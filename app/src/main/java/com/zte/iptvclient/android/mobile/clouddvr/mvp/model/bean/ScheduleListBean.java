package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ScheduleListBean {
    private List<ScheduleBean> data;
    private int returncode;
    private int totalcount;

    public List<ScheduleBean> getData() {
        List<ScheduleBean> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public int getReturncode() {
        return this.returncode;
    }

    public int getTotalcount() {
        return this.totalcount;
    }

    public void setData(List<ScheduleBean> list) {
        this.data = list;
    }

    public void setReturncode(int i) {
        this.returncode = i;
    }

    public void setTotalcount(int i) {
        this.totalcount = i;
    }
}
