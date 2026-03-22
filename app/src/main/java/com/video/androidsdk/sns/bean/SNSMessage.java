package com.video.androidsdk.sns.bean;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class SNSMessage {

    /* renamed from: a, reason: collision with root package name */
    String f3872a;

    /* renamed from: b, reason: collision with root package name */
    String f3873b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f3874c;

    /* renamed from: d, reason: collision with root package name */
    String f3875d;
    String e;
    Object f;
    String g;

    public Bitmap getBitmap() {
        return this.f3874c;
    }

    public String getDescription() {
        return this.g;
    }

    public String getLinkURL() {
        return this.e;
    }

    public Object getObj() {
        return this.f;
    }

    public String getPicURL() {
        return this.f3875d;
    }

    public String getText() {
        return this.f3873b;
    }

    public String getTitle() {
        return this.f3872a;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f3874c = bitmap;
    }

    public void setDescription(String str) {
        this.g = str;
    }

    public void setLinkURL(String str) {
        this.e = str;
    }

    public void setObj(Object obj) {
        this.f = obj;
    }

    public void setPicURL(String str) {
        this.f3875d = str;
    }

    public void setText(String str) {
        this.f3873b = str;
    }

    public void setTitle(String str) {
        this.f3872a = str;
    }
}
