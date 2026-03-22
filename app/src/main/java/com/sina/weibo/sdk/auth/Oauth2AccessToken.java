package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Oauth2AccessToken {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mRefreshToken;
    private String mUid;

    public Oauth2AccessToken() {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
    }

    private static String getString(Bundle bundle, String str, String str2) {
        String string;
        return (bundle == null || (string = bundle.getString(str)) == null) ? str2 : string;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("{") < 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString("uid"));
            oauth2AccessToken.setToken(jSONObject.optString("access_token"));
            oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
            oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            return oauth2AccessToken;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return (TextUtils.isEmpty(this.mAccessToken) || this.mExpiresTime == 0 || System.currentTimeMillis() >= this.mExpiresTime) ? false : true;
    }

    public void setExpiresIn(String str) {
        if (TextUtils.isEmpty(str) || str.equals("0")) {
            return;
        }
        setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.mUid);
        bundle.putString("access_token", this.mAccessToken);
        bundle.putString(KEY_REFRESH_TOKEN, this.mRefreshToken);
        bundle.putString("expires_in", Long.toString(this.mExpiresTime));
        return bundle;
    }

    public String toString() {
        return "uid: " + this.mUid + ", access_token: " + this.mAccessToken + ", " + KEY_REFRESH_TOKEN + ": " + this.mRefreshToken + ", expires_in: " + Long.toString(this.mExpiresTime);
    }

    public Oauth2AccessToken(String str) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        if (str == null || str.indexOf("{") < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setUid(jSONObject.optString("uid"));
            setToken(jSONObject.optString("access_token"));
            setExpiresIn(jSONObject.optString("expires_in"));
            setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        oauth2AccessToken.setUid(getString(bundle, "uid", ""));
        oauth2AccessToken.setToken(getString(bundle, "access_token", ""));
        oauth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
        oauth2AccessToken.setRefreshToken(getString(bundle, KEY_REFRESH_TOKEN, ""));
        return oauth2AccessToken;
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mAccessToken = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.mExpiresTime = currentTimeMillis;
        if (str2 != null) {
            this.mExpiresTime = currentTimeMillis + (Long.parseLong(str2) * 1000);
        }
    }
}
