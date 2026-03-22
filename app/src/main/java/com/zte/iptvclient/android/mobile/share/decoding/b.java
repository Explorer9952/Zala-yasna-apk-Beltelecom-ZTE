package com.zte.iptvclient.android.mobile.share.decoding;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager.java */
/* loaded from: classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    static final Vector<BarcodeFormat> f7207a;

    /* renamed from: b, reason: collision with root package name */
    static final Vector<BarcodeFormat> f7208b;

    /* renamed from: c, reason: collision with root package name */
    static final Vector<BarcodeFormat> f7209c;

    /* renamed from: d, reason: collision with root package name */
    static final Vector<BarcodeFormat> f7210d;

    static {
        Pattern.compile(",");
        Vector<BarcodeFormat> vector = new Vector<>(5);
        f7207a = vector;
        vector.add(BarcodeFormat.UPC_A);
        f7207a.add(BarcodeFormat.UPC_E);
        f7207a.add(BarcodeFormat.EAN_13);
        f7207a.add(BarcodeFormat.EAN_8);
        Vector<BarcodeFormat> vector2 = new Vector<>(f7207a.size() + 4);
        f7208b = vector2;
        vector2.addAll(f7207a);
        f7208b.add(BarcodeFormat.CODE_39);
        f7208b.add(BarcodeFormat.CODE_93);
        f7208b.add(BarcodeFormat.CODE_128);
        f7208b.add(BarcodeFormat.ITF);
        Vector<BarcodeFormat> vector3 = new Vector<>(1);
        f7209c = vector3;
        vector3.add(BarcodeFormat.QR_CODE);
        Vector<BarcodeFormat> vector4 = new Vector<>(1);
        f7210d = vector4;
        vector4.add(BarcodeFormat.DATA_MATRIX);
    }
}
