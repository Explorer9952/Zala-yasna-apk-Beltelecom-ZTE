package d.e.b.h.c;

import android.os.Message;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressResp;
import com.zte.ucs.tvcall.ocx.nab.OfflineContactInfo;
import com.zte.ucs.tvcall.ocx.nab.OfflineNabCallbackInfo;
import d.e.b.n.d;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8062d = b.class.getName();

    @Override // d.e.b.h.c.a
    public void a(String str, int i, OfflineContactInfo offlineContactInfo) {
        String accountid = offlineContactInfo.getAccountid();
        String userpassword = offlineContactInfo.getUserpassword();
        String contactid = offlineContactInfo.getContactid();
        String iconFile = offlineContactInfo.getIconFile();
        String address = offlineContactInfo.getAddress();
        String birthDate = offlineContactInfo.getBirthDate();
        String displayAttrValue = offlineContactInfo.getDisplayAttrValue();
        String duty = offlineContactInfo.getDuty();
        String email = offlineContactInfo.getEmail();
        String etag = offlineContactInfo.getEtag();
        String firstLetter = offlineContactInfo.getFirstLetter();
        String mobileId = offlineContactInfo.getMobileId();
        String name = offlineContactInfo.getName();
        String nickName = offlineContactInfo.getNickName();
        String officeAddr = offlineContactInfo.getOfficeAddr();
        String spellName = offlineContactInfo.getSpellName();
        StringBuilder sb = new StringBuilder();
        sb.append((int) offlineContactInfo.getRcsflag());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((int) offlineContactInfo.getAbility());
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) offlineContactInfo.getCommonflag());
        d.a(this.f8062d, String.format(Locale.getDefault(), "【离线NAB搜索Contact结果通知】 java_queryOfflineContactAddress  lResult[%d] sessionID[%s] accountId[%s] pass[%s] contactid[%s] icon[%s] rcsflag[%s] ability[%s] commonflag[%s] address[%s] birthdate[%s] displayAttrValue[%s] duty[%s] email[%s] etag[%s]  firstLetter[%s] mobileId[%s] name[%s] nickName[%s] officeAddr[%s] spellName[%s] tel[%s] officetel[%s] hometel[%s] currentThread[%s]", Integer.valueOf(i), str, accountid, userpassword, contactid, iconFile, sb2, sb4, sb5.toString(), address, birthDate, displayAttrValue, duty, email, etag, firstLetter, mobileId, name, nickName, officeAddr, spellName, offlineContactInfo.getTel(), offlineContactInfo.getOfficetel(), offlineContactInfo.getHometel(), Thread.currentThread().getName()));
        OfflineNabCallbackInfo offlineNabCallbackInfo = new OfflineNabCallbackInfo();
        offlineNabCallbackInfo.setSessionID(str);
        offlineNabCallbackInfo.setOfflineContactInfo(offlineContactInfo);
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = offlineNabCallbackInfo;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.h.c.a
    public void a(String str, int i, String str2, int i2, ContactAddressResp[] contactAddressRespArr) {
        d.a(this.f8062d, String.format(Locale.getDefault(), "【离线NAB checknab查询结果通知】 java_CheckNABOffline lResult[%d] sessionID[%s] accountId[%s] contactNum[%d] currentThread[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(i2), Thread.currentThread().getName()));
        OfflineNabCallbackInfo offlineNabCallbackInfo = new OfflineNabCallbackInfo();
        offlineNabCallbackInfo.setSessionID(str);
        if (contactAddressRespArr == null || i2 != contactAddressRespArr.length) {
            d.d(this.f8062d, "OcxEventCallBack.java_CheckNABOffline get null ContactAddressResp or contactNum wrong!");
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(contactAddressRespArr[i3]);
            }
            offlineNabCallbackInfo.setAddressInfoList(arrayList);
            offlineNabCallbackInfo.setContactNum(i2);
        }
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = offlineNabCallbackInfo;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.h.c.a
    public void b(String str, int i, OfflineContactInfo offlineContactInfo) {
        String accountid = offlineContactInfo.getAccountid();
        String userpassword = offlineContactInfo.getUserpassword();
        String contactid = offlineContactInfo.getContactid();
        String iconFile = offlineContactInfo.getIconFile();
        String address = offlineContactInfo.getAddress();
        String birthDate = offlineContactInfo.getBirthDate();
        String displayAttrValue = offlineContactInfo.getDisplayAttrValue();
        String duty = offlineContactInfo.getDuty();
        String email = offlineContactInfo.getEmail();
        String etag = offlineContactInfo.getEtag();
        String firstLetter = offlineContactInfo.getFirstLetter();
        String mobileId = offlineContactInfo.getMobileId();
        String name = offlineContactInfo.getName();
        String nickName = offlineContactInfo.getNickName();
        String officeAddr = offlineContactInfo.getOfficeAddr();
        String spellName = offlineContactInfo.getSpellName();
        StringBuilder sb = new StringBuilder();
        sb.append((int) offlineContactInfo.getRcsflag());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((int) offlineContactInfo.getAbility());
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) offlineContactInfo.getCommonflag());
        d.a(this.f8062d, String.format(Locale.getDefault(), "【离线NAB删除Contact结果通知】 java_deleteOfflineContactAddress  lResult[%d] sessionID[%s] accountId[%s] pass[%s] contactid[%s] icon[%s] rcsflag[%s] ability[%s] commonflag[%s] address[%s] birthdate[%s] displayAttrValue[%s] duty[%s] email[%s] etag[%s]  firstLetter[%s] mobileId[%s] name[%s] nickName[%s] officeAddr[%s] spellName[%s] tel[%s] officetel[%s] hometel[%s] currentThread[%s]", Integer.valueOf(i), str, accountid, userpassword, contactid, iconFile, sb2, sb4, sb5.toString(), address, birthDate, displayAttrValue, duty, email, etag, firstLetter, mobileId, name, nickName, officeAddr, spellName, offlineContactInfo.getTel(), offlineContactInfo.getOfficetel(), offlineContactInfo.getHometel(), Thread.currentThread().getName()));
        OfflineNabCallbackInfo offlineNabCallbackInfo = new OfflineNabCallbackInfo();
        offlineNabCallbackInfo.setSessionID(str);
        offlineNabCallbackInfo.setOfflineContactInfo(offlineContactInfo);
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = offlineNabCallbackInfo;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.h.c.a
    public void c(String str, int i, OfflineContactInfo offlineContactInfo) {
        String accountid = offlineContactInfo.getAccountid();
        String userpassword = offlineContactInfo.getUserpassword();
        String contactid = offlineContactInfo.getContactid();
        String iconFile = offlineContactInfo.getIconFile();
        String address = offlineContactInfo.getAddress();
        String birthDate = offlineContactInfo.getBirthDate();
        String displayAttrValue = offlineContactInfo.getDisplayAttrValue();
        String duty = offlineContactInfo.getDuty();
        String email = offlineContactInfo.getEmail();
        String etag = offlineContactInfo.getEtag();
        String firstLetter = offlineContactInfo.getFirstLetter();
        String mobileId = offlineContactInfo.getMobileId();
        String name = offlineContactInfo.getName();
        String nickName = offlineContactInfo.getNickName();
        String officeAddr = offlineContactInfo.getOfficeAddr();
        String spellName = offlineContactInfo.getSpellName();
        StringBuilder sb = new StringBuilder();
        sb.append((int) offlineContactInfo.getRcsflag());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((int) offlineContactInfo.getAbility());
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) offlineContactInfo.getCommonflag());
        d.a(this.f8062d, String.format(Locale.getDefault(), "【离线NAB增加Contact结果通知】 java_addOfflineContactAddress  lResult[%d] sessionID[%s] accountId[%s] pass[%s] contactid[%s] icon[%s] rcsflag[%s] ability[%s] commonflag[%s] address[%s] birthdate[%s] displayAttrValue[%s] duty[%s] email[%s] etag[%s]  firstLetter[%s] mobileId[%s] name[%s] nickName[%s] officeAddr[%s] spellName[%s] tel[%s] officetel[%s] hometel[%s] currentThread[%s]", Integer.valueOf(i), str, accountid, userpassword, contactid, iconFile, sb2, sb4, sb5.toString(), address, birthDate, displayAttrValue, duty, email, etag, firstLetter, mobileId, name, nickName, officeAddr, spellName, offlineContactInfo.getTel(), offlineContactInfo.getOfficetel(), offlineContactInfo.getHometel(), Thread.currentThread().getName()));
        OfflineNabCallbackInfo offlineNabCallbackInfo = new OfflineNabCallbackInfo();
        offlineNabCallbackInfo.setSessionID(str);
        offlineNabCallbackInfo.setOfflineContactInfo(offlineContactInfo);
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = offlineNabCallbackInfo;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }
}
