package com.video.androidsdk.cast.bean;

/* loaded from: classes.dex */
public class Device {
    private String mHCAbility;
    private String mHCDownload;
    private String mHCDownloadPort;
    private String mHCPort;
    private String mHCStorage;
    private String mSTBAddr;
    private String mSpecVersion = "";
    private String mDeviceType = "";
    private String mFriendlyName = "";
    private String mManufacturer = "";
    private String mManufacturerURL = "";
    private String mModelDescription = "";
    private String mModelName = "";
    private String mModelURL = "";
    private String mUDN = "";
    private String mMac = "";
    private String mUserID = "";
    private String mSTBName = "";
    private String mSTBLanguage = "";
    private String mSTBUserInfo = "";
    private String mDeviceID = "";
    private boolean isDMS = false;
    private boolean isDMR = false;

    public String getDeviceID() {
        return this.mDeviceID;
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public String getFriendlyName() {
        return this.mFriendlyName;
    }

    public String getHCAbility() {
        return this.mHCAbility;
    }

    public String getHCDownload() {
        return this.mHCDownload;
    }

    public String getHCDownloadPort() {
        return this.mHCDownloadPort;
    }

    public String getHCPort() {
        return this.mHCPort;
    }

    public String getHCStorage() {
        return this.mHCStorage;
    }

    public String getMacAddress() {
        return this.mMac;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getManufacturerURL() {
        return this.mManufacturerURL;
    }

    public String getModelDescription() {
        return this.mModelDescription;
    }

    public String getModelName() {
        return this.mModelName;
    }

    public String getModelURL() {
        return this.mModelURL;
    }

    public String getSTBAddr() {
        return this.mSTBAddr;
    }

    public String getSTBLanguage() {
        return this.mSTBLanguage;
    }

    public String getSTBName() {
        return this.mSTBName;
    }

    public String getSTBUserInfo() {
        return this.mSTBUserInfo;
    }

    public String getSpecVersion() {
        return this.mSpecVersion;
    }

    public String getUDN() {
        return this.mUDN;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public boolean isDMR() {
        return this.isDMR;
    }

    public boolean isDMS() {
        return this.isDMS;
    }

    public void setDMR(boolean z) {
        this.isDMR = z;
    }

    public void setDMS(boolean z) {
        this.isDMS = z;
    }

    public void setDeviceID(String str) {
        this.mDeviceID = str;
    }

    public void setDeviceType(String str) {
        this.mDeviceType = str;
    }

    public void setFriendlyName(String str) {
        this.mFriendlyName = str;
    }

    public void setHCAbility(String str) {
        this.mHCAbility = str;
    }

    public void setHCDownload(String str) {
        this.mHCDownload = str;
    }

    public void setHCDownloadPort(String str) {
        this.mHCDownloadPort = str;
    }

    public void setHCPort(String str) {
        this.mHCPort = str;
    }

    public void setHCStorage(String str) {
        this.mHCStorage = str;
    }

    public void setMacAddress(String str) {
        this.mMac = str;
    }

    public void setManufacturer(String str) {
        this.mManufacturer = str;
    }

    public void setManufacturerURL(String str) {
        this.mManufacturerURL = str;
    }

    public void setModelDescription(String str) {
        this.mModelDescription = str;
    }

    public void setModelName(String str) {
        this.mModelName = str;
    }

    public void setModelURL(String str) {
        this.mModelURL = str;
    }

    public void setSTBAddr(String str) {
        this.mSTBAddr = str;
    }

    public void setSTBLanguage(String str) {
        this.mSTBLanguage = str;
    }

    public void setSTBName(String str) {
        this.mSTBName = str;
    }

    public void setSTBUserInfo(String str) {
        this.mSTBUserInfo = str;
    }

    public void setSpecVersion(String str) {
        this.mSpecVersion = str;
    }

    public void setUDN(String str) {
        this.mUDN = str;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }
}
