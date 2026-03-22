package com.video.androidsdk.common.util;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class XML2Json {
    public static final Character AMP = '&';
    public static final Character APOS = '\'';
    public static final Character BANG = '!';
    public static final Character EQ = '=';
    public static final Character GT = '>';
    public static final Character LT = '<';
    public static final Character QUEST = '?';
    public static final Character QUOT = '\"';
    public static final Character SLASH = '/';

    private static Iterable<Integer> codePointIterator(final String str) {
        return new Iterable<Integer>() { // from class: com.video.androidsdk.common.util.XML2Json.1
            @Override // java.lang.Iterable
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() { // from class: com.video.androidsdk.common.util.XML2Json.1.1
                    private int length;
                    private int nextIndex = 0;

                    {
                        this.length = str.length();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.nextIndex < this.length;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Integer next() {
                        int codePointAt = str.codePointAt(this.nextIndex);
                        this.nextIndex += Character.charCount(codePointAt);
                        return Integer.valueOf(codePointAt);
                    }
                };
            }
        };
    }

    public static String escape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        Iterator<Integer> it2 = codePointIterator(str).iterator();
        while (it2.hasNext()) {
            int intValue = it2.next().intValue();
            if (intValue == 34) {
                sb.append("&quot;");
            } else if (intValue == 60) {
                sb.append("&lt;");
            } else if (intValue == 62) {
                sb.append("&gt;");
            } else if (intValue == 38) {
                sb.append("&amp;");
            } else if (intValue != 39) {
                if (mustEscape(intValue)) {
                    sb.append("&#x");
                    sb.append(Integer.toHexString(intValue));
                    sb.append(';');
                } else {
                    sb.appendCodePoint(intValue);
                }
            } else {
                sb.append("&apos;");
            }
        }
        return sb.toString();
    }

    private static boolean mustEscape(int i) {
        return !(!Character.isISOControl(i) || i == 9 || i == 10 || i == 13) || ((i < 32 || i > 55295) && ((i < 57344 || i > 65533) && (i < 65536 || i > 1114111)));
    }

    public static void noSpace(String str) throws JSONException {
        int length = str.length();
        if (length == 0) {
            throw new JSONException("Empty string.");
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                throw new JSONException("'" + str + "' contains a space character.");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x010b, code lost:
    
        r7 = r10.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0111, code lost:
    
        if ((r7 instanceof java.lang.String) == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0113, code lost:
    
        r7 = (java.lang.String) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0115, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0118, code lost:
    
        r7 = stringToValue(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0126, code lost:
    
        throw r10.syntaxError("Missing value");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean parse(com.video.androidsdk.common.util.XMLTokener r10, org.json.JSONObject r11, java.lang.String r12, boolean r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.util.XML2Json.parse(com.video.androidsdk.common.util.XMLTokener, org.json.JSONObject, java.lang.String, boolean):boolean");
    }

    public static Object stringToValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return JSONObject.NULL;
        }
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            try {
                if (str.indexOf(46) <= -1 && str.indexOf(101) <= -1 && str.indexOf(69) <= -1 && !"-0".equals(str)) {
                    Long valueOf = Long.valueOf(str);
                    if (str.equals(valueOf.toString())) {
                        return valueOf.longValue() == ((long) valueOf.intValue()) ? Integer.valueOf(valueOf.intValue()) : valueOf;
                    }
                }
                Double valueOf2 = Double.valueOf(str);
                if (!valueOf2.isInfinite() && !valueOf2.isNaN()) {
                    return valueOf2;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        return toJSONObject(str, false);
    }

    public static String toString(Object obj) throws JSONException {
        return toString(obj, null);
    }

    public static String unescape(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                int indexOf = str.indexOf(59, i);
                if (indexOf > i) {
                    String substring = str.substring(i + 1, indexOf);
                    sb.append(XMLTokener.unescapeEntity(substring));
                    i += substring.length() + 1;
                } else {
                    sb.append(charAt);
                }
            } else {
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }

    public static JSONObject toJSONObject(String str, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(str);
        while (xMLTokener.more()) {
            xMLTokener.skipPast("<");
            if (xMLTokener.more()) {
                parse(xMLTokener, jSONObject, null, z);
            }
        }
        return jSONObject;
    }

    public static String toString(Object obj, String str) throws JSONException {
        JSONArray jSONArray;
        StringBuilder sb = new StringBuilder();
        if (obj instanceof JSONObject) {
            if (str != null) {
                sb.append('<');
                sb.append(str);
                sb.append('>');
            }
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt == null) {
                    opt = "";
                }
                if ("content".equals(next)) {
                    if (opt instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) opt;
                        int length = jSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            if (i > 0) {
                                sb.append('\n');
                            }
                            sb.append(escape(jSONArray2.opt(i).toString()));
                        }
                    } else {
                        sb.append(escape(opt.toString()));
                    }
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray3 = (JSONArray) opt;
                    int length2 = jSONArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object opt2 = jSONArray3.opt(i2);
                        if (opt2 instanceof JSONArray) {
                            sb.append('<');
                            sb.append(next);
                            sb.append('>');
                            sb.append(toString(opt2));
                            sb.append("</");
                            sb.append(next);
                            sb.append('>');
                        } else {
                            sb.append(toString(opt2, next));
                        }
                    }
                } else if (opt.toString().length() == 0) {
                    sb.append('<');
                    sb.append(next);
                    sb.append("/>");
                } else {
                    sb.append(toString(opt, next));
                }
            }
            if (str != null) {
                sb.append("</");
                sb.append(str);
                sb.append('>');
            }
            return sb.toString();
        }
        if (obj != null && ((obj instanceof JSONArray) || obj.getClass().isArray())) {
            if (obj.getClass().isArray()) {
                jSONArray = (JSONArray) obj;
            } else {
                jSONArray = (JSONArray) obj;
            }
            int length3 = jSONArray.length();
            for (int i3 = 0; i3 < length3; i3++) {
                sb.append(toString(jSONArray.opt(i3), str == null ? "array" : str));
            }
            return sb.toString();
        }
        String escape = obj == null ? "null" : escape(obj.toString());
        if (str == null) {
            return "\"" + escape + "\"";
        }
        if (escape.length() == 0) {
            return "<" + str + "/>";
        }
        return "<" + str + ">" + escape + "</" + str + ">";
    }
}
