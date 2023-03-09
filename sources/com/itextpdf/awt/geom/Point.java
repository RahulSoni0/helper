package com.itextpdf.awt.geom;

import java.io.Serializable;

public class Point extends Point2D implements Serializable {
    private static final long serialVersionUID = -5276940640259749850L;

    /* renamed from: x */
    public double f1105x;

    /* renamed from: y */
    public double f1106y;

    public Point() {
        setLocation(0, 0);
    }

    public Point(int i, int i2) {
        setLocation(i, i2);
    }

    public Point(double d, double d2) {
        setLocation(d, d2);
    }

    public Point(Point point) {
        setLocation(point.f1105x, point.f1106y);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f1105x == point.f1105x && this.f1106y == point.f1106y) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.f1105x + ",y=" + this.f1106y + "]";
    }

    public double getX() {
        return this.f1105x;
    }

    public double getY() {
        return this.f1106y;
    }

    public Point getLocation() {
        return new Point(this.f1105x, this.f1106y);
    }

    public void setLocation(Point point) {
        setLocation(point.f1105x, point.f1106y);
    }

    public void setLocation(int i, int i2) {
        setLocation((double) i, (double) i2);
    }

    public void setLocation(double d, double d2) {
        this.f1105x = d;
        this.f1106y = d2;
    }

    public void move(int i, int i2) {
        move((double) i, (double) i2);
    }

    public void move(double d, double d2) {
        setLocation(d, d2);
    }

    public void translate(int i, int i2) {
        translate((double) i, (double) i2);
    }

    public void translate(double d, double d2) {
        this.f1105x += d;
        this.f1106y += d2;
    }
}
