package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ClientErrorMsgManager.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: d, reason: collision with root package name */
    private static f f4554d = new f();
    private static String e = "ClientErrorMsgManager";

    /* renamed from: a, reason: collision with root package name */
    private XmlResourceParser f4555a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4556b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f4557c;

    private f() {
    }

    public static f b() {
        return f4554d;
    }

    public Map<String, String> a() {
        if (this.f4556b == null) {
            return null;
        }
        this.f4557c = new HashMap();
        XmlResourceParser xml = this.f4556b.getResources().getXml(R.xml.bmserror);
        this.f4555a = xml;
        try {
            int eventType = xml.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    LogEx.d(e, "start document");
                } else if (eventType == 2) {
                    String name = this.f4555a.getName();
                    if (name.equals("error")) {
                        String attributeValue = this.f4555a.getAttributeValue(0);
                        String nextText = this.f4555a.nextText();
                        if (attributeValue.equals("9000~9999")) {
                            this.f4557c.put("9000", nextText);
                        } else {
                            this.f4557c.put(attributeValue, nextText);
                        }
                    } else if (name.equals("resources")) {
                        LogEx.d(e, "start parse resources");
                    }
                } else if (eventType == 3) {
                    LogEx.d(e, "end tag");
                }
                eventType = this.f4555a.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
        LogEx.d(e, "errorMap: " + this.f4557c.toString());
        return this.f4557c;
    }

    public void a(Context context) {
        this.f4556b = context;
    }
}
