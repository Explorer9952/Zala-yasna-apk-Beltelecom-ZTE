package com.zte.iptvclient.android.mobile.npvr.model.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SeriesNpvrListBean {
    private List<String> begintime;
    private List<String> channelcode;
    private List<String> channelname;
    private List<String> definition;
    private List<String> duration;
    private List<String> endtime;
    private String errormsg;
    private List<String> filename;
    private List<String> isseries;
    private List<String> mediaservice;
    private List<String> npvrcode;
    private List<String> prevuecode;
    private List<String> prevuename;
    private String returncode;
    private List<String> seriesnum;
    private String totalcount;

    public List<String> getBegintime() {
        List<String> list = this.begintime;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getChannelcode() {
        List<String> list = this.channelcode;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getChannelname() {
        List<String> list = this.channelname;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getDefinition() {
        List<String> list = this.definition;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getDuration() {
        List<String> list = this.duration;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getEndtime() {
        List<String> list = this.endtime;
        return list == null ? new ArrayList() : list;
    }

    public String getErrormsg() {
        String str = this.errormsg;
        return str == null ? "" : str;
    }

    public List<String> getFilename() {
        List<String> list = this.filename;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getIsseries() {
        List<String> list = this.isseries;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getMediaservice() {
        List<String> list = this.mediaservice;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getNpvrcode() {
        List<String> list = this.npvrcode;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getPrevuecode() {
        List<String> list = this.prevuecode;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getPrevuename() {
        List<String> list = this.prevuename;
        return list == null ? new ArrayList() : list;
    }

    public String getReturncode() {
        String str = this.returncode;
        return str == null ? "" : str;
    }

    public List<String> getSeriesnum() {
        List<String> list = this.seriesnum;
        return list == null ? new ArrayList() : list;
    }

    public String getTotalcount() {
        String str = this.totalcount;
        return str == null ? "" : str;
    }

    public void setBegintime(List<String> list) {
        this.begintime = list;
    }

    public void setChannelcode(List<String> list) {
        this.channelcode = list;
    }

    public void setChannelname(List<String> list) {
        this.channelname = list;
    }

    public void setDefinition(List<String> list) {
        this.definition = list;
    }

    public void setDuration(List<String> list) {
        this.duration = list;
    }

    public void setEndtime(List<String> list) {
        this.endtime = list;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setFilename(List<String> list) {
        this.filename = list;
    }

    public void setIsseries(List<String> list) {
        this.isseries = list;
    }

    public void setMediaservice(List<String> list) {
        this.mediaservice = list;
    }

    public void setNpvrcode(List<String> list) {
        this.npvrcode = list;
    }

    public void setPrevuecode(List<String> list) {
        this.prevuecode = list;
    }

    public void setPrevuename(List<String> list) {
        this.prevuename = list;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setSeriesnum(List<String> list) {
        this.seriesnum = list;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }
}
