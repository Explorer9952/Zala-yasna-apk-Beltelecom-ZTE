package com.zte.ucs.tvcall.ocx;

import com.zte.ucs.tvcall.ocx.audioconf.VoiceConfMemState;
import com.zte.ucs.tvcall.ocx.card.CardMsgInfo;
import com.zte.ucs.tvcall.ocx.card.CardSendMsgRespInfo;
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
import com.zte.ucs.tvcall.ocx.mail.MailMsgMediaArticle;
import com.zte.ucs.tvcall.ocx.message.GrpSendLargeMsgRateInfo;
import com.zte.ucs.tvcall.ocx.message.GrpSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.message.MsgRevokeRespInfo;
import com.zte.ucs.tvcall.ocx.message.SingleFileBase;
import com.zte.ucs.tvcall.ocx.message.SingleGetFileRate;
import com.zte.ucs.tvcall.ocx.message.SingleGetFileResp;
import com.zte.ucs.tvcall.ocx.message.SingleMsgInfo;
import com.zte.ucs.tvcall.ocx.message.SingleMsgRevokeRpt;
import com.zte.ucs.tvcall.ocx.message.SingleMultMsgInfo;
import com.zte.ucs.tvcall.ocx.message.SingleRecvLocationInfo;
import com.zte.ucs.tvcall.ocx.message.SingleRecvReportInfo;
import com.zte.ucs.tvcall.ocx.message.SingleRecvTypingInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendFileRate;
import com.zte.ucs.tvcall.ocx.message.SingleSendLocationResp;
import com.zte.ucs.tvcall.ocx.message.SingleSendMsgResp;
import com.zte.ucs.tvcall.ocx.message.SingleSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.message.SingleSendReportResp;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressResp;
import com.zte.ucs.tvcall.ocx.nab.ContactBaseInfo;
import com.zte.ucs.tvcall.ocx.nab.OfflineContactInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileResp;
import com.zte.ucs.tvcall.ocx.nab.UserPrefsResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstCompareDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstContactNodeInDirectory;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGetDirectoryResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstGroupMsgDndListOperationResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadContactResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadUserPrefResp;
import com.zte.ucs.tvcall.ocx.nabst.NabstLocalEtagSynNotify;
import com.zte.ucs.tvcall.ocx.nabst.NabstSingMsgDndListOperationResp;
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
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvLocInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvMultMsgInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvReportInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendLocResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendReportResp;
import com.zte.ucs.tvcall.ocx.presence.PresContactFreeTextSynNotify;
import com.zte.ucs.tvcall.ocx.presence.PresContactNode;
import com.zte.ucs.tvcall.ocx.presence.PresDocumentInfoNode;
import com.zte.ucs.tvcall.ocx.presence.PresPersonalFreeTextNotify;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalNotify;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalResp;
import com.zte.ucs.tvcall.ocx.presence.PresUploadFreeTextResp;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaMsgContentRecvInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaDetailInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMainMenuInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMsgContent;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendFileRate;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendRptResp;
import com.zte.ucs.tvcall.ocx.telephone.CallThrowScreenRspInfo;
import com.zte.ucs.tvcall.ocx.telephone.CallTransferRspInfo;
import com.zte.ucs.tvcall.ocx.videoconf.CallVideoConfParticipantSoundState;
import com.zte.ucs.tvcall.ocx.videoconf.CallVideoConfSoundControlResp;
import com.zte.ucs.tvcall.ocx.wb.WBShareSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.wb.WhiteBoardShareType;
import com.zte.ucs.tvcall.ocx.xcap.XCAPInterfaceResp;
import d.e.b.a.c.l;
import d.e.b.a.c.n;
import d.e.b.b.f;
import d.e.b.c.c.b;
import d.e.b.c.c.d;
import d.e.b.c.c.h;
import d.e.b.c.c.j;

/* loaded from: classes2.dex */
public class OcxEventCallBack {
    public static void java_AddNabContactBase(int i, String str, int i2, String str2, String str3) {
        f.a();
        f.h().a(i, str, i2, str2, str3);
    }

    public static void java_CBBroadBandGetDmCfgInfo(b bVar) {
        f.a();
        f.m().a(bVar);
    }

    public static void java_CBBroadBandGetDmCookie(d dVar) {
        f.a();
        f.m().a(dVar);
    }

    public static void java_CBBroadBandQueryAccount(d.e.b.c.c.f fVar) {
        f.a();
        f.m().a(fVar);
    }

    public static void java_CBBroadBandSmsCodeReturn(h hVar) {
        f.a();
        f.m().a(hVar);
    }

    public static void java_CBBroadBandVerifyECOPAccount(j jVar) {
        f.a();
        f.m().a(jVar);
    }

    public static void java_CBCallThrowScreen(CallThrowScreenRspInfo callThrowScreenRspInfo) {
        f.a();
        f.g().a(callThrowScreenRspInfo);
    }

    public static void java_CBCallTranfer(CallTransferRspInfo callTransferRspInfo) {
        f.a();
        f.g().a(callTransferRspInfo);
    }

    public static void java_CBCallVideoConfParticipantSoundState(CallVideoConfParticipantSoundState callVideoConfParticipantSoundState) {
        f.a();
        f.g().a(callVideoConfParticipantSoundState);
    }

    public static void java_CBCallVideoConfSoundControl(CallVideoConfSoundControlResp callVideoConfSoundControlResp) {
        f.a();
        f.g().a(callVideoConfSoundControlResp);
    }

    public static void java_CBGrpSendMsgAck(GrpSendMsgRespInfo grpSendMsgRespInfo) {
        f.a();
        f.d().a(grpSendMsgRespInfo);
    }

    public static void java_CBGrpSendMsgMultRate(GrpSendLargeMsgRateInfo grpSendLargeMsgRateInfo) {
        f.a();
        f.d().a(grpSendLargeMsgRateInfo);
    }

    public static void java_CBMailRecvMsg(MailMsgMediaArticle mailMsgMediaArticle) {
        f.a();
        f.d().a(mailMsgMediaArticle);
    }

    public static void java_CBUnifiedAuthApplyToken(d.e.b.a.c.b bVar) {
        f.a();
        f.k().a(bVar);
    }

    public static void java_CBUnifiedAuthModifyPassword(d.e.b.a.c.d dVar) {
        f.a();
        f.k().a(dVar);
    }

    public static void java_CBUnifiedAuthRefreshToken(d.e.b.a.c.f fVar) {
        f.a();
        f.k().a(fVar);
    }

    public static void java_CBUnifiedAuthResult(d.e.b.a.c.h hVar) {
        f.a();
        f.k().a(hVar);
    }

    public static void java_CBUnifiedAuthSmsVerification(d.e.b.a.c.j jVar) {
        f.a();
        f.k().a(jVar);
    }

    public static void java_CBUnifiedAuthSmscodeReturn(l lVar) {
        f.a();
        f.k().a(lVar);
    }

    public static void java_CBUnifiedAuthStart(n nVar) {
        f.a();
        f.k().a(nVar);
    }

    public static void java_CardmsgRcv(CardMsgInfo cardMsgInfo) {
        f.a();
        f.c().a(cardMsgInfo);
    }

    public static void java_CardmsgSendResp(String str, ResultInfo resultInfo, CardSendMsgRespInfo cardSendMsgRespInfo) {
        f.a();
        f.c().a(str, resultInfo, cardSendMsgRespInfo);
    }

    public static void java_CheckNAB(String str, int i, String str2, ProfileResp profileResp, UserPrefsResp userPrefsResp, int i2, int i3, int i4, ContactAddressResp[] contactAddressRespArr) {
        f.a();
        f.h().a(str, i, str2, profileResp, userPrefsResp, i2, i3, i4, contactAddressRespArr);
    }

    public static void java_CheckNABOffline(String str, int i, String str2, int i2, ContactAddressResp[] contactAddressRespArr) {
        f.a();
        f.i().a(str, i, str2, i2, contactAddressRespArr);
    }

    public static void java_ConferenceDetailInfo(String str, int i) {
        f.a();
        f.g().f(str, i);
    }

    public static void java_ConferenceParticipantStatus(String str, String str2, int i, int i2) {
        f.a();
        f.g().a(str, str2, i, i2);
    }

    public static void java_ConferenceSubscribeResp(String str, int i) {
        f.a();
        f.g().c(str, i);
    }

    public static void java_Conferenceinvite(String str, String str2) {
        f.a();
        f.g().e(str, str2);
    }

    public static void java_Conferenceinviteuser(String str, int i, String str2, String str3) {
        f.a();
        f.g().a(str, i, str2, str3);
    }

    public static void java_CreateVideoConference(String str, int i, String str2) {
        f.a();
        f.g().a(str, i, str2);
    }

    public static void java_DelNabContactBase(String str, int i, String str2, String str3) {
        f.a();
        f.h().c(str, i, str2, str3);
    }

    public static void java_DeviceRequestStatus(int i) {
        f.a();
        f.g().f(i);
    }

    public static void java_FireAlreadyLogout(int i) {
        f.a();
        f.f().d(i);
    }

    public static void java_FireCalleeForward(String str, String str2) {
        f.a();
        f.g().d(str, str2);
    }

    public static void java_FireCreateCallSessionAck(int i, String str, String str2, String str3) {
        f.a();
        f.l().a(i, str, str2, str3);
    }

    public static void java_FireCreateConfCallResult(String str, String str2, int i, int i2, int i3) {
        f.a();
        f.g().a(str, str2, i, i2, i3);
    }

    public static void java_FireIMSCallEvent(int i, String str, Object obj) {
        f.a();
        f.g().a(i, str, obj);
    }

    public static void java_FireIMSRCSQueryShareAbility(int i, String str, String str2) {
        f.a();
        f.f().a(i, str, str2);
    }

    public static void java_FireIVVRClickEvent(String str, String str2) {
        f.a();
        f.g().a(str, str2);
    }

    public static void java_FireLogonResult(int i, int i2, int i3) {
        f.a();
        f.f().a(i, i2, i3);
    }

    public static void java_FireLogoutServerSuccess() {
        f.a();
        f.f().b();
    }

    public static void java_FireMtSessGetMoments_Result(int i) {
        f.a();
        f.c().e(i);
    }

    public static void java_FireNewCallWhenBusy2(String str, int i, int i2, String str2) {
        f.a();
        f.g().a(str, i, i2, str2);
    }

    public static void java_FireNotifyReLogin(int i) {
        f.a();
        f.f().c(i);
    }

    public static void java_FirePTSessGetParty_Result(int i) {
        f.a();
        f.c().b(i);
    }

    public static void java_FirePaComplain_Result(String str, String str2, int i, int i2, String str3) {
        f.a();
        f.c().d(str, str2, i, i2, str3);
    }

    public static void java_FirePaMsgRecv(FirePaMsgContentRecvInfo firePaMsgContentRecvInfo) {
        f.a();
        f.c().a(firePaMsgContentRecvInfo);
    }

    public static void java_FirePaSessAddSubs_Result(String str, String str2, int i, int i2, String str3) {
        f.a();
        f.c().e(str, str2, i, i2, str3);
    }

    public static void java_FirePaSessCancelSubs_Result(String str, String str2, int i, int i2, String str3) {
        f.a();
        f.c().c(str, str2, i, i2, str3);
    }

    public static void java_FirePaSessGetPubDetail_Result(String str, String str2, int i, int i2, PaDetailInfo paDetailInfo) {
        f.a();
        f.c().a(str, str2, i, i2, paDetailInfo);
    }

    public static void java_FirePaSessGetPubLstRecmd_Result(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        f.a();
        f.c().c(str, str2, i, i2, i3, paInfoArr);
    }

    public static void java_FirePaSessGetPubMenu_Result(String str, String str2, int i, int i2, String str3, int i3, PaMainMenuInfo[] paMainMenuInfoArr) {
        f.a();
        f.c().a(str, str2, i, i2, str3, i3, paMainMenuInfoArr);
    }

    public static void java_FirePaSessGetPubPreMsg_Result(String str, String str2, int i, int i2, String str3, int i3, PaMsgContent[] paMsgContentArr) {
        f.a();
        f.c().a(str, str2, i, i2, str3, i3, paMsgContentArr);
    }

    public static void java_FirePaSessNotifyMenuEvent_Result(String str, String str2, int i, int i2, String str3) {
        f.a();
        f.c().b(str, str2, i, i2, str3);
    }

    public static void java_FirePaSessQryUsrSubs_Result(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        f.a();
        f.c().b(str, str2, i, i2, i3, paInfoArr);
    }

    public static void java_FirePaSessSearchPA_Result(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        f.a();
        f.c().a(str, str2, i, i2, i3, paInfoArr);
    }

    public static void java_FirePaSessSetAcptStat_Result(String str, String str2, int i, int i2, String str3) {
        f.a();
        f.c().a(str, str2, i, i2, str3);
    }

    public static void java_FirePaSessUpdatePubDetail_Result(int i, String str) {
        f.a();
        f.c().a(i, str);
    }

    public static void java_FirePaSessUpdatePubList_Result(int i) {
        f.a();
        f.c().g(i);
    }

    public static void java_FireRegisterSoftPhoneToSS(String str, int i) {
        f.a();
        f.f().e(str, i);
    }

    public static void java_FireReportMemberStatus(String str, int i, int i2) {
        f.a();
        f.g().a(str, i, i2);
    }

    public static void java_FireServerLinkLost() {
        f.a();
        f.f().a();
    }

    public static void java_FireSomeOneCallMe(String str, int i) {
        f.a();
        f.g().b(str, i);
    }

    public static void java_FireTerminateCallSessionAck(int i, String str, String str2) {
        f.a();
        f.l().b(i, str, str2);
    }

    public static void java_FirstFrame(int i) {
        f.a();
        f.g().h(i);
    }

    public static void java_GCApplyForJoinGroupAck(String str, ResultInfo resultInfo, GCApplyForJoinGroupAck gCApplyForJoinGroupAck) {
        f.a();
        f.b().a(str, resultInfo, gCApplyForJoinGroupAck);
    }

    public static void java_GCAuditJoinGroupAck(String str, ResultInfo resultInfo, GCAuditJoinGroupAck gCAuditJoinGroupAck) {
        f.a();
        f.b().a(str, resultInfo, gCAuditJoinGroupAck);
    }

    public static void java_GCGenerateQRCodeAck(String str, ResultInfo resultInfo, GCGenerateQRCodeAck gCGenerateQRCodeAck) {
        f.a();
        f.b().a(str, resultInfo, gCGenerateQRCodeAck);
    }

    public static void java_GCRecvApplyForJoinGroupRslt(GCRecvApplyForJoinGroupRslt gCRecvApplyForJoinGroupRslt) {
        f.a();
        f.b().a(gCRecvApplyForJoinGroupRslt);
    }

    public static void java_GCRecvJoinGroupApplication(GCRecvJoinGroupApplication gCRecvJoinGroupApplication) {
        f.a();
        f.b().a(gCRecvJoinGroupApplication);
    }

    public static void java_GCScanQRCodeAck(String str, ResultInfo resultInfo, GCScanQRCodeAck gCScanQRCodeAck) {
        f.a();
        f.b().a(str, resultInfo, gCScanQRCodeAck);
    }

    public static void java_GCsetJoinChatAuditAuthAck(String str, ResultInfo resultInfo) {
        f.a();
        f.b().b(str, resultInfo);
    }

    public static void java_GroupChatGetFileRate(String str, GroupChatGetFileRate groupChatGetFileRate) {
        f.a();
        f.b().a(str, groupChatGetFileRate);
    }

    public static void java_GroupChatGetLargerFile(String str, ResultInfo resultInfo, GroupChatGetFileResp groupChatGetFileResp) {
        f.a();
        f.b().a(str, resultInfo, groupChatGetFileResp);
    }

    public static void java_GroupChatSendFileRate(String str, GroupChatSendFileRate groupChatSendFileRate) {
        f.a();
        f.b().a(str, groupChatSendFileRate);
    }

    public static void java_GroupChatSendLocResp(String str, ResultInfo resultInfo, GroupChatSendLocResp groupChatSendLocResp) {
        f.a();
        f.b().a(str, resultInfo, groupChatSendLocResp);
    }

    public static void java_GroupMsgRevokeRcv(GroupMsgRevokeRpt groupMsgRevokeRpt) {
        f.a();
        f.b().a(groupMsgRevokeRpt);
    }

    public static void java_MsgRevokeResp(MsgRevokeRespInfo msgRevokeRespInfo) {
        f.a();
        f.d().a(msgRevokeRespInfo);
    }

    public static void java_NabstAddContact(NabstAddContactResp nabstAddContactResp) {
        f.a();
        f.j().a(nabstAddContactResp);
    }

    public static void java_NabstAddUserPref(NabstAddUserPrefResp nabstAddUserPrefResp) {
        f.a();
        f.j().a(nabstAddUserPrefResp);
    }

    public static void java_NabstCompareDirectory(NabstCompareDirectoryResp nabstCompareDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr) {
        f.a();
        f.j().a(nabstCompareDirectoryResp, nabstContactNodeInDirectoryArr);
    }

    public static void java_NabstDeleteContact(NabstDeleteContactResp nabstDeleteContactResp) {
        f.a();
        f.j().a(nabstDeleteContactResp);
    }

    public static void java_NabstDeleteUserPref(NabstDeleteUserPrefResp nabstDeleteUserPrefResp) {
        f.a();
        f.j().a(nabstDeleteUserPrefResp);
    }

    public static void java_NabstGetDirectory(NabstGetDirectoryResp nabstGetDirectoryResp, NabstContactNodeInDirectory[] nabstContactNodeInDirectoryArr) {
        f.a();
        f.j().a(nabstGetDirectoryResp, nabstContactNodeInDirectoryArr);
    }

    public static void java_NabstGroupMsgDndListOperation(NabstGroupMsgDndListOperationResp nabstGroupMsgDndListOperationResp) {
        f.a();
        f.j().a(nabstGroupMsgDndListOperationResp);
    }

    public static void java_NabstLoadContact(NabstLoadContactResp nabstLoadContactResp) {
        f.a();
        f.j().a(nabstLoadContactResp);
    }

    public static void java_NabstLoadUserPref(NabstLoadUserPrefResp nabstLoadUserPrefResp) {
        f.a();
        f.j().a(nabstLoadUserPrefResp);
    }

    public static void java_NabstLocalEtagSynNotify(NabstLocalEtagSynNotify nabstLocalEtagSynNotify) {
        f.a();
        f.j().a(nabstLocalEtagSynNotify);
    }

    public static void java_NabstSingMsgDndListOperation(NabstSingMsgDndListOperationResp nabstSingMsgDndListOperationResp) {
        f.a();
        f.j().a(nabstSingMsgDndListOperationResp);
    }

    public static void java_NabstUpLoadContact(NabstUpLoadContactResp nabstUpLoadContactResp) {
        f.a();
        f.j().a(nabstUpLoadContactResp);
    }

    public static void java_NabstUpLoadContactAddress(NabstUpLoadContactAddressResp nabstUpLoadContactAddressResp) {
        f.a();
        f.j().a(nabstUpLoadContactAddressResp);
    }

    public static void java_NabstUpLoadContactBirthday(NabstUpLoadContactBirthdayResp nabstUpLoadContactBirthdayResp) {
        f.a();
        f.j().a(nabstUpLoadContactBirthdayResp);
    }

    public static void java_NabstUpLoadContactCommAddr(NabstUpLoadContactCommAddrResp nabstUpLoadContactCommAddrResp) {
        f.a();
        f.j().a(nabstUpLoadContactCommAddrResp);
    }

    public static void java_NabstUpLoadContactGroupInfo(NabstUpLoadContactGroupInfoResp nabstUpLoadContactGroupInfoResp) {
        f.a();
        f.j().a(nabstUpLoadContactGroupInfoResp);
    }

    public static void java_NabstUpLoadContactName(NabstUpLoadContactNameResp nabstUpLoadContactNameResp) {
        f.a();
        f.j().a(nabstUpLoadContactNameResp);
    }

    public static void java_NabstUpLoadContactNote(NabstUpLoadContactNoteResp nabstUpLoadContactNoteResp) {
        f.a();
        f.j().a(nabstUpLoadContactNoteResp);
    }

    public static void java_NabstUpLoadContactOrgName(NabstUpLoadContactOrgNameResp nabstUpLoadContactOrgNameResp) {
        f.a();
        f.j().a(nabstUpLoadContactOrgNameResp);
    }

    public static void java_NabstUpLoadUserCallingSetting(NabstUpLoadUserCallingSettingResp nabstUpLoadUserCallingSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserCallingSettingResp);
    }

    public static void java_NabstUpLoadUserContactsSetting(NabstUpLoadUserContactsSettingResp nabstUpLoadUserContactsSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserContactsSettingResp);
    }

    public static void java_NabstUpLoadUserExtendSetting(NabstUpLoadUserExtendSettingResp nabstUpLoadUserExtendSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserExtendSettingResp);
    }

    public static void java_NabstUpLoadUserMsgDndSetting(NabstUpLoadUserMsgDndSettingResp nabstUpLoadUserMsgDndSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserMsgDndSettingResp);
    }

    public static void java_NabstUpLoadUserMsgNotifySetting(NabstUpLoadUserMsgNotifySettingResp nabstUpLoadUserMsgNotifySettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserMsgNotifySettingResp);
    }

    public static void java_NabstUpLoadUserMsgPlayModSetting(NabstUpLoadUserMsgPlayModSettingResp nabstUpLoadUserMsgPlayModSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserMsgPlayModSettingResp);
    }

    public static void java_NabstUpLoadUserMsgReminSetting(NabstUpLoadUserMsgReminSettingResp nabstUpLoadUserMsgReminSettingResp) {
        f.a();
        f.j().a(nabstUpLoadUserMsgReminSettingResp);
    }

    public static void java_NfyHoldResult(String str, int i, int i2) {
        f.a();
        f.g().b(str, i, i2);
    }

    public static void java_NfyVoiceConfInvite(String str, String str2, String str3, int i, int i2) {
        f.a();
        f.g().a(str, str2, str3, i, i2);
    }

    public static void java_NfyVoiceConfMemState(int i, VoiceConfMemState[] voiceConfMemStateArr) {
        f.a();
        f.g().a(i, voiceConfMemStateArr);
    }

    public static void java_NfyVoiceConfStateResp(String str, int i) {
        f.a();
        f.g().d(str, i);
    }

    public static void java_NotifyMediaStreamInfo(int i) {
        f.a();
        f.g().a(i);
    }

    public static void java_NotifyRealVideoFormate(int i, int i2) {
        f.a();
        f.g().a(i, i2);
    }

    public static void java_NotifyUIMediaInitFinished(String str, int i) {
        f.a();
        f.g().a(str, i);
    }

    public static void java_PASendReport(String str, ResultInfo resultInfo, PaSendRptResp paSendRptResp) {
        f.a();
        f.c().a(str, resultInfo, paSendRptResp);
    }

    public static void java_PaSendFileRate(String str, PaSendFileRate paSendFileRate) {
        f.a();
        f.c().a(str, paSendFileRate);
    }

    public static void java_PaSendMsg(String str, ResultInfo resultInfo, PaSendMsgResp paSendMsgResp) {
        f.a();
        f.c().a(str, resultInfo, paSendMsgResp);
    }

    public static void java_PaSendMultMsg(String str, ResultInfo resultInfo, PaSendMultMsgResp paSendMultMsgResp) {
        f.a();
        f.c().a(str, resultInfo, paSendMultMsgResp);
    }

    public static void java_PrecallRecvLoc(PrecallRecvLocInfo precallRecvLocInfo) {
        f.a();
        f.d().a(precallRecvLocInfo);
    }

    public static void java_PrecallRecvMultMsg(PrecallRecvMultMsgInfo precallRecvMultMsgInfo) {
        f.a();
        f.d().a(precallRecvMultMsgInfo);
    }

    public static void java_PrecallRecvReport(PrecallRecvReportInfo precallRecvReportInfo) {
        f.a();
        f.d().a(precallRecvReportInfo);
    }

    public static void java_PrecallSendLocAck(String str, ResultInfo resultInfo, PrecallSendLocResp precallSendLocResp) {
        f.a();
        f.d().a(str, resultInfo, precallSendLocResp);
    }

    public static void java_PrecallSendMultMsgAck(String str, ResultInfo resultInfo, PrecallSendMultMsgResp precallSendMultMsgResp) {
        f.a();
        f.d().a(str, resultInfo, precallSendMultMsgResp);
    }

    public static void java_PrecallSendReportAck(String str, ResultInfo resultInfo, PrecallSendReportResp precallSendReportResp) {
        f.a();
        f.d().a(str, resultInfo, precallSendReportResp);
    }

    public static void java_PresAddBuddyNotify(PresUniversalNotify presUniversalNotify) {
        f.a();
        f.n().c(presUniversalNotify);
    }

    public static void java_PresAddUserIntoBlockList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().a(str, resultInfo, presUniversalResp);
    }

    public static void java_PresAddUserIntoRCSList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().m(str, resultInfo, presUniversalResp);
    }

    public static void java_PresAddUserIntoRevokeList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().k(str, resultInfo, presUniversalResp);
    }

    public static void java_PresBuddyStatusNotify(PresUniversalNotify presUniversalNotify) {
        f.a();
        f.n().b(presUniversalNotify);
    }

    public static void java_PresCheckDocuments(String str, ResultInfo resultInfo, PresDocumentInfoNode[] presDocumentInfoNodeArr) {
        f.a();
        f.n().a(str, resultInfo, presDocumentInfoNodeArr);
    }

    public static void java_PresContactFreeTextSynNotify(PresContactFreeTextSynNotify presContactFreeTextSynNotify) {
        f.a();
        f.n().a(presContactFreeTextSynNotify);
    }

    public static void java_PresContactIconChangedNotify(PresUniversalNotify presUniversalNotify) {
        f.a();
        f.n().a(presUniversalNotify);
    }

    public static void java_PresContactListReturn(String str, String str2, PresContactNode[] presContactNodeArr) {
        f.a();
        f.n().a(str, str2, presContactNodeArr);
    }

    public static void java_PresContentReturn(String str, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().a(str, presUniversalResp);
    }

    public static void java_PresDeleteUserFromBlockList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().i(str, resultInfo, presUniversalResp);
    }

    public static void java_PresDeleteUserFromRCSList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().c(str, resultInfo, presUniversalResp);
    }

    public static void java_PresDeleteUserFromRevokeList(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().n(str, resultInfo, presUniversalResp);
    }

    public static void java_PresFreeTextReturn(PresPersonalFreeTextNotify presPersonalFreeTextNotify) {
        f.a();
        f.n().a(presPersonalFreeTextNotify);
    }

    public static void java_PresLoadContactIcon(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().b(str, resultInfo, presUniversalResp);
    }

    public static void java_PresLoadCurrentDocument(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().g(str, resultInfo, presUniversalResp);
    }

    public static void java_PresSubscribeAllInfo(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().j(str, resultInfo, presUniversalResp);
    }

    public static void java_PresSubscribeRLSInfo(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().f(str, resultInfo, presUniversalResp);
    }

    public static void java_PresSubscribeWatcherInfo(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().l(str, resultInfo, presUniversalResp);
    }

    public static void java_PresUploadDefaultDocument(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().d(str, resultInfo, presUniversalResp);
    }

    public static void java_PresUploadFreeText(PresUploadFreeTextResp presUploadFreeTextResp) {
        f.a();
        f.n().a(presUploadFreeTextResp);
    }

    public static void java_PresUploadPersonalIcon(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().h(str, resultInfo, presUniversalResp);
    }

    public static void java_PresUploadPresenceXDMS(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp) {
        f.a();
        f.n().e(str, resultInfo, presUniversalResp);
    }

    public static void java_QueryNabContactBase(String str, int i, String str2, String str3, int i2, ContactBaseInfo[] contactBaseInfoArr) {
        f.a();
        f.h().a(str, i, str2, str3, i2, contactBaseInfoArr);
    }

    public static void java_SessGCAcceptInviteAck(String str, ResultInfo resultInfo, SessGCAcceptInviteAck sessGCAcceptInviteAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCAcceptInviteAck);
    }

    public static void java_SessGCActiveAck(String str, ResultInfo resultInfo, SessGCActiveAck sessGCActiveAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCActiveAck);
    }

    public static void java_SessGCActivity(SessGCActivityInfo sessGCActivityInfo) {
        f.a();
        f.b().a(sessGCActivityInfo);
    }

    public static void java_SessGCAddMberAck(String str, ResultInfo resultInfo, SessGCAddMberAck sessGCAddMberAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCAddMberAck);
    }

    public static void java_SessGCCreateChatAck(String str, ResultInfo resultInfo, SessGCCreateChatAck sessGCCreateChatAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCCreateChatAck);
    }

    public static void java_SessGCDismissChatAck(String str, ResultInfo resultInfo, SessGCDismissChatAck sessGCDismissChatAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCDismissChatAck);
    }

    public static void java_SessGCGetGroupListAck(String str, ResultInfo resultInfo) {
        f.a();
        f.b().c(str, resultInfo);
    }

    public static void java_SessGCGetMberListAck(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCMberListAck);
    }

    public static void java_SessGCInActivity(SessGCInActivityInfo sessGCInActivityInfo) {
        f.a();
        f.b().a(sessGCInActivityInfo);
    }

    public static void java_SessGCModifyNickNameAck(String str, ResultInfo resultInfo, SessGCModifyNickNameAck sessGCModifyNickNameAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCModifyNickNameAck);
    }

    public static void java_SessGCModifySubjectAck(String str, ResultInfo resultInfo, SessGCModifySubjectAck sessGCModifySubjectAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCModifySubjectAck);
    }

    public static void java_SessGCQuitChatAck(String str, ResultInfo resultInfo, SessGCQuitChatAck sessGCQuitChatAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCQuitChatAck);
    }

    public static void java_SessGCRecvBoot(SessGCRecvBootChatInfo sessGCRecvBootChatInfo) {
        f.a();
        f.b().a(sessGCRecvBootChatInfo);
    }

    public static void java_SessGCRecvCreateChat(SessGCRecvCreateChatInfo sessGCRecvCreateChatInfo) {
        f.a();
        f.b().a(sessGCRecvCreateChatInfo);
    }

    public static void java_SessGCRecvDismiss(SessGCRecvDismissChatInfo sessGCRecvDismissChatInfo) {
        f.a();
        f.b().a(sessGCRecvDismissChatInfo);
    }

    public static void java_SessGCRecvLargerMultAck(String str, ResultInfo resultInfo, SessGCRecvLargerMult sessGCRecvLargerMult) {
        f.a();
        f.b().a(str, resultInfo, sessGCRecvLargerMult);
    }

    public static void java_SessGCRecvLoc(SessGCRecvLocInfo sessGCRecvLocInfo) {
        f.a();
        f.b().a(sessGCRecvLocInfo);
    }

    public static void java_SessGCRecvMultBase(SessGCRecvMultBase sessGCRecvMultBase) {
        f.a();
        f.b().a(sessGCRecvMultBase);
    }

    public static void java_SessGCRecvMultMsg(SessGCRecvMultMsgInfo sessGCRecvMultMsgInfo) {
        f.a();
        f.b().a(sessGCRecvMultMsgInfo);
    }

    public static void java_SessGCRecvMultMsgRate(String str, SessGCRecvMultMsgRate sessGCRecvMultMsgRate) {
        f.a();
        f.b().a(str, sessGCRecvMultMsgRate);
    }

    public static void java_SessGCRecvTxtMsg(SessGCRecvTxtMsgInfo sessGCRecvTxtMsgInfo) {
        f.a();
        f.b().a(sessGCRecvTxtMsgInfo);
    }

    public static void java_SessGCRejoinChatAck(String str, ResultInfo resultInfo, SessGCMberListAck sessGCMberListAck) {
        f.a();
        f.b().b(str, resultInfo, sessGCMberListAck);
    }

    public static void java_SessGCRemoveMberAck(String str, ResultInfo resultInfo, SessGCRemoveMemberAck sessGCRemoveMemberAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCRemoveMemberAck);
    }

    public static void java_SessGCSendLocAck(String str, ResultInfo resultInfo, SessGCSendLocAck sessGCSendLocAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCSendLocAck);
    }

    public static void java_SessGCSendMultMsgAck(String str, ResultInfo resultInfo, SessGCSendMultMsgAck sessGCSendMultMsgAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCSendMultMsgAck);
    }

    public static void java_SessGCSendMultMsgRate(SessGCSendMultMsgRate sessGCSendMultMsgRate) {
        f.a();
        f.b().a(sessGCSendMultMsgRate);
    }

    public static void java_SessGCSendTxtMsgAck(String str, ResultInfo resultInfo, SessGCSendTxtMsgAck sessGCSendTxtMsgAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCSendTxtMsgAck);
    }

    public static void java_SessGCSetChairAck(String str, ResultInfo resultInfo, SessGCSetChairAck sessGCSetChairAck) {
        f.a();
        f.b().a(str, resultInfo, sessGCSetChairAck);
    }

    public static void java_SessGC_NfyBoot(SessGCNfyBootChatInfo sessGCNfyBootChatInfo) {
        f.a();
        f.b().a(sessGCNfyBootChatInfo);
    }

    public static void java_SessGC_NfyConfMberList(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr) {
        f.a();
        f.b().b(sessGCMberListBase, i, sessGCMberInfoArr);
    }

    public static void java_SessGC_NfyGroupList(int i, SessGCNfyGetGroupInfo[] sessGCNfyGetGroupInfoArr) {
        f.a();
        f.b().a(i, sessGCNfyGetGroupInfoArr);
    }

    public static void java_SessGC_NfyMberConnect(SessGCMberConnectInfo sessGCMberConnectInfo) {
        f.a();
        f.b().a(sessGCMberConnectInfo);
    }

    public static void java_SessGC_NfyMberList(SessGCMberListBase sessGCMberListBase, int i, SessGCMberInfo[] sessGCMberInfoArr) {
        f.a();
        f.b().a(sessGCMberListBase, i, sessGCMberInfoArr);
    }

    public static void java_SessGC_NfyModifySubject(SessGCNfySubjectInfo sessGCNfySubjectInfo) {
        f.a();
        f.b().a(sessGCNfySubjectInfo);
    }

    public static void java_SessGC_NfyQuitChat(SessGCNfyQuitChatInfo sessGCNfyQuitChatInfo) {
        f.a();
        f.b().a(sessGCNfyQuitChatInfo);
    }

    public static void java_SingleMsgRevokeRcv(SingleMsgRevokeRpt singleMsgRevokeRpt) {
        f.a();
        f.d().a(singleMsgRevokeRpt);
    }

    public static void java_SingleSendLocationResp(String str, ResultInfo resultInfo, SingleSendLocationResp singleSendLocationResp) {
        f.a();
        f.d().a(str, resultInfo, singleSendLocationResp);
    }

    public static void java_SingleSendTypingAck(String str, ResultInfo resultInfo) {
        f.a();
        f.d().a(str, resultInfo);
    }

    public static void java_Switchtofront(String str, int i, String str2, String str3) {
        f.a();
        f.g().b(str, i, str2, str3);
    }

    public static void java_WBShareRcv(WhiteBoardShareType whiteBoardShareType) {
        f.a();
        f.d().a(whiteBoardShareType);
    }

    public static void java_WBShareSendResp(WBShareSendMsgRespInfo wBShareSendMsgRespInfo) {
        f.a();
        f.d().a(wBShareSendMsgRespInfo);
    }

    public static void java_XCAPInterface(XCAPInterfaceResp xCAPInterfaceResp) {
        f.a();
        f.o().a(xCAPInterfaceResp);
    }

    public static void java_abortConversation(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().h(str, resultInfo, str2);
    }

    public static void java_acceptInvitationAck(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().f(str, resultInfo, str2);
    }

    public static void java_addContactAddress(String str, int i, ContactAddressInfo contactAddressInfo) {
        f.a();
        f.h().b(str, i, contactAddressInfo);
    }

    public static void java_addOfflineContactAddress(String str, int i, OfflineContactInfo offlineContactInfo) {
        f.a();
        f.i().c(str, i, offlineContactInfo);
    }

    public static void java_addParticipants(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().c(str, resultInfo, str2);
    }

    public static void java_addProfile(String str, int i, ProfileInfo profileInfo) {
        f.a();
        f.h().c(str, i, profileInfo);
    }

    public static void java_deleteContactAddress(String str, int i, ContactAddressInfo contactAddressInfo) {
        f.a();
        f.h().d(str, i, contactAddressInfo);
    }

    public static void java_deleteOfflineContactAddress(String str, int i, OfflineContactInfo offlineContactInfo) {
        f.a();
        f.i().b(str, i, offlineContactInfo);
    }

    public static void java_deleteProfile(String str, int i, ProfileInfo profileInfo) {
        f.a();
        f.h().a(str, i, profileInfo);
    }

    public static void java_getMyGroupChat(String str, ResultInfo resultInfo) {
        f.a();
        f.b().d(str, resultInfo);
    }

    public static void java_getParticipantList(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().a(str, resultInfo, str2);
    }

    public static void java_groupChatSendMsg(String str, ResultInfo resultInfo, GroupChatSendMsgResp groupChatSendMsgResp) {
        f.a();
        f.b().a(str, resultInfo, groupChatSendMsgResp);
    }

    public static void java_groupChatSendMultMsg(String str, ResultInfo resultInfo, GroupChatSendMultMsgResp groupChatSendMultMsgResp) {
        f.a();
        f.b().a(str, resultInfo, groupChatSendMultMsgResp);
    }

    public static void java_initiateGroupChat(String str, ResultInfo resultInfo, InitiateGroupChatOutInfo initiateGroupChatOutInfo) {
        f.a();
        f.b().a(str, resultInfo, initiateGroupChatOutInfo);
    }

    public static void java_modifyNickName(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().i(str, resultInfo, str2);
    }

    public static void java_modifySubject(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().b(str, resultInfo, str2);
    }

    public static void java_notify_abortConversation(String str) {
        f.a();
        f.b().b(str);
    }

    public static void java_notify_bootConversation(String str, String str2) {
        f.a();
        f.b().b(str, str2);
    }

    @Deprecated
    public static void java_notify_confer_getMemList(int i, String str, ParticipantOutInfo[] participantOutInfoArr) {
        f.a();
        f.b().a(i, str, participantOutInfoArr);
    }

    public static void java_notify_getGroupChatList(int i, NotifyGroupChatOutInfo[] notifyGroupChatOutInfoArr) {
        f.a();
        f.b().a(i, notifyGroupChatOutInfoArr);
    }

    public static void java_notify_groupinfo_getMemList(ParticipantGCOutBase participantGCOutBase, int i, ParticipantOutInfo[] participantOutInfoArr) {
        f.a();
        f.b().a(participantGCOutBase, i, participantOutInfoArr);
    }

    public static void java_notify_modifySubject(String str, String str2) {
        f.a();
        f.b().f(str, str2);
    }

    public static void java_notify_onMeRemoved(String str) {
        f.a();
        f.b().a(str);
    }

    public static void java_notify_onParticipantJoined(ParticipantInfo participantInfo) {
        f.a();
        f.b().a(participantInfo);
    }

    public static void java_notify_quitConversation(String str, String str2) {
        f.a();
        f.b().c(str, str2);
    }

    public static void java_onGroupChatNewFileBase(GroupChatFileBase groupChatFileBase) {
        f.a();
        f.b().a(groupChatFileBase);
    }

    public static void java_onGroupChatNewMsg(GroupChatMsgInfo groupChatMsgInfo) {
        f.a();
        f.b().a(groupChatMsgInfo);
    }

    public static void java_onGroupChatNewMultMsg(GroupChatRecvMultInfo groupChatRecvMultInfo) {
        f.a();
        f.b().a(groupChatRecvMultInfo);
    }

    public static void java_onNewGroupChat(NewGroupChatOutInfo newGroupChatOutInfo) {
        f.a();
        f.b().a(newGroupChatOutInfo);
    }

    public static void java_onNewGroupChatLoc(GroupChatRecvLocInfo groupChatRecvLocInfo) {
        f.a();
        f.b().a(groupChatRecvLocInfo);
    }

    public static void java_onNewSingleLocation(SingleRecvLocationInfo singleRecvLocationInfo) {
        f.a();
        f.d().a(singleRecvLocationInfo);
    }

    public static void java_onSingleNewFileBase(SingleFileBase singleFileBase) {
        f.a();
        f.d().a(singleFileBase);
    }

    public static void java_onSingleNewMsg(SingleMsgInfo singleMsgInfo) {
        f.a();
        f.d().a(singleMsgInfo);
    }

    public static void java_onSingleNewMultMsg(SingleMultMsgInfo singleMultMsgInfo) {
        f.a();
        f.d().a(singleMultMsgInfo);
    }

    public static void java_onSingleRecvReport(SingleRecvReportInfo singleRecvReportInfo) {
        f.a();
        f.d().a(singleRecvReportInfo);
    }

    public static void java_onSingleRecvTyping(SingleRecvTypingInfo singleRecvTypingInfo) {
        f.a();
        f.d().a(singleRecvTypingInfo);
    }

    public static void java_queryContactAddress(String str, int i, ContactAddressInfo contactAddressInfo) {
        f.a();
        f.h().a(str, i, contactAddressInfo);
    }

    public static void java_queryOfflineContactAddress(String str, int i, OfflineContactInfo offlineContactInfo) {
        f.a();
        f.i().a(str, i, offlineContactInfo);
    }

    public static void java_queryProfile(String str, int i, ProfileInfo profileInfo) {
        f.a();
        f.h().b(str, i, profileInfo);
    }

    public static void java_quitConversation(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().d(str, resultInfo, str2);
    }

    @Deprecated
    public static void java_rejoinGroupChat(String str, int i, String str2) {
        f.a();
        f.b().b(str, i, str2);
    }

    public static void java_removeParticipants(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().g(str, resultInfo, str2);
    }

    public static void java_searchContactAddress(String str, int i, ContactAddressInfo contactAddressInfo) {
        f.a();
        f.h().c(str, i, contactAddressInfo);
    }

    public static void java_searchProfile(int i, String str, int i2, ProfileInfo profileInfo, String str2) {
        f.a();
        f.h().a(i, str, i2, profileInfo, str2);
    }

    public static void java_setChairman(String str, ResultInfo resultInfo, String str2) {
        f.a();
        f.b().e(str, resultInfo, str2);
    }

    public static void java_singleGetFileRate(String str, SingleGetFileRate singleGetFileRate) {
        f.a();
        f.d().a(str, singleGetFileRate);
    }

    public static void java_singleGetLargerFile(String str, ResultInfo resultInfo, SingleGetFileResp singleGetFileResp) {
        f.a();
        f.d().a(str, resultInfo, singleGetFileResp);
    }

    public static void java_singleSendFileRate(String str, SingleSendFileRate singleSendFileRate) {
        f.a();
        f.d().a(str, singleSendFileRate);
    }

    public static void java_singleSendMsg(String str, ResultInfo resultInfo, SingleSendMsgResp singleSendMsgResp) {
        f.a();
        f.d().a(str, resultInfo, singleSendMsgResp);
    }

    public static void java_singleSendMultMsg(String str, ResultInfo resultInfo, SingleSendMultMsgResp singleSendMultMsgResp) {
        f.a();
        f.d().a(str, resultInfo, singleSendMultMsgResp);
    }

    public static void java_singleSendReport(String str, ResultInfo resultInfo, SingleSendReportResp singleSendReportResp) {
        f.a();
        f.d().a(str, resultInfo, singleSendReportResp);
    }

    public static void java_updateProfile(String str, int i, ProfileInfo profileInfo) {
        f.a();
        f.h().d(str, i, profileInfo);
    }

    public static void loadocxLibrary() {
        System.loadLibrary("rcscontroller");
        OCXNative.setRcsOCXEnv(1);
    }
}
