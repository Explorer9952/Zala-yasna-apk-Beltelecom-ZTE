package com.zte.iptvclient.android.mobile.vod.entity;

import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GetVodDetailWithUrlEntity implements Serializable {
    public HashMap<String, String> downLoadURL = new HashMap<>();
    public ArrayList<VideoDetailBean> videoDetailList = new ArrayList<>();

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(GetVodDetailWithUrlEntity.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(GetVodDetailWithUrlEntity.class.getName(), "writeObject");
    }
}
