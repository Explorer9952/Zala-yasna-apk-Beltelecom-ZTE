package com.vk.api.sdk.exceptions;

import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: VKApiExecutionException.kt */
/* loaded from: classes.dex */
public class VKApiExecutionException extends VKApiException {
    public static final a Companion = new a(null);
    public static final long serialVersionUID = 7524047853274172872L;

    @NotNull
    private final String apiMethod;
    private final int code;

    @NotNull
    private final String detailMessage;

    @Nullable
    private final String errorMsg;

    @Nullable
    private final List<VKApiExecutionException> executeErrors;

    @Nullable
    private final Bundle extra;
    private final boolean hasLocalizedMessage;

    /* compiled from: VKApiExecutionException.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        @NotNull
        public final VKApiExecutionException a(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable Bundle bundle) {
            f.b(jSONObject, "json");
            if (str == null) {
                str = jSONObject.optString("method");
            }
            String str2 = str != null ? str : "";
            int i = jSONObject.getInt("error_code");
            String optString = jSONObject.optString("error_msg");
            String str3 = optString != null ? optString : "";
            if (jSONObject.has("error_text")) {
                boolean z = true;
                String optString2 = jSONObject.optString("error_text");
                return new VKApiExecutionException(i, str2, z, optString2 != null ? optString2 : "", bundle, null, str3, 32, null);
            }
            String optString3 = jSONObject.optString("error_msg");
            String str4 = optString3 != null ? optString3 : "";
            return new VKApiExecutionException(i, str2, false, str4 + " | by [" + str2 + ']', bundle, null, str4, 32, null);
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    public VKApiExecutionException(int i, @NotNull String str, boolean z, @NotNull String str2) {
        this(i, str, z, str2, null, null, null, 112, null);
    }

    public VKApiExecutionException(int i, @NotNull String str, boolean z, @NotNull String str2, @Nullable Bundle bundle) {
        this(i, str, z, str2, bundle, null, null, 96, null);
    }

    public VKApiExecutionException(int i, @NotNull String str, boolean z, @NotNull String str2, @Nullable Bundle bundle, @Nullable List<? extends VKApiExecutionException> list) {
        this(i, str, z, str2, bundle, list, null, 64, null);
    }

    public /* synthetic */ VKApiExecutionException(int i, String str, boolean z, String str2, Bundle bundle, List list, String str3, int i2, d dVar) {
        this(i, str, z, str2, (i2 & 16) != 0 ? Bundle.EMPTY : bundle, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VKApiExecutionException)) {
            return false;
        }
        VKApiExecutionException vKApiExecutionException = (VKApiExecutionException) obj;
        if (this.code == vKApiExecutionException.code) {
            if (!(this.extra != null ? !f.a(r1, r5) : vKApiExecutionException.extra != null)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String getApiMethod() {
        return this.apiMethod;
    }

    @NotNull
    public final String getCaptchaImg() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("captcha_img", "")) == null) ? "" : string;
    }

    @NotNull
    public final String getCaptchaSid() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("captcha_sid", "")) == null) ? "" : string;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDetailMessage() {
        return this.detailMessage;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    public final List<VKApiExecutionException> getExecuteErrors() {
        return this.executeErrors;
    }

    @NotNull
    public final String getExtensionHash() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("extend_hash", null)) == null) ? "" : string;
    }

    @Nullable
    public final Bundle getExtra() {
        return this.extra;
    }

    public final boolean getHasLocalizedMessage() {
        return this.hasLocalizedMessage;
    }

    @Nullable
    public final JSONObject getUserBanInfo() {
        String string;
        Bundle bundle = this.extra;
        if (bundle == null || (string = bundle.getString("user_ban_info")) == null) {
            return null;
        }
        return new JSONObject(string);
    }

    @NotNull
    public final String getUserConfirmText() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("confirmation_text", "")) == null) ? "" : string;
    }

    @NotNull
    public final String getValidationUrl() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("validation_url", "")) == null) ? "" : string;
    }

    public final boolean hasError(int i) {
        if (this.code == i) {
            return true;
        }
        List<VKApiExecutionException> list = this.executeErrors;
        Object obj = null;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((VKApiExecutionException) next).code == i) {
                    obj = next;
                    break;
                }
            }
            obj = (VKApiExecutionException) obj;
        }
        return obj != null;
    }

    public final boolean hasExtra() {
        Bundle bundle = this.extra;
        return bundle != null && (f.a(bundle, Bundle.EMPTY) ^ true);
    }

    public int hashCode() {
        int i = this.code * 31;
        Bundle bundle = this.extra;
        return i + (bundle != null ? bundle.hashCode() : 0);
    }

    public final boolean isAccessError() {
        int i = this.code;
        return i == 15 || i == 30 || i == 203 || i == 200 || i == 201;
    }

    public final boolean isCaptchaError() {
        return this.code == 14;
    }

    public final boolean isCompositeError() {
        return this.code == Integer.MIN_VALUE;
    }

    public final boolean isInternalServerError() {
        int i = this.code;
        return i == 1 || i == 10 || i == 13;
    }

    public final boolean isInvalidCredentialsError() {
        int i = this.code;
        return i == 4 || i == 5;
    }

    public final boolean isPasswordConfirmRequired() {
        return this.code == 3609;
    }

    public final boolean isTokenConfirmationRequired() {
        return this.code == 25;
    }

    public final boolean isTooManyRequestsError() {
        return this.code == 6;
    }

    public final boolean isUserConfirmRequired() {
        return this.code == 24;
    }

    public final boolean isValidationRequired() {
        return this.code == 17;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VKApiExecutionException{");
        sb.append("code=");
        sb.append(this.code);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(", method=");
        sb.append(this.apiMethod);
        sb.append(", executeErrors=");
        List<VKApiExecutionException> list = this.executeErrors;
        sb.append(list != null ? r.a(list, null, "[", "]", 0, null, null, 57, null) : null);
        sb.append(", super=");
        sb.append(super.toString());
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VKApiExecutionException(int i, @NotNull String str, boolean z, @NotNull String str2, @Nullable Bundle bundle, @Nullable List<? extends VKApiExecutionException> list, @Nullable String str3) {
        super(str2);
        f.b(str, "apiMethod");
        f.b(str2, "detailMessage");
        this.code = i;
        this.apiMethod = str;
        this.hasLocalizedMessage = z;
        this.detailMessage = str2;
        this.extra = bundle;
        this.executeErrors = list;
        this.errorMsg = str3;
    }
}
