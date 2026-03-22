package com.zte.iptvclient.android.mobile.order.bean;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.k.x;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class OrderRecordBean implements Serializable, Comparable<OrderRecordBean> {
    private static String TAG = OrderRecordBean.class.getSimpleName();
    private String autocontinue;
    private String begintime;
    private String cdrtype;
    private String channelcode;
    private String columncode;
    private String contentcode;
    private String contentname;
    private String contentprodtype;
    private String cpcode;
    private String endtime;
    private String epgorder = "";
    private String feecost;
    private String paytype;
    private String posterfilelist;
    private String posterpath;
    private Double price;
    private String productcode;
    private String producttype;
    private String programcode;
    private String programtype;
    private String seriesnum;
    private String seriesprogramcode;
    private String status;

    public static OrderRecordBean getOrderRecordBeanFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OrderRecordBean orderRecordBean = new OrderRecordBean();
        try {
            orderRecordBean.setAutocontinue(jSONObject.optString(ParamConst.ORDERED_SVOD_HISTORY_QUERY_RSP_AUTOCONTINUE));
            orderRecordBean.setProductcode(jSONObject.optString("productcode"));
            orderRecordBean.setProducttype(jSONObject.optString("producttype"));
            orderRecordBean.setPrice(Double.valueOf(jSONObject.optDouble("price")));
            orderRecordBean.setBegintime(jSONObject.optString("begintime"));
            orderRecordBean.setEndtime(jSONObject.optString("endtime"));
            orderRecordBean.setStatus(jSONObject.optString("status"));
            orderRecordBean.setContentname(jSONObject.optString("contentname"));
            orderRecordBean.setColumncode(jSONObject.optString("columncode"));
            orderRecordBean.setProgramcode(jSONObject.optString("programcode"));
            orderRecordBean.setProgramtype(jSONObject.optString("programtype"));
            orderRecordBean.setContentcode(jSONObject.optString("contentcode"));
            orderRecordBean.setCpcode(jSONObject.optString("cpcode"));
            orderRecordBean.setSeriesprogramcode(jSONObject.optString("seriesprogramcode"));
            orderRecordBean.setSeriesnum(jSONObject.optString("seriesnum"));
            orderRecordBean.setContentprodtype(jSONObject.optString("contentprodtype"));
            orderRecordBean.setPosterpath(jSONObject.optString("posterpath"));
            orderRecordBean.setPosterfilelist(jSONObject.optString("posterfilelist"));
            orderRecordBean.setCdrtype(jSONObject.optString("cdrtype"));
            orderRecordBean.setFeecost(jSONObject.optString(ParamConst.ORDERED_PPV_HISTORY_QUERY_RSP_FEECOST));
            orderRecordBean.setPaytype(jSONObject.optString("paytype"));
            orderRecordBean.setEpgorder(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_IF_EPGORDER));
            orderRecordBean.setChannelcode(jSONObject.optString("channelcode"));
        } catch (Exception e) {
            LogEx.e(TAG, e.getMessage());
        }
        return orderRecordBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(OrderRecordBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(OrderRecordBean.class.getName(), "writeObject");
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof OrderRecordBean) && compareTo((OrderRecordBean) obj) == 0;
    }

    public String getAutocontinue() {
        return this.autocontinue;
    }

    public String getBegintime() {
        return this.begintime;
    }

    public String getCdrtype() {
        return this.cdrtype;
    }

    public String getChannelcode() {
        return this.channelcode;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getContentname() {
        return this.contentname;
    }

    public String getContentprodtype() {
        return this.contentprodtype;
    }

    public String getCpcode() {
        return this.cpcode;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getEpgorder() {
        return this.epgorder;
    }

    public String getFeecost() {
        return this.feecost;
    }

    public String getPaytype() {
        return this.paytype;
    }

    public String getPosterfilelist() {
        return this.posterfilelist;
    }

    public String getPosterpath() {
        return this.posterpath;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getProductcode() {
        return this.productcode;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getProgramcode() {
        return this.programcode;
    }

    public String getProgramtype() {
        return this.programtype;
    }

    public String getSeriesnum() {
        return this.seriesnum;
    }

    public String getSeriesprogramcode() {
        return this.seriesprogramcode;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.begintime)) {
            return super.hashCode();
        }
        return this.begintime.intern().hashCode();
    }

    public void setAutocontinue(String str) {
        this.autocontinue = str;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setCdrtype(String str) {
        this.cdrtype = str;
    }

    public void setChannelcode(String str) {
        this.channelcode = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setContentname(String str) {
        this.contentname = str;
    }

    public void setContentprodtype(String str) {
        this.contentprodtype = str;
    }

    public void setCpcode(String str) {
        this.cpcode = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setEpgorder(String str) {
        this.epgorder = str;
    }

    public void setFeecost(String str) {
        this.feecost = str;
    }

    public void setPaytype(String str) {
        this.paytype = str;
    }

    public void setPosterfilelist(String str) {
        this.posterfilelist = str;
    }

    public void setPosterpath(String str) {
        this.posterpath = str;
    }

    public void setPrice(Double d2) {
        this.price = d2;
    }

    public void setProductcode(String str) {
        this.productcode = str;
    }

    public void setProducttype(String str) {
        this.producttype = str;
    }

    public void setProgramcode(String str) {
        this.programcode = str;
    }

    public void setProgramtype(String str) {
        this.programtype = str;
    }

    public void setSeriesnum(String str) {
        this.seriesnum = str;
    }

    public void setSeriesprogramcode(String str) {
        this.seriesprogramcode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(OrderRecordBean orderRecordBean) {
        if (TextUtils.isEmpty(orderRecordBean.getBegintime()) || TextUtils.isEmpty(getBegintime())) {
            return 0;
        }
        return x.f(orderRecordBean.getBegintime()).compareTo(x.f(getBegintime()));
    }
}
