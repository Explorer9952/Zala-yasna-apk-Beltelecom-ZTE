package com.video.androidsdk.cast.bean.currentinfo.mediainfo;

/* loaded from: classes.dex */
public class response {
    String CurrentURI;
    String CurrentURIMetaData;
    String MediaDuration;
    String NextURI;
    String NextURIMetaData;
    String NrTracks;
    String PlayMedium;
    String RecordMedium;
    String WriteStatus;
    String errormsg;
    String returncode;

    public String getCurrentURI() {
        return this.CurrentURI;
    }

    public String getCurrentURIMetaData() {
        return this.CurrentURIMetaData;
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public String getMediaDuration() {
        return this.MediaDuration;
    }

    public String getNextURI() {
        return this.NextURI;
    }

    public String getNextURIMetaData() {
        return this.NextURIMetaData;
    }

    public String getNrTracks() {
        return this.NrTracks;
    }

    public String getPlayMedium() {
        return this.PlayMedium;
    }

    public String getRecordMedium() {
        return this.RecordMedium;
    }

    public String getReturncode() {
        return this.returncode;
    }

    public String getWriteStatus() {
        return this.WriteStatus;
    }

    public void setCurrentURI(String str) {
        this.CurrentURI = str;
    }

    public void setCurrentURIMetaData(String str) {
        this.CurrentURIMetaData = str;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setMediaDuration(String str) {
        this.MediaDuration = str;
    }

    public void setNextURI(String str) {
        this.NextURI = str;
    }

    public void setNextURIMetaData(String str) {
        this.NextURIMetaData = str;
    }

    public void setNrTracks(String str) {
        this.NrTracks = str;
    }

    public void setPlayMedium(String str) {
        this.PlayMedium = str;
    }

    public void setRecordMedium(String str) {
        this.RecordMedium = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setWriteStatus(String str) {
        this.WriteStatus = str;
    }
}
