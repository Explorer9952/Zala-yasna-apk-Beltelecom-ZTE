package ijk.media.player.misc;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.zte.ucs.tvcall.Commons;
import ijk.media.player.c;

/* compiled from: IjkTrackInfo.java */
/* loaded from: classes2.dex */
public class k implements ITrackInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f8112a = 0;

    /* renamed from: b, reason: collision with root package name */
    private c.a f8113b;

    public k(c.a aVar) {
        this.f8113b = aVar;
    }

    public void a(int i) {
        this.f8112a = i;
    }

    @Override // ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new a(this.f8113b);
    }

    @Override // ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb = new StringBuilder(Commons.MSG_MCSP_INIT_SUCCESS);
        int i = this.f8112a;
        if (i == 1) {
            sb.append(ShareConstants.VIDEO_URL);
            sb.append(", ");
            sb.append(this.f8113b.a());
            sb.append(", ");
            sb.append(this.f8113b.c());
            sb.append(", ");
            sb.append(this.f8113b.b());
        } else if (i == 2) {
            sb.append("AUDIO");
            sb.append(", ");
            sb.append(this.f8113b.a());
            sb.append(", ");
            sb.append(this.f8113b.c());
            sb.append(", ");
            sb.append(this.f8113b.d());
        } else if (i == 3) {
            sb.append("TIMEDTEXT");
            sb.append(", ");
            sb.append(this.f8113b.f8090d);
        } else if (i != 4) {
            sb.append("UNKNOWN");
        } else {
            sb.append(ShareConstants.SUBTITLE);
        }
        return sb.toString();
    }

    @Override // ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        c.a aVar = this.f8113b;
        return (aVar == null || TextUtils.isEmpty(aVar.f8090d)) ? "und" : this.f8113b.f8090d;
    }

    @Override // ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.f8112a;
    }

    public String toString() {
        return k.class.getSimpleName() + '{' + getInfoInline() + "}";
    }
}
