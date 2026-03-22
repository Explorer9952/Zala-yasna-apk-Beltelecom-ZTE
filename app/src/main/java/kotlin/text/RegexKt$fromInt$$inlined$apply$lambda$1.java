package kotlin.text;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class RegexKt$fromInt$$inlined$apply$lambda$1<T> extends Lambda implements kotlin.jvm.b.l<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$$inlined$apply$lambda$1(int i) {
        super(1);
        this.$value$inlined = i;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean invoke(Enum r3) {
        e eVar = (e) r3;
        return (this.$value$inlined & eVar.getMask()) == eVar.getValue();
    }
}
