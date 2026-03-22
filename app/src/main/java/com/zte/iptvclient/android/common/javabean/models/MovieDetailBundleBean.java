package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class MovieDetailBundleBean implements Serializable {
    public static String MOVIE_BUNDLEPARAMS_ISOTTFLAG = "isOttFlag";
    public static String MOVIE_BUNDLEPARAMS_PROGRAMCODE = "programcode";
    public static String MOVIE_BUNDLEPARAM_COLUMNCODE = "columncode";
    public static String MOVIE_BUNDLEPARAM_RECOMMENDTYPE = "recommendtype";
    public static String SERIES_BUNDLEPARAMS_SERIES_NUM = "seriesnumber";
    private String columncode;
    private String isOttFlag;
    private String programcode;
    private String recommendtype;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(MovieDetailBundleBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(MovieDetailBundleBean.class.getName(), "writeObject");
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getIsOttFlag() {
        return this.isOttFlag;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getRecommendtype() {
        return this.recommendtype;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setIsOttFlag(String str) {
        this.isOttFlag = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setRecommendtype(String str) {
        this.recommendtype = str;
    }
}
