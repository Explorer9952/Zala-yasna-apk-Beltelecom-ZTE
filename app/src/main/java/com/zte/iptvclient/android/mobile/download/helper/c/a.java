package com.zte.iptvclient.android.mobile.download.helper.c;

import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.download.bean.DownloadTaskBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadJsonTool.java */
/* loaded from: classes.dex */
public class a {
    private static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US).parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static DownloadTaskBean b(String str) {
        JSONObject jSONObject = null;
        if ("null".equals(str)) {
            return null;
        }
        DownloadTaskBean downloadTaskBean = new DownloadTaskBean();
        LogEx.d("DownloadModule", "Begin to transfer JsonStr To DownloadTask Bean, JsonStr:" + str);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            downloadTaskBean.setTaskID(jSONObject2.getString("taskID"));
            downloadTaskBean.setCoverPath(jSONObject2.getString("coverPath"));
            downloadTaskBean.setDownloadUrl(jSONObject2.getString("downloadURL"));
            downloadTaskBean.setExpiredDate(a(jSONObject2.getString("expiredDate")));
            downloadTaskBean.setSizeAlreadyDownloaded(jSONObject2.getInt("sizeAlreadyDownloaded"));
            downloadTaskBean.setTaskAddDate(a(jSONObject2.getString("taskAddDate")));
            downloadTaskBean.setTaskDefinition(jSONObject2.getString("taskDefinition"));
            downloadTaskBean.setTaskStatus(jSONObject2.getInt("taskStatus"));
            downloadTaskBean.setVideoName(jSONObject2.getString("videoName"));
            downloadTaskBean.setVideoSize(jSONObject2.getInt("videoSize"));
            downloadTaskBean.setIsDrm(jSONObject2.getString("isDrm"));
            downloadTaskBean.setTvSeriesHeadName(jSONObject2.getString("tvSeriesHeadName"));
            downloadTaskBean.setTvSeriesIndex(jSONObject2.getString("tvSeriesIndex"));
            downloadTaskBean.setProgramType(jSONObject2.getString("programType"));
            downloadTaskBean.setIsHandStop(jSONObject2.optString("isHandStop", "false"));
            jSONObject = jSONObject2;
        } catch (JSONException e) {
            LogEx.d("DownloadModule", "jsonStr to DownloadTaskBean Error!");
            e.printStackTrace();
            downloadTaskBean = null;
        }
        if (jSONObject == null) {
            return downloadTaskBean;
        }
        try {
            downloadTaskBean.setColumeCode(jSONObject.getString("columnCode"));
        } catch (Exception unused) {
            downloadTaskBean.setColumeCode("");
        }
        try {
            downloadTaskBean.setContentCode(jSONObject.getString("contentCode"));
        } catch (Exception unused2) {
            downloadTaskBean.setContentCode("");
        }
        try {
            downloadTaskBean.setContentCode(jSONObject.getString("tvSeriesHeadName"));
        } catch (Exception unused3) {
            downloadTaskBean.setContentCode("");
        }
        try {
            downloadTaskBean.setBreakpoint(jSONObject.getString("breakpoint"));
        } catch (Exception unused4) {
            downloadTaskBean.setBreakpoint("");
        }
        LogEx.d("DownloadModule", "Finish to transfer JsonStr To DownloadTaskBean");
        return downloadTaskBean;
    }
}
