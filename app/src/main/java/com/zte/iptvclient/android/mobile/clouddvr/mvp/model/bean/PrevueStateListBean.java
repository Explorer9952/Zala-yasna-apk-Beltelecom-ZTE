package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PrevueStateListBean {
    private List<PrevueStateBean> data;
    private String returncode;
    private String totalcount;

    /* loaded from: classes.dex */
    public static class PrevueStateBean {
        private String prevueid;
        private String recordstate;
        private String recstarttime;
        private String scheduleid;
        private String seriesid;
        private String seriesrec;

        public String getPrevueid() {
            return this.prevueid;
        }

        public String getRecordstate() {
            return this.recordstate;
        }

        public String getRecstarttime() {
            return this.recstarttime;
        }

        public String getScheduleid() {
            return this.scheduleid;
        }

        public String getSeriesid() {
            return this.seriesid;
        }

        public String getSeriesrec() {
            return this.seriesrec;
        }

        public void setPrevueid(String str) {
            this.prevueid = str;
        }

        public void setRecordstate(String str) {
            this.recordstate = str;
        }

        public void setRecstarttime(String str) {
            this.recstarttime = str;
        }

        public void setScheduleid(String str) {
            this.scheduleid = str;
        }

        public void setSeriesid(String str) {
            this.seriesid = str;
        }

        public void setSeriesrec(String str) {
            this.seriesrec = str;
        }
    }

    public List<PrevueStateBean> getData() {
        List<PrevueStateBean> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public String getReturncode() {
        String str = this.returncode;
        return str == null ? "" : str;
    }

    public String getTotalcount() {
        String str = this.totalcount;
        return str == null ? "" : str;
    }

    public void setData(List<PrevueStateBean> list) {
        this.data = list;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
