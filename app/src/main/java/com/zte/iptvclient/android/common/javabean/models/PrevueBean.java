package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PrevueBean implements Serializable {
    private String begintime;
    private String channelTelcomcode;
    private String channelcode;
    private String channelname;
    private String columncode;
    private String definition;
    private String description;
    private String duration;
    private String endtime;
    private boolean isShowPlayBotton;
    private String isprotection;
    private String mixno;
    private String posterfilelist;
    private String posterimage;
    private String posterpath;
    private long prevuebreakpoint;
    private String prevuecode;
    private String prevueid;
    private String prevuename;
    private String privaterecordenable;
    private String programid;
    private String ratingid;
    private String scheduleid;
    private String seriesheadid;
    private String status;
    private String systemrecordenable;
    private String telecomcode;
    private String utcbegintime;
    private String utcendtime;
    private String recordstate = "0";
    private boolean isRecording = false;
    private String tstv = "1";
    private String tvod = "1";

    public static PrevueBean getPrevueBeanFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PrevueBean prevueBean = new PrevueBean();
        try {
            prevueBean.setChannelcode(jSONObject.optString("channelcode"));
            prevueBean.setChannelname(jSONObject.optString("channelname"));
            prevueBean.setTelecomcode(jSONObject.optString("telecomcode"));
            prevueBean.setPrevuecode(jSONObject.optString("prevuecode"));
            prevueBean.setPrevuename(jSONObject.optString("prevuename"));
            prevueBean.setIsprotection(jSONObject.optString("isprotection"));
            prevueBean.setColumncode(jSONObject.optString("columncode"));
            prevueBean.setMixno(jSONObject.optString("mixno"));
            prevueBean.setPosterimage(jSONObject.optString("posterimage"));
            prevueBean.setDefinition(jSONObject.optString("definition"));
            prevueBean.setBegintime(jSONObject.optString("begintime"));
            prevueBean.setEndtime(jSONObject.optString("endtime"));
            prevueBean.setUtcbegintime(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_UTCBEGINTIME));
            prevueBean.setUtcendtime(jSONObject.optString("utcendtime"));
            prevueBean.setStatus(jSONObject.optString("status"));
            prevueBean.setPrevueid(jSONObject.optString("prevueid"));
            prevueBean.setRatingid(jSONObject.optString("ratingid"));
            prevueBean.setDescription(jSONObject.optString("description"));
            prevueBean.setSeriesheadid(jSONObject.optString("seriesheadid"));
            prevueBean.setProgramid(jSONObject.optString("programid"));
            prevueBean.setSystemrecordenable(jSONObject.optString("systemrecordenable"));
            prevueBean.setPrivaterecordenable(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_PRIVATERECORDENABLE));
            prevueBean.setPosterfilelist(jSONObject.optString("posterfilelist"));
            prevueBean.setPosterpath(jSONObject.optString("posterpath"));
            prevueBean.setDuration(jSONObject.optString(ParamConst.NPVR_QUERY_RSP_DURATION));
            prevueBean.setTstv(jSONObject.optString("istimeshift", "1"));
            prevueBean.setTvod(jSONObject.optString("systemrecordenable", "1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prevueBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(PrevueBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(PrevueBean.class.getName(), "writeObject");
    }

    public String getBegintime() {
        if (!TextUtils.isEmpty(this.begintime)) {
            return this.begintime;
        }
        return this.utcbegintime;
    }

    public String getChannelTelcomcode() {
        return this.channelTelcomcode;
    }

    public String getChannelcode() {
        return this.channelcode;
    }

    public String getChannelname() {
        return this.channelname;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getEndtime() {
        if (!TextUtils.isEmpty(this.endtime)) {
            return this.endtime;
        }
        return this.utcendtime;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getPosterfilelist() {
        return this.posterfilelist;
    }

    public String getPosterimage() {
        return this.posterimage;
    }

    public String getPosterpath() {
        return this.posterpath;
    }

    public long getPrevuebreakpoint() {
        return this.prevuebreakpoint;
    }

    public String getPrevuecode() {
        return this.prevuecode;
    }

    public String getPrevueid() {
        return this.prevueid;
    }

    public String getPrevuename() {
        return this.prevuename;
    }

    public String getPrivaterecordenable() {
        return this.privaterecordenable;
    }

    public String getProgramid() {
        return this.programid;
    }

    public String getRatingid() {
        return this.ratingid;
    }

    public String getRecordstate() {
        String str = this.recordstate;
        return str == null ? "" : str;
    }

    public String getScheduleid() {
        String str = this.scheduleid;
        return str == null ? "" : str;
    }

    public String getSeriesheadid() {
        return this.seriesheadid;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSystemrecordenable() {
        return this.systemrecordenable;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getTstv() {
        return this.tstv;
    }

    public String getTvod() {
        return this.tvod;
    }

    public String getUtcbegintime() {
        return this.utcbegintime;
    }

    public String getUtcendtime() {
        return this.utcendtime;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public boolean isShowPlayBotton() {
        return this.isShowPlayBotton;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setChannelTelcomcode(String str) {
        this.channelTelcomcode = str;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setChannelname(String str) {
        this.channelname = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setPosterfilelist(String str) {
        this.posterfilelist = str;
    }

    public void setPosterimage(String str) {
        this.posterimage = str;
    }

    public void setPosterpath(String str) {
        this.posterpath = str;
    }

    public void setPrevuebreakpoint(long j) {
        this.prevuebreakpoint = j;
    }

    public void setPrevuecode(String str) {
        this.prevuecode = str;
    }

    public void setPrevueid(String str) {
        this.prevueid = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setPrivaterecordenable(String str) {
        this.privaterecordenable = str;
    }

    public void setProgramid(String str) {
        this.programid = str;
    }

    public void setRatingid(String str) {
        this.ratingid = str;
    }

    public void setRecording(boolean z) {
        this.isRecording = z;
    }

    public void setRecordstate(String str) {
        this.recordstate = str;
    }

    public void setScheduleid(String str) {
        this.scheduleid = str;
    }

    public void setSeriesheadid(String str) {
        this.seriesheadid = str;
    }

    public void setShowPlayBotton(boolean z) {
        this.isShowPlayBotton = z;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSystemrecordenable(String str) {
        this.systemrecordenable = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setTstv(String str) {
        this.tstv = str;
    }

    public void setTvod(String str) {
        this.tvod = str;
    }

    public void setUtcbegintime(String str) {
        this.utcbegintime = str;
    }

    public void setUtcendtime(String str) {
        this.utcendtime = str;
    }
}
