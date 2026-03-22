package d.e.b.f;

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

/* loaded from: classes2.dex */
public interface b {
    void a(int i, String str, ParticipantOutInfo[] participantOutInfoArr);

    void a(int i, NotifyGroupChatOutInfo[] notifyGroupChatOutInfoArr);

    void a(int i, SessGCNfyGetGroupInfo[] sessGCNfyGetGroupInfoArr);

    void a(GCRecvApplyForJoinGroupRslt gCRecvApplyForJoinGroupRslt);

    void a(GCRecvJoinGroupApplication gCRecvJoinGroupApplication);

    void a(GroupChatFileBase groupChatFileBase);

    void a(GroupChatMsgInfo groupChatMsgInfo);

    void a(GroupChatRecvLocInfo groupChatRecvLocInfo);

    void a(GroupChatRecvMultInfo groupChatRecvMultInfo);

    void a(GroupMsgRevokeRpt groupMsgRevokeRpt);

    void a(NewGroupChatOutInfo newGroupChatOutInfo);

    void a(ParticipantGCOutBase participantGCOutBase, int i, ParticipantOutInfo[] participantOutInfoArr);

    void a(ParticipantInfo participantInfo);

    void a(SessGCActivityInfo sessGCActivityInfo);

    void a(SessGCInActivityInfo sessGCInActivityInfo);

    void a(SessGCMberConnectInfo sessGCMberConnectInfo);

    void a(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr);

    void a(SessGCNfyBootChatInfo sessGCNfyBootChatInfo);

    void a(SessGCNfyQuitChatInfo sessGCNfyQuitChatInfo);

    void a(SessGCNfySubjectInfo sessGCNfySubjectInfo);

    void a(SessGCRecvBootChatInfo sessGCRecvBootChatInfo);

    void a(SessGCRecvCreateChatInfo sessGCRecvCreateChatInfo);

    void a(SessGCRecvDismissChatInfo sessGCRecvDismissChatInfo);

    void a(SessGCRecvLocInfo sessGCRecvLocInfo);

    void a(SessGCRecvMultBase sessGCRecvMultBase);

    void a(SessGCRecvMultMsgInfo sessGCRecvMultMsgInfo);

    void a(SessGCRecvTxtMsgInfo sessGCRecvTxtMsgInfo);

    void a(SessGCSendMultMsgRate sessGCSendMultMsgRate);

    void a(String str);

    void a(String str, ResultInfo resultInfo, GCApplyForJoinGroupAck gCApplyForJoinGroupAck);

    void a(String str, ResultInfo resultInfo, GCAuditJoinGroupAck gCAuditJoinGroupAck);

    void a(String str, ResultInfo resultInfo, GCGenerateQRCodeAck gCGenerateQRCodeAck);

    void a(String str, ResultInfo resultInfo, GCScanQRCodeAck gCScanQRCodeAck);

    void a(String str, ResultInfo resultInfo, GroupChatGetFileResp groupChatGetFileResp);

    void a(String str, ResultInfo resultInfo, GroupChatSendLocResp groupChatSendLocResp);

    void a(String str, ResultInfo resultInfo, GroupChatSendMsgResp groupChatSendMsgResp);

    void a(String str, ResultInfo resultInfo, GroupChatSendMultMsgResp groupChatSendMultMsgResp);

    void a(String str, ResultInfo resultInfo, InitiateGroupChatOutInfo initiateGroupChatOutInfo);

    void a(String str, ResultInfo resultInfo, SessGCAcceptInviteAck sessGCAcceptInviteAck);

    void a(String str, ResultInfo resultInfo, SessGCActiveAck sessGCActiveAck);

    void a(String str, ResultInfo resultInfo, SessGCAddMberAck sessGCAddMberAck);

    void a(String str, ResultInfo resultInfo, SessGCCreateChatAck sessGCCreateChatAck);

    void a(String str, ResultInfo resultInfo, SessGCDismissChatAck sessGCDismissChatAck);

    void a(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck);

    void a(String str, ResultInfo resultInfo, SessGCModifyNickNameAck sessGCModifyNickNameAck);

    void a(String str, ResultInfo resultInfo, SessGCModifySubjectAck sessGCModifySubjectAck);

    void a(String str, ResultInfo resultInfo, SessGCQuitChatAck sessGCQuitChatAck);

    void a(String str, ResultInfo resultInfo, SessGCRecvLargerMult sessGCRecvLargerMult);

    void a(String str, ResultInfo resultInfo, SessGCRemoveMemberAck sessGCRemoveMemberAck);

    void a(String str, ResultInfo resultInfo, SessGCSendLocAck sessGCSendLocAck);

    void a(String str, ResultInfo resultInfo, SessGCSendMultMsgAck sessGCSendMultMsgAck);

    void a(String str, ResultInfo resultInfo, SessGCSendTxtMsgAck sessGCSendTxtMsgAck);

    void a(String str, ResultInfo resultInfo, SessGCSetChairAck sessGCSetChairAck);

    void a(String str, ResultInfo resultInfo, String str2);

    void a(String str, GroupChatGetFileRate groupChatGetFileRate);

    void a(String str, GroupChatSendFileRate groupChatSendFileRate);

    void a(String str, SessGCRecvMultMsgRate sessGCRecvMultMsgRate);

    void b(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr);

    void b(String str);

    void b(String str, int i, String str2);

    void b(String str, ResultInfo resultInfo);

    void b(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck);

    void b(String str, ResultInfo resultInfo, String str2);

    void b(String str, String str2);

    void c(String str, ResultInfo resultInfo);

    void c(String str, ResultInfo resultInfo, String str2);

    void c(String str, String str2);

    void d(String str, ResultInfo resultInfo);

    void d(String str, ResultInfo resultInfo, String str2);

    void e(String str, ResultInfo resultInfo, String str2);

    void f(String str, ResultInfo resultInfo, String str2);

    void f(String str, String str2);

    void g(String str, ResultInfo resultInfo, String str2);

    void h(String str, ResultInfo resultInfo, String str2);

    void i(String str, ResultInfo resultInfo, String str2);
}
