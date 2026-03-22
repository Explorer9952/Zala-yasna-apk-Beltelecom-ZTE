package kotlin.text;

import com.zte.ucs.tvcall.Commons;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class RegexOption implements e {
    private static final /* synthetic */ RegexOption[] $VALUES;
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;
    public static final RegexOption LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    static {
        RegexOption regexOption = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = regexOption;
        RegexOption regexOption2 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = regexOption2;
        int i = 0;
        int i2 = 2;
        kotlin.jvm.internal.d dVar = null;
        RegexOption regexOption3 = new RegexOption("LITERAL", 2, 16, i, i2, dVar);
        LITERAL = regexOption3;
        RegexOption regexOption4 = new RegexOption("UNIX_LINES", 3, 1, i, i2, dVar);
        UNIX_LINES = regexOption4;
        RegexOption regexOption5 = new RegexOption("COMMENTS", 4, 4, i, i2, dVar);
        COMMENTS = regexOption5;
        RegexOption regexOption6 = new RegexOption("DOT_MATCHES_ALL", 5, 32, i, i2, dVar);
        DOT_MATCHES_ALL = regexOption6;
        RegexOption regexOption7 = new RegexOption("CANON_EQ", 6, Commons.MSG_MCSP_INIT_SUCCESS, i, i2, dVar);
        CANON_EQ = regexOption7;
        $VALUES = new RegexOption[]{regexOption, regexOption2, regexOption3, regexOption4, regexOption5, regexOption6, regexOption7};
    }

    private RegexOption(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.e
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.e
    public int getValue() {
        return this.value;
    }

    /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, kotlin.jvm.internal.d dVar) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }
}
