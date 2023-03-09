package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClipperOffset {
    private static final double DEFAULT_ARC_TOLERANCE = 0.25d;
    private static final double TOLERANCE = 1.0E-20d;
    private static final double TWO_PI = 6.283185307179586d;
    private final double arcTolerance;
    private double cos;
    private double delta;
    private Path destPoly;
    private Paths destPolys;
    private double inA;
    private Point.LongPoint lowest;
    private double miterLim;
    private final double miterLimit;
    private final List<Point.DoublePoint> normals;
    private final PolyNode polyNodes;
    private double sin;
    private Path srcPoly;
    private double stepsPerRad;

    private static boolean nearZero(double d) {
        return d > -1.0E-20d && d < TOLERANCE;
    }

    public ClipperOffset() {
        this(2.0d, DEFAULT_ARC_TOLERANCE);
    }

    public ClipperOffset(double d) {
        this(d, DEFAULT_ARC_TOLERANCE);
    }

    public ClipperOffset(double d, double d2) {
        this.miterLimit = d;
        this.arcTolerance = d2;
        Point.LongPoint longPoint = new Point.LongPoint();
        this.lowest = longPoint;
        longPoint.setX(-1L);
        this.polyNodes = new PolyNode();
        this.normals = new ArrayList();
    }

    public void addPath(Path path, Clipper.JoinType joinType, Clipper.EndType endType) {
        int size = path.size() - 1;
        if (size >= 0) {
            PolyNode polyNode = new PolyNode();
            polyNode.setJoinType(joinType);
            polyNode.setEndType(endType);
            int i = 0;
            if (endType == Clipper.EndType.CLOSED_LINE || endType == Clipper.EndType.CLOSED_POLYGON) {
                while (size > 0 && path.get(0) == path.get(size)) {
                    size--;
                }
            }
            polyNode.getPolygon().add(path.get(0));
            int i2 = 0;
            for (int i3 = 1; i3 <= size; i3++) {
                if (polyNode.getPolygon().get(i) != path.get(i3)) {
                    i++;
                    polyNode.getPolygon().add(path.get(i3));
                    if (((Point.LongPoint) path.get(i3)).getY() > ((Point.LongPoint) polyNode.getPolygon().get(i2)).getY() || (((Point.LongPoint) path.get(i3)).getY() == ((Point.LongPoint) polyNode.getPolygon().get(i2)).getY() && ((Point.LongPoint) path.get(i3)).getX() < ((Point.LongPoint) polyNode.getPolygon().get(i2)).getX())) {
                        i2 = i;
                    }
                }
            }
            if (endType != Clipper.EndType.CLOSED_POLYGON || i >= 2) {
                this.polyNodes.addChild(polyNode);
                if (endType == Clipper.EndType.CLOSED_POLYGON) {
                    if (this.lowest.getX() < 0) {
                        this.lowest = new Point.LongPoint((long) (this.polyNodes.getChildCount() - 1), (long) i2);
                        return;
                    }
                    Point.LongPoint longPoint = (Point.LongPoint) this.polyNodes.getChilds().get((int) this.lowest.getX()).getPolygon().get((int) this.lowest.getY());
                    if (((Point.LongPoint) polyNode.getPolygon().get(i2)).getY() > longPoint.getY() || (((Point.LongPoint) polyNode.getPolygon().get(i2)).getY() == longPoint.getY() && ((Point.LongPoint) polyNode.getPolygon().get(i2)).getX() < longPoint.getX())) {
                        this.lowest = new Point.LongPoint((long) (this.polyNodes.getChildCount() - 1), (long) i2);
                    }
                }
            }
        }
    }

    public void addPaths(Paths paths, Clipper.JoinType joinType, Clipper.EndType endType) {
        Iterator it = paths.iterator();
        while (it.hasNext()) {
            addPath((Path) it.next(), joinType, endType);
        }
    }

    public void clear() {
        this.polyNodes.getChilds().clear();
        this.lowest.setX(-1L);
    }

    private void doMiter(int i, int i2, double d) {
        double d2 = this.delta / d;
        Path path = this.destPoly;
        double x = (double) ((Point.LongPoint) this.srcPoly.get(i)).getX();
        Double.isNaN(x);
        long round = Math.round(x + ((this.normals.get(i2).getX() + this.normals.get(i).getX()) * d2));
        double y = (double) ((Point.LongPoint) this.srcPoly.get(i)).getY();
        Double.isNaN(y);
        path.add(new Point.LongPoint(round, Math.round(y + ((this.normals.get(i2).getY() + this.normals.get(i).getY()) * d2))));
    }

    private void doOffset(double d) {
        double d2;
        double d3;
        int i;
        char c;
        double d4 = d;
        this.destPolys = new Paths();
        this.delta = d4;
        int i2 = 0;
        if (nearZero(d)) {
            while (i2 < this.polyNodes.getChildCount()) {
                PolyNode polyNode = this.polyNodes.getChilds().get(i2);
                if (polyNode.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                    this.destPolys.add(polyNode.getPolygon());
                }
                i2++;
            }
            return;
        }
        double d5 = this.miterLimit;
        if (d5 > 2.0d) {
            this.miterLim = 2.0d / (d5 * d5);
        } else {
            this.miterLim = 0.5d;
        }
        double d6 = this.arcTolerance;
        double d7 = DEFAULT_ARC_TOLERANCE;
        double d8 = 0.0d;
        if (d6 > 0.0d) {
            if (d6 > Math.abs(d) * DEFAULT_ARC_TOLERANCE) {
                d7 = DEFAULT_ARC_TOLERANCE * Math.abs(d);
            } else {
                d7 = this.arcTolerance;
            }
        }
        double acos = 3.141592653589793d / Math.acos(1.0d - (d7 / Math.abs(d)));
        double d9 = TWO_PI / acos;
        this.sin = Math.sin(d9);
        this.cos = Math.cos(d9);
        this.stepsPerRad = acos / TWO_PI;
        if (d4 < 0.0d) {
            this.sin = -this.sin;
        }
        int i3 = 0;
        while (i3 < this.polyNodes.getChildCount()) {
            PolyNode polyNode2 = this.polyNodes.getChilds().get(i3);
            Path polygon = polyNode2.getPolygon();
            this.srcPoly = polygon;
            int size = polygon.size();
            if (size == 0 || (d4 <= d8 && (size < 3 || polyNode2.getEndType() != Clipper.EndType.CLOSED_POLYGON))) {
                d2 = acos;
                d3 = d8;
            } else {
                this.destPoly = new Path();
                int i4 = 1;
                if (size == 1) {
                    if (polyNode2.getJoinType() == Clipper.JoinType.ROUND) {
                        double d10 = d8;
                        double d11 = 1.0d;
                        while (((double) i4) <= acos) {
                            Path path = this.destPoly;
                            double x = (double) ((Point.LongPoint) this.srcPoly.get(i2)).getX();
                            Double.isNaN(x);
                            long round = Math.round(x + (d11 * d4));
                            double y = (double) ((Point.LongPoint) this.srcPoly.get(0)).getY();
                            Double.isNaN(y);
                            path.add(new Point.LongPoint(round, Math.round(y + (d10 * d4))));
                            double d12 = this.cos;
                            double d13 = this.sin;
                            d10 = (d10 * d12) + (d11 * d13);
                            i4++;
                            d11 = (d11 * d12) - (d13 * d10);
                            acos = acos;
                            i2 = 0;
                        }
                        d2 = acos;
                    } else {
                        d2 = acos;
                        double d14 = -1.0d;
                        double d15 = -1.0d;
                        for (int i5 = 0; i5 < 4; i5++) {
                            Path path2 = this.destPoly;
                            double x2 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getX();
                            Double.isNaN(x2);
                            long round2 = Math.round(x2 + (d14 * d4));
                            double y2 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getY();
                            Double.isNaN(y2);
                            path2.add(new Point.LongPoint(round2, Math.round(y2 + (d15 * d4))));
                            if (d14 < 0.0d) {
                                d14 = 1.0d;
                            } else if (d15 < 0.0d) {
                                d15 = 1.0d;
                            } else {
                                d14 = -1.0d;
                            }
                        }
                    }
                    this.destPolys.add(this.destPoly);
                } else {
                    d2 = acos;
                    this.normals.clear();
                    int i6 = 0;
                    while (true) {
                        i = size - 1;
                        if (i6 >= i) {
                            break;
                        }
                        i6++;
                        this.normals.add(Point.getUnitNormal((Point.LongPoint) this.srcPoly.get(i6), (Point.LongPoint) this.srcPoly.get(i6)));
                    }
                    if (polyNode2.getEndType() == Clipper.EndType.CLOSED_LINE || polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                        c = 0;
                        this.normals.add(Point.getUnitNormal((Point.LongPoint) this.srcPoly.get(i), (Point.LongPoint) this.srcPoly.get(0)));
                    } else {
                        this.normals.add(new Point.DoublePoint(this.normals.get(size - 2)));
                        c = 0;
                    }
                    if (polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                        int[] iArr = new int[1];
                        iArr[c] = i;
                        for (int i7 = 0; i7 < size; i7++) {
                            offsetPoint(i7, iArr, polyNode2.getJoinType());
                        }
                        this.destPolys.add(this.destPoly);
                    } else if (polyNode2.getEndType() == Clipper.EndType.CLOSED_LINE) {
                        int[] iArr2 = {i};
                        for (int i8 = 0; i8 < size; i8++) {
                            offsetPoint(i8, iArr2, polyNode2.getJoinType());
                        }
                        this.destPolys.add(this.destPoly);
                        this.destPoly = new Path();
                        Point.DoublePoint doublePoint = this.normals.get(i);
                        for (int i9 = i; i9 > 0; i9--) {
                            int i10 = i9 - 1;
                            this.normals.set(i9, new Point.DoublePoint(-this.normals.get(i10).getX(), -this.normals.get(i10).getY()));
                        }
                        List<Point.DoublePoint> list = this.normals;
                        Point.DoublePoint doublePoint2 = r9;
                        Point.DoublePoint doublePoint3 = new Point.DoublePoint(-doublePoint.getX(), -doublePoint.getY(), 0.0d);
                        list.set(0, doublePoint2);
                        iArr2[0] = 0;
                        while (i >= 0) {
                            offsetPoint(i, iArr2, polyNode2.getJoinType());
                            i--;
                        }
                        this.destPolys.add(this.destPoly);
                    } else {
                        int[] iArr3 = new int[1];
                        for (int i11 = 1; i11 < i; i11++) {
                            offsetPoint(i11, iArr3, polyNode2.getJoinType());
                        }
                        if (polyNode2.getEndType() == Clipper.EndType.OPEN_BUTT) {
                            double x3 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getX();
                            Double.isNaN(x3);
                            long round3 = Math.round(x3 + (this.normals.get(i).getX() * d4));
                            double y3 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getY();
                            Double.isNaN(y3);
                            this.destPoly.add(new Point.LongPoint(round3, Math.round(y3 + (this.normals.get(i).getY() * d4)), 0));
                            double x4 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getX();
                            Double.isNaN(x4);
                            long round4 = Math.round(x4 - (this.normals.get(i).getX() * d4));
                            double y4 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getY();
                            Double.isNaN(y4);
                            this.destPoly.add(new Point.LongPoint(round4, Math.round(y4 - (this.normals.get(i).getY() * d4)), 0));
                        } else {
                            iArr3[0] = size - 2;
                            this.inA = 0.0d;
                            this.normals.set(i, new Point.DoublePoint(-this.normals.get(i).getX(), -this.normals.get(i).getY()));
                            if (polyNode2.getEndType() == Clipper.EndType.OPEN_SQUARE) {
                                doSquare(i, iArr3[0], true);
                            } else {
                                doRound(i, iArr3[0]);
                            }
                        }
                        for (int i12 = i; i12 > 0; i12--) {
                            int i13 = i12 - 1;
                            this.normals.set(i12, new Point.DoublePoint(-this.normals.get(i13).getX(), -this.normals.get(i13).getY()));
                        }
                        this.normals.set(0, new Point.DoublePoint(-this.normals.get(1).getX(), -this.normals.get(1).getY()));
                        iArr3[0] = i;
                        for (int i14 = iArr3[0] - 1; i14 > 0; i14--) {
                            offsetPoint(i14, iArr3, polyNode2.getJoinType());
                        }
                        if (polyNode2.getEndType() == Clipper.EndType.OPEN_BUTT) {
                            double x5 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getX();
                            Double.isNaN(x5);
                            long round5 = Math.round(x5 - (this.normals.get(0).getX() * d4));
                            double y5 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getY();
                            Double.isNaN(y5);
                            this.destPoly.add(new Point.LongPoint(round5, Math.round(y5 - (this.normals.get(0).getY() * d4))));
                            double x6 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getX();
                            Double.isNaN(x6);
                            long round6 = Math.round(x6 + (this.normals.get(0).getX() * d4));
                            double y6 = (double) ((Point.LongPoint) this.srcPoly.get(0)).getY();
                            Double.isNaN(y6);
                            this.destPoly.add(new Point.LongPoint(round6, Math.round(y6 + (this.normals.get(0).getY() * d4))));
                            d3 = 0.0d;
                        } else {
                            iArr3[0] = 1;
                            d3 = 0.0d;
                            this.inA = 0.0d;
                            if (polyNode2.getEndType() == Clipper.EndType.OPEN_SQUARE) {
                                doSquare(0, 1, true);
                            } else {
                                doRound(0, 1);
                            }
                        }
                        this.destPolys.add(this.destPoly);
                    }
                }
                d3 = 0.0d;
            }
            i3++;
            d8 = d3;
            acos = d2;
            i2 = 0;
        }
    }

    private void doRound(int i, int i2) {
        int max = Math.max((int) Math.round(this.stepsPerRad * Math.abs(Math.atan2(this.inA, (this.normals.get(i2).getX() * this.normals.get(i).getX()) + (this.normals.get(i2).getY() * this.normals.get(i).getY())))), 1);
        double x = this.normals.get(i2).getX();
        double y = this.normals.get(i2).getY();
        int i3 = 0;
        while (i3 < max) {
            Path path = this.destPoly;
            double x2 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getX();
            Double.isNaN(x2);
            long round = Math.round(x2 + (this.delta * x));
            double y2 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getY();
            Double.isNaN(y2);
            path.add(new Point.LongPoint(round, Math.round(y2 + (this.delta * y))));
            double d = this.cos;
            double d2 = this.sin;
            y = (y * d) + (x * d2);
            i3++;
            x = (x * d) - (d2 * y);
        }
        Path path2 = this.destPoly;
        double x3 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getX();
        Double.isNaN(x3);
        long round2 = Math.round(x3 + (this.normals.get(i).getX() * this.delta));
        double y3 = (double) ((Point.LongPoint) this.srcPoly.get(i)).getY();
        Double.isNaN(y3);
        path2.add(new Point.LongPoint(round2, Math.round(y3 + (this.normals.get(i).getY() * this.delta))));
    }

    private void doSquare(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        double x = this.normals.get(i4).getX();
        double y = this.normals.get(i4).getY();
        double x2 = this.normals.get(i3).getX();
        double y2 = this.normals.get(i3).getY();
        double x3 = (double) ((Point.LongPoint) this.srcPoly.get(i3)).getX();
        double y3 = (double) ((Point.LongPoint) this.srcPoly.get(i3)).getY();
        double d = x2;
        double tan = Math.tan(Math.atan2(this.inA, (x * x2) + (y * y2)) / 4.0d);
        Path path = this.destPoly;
        double d2 = y2;
        double d3 = this.delta;
        double d4 = 0.0d;
        double d5 = z ? y * tan : 0.0d;
        Double.isNaN(x3);
        long round = Math.round((d3 * (x - d5)) + x3);
        double d6 = this.delta;
        double d7 = z ? x * tan : 0.0d;
        Double.isNaN(y3);
        path.add(new Point.LongPoint(round, Math.round((d6 * (y + d7)) + y3), 0));
        Path path2 = this.destPoly;
        double d8 = this.delta;
        double d9 = z ? d2 * tan : 0.0d;
        Double.isNaN(x3);
        long round2 = Math.round(x3 + (d8 * (d + d9)));
        double d10 = this.delta;
        if (z) {
            d4 = d * tan;
        }
        Double.isNaN(y3);
        path2.add(new Point.LongPoint(round2, Math.round(y3 + (d10 * (d2 - d4))), 0));
    }

    public void execute(Paths paths, double d) {
        Paths paths2 = paths;
        double d2 = d;
        paths.clear();
        fixOrientations();
        doOffset(d2);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        defaultClipper.addPaths(this.destPolys, Clipper.PolyType.SUBJECT, true);
        if (d2 > 0.0d) {
            defaultClipper.execute(Clipper.ClipType.UNION, paths2, Clipper.PolyFillType.POSITIVE, Clipper.PolyFillType.POSITIVE);
            return;
        }
        LongRect bounds = this.destPolys.getBounds();
        Path path = new Path(4);
        path.add(new Point.LongPoint(bounds.left - 10, bounds.bottom + 10, 0));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.bottom + 10, 0));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.top - 10, 0));
        path.add(new Point.LongPoint(bounds.left - 10, bounds.top - 10, 0));
        defaultClipper.addPath(path, Clipper.PolyType.SUBJECT, true);
        defaultClipper.execute(Clipper.ClipType.UNION, paths2, Clipper.PolyFillType.NEGATIVE, Clipper.PolyFillType.NEGATIVE);
        if (paths.size() > 0) {
            paths2.remove(0);
        }
    }

    public void execute(PolyTree polyTree, double d) {
        PolyTree polyTree2 = polyTree;
        double d2 = d;
        polyTree.Clear();
        fixOrientations();
        doOffset(d2);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        defaultClipper.addPaths(this.destPolys, Clipper.PolyType.SUBJECT, true);
        if (d2 > 0.0d) {
            defaultClipper.execute(Clipper.ClipType.UNION, polyTree2, Clipper.PolyFillType.POSITIVE, Clipper.PolyFillType.POSITIVE);
            return;
        }
        LongRect bounds = this.destPolys.getBounds();
        Path path = new Path(4);
        path.add(new Point.LongPoint(bounds.left - 10, bounds.bottom + 10, 0));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.bottom + 10, 0));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.top - 10, 0));
        path.add(new Point.LongPoint(bounds.left - 10, bounds.top - 10, 0));
        defaultClipper.addPath(path, Clipper.PolyType.SUBJECT, true);
        defaultClipper.execute(Clipper.ClipType.UNION, polyTree2, Clipper.PolyFillType.NEGATIVE, Clipper.PolyFillType.NEGATIVE);
        if (polyTree.getChildCount() != 1 || polyTree.getChilds().get(0).getChildCount() <= 0) {
            polyTree.Clear();
            return;
        }
        PolyNode polyNode = polyTree.getChilds().get(0);
        polyTree.getChilds().set(0, polyNode.getChilds().get(0));
        polyTree.getChilds().get(0).setParent(polyTree2);
        for (int i = 1; i < polyNode.getChildCount(); i++) {
            polyTree2.addChild(polyNode.getChilds().get(i));
        }
    }

    private void fixOrientations() {
        int i = 0;
        if (this.lowest.getX() < 0 || this.polyNodes.childs.get((int) this.lowest.getX()).getPolygon().orientation()) {
            while (i < this.polyNodes.getChildCount()) {
                PolyNode polyNode = this.polyNodes.childs.get(i);
                if (polyNode.getEndType() == Clipper.EndType.CLOSED_LINE && !polyNode.getPolygon().orientation()) {
                    Collections.reverse(polyNode.getPolygon());
                }
                i++;
            }
            return;
        }
        while (i < this.polyNodes.getChildCount()) {
            PolyNode polyNode2 = this.polyNodes.childs.get(i);
            if (polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON || (polyNode2.getEndType() == Clipper.EndType.CLOSED_LINE && polyNode2.getPolygon().orientation())) {
                Collections.reverse(polyNode2.getPolygon());
            }
            i++;
        }
    }

    private void offsetPoint(int i, int[] iArr, Clipper.JoinType joinType) {
        double d;
        long j;
        char c;
        int i2 = i;
        int i3 = iArr[0];
        double x = this.normals.get(i3).getX();
        double y = this.normals.get(i3).getY();
        double y2 = this.normals.get(i2).getY();
        double x2 = this.normals.get(i2).getX();
        long x3 = ((Point.LongPoint) this.srcPoly.get(i2)).getX();
        long y3 = ((Point.LongPoint) this.srcPoly.get(i2)).getY();
        int i4 = i3;
        double d2 = (x * y2) - (x2 * y);
        this.inA = d2;
        long j2 = y3;
        if (Math.abs(d2 * this.delta) >= 1.0d) {
            j = j2;
            d = y2;
            double d3 = this.inA;
            if (d3 > 1.0d) {
                this.inA = 1.0d;
            } else if (d3 < -1.0d) {
                this.inA = -1.0d;
            }
        } else if ((x * x2) + (y2 * y) > 0.0d) {
            Path path = this.destPoly;
            double d4 = (double) x3;
            Double.isNaN(d4);
            long round = Math.round(d4 + (x * this.delta));
            double d5 = (double) j2;
            Double.isNaN(d5);
            path.add(new Point.LongPoint(round, Math.round(d5 + (y * this.delta)), 0));
            return;
        } else {
            j = j2;
            d = y2;
        }
        if (this.inA * this.delta < 0.0d) {
            Path path2 = this.destPoly;
            double d6 = (double) x3;
            Double.isNaN(d6);
            long round2 = Math.round((x * this.delta) + d6);
            double d7 = (double) j;
            Double.isNaN(d7);
            path2.add(new Point.LongPoint(round2, Math.round((y * this.delta) + d7)));
            this.destPoly.add(this.srcPoly.get(i2));
            Path path3 = this.destPoly;
            Double.isNaN(d6);
            long round3 = Math.round(d6 + (x2 * this.delta));
            Double.isNaN(d7);
            path3.add(new Point.LongPoint(round3, Math.round(d7 + (this.delta * d))));
        } else {
            int i5 = C18271.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType[joinType.ordinal()];
            if (i5 == 1) {
                int i6 = i4;
                c = 0;
                double d8 = (x2 * x) + 1.0d + (d * y);
                if (d8 >= this.miterLim) {
                    doMiter(i2, i6, d8);
                } else {
                    doSquare(i2, i6, false);
                }
            } else if (i5 == 2) {
                c = 0;
                doSquare(i2, i4, false);
            } else if (i5 == 3) {
                doRound(i2, i4);
            }
            iArr[c] = i2;
        }
        c = 0;
        iArr[c] = i2;
    }

    /* renamed from: com.itextpdf.text.pdf.parser.clipper.ClipperOffset$1 */
    static /* synthetic */ class C18271 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType[] r0 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType = r0
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.MITER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.ClipperOffset.C18271.<clinit>():void");
        }
    }
}
