package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharCategory.kt */
/* loaded from: classes2.dex */
public enum CharCategory {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");

    public static final b Companion = new b(null);
    private static final kotlin.d categoryMap$delegate;

    @NotNull
    private final String code;
    private final int value;

    /* compiled from: CharCategory.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        kotlin.d a2;
        a2 = kotlin.f.a(new kotlin.jvm.b.a<Map<Integer, ? extends CharCategory>>() { // from class: kotlin.text.CharCategory.a
            @Override // kotlin.jvm.b.a
            @NotNull
            public final Map<Integer, ? extends CharCategory> invoke() {
                int a3;
                int a4;
                CharCategory[] values = CharCategory.values();
                a3 = kotlin.collections.x.a(values.length);
                a4 = kotlin.n.f.a(a3, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a4);
                for (CharCategory charCategory : values) {
                    linkedHashMap.put(Integer.valueOf(charCategory.getValue()), charCategory);
                }
                return linkedHashMap;
            }
        });
        categoryMap$delegate = a2;
    }

    CharCategory(int i, String str) {
        this.value = i;
        this.code = str;
    }

    public final boolean contains(char c2) {
        return Character.getType(c2) == this.value;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
