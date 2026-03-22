package com.video.androidsdk.common.config;

/* loaded from: classes.dex */
public class ClientRequest {
    int concurrentNum;
    int connectTimeout;
    String dataFrom;
    boolean isReturnRawData;
    int mergeMode;
    String requestClass;
    String requestID;
    String requestMethod;
    String requestNumPerPageKey;
    String requestPageNoKey;
    String requestType;
    String responseClass;
    String responseErrorMsgKey;
    String responseMarkFieldKey;
    String responseReturnCodeKey;
    String responseTotalCountKey;
    String responseType;
    String responseValue;
    String serverUrl;
    int socketTimeout;

    public int getConcurrentNum() {
        return this.concurrentNum;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getDataFrom() {
        return this.dataFrom;
    }

    public int getMergeMode() {
        return this.mergeMode;
    }

    public String getRequestClass() {
        return this.requestClass;
    }

    public String getRequestID() {
        return this.requestID;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getRequestNumPerPageKey() {
        return this.requestNumPerPageKey;
    }

    public String getRequestPageNoKey() {
        return this.requestPageNoKey;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getResponseClass() {
        return this.responseClass;
    }

    public String getResponseErrorMsgKey() {
        return this.responseErrorMsgKey;
    }

    public String getResponseMarkFieldKey() {
        return this.responseMarkFieldKey;
    }

    public String getResponseReturnCodeKey() {
        return this.responseReturnCodeKey;
    }

    public String getResponseTotalCountKey() {
        return this.responseTotalCountKey;
    }

    public String getResponseType() {
        return this.responseType;
    }

    public String getResponseValue() {
        return this.responseValue;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isReturnRawData() {
        return this.isReturnRawData;
    }

    public void setConcurrentNum(int i) {
        this.concurrentNum = i;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setDataFrom(String str) {
        this.dataFrom = str;
    }

    public void setMergeMode(int i) {
        this.mergeMode = i;
    }

    public void setRequestClass(String str) {
        this.requestClass = str;
    }

    public void setRequestID(String str) {
        this.requestID = str;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setRequestNumPerPageKey(String str) {
        this.requestNumPerPageKey = str;
    }

    public void setRequestPageNoKey(String str) {
        this.requestPageNoKey = str;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public void setResponseClass(String str) {
        this.responseClass = str;
    }

    public void setResponseErrorMsgKey(String str) {
        this.responseErrorMsgKey = str;
    }

    public void setResponseMarkFieldKey(String str) {
        this.responseMarkFieldKey = str;
    }

    public void setResponseReturnCodeKey(String str) {
        this.responseReturnCodeKey = str;
    }

    public void setResponseTotalCountKey(String str) {
        this.responseTotalCountKey = str;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }

    public void setResponseValue(String str) {
        this.responseValue = str;
    }

    public void setReturnRawData(boolean z) {
        this.isReturnRawData = z;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }
}
