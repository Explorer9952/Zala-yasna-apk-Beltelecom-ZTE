package com.video.androidsdk.mes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.MesMsg;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKCloudMsgMgr {
    private static final String LOG_TAG = "SDKCloudMsgMgr";
    private static final int MES_CLIENT_MESNOTIFY = 4;
    private static final int MES_CLIENT_PUSGMSG = 0;
    private static final int MES_CLIENT_QUERYMSGINFO = 1;
    private static final int MES_CLIENT_QUERYMSGINFOAFTERTIMESTAMP = 2;
    private static final int MES_CLIENT_QUERYMSGINFOBYTIMESTAMP_READY = 5;
    private static final int MES_CLIENT_UNREADMSGNUM = 3;
    private static final int REQUESTCODE_CLOUDMSG_NOTIFICATION = 300;
    private static SDKCloudMsgMgr instance;
    private BroadcastReceiver connReceiver;
    private WeakReference<Context> ctxRef;
    private String intentAction;
    private Class<?> intentCls;
    private Uri intentUri;
    IMesCloudMsg mesListener;
    private String ip_addr = null;
    private int port = 0;
    private String deviceid = null;
    private String userid = null;
    private String usertoken = null;
    private String terminalflag = null;

    /* loaded from: classes.dex */
    public interface IMesCloudMsg {
        void onMesNotify(MesMsg mesMsg);

        void onMsgInfo(Message message);

        void onMsgInfoAfterTimestamp(Message[] messageArr);

        void onSummary(Summary summary);

        void queryMsgInfoByTimestamp();
    }

    public static SDKCloudMsgMgr getInstance() {
        if (instance == null) {
            instance = new SDKCloudMsgMgr();
        }
        return instance;
    }

    private void notifyMesMsg(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("msghead");
            String string = jSONObject2.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            String string2 = jSONObject2.getString("msgtype");
            JSONObject jSONObject3 = jSONObject.getJSONObject("msgbody");
            String string3 = jSONObject3.getString("msgcode");
            String string4 = jSONObject3.getString("content");
            MesMsg mesMsg = new MesMsg();
            MesMsg.MsgHead msgHead = new MesMsg.MsgHead(string, string2);
            MesMsg.MsgBody msgBody = new MesMsg.MsgBody(string3, string4);
            mesMsg.setMsghead(msgHead);
            mesMsg.setMsgbody(msgBody);
            if (this.mesListener != null) {
                this.mesListener.onMesNotify(mesMsg);
            }
        } catch (JSONException e) {
            LogEx.d(LOG_TAG, "Parse error: " + str);
            e.printStackTrace();
        }
    }

    private void notifyMsgInfo(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(ParamConst.DLNA_NESSAGE);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("MsgID");
                String string2 = jSONObject.getString("MsgInfo");
                String string3 = jSONObject.getString("TimeStamp");
                if (this.mesListener != null) {
                    LogEx.d(LOG_TAG, "Notify msginfo: " + string3 + ", " + string + ", " + str);
                    this.mesListener.onMsgInfo(new Message(string3, string, string2));
                }
            }
        } catch (JSONException e) {
            LogEx.d(LOG_TAG, "Parse error: " + str);
            e.printStackTrace();
        }
    }

    private void notifyMsgInfoAfterTimestamp(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(ParamConst.DLNA_NESSAGE);
            int length = jSONArray.length();
            Message[] messageArr = new Message[length];
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("MsgID");
                String string2 = jSONObject.getString("MsgInfo");
                String string3 = jSONObject.getString("TimeStamp");
                messageArr[i] = new Message(string3, string, string2);
                LogEx.d(LOG_TAG, "History msginfo: " + string3 + ", " + string + ", " + str);
            }
            if (this.mesListener != null) {
                this.mesListener.onMsgInfoAfterTimestamp(messageArr);
            }
        } catch (JSONException e) {
            LogEx.d(LOG_TAG, "Parse error: " + str);
            e.printStackTrace();
        }
    }

    private void notifySummary(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("MsgID");
            String string2 = jSONObject.getString("MsgUrl");
            String string3 = jSONObject.getString("TimeStamp");
            String string4 = jSONObject.getString("Summary");
            if (this.mesListener != null) {
                this.mesListener.onSummary(new Summary(string3, string, string2, string4));
            }
        } catch (JSONException e) {
            LogEx.d(LOG_TAG, "Parse error: " + str);
            e.printStackTrace();
        }
    }

    private void queryMsgInfoByTimestamp() {
        IMesCloudMsg iMesCloudMsg = this.mesListener;
        if (iMesCloudMsg != null) {
            iMesCloudMsg.queryMsgInfoByTimestamp();
        }
    }

    protected void finalize() throws Throwable {
        MesMsgNativeSDK.UninitMESClient();
        super.finalize();
    }

    public void initMesClient(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        LogEx.d(LOG_TAG, "init mes_client");
        if (this.connReceiver == null) {
            this.connReceiver = new BroadcastReceiver() { // from class: com.video.androidsdk.mes.SDKCloudMsgMgr.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    String str6;
                    if (context2 != null) {
                        int checkNetworkInfo = new ClientNetworkInfo().checkNetworkInfo((ConnectivityManager) context2.getSystemService("connectivity"));
                        if (checkNetworkInfo != 0) {
                            if (checkNetworkInfo == 1) {
                                str6 = "2";
                            } else if (checkNetworkInfo != 2 && checkNetworkInfo != 3 && checkNetworkInfo != 4 && checkNetworkInfo != 5) {
                                str6 = "0";
                            }
                        }
                        str6 = "1";
                    } else {
                        str6 = null;
                    }
                    String str7 = str6;
                    if (str7 == null) {
                        return;
                    }
                    LogEx.d(SDKCloudMsgMgr.LOG_TAG, "restart mes_client");
                    int InitMESClient = MesMsgNativeSDK.InitMESClient(SDKCloudMsgMgr.instance.ip_addr, SDKCloudMsgMgr.instance.port, SDKCloudMsgMgr.instance.deviceid, SDKCloudMsgMgr.instance.userid, SDKCloudMsgMgr.instance.usertoken, SDKCloudMsgMgr.instance.terminalflag, str7);
                    LogEx.d(SDKCloudMsgMgr.LOG_TAG, "ret: " + InitMESClient);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(1000);
            if (context != null) {
                context.getApplicationContext().registerReceiver(this.connReceiver, intentFilter);
            }
        }
        this.ctxRef = new WeakReference<>(context);
        this.ip_addr = str;
        this.port = i;
        this.deviceid = str2;
        this.userid = str3;
        this.usertoken = str4;
        this.terminalflag = str5;
        String str6 = null;
        if (context != null) {
            int checkNetworkInfo = new ClientNetworkInfo().checkNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (checkNetworkInfo != 0) {
                if (checkNetworkInfo == 1) {
                    str6 = "2";
                } else if (checkNetworkInfo != 2 && checkNetworkInfo != 3 && checkNetworkInfo != 4 && checkNetworkInfo != 5) {
                    str6 = "0";
                }
            }
            str6 = "1";
        }
        int InitMESClient = MesMsgNativeSDK.InitMESClient(str, i, str2, str3, str4, str5, str6);
        LogEx.d(LOG_TAG, "ret: " + InitMESClient);
    }

    public void onMESNotify(int i, String str) {
        LogEx.d(LOG_TAG, "MES Notify:" + i + "  " + str);
        if (i == 0) {
            notifySummary(str);
            return;
        }
        if (i == 1) {
            notifyMsgInfo(str);
            return;
        }
        if (i == 2) {
            notifyMsgInfoAfterTimestamp(str);
        } else if (i == 4) {
            notifyMesMsg(str);
        } else {
            if (i != 5) {
                return;
            }
            queryMsgInfoByTimestamp();
        }
    }

    public void queryMsgInfo(String str, String str2) {
        LogEx.d(LOG_TAG, "query msginfo:" + str + " id:" + str2);
        MesMsgNativeSDK.QueryMsgInfo(str, str2);
    }

    public void queryMsgInfoAfterTimestamp(String str) {
        LogEx.d(LOG_TAG, "query msginfo after stamp:" + str);
        MesMsgNativeSDK.QueryMsgInfoAfterTimestamp(str);
        LogEx.d(LOG_TAG, "query msginfo after stamp11:" + str);
    }

    public void reportPlayStatus(String str, String str2) {
        LogEx.d(LOG_TAG, "reportPlayStatus:" + str);
        MesMsgNativeSDK.ReportPlaystatus(str, str2);
        LogEx.d(LOG_TAG, "reportPlayStatus11:" + str);
    }

    public void setIntentAction(String str) {
        this.intentAction = str;
    }

    public void setIntentClass(Class<?> cls) {
        this.intentCls = cls;
    }

    public void setIntentUri(Uri uri) {
        this.intentUri = uri;
    }

    public void setMesMsgListener(IMesCloudMsg iMesCloudMsg) {
        this.mesListener = iMesCloudMsg;
    }

    public void uninitMesClient() {
        MesMsgNativeSDK.UninitMESClient();
    }
}
