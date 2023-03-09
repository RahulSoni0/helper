package com.itextpdf.awt.geom.p014gl;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Shape;

/* renamed from: com.itextpdf.awt.geom.gl.Crossing */
public class Crossing {
    public static final int CROSSING = 255;
    static final double DELTA = 1.0E-5d;
    static final double ROOT_DELTA = 1.0E-10d;
    static final int UNKNOWN = 254;

    public static int crossLine(double d, double d2, double d3, double d4, double d5, double d6) {
        if ((d5 < d && d5 < d3) || ((d5 > d && d5 > d3) || ((d6 > d2 && d6 > d4) || d == d3))) {
            return 0;
        }
        if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
            return 0;
        }
        return d5 == d ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? 1 : -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int intersectLine(double r10, double r12, double r14, double r16, double r18, double r20, double r22, double r24) {
        /*
            r0 = 0
            int r1 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0009
            int r1 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r1 < 0) goto L_0x0019
        L_0x0009:
            int r1 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            int r1 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r1 > 0) goto L_0x0019
        L_0x0011:
            int r1 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
            if (r1 <= 0) goto L_0x001a
            int r1 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            int r1 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x0023
            int r1 = (r24 > r16 ? 1 : (r24 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x0023
            goto L_0x006a
        L_0x0023:
            r1 = 255(0xff, float:3.57E-43)
            int r2 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r2 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x003f
            int r2 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x0035
            r2 = r18
            goto L_0x0036
        L_0x0035:
            r2 = r10
        L_0x0036:
            int r4 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x003c
            r4 = r14
            goto L_0x004c
        L_0x003c:
            r4 = r22
            goto L_0x004c
        L_0x003f:
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x0046
            r2 = r18
            goto L_0x0047
        L_0x0046:
            r2 = r14
        L_0x0047:
            int r4 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x003c
            r4 = r10
        L_0x004c:
            double r6 = r16 - r12
            double r8 = r14 - r10
            double r6 = r6 / r8
            double r2 = r2 - r10
            double r2 = r2 * r6
            double r2 = r2 + r12
            double r4 = r4 - r10
            double r6 = r6 * r4
            double r6 = r6 + r12
            int r4 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r4 >= 0) goto L_0x0062
            int r4 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r4 >= 0) goto L_0x0062
            return r0
        L_0x0062:
            int r4 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r4 <= 0) goto L_0x009e
            int r2 = (r6 > r24 ? 1 : (r6 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x009e
        L_0x006a:
            int r1 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x006f
            return r0
        L_0x006f:
            r1 = -1
            int r2 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x007b
            int r2 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r0 = -1
        L_0x007a:
            return r0
        L_0x007b:
            r2 = 1
            int r3 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x0086
            int r1 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x0085
            r0 = 1
        L_0x0085:
            return r0
        L_0x0086:
            int r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x0094
            int r1 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x0093
            int r1 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x0093
            r0 = 1
        L_0x0093:
            return r0
        L_0x0094:
            int r2 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x009d
            int r2 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x009d
            r0 = -1
        L_0x009d:
            return r0
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.awt.geom.p014gl.Crossing.intersectLine(double, double, double, double, double, double, double, double):int");
    }

    public static boolean isInsideEvenOdd(int i) {
        return (i & 1) != 0;
    }

    public static boolean isInsideNonZero(int i) {
        return i != 0;
    }

    public static boolean isZero(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    public static int solveQuad(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i = 2;
        double d = dArr[2];
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != 0.0d) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < 0.0d) {
                return 0;
            }
            double sqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr3[0] = (d5 + sqrt) / d6;
            if (sqrt != 0.0d) {
                dArr3[1] = (d5 - sqrt) / d6;
                return fixRoots(dArr3, i);
            }
        } else if (d2 == 0.0d) {
            return -1;
        } else {
            dArr3[0] = (-d3) / d2;
        }
        i = 1;
        return fixRoots(dArr3, i);
    }

    public static int solveCubic(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i = 3;
        double d = dArr[3];
        if (d == 0.0d) {
            return solveQuad(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double acos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double sqrt = Math.sqrt(d5) * -2.0d;
            dArr3[0] = (Math.cos(acos) * sqrt) + d9;
            dArr3[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d9;
            dArr3[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double sqrt2 = Math.sqrt(d10) + Math.abs(d6);
            double d11 = d9;
            double pow = Math.pow(sqrt2, 0.3333333333333333d);
            if (d6 > 0.0d) {
                pow = -pow;
            }
            if (-1.0E-10d >= pow || pow >= ROOT_DELTA) {
                double d12 = pow + (d5 / pow);
                dArr3[0] = d12 + d11;
                if (-1.0E-10d < d10 && d10 < ROOT_DELTA) {
                    dArr3[1] = ((-d12) / 2.0d) + d11;
                    i = 2;
                }
            } else {
                dArr3[0] = d11;
            }
            i = 1;
        }
        return fixRoots(dArr3, i);
    }

    static int fixRoots(double[] dArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 >= i) {
                    dArr[i3] = dArr[i2];
                    i3++;
                    break;
                } else if (isZero(dArr[i2] - dArr[i5])) {
                    break;
                } else {
                    i5++;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    /* renamed from: com.itextpdf.awt.geom.gl.Crossing$QuadCurve */
    public static class QuadCurve {

        /* renamed from: Ax */
        double f1142Ax;

        /* renamed from: Ay */
        double f1143Ay;

        /* renamed from: Bx */
        double f1144Bx;

        /* renamed from: By */
        double f1145By;

        /* renamed from: ax */
        double f1146ax;

        /* renamed from: ay */
        double f1147ay;

        /* renamed from: bx */
        double f1148bx;

        /* renamed from: by */
        double f1149by;

        public QuadCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d5 - d;
            this.f1146ax = d7;
            double d8 = d6 - d2;
            this.f1147ay = d8;
            double d9 = d3 - d;
            this.f1148bx = d9;
            double d10 = d4 - d2;
            this.f1149by = d10;
            double d11 = d9 + d9;
            this.f1144Bx = d11;
            this.f1142Ax = d7 - d11;
            double d12 = d10 + d10;
            this.f1145By = d12;
            this.f1143Ay = d8 - d12;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                double d3 = dArr[i4];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d4 = this.f1148bx;
                            if (d4 == 0.0d) {
                                d4 = this.f1146ax - d4;
                            }
                            if (d4 < 0.0d) {
                                i3--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.f1147ay) {
                            double d5 = this.f1146ax;
                            double d6 = this.f1148bx;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > 0.0d) {
                                i3++;
                            }
                        }
                    } else if (((this.f1143Ay * d3) + this.f1145By) * d3 > d2) {
                        double d7 = (d3 * this.f1142Ax) + this.f1148bx;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i3 += d7 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveQuad(new double[]{-d, this.f1144Bx, this.f1142Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtrem(double[] dArr) {
            double d = this.f1142Ax;
            int i = 0;
            if (d != 0.0d) {
                dArr[0] = (-this.f1144Bx) / (d + d);
                i = 1;
            }
            double d2 = this.f1143Ay;
            if (d2 == 0.0d) {
                return i;
            }
            dArr[i] = (-this.f1145By) / (d2 + d2);
            return i + 1;
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            for (int i7 = 0; i7 < i5; i7++) {
                double d3 = dArr2[i7];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.f1142Ax * d3) + this.f1144Bx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i8 = i4 + 1;
                        dArr[i4] = d3;
                        int i9 = i8 + 1;
                        dArr[i8] = d4;
                        int i10 = i9 + 1;
                        dArr[i9] = d3 * ((this.f1143Ay * d3) + this.f1145By);
                        i4 = i10 + 1;
                        dArr[i10] = (double) i6;
                        if (z) {
                            i6++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    /* renamed from: com.itextpdf.awt.geom.gl.Crossing$CubicCurve */
    public static class CubicCurve {

        /* renamed from: Ax */
        double f1130Ax;
        double Ax3;

        /* renamed from: Ay */
        double f1131Ay;

        /* renamed from: Bx */
        double f1132Bx;
        double Bx2;

        /* renamed from: By */
        double f1133By;

        /* renamed from: Cx */
        double f1134Cx;

        /* renamed from: Cy */
        double f1135Cy;

        /* renamed from: ax */
        double f1136ax;

        /* renamed from: ay */
        double f1137ay;

        /* renamed from: bx */
        double f1138bx;

        /* renamed from: by */
        double f1139by;

        /* renamed from: cx */
        double f1140cx;

        /* renamed from: cy */
        double f1141cy;

        public CubicCurve(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double d9 = d7 - d;
            this.f1136ax = d9;
            double d10 = d8 - d2;
            this.f1137ay = d10;
            double d11 = d3 - d;
            this.f1138bx = d11;
            double d12 = d4 - d2;
            this.f1139by = d12;
            double d13 = d5 - d;
            this.f1140cx = d13;
            double d14 = d6 - d2;
            this.f1141cy = d14;
            double d15 = d11 + d11 + d11;
            this.f1134Cx = d15;
            double d16 = (((d13 + d13) + d13) - d15) - d15;
            this.f1132Bx = d16;
            double d17 = (d9 - d16) - d15;
            this.f1130Ax = d17;
            double d18 = d12 + d12 + d12;
            this.f1135Cy = d18;
            double d19 = (((d14 + d14) + d14) - d18) - d18;
            this.f1133By = d19;
            this.f1131Ay = (d10 - d19) - d18;
            this.Ax3 = d17 + d17 + d17;
            this.Bx2 = d16 + d16;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            double d3;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                double d4 = dArr[i4];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d5 = this.f1138bx;
                            if (d5 == 0.0d) {
                                double d6 = this.f1140cx;
                                d5 = d6 != d5 ? d6 - d5 : this.f1136ax - d6;
                            }
                            if (d5 < 0.0d) {
                                i3--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d < this.f1137ay) {
                            double d7 = this.f1136ax;
                            double d8 = this.f1140cx;
                            if (d7 != d8) {
                                d3 = d7 - d8;
                            } else {
                                d3 = this.f1138bx;
                                if (d8 != d3) {
                                    d3 = d8 - d3;
                                }
                            }
                            if (d3 > 0.0d) {
                                i3++;
                            }
                        }
                    } else if (((((this.f1131Ay * d4) + this.f1133By) * d4) + this.f1135Cy) * d4 > d2) {
                        double d9 = this.Ax3;
                        double d10 = this.Bx2;
                        double d11 = (((d4 * d9) + d10) * d4) + this.f1134Cx;
                        if (d11 > -1.0E-5d && d11 < 1.0E-5d) {
                            double d12 = (d4 * (d9 + d9)) + d10;
                            if (d12 >= -1.0E-5d && d12 <= 1.0E-5d) {
                                d11 = this.f1136ax;
                            }
                        }
                        i3 += d11 > 0.0d ? 1 : -1;
                    }
                }
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveCubic(new double[]{-d, this.f1134Cx, this.f1132Bx, this.f1130Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremX(double[] dArr) {
            return Crossing.solveQuad(new double[]{this.f1134Cx, this.Bx2, this.Ax3}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremY(double[] dArr) {
            double d = this.f1133By;
            double d2 = this.f1131Ay;
            return Crossing.solveQuad(new double[]{this.f1135Cy, d + d, d2 + d2 + d2}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            for (int i7 = 0; i7 < i5; i7++) {
                double d3 = dArr2[i7];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.f1130Ax * d3) + this.f1132Bx) * d3) + this.f1134Cx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i8 = i4 + 1;
                        dArr[i4] = d3;
                        int i9 = i8 + 1;
                        dArr[i8] = d4;
                        int i10 = i9 + 1;
                        dArr[i9] = d3 * ((((this.f1131Ay * d3) + this.f1133By) * d3) + this.f1135Cy);
                        i4 = i10 + 1;
                        dArr[i10] = (double) i6;
                        if (z) {
                            i6++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    public static int crossQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if ((d7 < d && d7 < d3 && d7 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d == d3 && d3 == d5)))) {
            return 0;
        }
        if (d8 < d2 && d8 < d4 && d8 < d6 && d7 != d && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d9 = d8 - d2;
        double[] dArr = new double[3];
        return quadCurve.cross(dArr, quadCurve.solvePoint(dArr, d7 - d), d9, d9);
    }

    public static int crossCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        if ((d9 < d && d9 < d3 && d9 < d5 && d9 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d == d3 && d3 == d5 && d5 == d7)))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d10 < d8 && d9 != d && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d11 = d10 - d2;
        double[] dArr = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        return cubicCurve3.cross(dArr, cubicCurve3.solvePoint(dArr, d9 - d), d11, d11);
    }

    public static int crossPath(PathIterator pathIterator, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        char c;
        double[] dArr = new double[6];
        int i = 0;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i2 = 0;
        while (true) {
            if (pathIterator.isDone()) {
                d3 = d7;
                d4 = d8;
                d5 = d9;
                d6 = d10;
                i = i2;
                break;
            }
            int currentSegment = pathIterator.currentSegment(dArr);
            if (currentSegment == 0) {
                if (d8 == d7 && d9 == d10) {
                    c = 1;
                } else {
                    c = 1;
                    i2 += crossLine(d8, d9, d7, d10, d, d2);
                }
                double d11 = dArr[0];
                d10 = dArr[c];
                d9 = d10;
                d8 = d11;
                d7 = d8;
            } else if (currentSegment == 1) {
                double d12 = dArr[0];
                double d13 = dArr[1];
                i2 += crossLine(d8, d9, d12, d13, d, d2);
                d8 = d12;
                d9 = d13;
            } else if (currentSegment == 2) {
                double d14 = dArr[0];
                double d15 = dArr[1];
                double d16 = dArr[2];
                double d17 = dArr[3];
                i2 += crossQuad(d8, d9, d14, d15, d16, d17, d, d2);
                d8 = d16;
                d9 = d17;
            } else if (currentSegment == 3) {
                double d18 = dArr[3];
                double d19 = dArr[4];
                double d20 = dArr[5];
                i2 += crossCubic(d8, d9, dArr[0], dArr[1], dArr[2], d18, d19, d20, d, d2);
                d8 = d19;
                d9 = d20;
            } else if (currentSegment == 4 && !(d9 == d10 && d8 == d7)) {
                i2 += crossLine(d8, d9, d7, d10, d, d2);
                d8 = d7;
                d9 = d10;
            }
            if (d == d8 && d2 == d9) {
                d3 = d7;
                d4 = d8;
                d5 = d10;
                d6 = d5;
                break;
            }
            pathIterator.next();
        }
        return d5 != d6 ? i + crossLine(d4, d5, d3, d6, d, d2) : i;
    }

    public static int crossShape(Shape shape, double d, double d2) {
        if (!shape.getBounds2D().contains(d, d2)) {
            return 0;
        }
        return crossPath(shape.getPathIterator((AffineTransform) null), d, d2);
    }

    static void sortBound(double[] dArr, int i) {
        int i2 = 0;
        while (i2 < i - 4) {
            int i3 = i2 + 4;
            int i4 = i2;
            for (int i5 = i3; i5 < i; i5 += 4) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i2];
                dArr[i2] = dArr[i4];
                dArr[i4] = d;
                int i6 = i2 + 1;
                double d2 = dArr[i6];
                int i7 = i4 + 1;
                dArr[i6] = dArr[i7];
                dArr[i7] = d2;
                int i8 = i2 + 2;
                double d3 = dArr[i8];
                int i9 = i4 + 2;
                dArr[i8] = dArr[i9];
                dArr[i9] = d3;
                int i10 = i2 + 3;
                double d4 = dArr[i10];
                int i11 = i4 + 3;
                dArr[i10] = dArr[i11];
                dArr[i11] = d4;
            }
            i2 = i3;
        }
    }

    static int crossBound(double[] dArr, int i, double d, double d2) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 2; i4 < i; i4 += 4) {
            if (dArr[i4] < d) {
                i3++;
            } else if (dArr[i4] <= d2) {
                return 255;
            } else {
                i2++;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        if (i3 == 0) {
            return 254;
        }
        sortBound(dArr, i);
        boolean z = dArr[2] > d2;
        int i5 = 6;
        while (i5 < i) {
            boolean z2 = dArr[i5] > d2;
            if (z != z2 && dArr[i5 + 1] != dArr[i5 - 3]) {
                return 255;
            }
            i5 += 4;
            z = z2;
        }
        return 254;
    }

    public static int intersectQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        if ((d9 < d && d9 < d3 && d9 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || (d8 > d2 && d8 > d4 && d8 > d6))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d7 != d && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d11 = d7 - d;
        double d12 = d8 - d2;
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int solvePoint = quadCurve.solvePoint(dArr, d11);
        int solvePoint2 = quadCurve.solvePoint(dArr2, d13);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double d15 = d11 - 1.0E-5d;
        double[] dArr3 = new double[28];
        QuadCurve quadCurve2 = quadCurve;
        double[] dArr4 = dArr3;
        double d16 = d15;
        double d17 = d13 + 1.0E-5d;
        double[] dArr5 = dArr;
        double[] dArr6 = dArr2;
        int addBound = quadCurve2.addBound(dArr4, quadCurve2.addBound(dArr4, quadCurve2.addBound(dArr4, 0, dArr, solvePoint, d16, d17, false, 0), dArr6, solvePoint2, d16, d17, false, 1), dArr6, quadCurve.solveExtrem(dArr6), d16, d17, true, 2);
        if (d7 < d && d < d9) {
            int i = addBound + 1;
            dArr3[addBound] = 0.0d;
            int i2 = i + 1;
            dArr3[i] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            addBound = i3 + 1;
            dArr3[i3] = 4.0d;
        }
        if (d7 < d5 && d5 < d9) {
            int i4 = addBound + 1;
            dArr3[addBound] = 1.0d;
            int i5 = i4 + 1;
            dArr3[i4] = quadCurve.f1146ax;
            int i6 = i5 + 1;
            dArr3[i5] = quadCurve.f1147ay;
            addBound = i6 + 1;
            dArr3[i6] = 5.0d;
        }
        int crossBound = crossBound(dArr3, addBound, d12, d14);
        if (crossBound != 254) {
            return crossBound;
        }
        return quadCurve.cross(dArr5, solvePoint, d12, d14);
    }

    public static int intersectCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        if ((d11 < d && d11 < d3 && d11 < d5 && d11 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || (d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8))) {
            return 0;
        }
        if (d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8 && d9 != d && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double d15 = d11 - d;
        double d16 = d12 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        int solvePoint = cubicCurve3.solvePoint(dArr, d13);
        int solvePoint2 = cubicCurve3.solvePoint(dArr2, d15);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double[] dArr3 = new double[40];
        double d17 = d13 - 1.0E-5d;
        double[] dArr4 = dArr3;
        double d18 = d15 + 1.0E-5d;
        CubicCurve cubicCurve4 = cubicCurve3;
        double[] dArr5 = dArr2;
        int addBound = cubicCurve3.addBound(dArr3, 0, dArr, solvePoint, d17, d18, false, 0);
        double[] dArr6 = dArr4;
        double[] dArr7 = dArr5;
        CubicCurve cubicCurve5 = cubicCurve4;
        double[] dArr8 = dArr;
        double[] dArr9 = dArr7;
        double d19 = d16;
        CubicCurve cubicCurve6 = cubicCurve5;
        int addBound2 = cubicCurve6.addBound(dArr6, cubicCurve5.addBound(dArr6, cubicCurve4.addBound(dArr6, addBound, dArr5, solvePoint2, d17, d18, false, 1), dArr7, cubicCurve5.solveExtremX(dArr7), d17, d18, true, 2), dArr9, cubicCurve6.solveExtremY(dArr9), d17, d18, true, 4);
        if (d9 < d && d < d11) {
            int i = addBound2 + 1;
            dArr4[addBound2] = 0.0d;
            int i2 = i + 1;
            dArr4[i] = 0.0d;
            int i3 = i2 + 1;
            dArr4[i2] = 0.0d;
            addBound2 = i3 + 1;
            dArr4[i3] = 6.0d;
        }
        if (d9 < d7 && d7 < d11) {
            int i4 = addBound2 + 1;
            dArr4[addBound2] = 1.0d;
            int i5 = i4 + 1;
            dArr4[i4] = cubicCurve6.f1136ax;
            int i6 = i5 + 1;
            dArr4[i5] = cubicCurve6.f1137ay;
            addBound2 = i6 + 1;
            dArr4[i6] = 7.0d;
        }
        int crossBound = crossBound(dArr4, addBound2, d14, d19);
        if (crossBound != 254) {
            return crossBound;
        }
        return cubicCurve6.cross(dArr8, solvePoint, d14, d19);
    }

    public static int intersectPath(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5;
        int i;
        char c;
        int intersectLine;
        double[] dArr = new double[6];
        double d6 = d + d3;
        double d7 = d2 + d4;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i2 = 0;
        while (true) {
            int i3 = 255;
            if (!pathIterator.isDone()) {
                int currentSegment = pathIterator.currentSegment(dArr);
                if (currentSegment == 0) {
                    if (d8 == d10 && d9 == d11) {
                        intersectLine = 0;
                        c = 1;
                    } else {
                        c = 1;
                        intersectLine = intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                    }
                    d10 = dArr[0];
                    d11 = dArr[c];
                    i3 = 255;
                    d9 = d11;
                    d5 = d10;
                } else if (currentSegment == 1) {
                    double d12 = dArr[0];
                    double d13 = dArr[1];
                    i = intersectLine(d8, d9, d12, d13, d, d2, d6, d7);
                    d9 = d13;
                    d5 = d10;
                    i3 = 255;
                    d10 = d12;
                } else if (currentSegment != 2) {
                    if (currentSegment == 3) {
                        double d14 = dArr[4];
                        double d15 = dArr[5];
                        i = intersectCubic(d8, d9, dArr[0], dArr[1], dArr[2], dArr[3], d14, d15, d, d2, d6, d7);
                        d5 = d10;
                        d10 = d14;
                        d9 = d15;
                    } else if (currentSegment != 4) {
                        d5 = d10;
                        d10 = d8;
                        i = 0;
                    } else {
                        i = (d9 == d11 && d8 == d10) ? 0 : intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                        d5 = d10;
                        d9 = d11;
                    }
                    i3 = 255;
                } else {
                    double d16 = dArr[0];
                    double d17 = dArr[1];
                    double d18 = dArr[2];
                    double d19 = dArr[3];
                    i = intersectQuad(d8, d9, d16, d17, d18, d19, d, d2, d6, d7);
                    d9 = d19;
                    d5 = d10;
                    i3 = 255;
                    d10 = d18;
                }
                if (i == i3) {
                    return i3;
                }
                i2 += i;
                pathIterator.next();
                d8 = d10;
                d10 = d5;
            } else if (d9 == d11) {
                return i2;
            } else {
                int intersectLine2 = intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                if (intersectLine2 == 255) {
                    return 255;
                }
                return i2 + intersectLine2;
            }
        }
    }

    public static int intersectShape(Shape shape, double d, double d2, double d3, double d4) {
        if (!shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return 0;
        }
        Shape shape2 = shape;
        return intersectPath(shape.getPathIterator((AffineTransform) null), d, d2, d3, d4);
    }
}
