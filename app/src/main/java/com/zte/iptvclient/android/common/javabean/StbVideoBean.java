package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class StbVideoBean implements Serializable {
    private String columncode;
    private String contentcode;
    private String contentname;
    private String favoritetype;
    private String isprotection;
    private String posterfileList;
    private String posterurl;
    private String programcode;
    private String programname;
    private String telecomcode;
    private String updatetime;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(StbVideoBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(StbVideoBean.class.getName(), "writeObject");
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getContentname() {
        return this.contentname;
    }

    public String getFavoritetype() {
        return this.favoritetype;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getPosterfileList() {
        return this.posterfileList;
    }

    public String getPosterurl() {
        return this.posterurl;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getProgramname() {
        return this.programname;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getUpdatetime() {
        return this.updatetime;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setContentname(String str) {
        this.contentname = str;
    }

    public void setFavoritetype(String str) {
        this.favoritetype = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setPosterfileList(String str) {
        this.posterfileList = str;
    }

    public void setPosterurl(String str) {
        this.posterurl = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setProgramname(String str) {
        this.programname = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setUpdatetime(String str) {
        this.updatetime = str;
    }
}
