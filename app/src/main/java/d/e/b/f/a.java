package d.e.b.f;

import android.os.Bundle;
import android.os.Message;
import com.google.gson.Gson;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GCApplyForJoinGroupAck;
import com.zte.ucs.tvcall.ocx.groupchat.GCAuditJoinGroupAck;
import com.zte.ucs.tvcall.ocx.groupchat.GCGenerateQRCodeAck;
import com.zte.ucs.tvcall.ocx.groupchat.GCRecvApplyForJoinGroupRslt;
import com.zte.ucs.tvcall.ocx.groupchat.GCRecvJoinGroupApplication;
import com.zte.ucs.tvcall.ocx.groupchat.GCScanQRCodeAck;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatFileBase;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatGetFileRate;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatGetFileResp;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatMsgInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatRecvLocInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatRecvMultInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatSendFileRate;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatSendLocResp;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatSendMsgResp;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.groupchat.GroupMsgRevokeRpt;
import com.zte.ucs.tvcall.ocx.groupchat.InitiateGroupChatOutInfo;
import com.zte.ucs.tvcall.ocx.groupchat.NewGroupChatOutInfo;
import com.zte.ucs.tvcall.ocx.groupchat.NotifyGroupChatOutInfo;
import com.zte.ucs.tvcall.ocx.groupchat.ParticipantGCOutBase;
import com.zte.ucs.tvcall.ocx.groupchat.ParticipantInfo;
import com.zte.ucs.tvcall.ocx.groupchat.ParticipantOutInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCAcceptInviteAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCActiveAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCActivityInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCAddMberAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCCreateChatAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCDismissChatAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCInActivityInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCMberConnectInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCMberInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCMberListAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCMberListBase;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCModifyNickNameAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCModifySubjectAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCNfyBootChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCNfyGetGroupInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCNfyQuitChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCNfySubjectInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCQuitChatAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvBootChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvCreateChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvDismissChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvLargerMult;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvLocInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvMultBase;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvMultMsgInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvMultMsgRate;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRecvTxtMsgInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRemoveMemberAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendLocAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendMultMsgAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendMultMsgRate;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendTxtMsgAck;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSetChairAck;
import d.e.b.f.c.c;
import d.e.b.f.c.e;
import d.e.b.f.c.f;
import d.e.b.f.c.g;
import d.e.b.f.c.h;
import d.e.b.n.d;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a extends d.e.b.b.b implements b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f8060d = "d.e.b.f.a";

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

    @Override // d.e.b.f.b
    public void a(int i, String str, ParticipantOutInfo[] participantOutInfoArr) {
        d.a(f8060d, String.format(Locale.getDefault(), "【不期望的通知事件】 java_notify_confer_getMemList chatId[%s], ParticipantOutInfo arraynum[%d]. Calling java_notify_groupinfo_getMemList method directly.", str, Integer.valueOf(i)));
    }

    @Override // d.e.b.f.b
    public void a(int i, NotifyGroupChatOutInfo[] notifyGroupChatOutInfoArr) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到用户所有群聊列表通知】 java_notify_getGroupChatList arraynum[%d]", Integer.valueOf(i)));
        if (i < 0) {
            d.d(f8060d, "java_notify_getGroupChatList.arraynum error:" + i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (notifyGroupChatOutInfoArr != null) {
            for (NotifyGroupChatOutInfo notifyGroupChatOutInfo : notifyGroupChatOutInfoArr) {
                GroupChatInfo groupChatInfo = new GroupChatInfo();
                groupChatInfo.setChatId(notifyGroupChatOutInfo.getChatId());
                groupChatInfo.setSubject(notifyGroupChatOutInfo.getSubject());
                arrayList.add(groupChatInfo);
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = i;
        obtain.obj = arrayList;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(int i, SessGCNfyGetGroupInfo[] sessGCNfyGetGroupInfoArr) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-单次订阅后收到用户所有群聊列表】java_SessGC_NfyGroupList arraynum[%d]", Integer.valueOf(i)));
        if (i < 0) {
            d.d(f8060d, "java_SessGC_NfyGroupList.arraynum error:" + i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (sessGCNfyGetGroupInfoArr != null) {
            for (SessGCNfyGetGroupInfo sessGCNfyGetGroupInfo : sessGCNfyGetGroupInfoArr) {
                GroupChatInfo groupChatInfo = new GroupChatInfo();
                groupChatInfo.setChatId(sessGCNfyGetGroupInfo.getChatId());
                groupChatInfo.setSubject(sessGCNfyGetGroupInfo.getSubject());
                arrayList.add(groupChatInfo);
            }
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = i;
        obtain.obj = arrayList;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GCRecvApplyForJoinGroupRslt gCRecvApplyForJoinGroupRslt) {
        String json = new Gson().toJson(gCRecvApplyForJoinGroupRslt);
        d.a(f8060d, "【群聊-收到申请入群的结果信息】java_GCRecvApplyForJoinGroupRslt" + json);
        d.e.b.f.c.d dVar = new d.e.b.f.c.d();
        dVar.a(gCRecvApplyForJoinGroupRslt.getChatId());
        dVar.a(gCRecvApplyForJoinGroupRslt.getOptionType());
        Message obtain = Message.obtain();
        obtain.what = 43;
        obtain.obj = dVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GCRecvJoinGroupApplication gCRecvJoinGroupApplication) {
        String json = new Gson().toJson(gCRecvJoinGroupApplication);
        d.a(f8060d, "【群聊-申请入群结果回调】java_GCRecvJoinGroupApplication " + json);
        e eVar = new e();
        eVar.a(gCRecvJoinGroupApplication.getChatId());
        eVar.b(gCRecvJoinGroupApplication.getProposerURL());
        eVar.c(gCRecvJoinGroupApplication.getReason());
        Message obtain = Message.obtain();
        obtain.what = 41;
        obtain.obj = eVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GroupChatFileBase groupChatFileBase) {
        if (groupChatFileBase == null) {
            d.d(f8060d, "java_onGroupChatNewFileBase get null GroupChatFileBase object !");
            return;
        }
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到大文件基础信息通知】 java_onGroupChatNewFileBase chatId[%s],messageId[%s],sendUrl[%s],smallPic[%s],filetranId[%s],dateTime[%s],fileName[%s],fileLen[%d],timeLen[%d],messageType[%d],barcycleTime[%d],special[%d],getFileFlag[%d]", groupChatFileBase.getChatId(), groupChatFileBase.getMessageId(), groupChatFileBase.getSendUrl(), groupChatFileBase.getSmallPic(), groupChatFileBase.getFiletranId(), groupChatFileBase.getDateTime(), groupChatFileBase.getFileName(), Integer.valueOf(groupChatFileBase.getFileLen()), Integer.valueOf(groupChatFileBase.getTimeLen()), Integer.valueOf(groupChatFileBase.getMessageType()), Integer.valueOf(groupChatFileBase.getBarcycleTime()), Integer.valueOf(groupChatFileBase.getMsgFlag()), Integer.valueOf(groupChatFileBase.getGetFileFlag())));
        Message obtain = Message.obtain();
        obtain.what = 29;
        obtain.obj = groupChatFileBase;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GroupChatMsgInfo groupChatMsgInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到文本消息通知】java_onGroupChatNewMsg chatId[%s],messageId[%s],sendUrl[%s],text[%s],CPIMcc[%s],deliverTime[%s],barcycleTime[%d],special[%d]", groupChatMsgInfo.getChatId(), groupChatMsgInfo.getMessageId(), groupChatMsgInfo.getSendUrl(), groupChatMsgInfo.getText(), groupChatMsgInfo.getCPIMcc(), groupChatMsgInfo.getDeliverTime(), Integer.valueOf(groupChatMsgInfo.getBarcycleTime()), Integer.valueOf(groupChatMsgInfo.getMsgFlag())));
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = groupChatMsgInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GroupChatRecvLocInfo groupChatRecvLocInfo) {
        if (groupChatRecvLocInfo == null) {
            d.d(f8060d, "java_onNewGroupChatLoc get null GroupChatRecvLocInfo object !");
            return;
        }
        String longitude = groupChatRecvLocInfo.getLongitude();
        String latidute = groupChatRecvLocInfo.getLatidute();
        String radius = groupChatRecvLocInfo.getRadius();
        String locationName = groupChatRecvLocInfo.getLocationName();
        String sendTime = groupChatRecvLocInfo.getSendTime();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到地理位置消息通知】java_onNewGroupChatLoc chatId[%s],messageId[%s],sendUrl[%s],longitude[%s],latidute[%s],radius[%s],locationName[%s],sendTime[%s],barcycleTime[%d],special[%d]", groupChatRecvLocInfo.getChatId(), groupChatRecvLocInfo.getMessageId(), groupChatRecvLocInfo.getSenderUrl(), longitude, latidute, radius, locationName, sendTime, Integer.valueOf(groupChatRecvLocInfo.getBarcycleTime()), Integer.valueOf(groupChatRecvLocInfo.getMsgFlag())));
        Message obtain = Message.obtain();
        obtain.what = 33;
        obtain.obj = groupChatRecvLocInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GroupChatRecvMultInfo groupChatRecvMultInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到多媒体消息通知】 java_onGroupChatNewMultMsg chatId[%s],messageId[%s],file[%s],contactId[%s],barcycleTime[%d],special[%d] ", groupChatRecvMultInfo.getChatId(), groupChatRecvMultInfo.getMessageId(), groupChatRecvMultInfo.getFile(), groupChatRecvMultInfo.getSendUrl(), Integer.valueOf(groupChatRecvMultInfo.getBarcycleTime()), Integer.valueOf(groupChatRecvMultInfo.getMsgFlag())));
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = groupChatRecvMultInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(GroupMsgRevokeRpt groupMsgRevokeRpt) {
        if (groupMsgRevokeRpt == null) {
            d.d(f8060d, "java_GroupMsgRevokeRcv get null groupMsgRevokeRpt object !");
            return;
        }
        String json = new Gson().toJson(groupMsgRevokeRpt);
        d.a(f8060d, "【群聊-消息撤回接收上报通知】java_GroupMsgRevokeRcv groupMsgRevokeRpt" + json);
        Message obtain = Message.obtain();
        obtain.what = 36;
        obtain.obj = groupMsgRevokeRpt;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(NewGroupChatOutInfo newGroupChatOutInfo) {
        String chatId = newGroupChatOutInfo.getChatId();
        String contactId = newGroupChatOutInfo.getContactId();
        String subject = newGroupChatOutInfo.getSubject();
        int callId = newGroupChatOutInfo.getCallId();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到群聊邀请通知】java_onNewGroupChat chatId[%s],contactId[%s],subject[%s],callId[%d],displayName[%s],displayNameEn[%s]", chatId, contactId, subject, Integer.valueOf(callId), newGroupChatOutInfo.getDisplayname(), newGroupChatOutInfo.getDisplaynameEn()));
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = newGroupChatOutInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(ParticipantGCOutBase participantGCOutBase, int i, ParticipantOutInfo[] participantOutInfoArr) {
        String chatId = participantGCOutBase.getChatId();
        String subject = participantGCOutBase.getSubject();
        char c2 = 0;
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到群聊成员列表信息通知】 java_notify_groupinfo_getMemList chatId[%s], subject[%s], ParticipantOutInfo arraynum[%d]", chatId, subject, Integer.valueOf(i)));
        if (participantOutInfoArr == null || participantOutInfoArr.length < 0 || i > participantOutInfoArr.length) {
            d.d(f8060d, "java_notify_groupinfo_getMemList groupChat INTERNAL_ERROR!");
            return;
        }
        g gVar = new g();
        gVar.a(chatId);
        gVar.b(subject);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            String contactId = participantOutInfoArr[i2].getContactId();
            String contactName = participantOutInfoArr[i2].getContactName();
            String contactNameEn = participantOutInfoArr[i2].getContactNameEn();
            int roletype = participantOutInfoArr[i2].getRoletype();
            int state = participantOutInfoArr[i2].getState();
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[7];
            objArr[c2] = Integer.valueOf(i2);
            objArr[1] = chatId;
            objArr[2] = contactId;
            objArr[3] = contactName;
            objArr[4] = contactNameEn;
            objArr[5] = Integer.valueOf(roletype);
            objArr[6] = Integer.valueOf(state);
            d.a(f8060d, String.format(locale, "【群聊-收到群聊成员列表信息通知】 ParticipantOutInfo[%d]: chatId[%s], contactId[%s], contactName[%s], contactNameEn[%s], roletype[%d], stat[%d]", objArr));
            h hVar = new h();
            hVar.a(chatId);
            hVar.b(contactId);
            hVar.c(contactName);
            hVar.d(contactNameEn);
            hVar.a(roletype);
            hVar.b(state);
            arrayList.add(hVar);
            i2++;
            c2 = 0;
        }
        gVar.a(arrayList);
        Message obtain = Message.obtain();
        obtain.what = 25;
        obtain.arg1 = i;
        obtain.obj = gVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(ParticipantInfo participantInfo) {
        if (participantInfo == null) {
            d.d(f8060d, "【群聊-收到新成员/改昵称/转群主通知】java_notify_onParticipantJoinedjava_notify_onParticipantJoined INTERNAL_ERROR participants is null!");
            return;
        }
        String contactName = participantInfo.getContactName();
        String contactNameEn = participantInfo.getContactNameEn();
        int state = participantInfo.getState();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到新成员/改昵称/转群主通知】java_notify_onParticipantJoined chatId[%s],contact[%s],roletype[%d],contactName[%s],contactNameEn[%s],state[%d]", participantInfo.getChatId(), participantInfo.getContactId(), Integer.valueOf(participantInfo.getRoletype()), contactName, contactNameEn, Integer.valueOf(state)));
        Message obtain = Message.obtain();
        obtain.what = 19;
        obtain.obj = participantInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCActivityInfo sessGCActivityInfo) {
        if (sessGCActivityInfo == null) {
            d.d(f8060d, "java_SessGCActivity get null GroupChatRecvLocInfo object !");
            return;
        }
        d.a(f8060d, String.format("【群聊session-处于激活状态通知】java_SessGCActivity chatId[%s]", sessGCActivityInfo.getChatId()));
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.obj = sessGCActivityInfo.getChatId();
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCInActivityInfo sessGCInActivityInfo) {
        if (sessGCInActivityInfo == null) {
            d.d(f8060d, "java_SessGCInActivity get null GroupChatRecvLocInfo object !");
            return;
        }
        d.a(f8060d, String.format("【群聊session-处于去激活状态通知】java_SessGCInActivity chatId[%s]", sessGCInActivityInfo.getChatId()));
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.obj = sessGCInActivityInfo.getChatId();
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCMberConnectInfo sessGCMberConnectInfo) {
        if (sessGCMberConnectInfo == null) {
            d.d(f8060d, "【群聊session-服务端投递的改昵称/成员新加入/转群主/成员上线通知】java_SessGC_NfyMberConnect INTERNAL_ERROR participants is null!");
            return;
        }
        String contactName = sessGCMberConnectInfo.getContactName();
        int state = sessGCMberConnectInfo.getState();
        String chatId = sessGCMberConnectInfo.getChatId();
        String contactId = sessGCMberConnectInfo.getContactId();
        int roletype = sessGCMberConnectInfo.getRoletype();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-服务端投递的改昵称/成员新加入/转群主/成员上线通知】java_SessGC_NfyMberConnect chatId[%s],contact[%s],roletype[%d],contactName[%s],state[%d]", chatId, contactId, Integer.valueOf(roletype), contactName, Integer.valueOf(state)));
        ParticipantInfo participantInfo = new ParticipantInfo();
        participantInfo.setChatId(chatId);
        participantInfo.setContactId(contactId);
        participantInfo.setContactName(sessGCMberConnectInfo.getContactName());
        participantInfo.setRoletype(roletype);
        participantInfo.setState(sessGCMberConnectInfo.getState());
        Message obtain = Message.obtain();
        obtain.what = 19;
        obtain.obj = participantInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr) {
        String chatId = sessGCMberListBase.getChatId();
        String subject = sessGCMberListBase.getSubject();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-单次订阅后收到一个群成员列表】java_SessGC_NfyMberList chatId[%s], SessGCMberInfo arraynum[%d]", chatId, Integer.valueOf(i)));
        if (sessGCMberInfoArr == null || sessGCMberInfoArr.length < 0 || i > sessGCMberInfoArr.length) {
            d.d(f8060d, "java_SessGC_NfyMberList groupChat INTERNAL_ERROR!");
            return;
        }
        g gVar = new g();
        gVar.a(chatId);
        gVar.b(subject);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            String contactId = sessGCMberInfoArr[i2].getContactId();
            String contactName = sessGCMberInfoArr[i2].getContactName();
            int roletype = sessGCMberInfoArr[i2].getRoletype();
            int state = sessGCMberInfoArr[i2].getState();
            d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-单次订阅后收到一个群成员列表】java_SessGC_NfyMberListParticipantOutInfo[%d]: chatId[%s], contactId[%s], contactName[%s], roletype[%d], stat[%d]", Integer.valueOf(i2), chatId, contactId, contactName, Integer.valueOf(roletype), Integer.valueOf(state)));
            h hVar = new h();
            hVar.a(chatId);
            hVar.b(contactId);
            hVar.c(contactName);
            hVar.a(roletype);
            hVar.b(state);
            arrayList.add(hVar);
        }
        gVar.a(arrayList);
        Message obtain = Message.obtain();
        obtain.what = 25;
        obtain.arg1 = i;
        obtain.obj = gVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCNfyBootChatInfo sessGCNfyBootChatInfo) {
        if (sessGCNfyBootChatInfo == null) {
            d.d(f8060d, "java_SessGC_NfyBoot get null GroupChatRecvLocInfo object !");
            return;
        }
        d.a(f8060d, String.format("【群聊session-服务端投递的有人被踢出群通知】java_SessGC_NfyBoot chatId[%s],contactId[%s]", sessGCNfyBootChatInfo.getChatId(), sessGCNfyBootChatInfo.getContactId()));
        Message obtain = Message.obtain();
        obtain.what = 26;
        obtain.obj = sessGCNfyBootChatInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCNfyQuitChatInfo sessGCNfyQuitChatInfo) {
        d.a(f8060d, String.format("【群聊session-收到有人退群通知】java_SessGC_NfyQuitChat chatId[%s] contactId[%s]", sessGCNfyQuitChatInfo.getChatId(), sessGCNfyQuitChatInfo.getContactId()));
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = sessGCNfyQuitChatInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCNfySubjectInfo sessGCNfySubjectInfo) {
        if (sessGCNfySubjectInfo == null) {
            d.d(f8060d, "java_SessGC_NfyModifySubject get null GroupChatRecvLocInfo object !");
            return;
        }
        d.a(f8060d, String.format("【群聊session-服务端投递的群主题变更通知】java_SessGC_NfyModifySubject chatId[%s],subject[%s]", sessGCNfySubjectInfo.getChatId(), sessGCNfySubjectInfo.getSubject()));
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = sessGCNfySubjectInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvBootChatInfo sessGCRecvBootChatInfo) {
        if (sessGCRecvBootChatInfo == null) {
            d.d(f8060d, "java_SessGCRecvBoot get null GroupChatRecvLocInfo object !");
            return;
        }
        d.a(f8060d, String.format("【群聊session-收到自己被踢出群操作】java_SessGCRecvBoot chatId[%s]", sessGCRecvBootChatInfo.getChatId()));
        Message obtain = Message.obtain();
        obtain.what = 21;
        obtain.obj = sessGCRecvBootChatInfo.getChatId();
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvCreateChatInfo sessGCRecvCreateChatInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-收到群聊邀请】java_SessGCRecvCreateChat chatId[%s] contactId[%s] subject[%s]", sessGCRecvCreateChatInfo.getChatId(), sessGCRecvCreateChatInfo.getContactId(), sessGCRecvCreateChatInfo.getSubject()));
        NewGroupChatOutInfo newGroupChatOutInfo = new NewGroupChatOutInfo();
        newGroupChatOutInfo.setChatId(sessGCRecvCreateChatInfo.getChatId());
        newGroupChatOutInfo.setSubject(sessGCRecvCreateChatInfo.getSubject());
        newGroupChatOutInfo.setContactId(sessGCRecvCreateChatInfo.getContactId());
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = newGroupChatOutInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvDismissChatInfo sessGCRecvDismissChatInfo) {
        d.a(f8060d, String.format("【群聊session-服务端投递的群解散操作】java_SessGCRecvDismiss chatId[%s]", sessGCRecvDismissChatInfo.getChatId()));
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = sessGCRecvDismissChatInfo.getChatId();
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvLocInfo sessGCRecvLocInfo) {
        if (sessGCRecvLocInfo == null) {
            d.d(f8060d, "java_SessGCRecvLoc get null GroupChatRecvLocInfo object !");
            return;
        }
        String longitude = sessGCRecvLocInfo.getLongitude();
        String latidute = sessGCRecvLocInfo.getLatidute();
        String radius = sessGCRecvLocInfo.getRadius();
        String locationName = sessGCRecvLocInfo.getLocationName();
        String contactId = sessGCRecvLocInfo.getContactId();
        String deliverTime = sessGCRecvLocInfo.getDeliverTime();
        String chatId = sessGCRecvLocInfo.getChatId();
        String messageId = sessGCRecvLocInfo.getMessageId();
        String contactId2 = sessGCRecvLocInfo.getContactId();
        d.a(f8060d, String.format("【群聊session-收到地理位置消息通知】java_SessGCRecvLoc chatId[%s],messageId[%s],sendUrl[%s],longitude[%s],latidute[%s],radius[%s],locationName[%s],contactId[%s],deliverTime[%s]", chatId, messageId, contactId2, longitude, latidute, radius, locationName, contactId, deliverTime));
        GroupChatRecvLocInfo groupChatRecvLocInfo = new GroupChatRecvLocInfo();
        groupChatRecvLocInfo.setChatId(chatId);
        groupChatRecvLocInfo.setSenderUrl(contactId2);
        groupChatRecvLocInfo.setLatidute(sessGCRecvLocInfo.getLatidute());
        groupChatRecvLocInfo.setLocationName(sessGCRecvLocInfo.getLocationName());
        groupChatRecvLocInfo.setLongitude(sessGCRecvLocInfo.getLongitude());
        groupChatRecvLocInfo.setMessageId(messageId);
        groupChatRecvLocInfo.setRadius(sessGCRecvLocInfo.getRadius());
        groupChatRecvLocInfo.setSendTime(sessGCRecvLocInfo.getDeliverTime());
        Message obtain = Message.obtain();
        obtain.what = 33;
        obtain.obj = groupChatRecvLocInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvMultBase sessGCRecvMultBase) {
        if (sessGCRecvMultBase == null) {
            d.d(f8060d, "java_SessGCRecvMultBase get null SessGCRecvMultBase object !");
            return;
        }
        String chatId = sessGCRecvMultBase.getChatId();
        String messageId = sessGCRecvMultBase.getMessageId();
        String contactId = sessGCRecvMultBase.getContactId();
        String smallPic = sessGCRecvMultBase.getSmallPic();
        String filetranId = sessGCRecvMultBase.getFiletranId();
        String deliverTime = sessGCRecvMultBase.getDeliverTime();
        String fileName = sessGCRecvMultBase.getFileName();
        int fileLen = sessGCRecvMultBase.getFileLen();
        int timeLen = sessGCRecvMultBase.getTimeLen();
        int messageType = sessGCRecvMultBase.getMessageType();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-收到大文件基础信息通知】java_SessGCRecvMultBase chatId[%s],messageId[%s],sendUrl[%s],smallPic[%s],filetranId[%s],deliverTime[%s],fileName[%s],fileLen[%d],timeLen[%d],messageType[%d]", chatId, messageId, contactId, smallPic, filetranId, deliverTime, fileName, Integer.valueOf(fileLen), Integer.valueOf(timeLen), Integer.valueOf(messageType)));
        GroupChatFileBase groupChatFileBase = new GroupChatFileBase();
        groupChatFileBase.setChatId(chatId);
        groupChatFileBase.setDateTime(sessGCRecvMultBase.getDeliverTime());
        groupChatFileBase.setFileLen(sessGCRecvMultBase.getFileLen());
        groupChatFileBase.setFileName(sessGCRecvMultBase.getFileName());
        groupChatFileBase.setFiletranId(sessGCRecvMultBase.getFiletranId());
        groupChatFileBase.setMessageId(messageId);
        groupChatFileBase.setSendUrl(contactId);
        groupChatFileBase.setSmallPic(smallPic);
        groupChatFileBase.setTimeLen(sessGCRecvMultBase.getTimeLen());
        groupChatFileBase.setMessageType(messageType);
        Message obtain = Message.obtain();
        obtain.what = 29;
        obtain.obj = groupChatFileBase;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvMultMsgInfo sessGCRecvMultMsgInfo) {
        String chatId = sessGCRecvMultMsgInfo.getChatId();
        String messageId = sessGCRecvMultMsgInfo.getMessageId();
        String file = sessGCRecvMultMsgInfo.getFile();
        String contactId = sessGCRecvMultMsgInfo.getContactId();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-收到多媒体消息通知】java_SessGCRecvMultMsg chatId[%s],messageId[%s],file[%s],contactId[%s],deliverTime[%s],CPIMcc[%s],smallPic[%s],messageType[%d],timeLen[%d] ", chatId, messageId, file, contactId, sessGCRecvMultMsgInfo.getDeliverTime(), sessGCRecvMultMsgInfo.getCPIMcc(), sessGCRecvMultMsgInfo.getSmallPic(), Integer.valueOf(sessGCRecvMultMsgInfo.getMessageType()), Integer.valueOf(sessGCRecvMultMsgInfo.getTimeLen())));
        GroupChatRecvMultInfo groupChatRecvMultInfo = new GroupChatRecvMultInfo();
        groupChatRecvMultInfo.setChatId(chatId);
        groupChatRecvMultInfo.setCPIMcc(sessGCRecvMultMsgInfo.getCPIMcc());
        groupChatRecvMultInfo.setDateTime(sessGCRecvMultMsgInfo.getDeliverTime());
        groupChatRecvMultInfo.setFile(file);
        groupChatRecvMultInfo.setMessageId(messageId);
        groupChatRecvMultInfo.setMessageType(sessGCRecvMultMsgInfo.getMessageType());
        groupChatRecvMultInfo.setSendUrl(contactId);
        groupChatRecvMultInfo.setSmallPic(sessGCRecvMultMsgInfo.getSmallPic());
        groupChatRecvMultInfo.setTimeLen(sessGCRecvMultMsgInfo.getTimeLen());
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = groupChatRecvMultInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCRecvTxtMsgInfo sessGCRecvTxtMsgInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-收到文本消息通知】java_SessGCRecvTxtMsg chatId[%s],messageId[%s], contactId[%s],CPIMcc[%s],text[%s],deliverTime[%s]", sessGCRecvTxtMsgInfo.getChatId(), sessGCRecvTxtMsgInfo.getMessageId(), sessGCRecvTxtMsgInfo.getContactId(), sessGCRecvTxtMsgInfo.getCPIMcc(), sessGCRecvTxtMsgInfo.getText(), sessGCRecvTxtMsgInfo.getDeliverTime()));
        String text = sessGCRecvTxtMsgInfo.getText();
        if (text != null && text.length() <= 1000) {
            d.c(f8060d, "【群聊session-收到文本消息通知】java_SessGCRecvTxtMsg text:" + text);
        }
        GroupChatMsgInfo groupChatMsgInfo = new GroupChatMsgInfo();
        groupChatMsgInfo.setChatId(sessGCRecvTxtMsgInfo.getChatId());
        groupChatMsgInfo.setCPIMcc(sessGCRecvTxtMsgInfo.getCPIMcc());
        groupChatMsgInfo.setDeliverTime(sessGCRecvTxtMsgInfo.getDeliverTime());
        groupChatMsgInfo.setMessageId(sessGCRecvTxtMsgInfo.getMessageId());
        groupChatMsgInfo.setSendUrl(sessGCRecvTxtMsgInfo.getContactId());
        groupChatMsgInfo.setText(sessGCRecvTxtMsgInfo.getText());
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = groupChatMsgInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(SessGCSendMultMsgRate sessGCSendMultMsgRate) {
        if (sessGCSendMultMsgRate == null) {
            d.d(f8060d, " get null GroupChatSendFileRate object !");
            return;
        }
        String chatId = sessGCSendMultMsgRate.getChatId();
        String messageId = sessGCSendMultMsgRate.getMessageId();
        String filetranId = sessGCSendMultMsgRate.getFiletranId();
        int finishSize = sessGCSendMultMsgRate.getFinishSize();
        int tranRate = sessGCSendMultMsgRate.getTranRate();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-发送消息文件进度通知】java_SessGCSendMultMsgRatejava_SessGCSendMultMsgRate chatId[%s],messageId[%s],filetranId[%s],finishSize[%d],tranRate[%d] ", chatId, messageId, filetranId, Integer.valueOf(finishSize), Integer.valueOf(tranRate)));
        GroupChatSendFileRate groupChatSendFileRate = new GroupChatSendFileRate();
        groupChatSendFileRate.setChatId(chatId);
        groupChatSendFileRate.setFiletranId(sessGCSendMultMsgRate.getFiletranId());
        groupChatSendFileRate.setFinishSize(sessGCSendMultMsgRate.getFinishSize());
        groupChatSendFileRate.setMessageId(messageId);
        groupChatSendFileRate.setTranRate(tranRate);
        Message obtain = Message.obtain();
        obtain.what = 28;
        obtain.obj = groupChatSendFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(String str) {
        d.a(f8060d, String.format("【群聊-收到自己被移除通知】 java_notify_onMeRemoved chatId[%s]", str));
        Message obtain = Message.obtain();
        obtain.what = 21;
        obtain.obj = str;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GCApplyForJoinGroupAck gCApplyForJoinGroupAck) {
        String json = new Gson().toJson(resultInfo);
        d.a(f8060d, "【群聊-申请入群响应】java_GCApplyForJoinGroupAck sessionID: " + str + " result: " + json);
        d.e.b.f.c.a aVar = new d.e.b.f.c.a();
        aVar.a(gCApplyForJoinGroupAck.getChatId());
        aVar.b(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 40, aVar));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GCAuditJoinGroupAck gCAuditJoinGroupAck) {
        String json = new Gson().toJson(resultInfo);
        d.a(f8060d, "【群聊-制码者审批入群响应】java_GCAuditJoinGroupAck sessionID: " + str + " result: " + json);
        d.e.b.f.c.b bVar = new d.e.b.f.c.b();
        bVar.a(gCAuditJoinGroupAck.getChatId());
        bVar.c(str);
        bVar.b(gCAuditJoinGroupAck.getProposerURL());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 42, bVar));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GCGenerateQRCodeAck gCGenerateQRCodeAck) {
        Gson gson = new Gson();
        String json = gson.toJson(gCGenerateQRCodeAck);
        String json2 = gson.toJson(resultInfo);
        d.a(f8060d, "【群聊-发送制作群的二维码响应】java_GCGenerateQRCodeAck sessionID: " + str + " result: " + json2 + " " + json);
        c cVar = new c();
        cVar.c(gCGenerateQRCodeAck.getQRCodeUuid());
        cVar.b(gCGenerateQRCodeAck.getExpiresDate());
        cVar.d(gCGenerateQRCodeAck.getQrCodePicPath());
        cVar.e(str);
        cVar.a(gCGenerateQRCodeAck.getChatId());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 37, cVar));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GCScanQRCodeAck gCScanQRCodeAck) {
        Gson gson = new Gson();
        String json = gson.toJson(gCScanQRCodeAck);
        String json2 = gson.toJson(resultInfo);
        d.a(f8060d, "【群聊-发送扫码响应】java_GCScanQRCodeAck sessionID: " + str + " result: " + json2 + " " + json);
        f fVar = new f();
        fVar.d(str);
        fVar.a(gCScanQRCodeAck.getChatId());
        fVar.a(gCScanQRCodeAck.getGroupVersion());
        fVar.b(gCScanQRCodeAck.getIdentityTpye());
        fVar.c(gCScanQRCodeAck.getMemberCount());
        fVar.b(gCScanQRCodeAck.getQrCodeUuid());
        fVar.c(gCScanQRCodeAck.getReferByUrl());
        fVar.e(gCScanQRCodeAck.getSubject());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 39, fVar));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GroupChatGetFileResp groupChatGetFileResp) {
        if (groupChatGetFileResp == null) {
            d.d(f8060d, "java_GroupChatGetLargerFile get null GroupChatGetFileResp object !");
            return;
        }
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-收到大文件完成通知】 java_GroupChatGetLargerFile sessionId[%s], result[%d],errorCode[%d],errorReason[%s],chatId[%s],messageId[%s],sendUrl[%s],file[%s],dateTime[%s],fileLen[%d],timeLen[%d],messageType[%d],barcycleTime[%d],special[%d],getFileFlag[%d]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), groupChatGetFileResp.getChatId(), groupChatGetFileResp.getMessageId(), groupChatGetFileResp.getSendUrl(), groupChatGetFileResp.getFile(), groupChatGetFileResp.getDateTime(), Integer.valueOf(groupChatGetFileResp.getFileLen()), Integer.valueOf(groupChatGetFileResp.getTimeLen()), Integer.valueOf(groupChatGetFileResp.getMessageType()), Integer.valueOf(groupChatGetFileResp.getBarcycleTime()), Integer.valueOf(groupChatGetFileResp.getMsgFlag()), Integer.valueOf(groupChatGetFileResp.getGetFileFlag())));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 31, groupChatGetFileResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GroupChatSendLocResp groupChatSendLocResp) {
        if (groupChatSendLocResp == null) {
            d.d(f8060d, "java_GroupChatSendLocResp get null GroupChatSendLocResp object !");
            return;
        }
        String chatId = groupChatSendLocResp.getChatId();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-发送地理位置消息结果通知】 java_GroupChatSendLocResp sessionId[%s], result[%d],errorCode[%d],errorReason[%s],messageId[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), groupChatSendLocResp.getMessageId(), chatId));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 32, groupChatSendLocResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GroupChatSendMsgResp groupChatSendMsgResp) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-发送文本消息结果通知】java_groupChatSendMsg sessionId[%s],result[%d],errorReason[%s],errorCode[%d], chatId[%s] messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), groupChatSendMsgResp.getChatId(), groupChatSendMsgResp.getMessageId()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 6, groupChatSendMsgResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, GroupChatSendMultMsgResp groupChatSendMultMsgResp) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-发送多媒体消息结果通知】java_groupChatSendMultMsg sessionId[%s], result[%d],errorReason[%s] errorCode[%d], chatId[%s],messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), groupChatSendMultMsgResp.getChatId(), groupChatSendMultMsgResp.getMessageId()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 7, groupChatSendMultMsgResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, InitiateGroupChatOutInfo initiateGroupChatOutInfo) {
        int result = resultInfo.getResult();
        int errorCode = resultInfo.getErrorCode();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-创建结果通知】java_initiateGroupChat seesionId[%s],result[%d],errorCode[%d],errorReason[%s], chatId[%s], subject[%s]", str, Integer.valueOf(result), Integer.valueOf(errorCode), resultInfo.getErrorReason(), initiateGroupChatOutInfo.getChatId(), initiateGroupChatOutInfo.getSubject()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(initiateGroupChatOutInfo.getChatId());
        groupChatInfo.setSessionId(str);
        groupChatInfo.setSubject(initiateGroupChatOutInfo.getSubject());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 1, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCAcceptInviteAck sessGCAcceptInviteAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-接受邀请执行通知】java_SessGCAcceptInviteAck seesionId[%s],result[%d],errorCode[%d], errorReason[%s]，chatId[%s] ", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCAcceptInviteAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCAcceptInviteAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 22, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCActiveAck sessGCActiveAck) {
        String chatId = sessGCActiveAck.getChatId();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-激活群执行通知】java_SessGCActiveAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), chatId));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 100, chatId));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCAddMberAck sessGCAddMberAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动加人执行通知】java_SessGCAddMberAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s] chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCAddMberAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCAddMberAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 18, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCCreateChatAck sessGCCreateChatAck) {
        int result = resultInfo.getResult();
        int errorCode = resultInfo.getErrorCode();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-创建结果通知】java_SessGCCreateChatAck seesionId[%s],result[%d],errorCode[%d],errorReason[%s] chatId[%s]", str, Integer.valueOf(result), Integer.valueOf(errorCode), resultInfo.getErrorReason(), sessGCCreateChatAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCCreateChatAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 1, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCDismissChatAck sessGCDismissChatAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动解散群执行通知】java_SessGCDismissChatAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCDismissChatAck.getChatId()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 11, sessGCDismissChatAck.getChatId()));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动获取一个群成员列表的执行通知】java_SessGCGetMberListAck sessionId[%s],result[%d],errorReason[%s],errorCode[%d],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), sessGCMberListAck.getChatId()));
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 27, str);
        a2.obj = sessGCMberListAck.getChatId();
        c().sendMessage(a2);
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCModifyNickNameAck sessGCModifyNickNameAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动改昵称执行通知】java_SessGCModifyNickNameAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCModifyNickNameAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCModifyNickNameAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 23, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCModifySubjectAck sessGCModifySubjectAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动修改群主题执行通知】java_SessGCModifySubjectAck sessionId[%s],result[%d],errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCModifySubjectAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCModifySubjectAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 16, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCQuitChatAck sessGCQuitChatAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动退群执行通知】java_SessGCQuitChatAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCQuitChatAck.getChatId()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 10, sessGCQuitChatAck.getChatId()));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCRecvLargerMult sessGCRecvLargerMult) {
        if (sessGCRecvLargerMult == null) {
            d.d(f8060d, "java_SessGCRecvLargerMult get null GroupChatGetFileResp object !");
            return;
        }
        String chatId = sessGCRecvLargerMult.getChatId();
        String messageId = sessGCRecvLargerMult.getMessageId();
        String contactId = sessGCRecvLargerMult.getContactId();
        String file = sessGCRecvLargerMult.getFile();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-收到大文件完成通知】java_SessGCRecvLargerMultAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s],chatId[%s],messageId[%s],sendUrl[%s],file[%s],deliverTime[%s],fileLen[%d],timeLen[%d],messageType[%d] ", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), chatId, messageId, contactId, file, sessGCRecvLargerMult.getDeliverTime(), Integer.valueOf(sessGCRecvLargerMult.getFileLen()), Integer.valueOf(sessGCRecvLargerMult.getTimeLen()), Integer.valueOf(sessGCRecvLargerMult.getMessageType())));
        GroupChatGetFileResp groupChatGetFileResp = new GroupChatGetFileResp();
        groupChatGetFileResp.setChatId(chatId);
        groupChatGetFileResp.setDateTime(sessGCRecvLargerMult.getDeliverTime());
        groupChatGetFileResp.setFile(file);
        groupChatGetFileResp.setFileLen(sessGCRecvLargerMult.getFileLen());
        groupChatGetFileResp.setMessageId(messageId);
        groupChatGetFileResp.setMessageType(sessGCRecvLargerMult.getMessageType());
        groupChatGetFileResp.setSendUrl(contactId);
        groupChatGetFileResp.setTimeLen(sessGCRecvLargerMult.getTimeLen());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 31, groupChatGetFileResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCRemoveMemberAck sessGCRemoveMemberAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动踢人执行通知】java_SessGCRemoveMberAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCRemoveMemberAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCRemoveMemberAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 20, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCSendLocAck sessGCSendLocAck) {
        if (sessGCSendLocAck == null) {
            d.d(f8060d, "java_SessGCSendLocAck get null GroupChatSendLocResp object !");
            return;
        }
        String chatId = sessGCSendLocAck.getChatId();
        String messageId = sessGCSendLocAck.getMessageId();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-发送地理位置消息结果通知】java_SessGCSendLocAck sessionId[%s], result[%d],errorCode[%d],chatId[%s],messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), chatId, messageId));
        GroupChatSendLocResp groupChatSendLocResp = new GroupChatSendLocResp();
        groupChatSendLocResp.setChatId(chatId);
        groupChatSendLocResp.setMessageId(messageId);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 32, groupChatSendLocResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCSendMultMsgAck sessGCSendMultMsgAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-发送多媒体消息结果通知】java_SessGCSendMultMsgAck seesionId[%s],result[%d],errorReason[%s] errorCode[%d], chatId[%s],messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), sessGCSendMultMsgAck.getChatId(), sessGCSendMultMsgAck.getMessageId()));
        GroupChatSendMultMsgResp groupChatSendMultMsgResp = new GroupChatSendMultMsgResp();
        groupChatSendMultMsgResp.setChatId(sessGCSendMultMsgAck.getChatId());
        groupChatSendMultMsgResp.setMessageId(sessGCSendMultMsgAck.getMessageId());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 7, groupChatSendMultMsgResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCSendTxtMsgAck sessGCSendTxtMsgAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-发送文本消息结果通知】java_SessGCSendTxtMsgAckjava_SessGCSendTxtMsgAck seesionId[%s],result[%d],errorReason[%s],errorCode[%d], chatId[%s] messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), sessGCSendTxtMsgAck.getChatId(), sessGCSendTxtMsgAck.getMessageId()));
        GroupChatSendMsgResp groupChatSendMsgResp = new GroupChatSendMsgResp();
        groupChatSendMsgResp.setChatId(sessGCSendTxtMsgAck.getChatId());
        groupChatSendMsgResp.setMessageId(sessGCSendTxtMsgAck.getMessageId());
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 6, groupChatSendMsgResp));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, SessGCSetChairAck sessGCSetChairAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动转移群主执行通知】java_SessGCSetChairAck sessionId[%s],result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), sessGCSetChairAck.getChatId()));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(sessGCSetChairAck.getChatId());
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 14, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void a(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-获取自己一个群的成员执行通知】 java_getParticipantList sessionId[%s],result[%d],errorReason[%s],errorCode[%d],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), str2));
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 27, str);
        a2.obj = str2;
        c().sendMessage(a2);
    }

    @Override // d.e.b.f.b
    public void a(String str, GroupChatGetFileRate groupChatGetFileRate) {
        if (groupChatGetFileRate == null) {
            d.d(f8060d, "java_GroupChatGetFileRate get null GroupChatGetFileRate object !");
            return;
        }
        String chatId = groupChatGetFileRate.getChatId();
        StringBuilder sb = new StringBuilder();
        sb.append(groupChatGetFileRate.getTranRate());
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-接收消息文件进度通知】 java_GroupChatGetFileRate sessionId[%s],chatId[%s],TranRate[%s],messageId[%s],filetranId[%s],finishSize[%d]", str, chatId, sb.toString(), groupChatGetFileRate.getMessageId(), groupChatGetFileRate.getFiletranId(), Integer.valueOf(groupChatGetFileRate.getFinishSize())));
        Message obtain = Message.obtain();
        obtain.what = 30;
        obtain.obj = groupChatGetFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(String str, GroupChatSendFileRate groupChatSendFileRate) {
        if (groupChatSendFileRate == null) {
            d.d(f8060d, "java_GroupChatSendFileRate get null GroupChatSendFileRate object !");
            return;
        }
        String chatId = groupChatSendFileRate.getChatId();
        String messageId = groupChatSendFileRate.getMessageId();
        StringBuilder sb = new StringBuilder();
        sb.append(groupChatSendFileRate.getTranRate());
        String sb2 = sb.toString();
        String filetranId = groupChatSendFileRate.getFiletranId();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(groupChatSendFileRate.getFinishSize());
        d.a(f8060d, String.format("【群聊-发送消息文件进度通知】 java_GroupChatSendFileRate chatId[%s],messageId[%s],rate[%s],filetranId[%s],finishSize[%s]", chatId, messageId, sb2, filetranId, sb3.toString()));
        Message obtain = Message.obtain();
        obtain.what = 28;
        obtain.obj = groupChatSendFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void a(String str, SessGCRecvMultMsgRate sessGCRecvMultMsgRate) {
        if (sessGCRecvMultMsgRate == null) {
            d.d(f8060d, "java_SessGCRecvMultMsgRate get null GroupChatGetFileRate object !");
            return;
        }
        String chatId = sessGCRecvMultMsgRate.getChatId();
        String messageId = sessGCRecvMultMsgRate.getMessageId();
        String filetranId = sessGCRecvMultMsgRate.getFiletranId();
        int finishSize = sessGCRecvMultMsgRate.getFinishSize();
        int tranRate = sessGCRecvMultMsgRate.getTranRate();
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-接收消息文件进度通知】java_SessGCRecvMultMsgRate chatId[%s],messageId[%s],TranRate[%d],filetranId[%s],finishSize[%d]", chatId, messageId, Integer.valueOf(tranRate), filetranId, Integer.valueOf(finishSize)));
        GroupChatGetFileRate groupChatGetFileRate = new GroupChatGetFileRate();
        groupChatGetFileRate.setChatId(chatId);
        groupChatGetFileRate.setFiletranId(sessGCRecvMultMsgRate.getFiletranId());
        groupChatGetFileRate.setFinishSize(sessGCRecvMultMsgRate.getFinishSize());
        groupChatGetFileRate.setMessageId(messageId);
        groupChatGetFileRate.setTranRate(tranRate);
        Message obtain = Message.obtain();
        obtain.what = 30;
        obtain.obj = groupChatGetFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void b(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-长期订阅后收到的群成员列表】java_SessGC_NfyConfMberList chatId[%s], subject[%s],SessGCMberInfo arraynum[%d]. Calling java_SessGC_NfyMberList method directly.", sessGCMberListBase.getChatId(), sessGCMberListBase.getSubject(), Integer.valueOf(i)));
        a(sessGCMberListBase, i, sessGCMberInfoArr);
    }

    @Override // d.e.b.f.b
    public void b(String str) {
        d.a(f8060d, String.format("【群聊-收到解散群通知】 java_notify_abortConversation chatId[%s]", str));
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = str;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    @Deprecated
    public void b(String str, int i, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【不期望的通知事件】 java_rejoinGroupChat seesionId[%s],chatId[%s],result[%d]", str, str2, Integer.valueOf(i)));
    }

    @Override // d.e.b.f.b
    public void b(String str, ResultInfo resultInfo) {
        String json = new Gson().toJson(resultInfo);
        d.a(f8060d, "【群聊-制码者设置入群审批权限响应】java_GCsetJoinChatAuditAuthAck sessionID: " + str + " result: " + json);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 38, str));
    }

    @Override // d.e.b.f.b
    public void b(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-长期订阅群通知的执行通知】java_SessGCRejoinChatAck sessionId[%s],result[%d],errorReason[%s],errorCode[%d],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), sessGCMberListAck.getChatId()));
        Message a2 = a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 5, str);
        a2.obj = sessGCMberListAck.getChatId();
        c().sendMessage(a2);
    }

    @Override // d.e.b.f.b
    public void b(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己修改群主题执行通知】java_modifySubject sessionId[%s],result[%d], errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 16, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void b(String str, String str2) {
        d.a(f8060d, String.format("【群聊-收到有人被踢通知】java_notify_bootConversation chatId[%s], contact[%s]", str, str2));
        SessGCNfyBootChatInfo sessGCNfyBootChatInfo = new SessGCNfyBootChatInfo();
        sessGCNfyBootChatInfo.setChatId(str);
        sessGCNfyBootChatInfo.setContactId(str2);
        Message obtain = Message.obtain();
        obtain.what = 26;
        obtain.obj = sessGCNfyBootChatInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void c(String str, ResultInfo resultInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊session-主动获取群列表的执行通知】java_SessGCGetGroupListAck sessionId[%s], result[%d],errorCode[%d],errorReason[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 3, str));
    }

    @Override // d.e.b.f.b
    public void c(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己添加成员执行通知】java_addParticipants sessionId[%s],result[%d],errorCode[%d],errorReason[%s] chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 18, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void c(String str, String str2) {
        d.a(f8060d, String.format("【群聊-收到有人退群通知】 java_notify_quitConversation chatId[%s], contact[%s]", str, str2));
        SessGCNfyQuitChatInfo sessGCNfyQuitChatInfo = new SessGCNfyQuitChatInfo();
        sessGCNfyQuitChatInfo.setChatId(str);
        sessGCNfyQuitChatInfo.setContactId(str2);
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = sessGCNfyQuitChatInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void d(String str, ResultInfo resultInfo) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-获取自己群列表执行通知】java_getMyGroupChat seesionId[%s],result[%d],errorCode[%d],errorReason[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 3, str));
    }

    @Override // d.e.b.f.b
    public void d(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己退群执行通知】java_quitConversation sessionId[%s], result[%d], errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 10, str2));
    }

    @Override // d.e.b.f.b
    public void e(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己设置群管理员执行通知】java_setChairman sessionId[%s], result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 14, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void f(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-接受邀请执行通知】java_acceptInvitationAck sessionId[%s] result[%d],errorCode[%d], errorReason[%s]，chatId[%s] ", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 22, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void f(String str, String str2) {
        d.a(f8060d, String.format("【群聊-收到群主题变更通知】 java_notify_modifySubject chatId[%s], subject[%s]", str, str2));
        SessGCNfySubjectInfo sessGCNfySubjectInfo = new SessGCNfySubjectInfo();
        sessGCNfySubjectInfo.setChatId(str);
        sessGCNfySubjectInfo.setSubject(str2);
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = sessGCNfySubjectInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.f.b
    public void g(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己移除成员执行通知】java_removeParticipants sessionId[%s], result[%d],errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 20, groupChatInfo));
    }

    @Override // d.e.b.f.b
    public void h(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己解散群执行通知】java_abortConversation sessionId[%s], result[%d],errorCode[%d],errorReason[%s],chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 11, str2));
    }

    @Override // d.e.b.f.b
    public void i(String str, ResultInfo resultInfo, String str2) {
        d.a(f8060d, String.format(Locale.getDefault(), "【群聊-自己改昵称执行通知】java_modifyNickName sessionId[%s], result[%d]errorCode[%d],errorReason[%s], chatId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), str2));
        GroupChatInfo groupChatInfo = new GroupChatInfo();
        groupChatInfo.setChatId(str2);
        groupChatInfo.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 23, groupChatInfo));
    }
}
