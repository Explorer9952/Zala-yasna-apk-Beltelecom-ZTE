package com.vk.api.sdk.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.MalformedJsonException;
import java.io.StringReader;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: JsonUtils.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3919a = new b();

    private b() {
    }

    private final boolean b(String str, String str2) {
        JsonToken peek;
        if (str.length() == 0) {
            return false;
        }
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        if (jsonReader.hasNext() && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
            jsonReader.beginObject();
            while (jsonReader.hasNext() && (peek = jsonReader.peek()) != JsonToken.END_DOCUMENT) {
                if (peek != JsonToken.NAME) {
                    jsonReader.skipValue();
                } else if (f.a((Object) str2, (Object) jsonReader.nextName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a(@NotNull String str, @NotNull String str2) {
        f.b(str, "jsonString");
        f.b(str2, "name");
        try {
            return b(str, str2);
        } catch (MalformedJsonException e) {
            throw new MalformedJsonException(e.getMessage() + ". Json: '" + str + '\'');
        }
    }
}
