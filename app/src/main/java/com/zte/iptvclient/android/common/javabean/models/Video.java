package com.zte.iptvclient.android.common.javabean.models;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.common.video.VoD;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Video implements Serializable {
    Date ExpiredTime;
    String actor;
    String actorcode;
    String adContent;
    String authReturncode;
    String bigImg1;
    String bigImg2;
    String boCode;
    String breakpoint;
    String categoryCode;
    String clipCode;
    String columncode;
    String contentCode;
    String contentType;
    String copyright;
    String cpCode;
    String definition;
    String description;
    String director;
    String directorcode;
    String doubanrate;
    HashMap<String, String> downloadUrl;
    String endTime;
    String favoritetype;
    String genre;
    String horizonposterimg;
    String id;
    String isTrailer;
    String isdrm;
    String isprotection;
    String itemCode;
    String language;
    String length;
    String packageCode;
    String packageType;
    String parentCategory;
    String posterImg;
    String posterfilelist;
    String price;
    String productId;
    String productType;
    String programtype;
    String ratingid;
    String ratingnum;
    String ratingsum;
    String region;
    String releasedate;
    String releaseyear;
    String rentalTerm;
    String seriesnum;
    String shortTitle;
    String singercode;
    String smallImg1;
    String smallImg2;
    String starlevel;
    String startTime;
    String stramUrl;
    String telecomcode;
    String thumbs;
    String title;
    String trailer;
    String type;
    String updatenum;
    String userId;
    String videoelapsedtime;
    String vrflag;
    String webUrl;
    String wgkeywords;
    String writer;
    String year;

    public static final Video fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Video video = new Video();
        video.setProgramtype(jSONObject.optString("programtype"));
        video.setActor(jSONObject.optString("actor"));
        video.setBigImg1(jSONObject.optString("big_img1"));
        video.setBigImg2(jSONObject.optString("big_img2"));
        video.setCategoryCode(jSONObject.optString("category_code"));
        video.setVideoPosterfileList(jSONObject.optString("posterfilelist"));
        video.setShortTitle(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
        video.setGenre(jSONObject.optString("genre"));
        video.setId(jSONObject.optString("id"));
        video.setDescription(jSONObject.optString("description"));
        video.setLanguage(jSONObject.optString("language"));
        video.setLength(jSONObject.optString(com.video.androidsdk.common.ParamConst.DLNA_SENDDMRCONTENT_REQ_LENGTH));
        video.setPosterImg(jSONObject.optString("poster_img"));
        video.setRegion(jSONObject.optString(TtmlNode.TAG_REGION));
        video.setSmallImg1(jSONObject.optString("small_img1"));
        video.setSmallImg2(jSONObject.optString("small_img2"));
        video.setStramUrl(jSONObject.optString("stream_url"));
        video.setTrailer(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER));
        video.setTitle(jSONObject.optString("title"));
        video.setYear(jSONObject.optString("year"));
        video.setClipCode(jSONObject.optString("clipcode"));
        video.setItemCode(jSONObject.optString("itemcode"));
        video.setPackageCode(jSONObject.optString("package_code"));
        video.setPackageType(jSONObject.optString("package"));
        video.setPrice(jSONObject.optString("price"));
        video.setDirector(jSONObject.optString("director"));
        video.setWebUrl(jSONObject.optString(MessengerShareContentUtility.BUTTON_URL_TYPE));
        video.setRatingnum(jSONObject.optString("ratingnum"));
        video.setRatingsum(jSONObject.optString("ratingsum"));
        video.setRatingID(jSONObject.optString("ratingid"));
        video.setStarLevel(jSONObject.optString("starlevel"));
        video.setUpdatenum(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM));
        video.setSeriesnum(jSONObject.optString("seriesnum"));
        video.setWgkeywords(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
        video.setConntentType(jSONObject.optString(ParamConst.ITEMCODE_TO_TELECODE_RSP_CONTENTTYPE));
        video.setIsdrm(jSONObject.optString("isdrm"));
        video.setAuthReturncode(jSONObject.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
        video.setTelecomcode(jSONObject.optString("telecomcode"));
        video.setBoCode(jSONObject.optString("bocode"));
        video.setCpCode(jSONObject.optString("cpcode"));
        video.setCopyright(jSONObject.optString("isprotection"));
        video.setDefinition(jSONObject.optString("definition"));
        video.setActorcode(jSONObject.optString("actorcode"));
        video.setDirectorcode(jSONObject.optString("directorcode"));
        video.setSingercode(jSONObject.optString("singercode"));
        video.setVrflag(jSONObject.optString("vrflag"));
        video.setContentCode(jSONObject.optString("contentcode"));
        video.setVideoReleaseDate(jSONObject.optString(ParamConst.CHANNEL_PREVUE_INFO_RSP_RELEASEYEAR));
        video.setFavoritetype(jSONObject.optString("favoritetype"));
        video.setWriter(jSONObject.optString("writer"));
        video.setIsTrailer(jSONObject.optString("isottcontent"));
        video.setAdContent(jSONObject.optString("advertisecontent"));
        video.setIsprotection(jSONObject.optString("isprotection"));
        video.setParentCategory(jSONObject.optString("parent_category_code"));
        return video;
    }

    public static final Video fromJsonToCommendVideo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Video video = new Video();
        video.setId(jSONObject.optString("programcode"));
        video.setTitle(jSONObject.optString("programname"));
        video.setShortTitle(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
        video.setCategoryCode(jSONObject.optString("columncode"));
        video.setContentCode(jSONObject.optString("contentcode"));
        video.setPosterImg(jSONObject.optString("poster4"));
        video.setHorizonposterimg(jSONObject.optString("poster6"));
        video.setRatingnum(jSONObject.optString("ratingnum"));
        video.setRatingsum(jSONObject.optString("ratingsum"));
        video.setRatingID(jSONObject.optString("ratingid"));
        video.setProgramtype(jSONObject.optString("programtype"));
        video.setStarLevel(jSONObject.optString("starlevel"));
        video.setVrflag(jSONObject.optString("vrflag"));
        video.setIsprotection(jSONObject.optString("isprotection"));
        video.setTelecomcode(jSONObject.optString("telecomcode"));
        video.setUpdatenum(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM));
        video.setSeriesnum(jSONObject.optString("seriesnum"));
        video.setWgkeywords(jSONObject.optString(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
        return video;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(Video.class.getName(), "readObject");
    }

    public static Video switchSeriesToVideo(VoD voD) {
        if (voD == null) {
            return null;
        }
        Video video = new Video();
        if (!TextUtils.isEmpty(voD.getProgramCode())) {
            video.setId(voD.getProgramCode());
        }
        if (!TextUtils.isEmpty(voD.getColumnCode())) {
            video.setCategoryCode(voD.getColumnCode());
        }
        if (!TextUtils.isEmpty(voD.getProgramName())) {
            video.setTitle(voD.getProgramName());
        }
        if (!TextUtils.isEmpty(voD.getDirector())) {
            video.setDirector(voD.getDirector());
        }
        if (!TextUtils.isEmpty(voD.getActor())) {
            video.setActor(voD.getActor());
        }
        if (!TextUtils.isEmpty(voD.getDescription())) {
            video.setDescription(voD.getDescription());
        }
        if (!TextUtils.isEmpty(voD.getProgramType())) {
            video.setProgramtype(voD.getProgramType());
        }
        if (!TextUtils.isEmpty(voD.getGenre())) {
            video.setGenre(voD.getGenre());
        }
        if (!TextUtils.isEmpty(voD.getCpCode())) {
            video.setCpCode(voD.getCpCode());
        }
        if (!TextUtils.isEmpty(voD.getBoCode())) {
            video.setBoCode(voD.getBoCode());
        }
        if (!TextUtils.isEmpty(voD.getContentCode())) {
            video.setContentCode(voD.getContentCode());
        }
        if (!TextUtils.isEmpty(voD.getProgramType())) {
            video.setConntentType(voD.getProgramType());
        }
        if (!TextUtils.isEmpty(voD.getRatingNum())) {
            video.setRatingnum(voD.getRatingNum());
        }
        if (!TextUtils.isEmpty(voD.getRatingSum())) {
            video.setRatingsum(voD.getRatingSum());
        }
        if (!TextUtils.isEmpty(voD.getTelecomCode())) {
            video.setTelecomcode(voD.getTelecomCode());
        }
        if (!TextUtils.isEmpty(voD.getTrailer())) {
            video.setTrailer(voD.getTrailer());
        }
        if (voD.isProtection()) {
            video.setIsprotection("1");
            return video;
        }
        video.setIsprotection("0");
        return video;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(Video.class.getName(), "writeObject");
    }

    public String getActor() {
        return this.actor;
    }

    public String getActorcode() {
        return this.actorcode;
    }

    public String getAdContent() {
        return this.adContent;
    }

    public String getAuthReturncode() {
        return this.authReturncode;
    }

    public String getBigImg1() {
        return this.bigImg1;
    }

    public String getBigImg2() {
        return this.bigImg2;
    }

    public String getBoCode() {
        return this.boCode;
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getCategoryCode() {
        return this.categoryCode;
    }

    public String getClipCode() {
        return this.clipCode;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getConntentType() {
        return this.contentType;
    }

    public String getContentCode() {
        return this.contentCode;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public String getCpCode() {
        return this.cpCode;
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

    public String getDirectorcode() {
        return this.directorcode;
    }

    public String getDoubanrate() {
        return this.doubanrate;
    }

    public HashMap<String, String> getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public Date getExpiredTime() {
        return this.ExpiredTime;
    }

    public String getFavoritetype() {
        return this.favoritetype;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getHorizonposterimg() {
        return this.horizonposterimg;
    }

    public String getId() {
        return this.id;
    }

    public String getIsTrailer() {
        return this.isTrailer;
    }

    public String getIsdrm() {
        return this.isdrm;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLength() {
        return this.length;
    }

    public String getPackageCode() {
        return this.packageCode;
    }

    public String getPackageType() {
        return this.packageType;
    }

    public String getParentCategory() {
        return this.parentCategory;
    }

    public String getPosterImg() {
        return this.posterImg;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProgramtype() {
        return this.programtype;
    }

    public String getRatingID() {
        return this.ratingid;
    }

    public String getRatingnum() {
        return this.ratingnum;
    }

    public String getRatingsum() {
        return this.ratingsum;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRentalTerm() {
        return this.rentalTerm;
    }

    public String getSeriesnum() {
        return this.seriesnum;
    }

    public String getShortTitle() {
        return this.shortTitle;
    }

    public String getSingercode() {
        return this.singercode;
    }

    public String getSmallImg1() {
        return this.smallImg1;
    }

    public String getSmallImg2() {
        return this.smallImg2;
    }

    public String getStarLevel() {
        return this.starlevel;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getStramUrl() {
        return this.stramUrl;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getThumbs() {
        return this.thumbs;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public String getType() {
        return this.type;
    }

    public String getUpdatenum() {
        return this.updatenum;
    }

    public String getVideoPosterfileList() {
        return this.posterfilelist;
    }

    public String getVideoReleaseDate() {
        return this.releasedate;
    }

    public String getVideoReleaseTime() {
        return this.releaseyear;
    }

    public String getVideoelapsedtime() {
        return this.videoelapsedtime;
    }

    public String getVrflag() {
        return this.vrflag;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getWgkeywords() {
        return this.wgkeywords;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getYear() {
        return this.year;
    }

    public String getproductId() {
        return this.productId;
    }

    public String getproductType() {
        return this.productType;
    }

    public String getuserId() {
        return this.userId;
    }

    public void setActor(String str) {
        this.actor = str;
    }

    public void setActorcode(String str) {
        this.actorcode = str;
    }

    public void setAdContent(String str) {
        this.adContent = str;
    }

    public void setAuthReturncode(String str) {
        this.authReturncode = str;
    }

    public void setBigImg1(String str) {
        this.bigImg1 = str;
    }

    public void setBigImg2(String str) {
        this.bigImg2 = str;
    }

    public void setBoCode(String str) {
        this.boCode = str;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setCategoryCode(String str) {
        this.categoryCode = str;
    }

    public void setClipCode(String str) {
        this.clipCode = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setConntentType(String str) {
        this.contentType = str;
    }

    public void setContentCode(String str) {
        this.contentCode = str;
    }

    public void setCopyright(String str) {
        this.copyright = str;
    }

    public void setCpCode(String str) {
        this.cpCode = str;
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

    public void setDirectorcode(String str) {
        this.directorcode = str;
    }

    public void setDoubanrate(String str) {
        this.doubanrate = str;
    }

    public void setDownloadUrl(HashMap<String, String> hashMap) {
        this.downloadUrl = hashMap;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setExpiredTime(Date date) {
        this.ExpiredTime = date;
    }

    public void setFavoritetype(String str) {
        this.favoritetype = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setHorizonposterimg(String str) {
        this.horizonposterimg = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsTrailer(String str) {
        this.isTrailer = str;
    }

    public void setIsdrm(String str) {
        this.isdrm = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setItemCode(String str) {
        this.itemCode = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLength(String str) {
        this.length = str;
    }

    public void setPackageCode(String str) {
        this.packageCode = str;
    }

    public void setPackageType(String str) {
        this.packageType = str;
    }

    public void setParentCategory(String str) {
        this.parentCategory = str;
    }

    public void setPosterImg(String str) {
        this.posterImg = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProgramtype(String str) {
        this.programtype = str;
    }

    public void setRatingID(String str) {
        this.ratingid = str;
    }

    public void setRatingnum(String str) {
        this.ratingnum = str;
    }

    public void setRatingsum(String str) {
        this.ratingsum = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRentalTerm(String str) {
        this.rentalTerm = str;
    }

    public void setSeriesnum(String str) {
        this.seriesnum = str;
    }

    public void setShortTitle(String str) {
        this.shortTitle = str;
    }

    public void setSingercode(String str) {
        this.singercode = str;
    }

    public void setSmallImg1(String str) {
        this.smallImg1 = str;
    }

    public void setSmallImg2(String str) {
        this.smallImg2 = str;
    }

    public void setStarLevel(String str) {
        this.starlevel = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setStramUrl(String str) {
        this.stramUrl = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setThumbs(String str) {
        this.thumbs = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrailer(String str) {
        this.trailer = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdatenum(String str) {
        this.updatenum = str;
    }

    public void setVideoPosterfileList(String str) {
        this.posterfilelist = str;
    }

    public void setVideoReleaseDate(String str) {
        this.releasedate = str;
    }

    public void setVideoReleaseTime(String str) {
        this.releaseyear = str;
    }

    public void setVideoelapsedtime(String str) {
        this.videoelapsedtime = str;
    }

    public void setVrflag(String str) {
        this.vrflag = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setWgkeywords(String str) {
        this.wgkeywords = str;
    }

    public void setWriter(String str) {
        this.writer = str;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public void setproductId(String str) {
        this.productId = str;
    }

    public void setproductType(String str) {
        this.productType = str;
    }

    public void setuserId(String str) {
        this.userId = str;
    }
}
