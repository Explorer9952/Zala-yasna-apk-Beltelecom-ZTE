package com.zte.iptvclient.android.common.db.entity;

import android.content.ContentValues;
import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CustomMagazineMovie implements Serializable {
    private String mProgramCode = "";
    private String mProgramType = "";
    private String mProgramName = "";
    private String mImgURL = "";
    private String mAccount = "";
    private String mProgramRating = "";
    private String mColumncode = "";

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(CustomMagazineMovie.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(CustomMagazineMovie.class.getName(), "writeObject");
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getColumncode() {
        return this.mColumncode;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ProgramCode", this.mProgramCode);
        contentValues.put("ProgramType", this.mProgramType);
        contentValues.put("ProgramName", this.mProgramName);
        contentValues.put("ProgramRating", this.mProgramRating);
        contentValues.put("Account", this.mAccount);
        contentValues.put("ImgURL", this.mImgURL);
        return contentValues;
    }

    public String getImgURL() {
        return this.mImgURL;
    }

    public String getProgramCode() {
        return this.mProgramCode;
    }

    public String getProgramName() {
        return this.mProgramName;
    }

    public String getProgramRating() {
        return this.mProgramRating;
    }

    public String getProgramType() {
        return this.mProgramType;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public void setColumncode(String str) {
        this.mColumncode = str;
    }

    public void setImgURL(String str) {
        this.mImgURL = str;
    }

    public void setProgramCode(String str) {
        this.mProgramCode = str;
    }

    public void setProgramName(String str) {
        this.mProgramName = str;
    }

    public void setProgramRating(String str) {
        this.mProgramRating = str;
    }

    public void setProgramType(String str) {
        this.mProgramType = str;
    }
}
