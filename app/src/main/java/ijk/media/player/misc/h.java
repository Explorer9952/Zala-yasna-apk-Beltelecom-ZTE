package ijk.media.player.misc;

import ijk.media.player.misc.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class h extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(a aVar) {
        super(null);
        this.f8109a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        int integer = aVar.getInteger("fps_num");
        int integer2 = aVar.getInteger("fps_den");
        if (integer <= 0 || integer2 <= 0) {
            return null;
        }
        return String.valueOf(integer / integer2);
    }
}
