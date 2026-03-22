package com.zte.iptvclient.android.common.javabean;

import android.net.Uri;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Comment implements Serializable {
    private String comments;
    private String commentsid;
    private String programcode;
    private String publishdate;
    private String usercode;

    public static Comment parseJsonToBean(JSONObject jSONObject) {
        Comment comment = new Comment();
        try {
            comment.setUsercode(com.zte.iptvclient.android.common.k.a.a(URLDecoder.decode(jSONObject.optString("usercode"), "UTF-8"), AES.getEncryptKey("impkey").getBytes("UTF-8")));
            comment.setComments(Uri.decode(jSONObject.optString("comments")));
            comment.setPublishdate(jSONObject.optString("publishdate"));
            comment.setProgramcode(jSONObject.optString("programcode"));
            comment.setCommentsid(jSONObject.optString("commentsid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(Comment.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(Comment.class.getName(), "writeObject");
    }

    public String getComments() {
        return this.comments;
    }

    public String getCommentsid() {
        return this.commentsid;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getPublishdate() {
        return this.publishdate;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public void setCommentsid(String str) {
        this.commentsid = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setPublishdate(String str) {
        this.publishdate = str;
    }

    public void setUsercode(String str) {
        this.usercode = str;
    }
}
