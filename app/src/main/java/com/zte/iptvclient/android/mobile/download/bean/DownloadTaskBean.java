package com.zte.iptvclient.android.mobile.download.bean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class DownloadTaskBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String TVSeriesHeadId;
    private String breakpoint;
    private String columeCode;
    private String contentCode;
    private String contentType;
    private String coverPath;
    private String downloadUrl;
    private Date expiredDate;
    private String isDrm;
    private String isHandStop;
    private String programType;
    private String seriesCount;
    private int sizeAlreadyDownloaded;
    private Date taskAddDate;
    private String taskDefinition;
    private String taskID;
    private int taskStatus;
    private String tvSeriesHeadName;
    private String tvSeriesIndex;
    private String videoName;
    private int videoSize;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(DownloadTaskBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(DownloadTaskBean.class.getName(), "writeObject");
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getColumeCode() {
        return this.columeCode;
    }

    public String getContentCode() {
        return this.contentCode;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public Date getExpiredDate() {
        return this.expiredDate;
    }

    public String getIsDrm() {
        return this.isDrm;
    }

    public String getIsHandStop() {
        return this.isHandStop;
    }

    public String getProgramType() {
        return this.programType;
    }

    public String getSeriesCount() {
        return this.seriesCount;
    }

    public int getSizeAlreadyDownloaded() {
        return this.sizeAlreadyDownloaded;
    }

    public String getTVSeriesHeadId() {
        return this.TVSeriesHeadId;
    }

    public Date getTaskAddDate() {
        return this.taskAddDate;
    }

    public String getTaskDefinition() {
        return this.taskDefinition;
    }

    public String getTaskID() {
        return this.taskID;
    }

    public int getTaskStatus() {
        return this.taskStatus;
    }

    public String getTvSeriesHeadName() {
        return this.tvSeriesHeadName;
    }

    public String getTvSeriesIndex() {
        return this.tvSeriesIndex;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setColumeCode(String str) {
        this.columeCode = str;
    }

    public void setContentCode(String str) {
        this.contentCode = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCoverPath(String str) {
        this.coverPath = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setExpiredDate(Date date) {
        this.expiredDate = date;
    }

    public void setIsDrm(String str) {
        this.isDrm = str;
    }

    public void setIsHandStop(String str) {
        this.isHandStop = str;
    }

    public void setProgramType(String str) {
        this.programType = str;
    }

    public void setSeriesCount(String str) {
        this.seriesCount = str;
    }

    public void setSizeAlreadyDownloaded(int i) {
        this.sizeAlreadyDownloaded = i;
    }

    public void setTVSeriesHeadId(String str) {
        this.TVSeriesHeadId = str;
    }

    public void setTaskAddDate(Date date) {
        this.taskAddDate = date;
    }

    public void setTaskDefinition(String str) {
        this.taskDefinition = str;
    }

    public void setTaskID(String str) {
        this.taskID = str;
    }

    public void setTaskStatus(int i) {
        this.taskStatus = i;
    }

    public void setTvSeriesHeadName(String str) {
        this.tvSeriesHeadName = str;
    }

    public void setTvSeriesIndex(String str) {
        this.tvSeriesIndex = str;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public void setVideoSize(int i) {
        this.videoSize = i;
    }
}
