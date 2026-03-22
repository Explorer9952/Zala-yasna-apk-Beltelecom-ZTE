package com.video.androidsdk.cast.bean;

import com.video.androidsdk.common.BaseResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes.dex */
public class DLNAEvent extends BaseResponse {
    public static final String EVENT_BROWSE_COMPLETE = "dlna.browse.complete";
    public static final String EVENT_CREATE_OBJECT_COMPLETE = "dlna.createobject.complete";
    public static final String EVENT_DESTORY_OBJECT_COMPLETE = "dlna.destoryobject.complete";
    public static final String EVENT_DEVICE_AUTHFAILED = "event.device.authfailed";
    public static final String EVENT_DEVICE_OFFLINE = "dlna.device.offline";
    public static final String EVENT_DEVICE_ONLINE = "dlna.device.online";
    public static final String EVENT_DMR_OFFLINE = "dlna.dmr.offline";
    public static final String EVENT_DMR_ONLINE = "dlna.dmr.online";
    public static final String EVENT_DMS_OFFLINE = "dlna.dms.offline";
    public static final String EVENT_DMS_ONLINE = "dlna.dms.online";
    public static final String EVENT_INIT_COMPLETE = "dlna.init.complete";
    public static final String EVENT_INIT_FAILED = "dlna.initilize.failed";
    public static final String EVENT_PAUSE_COMPLETE = "dlna.pause.complete";
    public static final String EVENT_PLAY_COMPLETE = "dlna.play.complete";
    public static final String EVENT_SEARCH_TIMEOUT = "dlna.search.timeout";
    public static final String EVENT_STOP_COMPLETE = "dlna.stop.complete";
    public static final String EVENT_STORAGE_INFO_COMPLETE = "dlna.storageinfo.complete";
    public static final String EVENT_UNKNOWN = "actionevent.unknown";
    public static final String NOTIFY_GEBOOKMARK_COMPLETE = "dlna.bookmark.complete";
    public static final String NOTIFY_GETCURRENTCHANNELINFO_COMPLETE = "dlna.currentchannelinfo.complete";
    public static final String NOTIFY_GETCURRENTPOSITIONINFO_COMPLETE = "dlna.currentpositioninfo.complete";
    public static final String NOTIFY_GETCURRENTTRANSPORTINFO_COMPLETE = "dlna.currenttransportinfo.complete";
    public static final String NOTIFY_GETCURRENTVOLUME_COMPLETE = "dlna.currentchannelinfo.complete";
    public static final String NOTIFY_GETVOLUMERANGE_COMPLETE = "dlna.volumerange.complete";
    private String arg0;
    private String arg1;
    private String event;
    private Object object;

    public DLNAEvent(String str, String str2, String str3, Object obj) {
        this.event = "";
        this.arg0 = "";
        this.arg1 = "";
        this.object = null;
        this.event = str;
        this.arg0 = str2;
        this.arg1 = str3;
        this.object = obj;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
    }

    public String getArg0() {
        return this.arg0;
    }

    public String getArg1() {
        return this.arg1;
    }

    public String getEvent() {
        return this.event;
    }

    public Object getObject() {
        return this.object;
    }

    public void setArg0(String str) {
        this.arg0 = str;
    }

    public void setArg1(String str) {
        this.arg1 = str;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }
}
