package com.video.androidsdk.mes;

import android.content.Context;
import android.net.Uri;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.b.c;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.mes.SDKCloudMsgMgr;
import com.video.androidsdk.mes.bean.MsgInfo;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKPushMsgMgr {
    private static final String LOG_TAG = "SDKPushMsgMgr";
    private static final String MESNOTIFY_MSGCODE_SIGNOUT = "9000";
    static SDKPushMsgMgr instance;
    private PushMsgDAO mDatabaseDao;
    private c mSDKDatabaseProxy;
    private SDKCloudMsgMgr.IMesCloudMsg mesListener = new SDKCloudMsgMgr.IMesCloudMsg() { // from class: com.video.androidsdk.mes.SDKPushMsgMgr.1
        @Override // com.video.androidsdk.mes.SDKCloudMsgMgr.IMesCloudMsg
        public void onMesNotify(MesMsg mesMsg) {
            if (!a.f) {
                LogEx.e(SDKPushMsgMgr.LOG_TAG, ErrMessage.LIC_INVALIDATE);
            } else if (SDKPushMsgMgr.this.pushListener != null) {
                SDKPushMsgMgr.this.pushListener.onMsgNotify(mesMsg);
            }
        }

        @Override // com.video.androidsdk.mes.SDKCloudMsgMgr.IMesCloudMsg
        public void onMsgInfo(Message message) {
            if (!a.f) {
                LogEx.e(SDKPushMsgMgr.LOG_TAG, ErrMessage.LIC_INVALIDATE);
                return;
            }
            if (SDKPushMsgMgr.this.pushListener == null || message == null) {
                LogEx.w(SDKPushMsgMgr.LOG_TAG, "push return message is null");
                return;
            }
            try {
                String trim = message.getMsginfo().trim();
                JSONObject jSONObject = new JSONObject(trim);
                LogEx.d(SDKPushMsgMgr.LOG_TAG, "MsgTpe is : " + jSONObject.getString("MsgType"));
                LogEx.d(SDKPushMsgMgr.LOG_TAG, "msgInfo is : " + trim);
                LogEx.d(SDKPushMsgMgr.LOG_TAG, "obj is : " + jSONObject);
                if ("0".equals(jSONObject.getString("MsgType"))) {
                    MsgInfo msgInfo = new MsgInfo();
                    msgInfo.timestamp = message.getTimestamp();
                    msgInfo.msgid = message.getMsgid();
                    msgInfo.msgType = jSONObject.optString("MsgType");
                    msgInfo.msgBindType = jSONObject.optString("MsgBindType");
                    msgInfo.msgShowType = jSONObject.optString("MsgShowType");
                    msgInfo.msgContent = jSONObject.optString("MsgContent");
                    msgInfo.position = jSONObject.optString("Position");
                    msgInfo.fileUrl = jSONObject.optString("FileUrl");
                    msgInfo.showMode = jSONObject.optString("ShowMode");
                    msgInfo.msgServType = jSONObject.optString("MsgServType");
                    msgInfo.summary = jSONObject.optString("Summary");
                    msgInfo.msgCntType = jSONObject.optString("TypeOfMsgCnt");
                    if (jSONObject.has("MsgServAttr")) {
                        LogEx.d(SDKPushMsgMgr.LOG_TAG, "MsgTpe is 2: " + jSONObject.optString("MsgServAttr"));
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("MsgServAttr"));
                        LogEx.d(SDKPushMsgMgr.LOG_TAG, "strMsgServAttr: " + jSONObject2);
                        LogEx.d(SDKPushMsgMgr.LOG_TAG, "MsgTpe is 3: " + jSONObject2.optString("OperType"));
                        msgInfo.operType = jSONObject2.optString("OperType");
                        LogEx.d(SDKPushMsgMgr.LOG_TAG, "MsgTpe is 4: " + jSONObject2.optString("ServiceType"));
                        msgInfo.serviceType = jSONObject2.optString("ServiceType");
                        LogEx.d(SDKPushMsgMgr.LOG_TAG, "MsgTpe is 5: " + jSONObject2.optString("ServParam"));
                        msgInfo.servParam = jSONObject2.optString("ServParam");
                    }
                    if (SDKPushMsgMgr.this.pushListener != null) {
                        SDKPushMsgMgr.this.pushListener.onMsgInfo(msgInfo);
                        return;
                    }
                    return;
                }
                MsgInfo msgInfo2 = new MsgInfo();
                msgInfo2.timestamp = message.getTimestamp();
                msgInfo2.msgid = message.getMsgid();
                msgInfo2.msgCntType = jSONObject.getString("MsgCntType");
                msgInfo2.msgContent = jSONObject.getString("MsgContent");
                msgInfo2.msgFrom = jSONObject.getString("MsgFrom");
                msgInfo2.msgTitle = jSONObject.getString("MsgTitle");
                msgInfo2.msgType = jSONObject.getString("MsgType");
                msgInfo2.summary = jSONObject.getString("Summary");
                msgInfo2.titleIconUrl = jSONObject.getString("TitleIconUrl");
                if (SDKPushMsgMgr.this.pushListener != null) {
                    SDKPushMsgMgr.this.pushListener.onMsgInfo(msgInfo2);
                }
            } catch (JSONException e) {
                LogEx.d(SDKPushMsgMgr.LOG_TAG, "Parse error: " + message.getMsginfo());
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.mes.SDKCloudMsgMgr.IMesCloudMsg
        public void onMsgInfoAfterTimestamp(Message[] messageArr) {
            if (!a.f) {
                LogEx.e(SDKPushMsgMgr.LOG_TAG, ErrMessage.LIC_INVALIDATE);
                return;
            }
            if (messageArr == null || messageArr.length == 0 || SDKPushMsgMgr.this.pushListener == null) {
                return;
            }
            MsgInfo[] msgInfoArr = new MsgInfo[messageArr.length];
            for (int i = 0; i < messageArr.length; i++) {
                MsgInfo msgInfo = new MsgInfo();
                msgInfo.timestamp = messageArr[i].getTimestamp();
                msgInfo.msgid = messageArr[i].getMsgid();
                String msginfo = messageArr[i].getMsginfo();
                try {
                    JSONObject jSONObject = new JSONObject(msginfo);
                    msgInfo.msgType = jSONObject.optString("MsgType");
                    msgInfo.msgCntType = jSONObject.optString("MsgCntType");
                    msgInfo.msgContent = jSONObject.optString("MsgContent");
                    msgInfo.summary = jSONObject.optString("Summary");
                    msgInfo.titleIconUrl = jSONObject.optString("TitleIconUrl");
                    msgInfo.msgFrom = jSONObject.optString("MsgFrom");
                    msgInfo.msgTitle = jSONObject.optString("MsgTitle");
                    msgInfo.isRead = "0";
                    msgInfo.msgBindType = jSONObject.optString("MsgBindType");
                    msgInfo.msgShowType = jSONObject.optString("MsgShowType");
                    msgInfo.position = jSONObject.optString("Position");
                    msgInfo.fileUrl = jSONObject.optString("FileUrl");
                    msgInfo.showMode = jSONObject.optString("ShowMode");
                    msgInfo.msgServType = jSONObject.optString("MsgServType");
                    if (jSONObject.has("MsgServAttr")) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("MsgServAttr"));
                        msgInfo.serviceType = jSONObject2.optString("ServiceType");
                        msgInfo.operType = jSONObject2.optString("OperType");
                        msgInfo.servParam = jSONObject2.optString("ServParam");
                    }
                    msgInfoArr[i] = msgInfo;
                } catch (JSONException e) {
                    LogEx.d(SDKPushMsgMgr.LOG_TAG, "Parse error: " + msginfo);
                    e.printStackTrace();
                }
            }
            if (SDKPushMsgMgr.this.pushListener != null) {
                SDKPushMsgMgr.this.pushListener.onMsgInfoAfterTimestamp(msgInfoArr);
            }
        }

        @Override // com.video.androidsdk.mes.SDKCloudMsgMgr.IMesCloudMsg
        public void onSummary(Summary summary) {
            if (!a.f) {
                LogEx.e(SDKPushMsgMgr.LOG_TAG, ErrMessage.LIC_INVALIDATE);
            } else {
                if (summary == null || SDKPushMsgMgr.this.pushListener == null) {
                    return;
                }
                SDKPushMsgMgr.this.pushListener.onSummary(summary.getTimestamp(), summary.getMsgid(), summary.getMsgurl(), summary.getSummary());
            }
        }

        @Override // com.video.androidsdk.mes.SDKCloudMsgMgr.IMesCloudMsg
        public void queryMsgInfoByTimestamp() {
            if (SDKPushMsgMgr.this.pushListener != null) {
                SDKPushMsgMgr.this.pushListener.onPrepared();
            }
        }
    };
    private OnPushMsgListener pushListener;

    /* loaded from: classes.dex */
    public interface OnPushMsgListener {
        void onMsgInfo(MsgInfo msgInfo);

        void onMsgInfoAfterTimestamp(MsgInfo[] msgInfoArr);

        void onMsgNotify(MesMsg mesMsg);

        void onPrepared();

        void onSummary(String str, String str2, String str3, String str4);
    }

    /* loaded from: classes.dex */
    public interface OnTerminalPlayStatusReturnListener {
        void onTerminalPlayStatusReturn(String str, String str2, String str3);
    }

    private SDKPushMsgMgr() {
        SDKCloudMsgMgr.getInstance().setMesMsgListener(this.mesListener);
        c a2 = c.a(SDKMgr.getApplicationContext());
        this.mSDKDatabaseProxy = a2;
        this.mDatabaseDao = new PushMsgDAO(a2.a());
    }

    public static SDKPushMsgMgr getInstance() {
        if (instance == null) {
            instance = new SDKPushMsgMgr();
        }
        return instance;
    }

    public void addMessage(MsgInfo msgInfo) {
        this.mDatabaseDao.addMessage(msgInfo);
    }

    public void deleteAllMsg() {
        this.mDatabaseDao.deleteAllMsg();
    }

    public void deleteMsgById(String str) {
        this.mDatabaseDao.deleteMsgById(str);
    }

    public void getTerminalPlayStatus(String str, HashMap<String, String> hashMap, final OnTerminalPlayStatusReturnListener onTerminalPlayStatusReturnListener) {
        JSONObject jSONObject = new JSONObject();
        if (hashMap != null) {
            try {
                jSONObject.put("usercode", hashMap.get("usercode"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(str + "/terminalplaystatusquery", "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.mes.SDKPushMsgMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                OnTerminalPlayStatusReturnListener onTerminalPlayStatusReturnListener2 = onTerminalPlayStatusReturnListener;
                if (onTerminalPlayStatusReturnListener2 != null) {
                    onTerminalPlayStatusReturnListener2.onTerminalPlayStatusReturn("0", "", str2);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w(SDKPushMsgMgr.LOG_TAG, "SDKNetHTTPRequest onFailReturn");
                OnTerminalPlayStatusReturnListener onTerminalPlayStatusReturnListener2 = onTerminalPlayStatusReturnListener;
                if (onTerminalPlayStatusReturnListener2 != null) {
                    onTerminalPlayStatusReturnListener2.onTerminalPlayStatusReturn(String.valueOf(i), str2, null);
                }
            }
        });
    }

    public int getUnReadMsgCount(String str) {
        return this.mDatabaseDao.getUnReadMsgCount(str);
    }

    public void initMesClient(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        if (!a.f) {
            LogEx.e(LOG_TAG, ErrMessage.LIC_INVALIDATE);
        } else {
            SDKCloudMsgMgr.getInstance().initMesClient(context, str, i, str2, str3, str4, str5);
        }
    }

    public ArrayList<MsgInfo> queryAllMsg(String str) {
        return this.mDatabaseDao.queryAllMsg(str);
    }

    public MsgInfo queryLastMessageByTime() {
        return this.mDatabaseDao.queryLastMessageByTime();
    }

    public void queryMsgInfo(String str, String str2) {
        SDKCloudMsgMgr.getInstance().queryMsgInfo(str, str2);
    }

    public void queryMsgInfoAfterTimestamp(String str) {
        SDKCloudMsgMgr.getInstance().queryMsgInfoAfterTimestamp(str);
    }

    public void reportPlayStatus(String str, String str2) {
        SDKCloudMsgMgr.getInstance().reportPlayStatus(str, str2);
    }

    public void setCallback(OnPushMsgListener onPushMsgListener) {
        this.pushListener = onPushMsgListener;
    }

    public void setIntentAction(String str) {
        SDKCloudMsgMgr.getInstance().setIntentAction(str);
    }

    public void setIntentClass(Class<?> cls) {
        SDKCloudMsgMgr.getInstance().setIntentClass(cls);
    }

    public void setIntentUri(Uri uri) {
        SDKCloudMsgMgr.getInstance().setIntentUri(uri);
    }

    public void uninitMesClient() {
        SDKCloudMsgMgr.getInstance().uninitMesClient();
    }

    public void updateMsgStatus(String str) {
        this.mDatabaseDao.updateMsgStatus(str);
    }
}
