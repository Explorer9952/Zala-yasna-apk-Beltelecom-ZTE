package c.a.a.a.b;

import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: AttrFactory.java */
/* loaded from: classes.dex */
public class a {
    public static g a(String str, int i, String str2, String str3) {
        g eVar;
        if ("background".equals(str)) {
            eVar = new b();
        } else if ("textColor".equals(str)) {
            eVar = new i();
        } else if ("listSelector".equals(str)) {
            eVar = new f();
        } else if ("divider".equals(str)) {
            eVar = new d();
        } else if ("textSize".equals(str)) {
            eVar = new j();
        } else if (TtmlNode.ATTR_TTS_BACKGROUND_COLOR.equals(str)) {
            eVar = new c();
        } else {
            if (!"src".equals(str)) {
                return null;
            }
            eVar = new e();
        }
        eVar.f1857a = str;
        eVar.f1858b = i;
        eVar.f1859c = str2;
        eVar.f1860d = str3;
        return eVar;
    }

    public static boolean a(String str) {
        return "background".equals(str) || "textColor".equals(str) || "listSelector".equals(str) || "divider".equals(str) || "textSize".equals(str) || TtmlNode.ATTR_TTS_BACKGROUND_COLOR.equals(str) || "src".equals(str);
    }
}
