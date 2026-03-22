package com.video.androidsdk.common.config;

import android.util.Xml;
import com.tencent.mm.sdk.contact.RContact;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class RequestConfigParser {
    private static String LOG_TAG = "RequestConfigParser";
    private static RequestConfigParser mInstance;
    private Map<String, ClientRequest> mRequestMap = new HashMap();

    public static RequestConfigParser getInstance() {
        if (mInstance == null) {
            mInstance = new RequestConfigParser();
        }
        return mInstance;
    }

    public ClientRequest getRequestCofig(String str) {
        if (str == null) {
            LogEx.w(LOG_TAG, "RequestId is null.");
            return null;
        }
        Map<String, ClientRequest> map = this.mRequestMap;
        if (map == null) {
            LogEx.w(LOG_TAG, "requestconfig.xml maybe parse failed. Please check previous log.");
            return null;
        }
        if (map.containsKey(str)) {
            LogEx.d(LOG_TAG, "Found RequestId " + str);
            return this.mRequestMap.get(str);
        }
        LogEx.w(LOG_TAG, str + " not found. Maybe forget configured.");
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0017 -> B:12:0x0043). Please report as a decompilation issue!!! */
    public void parseRequestConfig(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                parseRequestConfig(fileInputStream);
                fileInputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                LogEx.w(LOG_TAG, "Parse abnormal! " + e.getMessage());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            return;
        }
        LogEx.w(LOG_TAG, "Parse requestconfig.xml failed! File is null or not exist.");
    }

    public void parseRequestConfig(InputStream inputStream) {
        String attributeValue;
        String nextText;
        String attributeValue2;
        String attributeValue3;
        String attributeValue4;
        String nextText2;
        String nextText3;
        String nextText4;
        if (inputStream == null) {
            LogEx.w(LOG_TAG, "InputStream is null.Parse abnormal!");
            return;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, "UTF-8");
            ClientRequest clientRequest = null;
            for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("ClientRequest".equalsIgnoreCase(name)) {
                        clientRequest = new ClientRequest();
                        String attributeValue5 = newPullParser.getAttributeValue(null, "requestID");
                        if (attributeValue5 == null) {
                            LogEx.w(LOG_TAG, "requestId is null! Will Ignore!");
                        } else {
                            clientRequest.setRequestID(attributeValue5);
                        }
                    } else if ("conntimeout".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (nextText4 = newPullParser.nextText()) != null) {
                            try {
                                clientRequest.setConnectTimeout(Integer.parseInt(nextText4));
                            } catch (NumberFormatException unused) {
                                LogEx.w(LOG_TAG, "conntimeout configure is error:" + nextText4);
                            }
                        }
                    } else if ("readtimeout".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (nextText3 = newPullParser.nextText()) != null) {
                            try {
                                clientRequest.setSocketTimeout(Integer.parseInt(nextText3));
                            } catch (NumberFormatException unused2) {
                                LogEx.w(LOG_TAG, "readtimeout configure is error:" + nextText3);
                            }
                        }
                    } else if ("requestMethod".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (nextText2 = newPullParser.nextText()) != null) {
                            clientRequest.setRequestMethod(nextText2);
                        }
                    } else if ("request".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (attributeValue3 = newPullParser.getAttributeValue(null, "type")) != null && (attributeValue4 = newPullParser.getAttributeValue(null, "class")) != null) {
                            clientRequest.setRequestType(attributeValue3);
                            clientRequest.setRequestClass(attributeValue4);
                        }
                    } else if ("response".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (attributeValue2 = newPullParser.getAttributeValue(null, "type")) != null) {
                            String attributeValue6 = newPullParser.getAttributeValue(null, "class");
                            String attributeValue7 = newPullParser.getAttributeValue(null, "value");
                            if (attributeValue6 != null) {
                                clientRequest.setResponseType(attributeValue2);
                                clientRequest.setResponseClass(attributeValue6);
                                clientRequest.setResponseValue(attributeValue7);
                            }
                        }
                    } else if ("MergeMode".equalsIgnoreCase(name)) {
                        if (clientRequest != null && (nextText = newPullParser.nextText()) != null) {
                            try {
                                clientRequest.setMergeMode(Integer.parseInt(nextText));
                            } catch (NumberFormatException unused3) {
                                LogEx.w(LOG_TAG, "MergeMode configure is error:" + nextText);
                            }
                            String attributeValue8 = newPullParser.getAttributeValue(null, "concurrentnum");
                            if (attributeValue8 == null) {
                                LogEx.w(LOG_TAG, "concurrentnum is null! Ignore!");
                            } else {
                                try {
                                    clientRequest.setConcurrentNum(Integer.parseInt(attributeValue8));
                                } catch (NumberFormatException unused4) {
                                    LogEx.w(LOG_TAG, "concurrentnum configure is error:" + attributeValue8);
                                }
                            }
                        }
                    } else if ("IsReturnRawData".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            clientRequest.setReturnRawData("1".equals(newPullParser.nextText()));
                        }
                    } else if (ParamConst.SERVER_URL.equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            clientRequest.setServerUrl(newPullParser.nextText());
                        }
                    } else if ("datafrom".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            clientRequest.setDataFrom(newPullParser.nextText());
                        }
                    } else if ("pageno".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            String attributeValue9 = newPullParser.getAttributeValue(null, RContact.COL_ALIAS);
                            if (attributeValue9 == null) {
                                clientRequest.setRequestPageNoKey(name);
                            } else {
                                clientRequest.setRequestPageNoKey(attributeValue9);
                            }
                        }
                    } else if ("numperpage".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            String attributeValue10 = newPullParser.getAttributeValue(null, RContact.COL_ALIAS);
                            if (attributeValue10 == null) {
                                clientRequest.setRequestNumPerPageKey(name);
                            } else {
                                clientRequest.setRequestNumPerPageKey(attributeValue10);
                            }
                        }
                    } else if ("returncode".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            String attributeValue11 = newPullParser.getAttributeValue(null, RContact.COL_ALIAS);
                            if (attributeValue11 == null) {
                                clientRequest.setResponseReturnCodeKey(name);
                            } else {
                                clientRequest.setResponseReturnCodeKey(attributeValue11);
                            }
                        }
                    } else if ("errormsg".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            String attributeValue12 = newPullParser.getAttributeValue(null, RContact.COL_ALIAS);
                            if (attributeValue12 == null) {
                                clientRequest.setResponseErrorMsgKey(name);
                            } else {
                                clientRequest.setResponseErrorMsgKey(attributeValue12);
                            }
                        }
                    } else if ("totalcount".equalsIgnoreCase(name)) {
                        if (clientRequest != null) {
                            String attributeValue13 = newPullParser.getAttributeValue(null, RContact.COL_ALIAS);
                            if (attributeValue13 == null) {
                                clientRequest.setResponseTotalCountKey(name);
                            } else {
                                clientRequest.setResponseTotalCountKey(attributeValue13);
                            }
                        }
                    } else if ("response".equalsIgnoreCase(name) && clientRequest != null && (attributeValue = newPullParser.getAttributeValue(null, "markfield")) != null) {
                        clientRequest.setResponseMarkFieldKey(attributeValue);
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ClientRequest".equalsIgnoreCase(newPullParser.getName()) && clientRequest != null) {
                    String requestID = clientRequest.getRequestID();
                    if (requestID == null) {
                        LogEx.w(LOG_TAG, "requestId is null! Ignore! Should check configure!");
                    } else {
                        if (this.mRequestMap.containsKey(requestID)) {
                            LogEx.w(LOG_TAG, "requestId " + requestID + " conflict!Cover last one! Need check configure!");
                        }
                        this.mRequestMap.put(requestID, clientRequest);
                        clientRequest = null;
                    }
                }
            }
        } catch (IOException e) {
            LogEx.w(LOG_TAG, "Parse abnormal!" + e.getMessage());
        } catch (XmlPullParserException e2) {
            LogEx.w(LOG_TAG, "Parse abnormal! requestconfig.xml maybe has syntax error! " + e2.getMessage());
        }
    }
}
