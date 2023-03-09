package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.play.core.splitcompat.C0989p;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.play.core.splitinstall.k */
public final class C0997k {

    /* renamed from: a */
    private static C0999m f201a;

    private C0997k() {
    }

    /* renamed from: a */
    public static synchronized C0999m m217a(Context context) {
        C0999m mVar;
        synchronized (C0997k.class) {
            if (f201a == null) {
                C0991b bVar = new C0991b((byte[]) null);
                bVar.mo17127b(new C1004x(C0989p.m204c(context)));
                f201a = bVar.mo17126a();
            }
            mVar = f201a;
        }
        return mVar;
    }

    /* renamed from: b */
    static C0996h m218b(XmlPullParser xmlPullParser, C0995g gVar) {
        String c;
        while (xmlPullParser.next() != 1) {
            try {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("splits")) {
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (!xmlPullParser.getName().equals("module") || (c = m219c(AppMeasurementSdk.ConditionalUserProperty.NAME, xmlPullParser)) == null) {
                                    m220d(xmlPullParser);
                                } else {
                                    while (xmlPullParser.next() != 3) {
                                        if (xmlPullParser.getEventType() == 2) {
                                            if (xmlPullParser.getName().equals(DublinCoreProperties.LANGUAGE)) {
                                                while (xmlPullParser.next() != 3) {
                                                    if (xmlPullParser.getEventType() == 2) {
                                                        if (xmlPullParser.getName().equals("entry")) {
                                                            String c2 = m219c("key", xmlPullParser);
                                                            String c3 = m219c("split", xmlPullParser);
                                                            m220d(xmlPullParser);
                                                            if (!(c2 == null || c3 == null)) {
                                                                gVar.mo17133b(c, c2, c3);
                                                            }
                                                        } else {
                                                            m220d(xmlPullParser);
                                                        }
                                                    }
                                                }
                                            } else {
                                                m220d(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        m220d(xmlPullParser);
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            }
        }
        return gVar.mo17132a();
    }

    /* renamed from: c */
    private static String m219c(String str, XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: d */
    private static void m220d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
