package ijk.media.player.misc;

import ijk.media.player.misc.a;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class g extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar) {
        super(null);
        this.f8108a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        int integer = aVar.getInteger("width");
        int integer2 = aVar.getInteger("height");
        int integer3 = aVar.getInteger("sar_num");
        int integer4 = aVar.getInteger("sar_den");
        if (integer <= 0 || integer2 <= 0) {
            return null;
        }
        return (integer3 <= 0 || integer4 <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(integer), Integer.valueOf(integer2)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4));
    }
}
