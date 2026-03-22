package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RecordFileListBean {
    public static final String START_DATE_FORMAT = "yyyyMMdd";
    public static final String START_TIME_FORMAT = "yyyyMMddHHmmss";
    private List<DataBean> data;
    private String returncode;
    private String totalcount;

    /* loaded from: classes.dex */
    public static class DataBean {
        private String channelcode;
        private String channelname;
        private String channelno;
        private String endtime;
        private String endtimeutc;
        private String episodeno;
        private String historyreason;
        private String iconurl;
        private String lastactdate;
        private String limitlevel;
        private String mediaservice;
        private String prevuecode;
        private String profilecode;
        private String recmode;
        private String rectimeafter;
        private String scheduleid;
        private String schedulename;
        private String seriesid;
        private String seriesname;
        private String seriesrec;
        private String startdate;
        private String starttime;
        private String starttimeutc;
        private String status;

        public String getChannelcode() {
            return this.channelcode;
        }

        public String getChannelname() {
            return this.channelname;
        }

        public String getChannelno() {
            return this.channelno;
        }

        public String getEndtime() {
            String str = this.endtime;
            return str == null ? "" : str;
        }

        public String getEndtimeutc() {
            String str = this.endtimeutc;
            return str == null ? "" : str;
        }

        public String getEpisodeno() {
            return this.episodeno;
        }

        public String getHistoryreason() {
            return this.historyreason;
        }

        public String getIconurl() {
            String str = this.iconurl;
            return str == null ? "" : str;
        }

        public String getLastactdate() {
            return this.lastactdate;
        }

        public String getLimitlevel() {
            return this.limitlevel;
        }

        public String getMediaservice() {
            String str = this.mediaservice;
            return str == null ? "" : str;
        }

        public String getPrevuecode() {
            String str = this.prevuecode;
            return str == null ? "" : str;
        }

        public String getProfilecode() {
            String str = this.profilecode;
            return str == null ? "" : str;
        }

        public String getRecmode() {
            return this.recmode;
        }

        public String getRectimeafter() {
            String str = this.rectimeafter;
            return str == null ? "" : str;
        }

        public String getScheduleid() {
            return this.scheduleid;
        }

        public String getSchedulename() {
            return this.schedulename;
        }

        public String getSeriesid() {
            return this.seriesid;
        }

        public String getSeriesname() {
            return this.seriesname;
        }

        public String getSeriesrec() {
            return this.seriesrec;
        }

        public String getStartdate() {
            return this.startdate;
        }

        public String getStarttime() {
            String str = this.starttime;
            return str == null ? "" : str;
        }

        public String getStarttimeutc() {
            String str = this.starttimeutc;
            return str == null ? "" : str;
        }

        public String getStatus() {
            return this.status;
        }

        public void setChannelcode(String str) {
            this.channelcode = str;
        }

        public void setChannelname(String str) {
            this.channelname = str;
        }

        public void setChannelno(String str) {
            this.channelno = str;
        }

        public void setEndtime(String str) {
            this.endtime = str;
        }

        public void setEndtimeutc(String str) {
            this.endtimeutc = str;
        }

        public void setEpisodeno(String str) {
            this.episodeno = str;
        }

        public void setHistoryreason(String str) {
            this.historyreason = str;
        }

        public void setIconurl(String str) {
            this.iconurl = str;
        }

        public void setLastactdate(String str) {
            this.lastactdate = str;
        }

        public void setLimitlevel(String str) {
            this.limitlevel = str;
        }

        public void setMediaservice(String str) {
            this.mediaservice = str;
        }

        public void setPrevuecode(String str) {
            this.prevuecode = str;
        }

        public void setProfilecode(String str) {
            this.profilecode = str;
        }

        public void setRecmode(String str) {
            this.recmode = str;
        }

        public void setRectimeafter(String str) {
            this.rectimeafter = str;
        }

        public void setScheduleid(String str) {
            this.scheduleid = str;
        }

        public void setSchedulename(String str) {
            this.schedulename = str;
        }

        public void setSeriesid(String str) {
            this.seriesid = str;
        }

        public void setSeriesname(String str) {
            this.seriesname = str;
        }

        public void setSeriesrec(String str) {
            this.seriesrec = str;
        }

        public void setStartdate(String str) {
            this.startdate = str;
        }

        public void setStarttime(String str) {
            this.starttime = str;
        }

        public void setStarttimeutc(String str) {
            this.starttimeutc = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    public List<DataBean> getData() {
        List<DataBean> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getTotalcount() {
        return this.totalcount;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
