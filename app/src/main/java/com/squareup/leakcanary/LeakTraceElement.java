package com.squareup.leakcanary;

import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LeakTraceElement implements Serializable {
    public final String className;
    public final String extra;
    public final Holder holder;
    public final String referenceName;
    public final Type type;

    /* loaded from: classes.dex */
    public enum Holder {
        OBJECT,
        CLASS,
        THREAD,
        ARRAY
    }

    /* loaded from: classes.dex */
    public enum Type {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL
    }

    LeakTraceElement(String str, Type type, Holder holder, String str2, String str3) {
        this.referenceName = str;
        this.type = type;
        this.holder = holder;
        this.className = str2;
        this.extra = str3;
    }

    public String toString() {
        String str;
        String str2 = "";
        if (this.type == Type.STATIC_FIELD) {
            str2 = "static ";
        }
        Holder holder = this.holder;
        if (holder == Holder.ARRAY || holder == Holder.THREAD) {
            str2 = str2 + this.holder.name().toLowerCase(Locale.US) + " ";
        }
        String str3 = str2 + this.className;
        if (this.referenceName != null) {
            str = str3 + "." + this.referenceName;
        } else {
            str = str3 + " instance";
        }
        if (this.extra == null) {
            return str;
        }
        return str + " " + this.extra;
    }
}
