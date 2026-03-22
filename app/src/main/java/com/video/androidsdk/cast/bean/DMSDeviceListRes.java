package com.video.androidsdk.cast.bean;

/* loaded from: classes.dex */
public class DMSDeviceListRes {
    DeviceItem[] DeviceItem;
    String totalcount;

    public DeviceItem[] getDeviceItem() {
        return this.DeviceItem;
    }

    public String getTotalcount() {
        return this.totalcount;
    }

    public void setDeviceItem(DeviceItem[] deviceItemArr) {
        this.DeviceItem = deviceItemArr;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
