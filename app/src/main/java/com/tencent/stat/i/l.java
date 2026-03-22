package com.tencent.stat.i;

/* loaded from: classes.dex */
class l extends j {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f2886c;

    /* renamed from: d, reason: collision with root package name */
    int f2887d;
    private int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    private final byte[] i;
    static final /* synthetic */ boolean l = !i.class.desiredAssertionStatus();
    private static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public l(int i, byte[] bArr) {
        this.f2882a = bArr;
        this.f = (i & 1) == 0;
        this.g = (i & 2) == 0;
        this.h = (i & 4) != 0;
        this.i = (i & 8) == 0 ? j : k;
        this.f2886c = new byte[2];
        this.f2887d = 0;
        this.e = this.g ? 19 : -1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.i.l.a(byte[], int, int, boolean):boolean");
    }
}
