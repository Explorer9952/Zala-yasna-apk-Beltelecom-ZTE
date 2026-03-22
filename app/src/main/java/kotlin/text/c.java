package kotlin.text;

import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* compiled from: Charsets.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Charset f8213a;

    static {
        new c();
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.f.a((Object) forName, "Charset.forName(\"UTF-8\")");
        f8213a = forName;
        kotlin.jvm.internal.f.a((Object) Charset.forName(C.UTF16_NAME), "Charset.forName(\"UTF-16\")");
        kotlin.jvm.internal.f.a((Object) Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        kotlin.jvm.internal.f.a((Object) Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        kotlin.jvm.internal.f.a((Object) Charset.forName(C.ASCII_NAME), "Charset.forName(\"US-ASCII\")");
        kotlin.jvm.internal.f.a((Object) Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    private c() {
    }
}
