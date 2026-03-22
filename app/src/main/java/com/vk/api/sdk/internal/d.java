package com.vk.api.sdk.internal;

import android.os.Bundle;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VKErrorUtils.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3925a = new d();

    private d() {
    }

    private final Set<Integer> b(String str) {
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("execute_errors");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(Integer.valueOf(jSONArray.getJSONObject(i).getInt("error_code")));
        }
        return hashSet;
    }

    public final boolean a(@NotNull String str) {
        f.b(str, "response");
        return b.f3919a.a(str, "error");
    }

    public final boolean a(@NotNull String str, @Nullable int[] iArr) {
        f.b(str, "response");
        if (b.f3919a.a(str, "execute_errors")) {
            if (iArr == null) {
                return true;
            }
            Set<Integer> b2 = b(str);
            for (int i : iArr) {
                b2.remove(Integer.valueOf(i));
            }
            if (!b2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final VKApiException a(@NotNull String str, @Nullable String str2) {
        f.b(str, "errorJson");
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
        f.a((Object) optJSONObject, "JSONObject(errorJson).op…t(VKApiCodes.PARAM_ERROR)");
        return a(optJSONObject, str2);
    }

    public static /* synthetic */ VKApiException a(d dVar, JSONObject jSONObject, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return dVar.a(jSONObject, str);
    }

    @NotNull
    public final VKApiException a(@NotNull JSONObject jSONObject, @Nullable String str) {
        f.b(jSONObject, "errorJson");
        try {
            int i = jSONObject.getInt("error_code");
            Bundle bundle = null;
            if (i == 5) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ban_info");
                if (optJSONObject != null) {
                    bundle = new Bundle();
                    bundle.putString("user_ban_info", optJSONObject.toString());
                }
            } else if (i == 14) {
                bundle = new Bundle();
                bundle.putString("captcha_sid", jSONObject.getString("captcha_sid"));
                bundle.putString("captcha_img", jSONObject.getString("captcha_img"));
            } else if (i == 17) {
                bundle = new Bundle();
                bundle.putString("validation_url", jSONObject.getString("redirect_uri"));
            } else if (i == 24) {
                bundle = new Bundle();
                bundle.putString("confirmation_text", jSONObject.getString("confirmation_text"));
            } else if (i == 3609) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("extend_hash", jSONObject.optString("extend_hash", null));
                bundle = bundle2;
            }
            return VKApiExecutionException.Companion.a(jSONObject, str, bundle);
        } catch (Exception e) {
            return new VKApiIllegalResponseException(e);
        }
    }

    @NotNull
    public final VKApiException a(@NotNull String str, @NotNull String str2, @Nullable int[] iArr) {
        f.b(str, "response");
        f.b(str2, "method");
        JSONArray jSONArray = new JSONObject(str).getJSONArray("execute_errors");
        f.a((Object) jSONArray, "JSONObject(response).get…des.PARAM_EXECUTE_ERRORS)");
        return a(jSONArray, str2, iArr);
    }

    private final VKApiException a(JSONArray jSONArray, String str, int[] iArr) {
        int i;
        int code;
        boolean a2;
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            while (i < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f.a((Object) jSONObject, "errorsJson.getJSONObject(i)");
                VKApiException a3 = a(this, jSONObject, null, 2, null);
                if (!(a3 instanceof VKApiExecutionException) || (code = ((VKApiExecutionException) a3).getCode()) == 1 || code == 14 || code == 17 || code == 4 || code == 5 || code == 6 || code == 9 || code == 10 || code == 24 || code == 25) {
                    return a3;
                }
                if (iArr != null) {
                    a2 = kotlin.collections.f.a(iArr, ((VKApiExecutionException) a3).getCode());
                    i = a2 ? i + 1 : 0;
                }
                arrayList.add(a3);
            }
            return new VKApiExecutionException(Integer.MIN_VALUE, str, false, "", null, arrayList, null, 64, null);
        } catch (JSONException e) {
            return new VKApiIllegalResponseException(e);
        }
    }
}
