package com.zte.iptvclient.android.mobile.npvr.model.bean;

import com.video.androidsdk.service.comm.ParamConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NpvrBean {
    public static final String TIME_FORMAT = "yyyy.MM.dd HH:mm:ss";
    private String allowNetType;
    private String begintime;
    private String channelcode;
    private String channelname;
    private String definition;
    private String duration;
    private String endtime;
    private String filename;
    private String iconurl;
    private String isseries;
    private String mediaservice;
    private String mixno;
    private String npvrcode;
    private String playUrl;
    private String prevueRating;
    private String prevuecode;
    private String prevuename;
    private String ratingid;
    private String seriesheadid;
    private String status;
    private String systemlimitenable;

    private NpvrBean() {
    }

    public static NpvrBean jsonToBean(JSONObject jSONObject) {
        NpvrBean npvrBean = new NpvrBean();
        npvrBean.setSeriesheadid(jSONObject.optString("seriesheadid"));
        npvrBean.setChannelcode(jSONObject.optString("channelcode"));
        npvrBean.setChannelname(jSONObject.optString("channelname"));
        npvrBean.setPrevuecode(jSONObject.optString("prevuecode"));
        npvrBean.setPrevuename(jSONObject.optString("prevuename"));
        npvrBean.setFilename(jSONObject.optString("filename"));
        npvrBean.setBegintime(jSONObject.optString("begintime"));
        npvrBean.setEndtime(jSONObject.optString("endtime"));
        npvrBean.setIsseries(jSONObject.optString(ParamConst.NPVR_QUERY_RSP_ISSERIES));
        npvrBean.setDuration(jSONObject.optString(ParamConst.NPVR_QUERY_RSP_DURATION));
        npvrBean.setMediaservice(jSONObject.optString("mediaservice"));
        npvrBean.setDefinition(jSONObject.optString("definition"));
        npvrBean.setStatus(jSONObject.optString("status"));
        npvrBean.setNpvrcode(jSONObject.optString("npvrcode"));
        npvrBean.setPrevueRating(jSONObject.optString("ratingid"));
        return npvrBean;
    }

    public String getAllowNetType() {
        return this.allowNetType;
    }

    public String getBegintime() {
        String str = this.begintime;
        return str == null ? "" : str;
    }

    public String getChannelcode() {
        String str = this.channelcode;
        return str == null ? "" : str;
    }

    public String getChannelname() {
        String str = this.channelname;
        return str == null ? "" : str;
    }

    public String getDefinition() {
        String str = this.definition;
        return str == null ? "" : str;
    }

    public String getDuration() {
        String str = this.duration;
        return str == null ? "" : str;
    }

    public String getEndtime() {
        String str = this.endtime;
        return str == null ? "" : str;
    }

    public String getFilename() {
        String str = this.filename;
        return str == null ? "" : str;
    }

    public String getIconurl() {
        String str = this.iconurl;
        return str == null ? "" : str;
    }

    public String getIsseries() {
        String str = this.isseries;
        return str == null ? "" : str;
    }

    public String getMediaservice() {
        String str = this.mediaservice;
        return str == null ? "" : str;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getNpvrcode() {
        String str = this.npvrcode;
        return str == null ? "" : str;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public String getPrevueRating() {
        return this.prevueRating;
    }

    public String getPrevuecode() {
        String str = this.prevuecode;
        return str == null ? "" : str;
    }

    public String getPrevuename() {
        String str = this.prevuename;
        return str == null ? "" : str;
    }

    public String getRatingid() {
        return this.ratingid;
    }

    public String getSeriesheadid() {
        String str = this.seriesheadid;
        return str == null ? "" : str;
    }

    public String getStatus() {
        String str = this.status;
        return str == null ? "" : str;
    }

    public String getSystemlimitenable() {
        return this.systemlimitenable;
    }

    public void setAllowNetType(String str) {
        this.allowNetType = str;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setChannelname(String str) {
        this.channelname = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setIconurl(String str) {
        this.iconurl = str;
    }

    public void setIsseries(String str) {
        this.isseries = str;
    }

    public void setMediaservice(String str) {
        this.mediaservice = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setNpvrcode(String str) {
        this.npvrcode = str;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public void setPrevueRating(String str) {
        this.prevueRating = str;
    }

    public void setPrevuecode(String str) {
        this.prevuecode = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setRatingid(String str) {
        this.ratingid = str;
    }

    public void setSeriesheadid(String str) {
        this.seriesheadid = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSystemlimitenable(String str) {
        this.systemlimitenable = str;
    }

    public NpvrBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.seriesheadid = str;
        this.channelcode = str2;
        this.channelname = str3;
        this.prevuecode = str4;
        this.prevuename = str5;
        this.filename = str6;
        this.begintime = str7;
        this.endtime = str8;
        this.isseries = str9;
        this.duration = str10;
        this.mediaservice = str11;
        this.definition = str12;
        this.status = str13;
        this.npvrcode = str14;
        this.prevueRating = str15;
    }
}
