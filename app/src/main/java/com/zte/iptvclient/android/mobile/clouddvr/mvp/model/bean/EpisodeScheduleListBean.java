package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

import java.util.List;

/* loaded from: classes.dex */
public class EpisodeScheduleListBean {
    private List<ScheduleBean> data;
    private String returncode;
    private String totalcount;

    public List<ScheduleBean> getData() {
        return this.data;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getTotalcount() {
        return this.totalcount;
    }

    public void setData(List<ScheduleBean> list) {
        this.data = list;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
