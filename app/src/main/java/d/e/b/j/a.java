package d.e.b.j;

import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.presence.PresContactFreeTextSynNotify;
import com.zte.ucs.tvcall.ocx.presence.PresContactNode;
import com.zte.ucs.tvcall.ocx.presence.PresDocumentInfoNode;
import com.zte.ucs.tvcall.ocx.presence.PresPersonalFreeTextNotify;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalNotify;
import com.zte.ucs.tvcall.ocx.presence.PresUniversalResp;
import com.zte.ucs.tvcall.ocx.presence.PresUploadFreeTextResp;

/* loaded from: classes2.dex */
public interface a {
    void a(PresContactFreeTextSynNotify presContactFreeTextSynNotify);

    void a(PresPersonalFreeTextNotify presPersonalFreeTextNotify);

    void a(PresUniversalNotify presUniversalNotify);

    void a(PresUploadFreeTextResp presUploadFreeTextResp);

    void a(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void a(String str, ResultInfo resultInfo, PresDocumentInfoNode[] presDocumentInfoNodeArr);

    void a(String str, PresUniversalResp presUniversalResp);

    void a(String str, String str2, PresContactNode[] presContactNodeArr);

    void b(PresUniversalNotify presUniversalNotify);

    void b(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void c(PresUniversalNotify presUniversalNotify);

    void c(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void d(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void e(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void f(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void g(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void h(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void i(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void j(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void k(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void l(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void m(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);

    void n(String str, ResultInfo resultInfo, PresUniversalResp presUniversalResp);
}
