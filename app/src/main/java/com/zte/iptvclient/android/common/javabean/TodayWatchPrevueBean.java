package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class TodayWatchPrevueBean implements Serializable {
    private String channelCode;
    private String channelName;
    private String columnCode;
    private String columnName;
    private String cpCode;
    private String cpName;
    private String fileName;
    private String langType;
    private String mediaServices;
    private String prevueCode;
    private String prevueName;
    private String utcEndTime;
    private String utcStartTime;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(TodayWatchPrevueBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(TodayWatchPrevueBean.class.getName(), "writeObject");
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getColumnCode() {
        return this.columnCode;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getCpCode() {
        return this.cpCode;
    }

    public String getCpName() {
        return this.cpName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getLangType() {
        return this.langType;
    }

    public String getMediaServices() {
        return this.mediaServices;
    }

    public String getPrevueCode() {
        return this.prevueCode;
    }

    public String getPrevueName() {
        return this.prevueName;
    }

    public String getUtcEndTime() {
        return this.utcEndTime;
    }

    public String getUtcStartTime() {
        return this.utcStartTime;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setColumnCode(String str) {
        this.columnCode = str;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setCpCode(String str) {
        this.cpCode = str;
    }

    public void setCpName(String str) {
        this.cpName = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setLangType(String str) {
        this.langType = str;
    }

    public void setMediaServices(String str) {
        this.mediaServices = str;
    }

    public void setPrevueCode(String str) {
        this.prevueCode = str;
    }

    public void setPrevueName(String str) {
        this.prevueName = str;
    }

    public void setUtcEndTime(String str) {
        this.utcEndTime = str;
    }

    public void setUtcStartTime(String str) {
        this.utcStartTime = str;
    }
}
