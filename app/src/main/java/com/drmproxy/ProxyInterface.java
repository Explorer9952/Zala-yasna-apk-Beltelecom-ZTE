package com.drmproxy;

/* loaded from: classes.dex */
public class ProxyInterface {
    private ClientToProxyCallBack ClientObject;

    /* loaded from: classes.dex */
    public interface ClientToProxyCallBack {
        void ReportDeleteFileResult(String str);

        void ReportDownloadInfo(String str);

        void ReportPlayError(String str);

        void ReportQueryResolution(String str);

        void ReportUpdatekeyResult(String str);
    }

    public native void ChangeVideoStorePath(String str);

    public native void ClearExpiredData(String str);

    public native void DeleteFile(int i);

    public native void DeleteFile(String str);

    public native void DeleteFile(String str, String str2);

    public native int DownLoadVideo(String str);

    public native int DownLoadVideo(String str, String str2);

    public native int DownLoadVideo(String str, String str2, String str3);

    public native int DownLoadVideo(String str, String str2, String str3, String str4);

    public native int DownLoadVideo(String str, String str2, String str3, String str4, String str5);

    public native int GetAvailableSpace(String str);

    public native int GetFreeSpace(String str);

    public native int GetTotalSpace(String str);

    public native int InitDrm();

    public native void InitJavaCallBack();

    public native int InitProxyServer(String str, int i, String str2, String str3, String str4, String str5, boolean z);

    public native void QueryDownloadTaskInfo(String str);

    public native String QueryPathOfVideoInfo(String str);

    public native boolean QueryProxyState();

    public native int QueryResolution(String str);

    public native String QueryVideoExpiration(String str);

    public native String QueryVideoInfo(String str);

    public native int ReStartHttpServer();

    public native void ReleasePlayResource();

    public native String ReportAllDownloadInfo();

    public native String ReportAllDownloadInfo(int i, String str);

    public void ReportDeleteFileResult(String str) {
        ClientToProxyCallBack clientToProxyCallBack = this.ClientObject;
        if (clientToProxyCallBack != null) {
            clientToProxyCallBack.ReportDeleteFileResult(str);
        } else {
            System.out.println("ClientObject is null");
        }
    }

    public void ReportDownloadInfo(String str) {
        ClientToProxyCallBack clientToProxyCallBack = this.ClientObject;
        if (clientToProxyCallBack != null) {
            clientToProxyCallBack.ReportDownloadInfo(str);
        } else {
            System.out.println("ClientObject is null");
        }
    }

    public void ReportPlayError(String str) {
        ClientToProxyCallBack clientToProxyCallBack = this.ClientObject;
        if (clientToProxyCallBack != null) {
            clientToProxyCallBack.ReportPlayError(str);
        } else {
            System.out.println("ClientObject is null");
        }
    }

    public void ReportQueryResolution(String str) {
        ClientToProxyCallBack clientToProxyCallBack = this.ClientObject;
        if (clientToProxyCallBack != null) {
            clientToProxyCallBack.ReportQueryResolution(str);
        } else {
            System.out.println("ClientObject is null");
        }
    }

    public void ReportUpdatekeyResult(String str) {
        ClientToProxyCallBack clientToProxyCallBack = this.ClientObject;
        if (clientToProxyCallBack != null) {
            clientToProxyCallBack.ReportUpdatekeyResult(str);
        } else {
            System.out.println("ClientObject is null");
        }
    }

    public native void SetAllStorePath(String str);

    public void SetBuildVersion(int i) {
        System.out.println("--------proxy iBuildVersion=" + i);
        if (i >= 23) {
            System.out.println("--------proxy load v7");
            System.loadLibrary("multicastsdkinterface");
            System.loadLibrary("HttpProxyServer_v7");
            System.loadLibrary("server-jni_v7");
            return;
        }
        System.out.println("--------proxy load normal");
        System.loadLibrary("multicastsdkinterface");
        System.loadLibrary("HttpProxyServer");
        System.loadLibrary("server-jni");
    }

    public native void SetCallBackClass(String str);

    public native void SetDownloadParameter(String str);

    public native void SetDownloadRate(int i);

    public native void SetLogLevel(int i);

    public native void SetSpaceThreshold(int i);

    public native int StartHttpProxyServer();

    public native void StopHttpProxyServer();

    public native void StopVideoDownload(String str);

    public native void UnInitProxyServer();

    public native void UpdateKey(String str);

    public native int UpdateUrl(String str, String str2, String str3);

    public native void UpdateVideoInfo(String str, String str2);

    public void setCallBackObject(ClientToProxyCallBack clientToProxyCallBack) {
        System.out.println("setCallBackObject");
        this.ClientObject = clientToProxyCallBack;
    }
}
