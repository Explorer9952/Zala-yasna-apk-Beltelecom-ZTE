package com.zte.ucs.tvcall.ocx.xcap;

/* loaded from: classes2.dex */
public class XCAPReqInfo {
    private int content_Length;
    private byte iSslFlag;
    private byte isKeepAlive;
    private int serverPort;
    private String method = "";
    private String username = "";
    private String password = "";
    private String content_Type = "";
    private String uri = "";
    private String etag = "";
    private String serverAddr = "";
    private String authToken = "";
    private String body = "";

    public String getAuthToken() {
        return this.authToken;
    }

    public String getBody() {
        return this.body;
    }

    public int getContent_Length() {
        return this.content_Length;
    }

    public String getContent_Type() {
        return this.content_Type;
    }

    public String getEtag() {
        return this.etag;
    }

    public byte getIsKeepAlive() {
        return this.isKeepAlive;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPassword() {
        return this.password;
    }

    public String getServerAddr() {
        return this.serverAddr;
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUsername() {
        return this.username;
    }

    public byte getiSslFlag() {
        return this.iSslFlag;
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setContent_Length(int i) {
        this.content_Length = i;
    }

    public void setContent_Type(String str) {
        this.content_Type = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setIsKeepAlive(byte b2) {
        this.isKeepAlive = b2;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setServerAddr(String str) {
        this.serverAddr = str;
    }

    public void setServerPort(int i) {
        this.serverPort = i;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setiSslFlag(byte b2) {
        this.iSslFlag = b2;
    }
}
