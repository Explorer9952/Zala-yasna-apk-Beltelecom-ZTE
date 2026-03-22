package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChannelTvodTsTimeBean implements Serializable {
    private String channelcode;
    private String mixno;
    private String shifttime;
    private String tvodtime;

    public static ChannelTvodTsTimeBean getPlayChannelBeanFromJSon(JSONObject jSONObject) {
        ChannelTvodTsTimeBean channelTvodTsTimeBean = new ChannelTvodTsTimeBean();
        try {
            channelTvodTsTimeBean.setMixno(jSONObject.optString("mixno"));
            channelTvodTsTimeBean.setShifttime(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_SHIFTTIME));
            channelTvodTsTimeBean.setTvodtime(jSONObject.optString("tvodtime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelTvodTsTimeBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(ChannelTvodTsTimeBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(ChannelTvodTsTimeBean.class.getName(), "writeObject");
    }

    public String getChannelcode() {
        return this.channelcode;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getShifttime() {
        return this.shifttime;
    }

    public String getTvodtime() {
        return this.tvodtime;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setShifttime(String str) {
        this.shifttime = str;
    }

    public void setTvodtime(String str) {
        this.tvodtime = str;
    }
}
