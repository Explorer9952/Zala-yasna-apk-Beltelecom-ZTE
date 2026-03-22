package d.e.b.i;

import android.os.Bundle;
import android.os.Message;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson;
import com.picovr.picovrlib.JoyEvent;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstCallingSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstCompareDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstContactInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstContactNodeInDirectory;
import com.zte.ucs.tvcall.ocx.nabst.NabstContactsSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstExtendSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstGetDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGroupMsgDndListOperationResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGroupMsgDndSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLocalEtagSynNotify;
import com.zte.ucs.tvcall.ocx.nabst.NabstMessageSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstMsgDndSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstMsgReminderSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstPersonAddressInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstPersonNameInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstPersonTelInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstSingMsgDndListOperationResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstSingMsgDndSettingInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactAddressResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactBirthdayResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactCommAddrResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactGroupInfoResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNameResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNoteResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactOrgNameResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserCallingSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserContactsSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserExtendSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgDndSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgNotifySettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgPlayModSettingResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgReminSettingResp;
import d.e.b.i.c.j;
import d.e.b.i.c.k;
import d.e.b.i.c.l;
import d.e.b.i.c.m;
import d.e.b.i.c.n;
import d.e.b.i.d.c;
import d.e.b.i.d.e;
import d.e.b.i.d.f;
import d.e.b.i.d.g;
import d.e.b.i.d.h;
import d.e.b.i.d.i;
import d.e.b.i.d.o;
import d.e.b.i.d.p;
import d.e.b.i.d.q;
import d.e.b.i.d.r;
import d.e.b.i.d.s;
import d.e.b.i.d.t;
import d.e.b.i.d.u;
import d.e.b.i.d.v;
import d.e.b.i.d.w;
import d.e.b.i.d.x;
import d.e.b.i.d.y;
import d.e.b.i.d.z;
import d.e.b.n.d;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8063d = b.class.getName();

    private static Message a(int i, int i2, String str, int i3, Object obj) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, i);
        bundle.putInt(ResultInfo.KEY_errorCode, i2);
        bundle.putString(ResultInfo.KEY_errorReason, str);
        obtain.setData(bundle);
        obtain.what = i3;
        obtain.obj = obj;
        return obtain;
    }

    @Override // d.e.b.i.a
    public void a(NabstAddContactResp nabstAddContactResp) {
        String json = new Gson().toJson(nabstAddContactResp);
        d.a(this.f8063d, "【nabst-添加联系人的回调】 java_NabstAddContact " + json);
        d.e.b.i.d.a aVar = new d.e.b.i.d.a();
        aVar.c(nabstAddContactResp.getSessionID());
        aVar.a(nabstAddContactResp.getAccountid());
        aVar.b(nabstAddContactResp.getContactid());
        ResultInfo resultInfo = nabstAddContactResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65552, aVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstAddUserPrefResp nabstAddUserPrefResp) {
        String json = new Gson().toJson(nabstAddUserPrefResp);
        d.a(this.f8063d, "【nabst-个人配置文件添加回调】 java_NabstAddUserPref " + json);
        d.e.b.i.d.b bVar = new d.e.b.i.d.b();
        bVar.b(nabstAddUserPrefResp.getSessionID());
        bVar.a(nabstAddUserPrefResp.getAccountid());
        ResultInfo resultInfo = nabstAddUserPrefResp.gettResultInfo();
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65539, bVar);
        a2.arg1 = nabstAddUserPrefResp.getIsInnerOper();
        c().sendMessage(a2);
    }

    @Override // d.e.b.i.a
    public void a(NabstCompareDirectoryResp nabstCompareDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr) {
        ResultInfo resultInfo = nabstCompareDirectoryResp.gettResultInfo();
        String json = new Gson().toJson(nabstCompareDirectoryResp);
        d.a(this.f8063d, "【nabst-版本比较的结果回调】 java_NabstCompareDirectory " + json);
        c cVar = new c();
        cVar.b(nabstCompareDirectoryResp.getSessionID());
        cVar.a(nabstCompareDirectoryResp.getAccountid());
        cVar.a(nabstCompareDirectoryResp.getNabEtag());
        cVar.b(nabstCompareDirectoryResp.getPccchangedType());
        cVar.c(nabstCompareDirectoryResp.getUserperfchangedType());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nabstCompareDirectoryResp.getContactsCount(); i++) {
            d.e.b.i.c.c cVar2 = new d.e.b.i.c.c();
            String contactid = nabstContactNodeInDirectoryArr[i].getContactid();
            byte changedType = nabstContactNodeInDirectoryArr[i].getChangedType();
            int i2 = nabstContactNodeInDirectoryArr[i].geteTag();
            cVar2.a(contactid);
            cVar2.a(changedType);
            cVar2.a(i2);
            arrayList.add(cVar2);
        }
        cVar.a(arrayList);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65538, cVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstDeleteContactResp nabstDeleteContactResp) {
        String json = new Gson().toJson(nabstDeleteContactResp);
        d.a(this.f8063d, "【nabst-删除联系人文件的回调】 java_NabstDeleteContact " + json);
        d.e.b.i.d.d dVar = new d.e.b.i.d.d();
        dVar.c(nabstDeleteContactResp.getSessionID());
        dVar.a(nabstDeleteContactResp.getAccountid());
        dVar.b(nabstDeleteContactResp.getContactid());
        ResultInfo resultInfo = nabstDeleteContactResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65554, dVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstDeleteUserPrefResp nabstDeleteUserPrefResp) {
        String json = new Gson().toJson(nabstDeleteUserPrefResp);
        d.a(this.f8063d, "【nabst-个人配置文件删除回调】 java_NabstDeleteUserPref" + json);
        e eVar = new e();
        eVar.b(nabstDeleteUserPrefResp.getSessionID());
        eVar.a(nabstDeleteUserPrefResp.getAccountid());
        ResultInfo resultInfo = nabstDeleteUserPrefResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY, eVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstGetDirectoryResp nabstGetDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr) {
        ResultInfo resultInfo = nabstGetDirectoryResp.gettResultInfo();
        String json = new Gson().toJson(nabstGetDirectoryResp);
        d.a(this.f8063d, "【nabst-获取地址本结果回调】 java_NabstGetDirectory " + json);
        f fVar = new f();
        fVar.b(nabstGetDirectoryResp.getSessionID());
        fVar.a(nabstGetDirectoryResp.getAccountid());
        fVar.a(nabstGetDirectoryResp.getNabEtag());
        fVar.a(nabstGetDirectoryResp.getActionMode());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nabstGetDirectoryResp.getContactsCount(); i++) {
            d.e.b.i.c.c cVar = new d.e.b.i.c.c();
            String contactid = nabstContactNodeInDirectoryArr[i].getContactid();
            byte changedType = nabstContactNodeInDirectoryArr[i].getChangedType();
            int i2 = nabstContactNodeInDirectoryArr[i].geteTag();
            cVar.a(contactid);
            cVar.a(changedType);
            cVar.a(i2);
            arrayList.add(cVar);
            d.a(this.f8063d, String.format(Locale.getDefault(), "【联系人信息】contactList :accountid[%s] changedType[%d]tag[%d]", contactid, Integer.valueOf(changedType), Integer.valueOf(i2)));
        }
        fVar.a(arrayList);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, fVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstGroupMsgDndListOperationResp nabstGroupMsgDndListOperationResp) {
        String json = new Gson().toJson(nabstGroupMsgDndListOperationResp);
        d.a(this.f8063d, "【nabst-修改群消息免打扰列表设置回调】 java_NabstGroupMsgDndListOperation " + json);
        g gVar = new g();
        gVar.b(nabstGroupMsgDndListOperationResp.getSessionID());
        gVar.a(nabstGroupMsgDndListOperationResp.getAccountid());
        ResultInfo resultInfo = nabstGroupMsgDndListOperationResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65549, gVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstLoadContactResp nabstLoadContactResp) {
        d.a(this.f8063d, "【nabst-下载联系人文件的回调】 java_NabstLoadContact " + new Gson().toJson(nabstLoadContactResp));
        h hVar = new h();
        hVar.b(nabstLoadContactResp.getSessionID());
        hVar.a(nabstLoadContactResp.getAccountid());
        NabstContactInfo nabstContactInfo = nabstLoadContactResp.gettContactInfo();
        NabstPersonNameInfo nabstPersonNameInfo = nabstContactInfo.gettName();
        k kVar = new k();
        String familyName = nabstPersonNameInfo.getFamilyName();
        String givenName = nabstPersonNameInfo.getGivenName();
        String middleName = nabstPersonNameInfo.getMiddleName();
        String title = nabstPersonNameInfo.getTitle();
        kVar.a(familyName);
        kVar.b(givenName);
        kVar.c(middleName);
        kVar.d(title);
        ArrayList arrayList = new ArrayList();
        if (nabstContactInfo.gettCommAddr().getTelCount() > 0) {
            for (NabstPersonTelInfo nabstPersonTelInfo : nabstContactInfo.gettCommAddr().getTelArray()) {
                l lVar = new l();
                byte rcsUser = nabstPersonTelInfo.getRcsUser();
                byte telType = nabstPersonTelInfo.getTelType();
                String telStr = nabstPersonTelInfo.getTelStr();
                lVar.a(rcsUser);
                lVar.b(telType);
                lVar.a(telStr);
                arrayList.add(lVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (nabstContactInfo.gettCommAddr().getEmailCount() > 0) {
            for (String str : nabstContactInfo.gettCommAddr().getEmail()) {
                arrayList2.add(str);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (nabstContactInfo.gettAddress().getAddressCount() > 0) {
            for (NabstPersonAddressInfo nabstPersonAddressInfo : nabstContactInfo.gettAddress().getAddressArray()) {
                j jVar = new j();
                String addressStr = nabstPersonAddressInfo.getAddressStr();
                byte addressType = nabstPersonAddressInfo.getAddressType();
                jVar.a(addressStr);
                jVar.a(addressType);
                arrayList3.add(jVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (nabstContactInfo.gettGroup().getGroupCount() > 0) {
            for (String str2 : nabstContactInfo.gettGroup().getGroupNameArray()) {
                arrayList4.add(str2);
            }
        }
        d.e.b.i.c.b bVar = new d.e.b.i.c.b();
        String birthday = nabstContactInfo.getBirthday();
        String contactid = nabstContactInfo.getContactid();
        String note = nabstContactInfo.getNote();
        String orgName = nabstContactInfo.getOrgName();
        bVar.a(birthday);
        bVar.b(contactid);
        bVar.c(note);
        bVar.d(orgName);
        bVar.a(kVar);
        bVar.d(arrayList);
        bVar.c(arrayList4);
        bVar.b(arrayList2);
        bVar.a(arrayList3);
        hVar.a(bVar);
        hVar.a(nabstLoadContactResp.getChangedType());
        ResultInfo resultInfo = nabstLoadContactResp.gettResultInfo();
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65553, hVar);
        a2.arg1 = nabstLoadContactResp.getIsInnerOper();
        c().sendMessage(a2);
    }

    @Override // d.e.b.i.a
    public void a(NabstLoadUserPrefResp nabstLoadUserPrefResp) {
        NabstSingMsgDndSettingInfo[] singleMsgDndArray;
        NabstGroupMsgDndSettingInfo[] groupMsgDndArray;
        String[] blackArray;
        d.a(this.f8063d, "【nabst-个人配置文件下载回调】 java_NabstLoadUserPref " + new Gson().toJson(nabstLoadUserPrefResp));
        i iVar = new i();
        m mVar = new m();
        d.e.b.i.c.a aVar = new d.e.b.i.c.a();
        d.e.b.i.c.d dVar = new d.e.b.i.c.d();
        d.e.b.i.c.e eVar = new d.e.b.i.c.e();
        d.e.b.i.c.g gVar = new d.e.b.i.c.g();
        NabstCallingSettingInfo callSettingInfo = nabstLoadUserPrefResp.gettUserSettingInfo().getCallSettingInfo();
        byte dialKeypadTone = callSettingInfo.getDialKeypadTone();
        byte dialKeypadVibration = callSettingInfo.getDialKeypadVibration();
        aVar.a(dialKeypadTone);
        aVar.b(dialKeypadVibration);
        mVar.a(aVar);
        NabstContactsSettingInfo contactsSettingInfo = nabstLoadUserPrefResp.gettUserSettingInfo().getContactsSettingInfo();
        byte autoBackupFlag = contactsSettingInfo.getAutoBackupFlag();
        byte autoBackupFreq = contactsSettingInfo.getAutoBackupFreq();
        byte autoBackupOnlyWifi = contactsSettingInfo.getAutoBackupOnlyWifi();
        dVar.a(autoBackupFlag);
        dVar.b(autoBackupFreq);
        dVar.c(autoBackupOnlyWifi);
        mVar.a(dVar);
        NabstExtendSettingInfo extendSettingInfo = nabstLoadUserPrefResp.gettUserSettingInfo().getExtendSettingInfo();
        byte disturbingblock = extendSettingInfo.getDisturbingblock();
        ArrayList arrayList = new ArrayList();
        if (extendSettingInfo.getBlackCount() > 0 && (blackArray = extendSettingInfo.getBlackArray()) != null) {
            for (String str : blackArray) {
                arrayList.add(str);
            }
        }
        eVar.a(disturbingblock);
        eVar.a(arrayList);
        mVar.a(eVar);
        NabstMessageSettingInfo messageSettingInfo = nabstLoadUserPrefResp.gettUserSettingInfo().getMessageSettingInfo();
        d.e.b.i.c.h hVar = new d.e.b.i.c.h();
        NabstMsgDndSettingInfo msgDndSettingInfo = messageSettingInfo.getMsgDndSettingInfo();
        byte messageDndFlag = msgDndSettingInfo.getMessageDndFlag();
        String messageDndTime = msgDndSettingInfo.getMessageDndTime();
        hVar.a(messageDndFlag);
        hVar.a(messageDndTime);
        gVar.a(hVar);
        d.e.b.i.c.i iVar2 = new d.e.b.i.c.i();
        NabstMsgReminderSettingInfo msgReminderSettingInfo = messageSettingInfo.getMsgReminderSettingInfo();
        byte viaVibration = msgReminderSettingInfo.getViaVibration();
        byte viaVoice = msgReminderSettingInfo.getViaVoice();
        iVar2.a(viaVibration);
        iVar2.b(viaVoice);
        gVar.a(iVar2);
        byte archive = messageSettingInfo.getArchive();
        byte teleReceiver = messageSettingInfo.getTeleReceiver();
        gVar.a(archive);
        gVar.b(teleReceiver);
        mVar.a(gVar);
        ArrayList arrayList2 = new ArrayList();
        d.a(this.f8063d, "群消息免打扰列表数:" + messageSettingInfo.getSingMsgDndCount());
        if (messageSettingInfo.getGroupMsgDndCount() > 0 && (groupMsgDndArray = messageSettingInfo.getGroupMsgDndArray()) != null) {
            for (NabstGroupMsgDndSettingInfo nabstGroupMsgDndSettingInfo : groupMsgDndArray) {
                d.e.b.i.c.f fVar = new d.e.b.i.c.f();
                byte flag = nabstGroupMsgDndSettingInfo.getFlag();
                String groupid = nabstGroupMsgDndSettingInfo.getGroupid();
                String groupName = nabstGroupMsgDndSettingInfo.getGroupName();
                fVar.a(flag);
                fVar.b(groupid);
                fVar.a(groupName);
                arrayList2.add(fVar);
            }
        }
        mVar.a(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        d.a(this.f8063d, "1v1消息免打扰列表数:" + messageSettingInfo.getSingMsgDndCount());
        if (messageSettingInfo.getSingMsgDndCount() > 0 && (singleMsgDndArray = messageSettingInfo.getSingleMsgDndArray()) != null) {
            for (NabstSingMsgDndSettingInfo nabstSingMsgDndSettingInfo : singleMsgDndArray) {
                n nVar = new n();
                byte flag2 = nabstSingMsgDndSettingInfo.getFlag();
                String contactid = nabstSingMsgDndSettingInfo.getContactid();
                nVar.a(flag2);
                nVar.a(contactid);
                arrayList3.add(nVar);
            }
        }
        mVar.b(arrayList3);
        mVar.a(nabstLoadUserPrefResp.gettUserSettingInfo().getIosdispmsg());
        iVar.b(nabstLoadUserPrefResp.getSessionID());
        iVar.a(nabstLoadUserPrefResp.getAccountid());
        iVar.a(mVar);
        iVar.a(nabstLoadUserPrefResp.getChangedType());
        ResultInfo resultInfo = nabstLoadUserPrefResp.gettResultInfo();
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65540, iVar);
        a2.arg1 = nabstLoadUserPrefResp.getIsInnerOper();
        c().sendMessage(a2);
    }

    @Override // d.e.b.i.a
    public void a(NabstLocalEtagSynNotify nabstLocalEtagSynNotify) {
        String json = new Gson().toJson(nabstLocalEtagSynNotify);
        d.a(this.f8063d, "【nabst-更改Etag的通知】 java_NabstLocalEtagSynNotify " + json);
        d.e.b.i.d.j jVar = new d.e.b.i.d.j();
        jVar.a(nabstLocalEtagSynNotify.getNabEtag());
        jVar.a(nabstLocalEtagSynNotify.getAccountid());
        Message message = new Message();
        message.obj = jVar;
        message.what = 0;
        c().sendMessage(message);
    }

    @Override // d.e.b.i.a
    public void a(NabstSingMsgDndListOperationResp nabstSingMsgDndListOperationResp) {
        String json = new Gson().toJson(nabstSingMsgDndListOperationResp);
        d.a(this.f8063d, "【nabst-修改一对一消息免打扰列表设置回调】 java_NabstSingMsgDndListOperation " + json);
        d.e.b.i.d.k kVar = new d.e.b.i.d.k();
        kVar.b(nabstSingMsgDndListOperationResp.getSessionID());
        kVar.a(nabstSingMsgDndListOperationResp.getAccountid());
        ResultInfo resultInfo = nabstSingMsgDndListOperationResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65550, kVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactAddressResp nabstUpLoadContactAddressResp) {
        String json = new Gson().toJson(nabstUpLoadContactAddressResp);
        d.a(this.f8063d, "【nabst-修改联系人通讯地址】 java_NabstUpLoadContactAddress " + json);
        d.e.b.i.d.l lVar = new d.e.b.i.d.l();
        lVar.c(nabstUpLoadContactAddressResp.getSessionID());
        lVar.a(nabstUpLoadContactAddressResp.getAccountid());
        lVar.b(nabstUpLoadContactAddressResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactAddressResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65559, lVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactBirthdayResp nabstUpLoadContactBirthdayResp) {
        String json = new Gson().toJson(nabstUpLoadContactBirthdayResp);
        d.a(this.f8063d, "【nabst-修改联系人生日】 java_NabstUpLoadContactBirthday " + json);
        d.e.b.i.d.m mVar = new d.e.b.i.d.m();
        mVar.c(nabstUpLoadContactBirthdayResp.getSessionID());
        mVar.a(nabstUpLoadContactBirthdayResp.getAccountid());
        mVar.b(nabstUpLoadContactBirthdayResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactBirthdayResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65561, mVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactCommAddrResp nabstUpLoadContactCommAddrResp) {
        String json = new Gson().toJson(nabstUpLoadContactCommAddrResp);
        d.a(this.f8063d, "【nabst-修改联系人个人地址】 java_NabstUpLoadContactCommAddr " + json);
        d.e.b.i.d.n nVar = new d.e.b.i.d.n();
        nVar.c(nabstUpLoadContactCommAddrResp.getSessionID());
        nVar.a(nabstUpLoadContactCommAddrResp.getAccountid());
        nVar.b(nabstUpLoadContactCommAddrResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactCommAddrResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), JoyEvent.KEYCODE_DPAD_RIGHT, nVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactGroupInfoResp nabstUpLoadContactGroupInfoResp) {
        String json = new Gson().toJson(nabstUpLoadContactGroupInfoResp);
        d.a(this.f8063d, "【nabst-修改联系人分组信息】 java_NabstUpLoadContactGroupInfo " + json);
        o oVar = new o();
        oVar.c(nabstUpLoadContactGroupInfoResp.getSessionID());
        oVar.a(nabstUpLoadContactGroupInfoResp.getAccountid());
        oVar.b(nabstUpLoadContactGroupInfoResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactGroupInfoResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65560, oVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactNameResp nabstUpLoadContactNameResp) {
        String json = new Gson().toJson(nabstUpLoadContactNameResp);
        d.a(this.f8063d, "【nabst-修改联系人名称】 java_NabstUpLoadContactName " + json);
        p pVar = new p();
        pVar.d(nabstUpLoadContactNameResp.getSessionID());
        pVar.a(nabstUpLoadContactNameResp.getAccountid());
        pVar.c(nabstUpLoadContactNameResp.getOldcontactid());
        pVar.b(nabstUpLoadContactNameResp.getNewcontactid());
        ResultInfo resultInfo = nabstUpLoadContactNameResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), JoyEvent.KEYCODE_DPAD_LEFT, pVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactNoteResp nabstUpLoadContactNoteResp) {
        String json = new Gson().toJson(nabstUpLoadContactNoteResp);
        d.a(this.f8063d, "【nabst-修改联系人备注信息】 java_NabstUpLoadContactNote " + json);
        q qVar = new q();
        qVar.c(nabstUpLoadContactNoteResp.getSessionID());
        qVar.a(nabstUpLoadContactNoteResp.getAccountid());
        qVar.b(nabstUpLoadContactNoteResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactNoteResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), JoyEvent.KEYCODE_DPAD_UP, qVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactOrgNameResp nabstUpLoadContactOrgNameResp) {
        String json = new Gson().toJson(nabstUpLoadContactOrgNameResp);
        d.a(this.f8063d, "【nabst-修改联系人公司名称】 java_NabstUpLoadContactOrgName " + json);
        r rVar = new r();
        rVar.c(nabstUpLoadContactOrgNameResp.getSessionID());
        rVar.a(nabstUpLoadContactOrgNameResp.getAccountid());
        rVar.b(nabstUpLoadContactOrgNameResp.getContactid());
        ResultInfo resultInfo = nabstUpLoadContactOrgNameResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), JoyEvent.KEYCODE_DPAD_DOWN, rVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadContactResp nabstUpLoadContactResp) {
        String accountid = nabstUpLoadContactResp.getAccountid();
        String sessionID = nabstUpLoadContactResp.getSessionID();
        String newcontactid = nabstUpLoadContactResp.getNewcontactid();
        String oldcontactid = nabstUpLoadContactResp.getOldcontactid();
        String json = new Gson().toJson(nabstUpLoadContactResp);
        d.a(this.f8063d, "【nabst-全量更新联系人的回调】 java_NabstUpLoadContact " + json);
        s sVar = new s();
        sVar.d(sessionID);
        sVar.a(accountid);
        sVar.b(newcontactid);
        sVar.c(oldcontactid);
        ResultInfo resultInfo = nabstUpLoadContactResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65569, sVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserCallingSettingResp nabstUpLoadUserCallingSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserCallingSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户通话回调】 java_NabstUpLoadUserCallingSetting" + json);
        t tVar = new t();
        tVar.b(nabstUpLoadUserCallingSettingResp.getSessionID());
        tVar.a(nabstUpLoadUserCallingSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserCallingSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, tVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserContactsSettingResp nabstUpLoadUserContactsSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserContactsSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户联系人回调】 java_NabstUpLoadUserContactsSetting" + json);
        u uVar = new u();
        uVar.b(nabstUpLoadUserContactsSettingResp.getSessionID());
        uVar.a(nabstUpLoadUserContactsSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserContactsSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, uVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserExtendSettingResp nabstUpLoadUserExtendSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserExtendSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户扩展信息设置回调】 java_NabstUpLoadUserExtendSetting " + json);
        v vVar = new v();
        vVar.b(nabstUpLoadUserExtendSettingResp.getSessionID());
        vVar.a(nabstUpLoadUserExtendSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserExtendSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 65548, vVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserMsgDndSettingResp nabstUpLoadUserMsgDndSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserMsgDndSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户消息免打扰设置回调】 java_NabstUpLoadUserMsgDndSetting" + json);
        w wVar = new w();
        wVar.b(nabstUpLoadUserMsgDndSettingResp.getSessionID());
        wVar.a(nabstUpLoadUserMsgDndSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserMsgDndSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST, wVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserMsgNotifySettingResp nabstUpLoadUserMsgNotifySettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserMsgNotifySettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户消息通知设置回调】 java_NabstUpLoadUserMsgNotifySetting" + json);
        x xVar = new x();
        xVar.b(nabstUpLoadUserMsgNotifySettingResp.getSessionID());
        xVar.a(nabstUpLoadUserMsgNotifySettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserMsgNotifySettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY, xVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserMsgPlayModSettingResp nabstUpLoadUserMsgPlayModSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserMsgPlayModSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户消息播放模式设置回调】 java_NabstUpLoadUserMsgPlayModSetting" + json);
        y yVar = new y();
        yVar.b(nabstUpLoadUserMsgPlayModSettingResp.getSessionID());
        yVar.a(nabstUpLoadUserMsgPlayModSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserMsgPlayModSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, yVar));
    }

    @Override // d.e.b.i.a
    public void a(NabstUpLoadUserMsgReminSettingResp nabstUpLoadUserMsgReminSettingResp) {
        String json = new Gson().toJson(nabstUpLoadUserMsgReminSettingResp);
        d.a(this.f8063d, "【nabst-修改个人用户消息提醒设置回调】 java_NabstUpLoadUserMsgReminSetting" + json);
        z zVar = new z();
        zVar.b(nabstUpLoadUserMsgReminSettingResp.getSessionID());
        zVar.a(nabstUpLoadUserMsgReminSettingResp.getAccountid());
        ResultInfo resultInfo = nabstUpLoadUserMsgReminSettingResp.gettResultInfo();
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, zVar));
    }
}
