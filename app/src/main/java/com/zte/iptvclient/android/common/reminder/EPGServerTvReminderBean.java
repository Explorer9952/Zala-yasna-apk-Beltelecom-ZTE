package com.zte.iptvclient.android.common.reminder;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class EPGServerTvReminderBean implements Serializable {
    private String channelcode;
    private String channelname;
    private String columncode;
    private String definition;
    private String end_time;
    private String file_status;
    private String isprotection;
    private String mixno;
    private String posterimage;
    private String prevuecode;
    private String prevuename;
    private String start_time;
    private String telecomcode;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(EPGServerTvReminderBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(EPGServerTvReminderBean.class.getName(), "writeObject");
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

    public String getEnd_time() {
        return this.end_time;
    }

    public String getFile_status() {
        return this.file_status;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getPosterimage() {
        return this.posterimage;
    }

    public String getPrevuecode() {
        return this.prevuecode;
    }

    public String getPrevuename() {
        return this.prevuename;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public String getTelecomcode() {
        return this.telecomcode;
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

    public void setEnd_time(String str) {
        this.end_time = str;
    }

    public void setFile_status(String str) {
        this.file_status = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setPosterimage(String str) {
        this.posterimage = str;
    }

    public void setPrevuecode(String str) {
        this.prevuecode = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setStart_time(String str) {
        this.start_time = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }
}
