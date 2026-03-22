package d.e.b.o;

import android.os.Bundle;
import android.os.Message;
import com.zte.ucs.tvcall.ocx.ResultInfo;
import com.zte.ucs.tvcall.ocx.xcap.XCAPInterfaceResp;
import com.zte.ucs.tvcall.ocx.xcap.XCAPRespInfo;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8072d = d.e.b.i.b.class.getName();

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

    @Override // d.e.b.o.a
    public void a(XCAPInterfaceResp xCAPInterfaceResp) {
        String sessionID = xCAPInterfaceResp.getSessionID();
        XCAPRespInfo xCAPRespInfo = xCAPInterfaceResp.gettXcapRespInfo();
        int returncode = xCAPRespInfo.getReturncode();
        int content_Length = xCAPRespInfo.getContent_Length();
        String content_Type = xCAPRespInfo.getContent_Type();
        String etag = xCAPRespInfo.getEtag();
        String location = xCAPRespInfo.getLocation();
        String body = xCAPRespInfo.getBody();
        ResultInfo resultInfo = xCAPInterfaceResp.gettResultInfo();
        int result = resultInfo.getResult();
        int errorCode = resultInfo.getErrorCode();
        String errorReason = resultInfo.getErrorReason();
        d.a(this.f8072d, String.format(Locale.getDefault(), "【xcap-协议接口回调】  sessionID[%s] returncode[%d] content_Length[%d] content_Type[%s] etag[%s] location[%s] body[%s] result[%d] errorCode[%d] errorReason[%s] currentThread[%s]", sessionID, Integer.valueOf(returncode), Integer.valueOf(content_Length), content_Type, etag, location, body, Integer.valueOf(result), Integer.valueOf(errorCode), errorReason, Thread.currentThread().getName()));
        c().sendMessage(a(result, errorCode, errorReason, 1, xCAPInterfaceResp));
    }
}
