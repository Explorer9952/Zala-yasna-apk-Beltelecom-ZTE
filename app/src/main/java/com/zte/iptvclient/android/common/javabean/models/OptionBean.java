package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class OptionBean implements Serializable {
    private boolean isSelected;
    private String optionid;
    private String optionname;

    public static OptionBean getOptionBeanFromJSon(JSONObject jSONObject) {
        OptionBean optionBean = new OptionBean();
        try {
            optionBean.setOptionid(jSONObject.optString("optionid"));
            optionBean.setOptionname(jSONObject.optString("optionname"));
            optionBean.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return optionBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(OptionBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(OptionBean.class.getName(), "writeObject");
    }

    public String getOptionid() {
        return this.optionid;
    }

    public String getOptionname() {
        return this.optionname;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setOptionid(String str) {
        this.optionid = str;
    }

    public void setOptionname(String str) {
        this.optionname = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
