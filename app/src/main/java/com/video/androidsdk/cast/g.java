package com.video.androidsdk.cast;

import android.os.Handler;
import android.text.TextUtils;
import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.DMRDeviceListRes;
import com.video.androidsdk.cast.bean.DMSDeviceListRes;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.cast.bean.DeviceItem;
import com.video.androidsdk.cast.bean.DeviceListRes;
import com.video.androidsdk.cast.bean.currentinfo.channel.response;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.xml.DomParser;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKCastMgr f3062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SDKCastMgr sDKCastMgr) {
        this.f3062a = sDKCastMgr;
    }

    @Override // com.video.androidsdk.cast.c
    public void a(DLNAEvent dLNAEvent) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        SDKCastMgr.IDLNANotifyListener iDLNANotifyListener;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Map map;
        ArrayList arrayList5;
        ArrayList arrayList6;
        boolean z;
        Handler handler4;
        Runnable runnable;
        SDKCastMgr.IInitDLNAListener iInitDLNAListener;
        Handler handler5;
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        this.f3062a.f3044b = true;
        if (dLNAEvent == null) {
            LogEx.d("SDKCastMgr", "get dlna event null");
            return;
        }
        LogEx.d("SDKCastMgr", "get dlna event:" + dLNAEvent.getEvent() + "iType:" + dLNAEvent.getArg0() + "sessionid:" + dLNAEvent.getArg1());
        if (dLNAEvent.getObject() != null) {
            LogEx.d("SDKCastMgr", "get dlna event:" + dLNAEvent.getEvent() + "rspdata:" + dLNAEvent.getObject().toString());
        }
        if (dLNAEvent.getEvent() == null) {
            LogEx.d("SDKCastMgr", "dlna event is null");
            return;
        }
        LogEx.i("SDKCastMgr", "dlna event [" + dLNAEvent.getEvent() + "]");
        HashMap hashMap = new HashMap();
        if (dLNAEvent.getEvent().equals(DLNAEvent.EVENT_DEVICE_ONLINE) || dLNAEvent.getEvent().equals(DLNAEvent.EVENT_DEVICE_OFFLINE)) {
            this.f3062a.c();
            if (dLNAEvent.getObject() == null) {
                arrayList3 = this.f3062a.l;
                arrayList3.clear();
                arrayList4 = this.f3062a.m;
                arrayList4.clear();
                this.f3062a.n = null;
                this.f3062a.o = null;
            } else {
                LogEx.i("SDKCastMgr", "dlna event object : " + dLNAEvent.getObject().toString());
                a(dLNAEvent.getObject().toString());
            }
            if (dLNAEvent.getObject() != null) {
                arrayList = this.f3062a.l;
                hashMap.put(SDKCastMgr.DMRDEVICELIST, arrayList);
                arrayList2 = this.f3062a.m;
                hashMap.put(SDKCastMgr.DMSDEVICELIST, arrayList2);
            }
        } else if (dLNAEvent.getEvent().equals(DLNAEvent.EVENT_INIT_FAILED)) {
            z = this.f3062a.j;
            if (z) {
                handler4 = SDKCastMgr.f3042a;
                runnable = this.f3062a.D;
                handler4.removeCallbacks(runnable);
                iInitDLNAListener = this.f3062a.p;
                if (iInitDLNAListener != null) {
                    handler5 = SDKCastMgr.f3042a;
                    handler5.post(new h(this, dLNAEvent));
                } else {
                    this.f3062a.j = false;
                }
            }
        } else {
            String arg1 = dLNAEvent.getArg1();
            map = this.f3062a.k;
            SDKCastMgr.a aVar = (SDKCastMgr.a) map.remove(arg1);
            if (aVar != null) {
                a(arg1, aVar, (String) dLNAEvent.getObject());
                return;
            } else if (dLNAEvent.getObject() != null) {
                arrayList5 = this.f3062a.l;
                hashMap.put(SDKCastMgr.DMRDEVICELIST, arrayList5);
                arrayList6 = this.f3062a.m;
                hashMap.put(SDKCastMgr.DMSDEVICELIST, arrayList6);
            }
        }
        iDLNANotifyListener = this.f3062a.q;
        if (iDLNANotifyListener != null) {
            if (dLNAEvent.getEvent().equals(DLNAEvent.EVENT_DEVICE_ONLINE)) {
                handler3 = SDKCastMgr.f3042a;
                handler3.post(new i(this, hashMap));
            } else if (dLNAEvent.getEvent().equals(DLNAEvent.EVENT_DEVICE_OFFLINE)) {
                handler2 = SDKCastMgr.f3042a;
                handler2.post(new j(this, hashMap));
            } else {
                handler = SDKCastMgr.f3042a;
                handler.post(new k(this, hashMap));
            }
        }
    }

    private void a(String str, SDKCastMgr.a aVar, String str2) {
        SDKCastMgr.IDLNAActionCallback b2;
        String d2;
        LogEx.d("SDKCastMgr", "parseDLNAEvent");
        if (str2 == null || (b2 = aVar.b()) == null) {
            return;
        }
        int a2 = aVar.a();
        LogEx.d("SDKCastMgr", "parseDLNAEvent action:" + a2);
        if (a2 == 9) {
            HashMap hashMap = new HashMap();
            hashMap.put("RawData", str2);
            b2.onDLNAResponse("0", "", hashMap);
            return;
        }
        if (a2 != 20) {
            switch (a2) {
                case 1:
                    response responseVar = (response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), response.class);
                    if (responseVar == null) {
                        LogEx.d("SDKCastMgr", "channelInfo parse error");
                        return;
                    }
                    String returncode = responseVar.getReturncode();
                    String errormsg = responseVar.getErrormsg();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("returncode", returncode);
                    hashMap2.put("errormsg", errormsg);
                    hashMap2.put("channelcode", responseVar.getChannelcode());
                    b2.onDLNAResponse(returncode, errormsg, hashMap2);
                    return;
                case 2:
                    com.video.androidsdk.cast.bean.currentinfo.transport.response responseVar2 = (com.video.androidsdk.cast.bean.currentinfo.transport.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.currentinfo.transport.response.class);
                    if (responseVar2 == null) {
                        LogEx.d("SDKCastMgr", "transportInfo parse error");
                        return;
                    }
                    String returncode2 = responseVar2.getReturncode();
                    String errormsg2 = responseVar2.getErrormsg();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("returncode", returncode2);
                    hashMap3.put("errormsg", errormsg2);
                    hashMap3.put(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATE, responseVar2.getCurrentTransportState());
                    hashMap3.put(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATUS, responseVar2.getCurrentTransportStatus());
                    hashMap3.put(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTSPEED, responseVar2.getCurrentSpeed());
                    b2.onDLNAResponse(returncode2, errormsg2, hashMap3);
                    return;
                case 3:
                    com.video.androidsdk.cast.bean.currentinfo.position.response responseVar3 = (com.video.androidsdk.cast.bean.currentinfo.position.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.currentinfo.position.response.class);
                    if (responseVar3 == null) {
                        LogEx.d("SDKCastMgr", "positionInfo parse error");
                        return;
                    }
                    String returncode3 = responseVar3.getReturncode();
                    String errormsg3 = responseVar3.getErrormsg();
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("returncode", returncode3);
                    hashMap4.put("errormsg", errormsg3);
                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_TRACKDURATION, responseVar3.getTrackDuration());
                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELTIME, responseVar3.getRelTime());
                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELCOUNT, responseVar3.getRelCount());
                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_ABSCOUNT, responseVar3.getAbsCount());
                    if (responseVar3.getTrackURI() != null) {
                        String[] split = responseVar3.getTrackURI().split("&");
                        LogEx.d("SDKCastMgr", "TrackURI : " + responseVar3.getTrackURI());
                        String str3 = null;
                        String str4 = "";
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].trim().startsWith("url=")) {
                                String[] split2 = split[i].split("=");
                                if (split2.length >= 2 && split2[1] != null) {
                                    try {
                                        str4 = URLDecoder.decode(split2[1], "UTF-8");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_URLFROMSTB, str4);
                                }
                            } else if (split[i].trim().startsWith("pushtype=")) {
                                String[] split3 = split[i].split("=");
                                if (split3.length >= 2 && split3[1] != null) {
                                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_PUSHTYPE, split3[1]);
                                    str3 = split3[1];
                                }
                            } else if (split[i].trim().startsWith("mixno=")) {
                                String[] split4 = split[i].split("=");
                                if (split4.length >= 2 && split4[1] != null) {
                                    hashMap4.put("mixno", split4[1]);
                                }
                            } else if (split[i].trim().startsWith("channelcode=")) {
                                String[] split5 = split[i].split("=");
                                if (split5.length >= 2 && split5[1] != null) {
                                    hashMap4.put("channelcode", split5[1]);
                                }
                            } else if (split[i].trim().startsWith("telecomcode=")) {
                                String[] split6 = split[i].split("=");
                                if (split6.length >= 2 && split6[1] != null) {
                                    hashMap4.put("telecomcode", split6[1]);
                                    LogEx.d("SDKCastMgr", "Telecomcode : " + split6[1]);
                                }
                            } else if (split[i].trim().startsWith("seriestelecomcode=")) {
                                String[] split7 = split[i].split("=");
                                if (split7.length >= 2 && split7[1] != null) {
                                    hashMap4.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_SERIESTELECOMCODE, split7[1]);
                                    LogEx.d("SDKCastMgr", "Series Telecomcode : " + split7[1]);
                                }
                            } else if (split[i].trim().startsWith("begintime=")) {
                                String[] split8 = split[i].split("=");
                                if (split8.length >= 2 && split8[1] != null) {
                                    hashMap4.put("begintime", split8[1]);
                                }
                            } else if (split[i].trim().startsWith("endtime=")) {
                                String[] split9 = split[i].split("=");
                                if (split9.length >= 2 && split9[1] != null) {
                                    hashMap4.put("endtime", split9[1]);
                                }
                            } else if (split[i].trim().startsWith("breakpoint=")) {
                                String[] split10 = split[i].split("=");
                                if (split10.length >= 2 && split10[1] != null) {
                                    hashMap4.put("breakpoint", split10[1]);
                                }
                            } else if (split[i].trim().startsWith("programid=")) {
                                String[] split11 = split[i].split("=");
                                if (split11.length >= 2 && split11[1] != null) {
                                    hashMap4.put("programid", split11[1]);
                                }
                            } else if (split[i].trim().startsWith("url=")) {
                                String[] split12 = split[i].split("=");
                                if (split12.length >= 2 && split12[1] != null) {
                                    hashMap4.put("url", split12[1]);
                                }
                            }
                        }
                        if (TextUtils.equals(str3, DownloadConstant.REPORT_MSGTYPE_ADD) && !TextUtils.isEmpty(str4)) {
                            d2 = this.f3062a.d(str4);
                            hashMap4.put("playtype", d2);
                            b2.onDLNAResponse(returncode3, errormsg3, hashMap4);
                            return;
                        }
                    }
                    b2.onDLNAResponse(returncode3, errormsg3, hashMap4);
                    return;
                case 4:
                    com.video.androidsdk.cast.bean.currentinfo.volumn.response responseVar4 = (com.video.androidsdk.cast.bean.currentinfo.volumn.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.currentinfo.volumn.response.class);
                    if (responseVar4 == null) {
                        LogEx.d("SDKCastMgr", "volumnInfo parse error");
                        return;
                    }
                    String returncode4 = responseVar4.getReturncode();
                    String errormsg4 = responseVar4.getErrormsg();
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("returncode", returncode4);
                    hashMap5.put("errormsg", errormsg4);
                    hashMap5.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_VOLUMN, responseVar4.getCurrentVolume());
                    b2.onDLNAResponse(returncode4, errormsg4, hashMap5);
                    break;
                case 5:
                    com.video.androidsdk.cast.bean.operation.keycode.response responseVar5 = (com.video.androidsdk.cast.bean.operation.keycode.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.operation.keycode.response.class);
                    if (responseVar5 == null) {
                        LogEx.d("SDKCastMgr", "sendkeycode rsp parse error");
                        return;
                    }
                    String returncode5 = responseVar5.getReturncode();
                    String errormsg5 = responseVar5.getErrormsg();
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("returncode", returncode5);
                    hashMap6.put("errormsg", errormsg5);
                    b2.onDLNAResponse(returncode5, errormsg5, hashMap6);
                    break;
                case 6:
                    com.video.androidsdk.cast.bean.operation.content.response responseVar6 = (com.video.androidsdk.cast.bean.operation.content.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.operation.content.response.class);
                    if (responseVar6 == null) {
                        LogEx.d("SDKCastMgr", "sendcontent rsp parse error");
                        return;
                    }
                    String returncode6 = responseVar6.getReturncode();
                    String errormsg6 = responseVar6.getErrormsg();
                    HashMap hashMap7 = new HashMap();
                    hashMap7.put("returncode", returncode6);
                    hashMap7.put("errormsg", errormsg6);
                    b2.onDLNAResponse(returncode6, errormsg6, hashMap7);
                    break;
                case 7:
                    com.video.androidsdk.cast.bean.operation.play.response responseVar7 = (com.video.androidsdk.cast.bean.operation.play.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.operation.play.response.class);
                    if (responseVar7 == null) {
                        LogEx.d("SDKCastMgr", "sendplay rsp parse error");
                        return;
                    }
                    String returncode7 = responseVar7.getReturncode();
                    String errormsg7 = responseVar7.getErrormsg();
                    HashMap hashMap8 = new HashMap();
                    hashMap8.put("returncode", returncode7);
                    hashMap8.put("errormsg", errormsg7);
                    b2.onDLNAResponse(returncode7, errormsg7, hashMap8);
                    break;
                default:
                    switch (a2) {
                        case 11:
                            com.video.androidsdk.cast.bean.service.bookmark.response responseVar8 = (com.video.androidsdk.cast.bean.service.bookmark.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.service.bookmark.response.class);
                            if (responseVar8 == null) {
                                LogEx.d("SDKCastMgr", "getbookmark rsp parse error");
                                return;
                            }
                            String returncode8 = responseVar8.getReturncode();
                            String errormsg8 = responseVar8.getErrormsg();
                            HashMap hashMap9 = new HashMap();
                            hashMap9.put("returncode", returncode8);
                            hashMap9.put("errormsg", errormsg8);
                            hashMap9.put("breakpoint", responseVar8.getBreakpoint());
                            b2.onDLNAResponse(returncode8, errormsg8, hashMap9);
                            break;
                        case 12:
                            com.video.androidsdk.cast.bean.currentinfo.stbconfig.response responseVar9 = (com.video.androidsdk.cast.bean.currentinfo.stbconfig.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.currentinfo.stbconfig.response.class);
                            if (responseVar9 == null) {
                                LogEx.d("SDKCastMgr", "stbConfig rsp parse error");
                                return;
                            }
                            String returncode9 = responseVar9.getReturncode();
                            String errormsg9 = responseVar9.getErrormsg();
                            HashMap hashMap10 = new HashMap();
                            hashMap10.put("returncode", returncode9);
                            hashMap10.put("errormsg", errormsg9);
                            hashMap10.put(ParamConst.DLNA_SENDDMRGETSTBCONFIG_RSP_KEYVALUE, responseVar9.getKeyValue());
                            b2.onDLNAResponse(returncode9, errormsg9, hashMap10);
                            break;
                        case 13:
                            com.video.androidsdk.cast.bean.currentinfo.mediainfo.response responseVar10 = (com.video.androidsdk.cast.bean.currentinfo.mediainfo.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.currentinfo.mediainfo.response.class);
                            if (responseVar10 == null) {
                                LogEx.d("SDKCastMgr", "mediaInfo rsp parse error");
                                return;
                            }
                            String returncode10 = responseVar10.getReturncode();
                            String errormsg10 = responseVar10.getErrormsg();
                            HashMap hashMap11 = new HashMap();
                            hashMap11.put("returncode", returncode10);
                            hashMap11.put("errormsg", errormsg10);
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_NRTRACKS, responseVar10.getNrTracks());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_MEDIADURATION, responseVar10.getMediaDuration());
                            hashMap11.put("CurrentURI", responseVar10.getCurrentURI());
                            hashMap11.put("CurrentURIMetaData", responseVar10.getCurrentURIMetaData());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_NEXTURI, responseVar10.getNextURI());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_NEXTURIMETADATA, responseVar10.getNextURIMetaData());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_PLAYMEDIUM, responseVar10.getPlayMedium());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_RECORDMEDIUM, responseVar10.getRecordMedium());
                            hashMap11.put(ParamConst.DLNA_SENDDMRGETCURRVOLUMN_RSP_WRITESTATUS, responseVar10.getWriteStatus());
                            b2.onDLNAResponse(returncode10, errormsg10, hashMap11);
                            break;
                        case 14:
                            com.video.androidsdk.cast.bean.operation.seek.response responseVar11 = (com.video.androidsdk.cast.bean.operation.seek.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.operation.seek.response.class);
                            if (responseVar11 == null) {
                                LogEx.d("SDKCastMgr", "stbConfig rsp parse error");
                                return;
                            }
                            String returncode11 = responseVar11.getReturncode();
                            String errormsg11 = responseVar11.getErrormsg();
                            HashMap hashMap12 = new HashMap();
                            hashMap12.put("returncode", returncode11);
                            hashMap12.put("errormsg", errormsg11);
                            hashMap12.put("RawData", str2);
                            b2.onDLNAResponse(returncode11, errormsg11, hashMap12);
                            break;
                    }
            }
            return;
        }
        com.video.androidsdk.cast.bean.operation.binddev.response responseVar12 = (com.video.androidsdk.cast.bean.operation.binddev.response) DomParser.parse2Bean(new ByteArrayInputStream(str2.getBytes()), com.video.androidsdk.cast.bean.operation.binddev.response.class);
        if (responseVar12 == null) {
            return;
        }
        String returncode12 = responseVar12.getReturncode();
        String errormsg12 = responseVar12.getErrormsg();
        HashMap hashMap13 = new HashMap();
        hashMap13.put("returncode", returncode12);
        hashMap13.put("errormsg", errormsg12);
        b2.onDLNAResponse(returncode12, errormsg12, hashMap13);
    }

    private void a(String str) {
        Device device;
        String macAddress;
        String udn;
        ArrayList arrayList;
        Device device2;
        String macAddress2;
        String udn2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        if (TextUtils.isEmpty(str)) {
            arrayList7 = this.f3062a.l;
            arrayList7.clear();
            arrayList8 = this.f3062a.m;
            arrayList8.clear();
            this.f3062a.n = null;
            this.f3062a.o = null;
            return;
        }
        DeviceListRes deviceListRes = (DeviceListRes) DomParser.parse2Bean(new ByteArrayInputStream(str.getBytes()), DeviceListRes.class);
        if (deviceListRes == null) {
            arrayList5 = this.f3062a.l;
            arrayList5.clear();
            arrayList6 = this.f3062a.m;
            arrayList6.clear();
            this.f3062a.n = null;
            this.f3062a.o = null;
            return;
        }
        DMRDeviceListRes dMRDeviceListRes = deviceListRes.getDMRDeviceListRes();
        if (dMRDeviceListRes == null) {
            arrayList4 = this.f3062a.l;
            arrayList4.clear();
            this.f3062a.n = null;
        } else {
            device = this.f3062a.n;
            if (device == null) {
                LogEx.d("SDKCastMgr", "Pre mPairDMR is null.");
                udn = null;
                macAddress = null;
            } else {
                macAddress = device.getMacAddress();
                udn = device.getUDN();
            }
            DeviceItem[] deviceItem = dMRDeviceListRes.getDeviceItem();
            if (deviceItem == null) {
                arrayList = this.f3062a.l;
                arrayList.clear();
                this.f3062a.n = null;
            } else {
                ArrayList arrayList9 = new ArrayList();
                boolean z = false;
                for (DeviceItem deviceItem2 : deviceItem) {
                    if (deviceItem2 != null) {
                        Device device3 = new Device();
                        LogEx.d("SDKCastMgr", "DLNA dmr mac:" + deviceItem2.getMacAddr() + " udn:" + deviceItem2.getUDN() + " deviceid:" + deviceItem2.getDeviceID());
                        device3.setFriendlyName(deviceItem2.getFriendlyName());
                        device3.setUDN(deviceItem2.getUDN());
                        device3.setMacAddress(deviceItem2.getMacAddr());
                        device3.setUserID(deviceItem2.getUDN());
                        device3.setSTBName(deviceItem2.getSTBName());
                        device3.setSTBLanguage(deviceItem2.getSTBLanguage());
                        device3.setDeviceID(deviceItem2.getDeviceID());
                        if (!StringUtil.isEmptyString(deviceItem2.getSTBAddr())) {
                            device3.setSTBAddr(deviceItem2.getSTBAddr());
                        }
                        if (!StringUtil.isEmptyString(deviceItem2.getHCAbility())) {
                            device3.setHCAbility(deviceItem2.getHCAbility());
                        }
                        if (!StringUtil.isEmptyString(deviceItem2.getHCPort())) {
                            device3.setHCPort(deviceItem2.getHCPort());
                        }
                        if (!StringUtil.isEmptyString(deviceItem2.getHCStorage())) {
                            device3.setHCStorage(deviceItem2.getHCStorage());
                        }
                        if (!StringUtil.isEmptyString(deviceItem2.getHCDownload())) {
                            device3.setHCDownload(deviceItem2.getHCDownload());
                        }
                        if (!StringUtil.isEmptyString(deviceItem2.getHCDownloadPort())) {
                            device3.setHCDownloadPort(deviceItem2.getHCDownloadPort());
                        }
                        device3.setDMR(true);
                        arrayList9.add(device3);
                        if (macAddress == null) {
                            if (device3.getUDN() != null && device3.getUDN().equalsIgnoreCase(udn)) {
                                LogEx.d("SDKCastMgr", "Found selected DMR");
                                this.f3062a.n = device3;
                                z = true;
                            }
                        } else if (macAddress.equalsIgnoreCase(device3.getMacAddress()) || (device3.getUDN() != null && device3.getUDN().equalsIgnoreCase(udn))) {
                            LogEx.d("SDKCastMgr", "Found selected DMR");
                            this.f3062a.n = device3;
                            z = true;
                        }
                    }
                }
                if (!z) {
                    this.f3062a.n = null;
                }
                this.f3062a.l = arrayList9;
            }
        }
        DMSDeviceListRes dMSDeviceListRes = deviceListRes.getDMSDeviceListRes();
        if (dMSDeviceListRes == null) {
            arrayList3 = this.f3062a.m;
            arrayList3.clear();
            this.f3062a.o = null;
            return;
        }
        device2 = this.f3062a.o;
        if (device2 == null) {
            LogEx.d("SDKCastMgr", "Pre mPairDMS is null.");
            udn2 = null;
            macAddress2 = null;
        } else {
            macAddress2 = device2.getMacAddress();
            udn2 = device2.getUDN();
        }
        DeviceItem[] deviceItem3 = dMSDeviceListRes.getDeviceItem();
        if (deviceItem3 == null) {
            arrayList2 = this.f3062a.m;
            arrayList2.clear();
            this.f3062a.o = null;
            return;
        }
        ArrayList arrayList10 = new ArrayList();
        boolean z2 = false;
        for (DeviceItem deviceItem4 : deviceItem3) {
            if (deviceItem4 != null) {
                Device device4 = new Device();
                LogEx.d("SDKCastMgr", "DLNA dms mac:" + deviceItem4.getMacAddr() + " udn:" + deviceItem4.getUDN());
                device4.setFriendlyName(deviceItem4.getFriendlyName());
                device4.setUDN(deviceItem4.getUDN());
                device4.setMacAddress(deviceItem4.getMacAddr());
                device4.setUserID(deviceItem4.getUDN());
                device4.setSTBName(deviceItem4.getSTBName());
                device4.setSTBLanguage(deviceItem4.getSTBLanguage());
                device4.setDeviceID(deviceItem4.getDeviceID());
                if (!StringUtil.isEmptyString(deviceItem4.getSTBAddr())) {
                    device4.setSTBAddr(deviceItem4.getSTBAddr());
                }
                if (!StringUtil.isEmptyString(deviceItem4.getHCAbility())) {
                    device4.setHCAbility(deviceItem4.getHCAbility());
                }
                if (!StringUtil.isEmptyString(deviceItem4.getHCPort())) {
                    device4.setHCPort(deviceItem4.getHCPort());
                }
                if (!StringUtil.isEmptyString(deviceItem4.getHCStorage())) {
                    device4.setHCStorage(deviceItem4.getHCStorage());
                }
                if (!StringUtil.isEmptyString(deviceItem4.getHCDownload())) {
                    device4.setHCDownload(deviceItem4.getHCDownload());
                }
                if (!StringUtil.isEmptyString(deviceItem4.getHCDownloadPort())) {
                    device4.setHCDownloadPort(deviceItem4.getHCDownloadPort());
                }
                device4.setDMS(true);
                arrayList10.add(device4);
                if (macAddress2 == null) {
                    if (device4.getUDN() != null && device4.getUDN().equalsIgnoreCase(udn2)) {
                        LogEx.d("SDKCastMgr", "Found selected DMS");
                        this.f3062a.o = device4;
                        z2 = true;
                    }
                } else if (macAddress2.equalsIgnoreCase(device4.getMacAddress()) || (device4.getUDN() != null && device4.getUDN().equalsIgnoreCase(udn2))) {
                    LogEx.d("SDKCastMgr", "Found selected DMS");
                    this.f3062a.o = device4;
                    z2 = true;
                }
            }
        }
        if (!z2) {
            this.f3062a.o = null;
        }
        this.f3062a.m = arrayList10;
    }
}
