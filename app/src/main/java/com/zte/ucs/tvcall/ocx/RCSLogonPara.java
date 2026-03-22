package com.zte.ucs.tvcall.ocx;

import android.os.Build;

/* loaded from: classes2.dex */
public class RCSLogonPara {
    public int iRegTermianlType;
    public long lSipPort;
    public long lXcapPort;
    public String szDomain;
    public String szIMPI;
    public String szIMPU;
    public String szPassword;
    public String szSipIP;
    public String szVersion;
    public String szXcapIP;

    public RCSLogonPara(String str, String str2, String str3, String str4, long j, String str5, int i, String str6) {
        this.szIMPU = str;
        this.szIMPI = str2;
        this.szPassword = str3;
        this.szSipIP = str4;
        this.lSipPort = j;
        this.szXcapIP = str4;
        this.lXcapPort = j;
        this.szVersion = Build.VERSION.RELEASE;
        this.szDomain = str5;
        this.iRegTermianlType = i;
        this.szVersion = str6;
    }
}
