package com.video.androidsdk.common;

import android.text.TextUtils;
import com.video.androidsdk.common.util.SecurityUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BaseRequest implements Serializable, Cloneable {
    public static final String LOG_TAG = "BaseRequest";
    private static final long serialVersionUID = 2398273462347561L;
    private int m_iMsgCode = 0;
    private String m_strRequestCode = null;
    private int m_iTimeoutInterval = 0;
    private int m_iPageNum = 0;
    private int m_iRecordNumPerPage = 0;
    private Map<String, String> m_mapRequestParams = new HashMap();
    private List<Integer> m_listOtherSucessResultCodes = null;
    private String m_strSessionId = null;
    private boolean mbEnableAutoRedirect = false;
    private Map<String, String> mHeaderMap = new HashMap();

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        SecurityUtil.securityCheck(objectInputStream.toString(), "read");
        this.m_iMsgCode = objectInputStream.read();
        this.m_strRequestCode = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        SecurityUtil.securityCheck(objectOutputStream.toString(), "write");
        objectOutputStream.write(this.m_iMsgCode);
        objectOutputStream.writeChars(this.m_strRequestCode);
        objectOutputStream.writeObject(this.m_mapRequestParams);
    }

    public void addHeader(String str, String str2) {
        if (str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            return;
        }
        String trim = str.trim();
        String trim2 = str2.trim();
        if (this.mHeaderMap.containsKey(trim)) {
            String str3 = this.mHeaderMap.get(trim);
            if (!TextUtils.isEmpty(str3)) {
                for (String str4 : str3.split(";")) {
                    if (str4.equalsIgnoreCase(trim2)) {
                        return;
                    }
                }
                trim2 = str3 + ";" + trim2;
            }
        }
        this.mHeaderMap.put(trim, trim2);
    }

    public void addOtherSuccessResultCode(int i) {
        if (i == 0) {
            return;
        }
        if (this.m_listOtherSucessResultCodes == null) {
            this.m_listOtherSucessResultCodes = new ArrayList();
        }
        if (this.m_listOtherSucessResultCodes.contains(Integer.valueOf(i))) {
            return;
        }
        this.m_listOtherSucessResultCodes.add(Integer.valueOf(i));
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            SecurityUtil.securityCheck(objectOutputStream.toString(), "writeObject");
            objectOutputStream.writeObject(this);
            return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return super.clone();
        }
    }

    public void enableAutoRedirect(boolean z) {
        this.mbEnableAutoRedirect = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequest)) {
            return false;
        }
        BaseRequest baseRequest = (BaseRequest) obj;
        return this.m_iMsgCode == baseRequest.m_iMsgCode && StringUtil.isSameString(this.m_strRequestCode, baseRequest.m_strRequestCode) && this.m_mapRequestParams.equals(baseRequest.m_mapRequestParams);
    }

    public Map<String, String> getHeaderMap() {
        return this.mHeaderMap;
    }

    public int getMsgCode() {
        return this.m_iMsgCode;
    }

    public List<Integer> getOtherSucessResultCodes() {
        return this.m_listOtherSucessResultCodes;
    }

    public int getPageNum() {
        return this.m_iPageNum;
    }

    public int getRecordNumPerPage() {
        return this.m_iRecordNumPerPage;
    }

    public String getRequestCode() {
        return this.m_strRequestCode;
    }

    public Map<String, String> getRequestParamsMap() {
        return this.m_mapRequestParams;
    }

    public String getSessionId() {
        return this.m_strSessionId;
    }

    public int getTimeoutInterval() {
        return this.m_iTimeoutInterval;
    }

    public int hashCode() {
        return this.m_iMsgCode + (StringUtil.isEmptyString(this.m_strRequestCode) ? 0 : this.m_strRequestCode.hashCode());
    }

    public boolean isAutoRedirect() {
        return this.mbEnableAutoRedirect;
    }

    public boolean isValidateReq() {
        if (this.m_iMsgCode <= 0) {
            LogEx.w(LOG_TAG, "Invalid m_iMsgCode=" + this.m_iMsgCode);
            return false;
        }
        if (this.m_iPageNum >= 0) {
            return true;
        }
        LogEx.w(LOG_TAG, "Invalid m_iPageNum=" + this.m_iPageNum);
        return false;
    }

    public void setMsgCode(int i) {
        this.m_iMsgCode = i;
    }

    public void setPageNum(int i) {
        this.m_iPageNum = i;
    }

    public void setRecordNumPerPage(int i) {
        this.m_iRecordNumPerPage = i;
    }

    public void setRequestCode(String str) {
        this.m_strRequestCode = str;
    }

    public void setRequestParamsMap(Map<String, String> map) {
        this.m_mapRequestParams.putAll(map);
    }

    public void setSessionId(String str) {
        this.m_strSessionId = str;
    }

    public void setTimeoutInterval(int i) {
        if (i > 0) {
            this.m_iTimeoutInterval = i;
        }
    }

    public String toString() {
        return "Req class:" + getClass() + " msgCode:" + this.m_iMsgCode + " reqCode:" + this.m_strRequestCode + " paraMap:" + this.m_mapRequestParams;
    }
}
