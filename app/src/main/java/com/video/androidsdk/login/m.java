package com.video.androidsdk.login;

import java.util.HashMap;
import java.util.Properties;

/* compiled from: LoginInfoStore.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f3202a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Properties f3203b;

    public static HashMap<String, String> a() {
        return f3202a;
    }

    public static void b() {
        f3202a.clear();
        Properties properties = f3203b;
        if (properties != null) {
            properties.clear();
            f3203b = null;
        }
    }

    public static Properties c() {
        return f3203b;
    }

    public static void a(Properties properties) {
        f3203b = properties;
    }
}
