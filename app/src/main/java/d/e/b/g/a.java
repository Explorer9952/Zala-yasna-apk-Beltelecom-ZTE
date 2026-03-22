package d.e.b.g;

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
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvLocInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvMultMsgInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallRecvReportInfo;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendLocResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.precall.PrecallSendReportResp;
import com.zte.ucs.tvcall.ocx.wb.WBShareSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.wb.WhiteBoardShareType;

/* loaded from: classes2.dex */
public interface a {
    void a(MailMsgMediaArticle mailMsgMediaArticle);

    void a(GrpSendLargeMsgRateInfo grpSendLargeMsgRateInfo);

    void a(GrpSendMsgRespInfo grpSendMsgRespInfo);

    void a(MsgRevokeRespInfo msgRevokeRespInfo);

    void a(SingleFileBase singleFileBase);

    void a(SingleMsgInfo singleMsgInfo);

    void a(SingleMsgRevokeRpt singleMsgRevokeRpt);

    void a(SingleMultMsgInfo singleMultMsgInfo);

    void a(SingleRecvLocationInfo singleRecvLocationInfo);

    void a(SingleRecvReportInfo singleRecvReportInfo);

    void a(SingleRecvTypingInfo singleRecvTypingInfo);

    void a(PrecallRecvLocInfo precallRecvLocInfo);

    void a(PrecallRecvMultMsgInfo precallRecvMultMsgInfo);

    void a(PrecallRecvReportInfo precallRecvReportInfo);

    void a(WBShareSendMsgRespInfo wBShareSendMsgRespInfo);

    void a(WhiteBoardShareType whiteBoardShareType);

    void a(String str, ResultInfo resultInfo);

    void a(String str, ResultInfo resultInfo, SingleGetFileResp singleGetFileResp);

    void a(String str, ResultInfo resultInfo, SingleSendLocationResp singleSendLocationResp);

    void a(String str, ResultInfo resultInfo, SingleSendMsgResp singleSendMsgResp);

    void a(String str, ResultInfo resultInfo, SingleSendMultMsgResp singleSendMultMsgResp);

    void a(String str, ResultInfo resultInfo, SingleSendReportResp singleSendReportResp);

    void a(String str, ResultInfo resultInfo, PrecallSendLocResp precallSendLocResp);

    void a(String str, ResultInfo resultInfo, PrecallSendMultMsgResp precallSendMultMsgResp);

    void a(String str, ResultInfo resultInfo, PrecallSendReportResp precallSendReportResp);

    void a(String str, SingleGetFileRate singleGetFileRate);

    void a(String str, SingleSendFileRate singleSendFileRate);
}
