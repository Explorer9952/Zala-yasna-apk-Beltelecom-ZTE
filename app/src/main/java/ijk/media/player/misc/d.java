package ijk.media.player.misc;

import ijk.media.player.misc.a;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class d extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(null);
        this.f8105a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        int integer = aVar.getInteger("bitrate");
        if (integer <= 0) {
            return null;
        }
        return integer < 1000 ? String.format(Locale.US, "%d bit/s", Integer.valueOf(integer)) : String.format(Locale.US, "%d kb/s", Integer.valueOf(integer / 1000));
    }
}
