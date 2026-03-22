package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CommentBean implements Serializable {
    private String commentid = "";
    private String userid = "";
    private String createtime = "";
    private String content = "";
    private String lastreplytime = "";
    private String totalreply = "";
    private String totalpraise = "";
    private List<i> mListReply = new ArrayList();

    public static CommentBean parseJsonToBean(JSONObject jSONObject) {
        JSONArray jSONArray;
        CommentBean commentBean = new CommentBean();
        try {
            commentBean.setCommentid(jSONObject.optString("commentid"));
            commentBean.setUserid(jSONObject.optString(Constants.SINA_WEIBO_UID));
            commentBean.setCreatetime(jSONObject.optString("createtime"));
            commentBean.setContent(jSONObject.optString("content"));
            commentBean.setLastreplytime(jSONObject.optString("lastreplytime"));
            commentBean.setTotalpraise(jSONObject.optString("totalprasie"));
            commentBean.setTotalreply(jSONObject.optString("totalreply"));
            if (Integer.parseInt(jSONObject.optString("totalreply")) > 0 && (jSONArray = jSONObject.getJSONArray("replyinfo")) != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    commentBean.getListReply().add(i.a(jSONArray.getJSONObject(i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.d("ccc", "e = " + e.toString());
        }
        return commentBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(CommentBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(CommentBean.class.getName(), "writeObject");
    }

    public String getCommentid() {
        return this.commentid;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getLastreplytime() {
        return this.lastreplytime;
    }

    public List<i> getListReply() {
        return this.mListReply;
    }

    public String getTotalpraise() {
        return this.totalpraise;
    }

    public String getTotalreply() {
        return this.totalreply;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setCommentid(String str) {
        this.commentid = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public void setLastreplytime(String str) {
        this.lastreplytime = str;
    }

    public void setListReply(List<i> list) {
        this.mListReply = list;
    }

    public void setTotalpraise(String str) {
        this.totalpraise = str;
    }

    public void setTotalreply(String str) {
        this.totalreply = str;
    }

    public void setUserid(String str) {
        this.userid = str;
    }
}
