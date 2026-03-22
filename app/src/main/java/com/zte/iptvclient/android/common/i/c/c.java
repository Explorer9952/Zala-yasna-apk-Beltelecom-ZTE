package com.zte.iptvclient.android.common.i.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.log.LogEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f4655a = new HashMap<>();

    public static void a(Context context) {
        String str;
        String str2 = context.getFilesDir().getPath() + "/source/show";
        String language = Locale.getDefault().getLanguage();
        LogEx.d("lang", "lang=" + language);
        if ("en".equalsIgnoreCase(language) || "fr".equalsIgnoreCase(language) || LocaleUtil.ARABIC.equalsIgnoreCase(language)) {
            str = "strings_" + language + ".xml";
        } else {
            str = "strings_fr.xml";
        }
        String str3 = str2 + "/" + str;
        if (new File(str3).exists()) {
            LogEx.d("lang", "has local string localPath=" + str3);
            InputStream d2 = a.d(str3);
            if (d2 != null) {
                a(d2);
            }
            if (d2 != null) {
                try {
                    d2.close();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            a(context.getResources().getAssets().open(str));
        } catch (Exception e2) {
            LogEx.d("ContentValues", "e=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private static void a(InputStream inputStream) {
        f4655a.clear();
        try {
            try {
                try {
                    NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("string");
                    int length = elementsByTagName.getLength();
                    LogEx.d("lang", "length=" + length);
                    for (int i = 0; i < length; i++) {
                        Element element = (Element) elementsByTagName.item(i);
                        if (element != null) {
                            f4655a.put(element.getAttribute("name"), a.a(element));
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e) {
                    LogEx.d("lang", "e=" + e.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (f4655a.containsKey(str)) {
            String str2 = f4655a.get(str);
            if (str2.contains("\\n")) {
                String replaceAll = str2.replaceAll("\\n", "\n");
                Log.d("ContentValues", "getString1 换行 " + replaceAll);
                Log.d("ContentValues", "getString2: " + replaceAll.substring(0, replaceAll.indexOf("\\n")));
                Log.d("ContentValues", "getString3: " + replaceAll.substring(replaceAll.indexOf("\\n") + 2, replaceAll.length()));
                String substring = replaceAll.substring(0, replaceAll.indexOf("\\n"));
                String substring2 = replaceAll.substring(replaceAll.indexOf("\\n") + 2, replaceAll.length());
                Log.d("ContentValues", "getString4:" + (substring + "\n" + substring2));
                return substring + "\n" + substring2;
            }
            return f4655a.get(str);
        }
        return context.getResources().getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }
}
