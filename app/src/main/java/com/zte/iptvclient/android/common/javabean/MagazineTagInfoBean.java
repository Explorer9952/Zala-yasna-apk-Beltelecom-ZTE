package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MagazineTagInfoBean implements Serializable {
    private String sortNum;
    private String tagdesc;
    private String tagid;
    private String tagimg;
    private String tagname;
    private String tagtype;

    public static MagazineTagInfoBean parseJsonToBean(JSONObject jSONObject) {
        MagazineTagInfoBean magazineTagInfoBean = new MagazineTagInfoBean();
        try {
            magazineTagInfoBean.setTagid(jSONObject.optString("tagid"));
            magazineTagInfoBean.setTagname(jSONObject.optString("tagname"));
            magazineTagInfoBean.setTagtype(jSONObject.optString("tagtype"));
            magazineTagInfoBean.setTagdesc(jSONObject.optString("tagdesc"));
            magazineTagInfoBean.setTagimg(jSONObject.optString("tagimg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return magazineTagInfoBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(MagazineTagInfoBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(MagazineTagInfoBean.class.getName(), "writeObject");
    }

    public String getSortNum() {
        return this.sortNum;
    }

    public String getTagdesc() {
        return this.tagdesc;
    }

    public String getTagid() {
        return this.tagid;
    }

    public String getTagimg() {
        return this.tagimg;
    }

    public String getTagname() {
        return this.tagname;
    }

    public String getTagtype() {
        return this.tagtype;
    }

    public void setSortNum(String str) {
        this.sortNum = str;
    }

    public void setTagdesc(String str) {
        this.tagdesc = str;
    }

    public void setTagid(String str) {
        this.tagid = str;
    }

    public void setTagimg(String str) {
        this.tagimg = str;
    }

    public void setTagname(String str) {
        this.tagname = str;
    }

    public void setTagtype(String str) {
        this.tagtype = str;
    }
}
