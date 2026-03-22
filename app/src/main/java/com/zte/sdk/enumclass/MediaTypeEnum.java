package com.zte.sdk.enumclass;

import com.facebook.share.internal.ShareConstants;

/* loaded from: classes2.dex */
public enum MediaTypeEnum {
    text(10, "TEXT"),
    vcard(18, "VCARD"),
    location(19, "LOCATION"),
    image(20, ShareConstants.IMAGE_URL),
    video(30, ShareConstants.VIDEO_URL),
    audio(40, "AUDIO"),
    articleSingle(51, "ARTICLESINGLE"),
    articleMulti(52, "ARTICLEMULTI"),
    sms(60, "SMS"),
    unknown(0, "UNKNOWN");

    private int code;
    private String value;

    MediaTypeEnum(int i, String str) {
        this.value = "";
        this.code = 0;
        this.code = i;
        this.value = str;
    }

    public static MediaTypeEnum init(int i) {
        return i == text.getCode() ? text : i == vcard.getCode() ? vcard : i == location.getCode() ? location : i == image.getCode() ? image : i == video.getCode() ? video : i == audio.getCode() ? audio : i == articleSingle.getCode() ? articleSingle : i == articleMulti.getCode() ? articleMulti : i == sms.getCode() ? sms : unknown;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
