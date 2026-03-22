package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Channel implements Serializable {
    private static final long serialVersionUID = 123456780;
    private String AfterChannelLock;
    private String adContent;
    private String advertisecontent;
    private String allMixno;
    private String allownettype;
    private String authid;
    private String begintime;
    private String bigLogo1;
    private String bigLogo2;
    private String channelcode;
    private String channelname;
    private String columncode;
    private String curbegintime;
    private String curendtime;
    private String customsort;
    private String definition;
    private String description;
    private String endtime;
    private String isChannelLock;
    private String isdrm;
    private String isfavourite;
    private String isprotection;
    ArrayList<String> liveStreamDefinitionList;
    private String liveStreamUrl;
    ArrayList<String> liveStreamUrlList;
    private String mediaservices;
    private String mixno;
    private String npvravailable;
    private String posterimage;
    private String prevuename;
    private String ratingid;
    private String smallLogo1;
    private String smallLogo2;
    private String sortnum;
    private String supporttimeshift;
    private String systemlimitenable;
    private String telecomcode;
    private String timeshiftenable;
    private String tsavailable;
    private String tvCode;
    private String tvDescription;
    private String tvName;
    private String tvOnlyName;
    private String tvodavailable;
    private String usermixno;
    private String utcbegintime;
    private String utcendtime;
    private String vrflag;
    private String vrtype;

    public Channel(String str, String str2) {
        this.mixno = str;
        this.customsort = str2;
    }

    public static Channel getChannelFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Channel channel = new Channel();
        try {
            channel.setChannelcode(jSONObject.optString("channelcode"));
            channel.setChannelname(jSONObject.optString("channelname"));
            channel.setColumncode(jSONObject.optString("columncode"));
            if (!TextUtils.isEmpty(jSONObject.optString("usermixno"))) {
                channel.setMixno(jSONObject.optString("usermixno"));
                channel.setCustomsort(jSONObject.optString("usermixno"));
            } else {
                channel.setMixno(jSONObject.optString("mixno"));
                channel.setCustomsort(jSONObject.optString("mixno"));
            }
            channel.setAllMixno(jSONObject.optString("mixno"));
            channel.setTelecomcode(jSONObject.optString("telecomcode"));
            channel.setIsprotection(jSONObject.optString("isprotection"));
            channel.setRatingid(jSONObject.optString("ratingid"));
            channel.setSortnum(jSONObject.optString("sortnum"));
            channel.setPosterimage(jSONObject.optString("posterimage"));
            channel.setDescription(jSONObject.optString("description"));
            channel.setAdvertisecontent(jSONObject.optString("advertisecontent"));
            channel.setUsermixno(jSONObject.optString("usermixno"));
            channel.setMediaservices(jSONObject.optString("mediaservices"));
            channel.setTvodavailable(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_TVODAVAILABLE));
            channel.setNpvravailable(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_NPVRAVAILABLE));
            channel.setTsavailable(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE));
            channel.setTimeshiftenable(jSONObject.optString(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTENABLE));
            channel.setPrevuename(jSONObject.optString("prevuename"));
            channel.setBegintime(jSONObject.optString("begintime"));
            channel.setEndtime(jSONObject.optString("endtime"));
            channel.setUtcbegintime(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_UTCBEGINTIME));
            channel.setUtcendtime(jSONObject.optString("utcendtime"));
            channel.setIsfavourite(jSONObject.optString("isfavourite"));
            channel.setSystemlimitenable(jSONObject.optString("systemlimitenable"));
            channel.setIsChannelLock(jSONObject.optString("0"));
            channel.setAfterChannelLock(jSONObject.optString("0"));
            channel.setAllownettype(jSONObject.optString("allownettype"));
            String usermixno = channel.getUsermixno();
            if (!TextUtils.isEmpty(usermixno)) {
                channel.setMixno(usermixno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(Channel.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(Channel.class.getName(), "writeObject");
    }

    public String getAdContent() {
        return this.adContent;
    }

    public String getAdvertisecontent() {
        return this.advertisecontent;
    }

    public String getAfterChannelLock() {
        return this.AfterChannelLock;
    }

    public String getAllMixno() {
        return this.allMixno;
    }

    public String getAllownettype() {
        return this.allownettype;
    }

    public String getAuthid() {
        return this.authid;
    }

    public String getBegintime() {
        if (!TextUtils.isEmpty(this.begintime)) {
            return this.begintime;
        }
        return this.utcbegintime;
    }

    public String getBigLogo1() {
        return this.bigLogo1;
    }

    public String getBigLogo2() {
        return this.bigLogo2;
    }

    public String getChannelcode() {
        return this.channelcode;
    }

    public String getChannelname() {
        return this.channelname;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getCurbegintime() {
        return this.curbegintime;
    }

    public String getCurendtime() {
        return this.curendtime;
    }

    public String getCustomsort() {
        return this.customsort;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEndtime() {
        if (!TextUtils.isEmpty(this.endtime)) {
            return this.endtime;
        }
        return this.utcendtime;
    }

    public String getIsChannelLock() {
        return this.isChannelLock;
    }

    public String getIsdrm() {
        return this.isdrm;
    }

    public String getIsfavourite() {
        return this.isfavourite;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public ArrayList<String> getLiveStreamDefinitionList() {
        return this.liveStreamDefinitionList;
    }

    public String getLiveStreamUrl() {
        return this.liveStreamUrl;
    }

    public ArrayList<String> getLiveStreamUrlList() {
        return this.liveStreamUrlList;
    }

    public String getMediaservices() {
        return this.mediaservices;
    }

    public String getMixno() {
        return this.mixno;
    }

    public String getNpvravailable() {
        return this.npvravailable;
    }

    public String getPosterimage() {
        return this.posterimage;
    }

    public String getPrevuename() {
        return this.prevuename;
    }

    public String getRatingid() {
        return this.ratingid;
    }

    public String getSmallLogo1() {
        return this.smallLogo1;
    }

    public String getSmallLogo2() {
        return this.smallLogo2;
    }

    public String getSortnum() {
        return this.sortnum;
    }

    public String getSupporttimeshift() {
        return this.supporttimeshift;
    }

    public String getSystemlimitenable() {
        return this.systemlimitenable;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getTimeshiftenable() {
        return this.timeshiftenable;
    }

    public String getTsavailable() {
        return this.tsavailable;
    }

    public String getTvCode() {
        return this.tvCode;
    }

    public String getTvDescription() {
        return this.tvDescription;
    }

    public String getTvName() {
        return this.tvName;
    }

    public String getTvOnlyName() {
        return this.tvOnlyName;
    }

    public String getTvodavailable() {
        return this.tvodavailable;
    }

    public String getUsermixno() {
        return this.usermixno;
    }

    public String getUtcbegintime() {
        return this.utcbegintime;
    }

    public String getUtcendtime() {
        return this.utcendtime;
    }

    public String getVRFlag() {
        return this.vrflag;
    }

    public String getVRType() {
        return this.vrtype;
    }

    public String getVrflag() {
        return this.vrflag;
    }

    public String getVrtype() {
        return this.vrtype;
    }

    public String getbegintime() {
        return this.begintime;
    }

    public void setAdContent(String str) {
        this.adContent = str;
    }

    public void setAdvertisecontent(String str) {
        this.advertisecontent = str;
    }

    public void setAfterChannelLock(String str) {
        this.AfterChannelLock = str;
    }

    public void setAllMixno(String str) {
        this.allMixno = str;
    }

    public void setAllownettype(String str) {
        this.allownettype = str;
    }

    public void setAuthid(String str) {
        this.authid = str;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setBigLogo1(String str) {
        this.bigLogo1 = str;
    }

    public void setBigLogo2(String str) {
        this.bigLogo2 = str;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setChannelname(String str) {
        this.channelname = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setCurbegintime(String str) {
        this.curbegintime = str;
    }

    public void setCurendtime(String str) {
        this.curendtime = str;
    }

    public void setCustomsort(String str) {
        this.customsort = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setIsChannelLock(String str) {
        this.isChannelLock = str;
    }

    public void setIsdrm(String str) {
        this.isdrm = str;
    }

    public void setIsfavourite(String str) {
        this.isfavourite = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setLiveStreamDefinitionList(ArrayList<String> arrayList) {
        this.liveStreamDefinitionList = arrayList;
    }

    public void setLiveStreamUrl(String str) {
        this.liveStreamUrl = str;
    }

    public void setLiveStreamUrlList(ArrayList<String> arrayList) {
        this.liveStreamUrlList = arrayList;
    }

    public void setMediaservices(String str) {
        this.mediaservices = str;
    }

    public void setMixno(String str) {
        this.mixno = str;
    }

    public void setNpvravailable(String str) {
        this.npvravailable = str;
    }

    public void setPosterimage(String str) {
        this.posterimage = str;
    }

    public void setPrevuename(String str) {
        this.prevuename = str;
    }

    public void setRatingid(String str) {
        this.ratingid = str;
    }

    public void setSmallLogo1(String str) {
        this.smallLogo1 = str;
    }

    public void setSmallLogo2(String str) {
        this.smallLogo2 = str;
    }

    public void setSortnum(String str) {
        this.sortnum = str;
    }

    public void setSupporttimeShift(String str) {
        this.supporttimeshift = str;
    }

    public void setSupporttimeshift(String str) {
        this.supporttimeshift = str;
    }

    public void setSystemlimitenable(String str) {
        this.systemlimitenable = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setTimeshiftenable(String str) {
        this.timeshiftenable = str;
    }

    public void setTsavailable(String str) {
        this.tsavailable = str;
    }

    public void setTvCode(String str) {
        this.tvCode = str;
    }

    public void setTvDescription(String str) {
        this.tvDescription = str;
    }

    public void setTvName(String str) {
        this.tvName = str;
    }

    public void setTvOnlyName(String str) {
        this.tvOnlyName = str;
    }

    public void setTvodavailable(String str) {
        this.tvodavailable = str;
    }

    public void setUsermixno(String str) {
        this.usermixno = str;
    }

    public void setUtcbegintime(String str) {
        this.utcbegintime = str;
    }

    public void setUtcendtime(String str) {
        this.utcendtime = str;
    }

    public void setVRFlag(String str) {
        this.vrflag = str;
    }

    public void setVRType(String str) {
        this.vrtype = str;
    }

    public void setVrflag(String str) {
        this.vrflag = str;
    }

    public void setVrtype(String str) {
        this.vrtype = str;
    }

    public void setbegintime(String str) {
        this.begintime = str;
    }

    public Channel() {
        this.liveStreamUrlList = new ArrayList<>();
        this.liveStreamDefinitionList = new ArrayList<>();
    }
}
