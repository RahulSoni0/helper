package com.itextpdf.text;

import java.io.Serializable;

public class AccessibleElementId implements Comparable<AccessibleElementId>, Serializable {
    private static int id_counter;

    /* renamed from: id */
    private int f1150id;

    public AccessibleElementId() {
        int i = id_counter + 1;
        id_counter = i;
        this.f1150id = i;
    }

    public String toString() {
        return Integer.toString(this.f1150id);
    }

    public int hashCode() {
        return this.f1150id;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AccessibleElementId) && this.f1150id == ((AccessibleElementId) obj).f1150id;
    }

    public int compareTo(AccessibleElementId accessibleElementId) {
        int i = this.f1150id;
        int i2 = accessibleElementId.f1150id;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
