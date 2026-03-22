package d.e.b.e;

import com.zte.ucs.tvcall.ocx.OCXNative;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f8059a = a.class.getSimpleName();

    @Override // d.e.b.e.b
    public String a() {
        String jni_CliDbGetSdkLicenseStr = OCXNative.jni_CliDbGetSdkLicenseStr();
        d.d(this.f8059a, String.format(Locale.getDefault(), "【配置-获取license控制信息】 OCXNative.jni_CliDbGetSdkLicenseStr str[%s] currentThread[%s]", jni_CliDbGetSdkLicenseStr, Thread.currentThread().getName()));
        return jni_CliDbGetSdkLicenseStr;
    }

    @Override // d.e.b.e.b
    public boolean a(String str) {
        d.d(this.f8059a, String.format(Locale.getDefault(), "【配置-设置license文件路径】 OCXNative.jni_CliDbSetSdkLicenseFilePath path[%s] currentThread[%s]", str, Thread.currentThread().getName()));
        return OCXNative.jni_CliDbSetSdkLicenseFilePath(str);
    }
}
