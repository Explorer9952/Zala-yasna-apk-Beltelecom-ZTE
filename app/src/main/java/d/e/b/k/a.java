package d.e.b.k;

import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.card.CardMsgInfo;
import com.zte.ucs.tvcall.ocx.card.CardSendMsgRespInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.FirePaMsgContentRecvInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaDetailInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMainMenuInfo;
import com.zte.ucs.tvcall.ocx.publicaccount.PaMsgContent;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendFileRate;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendMultMsgResp;
import com.zte.ucs.tvcall.ocx.publicaccount.PaSendRptResp;

/* loaded from: classes2.dex */
public interface a {
    void a(int i, String str);

    void a(CardMsgInfo cardMsgInfo);

    void a(FirePaMsgContentRecvInfo firePaMsgContentRecvInfo);

    void a(String str, ResultInfo resultInfo, CardSendMsgRespInfo cardSendMsgRespInfo);

    void a(String str, ResultInfo resultInfo, PaSendMsgResp paSendMsgResp);

    void a(String str, ResultInfo resultInfo, PaSendMultMsgResp paSendMultMsgResp);

    void a(String str, ResultInfo resultInfo, PaSendRptResp paSendRptResp);

    void a(String str, PaSendFileRate paSendFileRate);

    void a(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr);

    void a(String str, String str2, int i, int i2, PaDetailInfo paDetailInfo);

    void a(String str, String str2, int i, int i2, String str3);

    void a(String str, String str2, int i, int i2, String str3, int i3, PaMainMenuInfo[] paMainMenuInfoArr);

    void a(String str, String str2, int i, int i2, String str3, int i3, PaMsgContent[] paMsgContentArr);

    void b(int i);

    void b(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr);

    void b(String str, String str2, int i, int i2, String str3);

    void c(String str, String str2, int i, int i2, int i3, PaInfo[] paInfoArr);

    void c(String str, String str2, int i, int i2, String str3);

    void d(String str, String str2, int i, int i2, String str3);

    void e(int i);

    void e(String str, String str2, int i, int i2, String str3);

    void g(int i);
}
