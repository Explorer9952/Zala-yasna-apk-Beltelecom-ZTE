package com.video.androidsdk.common.xml;

import com.video.androidsdk.log.LogEx;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class DomParser {
    private static final String LOG_TAG = "DomParser";

    public static Object parse2Bean(InputStream inputStream, Class<?> cls) {
        if (inputStream == null) {
            LogEx.w(LOG_TAG, "InputStream is null.Parse abnormal!");
            return null;
        }
        if (cls == null) {
            LogEx.w(LOG_TAG, "Parse class is null.Parse abnormal!");
            return null;
        }
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(new EntityResolver() { // from class: com.video.androidsdk.common.xml.DomParser.1
                @Override // org.xml.sax.EntityResolver
                public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
                    return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='utf-8'?>".getBytes()));
                }
            });
            return new DomNodeParser().reflectBean(newDocumentBuilder.parse(inputStream).getDocumentElement(), cls);
        } catch (IOException e) {
            LogEx.w(LOG_TAG, "Parse stream io exception!" + e.getMessage());
            return null;
        } catch (ParserConfigurationException e2) {
            LogEx.w(LOG_TAG, "Parse stream failed!" + e2.getMessage());
            return null;
        } catch (SAXException e3) {
            LogEx.w(LOG_TAG, "Parse stream failed!" + e3.getMessage());
            return null;
        }
    }
}
