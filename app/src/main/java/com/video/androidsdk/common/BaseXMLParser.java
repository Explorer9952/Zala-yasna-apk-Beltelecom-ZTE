package com.video.androidsdk.common;

import java.io.StringReader;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public abstract class BaseXMLParser extends DefaultHandler {
    protected String mstrTagLevel1Name = null;
    protected String mstrTagLevel2Name = null;
    protected String mstrTagLevel3Name = null;
    protected String mstrTagLevel4Name = null;
    protected String mstrTagLevel5Name = null;
    protected StringBuilder sbTagValue = new StringBuilder();

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        super.characters(cArr, i, i2);
        this.sbTagValue.append(cArr, i, i2);
    }

    public abstract Object getResult();

    public Object parseXML(String str) {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(this);
            xMLReader.parse(new InputSource(new StringReader(str)));
            return getResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        this.sbTagValue.setLength(0);
    }
}
