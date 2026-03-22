package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VideoDetailBean implements Serializable {
    private String actor;
    private String advertisecontent;
    private String allownettype;
    private String audiolang;
    private String auth_returncode;
    private String authid;
    private String beginduration;
    private String billdate;
    private String bocode;
    private String breakpoint;
    private String cast;
    private String chargetype;
    private String cmsid;
    private String columncode;
    private String contentcode;
    private String contentprodtype;
    private String countryname;
    private String cpcode;
    private String currentplayIndex;
    private String definition;
    private String description;
    private String director;
    private HashMap<String, String> downloadURL;
    private String effectivedate;
    private String effecttime;
    private String elapsedtime;
    private String encrypttype;
    private String endduration;
    private String endtime;
    private String expiredtime;
    private String genre;
    private String genreidlist;
    private String genrelock;
    private String getpoints;
    private String hastrailer;
    private String httpsplayurl;
    private String httpstrailerurl;
    private String iplimitflag;
    private String isfavourite;
    private String isprotection;
    private String language;
    private String mediaservice;
    private String mediaservices;
    private String offlinetime;
    private String orderpoints;
    private String physicalcontentid;
    private String playurl;
    private String points;
    private String posterfilelist;
    private String posterpath;
    private String preduration;
    private String previewendtime;
    private String previewstarttime;
    private String prevuename;
    private String price;
    private String productVIP;
    private String producttype;
    private String programcode;
    private String programname;
    private String programtype;
    private String pubcompany;
    private String purchasephone;
    private String ratingid;
    private String ratingnum;
    private String ratingsum;
    private String releasedate;
    private String seriestype;
    private String starlevel;
    private String starttime;
    private String subtitlelang;
    private String systemlimitenable;
    private String telecomcode;
    private String trailer;
    private String trailerurl;
    private String userscenetype;
    private String videoelapsedtime;
    private String videotelecomcode;
    private String videotype;
    private String vrflag;
    private String vrtype;
    private String writer;

    public static VideoDetailBean getVideoDetailBeanFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoDetailBean videoDetailBean = new VideoDetailBean();
        try {
            videoDetailBean.setProgramcode(jSONObject.optString("programcode"));
            videoDetailBean.setProgramname(jSONObject.optString("programname"));
            videoDetailBean.setActor(jSONObject.optString("actor"));
            videoDetailBean.setDirector(jSONObject.optString("director"));
            videoDetailBean.setWriter(jSONObject.optString("writer"));
            videoDetailBean.setPrice(jSONObject.optString("price"));
            videoDetailBean.setLanguage(jSONObject.optString("language"));
            videoDetailBean.setCountryname(jSONObject.optString("countryname"));
            videoDetailBean.setGenre(jSONObject.optString("genre"));
            videoDetailBean.setColumncode(jSONObject.optString("columncode"));
            videoDetailBean.setPosterfilelist(jSONObject.optString("posterfilelist"));
            videoDetailBean.setPosterpath(jSONObject.optString("posterpath"));
            videoDetailBean.setReleasedate(jSONObject.optString("releasedate"));
            videoDetailBean.setElapsedtime(jSONObject.optString("elapsedtime"));
            videoDetailBean.setPlayurl(jSONObject.optString("playurl"));
            videoDetailBean.setHttpsplayurl(jSONObject.optString("httpsplayurl"));
            videoDetailBean.setDescription(!TextUtils.isEmpty(jSONObject.optString("description")) ? jSONObject.optString("description").replace("<p>", " ").replace("</p>", " ").replace("/p", " ") : "");
            videoDetailBean.setProgramtype(jSONObject.optString("programtype"));
            videoDetailBean.setDefinition(jSONObject.optString("definition"));
            videoDetailBean.setVideotype(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE));
            videoDetailBean.setVideoelapsedtime(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOELAPSEDTIME));
            videoDetailBean.setMediaservice(jSONObject.optString("mediaservice"));
            videoDetailBean.setMediaservices(jSONObject.optString("mediaservices"));
            videoDetailBean.setContentcode(jSONObject.optString("contentcode"));
            videoDetailBean.setCpcode(jSONObject.optString("cpcode"));
            videoDetailBean.setBocode(jSONObject.optString("bocode"));
            videoDetailBean.setOfflinetime(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME));
            videoDetailBean.setRatingid(jSONObject.optString("ratingid"));
            videoDetailBean.setStarlevel(jSONObject.optString("starlevel"));
            videoDetailBean.setRatingnum(jSONObject.optString("ratingnum"));
            videoDetailBean.setRatingsum(jSONObject.optString("ratingsum"));
            videoDetailBean.setIplimitflag(jSONObject.optString("iplimitflag"));
            videoDetailBean.setIsprotection(jSONObject.optString("isprotection"));
            videoDetailBean.setAdvertisecontent(jSONObject.optString("advertisecontent"));
            videoDetailBean.setIsfavourite(jSONObject.optString("isfavourite"));
            videoDetailBean.setAuth_returncode(jSONObject.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
            videoDetailBean.setAuthid(jSONObject.optString(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID));
            videoDetailBean.setHastrailer(jSONObject.optString("hastrailer"));
            videoDetailBean.setTrailer(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER));
            videoDetailBean.setHttpstrailerurl(jSONObject.optString("httpstrailer"));
            videoDetailBean.setTrailerurl(jSONObject.optString("trailerurl"));
            videoDetailBean.setTrailerurl(jSONObject.optString("trailerurl"));
            videoDetailBean.setTelecomcode(jSONObject.optString("telecomcode"));
            videoDetailBean.setVideotelecomcode(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE));
            videoDetailBean.setBeginduration(jSONObject.optString("beginduration"));
            videoDetailBean.setEndduration(jSONObject.optString("endduration"));
            videoDetailBean.setPreduration(jSONObject.optString("preduration"));
            videoDetailBean.setPurchasephone(jSONObject.optString("purchasephone"));
            videoDetailBean.setPrevuename(jSONObject.optString("prevuename"));
            videoDetailBean.setPreviewstarttime(jSONObject.optString(ParamConst.AUTH_RSP_PREVIEWSTARTTIME));
            videoDetailBean.setPreviewendtime(jSONObject.optString(ParamConst.AUTH_RSP_PREVIEWENDTIME));
            videoDetailBean.setEffecttime(jSONObject.optString(ParamConst.AUTH_RSP_EFFECTTIME));
            videoDetailBean.setBilldate(jSONObject.optString("billdate"));
            videoDetailBean.setUserscenetype(jSONObject.optString(ParamConst.AUTH_RSP_USERSCENETYPE));
            videoDetailBean.setChargetype(jSONObject.optString(ParamConst.AUTH_RSP_CHARGETYPE));
            videoDetailBean.setOrderpoints(jSONObject.optString("orderpoints"));
            videoDetailBean.setGetpoints(jSONObject.optString("getpoints"));
            videoDetailBean.setPoints(jSONObject.optString(ParamConst.SUBSCRIBE_RES_POINTS));
            videoDetailBean.setVrtype(jSONObject.optString("vrtype"));
            videoDetailBean.setVrflag(jSONObject.optString("vrflag"));
            videoDetailBean.setExpiredtime(jSONObject.optString("expiredtime"));
            videoDetailBean.setContentprodtype(jSONObject.optString("contentprodtype"));
            videoDetailBean.setCmsid(jSONObject.optString("cmsid"));
            videoDetailBean.setPhysicalcontentid(jSONObject.optString("physicalcontentid"));
            videoDetailBean.setBreakpoint(jSONObject.optString("breakpoint"));
            videoDetailBean.setCast(jSONObject.optString("cast"));
            videoDetailBean.setSystemlimitenable(jSONObject.optString("systemlimitenable"));
            videoDetailBean.setAudiolang(jSONObject.optString("audiolang"));
            videoDetailBean.setSubtitlelang(jSONObject.optString("subtitlelang"));
            videoDetailBean.setAllownettype(jSONObject.optString("allownettype"));
            videoDetailBean.setGenrelock(jSONObject.optString("genrelock"));
            videoDetailBean.setGenreidlist(jSONObject.optString("genreidlist"));
            videoDetailBean.setEncrypttype(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_ENCRYPTTYPE));
            videoDetailBean.setPubcompany(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_PUBCOMPANY));
            videoDetailBean.setGenrelockByGenreidlist();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoDetailBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(VideoDetailBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(VideoDetailBean.class.getName(), "writeObject");
    }

    public String getActor() {
        return this.actor;
    }

    public String getAdvertisecontent() {
        return this.advertisecontent;
    }

    public String getAllownettype() {
        return this.allownettype;
    }

    public String getAudiolang() {
        return this.audiolang;
    }

    public String getAuth_returncode() {
        return this.auth_returncode;
    }

    public String getAuthid() {
        return this.authid;
    }

    public String getBeginduration() {
        return this.beginduration;
    }

    public String getBilldate() {
        return this.billdate;
    }

    public String getBocode() {
        return this.bocode;
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getCast() {
        return this.cast;
    }

    public String getChargetype() {
        return this.chargetype;
    }

    public String getCmsid() {
        return this.cmsid;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getContentprodtype() {
        return this.contentprodtype;
    }

    public String getCountryname() {
        return this.countryname;
    }

    public String getCpcode() {
        return this.cpcode;
    }

    public String getCurrentplayIndex() {
        return this.currentplayIndex;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDirector() {
        return this.director;
    }

    public HashMap<String, String> getDownloadURL() {
        return this.downloadURL;
    }

    public String getEffectivedate() {
        return this.effectivedate;
    }

    public String getEffecttime() {
        return this.effecttime;
    }

    public String getElapsedtime() {
        return this.elapsedtime;
    }

    public String getEncrypttype() {
        return this.encrypttype;
    }

    public String getEndduration() {
        return this.endduration;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getExpiredtime() {
        if (TextUtils.isEmpty(this.expiredtime)) {
            this.expiredtime = "2099.01.01 00:00:00";
        }
        return this.expiredtime;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getGenreidlist() {
        return this.genreidlist;
    }

    public String getGenrelock() {
        return this.genrelock;
    }

    public String getGetpoints() {
        return this.getpoints;
    }

    public String getHastrailer() {
        return this.hastrailer;
    }

    public String getHttpsplayurl() {
        return this.httpsplayurl;
    }

    public String getHttpstrailerurl() {
        return this.httpstrailerurl;
    }

    public String getIplimitflag() {
        return this.iplimitflag;
    }

    public String getIsfavourite() {
        return this.isfavourite;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMediaservice() {
        return this.mediaservice;
    }

    public String getMediaservices() {
        return this.mediaservices;
    }

    public String getOfflinetime() {
        return this.offlinetime;
    }

    public String getOrderpoints() {
        return this.orderpoints;
    }

    public String getPhysicalcontentid() {
        return this.physicalcontentid;
    }

    public String getPlayurl() {
        if (SDKLoginMgr.getInstance().getEPGHome() == null) {
            return "";
        }
        if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
            return this.httpsplayurl;
        }
        return this.playurl;
    }

    public String getPoints() {
        return this.points;
    }

    public String getPosterfilelist() {
        return this.posterfilelist;
    }

    public String getPosterpath() {
        return this.posterpath;
    }

    public String getPreduration() {
        return this.preduration;
    }

    public String getPreviewendtime() {
        return this.previewendtime;
    }

    public String getPreviewstarttime() {
        return this.previewstarttime;
    }

    public String getPrevuename() {
        return this.prevuename;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProductVIP() {
        return this.productVIP;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getProgramname() {
        return this.programname;
    }

    public String getProgramtype() {
        return this.programtype;
    }

    public String getPubcompany() {
        return this.pubcompany;
    }

    public String getPurchasephone() {
        return this.purchasephone;
    }

    public String getRatingid() {
        return this.ratingid;
    }

    public String getRatingnum() {
        return this.ratingnum;
    }

    public String getRatingsum() {
        return this.ratingsum;
    }

    public String getReleasedate() {
        return this.releasedate;
    }

    public String getSeriestype() {
        return this.seriestype;
    }

    public String getStarlevel() {
        return this.starlevel;
    }

    public String getStarttime() {
        return this.starttime;
    }

    public String getSubtitlelang() {
        return this.subtitlelang;
    }

    public String getSystemlimitenable() {
        return this.systemlimitenable;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getTrailer() {
        if (SDKLoginMgr.getInstance().getEPGHome() == null) {
            return "";
        }
        if (SDKLoginMgr.getInstance().getEPGHome().startsWith(HttpConstant.PROTOCOL_HTTPS)) {
            return this.httpstrailerurl;
        }
        return this.trailerurl;
    }

    public String getTrailerurl() {
        return this.trailerurl;
    }

    public String getUserscenetype() {
        return this.userscenetype;
    }

    public String getVideoelapsedtime() {
        return this.videoelapsedtime;
    }

    public String getVideotelecomcode() {
        return this.videotelecomcode;
    }

    public String getVideotype() {
        return this.videotype;
    }

    public String getVrflag() {
        return this.vrflag;
    }

    public String getVrtype() {
        return this.vrtype;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setActor(String str) {
        this.actor = str;
    }

    public void setAdvertisecontent(String str) {
        this.advertisecontent = str;
    }

    public void setAllownettype(String str) {
        this.allownettype = str;
    }

    public void setAudiolang(String str) {
        this.audiolang = str;
    }

    public void setAuth_returncode(String str) {
        this.auth_returncode = str;
    }

    public void setAuthid(String str) {
        this.authid = str;
    }

    public void setBeginduration(String str) {
        this.beginduration = str;
    }

    public void setBilldate(String str) {
        this.billdate = str;
    }

    public void setBocode(String str) {
        this.bocode = str;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setCast(String str) {
        this.cast = str;
    }

    public void setChargetype(String str) {
        this.chargetype = str;
    }

    public void setCmsid(String str) {
        this.cmsid = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setContentprodtype(String str) {
        this.contentprodtype = str;
    }

    public void setCountryname(String str) {
        this.countryname = str;
    }

    public void setCpcode(String str) {
        this.cpcode = str;
    }

    public void setCurrentplayIndex(String str) {
        this.currentplayIndex = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public void setDownloadURL(HashMap<String, String> hashMap) {
        this.downloadURL = hashMap;
    }

    public void setEffectivedate(String str) {
        this.effectivedate = str;
    }

    public void setEffecttime(String str) {
        this.effecttime = str;
    }

    public void setElapsedtime(String str) {
        this.elapsedtime = str;
    }

    public void setEncrypttype(String str) {
        this.encrypttype = str;
    }

    public void setEndduration(String str) {
        this.endduration = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setExpiredtime(String str) {
        this.expiredtime = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setGenreidlist(String str) {
        this.genreidlist = str;
    }

    public void setGenrelock(String str) {
        this.genrelock = str;
    }

    public void setGenrelockByGenreidlist() {
        LogEx.d("VideoDetailBean", "---setGenrelockByGenreidlist---");
        boolean a2 = com.zte.iptvclient.android.mobile.e0.f.c.a();
        LogEx.d("VideoDetailBean", "---setGenrelockByGenreidlist---isGenreLockByGenreIdList开关: " + a2);
        if (a2) {
            setGenrelock("0");
            String str = this.genreidlist;
            if (str != null) {
                String[] split = str.split(";");
                LogEx.d("VideoDetailBean", "---setGenrelockByGenreidlist---genreids: " + Arrays.asList(split));
                ArrayList<String> b2 = com.zte.iptvclient.android.common.j.k.i().b();
                LogEx.d("VideoDetailBean", "---setGenrelockByGenreidlist---genre锁: " + b2);
                for (String str2 : split) {
                    if (b2.contains(str2)) {
                        LogEx.d("VideoDetailBean", "---setGenrelockByGenreidlist---成功设置genre锁by " + str2);
                        setGenrelock("1");
                        return;
                    }
                }
            }
        }
    }

    public void setGetpoints(String str) {
        this.getpoints = str;
    }

    public void setHastrailer(String str) {
        this.hastrailer = str;
    }

    public void setHttpsplayurl(String str) {
        this.httpsplayurl = str;
    }

    public void setHttpstrailerurl(String str) {
        this.httpstrailerurl = str;
    }

    public void setIplimitflag(String str) {
        this.iplimitflag = str;
    }

    public void setIsfavourite(String str) {
        this.isfavourite = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMediaservice(String str) {
        this.mediaservice = str;
    }

    public void setMediaservices(String str) {
        this.mediaservices = str;
    }

    public void setOfflinetime(String str) {
        this.offlinetime = str;
    }

    public void setOrderpoints(String str) {
        this.orderpoints = str;
    }

    public void setPhysicalcontentid(String str) {
        this.physicalcontentid = str;
    }

    public void setPlayurl(String str) {
        this.playurl = str;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setPosterfilelist(String str) {
        this.posterfilelist = str;
    }

    public void setPosterpath(String str) {
        this.posterpath = str;
    }

    public void setPreduration(String str) {
        this.preduration = str;
    }

    public void setPreviewendtime(String str) {
        this.previewendtime = str;
    }

    public void setPreviewstarttime(String str) {
        this.previewstarttime = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProductVIP(String str) {
        this.productVIP = str;
    }

    public void setProducttype(String str) {
        this.producttype = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setProgramname(String str) {
        this.programname = str;
    }

    public void setProgramtype(String str) {
        this.programtype = str;
    }

    public void setPubcompany(String str) {
        this.pubcompany = str;
    }

    public void setPurchasephone(String str) {
        this.purchasephone = str;
    }

    public void setRatingid(String str) {
        this.ratingid = str;
    }

    public void setRatingnum(String str) {
        this.ratingnum = str;
    }

    public void setRatingsum(String str) {
        this.ratingsum = str;
    }

    public void setReleasedate(String str) {
        this.releasedate = str;
    }

    public void setSeriestype(String str) {
        this.seriestype = str;
    }

    public void setStarlevel(String str) {
        this.starlevel = str;
    }

    public void setStarttime(String str) {
        this.starttime = str;
    }

    public void setSubtitlelang(String str) {
        this.subtitlelang = str;
    }

    public void setSystemlimitenable(String str) {
        this.systemlimitenable = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setTrailer(String str) {
        this.trailer = str;
    }

    public void setTrailerurl(String str) {
        this.trailerurl = str;
    }

    public void setUserscenetype(String str) {
        this.userscenetype = str;
    }

    public void setVideoelapsedtime(String str) {
        this.videoelapsedtime = str;
    }

    public void setVideotelecomcode(String str) {
        this.videotelecomcode = str;
    }

    public void setVideotype(String str) {
        this.videotype = str;
    }

    public void setVrflag(String str) {
        this.vrflag = str;
    }

    public void setVrtype(String str) {
        this.vrtype = str;
    }

    public void setWriter(String str) {
        this.writer = str;
    }

    public String toString() {
        return "VideoDetailBean{programcode='" + this.programcode + "', programname='" + this.programname + "', actor='" + this.actor + "', director='" + this.director + "', writer='" + this.writer + "', price='" + this.price + "', language='" + this.language + "', countryname='" + this.countryname + "', genre='" + this.genre + "', columncode='" + this.columncode + "', posterfilelist='" + this.posterfilelist + "', posterpath='" + this.posterpath + "', releasedate='" + this.releasedate + "', elapsedtime='" + this.elapsedtime + "', playurl='" + this.playurl + "', httpsplayurl='" + this.httpsplayurl + "', description='" + this.description + "', programtype='" + this.programtype + "', definition='" + this.definition + "', videotype='" + this.videotype + "', videoelapsedtime='" + this.videoelapsedtime + "', mediaservice='" + this.mediaservice + "', mediaservices='" + this.mediaservices + "', contentcode='" + this.contentcode + "', cpcode='" + this.cpcode + "', bocode='" + this.bocode + "', offlinetime='" + this.offlinetime + "', ratingid='" + this.ratingid + "', starlevel='" + this.starlevel + "', ratingnum='" + this.ratingnum + "', ratingsum='" + this.ratingsum + "', iplimitflag='" + this.iplimitflag + "', telecomcode='" + this.telecomcode + "', isprotection='" + this.isprotection + "', advertisecontent='" + this.advertisecontent + "', isfavourite='" + this.isfavourite + "', auth_returncode='" + this.auth_returncode + "', authid='" + this.authid + "', starttime='" + this.starttime + "', endtime='" + this.endtime + "', expiredtime='" + this.expiredtime + "', effectivedate='" + this.effectivedate + "', producttype='" + this.producttype + "', productVIP='" + this.productVIP + "', purchasephone='" + this.purchasephone + "', prevuename='" + this.prevuename + "', previewstarttime='" + this.previewstarttime + "', previewendtime='" + this.previewendtime + "', effecttime='" + this.effecttime + "', billdate='" + this.billdate + "', userscenetype='" + this.userscenetype + "', chargetype='" + this.chargetype + "', orderpoints='" + this.orderpoints + "', getpoints='" + this.getpoints + "', points='" + this.points + "', hastrailer='" + this.hastrailer + "', trailer='" + this.trailer + "', trailerurl='" + this.trailerurl + "', vrflag='" + this.vrflag + "', vrtype='" + this.vrtype + "', downloadURL=" + this.downloadURL + ", contentprodtype='" + this.contentprodtype + "', cmsid='" + this.cmsid + "', physicalcontentid='" + this.physicalcontentid + "', breakpoint='" + this.breakpoint + "', beginduration='" + this.beginduration + "', endduration='" + this.endduration + "', preduration='" + this.preduration + "', audiolang='" + this.audiolang + "', subtitlelang='" + this.subtitlelang + "', allownettype='" + this.allownettype + "', systemlimitenable='" + this.systemlimitenable + "', cast='" + this.cast + "', currentplayIndex='" + this.currentplayIndex + "', genrelock='" + this.genrelock + "', genreidlist='" + this.genreidlist + "'}";
    }
}
