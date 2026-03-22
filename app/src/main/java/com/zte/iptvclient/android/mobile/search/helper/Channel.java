package com.zte.iptvclient.android.mobile.search.helper;

import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.mobile.search.bean.ChannelType;
import com.zte.iptvclient.android.mobile.search.bean.b;
import com.zte.iptvclient.android.mobile.search.bean.c;
import com.zte.iptvclient.common.video.MediaServiceType;
import com.zte.servicesdk.util.SDKUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Channel implements Serializable {
    private static final String LOG_TAG = "Channel";
    private static final long serialVersionUID = 1;
    private String AdvertiseContent;
    private String AudioLang;
    private String BitRate;
    private String BoCode;
    private List<com.zte.iptvclient.android.mobile.search.bean.a> CDNChannelInfoList;
    private String ChannelCode;
    private String ChannelName;
    private ChannelType ChannelType;
    private String ColumnCode;
    private String ColumnName;
    private String Description;
    private String DirId;
    private String ErrorMsg;
    private String FileName;
    private String MediaCode;
    private String MediaServices;
    private String MixNo;
    private List<c> PrevueList;
    private String RatingId;
    private int ReturnCode;
    private String SortNum;
    private String SubTitleLang;
    private String TelecomCode;
    private int TotalCount;
    private String UserMixNo;
    private boolean is3SFavorited;
    private boolean isIPPVEnable;
    private boolean isLPVREnable;
    private boolean isLocalTimeShift;
    private boolean isLocked;
    private boolean isNPVREnable;
    private boolean isParentControlEnable;
    private boolean isPurchased;
    private boolean isTVEnable;
    private b mChannelReq;
    private boolean isFavorited = false;
    private boolean isChannelInfoBack = false;
    private String ChannelUrl = "";
    private String TimeShiftURL = "";
    private int mIsFavorite = -1;
    private String mstrUrl = "";

    /* loaded from: classes2.dex */
    public interface a {
    }

    public Channel(b bVar, a aVar) {
        this.mChannelReq = bVar;
    }

    private static List<com.zte.iptvclient.android.mobile.search.bean.a> analysisCDNChanenlJson(JSONArray jSONArray) {
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 != null && jSONArray.length() > 0) {
            try {
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < length) {
                    int i2 = length;
                    com.zte.iptvclient.android.mobile.search.bean.a aVar = new com.zte.iptvclient.android.mobile.search.bean.a();
                    ArrayList arrayList2 = arrayList;
                    JSONObject jSONObject = jSONArray2.getJSONObject(i);
                    if (jSONObject.has("cdnchannelcode")) {
                        aVar.b((String) jSONObject.get("cdnchannelcode"));
                    }
                    if (jSONObject.has("mediaservice")) {
                        aVar.a(MediaServiceType.valueOf(Integer.parseInt((String) jSONObject.get("mediaservice"))));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_LIVEID)) {
                        aVar.f((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_LIVEID));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTENABLE)) {
                        aVar.c(Boolean.valueOf(SDKUtil.stringToBooleanOf1IsTrue((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTENABLE))));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TVODENABLE)) {
                        aVar.a(Boolean.valueOf(SDKUtil.stringToBooleanOf1IsTrue((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TVODENABLE))));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TVODSAVETIME)) {
                        aVar.g((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TVODSAVETIME));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_VIDEORATIO)) {
                        aVar.h((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_VIDEORATIO));
                    }
                    if (jSONObject.has("definition")) {
                        aVar.e((String) jSONObject.get("definition"));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_CDNTELECOMCODE)) {
                        aVar.d((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_CDNTELECOMCODE));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_CDNMEDIACODE)) {
                        aVar.c((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_CDNMEDIACODE));
                    }
                    if (jSONObject.has("bitrate")) {
                        aVar.a((String) jSONObject.get("bitrate"));
                    }
                    if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TVPAUSEENBLE)) {
                        aVar.b(Boolean.valueOf(SDKUtil.stringToBooleanOf1IsTrue((String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TVPAUSEENBLE))));
                    }
                    arrayList2.add(aVar);
                    i++;
                    arrayList = arrayList2;
                    length = i2;
                    jSONArray2 = jSONArray;
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        LogEx.w(LOG_TAG, "jsonArray is null");
        return null;
    }

    public static Map<String, Object> analysisJson(String str, List<Map<String, Object>> list) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strResponseJson is null");
            return null;
        }
        LogEx.d(LOG_TAG, "strResponseJson:" + str);
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            LogEx.d(LOG_TAG, "jsonobject:" + jSONObject);
            int intValue = Integer.valueOf((String) jSONObject.get("returncode")).intValue();
            hashMap.put("returncode", Integer.valueOf(intValue));
            LogEx.d(LOG_TAG, "intReturnCode:" + intValue);
            String str2 = (String) jSONObject.get("errormsg");
            hashMap.put("errormsg", str2);
            LogEx.d(LOG_TAG, "strMsg:" + str2);
            if (intValue != 0) {
                hashMap.put("totalcount", 0);
                return hashMap;
            }
            int intValue2 = Integer.valueOf((String) jSONObject.get("totalcount")).intValue();
            hashMap.put("totalcount", Integer.valueOf(intValue2));
            LogEx.d(LOG_TAG, "totalcount: " + intValue2);
            if (intValue2 <= 0) {
                LogEx.w(LOG_TAG, "totalcount <= 0");
                hashMap.put("totalcount", 0);
                return hashMap;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(ParamConst.CHANNEL_INFO_RSP_CHANNELINFO);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                HashMap hashMap2 = new HashMap();
                analysisPublicJson(jSONArray.getJSONObject(i), hashMap2);
                if (jSONArray.getJSONObject(i).has(ParamConst.CHANNEL_INFO_RSP_CDNCHANNELINFO)) {
                    new JSONArray();
                    hashMap2.put(ParamConst.CHANNEL_INFO_RSP_CDNCHANNELINFO, analysisCDNChanenlJson(jSONArray.getJSONObject(i).getJSONArray(ParamConst.CHANNEL_INFO_RSP_CDNCHANNELINFO)));
                }
                if (jSONArray.getJSONObject(i).has(ParamConst.CHANNEL_INFO_RSP_PREVUELIST)) {
                    new JSONArray();
                    hashMap2.put(ParamConst.CHANNEL_INFO_RSP_PREVUELIST, analysisPrevueJson(jSONArray.getJSONObject(i).getJSONArray(ParamConst.CHANNEL_INFO_RSP_PREVUELIST)));
                }
                list.add(hashMap2);
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.w(LOG_TAG, "Failed to parse jason:" + str);
            return null;
        }
    }

    private static List<c> analysisPrevueJson(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    c cVar = new c();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has("prevuename")) {
                        cVar.d((String) jSONObject.get("prevuename"));
                    }
                    if (jSONObject.has("prevuecode")) {
                        cVar.c((String) jSONObject.get("prevuecode"));
                    }
                    if (jSONObject.has("begintime")) {
                        cVar.a((String) jSONObject.get("begintime"));
                    }
                    if (jSONObject.has("endtime")) {
                        cVar.b((String) jSONObject.get("endtime"));
                    }
                    arrayList.add(cVar);
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        LogEx.w(LOG_TAG, "jsonArray is null");
        return null;
    }

    private static void analysisPublicJson(JSONObject jSONObject, Map<String, Object> map) {
        String str;
        if (jSONObject != null && map != null) {
            try {
                if (jSONObject.has("channelcode")) {
                    str = "description";
                    map.put("channelcode", (String) jSONObject.get("channelcode"));
                } else {
                    str = "description";
                }
                if (jSONObject.has("channelname")) {
                    map.put("channelname", (String) jSONObject.get("channelname"));
                }
                if (jSONObject.has("mixno")) {
                    map.put("mixno", (String) jSONObject.get("mixno"));
                }
                if (jSONObject.has("channeltype")) {
                    map.put("channeltype", (String) jSONObject.get("channeltype"));
                }
                if (jSONObject.has("mediaservices")) {
                    map.put("mediaservices", (String) jSONObject.get("mediaservices"));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_IPPVENABLE)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_IPPVENABLE, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_IPPVENABLE));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_LPVRENABLE)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_LPVRENABLE, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_LPVRENABLE));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_PARENTCONTROLENABLE)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_PARENTCONTROLENABLE, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_PARENTCONTROLENABLE));
                }
                if (jSONObject.has("ratingid")) {
                    map.put("ratingid", (String) jSONObject.get("ratingid"));
                }
                if (jSONObject.has("sortnum")) {
                    map.put("sortnum", (String) jSONObject.get("sortnum"));
                }
                if (jSONObject.has("bocode")) {
                    map.put("bocode", (String) jSONObject.get("bocode"));
                }
                if (jSONObject.has("telecomcode")) {
                    map.put("telecomcode", (String) jSONObject.get("telecomcode"));
                }
                if (jSONObject.has("mediacode")) {
                    map.put("mediacode", (String) jSONObject.get("mediacode"));
                }
                String str2 = str;
                if (jSONObject.has(str2)) {
                    map.put(str2, (String) jSONObject.get(str2));
                }
                if (jSONObject.has("columncode")) {
                    map.put("columncode", (String) jSONObject.get("columncode"));
                }
                if (jSONObject.has("columnname")) {
                    map.put("columnname", (String) jSONObject.get("columnname"));
                }
                if (jSONObject.has("filename")) {
                    map.put("filename", (String) jSONObject.get("filename"));
                }
                if (jSONObject.has("audiolang")) {
                    map.put("audiolang", (String) jSONObject.get("audiolang"));
                }
                if (jSONObject.has("subtitlelang")) {
                    map.put("subtitlelang", (String) jSONObject.get("subtitlelang"));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_ISLOCALTIMESHIFT)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_ISLOCALTIMESHIFT, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_ISLOCALTIMESHIFT));
                }
                if (jSONObject.has("advertisecontent")) {
                    map.put("advertisecontent", (String) jSONObject.get("advertisecontent"));
                }
                if (jSONObject.has("usermixno")) {
                    map.put("usermixno", (String) jSONObject.get("usermixno"));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_NPVRAVAILABLE)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_NPVRAVAILABLE, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_NPVRAVAILABLE));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TVAVAILABLE)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_TVAVAILABLE, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TVAVAILABLE));
                }
                if (jSONObject.has("isfavorite")) {
                    map.put("isfavorite", (String) jSONObject.get("isfavorite"));
                }
                if (jSONObject.has("is3Sfavorite")) {
                    map.put("is3Sfavorite", (String) jSONObject.get("is3Sfavorite"));
                }
                if (jSONObject.has("dirid")) {
                    map.put("dirid", (Integer) jSONObject.get("dirid"));
                }
                if (jSONObject.has("ispurchased")) {
                    map.put("ispurchased", (String) jSONObject.get("ispurchased"));
                }
                if (jSONObject.has("islocked")) {
                    map.put("islocked", (String) jSONObject.get("islocked"));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_CHANNELURL)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_CHANNELURL, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_CHANNELURL));
                }
                if (jSONObject.has(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTURL)) {
                    map.put(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTURL, (String) jSONObject.get(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTURL));
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        LogEx.w(LOG_TAG, "jsonobject or programMap is null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(Channel.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(Channel.class.getName(), "writeObject");
    }

    public void channelMapToBean(Map<String, Object> map) {
        setChannelCode((String) map.get("channelcode"));
        setChannelName((String) map.get("channelname"));
        setMixNo((String) map.get("mixno"));
        setMediaServices((String) map.get("mediaservices"));
        try {
            if (this.ChannelType != null) {
                setChannelType(ChannelType.valueOf(Integer.parseInt((String) map.get("channeltype"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setIsIPPVEnable(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_IPPVENABLE)));
        setIsLPVREnable(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_LPVRENABLE)));
        setIsParentControlEnable(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_PARENTCONTROLENABLE)));
        setRatingId((String) map.get("ratingid"));
        setSortNum((String) map.get("sortnum"));
        setBoCode((String) map.get("bocode"));
        setTelecomCode((String) map.get("telecomcode"));
        setMediaCode((String) map.get("mediacode"));
        setDescription((String) map.get("description"));
        setColumnCode((String) map.get("columncode"));
        setColumnName((String) map.get("columnname"));
        setFileName((String) map.get("filename"));
        setAudioLang((String) map.get("audiolang"));
        setSubTitleLang((String) map.get("subtitlelang"));
        setIsLocalTimeShift(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_ISLOCALTIMESHIFT)));
        setAdvertiseContent((String) map.get("advertisecontent"));
        setUserMixNo((String) map.get("usermixno"));
        setIsNPVREnable(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_NPVRAVAILABLE)));
        setIsTVEnable(SDKUtil.stringToBooleanOf1IsTrue((String) map.get(ParamConst.CHANNEL_INFO_RSP_TVAVAILABLE)));
        setIsFavorited(SDKUtil.stringToBooleanOf1IsTrue((String) map.get("isfavorite")));
        setIs3SFavorited(SDKUtil.stringToBooleanOf1IsTrue((String) map.get("is3Sfavorite")));
        setDirId(String.valueOf((Integer) map.get("dirid")));
        setIsPurchased(SDKUtil.stringToBooleanOf1IsTrue((String) map.get("ispurchased")));
        setIsLocked(SDKUtil.stringToBooleanOf1IsTrue((String) map.get("islocked")));
        setChannelUrl((String) map.get(ParamConst.CHANNEL_INFO_RSP_CHANNELURL));
        setTimeShiftUrl((String) map.get(ParamConst.CHANNEL_INFO_RSP_TIMESHIFTURL));
        setCDNChannelList((List) map.get(ParamConst.CHANNEL_INFO_RSP_CDNCHANNELINFO));
        setCurrentPrevueList((List) map.get(ParamConst.CHANNEL_INFO_RSP_PREVUELIST));
    }

    public String getAdvertiseContent() {
        return this.AdvertiseContent;
    }

    public String getAudioLang() {
        return this.AudioLang;
    }

    public String getBitRate() {
        return this.BitRate;
    }

    public String getBoCode() {
        return this.BoCode;
    }

    public List<com.zte.iptvclient.android.mobile.search.bean.a> getCDNChannelList() {
        return this.CDNChannelInfoList;
    }

    public String getChannelCode() {
        return this.ChannelCode;
    }

    public String getChannelName() {
        return this.ChannelName;
    }

    public ChannelType getChannelType() {
        return this.ChannelType;
    }

    public String getChannelUrl() {
        return this.ChannelUrl;
    }

    public String getColumnCode() {
        return this.ColumnCode;
    }

    public String getColumnName() {
        return this.ColumnName;
    }

    public List<c> getCurrentPrevueList() {
        return this.PrevueList;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getDirId() {
        return this.DirId;
    }

    public String getErrorMsg() {
        return this.ErrorMsg;
    }

    public int getFavoriteState() {
        return this.mIsFavorite;
    }

    public String getFileName() {
        return this.FileName;
    }

    public boolean getIs3SFavorited() {
        return this.is3SFavorited;
    }

    public boolean getIsChannelInfoBack() {
        return this.isChannelInfoBack;
    }

    public boolean getIsFavorited() {
        return this.isFavorited;
    }

    public boolean getIsIPPVEnable() {
        return this.isIPPVEnable;
    }

    public boolean getIsLPVREnable() {
        return this.isLPVREnable;
    }

    public boolean getIsLocalTimeShift() {
        return this.isLocalTimeShift;
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public boolean getIsNPVREnable() {
        return this.isNPVREnable;
    }

    public boolean getIsParentControlEnable() {
        return this.isParentControlEnable;
    }

    public boolean getIsPurchased() {
        return this.isPurchased;
    }

    public boolean getIsTVEnable() {
        return this.isTVEnable;
    }

    public String getMediaCode() {
        return this.MediaCode;
    }

    public String getMediaServices() {
        return this.MediaServices;
    }

    public String getMixNo() {
        return this.MixNo;
    }

    public String getRatingId() {
        return this.RatingId;
    }

    public int getReturnCode() {
        return this.ReturnCode;
    }

    public String getSortNum() {
        return this.SortNum;
    }

    public String getSubTitleLang() {
        return this.SubTitleLang;
    }

    public String getTelecomCode() {
        return this.TelecomCode;
    }

    public String getTimeShiftUrl() {
        return this.TimeShiftURL;
    }

    public int getTotalCount() {
        return this.TotalCount;
    }

    public String getUserMixNo() {
        return this.UserMixNo;
    }

    public void setAdvertiseContent(String str) {
        this.AdvertiseContent = str;
    }

    public void setAudioLang(String str) {
        this.AudioLang = str;
    }

    public void setBitRate(String str) {
        this.BitRate = str;
    }

    public void setBoCode(String str) {
        this.BoCode = str;
    }

    public void setCDNChannelList(List<com.zte.iptvclient.android.mobile.search.bean.a> list) {
        this.CDNChannelInfoList = list;
    }

    public void setChannelCode(String str) {
        this.ChannelCode = str;
    }

    public void setChannelInfoBack(boolean z) {
        this.isChannelInfoBack = z;
    }

    public void setChannelName(String str) {
        this.ChannelName = str;
    }

    public void setChannelType(ChannelType channelType) {
        this.ChannelType = channelType;
    }

    public void setChannelUrl(String str) {
        this.ChannelUrl = str;
    }

    public void setColumnCode(String str) {
        this.ColumnCode = str;
    }

    public void setColumnName(String str) {
        this.ColumnName = str;
    }

    public void setCurrentPrevueList(List<c> list) {
        this.PrevueList = list;
    }

    public void setDescription(String str) {
        this.Description = str;
    }

    public void setDirId(String str) {
        this.DirId = str;
    }

    public void setErrorMsg(String str) {
        this.ErrorMsg = str;
    }

    public void setFileName(String str) {
        this.FileName = str;
    }

    public void setIs3SFavorited(boolean z) {
        this.is3SFavorited = z;
    }

    public void setIsFavorited(boolean z) {
        this.isFavorited = z;
    }

    public void setIsIPPVEnable(boolean z) {
        this.isIPPVEnable = z;
    }

    public void setIsLPVREnable(boolean z) {
        this.isLPVREnable = z;
    }

    public void setIsLocalTimeShift(boolean z) {
        this.isLocalTimeShift = z;
    }

    public void setIsLocked(boolean z) {
        this.isLocked = z;
    }

    public void setIsNPVREnable(boolean z) {
        this.isNPVREnable = z;
    }

    public void setIsParentControlEnable(boolean z) {
        this.isParentControlEnable = z;
    }

    public void setIsPurchased(boolean z) {
        this.isPurchased = z;
    }

    public void setIsTVEnable(boolean z) {
        this.isTVEnable = z;
    }

    public void setMediaCode(String str) {
        this.MediaCode = str;
    }

    public void setMediaServices(String str) {
        this.MediaServices = str;
    }

    public void setMixNo(String str) {
        this.MixNo = str;
    }

    public void setRatingId(String str) {
        this.RatingId = str;
    }

    public void setReturnCode(int i) {
        this.ReturnCode = i;
    }

    public void setSortNum(String str) {
        this.SortNum = str;
    }

    public void setSubTitleLang(String str) {
        this.SubTitleLang = str;
    }

    public void setTelecomCode(String str) {
        this.TelecomCode = str;
    }

    public void setTimeShiftUrl(String str) {
        this.TimeShiftURL = str;
    }

    public void setTotalCount(int i) {
        this.TotalCount = i;
    }

    public void setUserMixNo(String str) {
        this.UserMixNo = str;
    }

    public Channel(Map<String, Object> map) {
        channelMapToBean(map);
    }
}
