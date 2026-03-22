package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class KVConfig {
    private static boolean aa = false;

    private static void a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            Log.v("MicroMsg.SDK.KVConfig", "empty values");
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Log.v("MicroMsg.SDK.KVConfig", "key=" + entry.getKey() + " value=" + entry.getValue());
        }
    }

    private static void a(Map<String, String> map, String str, Node node, int i) {
        if (node.getNodeName().equals("#text") || node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(node.getNodeName());
        sb.append(i > 0 ? Integer.valueOf(i) : "");
        String sb2 = sb.toString();
        map.put(sb2, node.getNodeValue());
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Node item = attributes.item(i2);
                map.put(sb2 + ".$" + item.getNodeName(), item.getNodeValue());
            }
        }
        HashMap hashMap = new HashMap();
        NodeList childNodes = node.getChildNodes();
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item2 = childNodes.item(i3);
            int nullAsNil = Util.nullAsNil((Integer) hashMap.get(item2.getNodeName()));
            a(map, sb2, item2, nullAsNil);
            hashMap.put(item2.getNodeName(), Integer.valueOf(nullAsNil + 1));
        }
    }

    public static Map<String, String> parseIni(String str) {
        String[] split;
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0 && (split = str2.trim().split("=", 2)) != null && split.length >= 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_]*")) {
                    hashMap.put(str3, str4);
                }
            }
        }
        if (aa) {
            a(hashMap);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (r5 != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> parseXml(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 60
            int r0 = r9.indexOf(r0)
            java.lang.String r1 = "MicroMsg.SDK.KVConfig"
            r2 = 0
            if (r0 >= 0) goto L12
            java.lang.String r9 = "text not in xml format"
        Le:
            com.tencent.mm.sdk.platformtools.Log.e(r1, r9)
            return r2
        L12:
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L27
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r5[r4] = r6
            java.lang.String r6 = "fix xml header from + %d"
            com.tencent.mm.sdk.platformtools.Log.w(r1, r6, r5)
            java.lang.String r9 = r9.substring(r0)
        L27:
            if (r9 == 0) goto Lc2
            int r0 = r9.length()
            if (r0 > 0) goto L31
            goto Lc2
        L31:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            javax.xml.parsers.DocumentBuilderFactory r5 = javax.xml.parsers.DocumentBuilderFactory.newInstance()
            javax.xml.parsers.DocumentBuilder r5 = r5.newDocumentBuilder()     // Catch: javax.xml.parsers.ParserConfigurationException -> Lbe
            if (r5 != 0) goto L43
            java.lang.String r9 = "new Document Builder failed"
            goto Le
        L43:
            org.xml.sax.InputSource r6 = new org.xml.sax.InputSource     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            byte[] r9 = r9.getBytes()     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            r7.<init>(r9)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            r6.<init>(r7)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            if (r11 == 0) goto L56
            r6.setEncoding(r11)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
        L56:
            org.w3c.dom.Document r9 = r5.parse(r6)     // Catch: java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d org.w3c.dom.DOMException -> L72
            r9.normalize()     // Catch: org.w3c.dom.DOMException -> L5e java.lang.Exception -> L63 java.io.IOException -> L68 org.xml.sax.SAXException -> L6d
            goto L78
        L5e:
            r11 = move-exception
            r8 = r11
            r11 = r9
            r9 = r8
            goto L74
        L63:
            r9 = move-exception
            r9.printStackTrace()
            return r2
        L68:
            r9 = move-exception
            r9.printStackTrace()
            return r2
        L6d:
            r9 = move-exception
            r9.printStackTrace()
            return r2
        L72:
            r9 = move-exception
            r11 = r2
        L74:
            r9.printStackTrace()
            r9 = r11
        L78:
            if (r9 != 0) goto L7d
            java.lang.String r9 = "new Document failed"
            goto Le
        L7d:
            org.w3c.dom.Element r9 = r9.getDocumentElement()
            if (r9 != 0) goto L86
            java.lang.String r9 = "getDocumentElement failed"
            goto Le
        L86:
            java.lang.String r11 = ""
            if (r10 == 0) goto L98
            java.lang.String r5 = r9.getNodeName()
            boolean r5 = r10.equals(r5)
            if (r5 == 0) goto L98
        L94:
            a(r0, r11, r9, r4)
            goto Lb6
        L98:
            org.w3c.dom.NodeList r9 = r9.getElementsByTagName(r10)
            int r10 = r9.getLength()
            if (r10 > 0) goto La6
            java.lang.String r9 = "parse item null"
            goto Le
        La6:
            int r10 = r9.getLength()
            if (r10 <= r3) goto Lb1
            java.lang.String r10 = "parse items more than one"
            com.tencent.mm.sdk.platformtools.Log.w(r1, r10)
        Lb1:
            org.w3c.dom.Node r9 = r9.item(r4)
            goto L94
        Lb6:
            boolean r9 = com.tencent.mm.sdk.platformtools.KVConfig.aa
            if (r9 == 0) goto Lbd
            a(r0)
        Lbd:
            return r0
        Lbe:
            r9 = move-exception
            r9.printStackTrace()
        Lc2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.KVConfig.parseXml(java.lang.String, java.lang.String, java.lang.String):java.util.Map");
    }
}
