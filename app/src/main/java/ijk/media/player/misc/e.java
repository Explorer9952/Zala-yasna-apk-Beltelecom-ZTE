package ijk.media.player.misc;

import android.text.TextUtils;
import com.zte.ucs.tvcall.Commons;
import ijk.media.player.misc.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class e extends a.AbstractC0413a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(null);
        this.f8106a = aVar;
    }

    @Override // ijk.media.player.misc.a.AbstractC0413a
    protected String a(a aVar) {
        String str;
        switch (aVar.getInteger("codec_profile_id")) {
            case 44:
                str = "CAVLC 4:4:4";
                break;
            case 66:
                str = "Baseline";
                break;
            case 77:
                str = "Main";
                break;
            case 88:
                str = "Extended";
                break;
            case 100:
                str = "High";
                break;
            case 110:
                str = "High 10";
                break;
            case 122:
                str = "High 4:2:2";
                break;
            case Commons.CONTACT_REFRESH_AFTER_EDIT /* 144 */:
                str = "High 4:4:4";
                break;
            case 244:
                str = "High 4:4:4 Predictive";
                break;
            case 578:
                str = "Constrained Baseline";
                break;
            case 2158:
                str = "High 10 Intra";
                break;
            case 2170:
                str = "High 4:2:2 Intra";
                break;
            case 2292:
                str = "High 4:4:4 Intra";
                break;
            default:
                return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String string = aVar.getString("codec_name");
        if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("h264")) {
            int integer = aVar.getInteger("codec_level");
            if (integer < 10) {
                return sb.toString();
            }
            sb.append(" Profile Level ");
            sb.append((integer / 10) % 10);
            int i = integer % 10;
            if (i != 0) {
                sb.append(".");
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
