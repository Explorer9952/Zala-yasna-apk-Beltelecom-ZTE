package com.zte.iptvclient.android.mobile.dlna.bean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class BackplayPositionInfoBean implements Serializable {
    private String TrackURI;
    private String absCount;
    private String absTime;
    private String begintime;
    private String breakpoint;
    private String channelcode;
    private String endtime;
    private String errorMsg;
    private String mixno;
    private String programid;
    private String pushtype;
    private String relCount;
    private String relTime;
    private String returnCode;
    private String seq;
    private String telecomcode;
    private String track;
    private String trackDuration;
    private String trackMetaData;
    private String urlfromstb;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(BackplayPositionInfoBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(BackplayPositionInfoBean.class.getName(), "writeObject");
    }

    public String getAbsCount() {
        return this.absCount;
    }

    public String getAbsTime() {
        return this.absTime;
    }

    public String getBegintime() {
        return this.begintime;
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getChannelcode() {
        return this.channelcode;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getProgramid() {
        return this.programid;
    }

    public String getPushtype() {
        return this.pushtype;
    }

    public String getRelCount() {
        return this.relCount;
    }

    public String getRelTime() {
        return this.relTime;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public String getSeq() {
        return this.seq;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getTrack() {
        return this.track;
    }

    public String getTrackDuration() {
        return this.trackDuration;
    }

    public String getTrackMetaData() {
        return this.trackMetaData;
    }

    public String getTrackURI() {
        return this.TrackURI;
    }

    public String getUrlfromstb() {
        return this.urlfromstb;
    }

    public void setAbsCount(String str) {
        this.absCount = str;
    }

    public void setAbsTime(String str) {
        this.absTime = str;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setProgramid(String str) {
        this.programid = str;
    }

    public void setPushtype(String str) {
        this.pushtype = str;
    }

    public void setRelCount(String str) {
        this.relCount = str;
    }

    public void setRelTime(String str) {
        this.relTime = str;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    public void setSeq(String str) {
        this.seq = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setTrack(String str) {
        this.track = str;
    }

    public void setTrackDuration(String str) {
        this.trackDuration = str;
    }

    public void setTrackMetaData(String str) {
        this.trackMetaData = str;
    }

    public void setTrackURI(String str) {
        this.TrackURI = str;
    }

    public void setUrlfromstb(String str) {
        this.urlfromstb = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("returnCode=" + getReturnCode());
        sb.append("errormsg=" + getErrorMsg());
        sb.append("realTime=" + getRelTime());
        sb.append("TrackURI=" + getTrackURI());
        sb.append("track=" + getTrack());
        sb.append("trackDuration=" + getTrackDuration());
        sb.append("trackMetaData=" + getTrackMetaData());
        sb.append("seq=" + getSeq());
        sb.append("relCount=" + getRelCount());
        sb.append("absTime=" + getAbsTime());
        sb.append("absCount=" + getAbsCount());
        return sb.toString();
    }
}
