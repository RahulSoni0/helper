package com.itextpdf.text.pdf.parser;

public class PathPaintingRenderInfo {
    public static final int EVEN_ODD_RULE = 2;
    public static final int FILL = 2;
    public static final int NONZERO_WINDING_RULE = 1;
    public static final int NO_OP = 0;
    public static final int STROKE = 1;

    /* renamed from: gs */
    private GraphicsState f1461gs;
    private int operation;
    private int rule;

    public PathPaintingRenderInfo(int i, int i2, GraphicsState graphicsState) {
        this.operation = i;
        this.rule = i2;
        this.f1461gs = graphicsState;
    }

    public PathPaintingRenderInfo(int i, GraphicsState graphicsState) {
        this(i, 1, graphicsState);
    }

    public int getOperation() {
        return this.operation;
    }

    public int getRule() {
        return this.rule;
    }

    public Matrix getCtm() {
        return this.f1461gs.ctm;
    }

    public float getLineWidth() {
        return this.f1461gs.getLineWidth();
    }

    public int getLineCapStyle() {
        return this.f1461gs.getLineCapStyle();
    }

    public int getLineJoinStyle() {
        return this.f1461gs.getLineJoinStyle();
    }

    public float getMiterLimit() {
        return this.f1461gs.getMiterLimit();
    }

    public LineDashPattern getLineDashPattern() {
        return this.f1461gs.getLineDashPattern();
    }
}
