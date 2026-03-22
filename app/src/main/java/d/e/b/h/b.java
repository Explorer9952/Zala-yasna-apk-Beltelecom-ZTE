package d.e.b.h;

import android.os.Message;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressResp;
import com.zte.ucs.tvcall.ocx.nab.ContactBaseInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactCallbackInfo;
import com.zte.ucs.tvcall.ocx.nab.LoadNabContactBaseResp;
import com.zte.ucs.tvcall.ocx.nab.NabCallbackInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileCallbackInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileResp;
import com.zte.ucs.tvcall.ocx.nab.UploadNabContactBaseResp;
import com.zte.ucs.tvcall.ocx.nab.UserPrefsInfo;
import com.zte.ucs.tvcall.ocx.nab.UserPrefsResp;
import d.e.b.n.d;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.a implements a {
    private final String g = b.class.getName();

    @Override // d.e.b.h.a
    public void a(int i, String str, int i2, ProfileInfo profileInfo, String str2) {
        Message obtain;
        String accountid = profileInfo.getAccountid();
        String firstname = profileInfo.getFirstname();
        String familyname = profileInfo.getFamilyname();
        String addr = profileInfo.getAddr();
        String uri = profileInfo.getUri();
        String tel = profileInfo.getTel();
        String officetel = profileInfo.getOfficetel();
        String birthdate = profileInfo.getBirthdate();
        String officeaddr = profileInfo.getOfficeaddr();
        String employer = profileInfo.getEmployer();
        String duty = profileInfo.getDuty();
        String email = profileInfo.getEmail();
        String icon = profileInfo.getIcon();
        String etag = profileInfo.getEtag();
        String signature = profileInfo.getSignature();
        String area = profileInfo.getArea();
        byte gender = profileInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB搜索Profile结果通知】 java_searchProfile lResult[%d] sessionID[%s] opertype[%d] accountId[%s] firstname[%s] familyname[%s] addr[%s] uri[%s]  tel[%s] officetel[%s] birthdate[%s] officeaddr[%s] employer[%s] duty[%s] email[%s] icon[%s] etag[%s] signature[%s] area[%s] gender[%d] userpassword[%s] eContactBaseTag[%s] ", Integer.valueOf(i2), str, Integer.valueOf(i), accountid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, etag, signature, area, Byte.valueOf(gender), profileInfo.getUserpassword(), profileInfo.geteContactBaseTag()));
        ContactCallbackInfo contactCallbackInfo = new ContactCallbackInfo();
        contactCallbackInfo.setOpertype(i);
        contactCallbackInfo.setSessionID(str);
        contactCallbackInfo.setlResult(i2);
        ContactAddressInfo contactAddressInfo = new ContactAddressInfo();
        contactAddressInfo.setContactid(profileInfo.getAccountid());
        contactAddressInfo.setEtag(profileInfo.getEtag());
        contactAddressInfo.setAccountid(str2);
        contactAddressInfo.setAddr(profileInfo.getAddr());
        contactAddressInfo.setBirthdate(profileInfo.getBirthdate());
        contactAddressInfo.setDuty(profileInfo.getDuty());
        contactAddressInfo.setEmail(profileInfo.getEmail());
        contactAddressInfo.setEmployer(profileInfo.getEmployer());
        contactAddressInfo.setFamilyname(profileInfo.getFamilyname());
        contactAddressInfo.setFirstname(profileInfo.getFirstname());
        contactAddressInfo.setIcon(profileInfo.getIcon());
        contactAddressInfo.setOfficeaddr(profileInfo.getOfficeaddr());
        contactAddressInfo.setOfficetel(profileInfo.getOfficetel());
        contactAddressInfo.setTel(profileInfo.getTel());
        contactAddressInfo.setUri(profileInfo.getUri());
        contactAddressInfo.setGender(profileInfo.getGender());
        contactAddressInfo.setSignature(profileInfo.getSignature());
        contactAddressInfo.setArea(profileInfo.getArea());
        contactCallbackInfo.setOpertype(i);
        contactCallbackInfo.setContactAddressInfo(contactAddressInfo);
        if (i2 == 0) {
            obtain = Message.obtain();
            obtain.what = 8;
        } else {
            obtain = Message.obtain();
            obtain.what = 9;
        }
        obtain.obj = contactCallbackInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void a(int i, String str, int i2, String str2, String str3) {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i2);
        d.a(this.g, String.format(locale, "【联系人base信息-上传执行通知】 java_AddNabContactBase sessionID[%s], opertype[%s] lResult[%s] accountid[%s] etag[%s]", str, sb.toString(), sb2.toString(), str2, str3));
        Message obtain = Message.obtain();
        UploadNabContactBaseResp uploadNabContactBaseResp = new UploadNabContactBaseResp();
        uploadNabContactBaseResp.setSessionid(str);
        uploadNabContactBaseResp.setOpertype(i);
        uploadNabContactBaseResp.setResult(i2);
        uploadNabContactBaseResp.setAccountid(str2);
        uploadNabContactBaseResp.setEtag(str3);
        obtain.obj = uploadNabContactBaseResp;
        obtain.what = i2 == 0 ? 8195 : 8196;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void a(String str, int i, ContactAddressInfo contactAddressInfo) {
        d.a(this.g, String.format(Locale.getDefault(), "【NAB查询Contact结果通知】 java_queryContactAddress lResult[%d] sessionID[%s] accountId[%s] contactid[%s]  firstname[%s] familyname[%s] addr[%s]  uri[%s] tel[%s] officetel[%s] birthdate[%s] officeaddr[%s]  employer[%s] duty[%s]  email[%s] icon[%s] markname[%s]  area[%s] gender[%d]  signature[%s] etag[%s] userpassword[%s]  rcsflag[%d]  commonflag[%d]  currentThread[%s] ", Integer.valueOf(i), str, contactAddressInfo.getAccountid(), contactAddressInfo.getContactid(), contactAddressInfo.getFirstname(), contactAddressInfo.getFamilyname(), contactAddressInfo.getAddr(), contactAddressInfo.getUri(), contactAddressInfo.getTel(), contactAddressInfo.getOfficetel(), contactAddressInfo.getBirthdate(), contactAddressInfo.getOfficeaddr(), contactAddressInfo.getEmployer(), contactAddressInfo.getDuty(), contactAddressInfo.getEmail(), contactAddressInfo.getIcon(), contactAddressInfo.getMarkname(), contactAddressInfo.getArea(), Byte.valueOf(contactAddressInfo.getGender()), contactAddressInfo.getSignature(), contactAddressInfo.getEtag(), contactAddressInfo.getUserpassword(), Byte.valueOf(contactAddressInfo.getRcsflag()), Byte.valueOf(contactAddressInfo.getCommonflag()), Thread.currentThread().getName()));
        ContactCallbackInfo contactCallbackInfo = new ContactCallbackInfo();
        contactCallbackInfo.setSessionID(str);
        contactCallbackInfo.setContactAddressInfo(contactAddressInfo);
        Message obtain = Message.obtain();
        obtain.what = i == 0 ? 4113 : 4114;
        obtain.obj = contactCallbackInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void a(String str, int i, ProfileInfo profileInfo) {
        String accountid = profileInfo.getAccountid();
        String firstname = profileInfo.getFirstname();
        String familyname = profileInfo.getFamilyname();
        String addr = profileInfo.getAddr();
        String uri = profileInfo.getUri();
        String tel = profileInfo.getTel();
        String officetel = profileInfo.getOfficetel();
        String birthdate = profileInfo.getBirthdate();
        String officeaddr = profileInfo.getOfficeaddr();
        String employer = profileInfo.getEmployer();
        String duty = profileInfo.getDuty();
        String email = profileInfo.getEmail();
        String icon = profileInfo.getIcon();
        String etag = profileInfo.getEtag();
        String signature = profileInfo.getSignature();
        String area = profileInfo.getArea();
        byte gender = profileInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB删除Profile结果通知】 java_deleteProfile lResult[%d] sessionID[%s] accountId[%s] firstname[%s] familyname[%s] addr[%s] uri[%s]  tel[%s] officetel[%s] birthdate[%s] officeaddr[%s] employer[%s] duty[%s] email[%s] icon[%s] etag[%s] signature[%s] area[%s] gender[%d] userpassword[%s] eContactBaseTag[%s] ", Integer.valueOf(i), str, accountid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, etag, signature, area, Byte.valueOf(gender), profileInfo.getUserpassword(), profileInfo.geteContactBaseTag()));
        ProfileCallbackInfo profileCallbackInfo = new ProfileCallbackInfo();
        profileCallbackInfo.setSessionID(str);
        profileCallbackInfo.setProfileInfo(profileInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 4;
        } else {
            obtain.what = 5;
        }
        obtain.obj = profileCallbackInfo;
        g().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void a(String str, int i, String str2, ProfileResp profileResp, UserPrefsResp userPrefsResp, int i2, int i3, int i4, ContactAddressResp[] contactAddressRespArr) {
        d.a(this.g, String.format(Locale.getDefault(), "【NAB查询服务端结果通知】 java_checkNAB lResult[%d] sessionID[%s] accountId[%s] contactpackage[%d] currentpackage[%d] contactNum[%d]  PstrAddr[%s] PeTag[%s] PeContactBaseTag[%s] UstrAddr[%s] UeTag[%s] currentThread[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), profileResp.getStrAddr(), profileResp.geteTag(), profileResp.geteContactBaseTag(), userPrefsResp.getStrAddr(), userPrefsResp.geteTag(), Thread.currentThread().getName()));
        ProfileInfo profileInfo = new ProfileInfo();
        profileInfo.setAccountid(str2);
        profileInfo.setEtag(profileResp.geteTag());
        profileInfo.seteContactBaseTag(profileResp.geteContactBaseTag());
        UserPrefsInfo userPrefsInfo = new UserPrefsInfo();
        userPrefsInfo.setAccountid(str2);
        userPrefsInfo.setEtag(userPrefsResp.geteTag());
        ArrayList arrayList = new ArrayList();
        if (contactAddressRespArr != null && i4 == contactAddressRespArr.length) {
            for (int i5 = 0; i5 < i4; i5++) {
                ContactAddressResp contactAddressResp = contactAddressRespArr[i5];
                ContactAddressInfo contactAddressInfo = new ContactAddressInfo();
                contactAddressInfo.setContactid(contactAddressResp.getFriendAddr());
                contactAddressInfo.setAccountid(str2);
                contactAddressInfo.setEtag(contactAddressResp.geteTag());
                arrayList.add(contactAddressInfo);
            }
        }
        NabCallbackInfo nabCallbackInfo = new NabCallbackInfo();
        nabCallbackInfo.setSessionID(str);
        nabCallbackInfo.setProfileInfo(profileInfo);
        nabCallbackInfo.setUserPrefsInfo(userPrefsInfo);
        nabCallbackInfo.setAddressInfoList(arrayList);
        nabCallbackInfo.setContactpackage(i2);
        nabCallbackInfo.setCurrentpackage(i3);
        nabCallbackInfo.setContactNum(i4);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 0;
        } else {
            obtain.what = 1;
            obtain.arg1 = i;
        }
        obtain.obj = nabCallbackInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void a(String str, int i, String str2, String str3, int i2, ContactBaseInfo[] contactBaseInfoArr) {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i2);
        d.a(this.g, String.format(locale, "【联系人base信息-下载执行通知】 java_QueryNabContactBase sessionID[%s], lResult[%s] accountid[%s] etag[%s] totalNum[%s]", str, sb.toString(), str2, str3, sb2.toString()));
        Message obtain = Message.obtain();
        LoadNabContactBaseResp loadNabContactBaseResp = new LoadNabContactBaseResp();
        loadNabContactBaseResp.setSessionid(str);
        loadNabContactBaseResp.setResult(i);
        loadNabContactBaseResp.setAccountid(str2);
        loadNabContactBaseResp.setEtag(str3);
        if (contactBaseInfoArr != null) {
            for (ContactBaseInfo contactBaseInfo : contactBaseInfoArr) {
                loadNabContactBaseResp.getContactBaseInfoList().add(contactBaseInfo);
            }
        }
        obtain.obj = loadNabContactBaseResp;
        obtain.what = i == 0 ? 8193 : 8194;
        e().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void b(String str, int i, ContactAddressInfo contactAddressInfo) {
        String accountid = contactAddressInfo.getAccountid();
        String contactid = contactAddressInfo.getContactid();
        String firstname = contactAddressInfo.getFirstname();
        String familyname = contactAddressInfo.getFamilyname();
        String addr = contactAddressInfo.getAddr();
        String uri = contactAddressInfo.getUri();
        String tel = contactAddressInfo.getTel();
        String officetel = contactAddressInfo.getOfficetel();
        String birthdate = contactAddressInfo.getBirthdate();
        String officeaddr = contactAddressInfo.getOfficeaddr();
        String employer = contactAddressInfo.getEmployer();
        String duty = contactAddressInfo.getDuty();
        String email = contactAddressInfo.getEmail();
        String icon = contactAddressInfo.getIcon();
        String markname = contactAddressInfo.getMarkname();
        String area = contactAddressInfo.getArea();
        byte gender = contactAddressInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB增加Contact结果通知】 java_addContactAddress lResult[%d] sessionID[%s] accountId[%s] contactid[%s]  firstname[%s] familyname[%s] addr[%s]  uri[%s] tel[%s] officetel[%s] birthdate[%s] officeaddr[%s]  employer[%s] duty[%s]  email[%s] icon[%s] markname[%s]  area[%s] gender[%d]  signature[%s] etag[%s] userpassword[%s]  rcsflag[%d]  commonflag[%d]  currentThread[%s] ", Integer.valueOf(i), str, accountid, contactid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, markname, area, Byte.valueOf(gender), contactAddressInfo.getSignature(), contactAddressInfo.getEtag(), contactAddressInfo.getUserpassword(), Byte.valueOf(contactAddressInfo.getRcsflag()), Byte.valueOf(contactAddressInfo.getCommonflag()), Thread.currentThread().getName()));
        ContactCallbackInfo contactCallbackInfo = new ContactCallbackInfo();
        contactCallbackInfo.setSessionID(str);
        contactCallbackInfo.setContactAddressInfo(contactAddressInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 0;
        } else {
            obtain.what = 1;
        }
        obtain.obj = contactCallbackInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void b(String str, int i, ProfileInfo profileInfo) {
        String accountid = profileInfo.getAccountid();
        String firstname = profileInfo.getFirstname();
        String familyname = profileInfo.getFamilyname();
        String addr = profileInfo.getAddr();
        String uri = profileInfo.getUri();
        String tel = profileInfo.getTel();
        String officetel = profileInfo.getOfficetel();
        String birthdate = profileInfo.getBirthdate();
        String officeaddr = profileInfo.getOfficeaddr();
        String employer = profileInfo.getEmployer();
        String duty = profileInfo.getDuty();
        String email = profileInfo.getEmail();
        String icon = profileInfo.getIcon();
        String etag = profileInfo.getEtag();
        String signature = profileInfo.getSignature();
        String area = profileInfo.getArea();
        byte gender = profileInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB查询Profile结果通知】 java_queryProfile lResult[%d] sessionID[%s] accountId[%s] firstname[%s] familyname[%s] addr[%s] uri[%s]  tel[%s] officetel[%s] birthdate[%s] officeaddr[%s] employer[%s] duty[%s] email[%s] icon[%s] etag[%s] signature[%s] area[%s] gender[%d] userpassword[%s] eContactBaseTag[%s] ", Integer.valueOf(i), str, accountid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, etag, signature, area, Byte.valueOf(gender), profileInfo.getUserpassword(), profileInfo.geteContactBaseTag()));
        ProfileCallbackInfo profileCallbackInfo = new ProfileCallbackInfo();
        profileCallbackInfo.setSessionID(str);
        profileCallbackInfo.setProfileInfo(profileInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 6;
        } else {
            obtain.what = 7;
        }
        obtain.obj = profileCallbackInfo;
        g().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void c(String str, int i, ContactAddressInfo contactAddressInfo) {
        String accountid = contactAddressInfo.getAccountid();
        String contactid = contactAddressInfo.getContactid();
        String firstname = contactAddressInfo.getFirstname();
        String familyname = contactAddressInfo.getFamilyname();
        String addr = contactAddressInfo.getAddr();
        String uri = contactAddressInfo.getUri();
        String tel = contactAddressInfo.getTel();
        String officetel = contactAddressInfo.getOfficetel();
        String birthdate = contactAddressInfo.getBirthdate();
        String officeaddr = contactAddressInfo.getOfficeaddr();
        String employer = contactAddressInfo.getEmployer();
        String duty = contactAddressInfo.getDuty();
        String email = contactAddressInfo.getEmail();
        String icon = contactAddressInfo.getIcon();
        String markname = contactAddressInfo.getMarkname();
        String area = contactAddressInfo.getArea();
        byte gender = contactAddressInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB搜索Contact结果通知】 java_searchContactAddress lResult[%d] sessionID[%s] accountId[%s] contactid[%s]  firstname[%s] familyname[%s] addr[%s]  uri[%s] tel[%s] officetel[%s] birthdate[%s] officeaddr[%s]  employer[%s] duty[%s]  email[%s] icon[%s] markname[%s]  area[%s] gender[%d]  signature[%s] etag[%s] userpassword[%s]  rcsflag[%d]  commonflag[%d]  currentThread[%s] ", Integer.valueOf(i), str, accountid, contactid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, markname, area, Byte.valueOf(gender), contactAddressInfo.getSignature(), contactAddressInfo.getEtag(), contactAddressInfo.getUserpassword(), Byte.valueOf(contactAddressInfo.getRcsflag()), Byte.valueOf(contactAddressInfo.getCommonflag()), Thread.currentThread().getName()));
        ContactCallbackInfo contactCallbackInfo = new ContactCallbackInfo();
        contactCallbackInfo.setSessionID(str);
        contactCallbackInfo.setContactAddressInfo(contactAddressInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 8;
        } else {
            obtain.what = 9;
        }
        obtain.obj = contactCallbackInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void c(String str, int i, ProfileInfo profileInfo) {
        String accountid = profileInfo.getAccountid();
        String firstname = profileInfo.getFirstname();
        String familyname = profileInfo.getFamilyname();
        String addr = profileInfo.getAddr();
        String uri = profileInfo.getUri();
        String tel = profileInfo.getTel();
        String officetel = profileInfo.getOfficetel();
        String birthdate = profileInfo.getBirthdate();
        String officeaddr = profileInfo.getOfficeaddr();
        String employer = profileInfo.getEmployer();
        String duty = profileInfo.getDuty();
        String email = profileInfo.getEmail();
        String icon = profileInfo.getIcon();
        String etag = profileInfo.getEtag();
        String signature = profileInfo.getSignature();
        String area = profileInfo.getArea();
        byte gender = profileInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB增加Profile结果通知】 java_addProfile lResult[%d] sessionID[%s] accountId[%s] firstname[%s] familyname[%s] addr[%s] uri[%s]  tel[%s] officetel[%s] birthdate[%s] officeaddr[%s] employer[%s] duty[%s] email[%s] icon[%s] etag[%s] signature[%s] area[%s] gender[%d] userpassword[%s] eContactBaseTag[%s] ", Integer.valueOf(i), str, accountid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, etag, signature, area, Byte.valueOf(gender), profileInfo.getUserpassword(), profileInfo.geteContactBaseTag()));
        ProfileCallbackInfo profileCallbackInfo = new ProfileCallbackInfo();
        profileCallbackInfo.setSessionID(str);
        profileCallbackInfo.setProfileInfo(profileInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 0;
        } else {
            obtain.what = 1;
        }
        obtain.obj = profileCallbackInfo;
        g().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void c(String str, int i, String str2, String str3) {
        d.a(this.g, String.format(Locale.getDefault(), "【联系人base信息-删除通知】 java_DelNabContactBase sessionID[%s] lResult[%d] accountid[%s] etag[%s]", str, Integer.valueOf(i), str2, str3));
    }

    @Override // d.e.b.h.a
    public void d(String str, int i, ContactAddressInfo contactAddressInfo) {
        String accountid = contactAddressInfo.getAccountid();
        String contactid = contactAddressInfo.getContactid();
        String firstname = contactAddressInfo.getFirstname();
        String familyname = contactAddressInfo.getFamilyname();
        String addr = contactAddressInfo.getAddr();
        String uri = contactAddressInfo.getUri();
        String tel = contactAddressInfo.getTel();
        String officetel = contactAddressInfo.getOfficetel();
        String birthdate = contactAddressInfo.getBirthdate();
        String officeaddr = contactAddressInfo.getOfficeaddr();
        String employer = contactAddressInfo.getEmployer();
        String duty = contactAddressInfo.getDuty();
        String email = contactAddressInfo.getEmail();
        String icon = contactAddressInfo.getIcon();
        String markname = contactAddressInfo.getMarkname();
        String area = contactAddressInfo.getArea();
        byte gender = contactAddressInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB删除Contact结果通知】 java_deleteContactAddress lResult[%d] sessionID[%s] accountId[%s] contactid[%s]  firstname[%s] familyname[%s] addr[%s]  uri[%s] tel[%s] officetel[%s] birthdate[%s] officeaddr[%s]  employer[%s] duty[%s]  email[%s] icon[%s] markname[%s]  area[%s] gender[%d]  signature[%s] etag[%s] userpassword[%s]  rcsflag[%d]  commonflag[%d]  currentThread[%s] ", Integer.valueOf(i), str, accountid, contactid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, markname, area, Byte.valueOf(gender), contactAddressInfo.getSignature(), contactAddressInfo.getEtag(), contactAddressInfo.getUserpassword(), Byte.valueOf(contactAddressInfo.getRcsflag()), Byte.valueOf(contactAddressInfo.getCommonflag()), Thread.currentThread().getName()));
        ContactCallbackInfo contactCallbackInfo = new ContactCallbackInfo();
        contactCallbackInfo.setSessionID(str);
        contactCallbackInfo.setContactAddressInfo(contactAddressInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 4;
        } else {
            obtain.what = 5;
        }
        obtain.obj = contactCallbackInfo;
        f().sendMessage(obtain);
    }

    @Override // d.e.b.h.a
    public void d(String str, int i, ProfileInfo profileInfo) {
        String accountid = profileInfo.getAccountid();
        String firstname = profileInfo.getFirstname();
        String familyname = profileInfo.getFamilyname();
        String addr = profileInfo.getAddr();
        String uri = profileInfo.getUri();
        String tel = profileInfo.getTel();
        String officetel = profileInfo.getOfficetel();
        String birthdate = profileInfo.getBirthdate();
        String officeaddr = profileInfo.getOfficeaddr();
        String employer = profileInfo.getEmployer();
        String duty = profileInfo.getDuty();
        String email = profileInfo.getEmail();
        String icon = profileInfo.getIcon();
        String etag = profileInfo.getEtag();
        String signature = profileInfo.getSignature();
        String area = profileInfo.getArea();
        byte gender = profileInfo.getGender();
        d.a(this.g, String.format(Locale.getDefault(), "【NAB更新Profile结果通知】 java_updateProfile lResult[%d] sessionID[%s] accountId[%s] firstname[%s] familyname[%s] addr[%s] uri[%s]  tel[%s] officetel[%s] birthdate[%s] officeaddr[%s] employer[%s] duty[%s] email[%s] icon[%s] etag[%s] signature[%s] area[%s] gender[%d] userpassword[%s] eContactBaseTag[%s] ", Integer.valueOf(i), str, accountid, firstname, familyname, addr, uri, tel, officetel, birthdate, officeaddr, employer, duty, email, icon, etag, signature, area, Byte.valueOf(gender), profileInfo.getUserpassword(), profileInfo.geteContactBaseTag()));
        ProfileCallbackInfo profileCallbackInfo = new ProfileCallbackInfo();
        profileCallbackInfo.setSessionID(str);
        profileCallbackInfo.setProfileInfo(profileInfo);
        Message obtain = Message.obtain();
        if (i == 0) {
            obtain.what = 2;
        } else {
            obtain.what = 3;
        }
        obtain.obj = profileCallbackInfo;
        g().sendMessage(obtain);
    }
}
