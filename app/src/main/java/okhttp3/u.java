package okhttp3;

import com.video.androidsdk.login.impl.IIPTVLogin;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f8527c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f8528d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    private final String f8529a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f8530b;

    private u(String str, String str2, String str3, @Nullable String str4) {
        this.f8529a = str;
        this.f8530b = str4;
    }

    public static u a(String str) {
        Matcher matcher = f8527c.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f8528d.matcher(str);
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase(IIPTVLogin.LOGIN_PARAM_CHARSET)) {
                        String group2 = matcher2.group(2);
                        if (group2 != null) {
                            if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                                group2 = group2.substring(1, group2.length() - 1);
                            }
                        } else {
                            group2 = matcher2.group(3);
                        }
                        if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                        }
                        str2 = group2;
                    }
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
                }
            }
            return new u(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    @Nullable
    public static u b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && ((u) obj).f8529a.equals(this.f8529a);
    }

    public int hashCode() {
        return this.f8529a.hashCode();
    }

    public String toString() {
        return this.f8529a;
    }

    @Nullable
    public Charset a() {
        return a((Charset) null);
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        try {
            return this.f8530b != null ? Charset.forName(this.f8530b) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
