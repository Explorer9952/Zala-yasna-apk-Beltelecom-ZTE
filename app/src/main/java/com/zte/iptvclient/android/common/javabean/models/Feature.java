package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.bean.Product;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Feature implements Serializable {
    private String autocontinueoption;
    private String begintime;
    private String createtime;
    private String cycparam;
    private String cyctype;
    private String cycunit;
    private String endtime;
    private String epgorder;
    private String featurecode;
    private String featuretype;
    private String featurevalue;
    private String fee;
    private String iscontinue;
    private String listprice;
    private String orderno;
    private String price;
    private String productcode;
    private String productdesc;
    private String productname;
    private String producttype;
    private String rentalterm;
    private String rentalunit;
    private String subcode;
    private String terminalflags;
    private String valuetype;

    public static Feature getChannelFromJSon(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Feature feature = new Feature();
        try {
            feature.setProductcode(jSONObject.optString("productcode"));
            feature.setProductname(jSONObject.optString("productname"));
            feature.setPrice(jSONObject.optString("price"));
            feature.setProducttype(jSONObject.optString("producttype"));
            feature.setEpgorder(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_IF_EPGORDER));
            feature.setIscontinue(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_ISCONTINUE));
            feature.setCyctype(jSONObject.optString("cyctype"));
            feature.setCycunit(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_CYCUNIT));
            feature.setCycparam(jSONObject.optString(ParamConst.ORDERED_PRODUCT_QUERY_RSP_CYCPARAM));
            feature.setOrderno(jSONObject.optString("orderno"));
            feature.setCreatetime(jSONObject.optString("createtime"));
            feature.setBegintime(jSONObject.optString("begintime"));
            feature.setEndtime(jSONObject.optString("endtime"));
            feature.setFeaturetype(jSONObject.optString("featuretype"));
            feature.setFeaturecode(jSONObject.optString("featurecode"));
            feature.setValuetype(jSONObject.optString("valuetype"));
            feature.setFeaturevalue(jSONObject.optString("featurevalue"));
            feature.setTerminalflags(jSONObject.optString("terminalflags"));
            feature.setSubcode(jSONObject.optString("subcode"));
            feature.setProductdesc(jSONObject.optString(ParamConst.AUTH_RSP_PRODUCTDESC));
            feature.setFee(jSONObject.optString("fee"));
            feature.setRentalterm(jSONObject.optString("rentalterm"));
            feature.setRentalunit(jSONObject.optString("rentalunit"));
            feature.setAutocontinueoption(jSONObject.optString(ParamConst.AUTH_RSP_AUTOCONTINUEOPTION));
            feature.setListprice(jSONObject.optString(ParamConst.AUTH_RSP_LISTPRICE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feature;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(Feature.class.getName(), "readObject");
    }

    public static Product switchCommonProduct(Feature feature) {
        Product product = new Product();
        if (feature != null) {
            try {
                product.setRentalterm(feature.getRentalterm());
                product.setRentalunit(feature.getRentalunit());
                product.setTerminalflags(feature.getTerminalflags());
                product.setFee(feature.getFee());
                product.setPurchasetype(feature.getProducttype());
                product.setProductdesc(feature.getProductdesc());
                product.setProductname(feature.getProductname());
                product.setProductcode(feature.getProductcode());
                product.setAutocontinueoption(feature.getAutocontinueoption());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(Feature.class.getName(), "writeObject");
    }

    public String getAutocontinueoption() {
        return this.autocontinueoption;
    }

    public String getBegintime() {
        return this.begintime;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getCycparam() {
        return this.cycparam;
    }

    public String getCyctype() {
        return this.cyctype;
    }

    public String getCycunit() {
        return this.cycunit;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getEpgorder() {
        return this.epgorder;
    }

    public String getFeaturecode() {
        return this.featurecode;
    }

    public String getFeaturetype() {
        return this.featuretype;
    }

    public String getFeaturevalue() {
        return this.featurevalue;
    }

    public String getFee() {
        return this.fee;
    }

    public String getIscontinue() {
        return this.iscontinue;
    }

    public String getListprice() {
        return this.listprice;
    }

    public String getOrderno() {
        return this.orderno;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProductcode() {
        return this.productcode;
    }

    public String getProductdesc() {
        return this.productdesc;
    }

    public String getProductname() {
        return this.productname;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getRentalterm() {
        return this.rentalterm;
    }

    public String getRentalunit() {
        return this.rentalunit;
    }

    public String getSubcode() {
        return this.subcode;
    }

    public String getTerminalflags() {
        return this.terminalflags;
    }

    public String getValuetype() {
        return this.valuetype;
    }

    public void setAutocontinueoption(String str) {
        this.autocontinueoption = str;
    }

    public void setBegintime(String str) {
        this.begintime = str;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public void setCycparam(String str) {
        this.cycparam = str;
    }

    public void setCyctype(String str) {
        this.cyctype = str;
    }

    public void setCycunit(String str) {
        this.cycunit = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setEpgorder(String str) {
        this.epgorder = str;
    }

    public void setFeaturecode(String str) {
        this.featurecode = str;
    }

    public void setFeaturetype(String str) {
        this.featuretype = str;
    }

    public void setFeaturevalue(String str) {
        this.featurevalue = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setIscontinue(String str) {
        this.iscontinue = str;
    }

    public void setListprice(String str) {
        this.listprice = str;
    }

    public void setOrderno(String str) {
        this.orderno = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProductcode(String str) {
        this.productcode = str;
    }

    public void setProductdesc(String str) {
        this.productdesc = str;
    }

    public void setProductname(String str) {
        this.productname = str;
    }

    public void setProducttype(String str) {
        this.producttype = str;
    }

    public void setRentalterm(String str) {
        this.rentalterm = str;
    }

    public void setRentalunit(String str) {
        this.rentalunit = str;
    }

    public void setSubcode(String str) {
        this.subcode = str;
    }

    public void setTerminalflags(String str) {
        this.terminalflags = str;
    }

    public void setValuetype(String str) {
        this.valuetype = str;
    }
}
