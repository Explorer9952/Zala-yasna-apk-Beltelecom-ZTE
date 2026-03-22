package d.e.b.k;

import android.os.Bundle;
import android.os.Message;
import com.google.gson.Gson;
import com.zte.sdk.enumclass.CardSendTypeEnum;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.card.CardMsgInfo;
import com.zte.ucs.tvcall.ocx.card.CardSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaMsgContentRecvInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessAddSubsResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessCancelSubsResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessGetPubDetailResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessGetPubLstRecmdInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessGetPubLstResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessGetPubMenuResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessGetPubPreMsgResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessNotifyMenuEventResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessQryUsrSubsResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaSessSetAcptStatResultInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaComplainInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaDetailInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMainMenuInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMsgContent;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendFileRate;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendRptResp;
import d.e.b.b.f;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8065d = b.class.getName();

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

    @Override // d.e.b.k.a
    public void a(int i, String str) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-更新公众账号详细信息回调】 java_FirePaSessUpdatePubDetail_Result type[%d], pauuid[%s]", Integer.valueOf(i), str));
        Message obtain = Message.obtain();
        obtain.what = 5122;
        obtain.obj = str;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void a(CardMsgInfo cardMsgInfo) {
        if (cardMsgInfo == null) {
            d.d(this.f8065d, "java_CardmsgRcv CardMsgInfo is null!");
            return;
        }
        String json = new Gson().toJson(cardMsgInfo);
        d.a(this.f8065d, String.format(Locale.getDefault(), "【卡片消息-接收消息通知】 ->" + json, new Object[0]));
        if (cardMsgInfo.getSendType() == CardSendTypeEnum.SINGLE_CHAT.getCode()) {
            Message obtain = Message.obtain();
            obtain.what = 33;
            obtain.obj = cardMsgInfo;
            f.a();
            ((d.e.b.g.b) f.d()).c().sendMessage(obtain);
            return;
        }
        if (cardMsgInfo.getSendType() != CardSendTypeEnum.GROUP_CHAT.getCode()) {
            d.a(this.f8065d, "cardMsgInfo.getSendType() error!!!");
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 34;
        obtain2.obj = cardMsgInfo;
        f.a();
        ((d.e.b.f.a) f.b()).c().sendMessage(obtain2);
    }

    @Override // d.e.b.k.a
    public void a(FirePaMsgContentRecvInfo firePaMsgContentRecvInfo) {
        if (firePaMsgContentRecvInfo == null) {
            d.d(this.f8065d, "java_FirePaMsgRecv get FirePaMsgContentRecvInfo is null");
            return;
        }
        String userId = firePaMsgContentRecvInfo.getUserId();
        String paUuid = firePaMsgContentRecvInfo.getPaUuid();
        int mediaType = firePaMsgContentRecvInfo.getMediaType();
        String createTime = firePaMsgContentRecvInfo.getCreateTime();
        int activeStatus = firePaMsgContentRecvInfo.getActiveStatus();
        int forwardable = firePaMsgContentRecvInfo.getForwardable();
        String msgUuid = firePaMsgContentRecvInfo.getMsgUuid();
        String smsDigest = firePaMsgContentRecvInfo.getSmsDigest();
        String text = firePaMsgContentRecvInfo.getText();
        int articanum = firePaMsgContentRecvInfo.getArticanum();
        int rptType = firePaMsgContentRecvInfo.getRptType();
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-收到图文消息通知】 java_FirePaMsgRecv userId[%s],paUuid[%s],msgid[%s],rptType[%d],mediaType[%d] createTime[%s] activeStatus[%d] forwardable[%d] msgUuid[%s] smsDigest[%s] text[%s] articanum[%d] ", userId, paUuid, firePaMsgContentRecvInfo.getMsgid(), Integer.valueOf(rptType), Integer.valueOf(mediaType), createTime, Integer.valueOf(activeStatus), Integer.valueOf(forwardable), msgUuid, smsDigest, text, Integer.valueOf(articanum)));
        FirePaMsgContentRecvInfo firePaMsgContentRecvInfo2 = new FirePaMsgContentRecvInfo();
        firePaMsgContentRecvInfo2.setActiveStatus(firePaMsgContentRecvInfo.getActiveStatus());
        firePaMsgContentRecvInfo2.setArticalMult(firePaMsgContentRecvInfo.getArticalMult());
        firePaMsgContentRecvInfo2.setArticalSingle(firePaMsgContentRecvInfo.getArticalSingle());
        firePaMsgContentRecvInfo2.setArticanum(firePaMsgContentRecvInfo.getArticanum());
        firePaMsgContentRecvInfo2.setAudio(firePaMsgContentRecvInfo.getAudio());
        firePaMsgContentRecvInfo2.setCreateTime(firePaMsgContentRecvInfo.getCreateTime());
        firePaMsgContentRecvInfo2.setForwardable(firePaMsgContentRecvInfo.getForwardable());
        firePaMsgContentRecvInfo2.setMediaType(firePaMsgContentRecvInfo.getMediaType());
        firePaMsgContentRecvInfo2.setMsgUuid(firePaMsgContentRecvInfo.getMsgUuid());
        firePaMsgContentRecvInfo2.setPaUuid(firePaMsgContentRecvInfo.getPaUuid());
        firePaMsgContentRecvInfo2.setPic(firePaMsgContentRecvInfo.getPic());
        firePaMsgContentRecvInfo2.setSmsDigest(firePaMsgContentRecvInfo.getSmsDigest());
        firePaMsgContentRecvInfo2.setText(firePaMsgContentRecvInfo.getText());
        firePaMsgContentRecvInfo2.setUserId(firePaMsgContentRecvInfo.getUserId());
        firePaMsgContentRecvInfo2.setVideo(firePaMsgContentRecvInfo.getVideo());
        firePaMsgContentRecvInfo2.setRptType(rptType);
        firePaMsgContentRecvInfo2.setMsgid(firePaMsgContentRecvInfo.getMsgid());
        Message obtain = Message.obtain();
        obtain.what = 4609;
        obtain.obj = firePaMsgContentRecvInfo2;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void a(String str, ResultInfo resultInfo, CardSendMsgRespInfo cardSendMsgRespInfo) {
        if (cardSendMsgRespInfo == null) {
            d.d(this.f8065d, "java_CardmsgSendResp CardSendMsgRespInfo is null!");
            return;
        }
        String json = new Gson().toJson(cardSendMsgRespInfo);
        d.a(this.f8065d, String.format(Locale.getDefault(), "【卡片消息-发送消息结果回调】 java_CardmsgSendResp sessionId[%s], result[%d], errorReason[%s], errorCode[%d]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode())));
        d.a(this.f8065d, json);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, resultInfo.getResult());
        bundle.putInt(ResultInfo.KEY_errorCode, resultInfo.getErrorCode());
        bundle.putString(ResultInfo.KEY_errorReason, resultInfo.getErrorReason());
        bundle.putString("SessionID", str);
        obtain.setData(bundle);
        obtain.what = 5633;
        obtain.obj = cardSendMsgRespInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void a(String str, ResultInfo resultInfo, PaSendMsgResp paSendMsgResp) {
        if (paSendMsgResp == null) {
            d.d(this.f8065d, "java_PaSendMsg PaSendMsgResp is null!");
        } else {
            d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-发送文本消息执行通知】 java_PaSendMsg sessionId[%s], result[%d],errorCode[%d], errorReason[%s], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), paSendMsgResp.getMessageId()));
            c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 4610, paSendMsgResp));
        }
    }

    @Override // d.e.b.k.a
    public void a(String str, ResultInfo resultInfo, PaSendMultMsgResp paSendMultMsgResp) {
        if (paSendMultMsgResp == null) {
            d.d(this.f8065d, "java_PaSendMultMsg PaSendMultMsgResp is null!");
            return;
        }
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-发送多媒体消息执行通知】 java_PaSendMultMsg sessionId[%s], result[%d],errorReason[%s], errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), paSendMultMsgResp.getMessageId()));
        paSendMultMsgResp.setSessionId(str);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 4611, paSendMultMsgResp));
    }

    @Override // d.e.b.k.a
    public void a(String str, ResultInfo resultInfo, PaSendRptResp paSendRptResp) {
        if (paSendRptResp == null) {
            d.d(this.f8065d, "java_PASendReport PaSendRptResp is null!");
        } else {
            d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-发送回执结果通知】 java_PASendReport sessionId[%s], result[%d],errorReason[%s], errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), paSendRptResp.getMessageId()));
            c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 4613, paSendRptResp));
        }
    }

    @Override // d.e.b.k.a
    public void a(String str, PaSendFileRate paSendFileRate) {
        if (paSendFileRate == null) {
            d.d(this.f8065d, "java_PaSendFileRate get null PaSendFileRate object !");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(paSendFileRate.getTranRate());
        d.a(this.f8065d, String.format("【公众账号-发送多媒体消息进度通知】 java_PaSendFileRate sessionId[%s],messageId[%s],TranRate[%s]", str, paSendFileRate.getMessageId(), sb.toString()));
        Message obtain = Message.obtain();
        obtain.what = 4612;
        obtain.obj = paSendFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void a(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户搜索列表结果通知】 java_FirePaSessSearchPA_Result dwSessId[%s],userId[%s],result[%d],reason[%d]，,panum[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        FirePaSessGetPubLstResultInfo firePaSessGetPubLstResultInfo = new FirePaSessGetPubLstResultInfo();
        firePaSessGetPubLstResultInfo.setDwSessId(str);
        firePaSessGetPubLstResultInfo.setUserId(str2);
        firePaSessGetPubLstResultInfo.setPanum(i3);
        firePaSessGetPubLstResultInfo.setPaInfosArry(paInfoArr);
        c().sendMessage(a(i, i2, "", 769, firePaSessGetPubLstResultInfo));
    }

    @Override // d.e.b.k.a
    public void a(String str, String str2, int i, int i2, PaDetailInfo paDetailInfo) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户查询详细结果通知】 java_FirePaSessGetPubDetail_Result dwSessId[%s],userId[%s],result[%d],reason[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2)));
        FirePaSessGetPubDetailResultInfo firePaSessGetPubDetailResultInfo = new FirePaSessGetPubDetailResultInfo();
        firePaSessGetPubDetailResultInfo.setDwSessId(str);
        firePaSessGetPubDetailResultInfo.setUserId(str2);
        firePaSessGetPubDetailResultInfo.setPaDetailInfo(paDetailInfo);
        c().sendMessage(a(i, i2, "", 1025, firePaSessGetPubDetailResultInfo));
    }

    @Override // d.e.b.k.a
    public void a(String str, String str2, int i, int i2, String str3) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户设置接收结果通知】 java_FirePaSessSetAcptStat_Result dwSessId[%s],userId[%s],result[%d],reason[%d],pa_uuid[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
        FirePaSessSetAcptStatResultInfo firePaSessSetAcptStatResultInfo = new FirePaSessSetAcptStatResultInfo();
        firePaSessSetAcptStatResultInfo.setDwSessId(str);
        firePaSessSetAcptStatResultInfo.setPaUuid(str3);
        firePaSessSetAcptStatResultInfo.setUserId(str2);
        c().sendMessage(a(i, i2, "", 4097, firePaSessSetAcptStatResultInfo));
    }

    @Override // d.e.b.k.a
    public void a(String str, String str2, int i, int i2, String str3, int i3, PaMainMenuInfo[] paMainMenuInfoArr) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户查询菜单结果通知】 java_FirePaSessGetPubMenu_Result dwSessId[%s],userId[%s],result[%d],reason[%d],pa_uuid[%s],menunum[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, Integer.valueOf(i3)));
        FirePaSessGetPubMenuResultInfo firePaSessGetPubMenuResultInfo = new FirePaSessGetPubMenuResultInfo();
        firePaSessGetPubMenuResultInfo.setDwSessId(str);
        firePaSessGetPubMenuResultInfo.setUserId(str2);
        firePaSessGetPubMenuResultInfo.setPaUuid(str3);
        firePaSessGetPubMenuResultInfo.setMenuNum(i3);
        firePaSessGetPubMenuResultInfo.setPaMainMenuInfoArry(paMainMenuInfoArr);
        c().sendMessage(a(i, i2, "", 1537, firePaSessGetPubMenuResultInfo));
    }

    @Override // d.e.b.k.a
    public void a(String str, String str2, int i, int i2, String str3, int i3, PaMsgContent[] paMsgContentArr) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-查询历史消息结果通知】 java_FirePaSessGetPubPreMsg_Result result[%d],reason[%d],sessionid[%s],pa_uuid[%s],msgnum[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, str3, Integer.valueOf(i3)));
        FirePaSessGetPubPreMsgResultInfo firePaSessGetPubPreMsgResultInfo = new FirePaSessGetPubPreMsgResultInfo();
        firePaSessGetPubPreMsgResultInfo.setSessionid(str);
        firePaSessGetPubPreMsgResultInfo.setPauuid(str3);
        firePaSessGetPubPreMsgResultInfo.setMsgnum(i3);
        firePaSessGetPubPreMsgResultInfo.setPaMsgContentArry(paMsgContentArr);
        c().sendMessage(a(i, i2, "", 1793, firePaSessGetPubPreMsgResultInfo));
    }

    @Override // d.e.b.k.a
    public void b(int i) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【聚吧-聚吧有新消息信息回调】 java_FirePaSessGetParty_Result type[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 5378;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void b(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-查询已关注账号列表结果通知】 java_FirePaSessQryUsrSubs_Result dwSessId[%s],userId[%s],result[%d],reason[%d]，,panum[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        FirePaSessQryUsrSubsResultInfo firePaSessQryUsrSubsResultInfo = new FirePaSessQryUsrSubsResultInfo();
        firePaSessQryUsrSubsResultInfo.setDwSessId(str);
        firePaSessQryUsrSubsResultInfo.setUserId(str2);
        firePaSessQryUsrSubsResultInfo.setPanum(i3);
        firePaSessQryUsrSubsResultInfo.setPaInfosArry(paInfoArr);
        c().sendMessage(a(i, i2, "", 1281, firePaSessQryUsrSubsResultInfo));
    }

    @Override // d.e.b.k.a
    public void b(String str, String str2, int i, int i2, String str3) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-自定义菜单结果通知】 java_FirePaSessNotifyMenuEvent_Result dwSessId[%s],userId[%s],result[%d],reason[%d],pa_uuid[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
        FirePaSessNotifyMenuEventResultInfo firePaSessNotifyMenuEventResultInfo = new FirePaSessNotifyMenuEventResultInfo();
        firePaSessNotifyMenuEventResultInfo.setDwSessId(str);
        firePaSessNotifyMenuEventResultInfo.setUserId(str2);
        firePaSessNotifyMenuEventResultInfo.setPa_uuid(str3);
        c().sendMessage(a(i, i2, "", 4353, firePaSessNotifyMenuEventResultInfo));
    }

    @Override // d.e.b.k.a
    public void c(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-查询推荐账号列表结果通知】 java_FirePaSessGetPubLstRecmd_Result dwSessId[%s],userId[%s],result[%d],reason[%d]，,panum[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        FirePaSessGetPubLstRecmdInfo firePaSessGetPubLstRecmdInfo = new FirePaSessGetPubLstRecmdInfo();
        firePaSessGetPubLstRecmdInfo.setDwSessId(str);
        firePaSessGetPubLstRecmdInfo.setUserId(str2);
        firePaSessGetPubLstRecmdInfo.setPanum(i3);
        firePaSessGetPubLstRecmdInfo.setPaInfosArry(paInfoArr);
        c().sendMessage(a(i, i2, "", 2305, firePaSessGetPubLstRecmdInfo));
    }

    @Override // d.e.b.k.a
    public void c(String str, String str2, int i, int i2, String str3) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户取消关注通知】 java_FirePaSessCancelSubs_Result dwSessId[%s],userId[%s],result[%d],reason[%d]，,pa_uuid[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
        FirePaSessCancelSubsResultInfo firePaSessCancelSubsResultInfo = new FirePaSessCancelSubsResultInfo();
        firePaSessCancelSubsResultInfo.setDwSessId(str);
        firePaSessCancelSubsResultInfo.setUserId(str2);
        firePaSessCancelSubsResultInfo.setPa_Uuid(str3);
        c().sendMessage(a(i, i2, "", 513, firePaSessCancelSubsResultInfo));
    }

    @Override // d.e.b.k.a
    public void d(String str, String str2, int i, int i2, String str3) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-投诉账号/消息内容的结果通知】 java_FirePaComplain_Result sessionId[%s],userId[%s],result[%d], reason[%d], paUuid[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
        PaComplainInfo paComplainInfo = new PaComplainInfo();
        paComplainInfo.setSessionId(str);
        paComplainInfo.setUserId(str2);
        paComplainInfo.setPaUuid(str3);
        c().sendMessage(a(i, i2, "", 4865, paComplainInfo));
    }

    @Override // d.e.b.k.a
    public void e(int i) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【圈子-圈子有新消息信息回调】 java_FirePtSessGetMoments_Result type[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 5377;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.k.a
    public void e(String str, String str2, int i, int i2, String str3) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-用户关注通知】 java_FirePaSessAddSubs_Result dwSessId[%s],userId[%s],result[%d],reason[%d]，,pa_uuid[%s]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3));
        FirePaSessAddSubsResultInfo firePaSessAddSubsResultInfo = new FirePaSessAddSubsResultInfo();
        firePaSessAddSubsResultInfo.setDwSessId(str);
        firePaSessAddSubsResultInfo.setUserId(str2);
        firePaSessAddSubsResultInfo.setPa_uuid(str3);
        c().sendMessage(a(i, i2, "", 257, firePaSessAddSubsResultInfo));
    }

    @Override // d.e.b.k.a
    public void g(int i) {
        d.a(this.f8065d, String.format(Locale.getDefault(), "【公众账号-更新公众账号关注列表信息回调】 java_FirePaSessUpdatePubList_Result type[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 5121;
        c().sendMessage(obtain);
    }
}
