package d.e.b.g;

import android.os.Bundle;
import android.os.Message;
import com.google.gson.Gson;
import com.zte.ucs.tvcall.ocx.ResultInfo;
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
import com.zte.ucs.tvcall.ocx.message.SingleSendTypingAck;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvLocInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvMultMsgInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvReportInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendLocResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendReportResp;
import com.zte.ucs.tvcall.ocx.wb.WBShareSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.wb.WhiteBoardShareType;
import d.e.b.b.f;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8061d = b.class.getSimpleName();

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

    @Override // d.e.b.g.a
    public void a(MailMsgMediaArticle mailMsgMediaArticle) {
        if (mailMsgMediaArticle == null) {
            d.d(this.f8061d, "java_CBMailRecvMsg get null mailMsgMediaArticle object !");
            return;
        }
        String from = mailMsgMediaArticle.getFrom();
        int forwardable = mailMsgMediaArticle.getForwardable();
        String msgid = mailMsgMediaArticle.getMsgid();
        String sendTime = mailMsgMediaArticle.getSendTime();
        int needRpt = mailMsgMediaArticle.getNeedRpt();
        String version = mailMsgMediaArticle.getVersion();
        int mailCount = mailMsgMediaArticle.getMailCount();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【139邮箱-邮箱信息回调通知】 java_CBMailRecvMsg From[%s],Forwardable[%d],msgid[%s],sendTime[%s],Version[%s],FromAddress[%s],FromNumber[%s],ToAddress[%s],Title[%s],Summary[%s],Mid[%s],Time[%s],MailURL[%s],needRpt[%d],MailCount[%d],AttachedCount[%d]", from, Integer.valueOf(forwardable), msgid, sendTime, version, mailMsgMediaArticle.getFromAddress(), mailMsgMediaArticle.getFromNumber(), mailMsgMediaArticle.getToAddress(), mailMsgMediaArticle.getTitle(), mailMsgMediaArticle.getSummary(), mailMsgMediaArticle.getMid(), mailMsgMediaArticle.getTime(), mailMsgMediaArticle.getMailURL(), Integer.valueOf(needRpt), Integer.valueOf(mailCount), Integer.valueOf(mailMsgMediaArticle.getAttachedCount())));
        Message obtain = Message.obtain();
        obtain.what = 32;
        obtain.obj = mailMsgMediaArticle;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(GrpSendLargeMsgRateInfo grpSendLargeMsgRateInfo) {
        String str;
        String str2;
        String str3;
        int i;
        String str4 = "";
        if (grpSendLargeMsgRateInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(grpSendLargeMsgRateInfo.getTranRate());
            String sb2 = sb.toString();
            str = grpSendLargeMsgRateInfo.getMessageId();
            String filetranId = grpSendLargeMsgRateInfo.getFiletranId();
            int finishSize = grpSendLargeMsgRateInfo.getFinishSize();
            str2 = sb2;
            str4 = grpSendLargeMsgRateInfo.getSessionId();
            i = finishSize;
            str3 = filetranId;
        } else {
            d.d(this.f8061d, "java_CBGrpSendMsgMultRate get null java_CBGrpSendMsgMultRate object !");
            str = "";
            str2 = str;
            str3 = str2;
            i = 0;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【群发-发送进度回调通知】 java_CBGrpSendMsgMultRate sessionId[%s],messageId[%s],TranRate[%s],filetranId[%s],finishSize[%d]", str4, str, str2, str3, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 31;
        obtain.obj = grpSendLargeMsgRateInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(GrpSendMsgRespInfo grpSendMsgRespInfo) {
        String str;
        int i;
        String str2 = "";
        if (grpSendMsgRespInfo != null) {
            String messageId = grpSendMsgRespInfo.getMessageId();
            int result = grpSendMsgRespInfo.getResult();
            str = messageId;
            str2 = grpSendMsgRespInfo.getSessionId();
            i = result;
        } else {
            d.d(this.f8061d, "java_CBGrpSendMsgAck GrpSendMsgResp is null!");
            str = "";
            i = 0;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【群发-发送文本/多媒体/地理消息执行通知】 java_CBGrpSendMsgAck sessionId[%s], result[%d], errorReason[%s], errorCode[%d], messageId[%s]", str2, Integer.valueOf(i), grpSendMsgRespInfo.getErrorReason(), Integer.valueOf(grpSendMsgRespInfo.getErrorCode()), str));
        c().sendMessage(a(grpSendMsgRespInfo.getResult(), grpSendMsgRespInfo.getErrorCode(), grpSendMsgRespInfo.getErrorReason(), 30, grpSendMsgRespInfo));
    }

    @Override // d.e.b.g.a
    public void a(MsgRevokeRespInfo msgRevokeRespInfo) {
        if (msgRevokeRespInfo == null) {
            d.d(this.f8061d, "java_MsgRevokeResp get null msgRevokeRespInfo object !");
            return;
        }
        String json = new Gson().toJson(msgRevokeRespInfo);
        d.a(this.f8061d, "【单聊-消息撤回通知】 java_MsgRevokeResp MsgRevokeRespInfo:" + json);
        if (msgRevokeRespInfo.getMessageType() == 1) {
            Message obtain = Message.obtain();
            obtain.what = 42;
            obtain.obj = msgRevokeRespInfo;
            c().sendMessage(obtain);
            return;
        }
        if (msgRevokeRespInfo.getMessageType() == 2) {
            Message obtain2 = Message.obtain();
            obtain2.what = 35;
            obtain2.obj = msgRevokeRespInfo;
            f.a();
            ((d.e.b.f.a) f.b()).c().sendMessage(obtain2);
            return;
        }
        if (msgRevokeRespInfo.getMessageType() != 3) {
            d.a(this.f8061d, "java_MsgRevokeResp.msgRevokeRespInfo.getSendType() error!!!");
            return;
        }
        Message obtain3 = Message.obtain();
        obtain3.what = 43;
        obtain3.obj = msgRevokeRespInfo;
        c().sendMessage(obtain3);
    }

    @Override // d.e.b.g.a
    public void a(SingleFileBase singleFileBase) {
        if (singleFileBase == null) {
            d.d(this.f8061d, "java_onSingleNewFileBase get null SingleFileBase object !");
            return;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-收到大文件通知】 java_onSingleNewFileBase messageId[%s],sendUrl[%s]filetranId[%s],receiverUri[%s],smallPic[%s],dateTime[%s],fileName[%s],fileLen[%d],timeLen[%d],messageType[%d],receipt[%d],msgFlag[%d],barcycleTime[%d],getFileFlag[%d]", singleFileBase.getMessageId(), singleFileBase.getSendUrl(), singleFileBase.getFiletranId(), singleFileBase.getReceiverUri(), singleFileBase.getSmallPic(), singleFileBase.getDateTime(), singleFileBase.getFileName(), Integer.valueOf(singleFileBase.getFileLen()), Integer.valueOf(singleFileBase.getTimeLen()), Integer.valueOf(singleFileBase.getMessageType()), Integer.valueOf(singleFileBase.getReceipt()), Integer.valueOf(singleFileBase.getMsgFlag()), Integer.valueOf(singleFileBase.getBarcycleTime()), Integer.valueOf(singleFileBase.getGetFileFlag())));
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = singleFileBase;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleMsgInfo singleMsgInfo) {
        if (singleMsgInfo == null) {
            d.d(this.f8061d, "java_onSingleNewMsg get null SingleMsgInfo object !");
            return;
        }
        String receiverUri = singleMsgInfo.getReceiverUri();
        String text = singleMsgInfo.getText();
        String dateTime = singleMsgInfo.getDateTime();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-收到文本消息结果通知】 java_onSingleNewMsg messageId[%s],sendUrl[%s],receiverUri[%s],dateTime[%s],receipt[%d],msgFlag[%d],text[%s],barcycleTime[%d]", singleMsgInfo.getMessageId(), singleMsgInfo.getSendUrl(), receiverUri, dateTime, Integer.valueOf(singleMsgInfo.getReceipt()), Integer.valueOf(singleMsgInfo.getMsgFlag()), text, Integer.valueOf(singleMsgInfo.getBarcycleTime())));
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = singleMsgInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleMsgRevokeRpt singleMsgRevokeRpt) {
        if (singleMsgRevokeRpt == null) {
            d.d(this.f8061d, "java_SingleMsgRevokeRcv get null singleMsgRevokeRpt object !");
            return;
        }
        String json = new Gson().toJson(singleMsgRevokeRpt);
        d.a(this.f8061d, "【单聊-消息撤回接收上报】 java_SingleMsgRevokeRcv SingleMsgRevokeRpt:" + json);
        Message obtain = Message.obtain();
        obtain.what = 44;
        obtain.obj = singleMsgRevokeRpt;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleMultMsgInfo singleMultMsgInfo) {
        if (singleMultMsgInfo == null) {
            d.d(this.f8061d, "java_onSingleNewMultMsg get null SingleMultMsgInfo object !");
            return;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-收到多媒体消息结果通知】 java_onSingleNewMultMsg messageId[%s],sendUrl[%s],receiverUri[%s],file[%s],dateTime[%s],timeLen[%d],receipt[%d],messageType[%d],msgFlag[%d],barcycleTime[%d]", singleMultMsgInfo.getMessageId(), singleMultMsgInfo.getSendUrl(), singleMultMsgInfo.getReceiverUri(), singleMultMsgInfo.getFile(), singleMultMsgInfo.getDateTime(), Integer.valueOf(singleMultMsgInfo.getTimeLen()), Integer.valueOf(singleMultMsgInfo.getReceipt()), Integer.valueOf(singleMultMsgInfo.getMessageType()), Integer.valueOf(singleMultMsgInfo.getMsgFlag()), Integer.valueOf(singleMultMsgInfo.getBarcycleTime())));
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = singleMultMsgInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleRecvLocationInfo singleRecvLocationInfo) {
        if (singleRecvLocationInfo == null) {
            d.d(this.f8061d, "java_onNewSingleLocation get null SingleRecvLocationInfo object !");
            return;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-收到地理位置信息通知】 java_onNewSingleLocation messageId[%s],sendUrl[%s],longitude[%s],latidute[%s],radius[%s],locationName[%s],sendTime[%s],receipt[%d],msgFlag[%d] barcycleTime[%d]", singleRecvLocationInfo.getMessageId(), singleRecvLocationInfo.getSenderUrl(), singleRecvLocationInfo.getLongitude(), singleRecvLocationInfo.getLatidute(), singleRecvLocationInfo.getRadius(), singleRecvLocationInfo.getLocationName(), singleRecvLocationInfo.getSendTime(), Integer.valueOf(singleRecvLocationInfo.getReceipt()), Integer.valueOf(singleRecvLocationInfo.getMsgFlag()), Integer.valueOf(singleRecvLocationInfo.getBarcycleTime())));
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = singleRecvLocationInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleRecvReportInfo singleRecvReportInfo) {
        if (singleRecvReportInfo == null) {
            d.d(this.f8061d, "java_singleSendReport get SingleRecvReportInfo is null!");
            return;
        }
        String oldMsgId = singleRecvReportInfo.getOldMsgId();
        String sendUrl = singleRecvReportInfo.getSendUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(singleRecvReportInfo.getReceiptType());
        d.a(this.f8061d, String.format("【单聊-收到回执通知】 java_onSingleRecvReport ordinary messageId[%s],sendUrl[%s],receipt[%s]", oldMsgId, sendUrl, sb.toString()));
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = singleRecvReportInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(SingleRecvTypingInfo singleRecvTypingInfo) {
        int refresh = singleRecvTypingInfo.getRefresh();
        String senderUri = singleRecvTypingInfo.getSenderUri();
        String sendTime = singleRecvTypingInfo.getSendTime();
        int state = singleRecvTypingInfo.getState();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-对方输入状态通知】 java_CBSingleInputNotify ordinary refresh[%s],senderUrl[%s],sendTime[%s],state[%d]", Integer.valueOf(refresh), senderUri, sendTime, Integer.valueOf(state)));
        d.e.b.g.c.a aVar = new d.e.b.g.c.a();
        aVar.a(refresh);
        aVar.b(senderUri);
        aVar.a(sendTime);
        aVar.b(state);
        Message obtain = Message.obtain();
        obtain.what = 13;
        obtain.obj = aVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(PrecallRecvLocInfo precallRecvLocInfo) {
        int receipt = precallRecvLocInfo.getReceipt();
        String messageId = precallRecvLocInfo.getMessageId();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-收到地理位置】java_PrecallRecvLoc contactId[%s],messageId[%s],receipt[%d],type[%d] ", precallRecvLocInfo.getContactId(), messageId, Integer.valueOf(receipt), Integer.valueOf(precallRecvLocInfo.getType())));
        Message obtain = Message.obtain();
        obtain.what = 27;
        obtain.obj = precallRecvLocInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(PrecallRecvMultMsgInfo precallRecvMultMsgInfo) {
        int messageType = precallRecvMultMsgInfo.getMessageType();
        int receipt = precallRecvMultMsgInfo.getReceipt();
        String messageId = precallRecvMultMsgInfo.getMessageId();
        String contactId = precallRecvMultMsgInfo.getContactId();
        String file = precallRecvMultMsgInfo.getFile();
        int type = precallRecvMultMsgInfo.getType();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-收到消息】java_PrecallRecvMultMsg contactId[%s],messageId[%s],file[%s],messageType[%d],timeLen[%d],receipt[%d],type[%d]", contactId, messageId, file, Integer.valueOf(messageType), Integer.valueOf(precallRecvMultMsgInfo.getTimeLen()), Integer.valueOf(receipt), Integer.valueOf(type)));
        Message obtain = Message.obtain();
        obtain.what = 22;
        obtain.obj = precallRecvMultMsgInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(PrecallRecvReportInfo precallRecvReportInfo) {
        if (precallRecvReportInfo == null) {
            d.d(this.f8061d, "java_PrecallRecvReport get SingleRecvReportInfo is null!");
            return;
        }
        String oldMsgId = precallRecvReportInfo.getOldMsgId();
        String contactId = precallRecvReportInfo.getContactId();
        StringBuilder sb = new StringBuilder();
        sb.append(precallRecvReportInfo.getReceiptType());
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-收到回执】 java_PrecallRecvReport ordinary messageId[%s],sendUrl[%s],receipt[%s],type[%d]", oldMsgId, contactId, sb.toString(), Integer.valueOf(precallRecvReportInfo.getType())));
        Message obtain = Message.obtain();
        obtain.what = 24;
        obtain.obj = precallRecvReportInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(WBShareSendMsgRespInfo wBShareSendMsgRespInfo) {
        if (wBShareSendMsgRespInfo == null) {
            d.d(this.f8061d, "java_WBShareSendResp get WBShareSendMsgRespInfo is null!");
            return;
        }
        String msgid = wBShareSendMsgRespInfo.getMsgid();
        ResultInfo resultInfo = wBShareSendMsgRespInfo.gettResultInfo();
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Wbshare-发送白板共享完成通知】 java_WBShareSendResp sessionId[%s], result[%d], errorReason[%s], errorCode[%d], messageId[%s]", wBShareSendMsgRespInfo.getSzSessionID(), Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), msgid));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 40, wBShareSendMsgRespInfo));
    }

    @Override // d.e.b.g.a
    public void a(WhiteBoardShareType whiteBoardShareType) {
        if (whiteBoardShareType == null) {
            d.d(this.f8061d, "java_WBShareRcv get WhiteBoardShareType is null!");
            return;
        }
        String json = new Gson().toJson(whiteBoardShareType);
        d.a(this.f8061d, "【Wbshare-收到白板共享】 java_WBShareRcv " + json);
        Message obtain = Message.obtain();
        obtain.what = 41;
        obtain.obj = whiteBoardShareType;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo) {
        String format = String.format(Locale.getDefault(), "【单聊-发送输入状态回调】 java_SingleSendTypingAck  sessionID[%s] result[%d] errorCode[%d] errorReason[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason());
        SingleSendTypingAck singleSendTypingAck = new SingleSendTypingAck();
        singleSendTypingAck.setSzSessionID(str);
        singleSendTypingAck.settResultInfo(resultInfo);
        d.a(this.f8061d, format);
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 12, singleSendTypingAck));
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, SingleGetFileResp singleGetFileResp) {
        SingleGetFileResp singleGetFileResp2;
        if (singleGetFileResp == null) {
            d.d(this.f8061d, "java_singleGetLargerFile get null SingleGetFileResp object !");
            singleGetFileResp2 = new SingleGetFileResp();
        } else {
            singleGetFileResp2 = singleGetFileResp;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-接收大文件的结果通知】 java_singleGetLargerFile sessionId[%s], result[%d], errorReason[%s],errorCode[%d],messageId[%s],sendUrl[%s]file[%s],dateTime[%s],timeLen[%d],receipt[%d],messageType[%d],msgFlag[%d],barcycleTime[%d],getFileFlag[%d]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), singleGetFileResp2.getMessageId(), singleGetFileResp2.getSendUrl(), singleGetFileResp2.getFile(), singleGetFileResp2.getDateTime(), Integer.valueOf(singleGetFileResp2.getTimeLen()), Integer.valueOf(singleGetFileResp2.getReceipt()), Integer.valueOf(singleGetFileResp2.getMessageType()), Integer.valueOf(singleGetFileResp2.getMsgFlag()), Integer.valueOf(singleGetFileResp2.getBarcycleTime()), Integer.valueOf(singleGetFileResp2.getGetFileFlag())));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 7, singleGetFileResp2));
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, SingleSendLocationResp singleSendLocationResp) {
        if (singleSendLocationResp == null) {
            d.d(this.f8061d, "java_SingleSendLocationResp get null SingleSendLocationResp object !");
            singleSendLocationResp = new SingleSendLocationResp();
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-发送地理位置执行通知】 java_SingleSendLocationResp sessionId[%s], result[%d], errorReason[%s], errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), singleSendLocationResp.getMessageId()));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 8, singleSendLocationResp));
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, SingleSendMsgResp singleSendMsgResp) {
        String str2;
        if (singleSendMsgResp != null) {
            str2 = singleSendMsgResp.getMessageId();
        } else {
            d.d(this.f8061d, "java_singleSendMsg SingleSendMsgResp is null!");
            str2 = "";
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-发送文本消息执行通知】 java_singleSendMsg sessionId[%s], result[%d], errorReason[%s], errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), str2));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 0, singleSendMsgResp));
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, SingleSendMultMsgResp singleSendMultMsgResp) {
        String str2;
        if (singleSendMultMsgResp != null) {
            str2 = singleSendMultMsgResp.getMessageId();
            singleSendMultMsgResp.setSessionId(str);
        } else {
            d.d(this.f8061d, "java_singleSendMultMsg SingleSendMultMsgResp is null!");
            singleSendMultMsgResp = new SingleSendMultMsgResp();
            str2 = "";
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-发送多媒体消息执行通知】 java_singleSendMultMsg sessionId[%s], result[%d], errorReason[%s], errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), resultInfo.getErrorReason(), Integer.valueOf(resultInfo.getErrorCode()), str2));
        c().sendMessage(a(resultInfo.getResult(), resultInfo.getErrorCode(), resultInfo.getErrorReason(), 1, singleSendMultMsgResp));
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, SingleSendReportResp singleSendReportResp) {
        if (singleSendReportResp == null) {
            d.d(this.f8061d, "java_singleSendReport get null SingleSendReportResp object !");
            singleSendReportResp = new SingleSendReportResp();
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-发送回执完成通知】 java_singleSendReport sessionId[%s],result[%d],errorCode[%d],errorReason[%s],messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), resultInfo.getErrorReason(), singleSendReportResp.getMessageId()));
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, resultInfo.getResult());
        bundle.putInt(ResultInfo.KEY_errorCode, resultInfo.getErrorCode());
        bundle.putString(ResultInfo.KEY_errorReason, resultInfo.getErrorReason());
        obtain.setData(bundle);
        obtain.what = 10;
        obtain.obj = singleSendReportResp;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, PrecallSendLocResp precallSendLocResp) {
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-发送地理位置执行通知】java_PrecallSendLocAck seesionId[%s],result[%d],errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), precallSendLocResp.getMessageId()));
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, resultInfo.getResult());
        bundle.putInt(ResultInfo.KEY_errorCode, resultInfo.getErrorCode());
        bundle.putString(ResultInfo.KEY_errorReason, resultInfo.getErrorReason());
        obtain.setData(bundle);
        obtain.what = 26;
        obtain.obj = precallSendLocResp;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, PrecallSendMultMsgResp precallSendMultMsgResp) {
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-发送多媒体消息执行通知】java_PrecallSendMultMsgAck seesionId[%s],result[%d],errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), precallSendMultMsgResp.getMessageId()));
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, resultInfo.getResult());
        bundle.putInt(ResultInfo.KEY_errorCode, resultInfo.getErrorCode());
        bundle.putString(ResultInfo.KEY_errorReason, resultInfo.getErrorReason());
        obtain.setData(bundle);
        obtain.what = 21;
        obtain.obj = precallSendMultMsgResp;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, ResultInfo resultInfo, PrecallSendReportResp precallSendReportResp) {
        if (precallSendReportResp == null) {
            d.d(this.f8061d, "java_PrecallSendReportAck get null SingleSendReportResp object !");
            precallSendReportResp = new PrecallSendReportResp();
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【Precall-发送回执完成通知】 java_PrecallSendReportAck sessionId[%s],result[%d],errorCode[%d], messageId[%s]", str, Integer.valueOf(resultInfo.getResult()), Integer.valueOf(resultInfo.getErrorCode()), precallSendReportResp.getMessageId()));
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(ResultInfo.KEY_result, resultInfo.getResult());
        bundle.putInt(ResultInfo.KEY_errorCode, resultInfo.getErrorCode());
        bundle.putString(ResultInfo.KEY_errorReason, resultInfo.getErrorReason());
        obtain.what = 23;
        obtain.setData(bundle);
        obtain.obj = precallSendReportResp;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, SingleGetFileRate singleGetFileRate) {
        String str2;
        int i;
        int i2;
        String str3 = "";
        if (singleGetFileRate != null) {
            int tranRate = singleGetFileRate.getTranRate();
            String messageId = singleGetFileRate.getMessageId();
            str2 = singleGetFileRate.getFiletranId();
            i2 = singleGetFileRate.getFinishSize();
            i = tranRate;
            str3 = messageId;
        } else {
            d.d(this.f8061d, "java_singleGetFileRate get null SingleSendFileRate object !");
            str2 = "";
            i = 0;
            i2 = 0;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-接收大文件进度通知】 java_singleGetFileRate sessionId[%s],messageId[%s],TranRate[%d],filetranId[%s],finishSize[%d]", str, str3, Integer.valueOf(i), str2, Integer.valueOf(i2)));
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = singleGetFileRate;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.g.a
    public void a(String str, SingleSendFileRate singleSendFileRate) {
        String str2;
        String str3;
        int i;
        String str4 = "";
        if (singleSendFileRate != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(singleSendFileRate.getTranRate());
            String sb2 = sb.toString();
            String messageId = singleSendFileRate.getMessageId();
            str3 = singleSendFileRate.getFiletranId();
            i = singleSendFileRate.getFinishSize();
            str2 = sb2;
            str4 = messageId;
        } else {
            d.d(this.f8061d, "java_singleSendFileRate get null SingleSendFileRate object !");
            str2 = "";
            str3 = str2;
            i = 0;
        }
        d.a(this.f8061d, String.format(Locale.getDefault(), "【单聊-发送多媒体消息进度通知】 java_singleSendFileRate sessionId[%s],messageId[%s],TranRate[%s],filetranId[%s],finishSize[%d]", str, str4, str2, str3, Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = singleSendFileRate;
        c().sendMessage(obtain);
    }
}
