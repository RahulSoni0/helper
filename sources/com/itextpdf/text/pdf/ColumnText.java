package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColumnText {
    public static final int AR_COMPOSEDTASHKEEL = 4;
    public static final int AR_LIG = 8;
    public static final int AR_NOVOWEL = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final float GLOBAL_SPACE_CHAR_RATIO = 0.0f;
    protected static final int LINE_STATUS_NOLINE = 2;
    protected static final int LINE_STATUS_OFFLIMITS = 1;
    protected static final int LINE_STATUS_OK = 0;
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    public static final int START_COLUMN = 0;
    private final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ColumnText.class);
    private boolean adjustFirstLine = true;
    protected int alignment = 0;
    private int arabicOptions = 0;
    protected BidiLine bidiLine;
    protected PdfContentByte canvas;
    protected PdfContentByte[] canvases;
    protected boolean composite = false;
    protected ColumnText compositeColumn;
    protected LinkedList<Element> compositeElements;
    protected float currentLeading = 16.0f;
    protected float descender;
    protected float extraParagraphSpace = 0.0f;
    private float filledWidth;
    private float firstLineY;
    private boolean firstLineYDone = false;
    protected float fixedLeading = 16.0f;
    protected float followingIndent = 0.0f;
    private boolean ignoreSpacingBefore = true;
    protected float indent = 0.0f;
    private boolean inheritGraphicState = false;
    protected boolean isWordSplit;
    private boolean lastWasNewline = true;
    protected float lastX;
    protected ArrayList<float[]> leftWall;
    protected float leftX;
    protected int lineStatus;
    private int linesWritten;
    protected int listIdx = 0;
    protected float maxY;
    protected float minY;
    protected float multipliedLeading = 0.0f;
    protected boolean rectangularMode = false;
    protected float rectangularWidth = -1.0f;
    private boolean repeatFirstLineIndent = true;
    protected float rightIndent = 0.0f;
    protected ArrayList<float[]> rightWall;
    protected float rightX;
    protected int rowIdx = 0;
    protected int runDirection = 1;
    private float spaceCharRatio = 0.0f;
    private int splittedRow = -2;
    private boolean useAscender = false;
    protected Phrase waitPhrase;
    protected float yLine;

    public static boolean hasMoreText(int i) {
        return (i & 1) == 0;
    }

    public ColumnText(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
    }

    public static ColumnText duplicate(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText((PdfContentByte) null);
        columnText2.setACopy(columnText);
        return columnText2;
    }

    public ColumnText setACopy(ColumnText columnText) {
        if (columnText != null) {
            setSimpleVars(columnText);
            if (columnText.bidiLine != null) {
                this.bidiLine = new BidiLine(columnText.bidiLine);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void setSimpleVars(ColumnText columnText) {
        this.maxY = columnText.maxY;
        this.minY = columnText.minY;
        this.alignment = columnText.alignment;
        this.leftWall = null;
        if (columnText.leftWall != null) {
            this.leftWall = new ArrayList<>(columnText.leftWall);
        }
        this.rightWall = null;
        if (columnText.rightWall != null) {
            this.rightWall = new ArrayList<>(columnText.rightWall);
        }
        this.yLine = columnText.yLine;
        this.currentLeading = columnText.currentLeading;
        this.fixedLeading = columnText.fixedLeading;
        this.multipliedLeading = columnText.multipliedLeading;
        this.canvas = columnText.canvas;
        this.canvases = columnText.canvases;
        this.lineStatus = columnText.lineStatus;
        this.indent = columnText.indent;
        this.followingIndent = columnText.followingIndent;
        this.rightIndent = columnText.rightIndent;
        this.extraParagraphSpace = columnText.extraParagraphSpace;
        this.rectangularWidth = columnText.rectangularWidth;
        this.rectangularMode = columnText.rectangularMode;
        this.spaceCharRatio = columnText.spaceCharRatio;
        this.lastWasNewline = columnText.lastWasNewline;
        this.repeatFirstLineIndent = columnText.repeatFirstLineIndent;
        this.linesWritten = columnText.linesWritten;
        this.arabicOptions = columnText.arabicOptions;
        this.runDirection = columnText.runDirection;
        this.descender = columnText.descender;
        this.composite = columnText.composite;
        this.splittedRow = columnText.splittedRow;
        if (columnText.composite) {
            this.compositeElements = new LinkedList<>();
            Iterator it = columnText.compositeElements.iterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                if (element instanceof PdfPTable) {
                    this.compositeElements.add(new PdfPTable((PdfPTable) element));
                } else {
                    this.compositeElements.add(element);
                }
            }
            ColumnText columnText2 = columnText.compositeColumn;
            if (columnText2 != null) {
                this.compositeColumn = duplicate(columnText2);
            }
        }
        this.listIdx = columnText.listIdx;
        this.rowIdx = columnText.rowIdx;
        this.firstLineY = columnText.firstLineY;
        this.leftX = columnText.leftX;
        this.rightX = columnText.rightX;
        this.firstLineYDone = columnText.firstLineYDone;
        this.waitPhrase = columnText.waitPhrase;
        this.useAscender = columnText.useAscender;
        this.filledWidth = columnText.filledWidth;
        this.adjustFirstLine = columnText.adjustFirstLine;
        this.inheritGraphicState = columnText.inheritGraphicState;
        this.ignoreSpacingBefore = columnText.ignoreSpacingBefore;
    }

    private void addWaitingPhrase() {
        if (this.bidiLine == null && this.waitPhrase != null) {
            this.bidiLine = new BidiLine();
            for (Chunk pdfChunk : this.waitPhrase.getChunks()) {
                this.bidiLine.addChunk(new PdfChunk(pdfChunk, (PdfAction) null, this.waitPhrase.getTabSettings()));
            }
            this.waitPhrase = null;
        }
    }

    public void addText(Phrase phrase) {
        if (phrase != null && !this.composite) {
            addWaitingPhrase();
            if (this.bidiLine == null) {
                this.waitPhrase = phrase;
                return;
            }
            for (Chunk pdfChunk : phrase.getChunks()) {
                this.bidiLine.addChunk(new PdfChunk(pdfChunk, (PdfAction) null, phrase.getTabSettings()));
            }
        }
    }

    public void setText(Phrase phrase) {
        this.bidiLine = null;
        this.composite = false;
        this.compositeColumn = null;
        this.compositeElements = null;
        this.listIdx = 0;
        this.rowIdx = 0;
        this.splittedRow = -1;
        this.waitPhrase = phrase;
    }

    public void addText(Chunk chunk) {
        if (chunk != null && !this.composite) {
            addText(new Phrase(chunk));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElement(com.itextpdf.text.Paragraph r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r7 instanceof com.itextpdf.text.Image
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0071
            com.itextpdf.text.Image r7 = (com.itextpdf.text.Image) r7
            com.itextpdf.text.pdf.PdfPTable r0 = new com.itextpdf.text.pdf.PdfPTable
            r0.<init>((int) r2)
            float r3 = r7.getWidthPercentage()
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
            float r3 = r7.getScaledWidth()
            r0.setTotalWidth((float) r3)
            r0.setLockedWidth(r2)
            goto L_0x0027
        L_0x0024:
            r0.setWidthPercentage(r3)
        L_0x0027:
            float r3 = r7.getSpacingAfter()
            r0.setSpacingAfter(r3)
            float r3 = r7.getSpacingBefore()
            r0.setSpacingBefore(r3)
            int r3 = r7.getAlignment()
            if (r3 == 0) goto L_0x0046
            r5 = 2
            if (r3 == r5) goto L_0x0042
            r0.setHorizontalAlignment(r2)
            goto L_0x0049
        L_0x0042:
            r0.setHorizontalAlignment(r5)
            goto L_0x0049
        L_0x0046:
            r0.setHorizontalAlignment(r1)
        L_0x0049:
            com.itextpdf.text.pdf.PdfPCell r3 = new com.itextpdf.text.pdf.PdfPCell
            r3.<init>((com.itextpdf.text.Image) r7, (boolean) r2)
            r3.setPadding(r4)
            int r4 = r7.getBorder()
            r3.setBorder(r4)
            com.itextpdf.text.BaseColor r4 = r7.getBorderColor()
            r3.setBorderColor(r4)
            float r4 = r7.getBorderWidth()
            r3.setBorderWidth(r4)
            com.itextpdf.text.BaseColor r7 = r7.getBackgroundColor()
            r3.setBackgroundColor(r7)
            r0.addCell((com.itextpdf.text.pdf.PdfPCell) r3)
            r7 = r0
        L_0x0071:
            int r0 = r7.type()
            r3 = 10
            r4 = 23
            if (r0 != r3) goto L_0x0084
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Chunk r7 = (com.itextpdf.text.Chunk) r7
            r0.<init>((com.itextpdf.text.Chunk) r7)
        L_0x0082:
            r7 = r0
            goto L_0x00a0
        L_0x0084:
            int r0 = r7.type()
            r3 = 11
            if (r0 != r3) goto L_0x0094
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Phrase r7 = (com.itextpdf.text.Phrase) r7
            r0.<init>((com.itextpdf.text.Phrase) r7)
            goto L_0x0082
        L_0x0094:
            int r0 = r7.type()
            if (r0 != r4) goto L_0x00a0
            r0 = r7
            com.itextpdf.text.pdf.PdfPTable r0 = (com.itextpdf.text.pdf.PdfPTable) r0
            r0.init()
        L_0x00a0:
            int r0 = r7.type()
            r3 = 12
            if (r0 == r3) goto L_0x00d5
            int r0 = r7.type()
            r5 = 14
            if (r0 == r5) goto L_0x00d5
            int r0 = r7.type()
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 55
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 37
            if (r0 != r4) goto L_0x00c7
            goto L_0x00d5
        L_0x00c7:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "element.not.allowed"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage((java.lang.String) r1, (java.lang.Object[]) r0)
            r7.<init>(r0)
            throw r7
        L_0x00d5:
            boolean r0 = r6.composite
            if (r0 != 0) goto L_0x00e7
            r6.composite = r2
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r6.compositeElements = r0
            r0 = 0
            r6.bidiLine = r0
            r6.waitPhrase = r0
        L_0x00e7:
            int r0 = r7.type()
            if (r0 != r3) goto L_0x00f9
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.compositeElements
            java.util.List r7 = r7.breakUp()
            r0.addAll(r7)
            return
        L_0x00f9:
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.compositeElements
            r0.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.addElement(com.itextpdf.text.Element):void");
    }

    public static boolean isAllowedElement(Element element) {
        int type = element.type();
        if (type == 10 || type == 11 || type == 37 || type == 12 || type == 14 || type == 55 || type == 23 || (element instanceof Image)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ArrayList<float[]> convertColumn(float[] fArr) {
        if (fArr.length >= 4) {
            ArrayList<float[]> arrayList = new ArrayList<>();
            int i = 0;
            while (i < fArr.length - 2) {
                float f = fArr[i];
                float f2 = fArr[i + 1];
                int i2 = i + 2;
                float f3 = fArr[i2];
                float f4 = fArr[i + 3];
                if (f2 != f4) {
                    float f5 = (f - f3) / (f2 - f4);
                    float[] fArr2 = {Math.min(f2, f4), Math.max(f2, f4), f5, f - (f5 * f2)};
                    arrayList.add(fArr2);
                    this.maxY = Math.max(this.maxY, fArr2[1]);
                    this.minY = Math.min(this.minY, fArr2[0]);
                }
                i = i2;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public float findLimitsPoint(ArrayList<float[]> arrayList) {
        this.lineStatus = 0;
        float f = this.yLine;
        if (f < this.minY || f > this.maxY) {
            this.lineStatus = 1;
            return 0.0f;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            float f2 = this.yLine;
            if (f2 >= fArr[0] && f2 <= fArr[1]) {
                return (fArr[2] * f2) + fArr[3];
            }
        }
        this.lineStatus = 2;
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsOneLine() {
        float findLimitsPoint = findLimitsPoint(this.leftWall);
        int i = this.lineStatus;
        if (i == 1 || i == 2) {
            return null;
        }
        float findLimitsPoint2 = findLimitsPoint(this.rightWall);
        if (this.lineStatus == 2) {
            return null;
        }
        return new float[]{findLimitsPoint, findLimitsPoint2};
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsTwoLines() {
        boolean z = false;
        while (true) {
            if (z && this.currentLeading == 0.0f) {
                return null;
            }
            float[] findLimitsOneLine = findLimitsOneLine();
            int i = this.lineStatus;
            if (i == 1) {
                return null;
            }
            this.yLine -= this.currentLeading;
            if (i != 2) {
                float[] findLimitsOneLine2 = findLimitsOneLine();
                int i2 = this.lineStatus;
                if (i2 == 1) {
                    return null;
                }
                if (i2 == 2) {
                    this.yLine -= this.currentLeading;
                } else if (findLimitsOneLine[0] < findLimitsOneLine2[1] && findLimitsOneLine2[0] < findLimitsOneLine[1]) {
                    return new float[]{findLimitsOneLine[0], findLimitsOneLine[1], findLimitsOneLine2[0], findLimitsOneLine2[1]};
                }
            }
            z = true;
        }
    }

    public void setColumns(float[] fArr, float[] fArr2) {
        this.maxY = -1.0E21f;
        this.minY = 1.0E21f;
        setYLine(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.rightWall = convertColumn(fArr2);
        this.leftWall = convertColumn(fArr);
        this.rectangularWidth = -1.0f;
        this.rectangularMode = false;
    }

    public void setSimpleColumn(Phrase phrase, float f, float f2, float f3, float f4, float f5, int i) {
        addText(phrase);
        setSimpleColumn(f, f2, f3, f4, f5, i);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4, float f5, int i) {
        setLeading(f5);
        this.alignment = i;
        setSimpleColumn(f, f2, f3, f4);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        float max = Math.max(f, f3);
        this.rightX = max;
        this.yLine = this.maxY;
        float f5 = max - this.leftX;
        this.rectangularWidth = f5;
        if (f5 < 0.0f) {
            this.rectangularWidth = 0.0f;
        }
        this.rectangularMode = true;
    }

    public void setSimpleColumn(Rectangle rectangle) {
        setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop());
    }

    public void setLeading(float f) {
        this.fixedLeading = f;
        this.multipliedLeading = 0.0f;
    }

    public void setLeading(float f, float f2) {
        this.fixedLeading = f;
        this.multipliedLeading = f2;
    }

    public float getLeading() {
        return this.fixedLeading;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getYLine() {
        return this.yLine;
    }

    public int getRowsDrawn() {
        return this.rowIdx;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setIndent(float f) {
        setIndent(f, true);
    }

    public void setIndent(float f, boolean z) {
        this.indent = f;
        this.lastWasNewline = true;
        this.repeatFirstLineIndent = z;
    }

    public float getIndent() {
        return this.indent;
    }

    public void setFollowingIndent(float f) {
        this.followingIndent = f;
        this.lastWasNewline = true;
    }

    public float getFollowingIndent() {
        return this.followingIndent;
    }

    public void setRightIndent(float f) {
        this.rightIndent = f;
        this.lastWasNewline = true;
    }

    public float getRightIndent() {
        return this.rightIndent;
    }

    public float getCurrentLeading() {
        return this.currentLeading;
    }

    public boolean getInheritGraphicState() {
        return this.inheritGraphicState;
    }

    public void setInheritGraphicState(boolean z) {
        this.inheritGraphicState = z;
    }

    public boolean isIgnoreSpacingBefore() {
        return this.ignoreSpacingBefore;
    }

    public void setIgnoreSpacingBefore(boolean z) {
        this.ignoreSpacingBefore = z;
    }

    /* renamed from: go */
    public int mo32521go() throws DocumentException {
        return mo32522go(false);
    }

    /* renamed from: go */
    public int mo32522go(boolean z) throws DocumentException {
        return mo32523go(z, (IAccessibleElement) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a4, code lost:
        r0.bidiLine.restore();
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d7, code lost:
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d9, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0322  */
    /* renamed from: go */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo32523go(boolean r31, com.itextpdf.text.pdf.interfaces.IAccessibleElement r32) throws com.itextpdf.text.DocumentException {
        /*
            r30 = this;
            r0 = r30
            r1 = r32
            r2 = 0
            r0.isWordSplit = r2
            boolean r3 = r0.composite
            if (r3 == 0) goto L_0x0010
            int r1 = r30.goComposite(r31)
            return r1
        L_0x0010:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            boolean r3 = isTagged(r3)
            if (r3 == 0) goto L_0x0024
            boolean r3 = r1 instanceof com.itextpdf.text.ListItem
            if (r3 == 0) goto L_0x0024
            r3 = r1
            com.itextpdf.text.ListItem r3 = (com.itextpdf.text.ListItem) r3
            com.itextpdf.text.ListBody r3 = r3.getListBody()
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            r30.addWaitingPhrase()
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            r6 = 1
            if (r5 != 0) goto L_0x002e
            return r6
        L_0x002e:
            r5 = 0
            r0.descender = r5
            r0.linesWritten = r2
            r0.lastX = r5
            float r7 = r0.spaceCharRatio
            r8 = 2
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r5)
            r15[r6] = r9
            r9 = 2143289344(0x7fc00000, float:NaN)
            r0.firstLineY = r9
            int r14 = r0.runDirection
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            if (r9 == 0) goto L_0x0068
            com.itextpdf.text.pdf.PdfDocument r10 = r9.getPdfDocument()
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
            boolean r11 = isTagged(r11)
            if (r11 != 0) goto L_0x0060
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
            boolean r12 = r0.inheritGraphicState
            com.itextpdf.text.pdf.PdfContentByte r11 = r11.getDuplicate(r12)
            goto L_0x0062
        L_0x0060:
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
        L_0x0062:
            r25 = r9
            r26 = r10
            r13 = r11
            goto L_0x006f
        L_0x0068:
            if (r31 == 0) goto L_0x0338
            r13 = 0
            r25 = 0
            r26 = 0
        L_0x006f:
            r9 = 981668463(0x3a83126f, float:0.001)
            if (r31 != 0) goto L_0x0088
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0081
            com.itextpdf.text.pdf.PdfWriter r7 = r13.getPdfWriter()
            float r7 = r7.getSpaceCharRatio()
            goto L_0x0088
        L_0x0081:
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 >= 0) goto L_0x0088
            r7 = 981668463(0x3a83126f, float:0.001)
        L_0x0088:
            boolean r9 = r0.rectangularMode
            if (r9 != 0) goto L_0x00b3
            com.itextpdf.text.pdf.BidiLine r9 = r0.bidiLine
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r9 = r9.chunks
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x0095:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00aa
            java.lang.Object r11 = r9.next()
            com.itextpdf.text.pdf.PdfChunk r11 = (com.itextpdf.text.pdf.PdfChunk) r11
            float r11 = r11.height()
            float r10 = java.lang.Math.max(r10, r11)
            goto L_0x0095
        L_0x00aa:
            float r9 = r0.fixedLeading
            float r11 = r0.multipliedLeading
            float r10 = r10 * r11
            float r9 = r9 + r10
            r0.currentLeading = r9
        L_0x00b3:
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00b6:
            boolean r12 = r0.lastWasNewline
            if (r12 == 0) goto L_0x00bd
            float r12 = r0.indent
            goto L_0x00bf
        L_0x00bd:
            float r12 = r0.followingIndent
        L_0x00bf:
            boolean r5 = r0.rectangularMode
            r16 = 3
            if (r5 == 0) goto L_0x01ad
            float r5 = r0.rectangularWidth
            float r4 = r0.rightIndent
            float r4 = r4 + r12
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00dc
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d9
            r6 = 3
            goto L_0x024e
        L_0x00d9:
            r6 = 2
            goto L_0x024e
        L_0x00dc:
            com.itextpdf.text.pdf.BidiLine r4 = r0.bidiLine
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00e6
            goto L_0x024e
        L_0x00e6:
            com.itextpdf.text.pdf.BidiLine r4 = r0.bidiLine
            float r5 = r0.leftX
            float r8 = r0.rectangularWidth
            float r8 = r8 - r12
            float r6 = r0.rightIndent
            float r18 = r8 - r6
            int r6 = r0.alignment
            int r8 = r0.arabicOptions
            float r2 = r0.minY
            r27 = r10
            float r10 = r0.yLine
            r28 = r7
            float r7 = r0.descender
            r16 = r4
            r17 = r5
            r19 = r6
            r20 = r14
            r21 = r8
            r22 = r2
            r23 = r10
            r24 = r7
            com.itextpdf.text.pdf.PdfLine r2 = r16.processLine(r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r4 = r0.isWordSplit
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            boolean r5 = r5.isWordSplit()
            r4 = r4 | r5
            r0.isWordSplit = r4
            if (r2 != 0) goto L_0x0122
            goto L_0x01d7
        L_0x0122:
            float r4 = r0.fixedLeading
            float r5 = r0.multipliedLeading
            float[] r4 = r2.getMaxSize(r4, r5)
            boolean r5 = r30.isUseAscender()
            if (r5 == 0) goto L_0x013f
            float r5 = r0.firstLineY
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 == 0) goto L_0x013f
            float r4 = r2.getAscender()
            r0.currentLeading = r4
            goto L_0x014e
        L_0x013f:
            r5 = 0
            r6 = r4[r5]
            r5 = 1
            r4 = r4[r5]
            float r5 = r0.descender
            float r4 = r4 - r5
            float r4 = java.lang.Math.max(r6, r4)
            r0.currentLeading = r4
        L_0x014e:
            float r4 = r0.yLine
            float r5 = r0.maxY
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01a4
            float r5 = r0.currentLeading
            float r6 = r4 - r5
            float r7 = r0.minY
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0161
            goto L_0x01a4
        L_0x0161:
            float r4 = r4 - r5
            r0.yLine = r4
            if (r31 != 0) goto L_0x0184
            if (r9 != 0) goto L_0x0184
            boolean r4 = r2.isRTL
            if (r4 == 0) goto L_0x017d
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.canvas
            boolean r4 = r4.isTagged()
            if (r4 == 0) goto L_0x017d
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.canvas
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.REVERSEDCHARS
            r4.beginMarkedContentSequence((com.itextpdf.text.pdf.PdfName) r5)
            r10 = 1
            goto L_0x017f
        L_0x017d:
            r10 = r27
        L_0x017f:
            r13.beginText()
            r9 = 1
            goto L_0x0186
        L_0x0184:
            r10 = r27
        L_0x0186:
            float r4 = r0.firstLineY
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x0192
            float r4 = r0.yLine
            r0.firstLineY = r4
        L_0x0192:
            float r4 = r0.rectangularWidth
            float r5 = r2.widthLeft()
            float r4 = r4 - r5
            r0.updateFilledWidth(r4)
            float r4 = r0.leftX
            r5 = r9
            r6 = r10
            r29 = r12
            goto L_0x026e
        L_0x01a4:
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            r1.restore()
            r10 = r27
            goto L_0x00d9
        L_0x01ad:
            r28 = r7
            r27 = r10
            float r2 = r0.yLine
            float r4 = r0.currentLeading
            float r2 = r2 - r4
            float[] r4 = r30.findLimitsTwoLines()
            if (r4 != 0) goto L_0x01cd
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x01c6
            r6 = 3
            goto L_0x01c7
        L_0x01c6:
            r6 = 2
        L_0x01c7:
            r0.yLine = r2
            r10 = r27
            goto L_0x024e
        L_0x01cd:
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x01dc
            r0.yLine = r2
        L_0x01d7:
            r10 = r27
        L_0x01d9:
            r6 = 1
            goto L_0x024e
        L_0x01dc:
            r5 = 0
            r6 = r4[r5]
            r5 = 2
            r7 = r4[r5]
            float r6 = java.lang.Math.max(r6, r7)
            r7 = 1
            r8 = r4[r7]
            r4 = r4[r16]
            float r4 = java.lang.Math.min(r8, r4)
            float r4 = r4 - r6
            float r7 = r0.rightIndent
            float r8 = r12 + r7
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0202
            r10 = r27
        L_0x01fa:
            r7 = r28
            r2 = 0
            r5 = 0
            r6 = 1
            r8 = 2
            goto L_0x00b6
        L_0x0202:
            com.itextpdf.text.pdf.BidiLine r8 = r0.bidiLine
            float r4 = r4 - r12
            float r18 = r4 - r7
            int r4 = r0.alignment
            int r7 = r0.arabicOptions
            float r10 = r0.minY
            float r5 = r0.yLine
            r29 = r12
            float r12 = r0.descender
            r16 = r8
            r17 = r6
            r19 = r4
            r20 = r14
            r21 = r7
            r22 = r10
            r23 = r5
            r24 = r12
            com.itextpdf.text.pdf.PdfLine r4 = r16.processLine(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r31 != 0) goto L_0x0247
            if (r9 != 0) goto L_0x0247
            boolean r5 = r4.isRTL
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            boolean r5 = r5.isTagged()
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.REVERSEDCHARS
            r5.beginMarkedContentSequence((com.itextpdf.text.pdf.PdfName) r7)
            r10 = 1
            goto L_0x0242
        L_0x0240:
            r10 = r27
        L_0x0242:
            r13.beginText()
            r9 = 1
            goto L_0x0249
        L_0x0247:
            r10 = r27
        L_0x0249:
            if (r4 != 0) goto L_0x026a
            r0.yLine = r2
            goto L_0x01d9
        L_0x024e:
            if (r9 == 0) goto L_0x0269
            r13.endText()
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            if (r1 == r13) goto L_0x025a
            r1.add(r13)
        L_0x025a:
            if (r10 == 0) goto L_0x0269
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            boolean r1 = r1.isTagged()
            if (r1 == 0) goto L_0x0269
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            r1.endMarkedContentSequence()
        L_0x0269:
            return r6
        L_0x026a:
            r2 = r4
            r4 = r6
            r5 = r9
            r6 = r10
        L_0x026e:
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.canvas
            boolean r7 = isTagged(r7)
            if (r7 == 0) goto L_0x02ca
            boolean r7 = r1 instanceof com.itextpdf.text.ListItem
            if (r7 == 0) goto L_0x02ca
            float r7 = r0.firstLineY
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x02ca
            boolean r7 = r0.firstLineYDone
            if (r7 != 0) goto L_0x02ca
            if (r31 != 0) goto L_0x02c5
            r7 = r1
            com.itextpdf.text.ListItem r7 = (com.itextpdf.text.ListItem) r7
            com.itextpdf.text.ListLabel r8 = r7.getListLabel()
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.openMCBlock(r8)
            com.itextpdf.text.Chunk r9 = new com.itextpdf.text.Chunk
            com.itextpdf.text.Chunk r7 = r7.getListSymbol()
            r9.<init>((com.itextpdf.text.Chunk) r7)
            r7 = 0
            r9.setRole(r7)
            com.itextpdf.text.pdf.PdfContentByte r10 = r0.canvas
            r17 = 0
            com.itextpdf.text.Phrase r12 = new com.itextpdf.text.Phrase
            r12.<init>((com.itextpdf.text.Chunk) r9)
            float r9 = r0.leftX
            float r16 = r8.getIndentation()
            float r19 = r9 + r16
            float r9 = r0.firstLineY
            r21 = 0
            r16 = r10
            r18 = r12
            r20 = r9
            showTextAligned(r16, r17, r18, r19, r20, r21)
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.closeMCBlock(r8)
            goto L_0x02c6
        L_0x02c5:
            r7 = 0
        L_0x02c6:
            r8 = 1
            r0.firstLineYDone = r8
            goto L_0x02cb
        L_0x02ca:
            r7 = 0
        L_0x02cb:
            if (r31 != 0) goto L_0x0306
            if (r3 == 0) goto L_0x02d5
            com.itextpdf.text.pdf.PdfContentByte r8 = r0.canvas
            r8.openMCBlock(r3)
            r3 = r7
        L_0x02d5:
            r8 = 0
            r15[r8] = r11
            boolean r8 = r2.isRTL()
            if (r8 == 0) goto L_0x02e1
            float r12 = r0.rightIndent
            goto L_0x02e3
        L_0x02e1:
            r12 = r29
        L_0x02e3:
            float r4 = r4 + r12
            float r8 = r2.indentLeft()
            float r4 = r4 + r8
            float r8 = r0.yLine
            r13.setTextMatrix(r4, r8)
            r9 = r26
            r10 = r2
            r11 = r13
            r12 = r25
            r4 = r13
            r13 = r15
            r8 = r14
            r14 = r28
            float r9 = r9.writeLineToContent(r10, r11, r12, r13, r14)
            r0.lastX = r9
            r9 = 0
            r10 = r15[r9]
            com.itextpdf.text.pdf.PdfFont r10 = (com.itextpdf.text.pdf.PdfFont) r10
            r11 = r10
            goto L_0x0308
        L_0x0306:
            r4 = r13
            r8 = r14
        L_0x0308:
            boolean r9 = r0.repeatFirstLineIndent
            if (r9 == 0) goto L_0x0314
            boolean r9 = r2.isNewlineSplit()
            if (r9 == 0) goto L_0x0314
            r9 = 1
            goto L_0x0315
        L_0x0314:
            r9 = 0
        L_0x0315:
            r0.lastWasNewline = r9
            float r9 = r0.yLine
            boolean r10 = r2.isNewlineSplit()
            if (r10 == 0) goto L_0x0322
            float r10 = r0.extraParagraphSpace
            goto L_0x0323
        L_0x0322:
            r10 = 0
        L_0x0323:
            float r9 = r9 - r10
            r0.yLine = r9
            int r9 = r0.linesWritten
            r10 = 1
            int r9 = r9 + r10
            r0.linesWritten = r9
            float r2 = r2.getDescender()
            r0.descender = r2
            r13 = r4
            r9 = r5
            r10 = r6
            r14 = r8
            goto L_0x01fa
        L_0x0338:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null"
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage((java.lang.String) r3, (java.lang.Object[]) r2)
            r1.<init>(r2)
            goto L_0x0348
        L_0x0347:
            throw r1
        L_0x0348:
            goto L_0x0347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.mo32523go(boolean, com.itextpdf.text.pdf.interfaces.IAccessibleElement):int");
    }

    public boolean isWordSplit() {
        return this.isWordSplit;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void clearChunks() {
        BidiLine bidiLine2 = this.bidiLine;
        if (bidiLine2 != null) {
            bidiLine2.clearChunks();
        }
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        this.spaceCharRatio = f;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public int getLinesWritten() {
        return this.linesWritten;
    }

    public float getLastX() {
        return this.lastX;
    }

    public int getArabicOptions() {
        return this.arabicOptions;
    }

    public void setArabicOptions(int i) {
        this.arabicOptions = i;
    }

    public float getDescender() {
        return this.descender;
    }

    public static float getWidth(Phrase phrase, int i, int i2) {
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.addText(phrase);
        columnText.addWaitingPhrase();
        PdfLine processLine = columnText.bidiLine.processLine(0.0f, 20000.0f, 0, i, i2, 0.0f, 0.0f, 0.0f);
        if (processLine == null) {
            return 0.0f;
        }
        return 20000.0f - processLine.widthLeft();
    }

    public static float getWidth(Phrase phrase) {
        return getWidth(phrase, 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
        if (r3 == 2) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void showTextAligned(com.itextpdf.text.pdf.PdfContentByte r18, int r19, com.itextpdf.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x0011
            r2 = 1
            if (r0 == r2) goto L_0x0011
            if (r0 == r9) goto L_0x0011
            r15 = 0
            goto L_0x0012
        L_0x0011:
            r15 = r0
        L_0x0012:
            r18.saveState()
            com.itextpdf.text.pdf.ColumnText r14 = new com.itextpdf.text.pdf.ColumnText
            r13 = r18
            r14.<init>(r13)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 1073741824(0x40000000, float:2.0)
            r0 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r2 = 1184645120(0x469c4000, float:20000.0)
            r3 = 0
            if (r15 == 0) goto L_0x0035
            if (r15 == r9) goto L_0x002f
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            goto L_0x0036
        L_0x002f:
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r16 = 0
            goto L_0x0039
        L_0x0035:
            r12 = 0
        L_0x0036:
            r16 = 1184645120(0x469c4000, float:20000.0)
        L_0x0039:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0046
            float r12 = r12 + r21
            float r0 = r22 + r10
            float r16 = r16 + r21
            float r1 = r22 + r11
            goto L_0x0070
        L_0x0046:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.concatCTM((float) r1, (float) r2, (float) r3, (float) r4, (float) r5, (float) r6)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0070:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r0
            r0 = r14
            r14 = r16
            r3 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r10.setSimpleColumn(r11, r12, r13, r14, r15, r16, r17)
            r1 = 3
            if (r7 != r1) goto L_0x008c
            if (r3 != 0) goto L_0x0089
            r8 = 2
            goto L_0x008d
        L_0x0089:
            if (r3 != r9) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r8 = r3
        L_0x008d:
            r0.setAlignment(r8)
            r1 = r25
            r0.setArabicOptions(r1)
            r0.setRunDirection(r7)
            r0.mo32521go()     // Catch:{ DocumentException -> 0x009f }
            r18.restoreState()
            return
        L_0x009f:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.showTextAligned(com.itextpdf.text.pdf.PdfContentByte, int, com.itextpdf.text.Phrase, float, float, float, int, int):void");
    }

    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3) {
        showTextAligned(pdfContentByte, i, phrase, f, f2, f3, 1, 0);
    }

    public static float fitText(Font font, String str, Rectangle rectangle, float f, int i) {
        float f2;
        Font font2 = font;
        String str2 = str;
        int i2 = i;
        if (f <= 0.0f) {
            try {
                char[] charArray = str.toCharArray();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < charArray.length; i5++) {
                    if (charArray[i5] == 10) {
                        i4++;
                    } else if (charArray[i5] == 13) {
                        i3++;
                    }
                }
                f2 = (Math.abs(rectangle.getHeight()) / ((float) (Math.max(i3, i4) + 1))) - 0.001f;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            f2 = f;
        }
        font2.setSize(f2);
        Phrase phrase = new Phrase(str2, font2);
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.setSimpleColumn(phrase, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f2, 0);
        columnText.setRunDirection(i2);
        if ((columnText.mo32522go(true) & 1) != 0) {
            return f2;
        }
        float f3 = f2;
        float f4 = 0.0f;
        for (int i6 = 0; i6 < 50; i6++) {
            f2 = (f4 + f3) / 2.0f;
            ColumnText columnText2 = new ColumnText((PdfContentByte) null);
            font2.setSize(f2);
            columnText2.setSimpleColumn(new Phrase(str2, font2), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f2, 0);
            columnText2.setRunDirection(i2);
            if ((columnText2.mo32522go(true) & 1) == 0) {
                f3 = f2;
            } else if (f3 - f4 < f2 * 0.1f) {
                return f2;
            } else {
                f4 = f2;
            }
        }
        return f2;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r3v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v37 */
    /* JADX WARNING: type inference failed for: r3v75 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03b0, code lost:
        return 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x08fb  */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0904  */
    /* JADX WARNING: Removed duplicated region for block: B:499:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0207 A[LOOP:3: B:91:0x01fa->B:95:0x0207, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int goComposite(boolean r32) throws com.itextpdf.text.DocumentException {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            com.itextpdf.text.pdf.PdfContentByte r2 = r0.canvas
            if (r2 == 0) goto L_0x000a
            com.itextpdf.text.pdf.PdfDocument r2 = r2.pdf
        L_0x000a:
            boolean r2 = r0.rectangularMode
            r3 = 0
            if (r2 == 0) goto L_0x094e
            r0.linesWritten = r3
            r2 = 0
            r0.descender = r2
            int r4 = r0.runDirection
            r5 = 3
            r6 = 1
            if (r4 != r5) goto L_0x001c
            r4 = 1
            goto L_0x001d
        L_0x001c:
            r4 = 0
        L_0x001d:
            r7 = 1
        L_0x001e:
            java.util.LinkedList<com.itextpdf.text.Element> r8 = r0.compositeElements
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0027
            return r6
        L_0x0027:
            java.util.LinkedList<com.itextpdf.text.Element> r8 = r0.compositeElements
            java.lang.Object r8 = r8.getFirst()
            com.itextpdf.text.Element r8 = (com.itextpdf.text.Element) r8
            int r9 = r8.type()
            r10 = 12
            r11 = 0
            r12 = 2
            if (r9 != r10) goto L_0x01a2
            com.itextpdf.text.Paragraph r8 = (com.itextpdf.text.Paragraph) r8
            r9 = 0
            r10 = 0
        L_0x003d:
            if (r9 >= r12) goto L_0x015c
            float r10 = r0.yLine
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            if (r13 != 0) goto L_0x00b6
            com.itextpdf.text.pdf.ColumnText r13 = new com.itextpdf.text.pdf.ColumnText
            com.itextpdf.text.pdf.PdfContentByte r14 = r0.canvas
            r13.<init>(r14)
            r0.compositeColumn = r13
            int r14 = r8.getAlignment()
            r13.setAlignment(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r8.getIndentationLeft()
            float r15 = r8.getFirstLineIndent()
            float r14 = r14 + r15
            r13.setIndent(r14, r3)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r8.getExtraParagraphSpace()
            r13.setExtraParagraphSpace(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r8.getIndentationLeft()
            r13.setFollowingIndent(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r8.getIndentationRight()
            r13.setRightIndent(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r8.getLeading()
            float r15 = r8.getMultipliedLeading()
            r13.setLeading(r14, r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            int r14 = r0.runDirection
            r13.setRunDirection(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            int r14 = r0.arabicOptions
            r13.setArabicOptions(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r0.spaceCharRatio
            r13.setSpaceCharRatio(r14)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            r13.addText((com.itextpdf.text.Phrase) r8)
            if (r7 == 0) goto L_0x00ab
            boolean r13 = r0.adjustFirstLine
            if (r13 != 0) goto L_0x00b4
        L_0x00ab:
            float r13 = r0.yLine
            float r14 = r8.getSpacingBefore()
            float r13 = r13 - r14
            r0.yLine = r13
        L_0x00b4:
            r13 = 1
            goto L_0x00b7
        L_0x00b6:
            r13 = 0
        L_0x00b7:
            com.itextpdf.text.pdf.ColumnText r14 = r0.compositeColumn
            if (r7 != 0) goto L_0x00c1
            float r15 = r0.descender
            int r15 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x00c8
        L_0x00c1:
            boolean r15 = r0.adjustFirstLine
            if (r15 == 0) goto L_0x00c8
            boolean r15 = r0.useAscender
            goto L_0x00c9
        L_0x00c8:
            r15 = 0
        L_0x00c9:
            r14.setUseAscender(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.compositeColumn
            boolean r15 = r0.inheritGraphicState
            r14.setInheritGraphicState(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.compositeColumn
            float r15 = r0.leftX
            r14.leftX = r15
            float r15 = r0.rightX
            r14.rightX = r15
            float r15 = r0.yLine
            r14.yLine = r15
            float r15 = r0.rectangularWidth
            r14.rectangularWidth = r15
            boolean r15 = r0.rectangularMode
            r14.rectangularMode = r15
            float r15 = r0.minY
            r14.minY = r15
            float r15 = r0.maxY
            r14.maxY = r15
            boolean r14 = r8.getKeepTogether()
            if (r14 == 0) goto L_0x0101
            if (r13 == 0) goto L_0x0101
            if (r7 == 0) goto L_0x00ff
            boolean r13 = r0.adjustFirstLine
            if (r13 != 0) goto L_0x0101
        L_0x00ff:
            r13 = 1
            goto L_0x0102
        L_0x0101:
            r13 = 0
        L_0x0102:
            if (r1 != 0) goto L_0x010b
            if (r13 == 0) goto L_0x0109
            if (r9 != 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            r14 = 0
            goto L_0x010c
        L_0x010b:
            r14 = 1
        L_0x010c:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            boolean r15 = isTagged(r15)
            if (r15 == 0) goto L_0x011b
            if (r14 != 0) goto L_0x011b
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            r15.openMCBlock(r8)
        L_0x011b:
            com.itextpdf.text.pdf.ColumnText r15 = r0.compositeColumn
            int r15 = r15.mo32522go(r14)
            com.itextpdf.text.pdf.PdfContentByte r2 = r0.canvas
            boolean r2 = isTagged(r2)
            if (r2 == 0) goto L_0x0130
            if (r14 != 0) goto L_0x0130
            com.itextpdf.text.pdf.PdfContentByte r2 = r0.canvas
            r2.closeMCBlock(r8)
        L_0x0130:
            com.itextpdf.text.pdf.ColumnText r2 = r0.compositeColumn
            float r2 = r2.getLastX()
            r0.lastX = r2
            com.itextpdf.text.pdf.ColumnText r2 = r0.compositeColumn
            float r2 = r2.filledWidth
            r0.updateFilledWidth(r2)
            r2 = r15 & 1
            if (r2 != 0) goto L_0x014a
            if (r13 == 0) goto L_0x014a
            r0.compositeColumn = r11
            r0.yLine = r10
            return r12
        L_0x014a:
            if (r1 != 0) goto L_0x015b
            if (r13 != 0) goto L_0x014f
            goto L_0x015b
        L_0x014f:
            if (r9 != 0) goto L_0x0155
            r0.compositeColumn = r11
            r0.yLine = r10
        L_0x0155:
            int r9 = r9 + 1
            r10 = r15
            r2 = 0
            goto L_0x003d
        L_0x015b:
            r10 = r15
        L_0x015c:
            com.itextpdf.text.pdf.ColumnText r2 = r0.compositeColumn
            int r2 = r2.getLinesWritten()
            if (r2 <= 0) goto L_0x017e
            com.itextpdf.text.pdf.ColumnText r2 = r0.compositeColumn
            float r7 = r2.yLine
            r0.yLine = r7
            int r7 = r0.linesWritten
            int r9 = r2.linesWritten
            int r7 = r7 + r9
            r0.linesWritten = r7
            float r7 = r2.descender
            r0.descender = r7
            boolean r7 = r0.isWordSplit
            boolean r2 = r2.isWordSplit()
            r2 = r2 | r7
            r0.isWordSplit = r2
        L_0x017e:
            com.itextpdf.text.pdf.ColumnText r2 = r0.compositeColumn
            float r2 = r2.currentLeading
            r0.currentLeading = r2
            r2 = r10 & 1
            if (r2 == 0) goto L_0x0198
            r0.compositeColumn = r11
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
            float r2 = r0.yLine
            float r7 = r8.getSpacingAfter()
            float r2 = r2 - r7
            r0.yLine = r2
        L_0x0198:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x019d
            return r12
        L_0x019d:
            r3 = 3
        L_0x019e:
            r5 = 0
            r7 = 0
            goto L_0x0949
        L_0x01a2:
            int r2 = r8.type()
            r9 = 14
            if (r2 != r9) goto L_0x0453
            com.itextpdf.text.List r8 = (com.itextpdf.text.List) r8
            java.util.ArrayList r2 = r8.getItems()
            float r9 = r8.getIndentationLeft()
            java.util.Stack r13 = new java.util.Stack
            r13.<init>()
            r14 = 0
            r15 = 0
        L_0x01bb:
            int r10 = r2.size()
            if (r14 >= r10) goto L_0x022e
            java.lang.Object r10 = r2.get(r14)
            boolean r11 = r10 instanceof com.itextpdf.text.ListItem
            if (r11 == 0) goto L_0x01d4
            int r11 = r0.listIdx
            if (r15 != r11) goto L_0x01d1
            r2 = r10
            com.itextpdf.text.ListItem r2 = (com.itextpdf.text.ListItem) r2
            goto L_0x022f
        L_0x01d1:
            int r15 = r15 + 1
            goto L_0x01fa
        L_0x01d4:
            boolean r11 = r10 instanceof com.itextpdf.text.List
            if (r11 == 0) goto L_0x01fa
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r3] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r2[r6] = r8
            java.lang.Float r8 = new java.lang.Float
            r8.<init>(r9)
            r2[r12] = r8
            r13.push(r2)
            com.itextpdf.text.List r10 = (com.itextpdf.text.List) r10
            java.util.ArrayList r2 = r10.getItems()
            float r8 = r10.getIndentationLeft()
            float r9 = r9 + r8
            r8 = r10
            r14 = -1
            goto L_0x022b
        L_0x01fa:
            int r10 = r2.size()
            int r10 = r10 - r6
            if (r14 != r10) goto L_0x022b
            boolean r10 = r13.isEmpty()
            if (r10 != 0) goto L_0x022b
            java.lang.Object r2 = r13.pop()
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r8 = r2[r3]
            com.itextpdf.text.List r8 = (com.itextpdf.text.List) r8
            java.util.ArrayList r9 = r8.getItems()
            r10 = r2[r6]
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r14 = r10.intValue()
            r2 = r2[r12]
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r30 = r9
            r9 = r2
            r2 = r30
            goto L_0x01fa
        L_0x022b:
            int r14 = r14 + r6
            r11 = 0
            goto L_0x01bb
        L_0x022e:
            r2 = 0
        L_0x022f:
            r10 = 0
            r11 = 0
            r13 = 0
        L_0x0232:
            if (r10 >= r12) goto L_0x038f
            float r14 = r0.yLine
            com.itextpdf.text.pdf.ColumnText r15 = r0.compositeColumn
            if (r15 != 0) goto L_0x02dc
            if (r2 != 0) goto L_0x0245
            r0.listIdx = r3
            java.util.LinkedList<com.itextpdf.text.Element> r10 = r0.compositeElements
            r10.removeFirst()
            goto L_0x038f
        L_0x0245:
            com.itextpdf.text.pdf.ColumnText r13 = new com.itextpdf.text.pdf.ColumnText
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            r13.<init>(r15)
            r0.compositeColumn = r13
            if (r7 != 0) goto L_0x0258
            float r15 = r0.descender
            r16 = 0
            int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r15 != 0) goto L_0x025f
        L_0x0258:
            boolean r15 = r0.adjustFirstLine
            if (r15 == 0) goto L_0x025f
            boolean r15 = r0.useAscender
            goto L_0x0260
        L_0x025f:
            r15 = 0
        L_0x0260:
            r13.setUseAscender(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            boolean r15 = r0.inheritGraphicState
            r13.setInheritGraphicState(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            int r15 = r2.getAlignment()
            r13.setAlignment(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r2.getIndentationLeft()
            float r15 = r15 + r9
            float r17 = r2.getFirstLineIndent()
            float r15 = r15 + r17
            r13.setIndent(r15, r3)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r2.getExtraParagraphSpace()
            r13.setExtraParagraphSpace(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r13.getIndent()
            r13.setFollowingIndent(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r2.getIndentationRight()
            float r17 = r8.getIndentationRight()
            float r15 = r15 + r17
            r13.setRightIndent(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r2.getLeading()
            float r3 = r2.getMultipliedLeading()
            r13.setLeading(r15, r3)
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            int r13 = r0.runDirection
            r3.setRunDirection(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            int r13 = r0.arabicOptions
            r3.setArabicOptions(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            float r13 = r0.spaceCharRatio
            r3.setSpaceCharRatio(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            r3.addText((com.itextpdf.text.Phrase) r2)
            if (r7 == 0) goto L_0x02d1
            boolean r3 = r0.adjustFirstLine
            if (r3 != 0) goto L_0x02da
        L_0x02d1:
            float r3 = r0.yLine
            float r13 = r2.getSpacingBefore()
            float r3 = r3 - r13
            r0.yLine = r3
        L_0x02da:
            r3 = 1
            goto L_0x02dd
        L_0x02dc:
            r3 = 0
        L_0x02dd:
            com.itextpdf.text.pdf.ColumnText r13 = r0.compositeColumn
            float r15 = r0.leftX
            r13.leftX = r15
            float r15 = r0.rightX
            r13.rightX = r15
            float r15 = r0.yLine
            r13.yLine = r15
            float r15 = r0.rectangularWidth
            r13.rectangularWidth = r15
            boolean r15 = r0.rectangularMode
            r13.rectangularMode = r15
            float r15 = r0.minY
            r13.minY = r15
            float r15 = r0.maxY
            r13.maxY = r15
            boolean r13 = r2.getKeepTogether()
            if (r13 == 0) goto L_0x030b
            if (r3 == 0) goto L_0x030b
            if (r7 == 0) goto L_0x0309
            boolean r3 = r0.adjustFirstLine
            if (r3 != 0) goto L_0x030b
        L_0x0309:
            r3 = 1
            goto L_0x030c
        L_0x030b:
            r3 = 0
        L_0x030c:
            if (r1 != 0) goto L_0x0315
            if (r3 == 0) goto L_0x0313
            if (r10 != 0) goto L_0x0313
            goto L_0x0315
        L_0x0313:
            r13 = 0
            goto L_0x0316
        L_0x0315:
            r13 = 1
        L_0x0316:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            boolean r15 = isTagged(r15)
            if (r15 == 0) goto L_0x033f
            if (r13 != 0) goto L_0x033f
            com.itextpdf.text.ListLabel r15 = r2.getListLabel()
            r15.setIndentation(r9)
            com.itextpdf.text.ListItem r15 = r8.getFirstItem()
            if (r15 == r2) goto L_0x0335
            com.itextpdf.text.pdf.ColumnText r15 = r0.compositeColumn
            if (r15 == 0) goto L_0x033a
            com.itextpdf.text.pdf.BidiLine r15 = r15.bidiLine
            if (r15 == 0) goto L_0x033a
        L_0x0335:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            r15.openMCBlock(r8)
        L_0x033a:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.canvas
            r15.openMCBlock(r2)
        L_0x033f:
            com.itextpdf.text.pdf.ColumnText r15 = r0.compositeColumn
            int r15 = r15.mo32523go(r13, r2)
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            boolean r5 = isTagged(r5)
            if (r5 == 0) goto L_0x035d
            if (r13 != 0) goto L_0x035d
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            com.itextpdf.text.ListBody r13 = r2.getListBody()
            r5.closeMCBlock(r13)
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            r5.closeMCBlock(r2)
        L_0x035d:
            com.itextpdf.text.pdf.ColumnText r5 = r0.compositeColumn
            float r5 = r5.getLastX()
            r0.lastX = r5
            com.itextpdf.text.pdf.ColumnText r5 = r0.compositeColumn
            float r5 = r5.filledWidth
            r0.updateFilledWidth(r5)
            r5 = r15 & 1
            if (r5 != 0) goto L_0x0379
            if (r3 == 0) goto L_0x0379
            r5 = 0
            r0.compositeColumn = r5
            r0.yLine = r14
            r11 = 1
            goto L_0x037a
        L_0x0379:
            r5 = 0
        L_0x037a:
            if (r1 != 0) goto L_0x038e
            if (r3 == 0) goto L_0x038e
            if (r11 == 0) goto L_0x0381
            goto L_0x038e
        L_0x0381:
            if (r10 != 0) goto L_0x0387
            r0.compositeColumn = r5
            r0.yLine = r14
        L_0x0387:
            int r10 = r10 + 1
            r13 = r15
            r3 = 0
            r5 = 3
            goto L_0x0232
        L_0x038e:
            r13 = r15
        L_0x038f:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            boolean r3 = isTagged(r3)
            if (r3 == 0) goto L_0x03ae
            if (r1 != 0) goto L_0x03ae
            if (r2 == 0) goto L_0x03a9
            com.itextpdf.text.ListItem r3 = r8.getLastItem()
            if (r3 != r2) goto L_0x03a5
            r3 = r13 & 1
            if (r3 != 0) goto L_0x03a9
        L_0x03a5:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x03ae
        L_0x03a9:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            r3.closeMCBlock(r8)
        L_0x03ae:
            if (r11 == 0) goto L_0x03b1
            return r12
        L_0x03b1:
            if (r2 != 0) goto L_0x03b5
            goto L_0x0949
        L_0x03b5:
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            float r5 = r3.yLine
            r0.yLine = r5
            int r5 = r0.linesWritten
            int r7 = r3.linesWritten
            int r5 = r5 + r7
            r0.linesWritten = r5
            float r5 = r3.descender
            r0.descender = r5
            float r3 = r3.currentLeading
            r0.currentLeading = r3
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            boolean r3 = isTagged(r3)
            if (r3 != 0) goto L_0x0439
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            float r3 = r3.firstLineY
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x0439
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            boolean r3 = r3.firstLineYDone
            if (r3 != 0) goto L_0x0439
            if (r1 != 0) goto L_0x0435
            if (r4 == 0) goto L_0x0415
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            r19 = 2
            com.itextpdf.text.Phrase r5 = new com.itextpdf.text.Phrase
            com.itextpdf.text.Chunk r7 = r2.getListSymbol()
            r5.<init>((com.itextpdf.text.Chunk) r7)
            com.itextpdf.text.pdf.ColumnText r7 = r0.compositeColumn
            float r7 = r7.lastX
            float r8 = r2.getIndentationLeft()
            float r21 = r7 + r8
            com.itextpdf.text.pdf.ColumnText r7 = r0.compositeColumn
            float r7 = r7.firstLineY
            r23 = 0
            int r8 = r0.runDirection
            int r9 = r0.arabicOptions
            r18 = r3
            r20 = r5
            r22 = r7
            r24 = r8
            r25 = r9
            showTextAligned(r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x0435
        L_0x0415:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            r25 = 0
            com.itextpdf.text.Phrase r5 = new com.itextpdf.text.Phrase
            com.itextpdf.text.Chunk r7 = r2.getListSymbol()
            r5.<init>((com.itextpdf.text.Chunk) r7)
            com.itextpdf.text.pdf.ColumnText r7 = r0.compositeColumn
            float r8 = r7.leftX
            float r27 = r8 + r9
            float r7 = r7.firstLineY
            r29 = 0
            r24 = r3
            r26 = r5
            r28 = r7
            showTextAligned(r24, r25, r26, r27, r28, r29)
        L_0x0435:
            com.itextpdf.text.pdf.ColumnText r3 = r0.compositeColumn
            r3.firstLineYDone = r6
        L_0x0439:
            r3 = r13 & 1
            if (r3 == 0) goto L_0x044e
            r3 = 0
            r0.compositeColumn = r3
            int r3 = r0.listIdx
            int r3 = r3 + r6
            r0.listIdx = r3
            float r3 = r0.yLine
            float r2 = r2.getSpacingAfter()
            float r3 = r3 - r2
            r0.yLine = r3
        L_0x044e:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x019d
            return r12
        L_0x0453:
            int r2 = r8.type()
            r3 = 23
            if (r2 != r3) goto L_0x08b7
            com.itextpdf.text.pdf.PdfPTable r8 = (com.itextpdf.text.pdf.PdfPTable) r8
            int r2 = r0.runDirection
            int r3 = r8.getRunDirection()
            r0.runDirection = r3
            r4 = 3
            if (r3 != r4) goto L_0x046a
            r4 = 1
            goto L_0x046b
        L_0x046a:
            r4 = 0
        L_0x046b:
            int r3 = r8.size()
            int r5 = r8.getHeaderRows()
            if (r3 > r5) goto L_0x047e
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
            r18 = r7
            goto L_0x05f5
        L_0x047e:
            float r3 = r0.yLine
            float r5 = r0.descender
            float r3 = r3 + r5
            int r5 = r0.rowIdx
            if (r5 != 0) goto L_0x0490
            boolean r5 = r0.adjustFirstLine
            if (r5 == 0) goto L_0x0490
            float r5 = r8.spacingBefore()
            float r3 = r3 - r5
        L_0x0490:
            r24 = r3
            float r3 = r0.minY
            int r3 = (r24 > r3 ? 1 : (r24 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x08b5
            float r3 = r0.maxY
            int r3 = (r24 > r3 ? 1 : (r24 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x04a0
            goto L_0x08b5
        L_0x04a0:
            float r3 = r0.leftX
            r5 = 0
            r0.currentLeading = r5
            boolean r5 = r8.isLockedWidth()
            if (r5 == 0) goto L_0x04b3
            float r5 = r8.getTotalWidth()
            r0.updateFilledWidth(r5)
            goto L_0x04c1
        L_0x04b3:
            float r5 = r0.rectangularWidth
            float r9 = r8.getWidthPercentage()
            float r5 = r5 * r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 / r9
            r8.setTotalWidth((float) r5)
        L_0x04c1:
            r8.normalizeHeadersFooters()
            int r9 = r8.getHeaderRows()
            int r10 = r8.getFooterRows()
            int r11 = r9 - r10
            float r13 = r8.getFooterHeight()
            float r14 = r8.getHeaderHeight()
            float r14 = r14 - r13
            boolean r15 = r8.isSkipFirstHeader()
            if (r15 == 0) goto L_0x04ed
            int r15 = r0.rowIdx
            if (r15 > r11) goto L_0x04ed
            boolean r15 = r8.isComplete()
            if (r15 != 0) goto L_0x04eb
            int r15 = r0.rowIdx
            if (r15 == r11) goto L_0x04ed
        L_0x04eb:
            r15 = 1
            goto L_0x04ee
        L_0x04ed:
            r15 = 0
        L_0x04ee:
            if (r15 != 0) goto L_0x04f3
            float r14 = r24 - r14
            goto L_0x04f5
        L_0x04f3:
            r14 = r24
        L_0x04f5:
            int r12 = r0.rowIdx
            if (r12 >= r9) goto L_0x04fb
            r0.rowIdx = r9
        L_0x04fb:
            boolean r12 = r8.isSkipLastFooter()
            if (r12 == 0) goto L_0x050c
            float r12 = r0.minY
            float r12 = r14 - r12
            int r6 = r0.rowIdx
            com.itextpdf.text.pdf.PdfPTable$FittingRows r6 = r8.getFittingRows(r12, r6)
            goto L_0x050d
        L_0x050c:
            r6 = 0
        L_0x050d:
            boolean r12 = r8.isSkipLastFooter()
            if (r12 == 0) goto L_0x0525
            int r12 = r6.lastRow
            int r18 = r8.size()
            r20 = r6
            r19 = 1
            int r6 = r18 + -1
            if (r12 >= r6) goto L_0x0522
            goto L_0x0525
        L_0x0522:
            r6 = r20
            goto L_0x0530
        L_0x0525:
            float r14 = r14 - r13
            float r6 = r0.minY
            float r6 = r14 - r6
            int r12 = r0.rowIdx
            com.itextpdf.text.pdf.PdfPTable$FittingRows r6 = r8.getFittingRows(r6, r12)
        L_0x0530:
            float r12 = r0.minY
            int r12 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r12 < 0) goto L_0x08b3
            float r12 = r0.maxY
            int r12 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x053e
            goto L_0x08b3
        L_0x053e:
            int r12 = r6.lastRow
            r18 = 1
            int r12 = r12 + 1
            r18 = r7
            float r7 = r6.height
            float r14 = r14 - r7
            com.itextpdf.text.log.Logger r7 = r0.LOGGER
            r19 = r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r29 = r2
            java.lang.String r2 = "Want to split at row "
            r14.append(r2)
            r14.append(r12)
            java.lang.String r2 = r14.toString()
            r7.info(r2)
            r2 = r12
        L_0x0564:
            int r7 = r0.rowIdx
            if (r2 <= r7) goto L_0x057b
            int r7 = r8.size()
            if (r2 >= r7) goto L_0x057b
            com.itextpdf.text.pdf.PdfPRow r7 = r8.getRow(r2)
            boolean r7 = r7.isMayNotBreak()
            if (r7 == 0) goto L_0x057b
            int r2 = r2 + -1
            goto L_0x0564
        L_0x057b:
            int r7 = r8.size()
            r14 = 1
            int r7 = r7 - r14
            if (r2 >= r7) goto L_0x058f
            com.itextpdf.text.pdf.PdfPRow r7 = r8.getRow(r2)
            boolean r7 = r7.isMayNotBreak()
            if (r7 != 0) goto L_0x058f
            int r2 = r2 + 1
        L_0x058f:
            int r7 = r0.rowIdx
            if (r2 <= r7) goto L_0x0595
            if (r2 < r12) goto L_0x05a7
        L_0x0595:
            if (r2 != r9) goto L_0x05af
            com.itextpdf.text.pdf.PdfPRow r7 = r8.getRow(r9)
            boolean r7 = r7.isMayNotBreak()
            if (r7 == 0) goto L_0x05af
            boolean r7 = r8.isLoopCheck()
            if (r7 == 0) goto L_0x05af
        L_0x05a7:
            float r14 = r0.minY
            r7 = 0
            r8.setLoopCheck(r7)
            r12 = r2
            goto L_0x05b1
        L_0x05af:
            r14 = r19
        L_0x05b1:
            com.itextpdf.text.log.Logger r2 = r0.LOGGER
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r19 = r9
            java.lang.String r9 = "Will split at row "
            r7.append(r9)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r2.info(r7)
            boolean r2 = r8.isSplitLate()
            if (r2 == 0) goto L_0x05d6
            if (r12 <= 0) goto L_0x05d6
            int r2 = r12 + -1
            r6.correctLastRowChosen(r8, r2)
        L_0x05d6:
            boolean r2 = r8.isComplete()
            if (r2 != 0) goto L_0x05dd
            float r14 = r14 + r13
        L_0x05dd:
            boolean r2 = r8.isSplitRows()
            if (r2 != 0) goto L_0x060f
            r2 = -1
            r0.splittedRow = r2
            int r2 = r0.rowIdx
            if (r12 != r2) goto L_0x069e
            int r2 = r8.size()
            if (r12 != r2) goto L_0x05fd
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
        L_0x05f5:
            r7 = r18
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 1
            goto L_0x001e
        L_0x05fd:
            boolean r1 = r8.isComplete()
            if (r1 != 0) goto L_0x0606
            r1 = 1
            if (r12 == r1) goto L_0x060d
        L_0x0606:
            java.util.ArrayList r1 = r8.getRows()
            r1.remove(r12)
        L_0x060d:
            r1 = 2
            return r1
        L_0x060f:
            boolean r2 = r8.isSplitLate()
            if (r2 == 0) goto L_0x062e
            int r2 = r0.rowIdx
            if (r2 < r12) goto L_0x062a
            int r2 = r0.splittedRow
            r7 = -2
            if (r2 != r7) goto L_0x062e
            int r2 = r8.getHeaderRows()
            if (r2 == 0) goto L_0x062a
            boolean r2 = r8.isSkipFirstHeader()
            if (r2 == 0) goto L_0x062e
        L_0x062a:
            r2 = -1
            r0.splittedRow = r2
            goto L_0x069e
        L_0x062e:
            int r2 = r8.size()
            if (r12 >= r2) goto L_0x069e
            float r2 = r6.completedRowsHeight
            float r6 = r6.height
            float r2 = r2 - r6
            float r14 = r14 - r2
            float r2 = r0.minY
            float r2 = r14 - r2
            com.itextpdf.text.pdf.PdfPRow r6 = r8.getRow(r12)
            com.itextpdf.text.pdf.PdfPRow r2 = r6.splitRow(r8, r12, r2)
            if (r2 != 0) goto L_0x0658
            com.itextpdf.text.log.Logger r2 = r0.LOGGER
            java.lang.String r6 = "Didn't split row!"
            r2.info(r6)
            r2 = -1
            r0.splittedRow = r2
            int r2 = r0.rowIdx
            if (r2 != r12) goto L_0x069e
            r2 = 2
            return r2
        L_0x0658:
            int r6 = r0.splittedRow
            if (r12 == r6) goto L_0x067d
            int r6 = r12 + 1
            r0.splittedRow = r6
            com.itextpdf.text.pdf.PdfPTable r6 = new com.itextpdf.text.pdf.PdfPTable
            r6.<init>((com.itextpdf.text.pdf.PdfPTable) r8)
            java.util.LinkedList<com.itextpdf.text.Element> r7 = r0.compositeElements
            r8 = 0
            r7.set(r8, r6)
            java.util.ArrayList r7 = r6.getRows()
            r9 = r19
        L_0x0671:
            int r8 = r0.rowIdx
            if (r9 >= r8) goto L_0x067c
            r8 = 0
            r7.set(r9, r8)
            int r9 = r9 + 1
            goto L_0x0671
        L_0x067c:
            r8 = r6
        L_0x067d:
            float r14 = r0.minY
            java.util.ArrayList r6 = r8.getRows()
            int r12 = r12 + 1
            r6.add(r12, r2)
            com.itextpdf.text.log.Logger r2 = r0.LOGGER
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Inserting row at position "
            r6.append(r7)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            r2.info(r6)
        L_0x069e:
            if (r1 != 0) goto L_0x0824
            int r2 = r8.getHorizontalAlignment()
            r6 = 1
            if (r2 == r6) goto L_0x06b8
            r6 = 2
            if (r2 == r6) goto L_0x06b0
            if (r4 == 0) goto L_0x06b5
            float r2 = r0.rectangularWidth
        L_0x06ae:
            float r2 = r2 - r5
            goto L_0x06be
        L_0x06b0:
            if (r4 != 0) goto L_0x06b5
            float r2 = r0.rectangularWidth
            goto L_0x06ae
        L_0x06b5:
            r23 = r3
            goto L_0x06c0
        L_0x06b8:
            float r2 = r0.rectangularWidth
            float r2 = r2 - r5
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r4
        L_0x06be:
            float r3 = r3 + r2
            goto L_0x06b5
        L_0x06c0:
            com.itextpdf.text.pdf.PdfPTable r2 = com.itextpdf.text.pdf.PdfPTable.shallowCopy(r8)
            java.util.ArrayList r3 = r2.getRows()
            if (r15 != 0) goto L_0x06e3
            if (r11 <= 0) goto L_0x06e3
            r4 = 0
            java.util.ArrayList r5 = r8.getRows(r4, r11)
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.canvas
            boolean r4 = isTagged(r4)
            if (r4 == 0) goto L_0x06df
            com.itextpdf.text.pdf.PdfPTableHeader r4 = r2.getHeader()
            r4.rows = r5
        L_0x06df:
            r3.addAll(r5)
            goto L_0x06e6
        L_0x06e3:
            r2.setHeaderRows(r10)
        L_0x06e6:
            int r4 = r0.rowIdx
            java.util.ArrayList r4 = r8.getRows(r4, r12)
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            boolean r5 = isTagged(r5)
            if (r5 == 0) goto L_0x06fa
            com.itextpdf.text.pdf.PdfPTableBody r5 = r2.getBody()
            r5.rows = r4
        L_0x06fa:
            r3.addAll(r4)
            boolean r4 = r8.isSkipLastFooter()
            r5 = 1
            r19 = r4 ^ 1
            int r4 = r8.size()
            if (r12 >= r4) goto L_0x0711
            r2.setComplete(r5)
            r4 = 1
            r19 = 1
            goto L_0x0712
        L_0x0711:
            r4 = 0
        L_0x0712:
            if (r10 <= 0) goto L_0x0734
            boolean r5 = r2.isComplete()
            if (r5 == 0) goto L_0x0734
            if (r19 == 0) goto L_0x0734
            int r5 = r11 + r10
            java.util.ArrayList r5 = r8.getRows(r11, r5)
            com.itextpdf.text.pdf.PdfContentByte r6 = r0.canvas
            boolean r6 = isTagged(r6)
            if (r6 == 0) goto L_0x0730
            com.itextpdf.text.pdf.PdfPTableFooter r6 = r2.getFooter()
            r6.rows = r5
        L_0x0730:
            r3.addAll(r5)
            goto L_0x0735
        L_0x0734:
            r10 = 0
        L_0x0735:
            int r5 = r3.size()
            if (r5 <= 0) goto L_0x0822
            int r5 = r3.size()
            r6 = 1
            int r5 = r5 - r6
            int r5 = r5 - r10
            java.lang.Object r3 = r3.get(r5)
            com.itextpdf.text.pdf.PdfPRow r3 = (com.itextpdf.text.pdf.PdfPRow) r3
            boolean r7 = r8.isExtendLastRow(r4)
            if (r7 == 0) goto L_0x075c
            float r7 = r3.getMaxHeights()
            float r9 = r0.minY
            float r14 = r14 - r9
            float r14 = r14 + r7
            r3.setMaxHeights(r14)
            float r14 = r0.minY
            goto L_0x075d
        L_0x075c:
            r7 = 0
        L_0x075d:
            if (r4 == 0) goto L_0x076c
            com.itextpdf.text.pdf.PdfPTableEvent r9 = r8.getTableEvent()
            boolean r10 = r9 instanceof com.itextpdf.text.pdf.PdfPTableEventSplit
            if (r10 == 0) goto L_0x076c
            com.itextpdf.text.pdf.PdfPTableEventSplit r9 = (com.itextpdf.text.pdf.PdfPTableEventSplit) r9
            r9.splitTable(r8)
        L_0x076c:
            com.itextpdf.text.pdf.PdfContentByte[] r9 = r0.canvases
            if (r9 == 0) goto L_0x07a6
            r10 = 3
            r9 = r9[r10]
            boolean r9 = isTagged(r9)
            if (r9 == 0) goto L_0x0780
            com.itextpdf.text.pdf.PdfContentByte[] r9 = r0.canvases
            r9 = r9[r10]
            r9.openMCBlock(r8)
        L_0x0780:
            r19 = 0
            r20 = -1
            r21 = 0
            r22 = -1
            com.itextpdf.text.pdf.PdfContentByte[] r9 = r0.canvases
            r26 = 0
            r18 = r2
            r25 = r9
            r18.writeSelectedRows((int) r19, (int) r20, (int) r21, (int) r22, (float) r23, (float) r24, (com.itextpdf.text.pdf.PdfContentByte[]) r25, (boolean) r26)
            com.itextpdf.text.pdf.PdfContentByte[] r9 = r0.canvases
            r10 = 3
            r9 = r9[r10]
            boolean r9 = isTagged(r9)
            if (r9 == 0) goto L_0x07d3
            com.itextpdf.text.pdf.PdfContentByte[] r9 = r0.canvases
            r9 = r9[r10]
            r9.closeMCBlock(r8)
            goto L_0x07d3
        L_0x07a6:
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            boolean r9 = isTagged(r9)
            if (r9 == 0) goto L_0x07b3
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.openMCBlock(r8)
        L_0x07b3:
            r19 = 0
            r20 = -1
            r21 = 0
            r22 = -1
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r26 = 0
            r18 = r2
            r25 = r9
            r18.writeSelectedRows((int) r19, (int) r20, (int) r21, (int) r22, (float) r23, (float) r24, (com.itextpdf.text.pdf.PdfContentByte) r25, (boolean) r26)
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            boolean r9 = isTagged(r9)
            if (r9 == 0) goto L_0x07d3
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.closeMCBlock(r8)
        L_0x07d3:
            boolean r9 = r8.isComplete()
            if (r9 != 0) goto L_0x07dc
            r8.addNumberOfRowsWritten(r12)
        L_0x07dc:
            int r9 = r0.splittedRow
            if (r9 != r12) goto L_0x07f4
            int r9 = r8.size()
            if (r12 >= r9) goto L_0x07f4
            java.util.ArrayList r9 = r8.getRows()
            java.lang.Object r9 = r9.get(r12)
            com.itextpdf.text.pdf.PdfPRow r9 = (com.itextpdf.text.pdf.PdfPRow) r9
            r9.copyRowContent(r2, r5)
            goto L_0x0805
        L_0x07f4:
            if (r12 <= 0) goto L_0x0805
            int r9 = r8.size()
            if (r12 >= r9) goto L_0x0805
            com.itextpdf.text.pdf.PdfPRow r9 = r8.getRow(r12)
            int r10 = r12 + -1
            r9.splitRowspans(r8, r10, r2, r5)
        L_0x0805:
            boolean r2 = r8.isExtendLastRow(r4)
            if (r2 == 0) goto L_0x080e
            r3.setMaxHeights(r7)
        L_0x080e:
            if (r4 == 0) goto L_0x0834
            com.itextpdf.text.pdf.PdfPTableEvent r2 = r8.getTableEvent()
            boolean r3 = r2 instanceof com.itextpdf.text.pdf.PdfPTableEventAfterSplit
            if (r3 == 0) goto L_0x0834
            com.itextpdf.text.pdf.PdfPRow r3 = r8.getRow(r12)
            com.itextpdf.text.pdf.PdfPTableEventAfterSplit r2 = (com.itextpdf.text.pdf.PdfPTableEventAfterSplit) r2
            r2.afterSplitTable(r8, r3, r12)
            goto L_0x0834
        L_0x0822:
            r6 = 1
            goto L_0x0834
        L_0x0824:
            r6 = 1
            boolean r2 = r8.isExtendLastRow()
            if (r2 == 0) goto L_0x0834
            float r2 = r0.minY
            r3 = -830472192(0xffffffffce800000, float:-1.07374182E9)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0834
            r14 = r2
        L_0x0834:
            r0.yLine = r14
            r2 = 0
            r0.descender = r2
            r0.currentLeading = r2
            if (r15 != 0) goto L_0x0848
            boolean r2 = r8.isComplete()
            if (r2 != 0) goto L_0x0848
            float r2 = r0.yLine
            float r2 = r2 + r13
            r0.yLine = r2
        L_0x0848:
            int r2 = r8.size()
            if (r12 >= r2) goto L_0x0861
            float r2 = r8.getRowHeight(r12)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0861
            boolean r2 = r8.hasRowspan(r12)
            if (r2 == 0) goto L_0x085e
            goto L_0x0861
        L_0x085e:
            int r12 = r12 + 1
            goto L_0x0848
        L_0x0861:
            int r2 = r8.size()
            if (r12 < r2) goto L_0x089b
            float r2 = r0.yLine
            float r3 = r8.spacingAfter()
            float r2 = r2 - r3
            float r3 = r0.minY
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0877
            r0.yLine = r3
            goto L_0x0880
        L_0x0877:
            float r2 = r0.yLine
            float r3 = r8.spacingAfter()
            float r2 = r2 - r3
            r0.yLine = r2
        L_0x0880:
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
            r2 = -1
            r0.splittedRow = r2
            r2 = 0
            r0.rowIdx = r2
            r2 = r29
            r0.runDirection = r2
            r3 = 3
            if (r2 != r3) goto L_0x0895
            r19 = 1
            goto L_0x0897
        L_0x0895:
            r19 = 0
        L_0x0897:
            r4 = r19
            goto L_0x019e
        L_0x089b:
            r2 = -1
            int r1 = r0.splittedRow
            if (r1 <= r2) goto L_0x08af
            java.util.ArrayList r1 = r8.getRows()
            int r2 = r0.rowIdx
        L_0x08a6:
            if (r2 >= r12) goto L_0x08af
            r5 = 0
            r1.set(r2, r5)
            int r2 = r2 + 1
            goto L_0x08a6
        L_0x08af:
            r0.rowIdx = r12
            r1 = 2
            return r1
        L_0x08b3:
            r1 = 2
            return r1
        L_0x08b5:
            r1 = 2
            return r1
        L_0x08b7:
            r18 = r7
            r3 = 3
            r5 = 0
            int r2 = r8.type()
            r7 = 55
            if (r2 != r7) goto L_0x08de
            if (r1 != 0) goto L_0x08d7
            r9 = r8
            com.itextpdf.text.pdf.draw.DrawInterface r9 = (com.itextpdf.text.pdf.draw.DrawInterface) r9
            com.itextpdf.text.pdf.PdfContentByte r10 = r0.canvas
            float r11 = r0.leftX
            float r12 = r0.minY
            float r13 = r0.rightX
            float r14 = r0.maxY
            float r15 = r0.yLine
            r9.draw(r10, r11, r12, r13, r14, r15)
        L_0x08d7:
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
            r5 = 0
            goto L_0x0947
        L_0x08de:
            int r2 = r8.type()
            r7 = 37
            if (r2 != r7) goto L_0x0941
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x08eb:
            r2.add(r8)
            java.util.LinkedList<com.itextpdf.text.Element> r8 = r0.compositeElements
            r8.removeFirst()
            java.util.LinkedList<com.itextpdf.text.Element> r8 = r0.compositeElements
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0904
            java.util.LinkedList<com.itextpdf.text.Element> r8 = r0.compositeElements
            java.lang.Object r8 = r8.getFirst()
            com.itextpdf.text.Element r8 = (com.itextpdf.text.Element) r8
            goto L_0x0905
        L_0x0904:
            r8 = r5
        L_0x0905:
            if (r8 == 0) goto L_0x090d
            int r9 = r8.type()
            if (r9 == r7) goto L_0x08eb
        L_0x090d:
            com.itextpdf.text.pdf.FloatLayout r5 = new com.itextpdf.text.pdf.FloatLayout
            boolean r7 = r0.useAscender
            r5.<init>(r2, r7)
            float r7 = r0.leftX
            float r8 = r0.minY
            float r9 = r0.rightX
            float r10 = r0.yLine
            r5.setSimpleColumn(r7, r8, r9, r10)
            com.itextpdf.text.pdf.ColumnText r7 = r5.compositeColumn
            boolean r8 = r31.isIgnoreSpacingBefore()
            r7.setIgnoreSpacingBefore(r8)
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.canvas
            int r7 = r5.layout(r7, r1)
            float r5 = r5.getYLine()
            r0.yLine = r5
            r5 = 0
            r0.descender = r5
            r8 = r7 & 1
            if (r8 != 0) goto L_0x0947
            java.util.LinkedList<com.itextpdf.text.Element> r1 = r0.compositeElements
            r1.addAll(r2)
            return r7
        L_0x0941:
            r5 = 0
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.compositeElements
            r2.removeFirst()
        L_0x0947:
            r7 = r18
        L_0x0949:
            r2 = 0
            r3 = 0
            r5 = 3
            goto L_0x001e
        L_0x094e:
            com.itextpdf.text.DocumentException r1 = new com.itextpdf.text.DocumentException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "irregular.columns.are.not.supported.in.composite.mode"
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage((java.lang.String) r3, (java.lang.Object[]) r2)
            r1.<init>((java.lang.String) r2)
            goto L_0x095e
        L_0x095d:
            throw r1
        L_0x095e:
            goto L_0x095d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.goComposite(boolean):int");
    }

    public PdfContentByte getCanvas() {
        return this.canvas;
    }

    public void setCanvas(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
        this.canvases = null;
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvas(pdfContentByte);
        }
    }

    public void setCanvases(PdfContentByte[] pdfContentByteArr) {
        this.canvases = pdfContentByteArr;
        this.canvas = pdfContentByteArr[3];
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvases(pdfContentByteArr);
        }
    }

    public PdfContentByte[] getCanvases() {
        return this.canvases;
    }

    public boolean zeroHeightElement() {
        return this.composite && !this.compositeElements.isEmpty() && this.compositeElements.getFirst().type() == 55;
    }

    public List<Element> getCompositeElements() {
        return this.compositeElements;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void updateFilledWidth(float f) {
        if (f > this.filledWidth) {
            this.filledWidth = f;
        }
    }

    public boolean isAdjustFirstLine() {
        return this.adjustFirstLine;
    }

    public void setAdjustFirstLine(boolean z) {
        this.adjustFirstLine = z;
    }

    private static boolean isTagged(PdfContentByte pdfContentByte) {
        return (pdfContentByte == null || pdfContentByte.pdf == null || pdfContentByte.writer == null || !pdfContentByte.writer.isTagged()) ? false : true;
    }
}
