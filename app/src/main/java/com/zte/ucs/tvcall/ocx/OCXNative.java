package com.zte.ucs.tvcall.ocx;

import com.zte.ucs.tvcall.ocx.card.CardMsgInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatAddMembReq;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatGetFileInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatMsgInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatMultMsgInfo;
import com.zte.ucs.tvcall.ocx.groupchat.GroupChatSendLocInfo;
import com.zte.ucs.tvcall.ocx.groupchat.InitiateGroupChatInInfo;
import com.zte.ucs.tvcall.ocx.groupchat.NewGroupChatOutInfo;
import com.zte.ucs.tvcall.ocx.groupchat.ParticipantInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCAccpetInviteInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCActiveChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCAddMberInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCCreateChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCDismissChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCGetLargerMultInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCGetMberListInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCModifyNickNameInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCModifySubjectInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCQuitChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRejoinChatInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCRemoveMberInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendLocInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendMultMsgInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSendTxtMsgInfo;
import com.zte.ucs.tvcall.ocx.groupsm.SessGCSetChairInfo;
import com.zte.ucs.tvcall.ocx.message.GrpSendMsgLocationInfo;
import com.zte.ucs.tvcall.ocx.message.GrpSendMsgMultInfo;
import com.zte.ucs.tvcall.ocx.message.GrpSendMsgTxtInfo;
import com.zte.ucs.tvcall.ocx.message.SingleGetFileInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendLocationInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendMsgInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendMultMsgInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendReportInfo;
import com.zte.ucs.tvcall.ocx.message.SingleSendTypingInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactAddressInfo;
import com.zte.ucs.tvcall.ocx.nab.ContactBaseInfo;
import com.zte.ucs.tvcall.ocx.nab.OfflineCheckNab;
import com.zte.ucs.tvcall.ocx.nab.OfflineContactInfo;
import com.zte.ucs.tvcall.ocx.nab.ProfileInfo;
import com.zte.ucs.tvcall.ocx.nab.UserPrefsInfo;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddContactReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstAddUserPrefReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstCompareDirectoryReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteContactReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstDeleteUserPrefReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstGetDirectoryReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstGroupMsgDndListOperationReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadContactReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstLoadUserPrefReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstSingMsgDndListOperationReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactAddressReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactBirthdayReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactCommAddrReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactGroupInfoReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNameReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactNoteReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactOrgNameReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadContactReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserCallingSettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserContactsSettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserExtendSettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgDndSettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgNotifySettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgPlayModSettingReq;
import com.zte.ucs.tvcall.ocx.nabst.NabstUpLoadUserMsgReminSettingReq;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendLocInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendMultMsgInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendReportInfo;
import com.zte.ucs.tvcall.ocx.presence.PresCfgPara;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalReq;
import com.zte.ucs.tvcall.ocx.presence.PresUploadFreeTextReq;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaMsgSendInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaMultMsgSendInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PASendMsgRptInfo;
import com.zte.ucs.tvcall.ocx.telephone.CallThrowScreenReqInfo;
import com.zte.ucs.tvcall.ocx.telephone.CallTransferReqInfo;
import com.zte.ucs.tvcall.ocx.videoconf.CallVideoConfSoundControlReq;
import com.zte.ucs.tvcall.ocx.videoconf.ConferenceinviteuserInfo;
import com.zte.ucs.tvcall.ocx.videoconf.SwitchtofrontInfo;
import com.zte.ucs.tvcall.ocx.videoconf.VideoConferenceInfo;
import com.zte.ucs.tvcall.ocx.wb.WhiteBoardShareType;
import com.zte.ucs.tvcall.ocx.xcap.XCAPInterfaceReq;
import d.e.b.a.c.k;
import d.e.b.a.c.m;
import d.e.b.c.c.a;
import d.e.b.c.c.c;
import d.e.b.c.c.e;
import d.e.b.c.c.g;
import d.e.b.c.c.i;

/* loaded from: classes2.dex */
public class OCXNative {
    public static native boolean jni_AddSubscribePA(String str, String str2, String str3, String str4, String str5, String str6);

    public static native boolean jni_BroadBandGetDmCfgInfo(String str, a aVar);

    public static native boolean jni_BroadBandGetDmCookie(String str, c cVar);

    public static native boolean jni_BroadBandQueryAccount(String str, e eVar);

    public static native boolean jni_BroadBandSetHttpPort(long j);

    public static native boolean jni_BroadBandSetHttpsPort(long j);

    public static native boolean jni_BroadBandSetServerIp(String str);

    public static native boolean jni_BroadBandSmsCodeReturn(String str, g gVar);

    public static native boolean jni_BroadBandVerifyECOPAccount(String str, i iVar);

    public static native boolean jni_CallThrowScreen(String str, CallThrowScreenReqInfo callThrowScreenReqInfo);

    public static native boolean jni_CallTranfer(String str, CallTransferReqInfo callTransferReqInfo);

    public static native boolean jni_CallVideoConfSoundControl(String str, CallVideoConfSoundControlReq callVideoConfSoundControlReq);

    public static native boolean jni_CancelSubscribePA(String str, String str2, String str3);

    public static native boolean jni_CardMsgSend(String str, CardMsgInfo cardMsgInfo);

    public static native String jni_CliDbGetSDKversion();

    public static native String jni_CliDbGetSdkLicenseStr();

    public static native int jni_CliDbGetVideoPXPara();

    public static native String jni_CliDbGetZIMEversion();

    public static native boolean jni_CliDbSetAttachFilePath(String str);

    public static native boolean jni_CliDbSetAudioCodecPriority(int i);

    public static native boolean jni_CliDbSetCallSessionServerAddr(String str);

    public static native boolean jni_CliDbSetCallSessionServerPort(long j);

    public static native boolean jni_CliDbSetCapablityList(String str);

    public static native boolean jni_CliDbSetGroupChatMode(int i);

    public static native boolean jni_CliDbSetGroupChatSrvAddr(String str);

    public static native boolean jni_CliDbSetGrpSendMsgUri(String str);

    public static native boolean jni_CliDbSetHasUserPhone(long j);

    public static native boolean jni_CliDbSetIconPath(String str);

    public static native boolean jni_CliDbSetIsNeedP2P(long j);

    public static native boolean jni_CliDbSetMsrpTransType(int i);

    public static native boolean jni_CliDbSetNabServAddr(String str);

    public static native boolean jni_CliDbSetNabServPort(long j);

    public static native boolean jni_CliDbSetPAServerAddr(String str);

    public static native boolean jni_CliDbSetPAServerPort(long j);

    public static native boolean jni_CliDbSetSdkLicenseFilePath(String str);

    public static native boolean jni_CliDbSetSipConnType(long j);

    public static native boolean jni_CliDbSetTerminalType(String str);

    public static native boolean jni_CliDbSetVideoConfAsUri(String str);

    public static native boolean jni_CliDbSetVideoConfDomainName(String str);

    public static native boolean jni_CliDbSetVideoConfMode(int i);

    public static native boolean jni_CliDbSetVideoConfQoeFlag(int i);

    public static native boolean jni_CliDbSetVideoPXPara(String str);

    public static native boolean jni_ConferenceAccept(String str);

    public static native boolean jni_Conferenceinviteuser(String str, ConferenceinviteuserInfo conferenceinviteuserInfo);

    public static native boolean jni_Create3PartyCall(String str, String str2, String str3, int i);

    public static native boolean jni_CreateCallSession(d.e.b.d.c.a aVar);

    public static native boolean jni_CreateVideoConference(String str, VideoConferenceInfo videoConferenceInfo);

    public static native boolean jni_GetVoiceConfParticipants(String str, String str2);

    public static native boolean jni_GroupChatGetLargerFile(String str, GroupChatGetFileInfo groupChatGetFileInfo);

    public static native boolean jni_GroupChatSendLocation(String str, GroupChatSendLocInfo groupChatSendLocInfo);

    public static native boolean jni_GrpSendMsgLocation(String str, GrpSendMsgLocationInfo grpSendMsgLocationInfo);

    public static native boolean jni_GrpSendMsgMult(String str, GrpSendMsgMultInfo grpSendMsgMultInfo);

    public static native boolean jni_GrpSendMsgTxt(String str, GrpSendMsgTxtInfo grpSendMsgTxtInfo);

    public static native boolean jni_Inviteto3PartyCall(String str, String str2);

    public static native boolean jni_MergeCreatVoiceConf(String str, String str2);

    public static native boolean jni_NabstAddContact(NabstAddContactReq nabstAddContactReq);

    public static native boolean jni_NabstAddUserPref(NabstAddUserPrefReq nabstAddUserPrefReq);

    public static native boolean jni_NabstCompareDirectory(NabstCompareDirectoryReq nabstCompareDirectoryReq);

    public static native boolean jni_NabstDeleteContact(NabstDeleteContactReq nabstDeleteContactReq);

    public static native boolean jni_NabstDeleteUserPref(NabstDeleteUserPrefReq nabstDeleteUserPrefReq);

    public static native boolean jni_NabstGetDirectory(NabstGetDirectoryReq nabstGetDirectoryReq);

    public static native boolean jni_NabstGroupMsgDndListOperation(NabstGroupMsgDndListOperationReq nabstGroupMsgDndListOperationReq);

    public static native boolean jni_NabstLoadContact(NabstLoadContactReq nabstLoadContactReq);

    public static native boolean jni_NabstLoadUserPref(NabstLoadUserPrefReq nabstLoadUserPrefReq);

    public static native boolean jni_NabstSetAuthToken(String str);

    public static native boolean jni_NabstSetLocalEtag(long j);

    public static native boolean jni_NabstSetSSLFlag(int i);

    public static native boolean jni_NabstSetServAddr(String str);

    public static native boolean jni_NabstSetServPort(long j);

    public static native boolean jni_NabstSingMsgDndListOperation(NabstSingMsgDndListOperationReq nabstSingMsgDndListOperationReq);

    public static native boolean jni_NabstUpLoadContact(NabstUpLoadContactReq nabstUpLoadContactReq);

    public static native boolean jni_NabstUpLoadContactAddress(NabstUpLoadContactAddressReq nabstUpLoadContactAddressReq);

    public static native boolean jni_NabstUpLoadContactBirthday(NabstUpLoadContactBirthdayReq nabstUpLoadContactBirthdayReq);

    public static native boolean jni_NabstUpLoadContactCommAddr(NabstUpLoadContactCommAddrReq nabstUpLoadContactCommAddrReq);

    public static native boolean jni_NabstUpLoadContactGroupInfo(NabstUpLoadContactGroupInfoReq nabstUpLoadContactGroupInfoReq);

    public static native boolean jni_NabstUpLoadContactName(NabstUpLoadContactNameReq nabstUpLoadContactNameReq);

    public static native boolean jni_NabstUpLoadContactNote(NabstUpLoadContactNoteReq nabstUpLoadContactNoteReq);

    public static native boolean jni_NabstUpLoadContactOrgName(NabstUpLoadContactOrgNameReq nabstUpLoadContactOrgNameReq);

    public static native boolean jni_NabstUpLoadUserCallingSetting(NabstUpLoadUserCallingSettingReq nabstUpLoadUserCallingSettingReq);

    public static native boolean jni_NabstUpLoadUserContactsSetting(NabstUpLoadUserContactsSettingReq nabstUpLoadUserContactsSettingReq);

    public static native boolean jni_NabstUpLoadUserExtendSetting(NabstUpLoadUserExtendSettingReq nabstUpLoadUserExtendSettingReq);

    public static native boolean jni_NabstUpLoadUserMsgDndSetting(NabstUpLoadUserMsgDndSettingReq nabstUpLoadUserMsgDndSettingReq);

    public static native boolean jni_NabstUpLoadUserMsgNotifySetting(NabstUpLoadUserMsgNotifySettingReq nabstUpLoadUserMsgNotifySettingReq);

    public static native boolean jni_NabstUpLoadUserMsgPlayModSetting(NabstUpLoadUserMsgPlayModSettingReq nabstUpLoadUserMsgPlayModSettingReq);

    public static native boolean jni_NabstUpLoadUserMsgReminSetting(NabstUpLoadUserMsgReminSettingReq nabstUpLoadUserMsgReminSettingReq);

    public static native boolean jni_PASendReport(String str, PASendMsgRptInfo pASendMsgRptInfo);

    public static native boolean jni_PASetSSLFlag(long j);

    public static native boolean jni_PASetServerSSLPort(long j);

    public static native boolean jni_PaSendMsg(String str, FirePaMsgSendInfo firePaMsgSendInfo);

    public static native boolean jni_PaSendMultMsg(String str, FirePaMultMsgSendInfo firePaMultMsgSendInfo);

    public static native boolean jni_PrecallSendLoc(String str, PrecallSendLocInfo precallSendLocInfo);

    public static native boolean jni_PrecallSendMultMsg(String str, PrecallSendMultMsgInfo precallSendMultMsgInfo);

    public static native boolean jni_PrecallSendReport(String str, PrecallSendReportInfo precallSendReportInfo);

    public static native boolean jni_PresAddUserIntoBlockList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresAddUserIntoRCSList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresAddUserIntoRevokeList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresCheckDocuments(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresDeleteUserFromBlockList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresDeleteUserFromRCSList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresDeleteUserFromRevokeList(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresLoadContactIcon(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresLoadCurrentDocument(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresSubscribeAllInfo(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresSubscribeRLSInfo(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresSubscribeWatcherInfo(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresUploadDefaultDocument(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresUploadFreeText(PresUploadFreeTextReq presUploadFreeTextReq);

    public static native boolean jni_PresUploadPersonalIcon(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_PresUploadPresenceXDMS(String str, PresUniversalReq presUniversalReq);

    public static native boolean jni_QueryUserPAList(String str, String str2, int i, int i2, int i3);

    public static native boolean jni_SearchPA(String str, String str2, String str3, int i, int i2, int i3);

    public static native boolean jni_SessGCAcceptInvite(String str, SessGCAccpetInviteInfo sessGCAccpetInviteInfo);

    public static native boolean jni_SessGCActive(String str, SessGCActiveChatInfo sessGCActiveChatInfo);

    public static native boolean jni_SessGCAddMber(String str, SessGCAddMberInfo sessGCAddMberInfo);

    public static native boolean jni_SessGCCreateChat(String str, SessGCCreateChatInfo sessGCCreateChatInfo);

    public static native boolean jni_SessGCDismissChat(String str, SessGCDismissChatInfo sessGCDismissChatInfo);

    public static native boolean jni_SessGCGetGroupList(String str);

    public static native boolean jni_SessGCGetLargerMultMsg(String str, SessGCGetLargerMultInfo sessGCGetLargerMultInfo);

    public static native boolean jni_SessGCGetMberList(String str, SessGCGetMberListInfo sessGCGetMberListInfo);

    public static native boolean jni_SessGCModifyNickName(String str, SessGCModifyNickNameInfo sessGCModifyNickNameInfo);

    public static native boolean jni_SessGCModifySubject(String str, SessGCModifySubjectInfo sessGCModifySubjectInfo);

    public static native boolean jni_SessGCQuitChat(String str, SessGCQuitChatInfo sessGCQuitChatInfo);

    public static native boolean jni_SessGCRejoinChat(String str, SessGCRejoinChatInfo sessGCRejoinChatInfo);

    public static native boolean jni_SessGCRemoveMber(String str, SessGCRemoveMberInfo sessGCRemoveMberInfo);

    public static native boolean jni_SessGCSendLoc(String str, SessGCSendLocInfo sessGCSendLocInfo);

    public static native boolean jni_SessGCSendMultMsg(String str, SessGCSendMultMsgInfo sessGCSendMultMsgInfo);

    public static native boolean jni_SessGCSendTxtMsg(String str, SessGCSendTxtMsgInfo sessGCSendTxtMsgInfo);

    public static native boolean jni_SessGCSetChair(String str, SessGCSetChairInfo sessGCSetChairInfo);

    public static native boolean jni_SetCBUriFormat(int i);

    public static native boolean jni_SetDestUriFormat(int i);

    public static native boolean jni_SetPresenceConfig(PresCfgPara presCfgPara);

    public static native boolean jni_SingleSendLocation(String str, SingleSendLocationInfo singleSendLocationInfo);

    public static native boolean jni_SingleSendTyping(String str, SingleSendTypingInfo singleSendTypingInfo);

    public static native boolean jni_Switchtofront(String str, SwitchtofrontInfo switchtofrontInfo);

    public static native boolean jni_TerminateCallSession(d.e.b.d.c.c cVar);

    public static native boolean jni_UnifiedAuthApplyToken(String str, d.e.b.a.c.a aVar);

    public static native boolean jni_UnifiedAuthModifyPassword(String str, d.e.b.a.c.c cVar);

    public static native boolean jni_UnifiedAuthRefreshToken(String str, d.e.b.a.c.e eVar);

    public static native boolean jni_UnifiedAuthResult(String str, d.e.b.a.c.g gVar);

    public static native boolean jni_UnifiedAuthSetHttpType(long j);

    public static native boolean jni_UnifiedAuthSetServerIp(String str);

    public static native boolean jni_UnifiedAuthSetServerPort(long j);

    public static native boolean jni_UnifiedAuthSmsVerification(String str, d.e.b.a.c.i iVar);

    public static native boolean jni_UnifiedAuthSmscodeReturn(String str, k kVar);

    public static native boolean jni_UnifiedAuthStart(String str, m mVar);

    public static native boolean jni_WBShareSend(String str, WhiteBoardShareType whiteBoardShareType);

    public static native boolean jni_XCAPInterface(XCAPInterfaceReq xCAPInterfaceReq);

    public static native boolean jni_abortConversation(String str, String str2);

    public static native boolean jni_acceptInvitation(String str, NewGroupChatOutInfo newGroupChatOutInfo);

    public static native boolean jni_addContactAddress(String str, ContactAddressInfo contactAddressInfo);

    public static native boolean jni_addContactBase(int i, String str, String str2, String str3, ContactBaseInfo[] contactBaseInfoArr);

    public static native boolean jni_addOfflineContactAddress(String str, OfflineContactInfo offlineContactInfo);

    public static native boolean jni_addParticipants(String str, GroupChatAddMembReq groupChatAddMembReq);

    public static native boolean jni_addProfile(String str, ProfileInfo profileInfo);

    public static native boolean jni_addUserPrefs(String str, UserPrefsInfo userPrefsInfo);

    public static native boolean jni_bAcceptCall(String str);

    public static native boolean jni_bCallHold(String str, long j);

    public static native boolean jni_bCreateMultiCall(String str, long j);

    public static native boolean jni_bCreateThirdCall(String str, long j);

    public static native boolean jni_bDoNewCallWhenBusy2(long j, long j2, String str);

    public static native boolean jni_bForceLogonServer(RCSLogonPara rCSLogonPara);

    public static native boolean jni_bIMSCallMethod(long j, RCSNormalCallMethodPara rCSNormalCallMethodPara);

    public static native boolean jni_bLeaveCall();

    public static native boolean jni_bLogon(int i, RCSLogonPara rCSLogonPara);

    public static native boolean jni_bLogoutServer();

    public static native boolean jni_bRCSQueryShareAbility(String str);

    public static native boolean jni_bRejectCall(String str);

    public static native boolean jni_bReleaseTalker(String str);

    public static native boolean jni_checkNAB(String str, ProfileInfo profileInfo);

    public static native boolean jni_checkNABOffline(String str, OfflineCheckNab offlineCheckNab);

    public static native boolean jni_complainPA(String str, String str2, String str3, int i, String str4, String str5, String str6);

    public static native boolean jni_deleteContactAddress(String str, ContactAddressInfo contactAddressInfo);

    public static native boolean jni_deleteContactBase(String str, String str2, String str3);

    public static native boolean jni_deleteOfflineContactAddress(String str, OfflineContactInfo offlineContactInfo);

    public static native boolean jni_deleteProfile(String str, ProfileInfo profileInfo);

    public static native boolean jni_getMyGroupChat(String str);

    public static native boolean jni_getPADetail(String str, String str2, String str3, String str4);

    public static native boolean jni_getPAMenu(String str, String str2, String str3, String str4);

    public static native boolean jni_getPAPreMsg(String str, String str2, String str3, String str4, int i, int i2, int i3);

    public static native boolean jni_getParticipantList(String str, String str2);

    public static native boolean jni_getRecommendPA(String str, String str2, int i, int i2, int i3);

    public static native boolean jni_initiateGroupChat(String str, InitiateGroupChatInInfo initiateGroupChatInInfo);

    public static native boolean jni_launcherThreads();

    public static native boolean jni_modifyNickName(String str, ParticipantInfo participantInfo);

    public static native boolean jni_modifySubject(String str, String str2, String str3);

    public static native boolean jni_notifyMenuEvent(String str, String str2, String str3, String str4, String str5, int i);

    public static native boolean jni_queryContactAddress(String str, ContactAddressInfo contactAddressInfo);

    public static native boolean jni_queryContactBase(String str, String str2, String str3);

    public static native boolean jni_queryOfflineContactAddress(String str, OfflineContactInfo offlineContactInfo);

    public static native boolean jni_queryProfile(String str, ProfileInfo profileInfo);

    public static native boolean jni_quitConversation(String str, String str2);

    public static native boolean jni_rejoinGroupChat(String str, String str2);

    public static native boolean jni_removeParticipants(String str, String str2, String str3);

    public static native boolean jni_searchProfile(int i, String str, ProfileInfo profileInfo, String str2);

    public static native boolean jni_sendGroupChatMsg(String str, GroupChatMsgInfo groupChatMsgInfo);

    public static native boolean jni_sendGroupChatMultMsg(String str, GroupChatMultMsgInfo groupChatMultMsgInfo);

    public static native boolean jni_sendSingleMultMsg(String str, SingleSendMultMsgInfo singleSendMultMsgInfo);

    public static native boolean jni_setChairman(String str, String str2, String str3);

    public static native boolean jni_setGCIsURLEncode(int i);

    public static native boolean jni_setPAAcceptStatus(String str, String str2, String str3, int i);

    public static native boolean jni_singleGetLargerFile(String str, SingleGetFileInfo singleGetFileInfo);

    public static native boolean jni_singleSendMsg(String str, SingleSendMsgInfo singleSendMsgInfo);

    public static native boolean jni_singleSendReport(String str, SingleSendReportInfo singleSendReportInfo);

    public static native int setRcsOCXEnv(int i);
}
