package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class TvShowItem extends k implements Serializable {
    String acara;
    String channelmediacode;
    String contentmediacode;
    String duration;
    String endTime;
    String expireDate;
    String expireTime;
    String fileName;
    String fileStatus;
    String id;
    String jam;
    String needLogin;
    String prevueId;
    String programid;
    String ratingid;
    String seriesheadid;
    String startDate;
    String startTime;
    String tanggal;
    String tvodStream;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(TvShowItem.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(TvShowItem.class.getName(), "writeObject");
    }

    public String getAcara() {
        return this.acara;
    }

    public String getChannelmediacode() {
        return this.channelmediacode;
    }

    public String getContentmediacode() {
        return this.contentmediacode;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileStatus() {
        return this.fileStatus;
    }

    public String getId() {
        return this.id;
    }

    public String getJam() {
        return this.jam;
    }

    public String getNeedLogin() {
        return this.needLogin;
    }

    public String getPrevueId() {
        return this.prevueId;
    }

    public String getProgramid() {
        return this.programid;
    }

    public String getRatingid() {
        return this.ratingid;
    }

    public String getSeriesheadid() {
        return this.seriesheadid;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public String getTvodStream() {
        return this.tvodStream;
    }

    public void setAcara(String str) {
        this.acara = str;
    }

    public void setChannelmediacode(String str) {
        this.channelmediacode = str;
    }

    public void setContentmediacode(String str) {
        this.contentmediacode = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileStatus(String str) {
        this.fileStatus = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setJam(String str) {
        this.jam = str;
    }

    public void setNeedLogin(String str) {
        this.needLogin = str;
    }

    public void setPrevueId(String str) {
        this.prevueId = str;
    }

    public void setProgramid(String str) {
        this.programid = str;
    }

    public void setRatingid(String str) {
        this.ratingid = str;
    }

    public void setSeriesheadid(String str) {
        this.seriesheadid = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTanggal(String str) {
        this.tanggal = str;
    }

    public void setTvodStream(String str) {
        this.tvodStream = str;
    }
}
