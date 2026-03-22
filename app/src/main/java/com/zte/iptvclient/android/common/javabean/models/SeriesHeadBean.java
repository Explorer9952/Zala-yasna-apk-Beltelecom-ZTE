package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SeriesHeadBean implements Serializable {
    private String actor;
    private String advertisecontent;
    private String allownettype;
    private String audiolang;
    private String bocode;
    private String bookmarktype;
    private String breakpoint;
    private String cast;
    private String catalogname;
    private String columncode;
    private String contentcode;
    private String contentprodtype;
    private String countryname;
    private String cpcode;
    private String description;
    private String descriptionkey;
    private String director;
    private String elapsedtime;
    private String episodetitle;
    private String genre;
    private String genreidlist;
    private String genrelock;
    private String hastrailer;
    private String iplimitflag;
    private String isfavorite;
    private String isprotection;
    private String issimpletrailer;
    private String language;
    private String mediaservices;
    private String offlinetime;
    private String posterfilelist;
    private String posterpath;
    private String price;
    private String programcode;
    private String programname;
    private String programtype;
    private String pubcompany;
    private String ratingid;
    private String ratingnum;
    private String ratingsum;
    private String releasedate;
    private String seriesnum;
    private String seriesprogramcode;
    private String seriesseason;
    private String seriestype;
    private String shortdesc;
    private String shorttitle;
    private String starlevel;
    private String subgenre;
    private String subtitlelang;
    private String telecomcode;
    private String trailer;
    private String trailerbegintime;
    private String trailerendtime;
    private String updatenum;
    private String videotelecomcode;
    private ArrayList<a> vodInfoList;
    private String vrflag;
    private String vrtype;
    private String writer;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f4756a;

        public String a() {
            return this.f4756a;
        }

        public void b(String str) {
        }

        public void a(String str) {
            this.f4756a = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0107 A[Catch: Exception -> 0x02b3, TryCatch #0 {Exception -> 0x02b3, blocks: (B:3:0x000e, B:6:0x007d, B:7:0x0090, B:10:0x00c6, B:13:0x00d3, B:14:0x00e4, B:16:0x0107, B:17:0x011d, B:18:0x0287, B:20:0x028d, B:22:0x02af, B:26:0x00dd, B:27:0x0089), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x028d A[Catch: Exception -> 0x02b3, LOOP:0: B:18:0x0287->B:20:0x028d, LOOP_END, TryCatch #0 {Exception -> 0x02b3, blocks: (B:3:0x000e, B:6:0x007d, B:7:0x0090, B:10:0x00c6, B:13:0x00d3, B:14:0x00e4, B:16:0x0107, B:17:0x011d, B:18:0x0287, B:20:0x028d, B:22:0x02af, B:26:0x00dd, B:27:0x0089), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean getSeriesHeadBeanFromJSon(org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean.getSeriesHeadBeanFromJSon(org.json.JSONObject):com.zte.iptvclient.android.common.javabean.models.SeriesHeadBean");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(SeriesHeadBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(SeriesHeadBean.class.getName(), "writeObject");
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

    public String getBocode() {
        return this.bocode;
    }

    public String getBookmarktype() {
        return this.bookmarktype;
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getCast() {
        return this.cast;
    }

    public String getCatalogname() {
        return this.catalogname;
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

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionkey() {
        return this.descriptionkey;
    }

    public String getDirector() {
        return this.director;
    }

    public String getElapsedtime() {
        return this.elapsedtime;
    }

    public String getEpisodetitle() {
        return this.episodetitle;
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

    public String getHastrailer() {
        return this.hastrailer;
    }

    public String getIplimitflag() {
        return this.iplimitflag;
    }

    public String getIsfavorite() {
        return this.isfavorite;
    }

    public String getIsprotection() {
        return this.isprotection;
    }

    public String getIssimpletrailer() {
        return this.issimpletrailer;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMediaservices() {
        return this.mediaservices;
    }

    public String getOfflinetime() {
        return this.offlinetime;
    }

    public String getPosterfilelist() {
        return this.posterfilelist;
    }

    public String getPosterpath() {
        return this.posterpath;
    }

    public String getPrice() {
        return this.price;
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

    public String getSeriesnum() {
        return this.seriesnum;
    }

    public String getSeriesprogramcode() {
        return this.seriesprogramcode;
    }

    public String getSeriesseason() {
        return this.seriesseason;
    }

    public String getSeriestype() {
        return this.seriestype;
    }

    public String getShortdesc() {
        return this.shortdesc;
    }

    public String getShorttitle() {
        return this.shorttitle;
    }

    public String getStarlevel() {
        return this.starlevel;
    }

    public String getSubgenre() {
        return this.subgenre;
    }

    public String getSubtitlelang() {
        return this.subtitlelang;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public String getTrailerbegintime() {
        return this.trailerbegintime;
    }

    public String getTrailerendtime() {
        return this.trailerendtime;
    }

    public String getUpdatenum() {
        return this.updatenum;
    }

    public String getVideotelecomcode() {
        return this.videotelecomcode;
    }

    public ArrayList<a> getVodInfoList() {
        return this.vodInfoList;
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

    public void setBocode(String str) {
        this.bocode = str;
    }

    public void setBookmarktype(String str) {
        this.bookmarktype = str;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setCast(String str) {
        this.cast = str;
    }

    public void setCatalogname(String str) {
        this.catalogname = str;
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescriptionkey(String str) {
        this.descriptionkey = str;
    }

    public void setDirector(String str) {
        this.director = str;
    }

    public void setElapsedtime(String str) {
        this.elapsedtime = str;
    }

    public void setEpisodetitle(String str) {
        this.episodetitle = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setGenreidlist(String str) {
        LogEx.d("SeriesHeadBean", "genreidlist: " + str);
        this.genreidlist = str;
    }

    public void setGenrelock(String str) {
        this.genrelock = str;
    }

    public void setHastrailer(String str) {
        this.hastrailer = str;
    }

    public void setIplimitflag(String str) {
        this.iplimitflag = str;
    }

    public void setIsfavorite(String str) {
        this.isfavorite = str;
    }

    public void setIsprotection(String str) {
        this.isprotection = str;
    }

    public void setIssimpletrailer(String str) {
        this.issimpletrailer = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMediaservices(String str) {
        this.mediaservices = str;
    }

    public void setOfflinetime(String str) {
        this.offlinetime = str;
    }

    public void setPosterfilelist(String str) {
        this.posterfilelist = str;
    }

    public void setPosterpath(String str) {
        this.posterpath = str;
    }

    public void setPrice(String str) {
        this.price = str;
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

    public void setSeriesnum(String str) {
        this.seriesnum = str;
    }

    public void setSeriesprogramcode(String str) {
        this.seriesprogramcode = str;
    }

    public void setSeriesseason(String str) {
        this.seriesseason = str;
    }

    public void setSeriestype(String str) {
        this.seriestype = str;
    }

    public void setShortdesc(String str) {
        this.shortdesc = str;
    }

    public void setShorttitle(String str) {
        this.shorttitle = str;
    }

    public void setStarlevel(String str) {
        this.starlevel = str;
    }

    public void setSubgenre(String str) {
        this.subgenre = str;
    }

    public void setSubtitlelang(String str) {
        this.subtitlelang = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setTrailer(String str) {
        this.trailer = str;
    }

    public void setTrailerbegintime(String str) {
        this.trailerbegintime = str;
    }

    public void setTrailerendtime(String str) {
        this.trailerendtime = str;
    }

    public void setUpdatenum(String str) {
        this.updatenum = str;
    }

    public void setVideotelecomcode(String str) {
        this.videotelecomcode = str;
    }

    public void setVodInfoList(ArrayList<a> arrayList) {
        this.vodInfoList = arrayList;
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
        return "SeriesHeadBean{programcode='" + this.programcode + "', programname='" + this.programname + "', programtype='" + this.programtype + "', contentcode='" + this.contentcode + "', seriesprogramcode='" + this.seriesprogramcode + "', mediaservices='" + this.mediaservices + "', ratingid='" + this.ratingid + "', price='" + this.price + "', offlinetime='" + this.offlinetime + "', countryname='" + this.countryname + "', issimpletrailer='" + this.issimpletrailer + "', telecomcode='" + this.telecomcode + "', trailerbegintime='" + this.trailerbegintime + "', trailerendtime='" + this.trailerendtime + "', seriesnum='" + this.seriesnum + "', updatenum='" + this.updatenum + "', posterfilelist='" + this.posterfilelist + "', posterpath='" + this.posterpath + "', description='" + this.description + "', director='" + this.director + "', actor='" + this.actor + "', iplimitflag='" + this.iplimitflag + "', columncode='" + this.columncode + "', catalogname='" + this.catalogname + "', descriptionkey='" + this.descriptionkey + "', advertisecontent='" + this.advertisecontent + "', releasedate='" + this.releasedate + "', writer='" + this.writer + "', audiolang='" + this.audiolang + "', subtitlelang='" + this.subtitlelang + "', seriesseason='" + this.seriesseason + "', genre='" + this.genre + "', subgenre='" + this.subgenre + "', shortdesc='" + this.shortdesc + "', shorttitle='" + this.shorttitle + "', elapsedtime='" + this.elapsedtime + "', starlevel='" + this.starlevel + "', isprotection='" + this.isprotection + "', language='" + this.language + "', episodetitle='" + this.episodetitle + "', breakpoint='" + this.breakpoint + "', bookmarktype='" + this.bookmarktype + "', ratingnum='" + this.ratingnum + "', ratingsum='" + this.ratingsum + "', isfavorite='" + this.isfavorite + "', hastrailer='" + this.hastrailer + "', cpcode='" + this.cpcode + "', bocode='" + this.bocode + "', trailer='" + this.trailer + "', vrflag='" + this.vrflag + "', vrtype='" + this.vrtype + "', contentprodtype='" + this.contentprodtype + "', cast='" + this.cast + "', allownettype='" + this.allownettype + "', genrelock='" + this.genrelock + "', seriestype='" + this.seriestype + "', genreidlist='" + this.genreidlist + "'}";
    }
}
