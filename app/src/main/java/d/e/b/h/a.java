package d.e.b.h;

import com.zte.ucs.tvcall.ocx.nab.ContactAddressInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressResp;
import com.zte.ucs.tvcall.ocx.nab.ContactBaseInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileResp;
import com.zte.ucs.tvcall.ocx.nab.UserPrefsResp;

/* loaded from: classes2.dex */
public interface a {
    void a(int i, String str, int i2, ProfileInfo profileInfo, String str2);

    void a(int i, String str, int i2, String str2, String str3);

    void a(String str, int i, ContactAddressInfo contactAddressInfo);

    void a(String str, int i, ProfileInfo profileInfo);

    void a(String str, int i, String str2, ProfileResp profileResp, UserPrefsResp userPrefsResp, int i2, int i3, int i4, ContactAddressResp[] contactAddressRespArr);

    void a(String str, int i, String str2, String str3, int i2, ContactBaseInfo[] contactBaseInfoArr);

    void b(String str, int i, ContactAddressInfo contactAddressInfo);

    void b(String str, int i, ProfileInfo profileInfo);

    void c(String str, int i, ContactAddressInfo contactAddressInfo);

    void c(String str, int i, ProfileInfo profileInfo);

    void c(String str, int i, String str2, String str3);

    void d(String str, int i, ContactAddressInfo contactAddressInfo);

    void d(String str, int i, ProfileInfo profileInfo);
}
