package ijk.media.player.misc;

import ijk.media.player.misc.a;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class j extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(a aVar) {
        super(null);
        this.f8111a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        int integer = aVar.getInteger("channel_layout");
        if (integer <= 0) {
            return null;
        }
        long j = integer;
        return j == 4 ? "mono" : j == 3 ? "stereo" : String.format(Locale.US, "%x", Integer.valueOf(integer));
    }
}
