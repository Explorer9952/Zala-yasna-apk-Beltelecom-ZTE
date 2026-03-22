package com.zte.iptvclient.android.common.javabean.column;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ColumnBean implements Serializable {
    private static final long serialVersionUID = 123456789;
    private String advertised;
    private String columntype;
    private String description;
    private String hasposter;
    private String mColumnCode;
    private String mColumnName;
    private String parentcode;
    private String posterfilelist;
    private String sortnum;
    private String status;
    private String subexist;
    private String systemLimitEnable;
    private String telecomcode;
    private String version;

    public static ColumnBean getColumnBeanFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ColumnBean columnBean = new ColumnBean();
        try {
            columnBean.setColumnCode(jSONObject.optString("columncode"));
            columnBean.setColumnName(jSONObject.optString("columnname"));
            columnBean.setParentcode(jSONObject.optString(ParamConst.COLUMN_INFO_RSP_PARENTCODE));
            columnBean.setColumntype(jSONObject.optString(ParamConst.COLUMN_INFO_RSP_COLUMNTYPE));
            columnBean.setSubexist(jSONObject.optString(ParamConst.COLUMN_INFO_RSP_SUBEXIST));
            columnBean.setSortnum(jSONObject.optString("sortnum"));
            columnBean.setPosterfilelist(jSONObject.optString("posterfilelist"));
            columnBean.setAdvertised(jSONObject.optString(ParamConst.COLUMN_INFO_RSP_ADVERTISED));
            columnBean.setDescription(jSONObject.optString("description"));
            columnBean.setHasposter(jSONObject.optString(ParamConst.COLUMN_INFO_RSP_HASPOSTER));
            columnBean.setStatus(jSONObject.optString("status"));
            columnBean.setTelecomcode(jSONObject.optString("telecomcode"));
            columnBean.setSystemLimitEnable(jSONObject.optString("systemlimitenable"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnBean;
    }

    public static ColumnBean getColumnBeanFromPCTJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ColumnBean columnBean = new ColumnBean();
        try {
            columnBean.setColumnCode(jSONObject.optString("id"));
            columnBean.setColumnName(jSONObject.optString("name"));
            columnBean.setVersion(jSONObject.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(ColumnBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(ColumnBean.class.getName(), "writeObject");
    }

    public String getAdvertised() {
        return this.advertised;
    }

    public String getColumnCode() {
        return this.mColumnCode;
    }

    public String getColumnName() {
        return TextUtils.isEmpty(this.mColumnName) ? "" : this.mColumnName;
    }

    public String getColumntype() {
        return this.columntype;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHasposter() {
        return this.hasposter;
    }

    public String getParentcode() {
        return this.parentcode;
    }

    public String getPosterfilelist() {
        return this.posterfilelist;
    }

    public String getSortnum() {
        return this.sortnum;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSubexist() {
        return this.subexist;
    }

    public String getSystemLimitEnable() {
        return this.systemLimitEnable;
    }

    public String getTelecomcode() {
        return this.telecomcode;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdvertised(String str) {
        this.advertised = str;
    }

    public void setColumnCode(String str) {
        this.mColumnCode = str;
    }

    public void setColumnName(String str) {
        this.mColumnName = str;
    }

    public void setColumntype(String str) {
        this.columntype = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHasposter(String str) {
        this.hasposter = str;
    }

    public void setParentcode(String str) {
        this.parentcode = str;
    }

    public void setPosterfilelist(String str) {
        this.posterfilelist = str;
    }

    public void setSortnum(String str) {
        this.sortnum = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSubexist(String str) {
        this.subexist = str;
    }

    public void setSystemLimitEnable(String str) {
        this.systemLimitEnable = str;
    }

    public void setTelecomcode(String str) {
        this.telecomcode = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "ColumnBean{mColumnCode='" + this.mColumnCode + "', mColumnName='" + this.mColumnName + "', parentcode='" + this.parentcode + "', columntype='" + this.columntype + "', subexist='" + this.subexist + "', sortnum='" + this.sortnum + "', posterfilelist='" + this.posterfilelist + "', advertised='" + this.advertised + "', description='" + this.description + "', hasposter='" + this.hasposter + "', status='" + this.status + "', telecomcode='" + this.telecomcode + "', version='" + this.version + "', systemLimitEnable='" + this.systemLimitEnable + "'}";
    }
}
