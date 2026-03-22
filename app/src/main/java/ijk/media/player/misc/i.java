package ijk.media.player.misc;

import ijk.media.player.misc.a;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class i extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(a aVar) {
        super(null);
        this.f8110a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        int integer = aVar.getInteger("sample_rate");
        if (integer <= 0) {
            return null;
        }
        return String.format(Locale.US, "%d Hz", Integer.valueOf(integer));
    }
}
