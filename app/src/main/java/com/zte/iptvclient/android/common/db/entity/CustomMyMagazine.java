package com.zte.iptvclient.android.common.db.entity;

import android.content.ContentValues;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CustomMyMagazine implements Serializable {
    private String mAccount;
    private String mColumncode;
    private String mContentAbstract;
    private String mCreatetime;
    private String mFramecode;
    private String mFramepath;
    private String mImgUrls;
    private String mIsmultiscreen;
    private String mIspublic;
    private String mMagazineCreatedTime;
    private String mMagazineName;
    private String mMagzcontent;
    private String mMagzdesc;
    private String mMagzid;
    private String mMagzname;
    private String mMagztags;
    private String mPosterfilelist;
    private String mProgramCodes;
    private String mProgramNames;
    private String mProgramRatings;
    private String mProgramTypes;
    private String mReserve1;
    private String mReserve2;
    private String mReserve3;
    private String mTemplateName;
    private String mTerminalflag;
    private String mUpdatetime;
    private String mUsercode;

    public static CustomMyMagazine jsonToBean(JSONObject jSONObject) {
        CustomMyMagazine customMyMagazine;
        CustomMyMagazine customMyMagazine2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            customMyMagazine = new CustomMyMagazine();
        } catch (Exception e) {
            e = e;
        }
        try {
            customMyMagazine.setMagzid(jSONObject.optString("magzid"));
            customMyMagazine.setFramecode(jSONObject.optString(ParamConst.FIRST_PAGE_REQ_FRAMECODE));
            customMyMagazine.setMagzname(jSONObject.optString("magzname"));
            customMyMagazine.setMagzdesc(jSONObject.optString("magzdesc"));
            customMyMagazine.setIsmultiscreen(jSONObject.optString("ismultiscreen"));
            customMyMagazine.setIspublic(jSONObject.optString("ispublic"));
            customMyMagazine.setMagztags(jSONObject.optString("magztags"));
            customMyMagazine.setPosterfilelist(jSONObject.optString("posterfilelist"));
            customMyMagazine.setUsercode(jSONObject.optString("usercode"));
            customMyMagazine.setTerminalflag(jSONObject.optString("terminalflag"));
            customMyMagazine.setCreatetime(jSONObject.optString("createtime"));
            customMyMagazine.setUpdatetime(jSONObject.optString("updatetime"));
            customMyMagazine.setReserve1(jSONObject.optString(ParamConst.AUTH_RSP_RESERVE1));
            customMyMagazine.setReserve2(jSONObject.optString("reserve2"));
            customMyMagazine.setReserve3(jSONObject.optString("reserve3"));
            customMyMagazine.setFramepath(jSONObject.optString(ParamConst.FIRST_PAGE_RSP_FRAMEPATH));
            return customMyMagazine;
        } catch (Exception e2) {
            e = e2;
            customMyMagazine2 = customMyMagazine;
            e.printStackTrace();
            return customMyMagazine2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(CustomMyMagazine.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(CustomMyMagazine.class.getName(), "writeObject");
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getColumncode() {
        return this.mColumncode;
    }

    public String getContentAbstract() {
        return this.mContentAbstract;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("MagazineCreatedTime", this.mMagazineCreatedTime);
        contentValues.put("MagazineName", this.mMagazineName);
        contentValues.put("ProgramCodes", this.mProgramCodes);
        contentValues.put("ProgramTypes", this.mProgramTypes);
        contentValues.put("ProgramNames", this.mProgramNames);
        contentValues.put("ProgramRatings", this.mProgramRatings);
        contentValues.put("ImgURLs", this.mImgUrls);
        contentValues.put("TemplateName", this.mTemplateName);
        contentValues.put("ContentAbstract", this.mContentAbstract);
        contentValues.put("Account", this.mAccount);
        return contentValues;
    }

    public String getCreatetime() {
        return this.mCreatetime;
    }

    public String getFramecode() {
        return this.mFramecode;
    }

    public String getFramepath() {
        return this.mFramepath;
    }

    public String getImgUrls() {
        return this.mImgUrls;
    }

    public String getIsmultiscreen() {
        return this.mIsmultiscreen;
    }

    public String getIspublic() {
        return this.mIspublic;
    }

    public String getMagazineCreatedTime() {
        return this.mMagazineCreatedTime;
    }

    public String getMagazineName() {
        return this.mMagazineName;
    }

    public String getMagzcontent() {
        return this.mMagzcontent;
    }

    public String getMagzdesc() {
        return this.mMagzdesc;
    }

    public String getMagzid() {
        return this.mMagzid;
    }

    public String getMagzname() {
        return this.mMagzname;
    }

    public String getMagztags() {
        return this.mMagztags;
    }

    public String getPosterfilelist() {
        return this.mPosterfilelist;
    }

    public String getProgramCodes() {
        return this.mProgramCodes;
    }

    public String getProgramNames() {
        return this.mProgramNames;
    }

    public String getProgramRatings() {
        return this.mProgramRatings;
    }

    public String getProgramTypes() {
        return this.mProgramTypes;
    }

    public String getReserve1() {
        return this.mReserve1;
    }

    public String getReserve2() {
        return this.mReserve2;
    }

    public String getReserve3() {
        return this.mReserve3;
    }

    public String getTemplateName() {
        return this.mTemplateName;
    }

    public String getTerminalflag() {
        return this.mTerminalflag;
    }

    public String getUpdatetime() {
        return this.mUpdatetime;
    }

    public String getUsercode() {
        return this.mUsercode;
    }

    public void setAccount(String str) {
        this.mAccount = str;
    }

    public void setColumncode(String str) {
        this.mColumncode = str;
    }

    public void setContentAbstract(String str) {
        this.mContentAbstract = str;
    }

    public void setCreatetime(String str) {
        this.mCreatetime = str;
    }

    public void setFramecode(String str) {
        this.mFramecode = str;
    }

    public void setFramepath(String str) {
        this.mFramepath = str;
    }

    public void setImgUrls(String str) {
        this.mImgUrls = str;
    }

    public void setIsmultiscreen(String str) {
        this.mIsmultiscreen = str;
    }

    public void setIspublic(String str) {
        this.mIspublic = str;
    }

    public void setMagazineCreatedTime(String str) {
        this.mMagazineCreatedTime = str;
    }

    public void setMagazineName(String str) {
        this.mMagazineName = str;
    }

    public void setMagzcontent(String str) {
        this.mMagzcontent = str;
    }

    public void setMagzdesc(String str) {
        this.mMagzdesc = str;
    }

    public void setMagzid(String str) {
        this.mMagzid = str;
    }

    public void setMagzname(String str) {
        this.mMagzname = str;
    }

    public void setMagztags(String str) {
        this.mMagztags = str;
    }

    public void setPosterfilelist(String str) {
        this.mPosterfilelist = str;
    }

    public void setProgramCodes(String str) {
        this.mProgramCodes = str;
    }

    public void setProgramNames(String str) {
        this.mProgramNames = str;
    }

    public void setProgramRatings(String str) {
        this.mProgramRatings = str;
    }

    public void setProgramTypes(String str) {
        this.mProgramTypes = str;
    }

    public void setReserve1(String str) {
        this.mReserve1 = str;
    }

    public void setReserve2(String str) {
        this.mReserve2 = str;
    }

    public void setReserve3(String str) {
        this.mReserve3 = str;
    }

    public void setTemplateName(String str) {
        this.mTemplateName = str;
    }

    public void setTerminalflag(String str) {
        this.mTerminalflag = str;
    }

    public void setUpdatetime(String str) {
        this.mUpdatetime = str;
    }

    public void setUsercode(String str) {
        this.mUsercode = str;
    }
}
