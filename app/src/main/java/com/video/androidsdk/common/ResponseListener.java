package com.video.androidsdk.common;

import java.util.UUID;

/* loaded from: classes.dex */
public abstract class ResponseListener {
    UUID uuid;

    public UUID getUUID() {
        return this.uuid;
    }

    public abstract void onResponse(String str, Object obj);

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
