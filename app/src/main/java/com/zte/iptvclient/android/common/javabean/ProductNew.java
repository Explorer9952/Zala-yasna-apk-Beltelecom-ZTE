package com.zte.iptvclient.android.common.javabean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ProductNew implements Serializable {
    private static final long serialVersionUID = 400258144285817244L;
    public String autocontinueoption;
    public String balance;
    public String billdate;
    public String chargetype;
    public String columncode;
    public String contentcode;
    public String effecttime;
    public String endtime;
    public String fee;
    public String limittimes;
    public String listprice;
    public String ordertype;
    public String previewendtime;
    public String previewstarttime;
    public String prevueName;
    public String productcode;
    public String productdesc;
    public String productname;
    public String purchasephone;
    public String purchasetype;
    public String rentalterm;
    public String rentalunit;
    public String reserve1;
    public String servicecode;
    public String starttime;
    public String terminalflags;
    public String userscenetype;
    public String areatype = "0";
    private boolean isSelector = false;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
    }

    public String getAreatype() {
        return this.areatype;
    }

    public String getAutocontinueoption() {
        return this.autocontinueoption;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getBilldate() {
        return this.billdate;
    }

    public String getChargetype() {
        return this.chargetype;
    }

    public String getColumncode() {
        return this.columncode;
    }

    public String getContentcode() {
        return this.contentcode;
    }

    public String getEffecttime() {
        return this.effecttime;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getFee() {
        return this.fee;
    }

    public String getLimittimes() {
        return this.limittimes;
    }

    public String getListprice() {
        return this.listprice;
    }

    public String getOrdertype() {
        return this.ordertype;
    }

    public String getPreviewendtime() {
        return this.previewendtime;
    }

    public String getPreviewstarttime() {
        return this.previewstarttime;
    }

    public String getPrevueName() {
        return this.prevueName;
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

    public String getPurchasephone() {
        return this.purchasephone;
    }

    public String getPurchasetype() {
        return this.purchasetype;
    }

    public String getRentalterm() {
        return this.rentalterm;
    }

    public String getRentalunit() {
        return this.rentalunit;
    }

    public String getReserve1() {
        return this.reserve1;
    }

    public String getServicecode() {
        return this.servicecode;
    }

    public String getStarttime() {
        return this.starttime;
    }

    public String getTerminalflags() {
        return this.terminalflags;
    }

    public String getUserscenetype() {
        return this.userscenetype;
    }

    public boolean isSelector() {
        return this.isSelector;
    }

    public void setAreatype(String str) {
        this.areatype = str;
    }

    public void setAutocontinueoption(String str) {
        this.autocontinueoption = str;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setBilldate(String str) {
        this.billdate = str;
    }

    public void setChargetype(String str) {
        this.chargetype = str;
    }

    public void setColumncode(String str) {
        this.columncode = str;
    }

    public void setContentcode(String str) {
        this.contentcode = str;
    }

    public void setEffecttime(String str) {
        this.effecttime = str;
    }

    public void setEndtime(String str) {
        this.endtime = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setLimittimes(String str) {
        this.limittimes = str;
    }

    public void setListprice(String str) {
        this.listprice = str;
    }

    public void setOrdertype(String str) {
        this.ordertype = str;
    }

    public void setPreviewendtime(String str) {
        this.previewendtime = str;
    }

    public void setPreviewstarttime(String str) {
        this.previewstarttime = str;
    }

    public void setPrevueName(String str) {
        this.prevueName = str;
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

    public void setPurchasephone(String str) {
        this.purchasephone = str;
    }

    public void setPurchasetype(String str) {
        this.purchasetype = str;
    }

    public void setRentalterm(String str) {
        this.rentalterm = str;
    }

    public void setRentalunit(String str) {
        this.rentalunit = str;
    }

    public void setReserve1(String str) {
        this.reserve1 = str;
    }

    public void setSelector(boolean z) {
        this.isSelector = z;
    }

    public void setServicecode(String str) {
        this.servicecode = str;
    }

    public void setStarttime(String str) {
        this.starttime = str;
    }

    public void setTerminalflags(String str) {
        this.terminalflags = str;
    }

    public void setUserscenetype(String str) {
        this.userscenetype = str;
    }
}
