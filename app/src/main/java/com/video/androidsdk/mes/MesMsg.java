package com.video.androidsdk.mes;

/* loaded from: classes.dex */
public class MesMsg {
    MsgBody msgbody;
    MsgHead msghead;

    /* loaded from: classes.dex */
    public static class MsgBody {
        String content;
        String msgcode;

        public MsgBody(String str, String str2) {
            this.msgcode = str;
            this.content = str2;
        }

        public String getContent() {
            return this.content;
        }

        public String getMsgcode() {
            return this.msgcode;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setMsgcode(String str) {
            this.msgcode = str;
        }
    }

    /* loaded from: classes.dex */
    public static class MsgHead {
        String msgtype;
        String version;

        public MsgHead(String str, String str2) {
            this.version = str;
            this.msgtype = str2;
        }

        public String getMsgtype() {
            return this.msgtype;
        }

        public String getVersion() {
            return this.version;
        }

        public void setMsgtype(String str) {
            this.msgtype = str;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public MsgBody getMsgbody() {
        return this.msgbody;
    }

    public MsgHead getMsghead() {
        return this.msghead;
    }

    public void setMsgbody(MsgBody msgBody) {
        this.msgbody = msgBody;
    }

    public void setMsghead(MsgHead msgHead) {
        this.msghead = msgHead;
    }
}
