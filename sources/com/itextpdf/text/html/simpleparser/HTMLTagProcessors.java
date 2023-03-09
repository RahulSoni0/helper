package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {

    /* renamed from: A */
    public static final HTMLTagProcessor f1211A = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.flushContent();
        }

        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.processLink();
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: BR */
    public static final HTMLTagProcessor f1212BR = new HTMLTagProcessor() {
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.newLine();
        }
    };
    public static final HTMLTagProcessor DIV = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor EM_STRONG_STRIKE_SUP_SUP = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            String mapTag = mapTag(str);
            map.put(mapTag, (Object) null);
            hTMLWorker.updateChain(mapTag, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(mapTag(str));
        }

        private String mapTag(String str) {
            if (HtmlTags.f1193EM.equalsIgnoreCase(str)) {
                return HtmlTags.f1201I;
            }
            if (HtmlTags.STRONG.equalsIgnoreCase(str)) {
                return HtmlTags.f1191B;
            }
            return HtmlTags.STRIKE.equalsIgnoreCase(str) ? HtmlTags.f1205S : str;
        }
    };

    /* renamed from: H */
    public static final HTMLTagProcessor f1213H = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.SIZE)) {
                map.put(HtmlTags.SIZE, Integer.toString(7 - Integer.parseInt(str.substring(1))));
            }
            hTMLWorker.updateChain(str, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: HR */
    public static final HTMLTagProcessor f1214HR = new HTMLTagProcessor() {
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(hTMLWorker.createLineSeparator(map));
        }
    };
    public static final HTMLTagProcessor IMG = new HTMLTagProcessor() {
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.processImage(hTMLWorker.createImage(map), map);
            hTMLWorker.updateChain(str);
        }
    };

    /* renamed from: LI */
    public static final HTMLTagProcessor f1215LI = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingLI(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createListItem());
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingLI(false);
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str);
            hTMLWorker.processListItem();
        }
    };
    public static final HTMLTagProcessor PRE = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.FACE)) {
                map.put(HtmlTags.FACE, "Courier");
            }
            hTMLWorker.updateChain(str, map);
            hTMLWorker.setInsidePRE(true);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
            hTMLWorker.setInsidePRE(false);
        }
    };
    public static final HTMLTagProcessor SPAN = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor TABLE = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(new TableWrapper(map));
            hTMLWorker.pushTableState();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.setPendingTR(false);
            hTMLWorker.setSkipText(true);
            map.remove(HtmlTags.ALIGN);
            map.put(HtmlTags.COLSPAN, "1");
            map.put(HtmlTags.ROWSPAN, "1");
            hTMLWorker.updateChain(str, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(HtmlTags.f1208TR);
            }
            hTMLWorker.updateChain(str);
            hTMLWorker.processTable();
            hTMLWorker.popTableState();
            hTMLWorker.setSkipText(false);
        }
    };

    /* renamed from: TD */
    public static final HTMLTagProcessor f1216TD = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingTD(true);
            hTMLWorker.updateChain(HtmlTags.f1206TD, map);
            hTMLWorker.pushToStack(hTMLWorker.createCell(str));
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.updateChain(HtmlTags.f1206TD);
            hTMLWorker.setSkipText(true);
        }
    };

    /* renamed from: TR */
    public static final HTMLTagProcessor f1217TR = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.setPendingTR(true);
            hTMLWorker.updateChain(str, map);
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(HtmlTags.f1206TD);
            }
            hTMLWorker.setPendingTR(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processRow();
            hTMLWorker.setSkipText(true);
        }
    };
    public static final HTMLTagProcessor UL_OL = new HTMLTagProcessor() {
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.f1202LI);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createList(str));
        }

        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.f1202LI);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processList();
        }
    };
    private static final long serialVersionUID = -959260811961222824L;

    public HTMLTagProcessors() {
        put(HtmlTags.f1190A, f1211A);
        HTMLTagProcessor hTMLTagProcessor = EM_STRONG_STRIKE_SUP_SUP;
        put(HtmlTags.f1191B, hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor2 = DIV;
        put(HtmlTags.BODY, hTMLTagProcessor2);
        put(HtmlTags.f1192BR, f1212BR);
        put(HtmlTags.DIV, hTMLTagProcessor2);
        put(HtmlTags.f1193EM, hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor3 = SPAN;
        put(HtmlTags.FONT, hTMLTagProcessor3);
        HTMLTagProcessor hTMLTagProcessor4 = f1213H;
        put(HtmlTags.f1194H1, hTMLTagProcessor4);
        put(HtmlTags.f1195H2, hTMLTagProcessor4);
        put(HtmlTags.f1196H3, hTMLTagProcessor4);
        put(HtmlTags.f1197H4, hTMLTagProcessor4);
        put(HtmlTags.f1198H5, hTMLTagProcessor4);
        put(HtmlTags.f1199H6, hTMLTagProcessor4);
        put(HtmlTags.f1200HR, f1214HR);
        put(HtmlTags.f1201I, hTMLTagProcessor);
        put(HtmlTags.IMG, IMG);
        put(HtmlTags.f1202LI, f1215LI);
        HTMLTagProcessor hTMLTagProcessor5 = UL_OL;
        put(HtmlTags.f1203OL, hTMLTagProcessor5);
        put(HtmlTags.f1204P, hTMLTagProcessor2);
        put(HtmlTags.PRE, PRE);
        put(HtmlTags.f1205S, hTMLTagProcessor);
        put(HtmlTags.SPAN, hTMLTagProcessor3);
        put(HtmlTags.STRIKE, hTMLTagProcessor);
        put(HtmlTags.STRONG, hTMLTagProcessor);
        put(HtmlTags.SUB, hTMLTagProcessor);
        put(HtmlTags.SUP, hTMLTagProcessor);
        put(HtmlTags.TABLE, TABLE);
        HTMLTagProcessor hTMLTagProcessor6 = f1216TD;
        put(HtmlTags.f1206TD, hTMLTagProcessor6);
        put(HtmlTags.f1207TH, hTMLTagProcessor6);
        put(HtmlTags.f1208TR, f1217TR);
        put(HtmlTags.f1209U, hTMLTagProcessor);
        put(HtmlTags.f1210UL, hTMLTagProcessor5);
    }
}
