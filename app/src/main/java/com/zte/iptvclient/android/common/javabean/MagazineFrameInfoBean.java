package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MagazineFrameInfoBean implements Serializable {
    private String createtime;
    private String fileimage;
    private String filepath;
    private String framecode;
    private String framename;
    private String isrecommend;
    private String tagsname;

    public static MagazineFrameInfoBean parseJsonToBean(JSONObject jSONObject) {
        MagazineFrameInfoBean magazineFrameInfoBean = new MagazineFrameInfoBean();
        try {
            magazineFrameInfoBean.setFramecode(jSONObject.optString(ParamConst.FIRST_PAGE_REQ_FRAMECODE));
            magazineFrameInfoBean.setFramename(jSONObject.optString("framename"));
            magazineFrameInfoBean.setFilepath(jSONObject.optString("filepath"));
            magazineFrameInfoBean.setFileimage(jSONObject.optString("fileimage"));
            magazineFrameInfoBean.setIsrecommend(jSONObject.optString("isrecommend"));
            magazineFrameInfoBean.setCreatetime(jSONObject.optString("createtime"));
            magazineFrameInfoBean.setTagsname(jSONObject.optString("tagsname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return magazineFrameInfoBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(MagazineFrameInfoBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(MagazineFrameInfoBean.class.getName(), "writeObject");
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getFileimage() {
        return this.fileimage;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public String getFramecode() {
        return this.framecode;
    }

    public String getFramename() {
        return this.framename;
    }

    public String getIsrecommend() {
        return this.isrecommend;
    }

    public String getTagsname() {
        return this.tagsname;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public void setFileimage(String str) {
        this.fileimage = str;
    }

    public void setFilepath(String str) {
        this.filepath = str;
    }

    public void setFramecode(String str) {
        this.framecode = str;
    }

    public void setFramename(String str) {
        this.framename = str;
    }

    public void setIsrecommend(String str) {
        this.isrecommend = str;
    }

    public void setTagsname(String str) {
        this.tagsname = str;
    }
}
