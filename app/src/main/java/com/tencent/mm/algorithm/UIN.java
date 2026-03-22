package com.tencent.mm.algorithm;

/* loaded from: classes.dex */
public class UIN extends Number {
    private int h;

    public UIN(int i) {
        this.h = 0;
        this.h = i;
    }

    public UIN(long j) {
        this.h = 0;
        this.h = (int) (j & (-1));
    }

    public static int valueOf(String str) {
        try {
            return new UIN(Long.valueOf(str).longValue()).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        double d2 = this.h | 0;
        Double.isNaN(d2);
        return d2 + 0.0d;
    }

    @Override // java.lang.Number
    public float floatValue() {
        double d2 = this.h | 0;
        Double.isNaN(d2);
        return (float) (d2 + 0.0d);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.h;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.h & 4294967295L;
    }

    public String toString() {
        return String.valueOf(this.h & 4294967295L);
    }

    public int value() {
        return this.h;
    }
}
