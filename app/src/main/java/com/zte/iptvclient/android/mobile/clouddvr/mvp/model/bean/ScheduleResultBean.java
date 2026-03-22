package com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ScheduleResultBean {
    private List<DataBean> data;
    private String errormsg;
    private String mac;
    private String prevueid;
    private String recordstarttime;
    private int returncode;
    private int scheduleid;
    private int taskid;

    /* loaded from: classes.dex */
    public static class DataBean {
        private NewrecordBean newrecord;
        private List<OldrecordBean> oldrecord;

        /* loaded from: classes.dex */
        public static class NewrecordBean {
            private String hdflag;
            private String level;
            private String mixid;
            private String priority;
            private String programname;
            private String recendtime;
            private String recendtimeutc;
            private String recstarttime;
            private String recstarttimeutc;
            private String scheduleid;
            private String seriesrec;

            public String getHdflag() {
                return this.hdflag;
            }

            public String getLevel() {
                return this.level;
            }

            public String getMixid() {
                return this.mixid;
            }

            public String getPriority() {
                return this.priority;
            }

            public String getProgramname() {
                return this.programname;
            }

            public String getRecendtime() {
                return this.recendtime;
            }

            public String getRecendtimeutc() {
                return this.recendtimeutc;
            }

            public String getRecstarttime() {
                return this.recstarttime;
            }

            public String getRecstarttimeutc() {
                return this.recstarttimeutc;
            }

            public String getScheduleid() {
                return this.scheduleid;
            }

            public String getSeriesrec() {
                return this.seriesrec;
            }

            public void setHdflag(String str) {
                this.hdflag = str;
            }

            public void setLevel(String str) {
                this.level = str;
            }

            public void setMixid(String str) {
                this.mixid = str;
            }

            public void setPriority(String str) {
                this.priority = str;
            }

            public void setProgramname(String str) {
                this.programname = str;
            }

            public void setRecendtime(String str) {
                this.recendtime = str;
            }

            public void setRecendtimeutc(String str) {
                this.recendtimeutc = str;
            }

            public void setRecstarttime(String str) {
                this.recstarttime = str;
            }

            public void setRecstarttimeutc(String str) {
                this.recstarttimeutc = str;
            }

            public void setScheduleid(String str) {
                this.scheduleid = str;
            }

            public void setSeriesrec(String str) {
                this.seriesrec = str;
            }
        }

        /* loaded from: classes.dex */
        public static class OldrecordBean {
            private String hdflag;
            private String level;
            private String mixid;
            private String priority;
            private String programname;
            private String recendtime;
            private String recendtimeutc;
            private String recstarttime;
            private String recstarttimeutc;
            private String scheduleid;
            private String seriesrec;

            public String getHdflag() {
                return this.hdflag;
            }

            public String getLevel() {
                return this.level;
            }

            public String getMixid() {
                return this.mixid;
            }

            public String getPriority() {
                return this.priority;
            }

            public String getProgramname() {
                return this.programname;
            }

            public String getRecendtime() {
                return this.recendtime;
            }

            public String getRecendtimeutc() {
                return this.recendtimeutc;
            }

            public String getRecstarttime() {
                return this.recstarttime;
            }

            public String getRecstarttimeutc() {
                return this.recstarttimeutc;
            }

            public String getScheduleid() {
                return this.scheduleid;
            }

            public String getSeriesrec() {
                return this.seriesrec;
            }

            public void setHdflag(String str) {
                this.hdflag = str;
            }

            public void setLevel(String str) {
                this.level = str;
            }

            public void setMixid(String str) {
                this.mixid = str;
            }

            public void setPriority(String str) {
                this.priority = str;
            }

            public void setProgramname(String str) {
                this.programname = str;
            }

            public void setRecendtime(String str) {
                this.recendtime = str;
            }

            public void setRecendtimeutc(String str) {
                this.recendtimeutc = str;
            }

            public void setRecstarttime(String str) {
                this.recstarttime = str;
            }

            public void setRecstarttimeutc(String str) {
                this.recstarttimeutc = str;
            }

            public void setScheduleid(String str) {
                this.scheduleid = str;
            }

            public void setSeriesrec(String str) {
                this.seriesrec = str;
            }
        }

        public NewrecordBean getNewrecord() {
            return this.newrecord;
        }

        public List<OldrecordBean> getOldrecord() {
            return this.oldrecord;
        }

        public void setNewrecord(NewrecordBean newrecordBean) {
            this.newrecord = newrecordBean;
        }

        public void setOldrecord(List<OldrecordBean> list) {
            this.oldrecord = list;
        }
    }

    public List<DataBean> getData() {
        List<DataBean> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getMac() {
        return this.mac;
    }

    public String getPrevueid() {
        String str = this.prevueid;
        return str == null ? "" : str;
    }

    public String getRecordstarttime() {
        return this.recordstarttime;
    }

    public int getReturncode() {
        return this.returncode;
    }

    public int getScheduleid() {
        return this.scheduleid;
    }

    public int getTaskid() {
        return this.taskid;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setPrevueid(String str) {
        this.prevueid = str;
    }

    public void setRecordstarttime(String str) {
        this.recordstarttime = str;
    }

    public void setReturncode(int i) {
        this.returncode = i;
    }

    public void setScheduleid(int i) {
        this.scheduleid = i;
    }

    public void setTaskid(int i) {
        this.taskid = i;
    }
}
