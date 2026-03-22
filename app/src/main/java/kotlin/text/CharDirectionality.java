package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharDirectionality.kt */
/* loaded from: classes2.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);

    public static final b Companion = new b(null);
    private static final kotlin.d directionalityMap$delegate;
    private final int value;

    /* compiled from: CharDirectionality.kt */
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
        a2 = kotlin.f.a(new kotlin.jvm.b.a<Map<Integer, ? extends CharDirectionality>>() { // from class: kotlin.text.CharDirectionality.a
            @Override // kotlin.jvm.b.a
            @NotNull
            public final Map<Integer, ? extends CharDirectionality> invoke() {
                int a3;
                int a4;
                CharDirectionality[] values = CharDirectionality.values();
                a3 = kotlin.collections.x.a(values.length);
                a4 = kotlin.n.f.a(a3, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a4);
                for (CharDirectionality charDirectionality : values) {
                    linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
                }
                return linkedHashMap;
            }
        });
        directionalityMap$delegate = a2;
    }

    CharDirectionality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
