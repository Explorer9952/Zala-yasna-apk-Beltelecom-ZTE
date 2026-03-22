package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i b(@NotNull Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i b(@NotNull Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new j(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n.c b(@NotNull MatchResult matchResult) {
        kotlin.n.c d2;
        d2 = kotlin.n.f.d(matchResult.start(), matchResult.end());
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n.c b(@NotNull MatchResult matchResult, int i) {
        kotlin.n.c d2;
        d2 = kotlin.n.f.d(matchResult.start(i), matchResult.end(i));
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(@NotNull Iterable<? extends e> iterable) {
        Iterator<? extends e> it2 = iterable.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i |= it2.next().getValue();
        }
        return i;
    }
}
