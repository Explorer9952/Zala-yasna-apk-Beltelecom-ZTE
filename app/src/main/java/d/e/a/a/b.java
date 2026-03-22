package d.e.a.a;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CodeTransAPI.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0411b f8037a = null;

    /* renamed from: b, reason: collision with root package name */
    private SDKNetHTTPRequest f8038b;

    /* compiled from: CodeTransAPI.java */
    /* loaded from: classes2.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            Map<String, Object> a2 = b.a(str, new ArrayList());
            if (a2 != null) {
                b.this.f8037a.a(((Integer) a2.get("returncode")).intValue(), (String) a2.get("errormsg"), a2);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
        }
    }

    /* compiled from: CodeTransAPI.java */
    /* renamed from: d.e.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0411b {
        void a(int i, String str, Map<String, Object> map);
    }

    public void a(String str, String str2, String str3, InterfaceC0411b interfaceC0411b) {
        if (interfaceC0411b == null) {
            return;
        }
        this.f8037a = interfaceC0411b;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f8038b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setParam("contenttype", str);
        this.f8038b.setParam("columncode", str3);
        this.f8038b.setParam("contentcode", str2);
        this.f8038b.startRequest(String.format("%s%s/getinnercode.jsp", c.a(), SDKLoginMgr.getInstance().getUserInfo("StypeUrl")), HttpRequest.METHOD_GET, new a());
    }

    public static Map<String, Object> a(String str, List<Map<String, Object>> list) {
        LogEx.d("CodeTransAPI", "analysisSearchCommonJson start. strResponseJson = " + str);
        if (StringUtil.isEmptyString(str)) {
            LogEx.w("CodeTransAPI", "strResponseJson is null");
            return null;
        }
        LogEx.d("CodeTransAPI", "strResponseJson:" + str);
        Map<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt((String) jSONObject.get("returncode"));
            hashMap.put("returncode", Integer.valueOf(parseInt));
            LogEx.d("CodeTransAPI", "intReturnCode:" + parseInt);
            String str2 = (String) jSONObject.get("errormsg");
            hashMap.put("errormsg", str2);
            LogEx.d("CodeTransAPI", "strMsg:" + str2);
            if (parseInt != 0) {
                LogEx.w("CodeTransAPI", "the json String is error.strMsg:" + str2);
                list.add(hashMap);
                return hashMap;
            }
            if (jSONObject.has("columncode")) {
                hashMap.put("columncode", (String) jSONObject.get("columncode"));
            }
            if (jSONObject.has("contentcode")) {
                hashMap.put("contentcode", (String) jSONObject.get("contentcode"));
            }
            if (jSONObject.has("contenttype")) {
                hashMap.put("contenttype", (String) jSONObject.get("contenttype"));
            }
            if (jSONObject.has("programcode")) {
                hashMap.put("programcode", (String) jSONObject.get("programcode"));
            }
            list.add(hashMap);
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.w("CodeTransAPI", "Failed to parse jason:" + str);
            return null;
        }
    }
}
