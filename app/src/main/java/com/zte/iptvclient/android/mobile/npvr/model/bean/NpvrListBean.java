package com.zte.iptvclient.android.mobile.npvr.model.bean;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class NpvrListBean {
    private List<String> begintime;
    private List<String> channelcode;
    private List<String> channelname;
    private List<String> definition;
    private List<String> duration;
    private List<String> endtime;
    private String errormsg;
    private List<String> filename;
    private List<String> isseries;
    private ArrayList<NpvrBean> mDataList;
    private List<String> mediaservice;
    private List<String> npvrcode;
    private List<String> prevuecode;
    private List<String> prevuename;
    private List<String> ratingid;
    private String returncode;
    private List<String> seriesheadid;
    private List<String> status;
    private String totalcount;

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026 A[LOOP:0: B:5:0x0024->B:6:0x0026, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dataParseToBeanList() {
        /*
            r21 = this;
            r1 = r21
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.mDataList = r0
            java.lang.String r0 = r1.totalcount
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r0 = r1.totalcount     // Catch: java.lang.Exception -> L19
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L19
            goto L24
        L19:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "NpvrListBean"
            com.video.androidsdk.log.LogEx.d(r3, r0)
        L23:
            r0 = 0
        L24:
            if (r2 >= r0) goto Lcd
            com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean r15 = new com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean
            java.util.List<java.lang.String> r3 = r1.seriesheadid
            java.lang.Object r3 = r3.get(r2)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            java.util.List<java.lang.String> r3 = r1.channelcode
            java.lang.Object r3 = r3.get(r2)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            java.util.List<java.lang.String> r3 = r1.channelname
            java.lang.Object r3 = r3.get(r2)
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            java.util.List<java.lang.String> r3 = r1.prevuecode
            java.lang.Object r3 = r3.get(r2)
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            java.util.List<java.lang.String> r3 = r1.prevuename
            java.lang.Object r3 = r3.get(r2)
            r8 = r3
            java.lang.String r8 = (java.lang.String) r8
            java.util.List<java.lang.String> r3 = r1.filename
            java.lang.Object r3 = r3.get(r2)
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            java.util.List<java.lang.String> r3 = r1.begintime
            java.lang.Object r3 = r3.get(r2)
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            java.util.List<java.lang.String> r3 = r1.endtime
            java.lang.Object r3 = r3.get(r2)
            r11 = r3
            java.lang.String r11 = (java.lang.String) r11
            java.util.List<java.lang.String> r3 = r1.isseries
            java.lang.Object r3 = r3.get(r2)
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
            java.util.List<java.lang.String> r3 = r1.duration
            java.lang.Object r3 = r3.get(r2)
            r13 = r3
            java.lang.String r13 = (java.lang.String) r13
            java.util.List<java.lang.String> r3 = r1.mediaservice
            java.lang.Object r3 = r3.get(r2)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            java.util.List<java.lang.String> r3 = r1.definition
            java.lang.Object r3 = r3.get(r2)
            r16 = r3
            java.lang.String r16 = (java.lang.String) r16
            java.util.List<java.lang.String> r3 = r1.status
            java.lang.Object r3 = r3.get(r2)
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            java.util.List<java.lang.String> r3 = r1.npvrcode
            java.lang.Object r3 = r3.get(r2)
            r18 = r3
            java.lang.String r18 = (java.lang.String) r18
            java.util.List<java.lang.String> r3 = r1.ratingid
            java.lang.Object r3 = r3.get(r2)
            r19 = r3
            java.lang.String r19 = (java.lang.String) r19
            r3 = r15
            r20 = r0
            r0 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.util.ArrayList<com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrBean> r3 = r1.mDataList
            r3.add(r0)
            int r2 = r2 + 1
            r0 = r20
            goto L24
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean.dataParseToBeanList():void");
    }

    public ArrayList<NpvrBean> getDataList() {
        ArrayList<NpvrBean> arrayList = this.mDataList;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public String getErrormsg() {
        String str = this.errormsg;
        return str == null ? "" : str;
    }

    public String getReturncode() {
        String str = this.returncode;
        return str == null ? "" : str;
    }

    public String getTotalcount() {
        String str = this.totalcount;
        return str == null ? "" : str;
    }

    public void setDataList(ArrayList<NpvrBean> arrayList) {
        this.mDataList = arrayList;
    }

    public void setErrormsg(String str) {
        this.errormsg = str;
    }

    public void setReturncode(String str) {
        this.returncode = str;
    }

    public void setTotalcount(String str) {
        this.totalcount = str;
    }

    public void dataParseToBeanList(JSONArray jSONArray) {
        this.mDataList = new ArrayList<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                this.mDataList.add(NpvrBean.jsonToBean(jSONArray.optJSONObject(i)));
            }
        }
    }
}
