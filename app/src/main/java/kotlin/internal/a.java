package kotlin.internal;

import com.video.androidsdk.common.ErrMessage;
import java.lang.reflect.Method;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: kotlin.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0420a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public static final Method f8175a;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0047 A[EDGE_INSN: B:10:0x0047->B:11:0x0047 BREAK  A[LOOP:0: B:2:0x0013->B:9:0x0043], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[LOOP:0: B:2:0x0013->B:9:0x0043, LOOP_END] */
        static {
            /*
                kotlin.internal.a$a r0 = new kotlin.internal.a$a
                r0.<init>()
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                kotlin.jvm.internal.f.a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L13:
                if (r4 >= r2) goto L46
                r5 = r1[r4]
                java.lang.String r6 = "it"
                kotlin.jvm.internal.f.a(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = kotlin.jvm.internal.f.a(r6, r7)
                if (r6 == 0) goto L3f
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                kotlin.jvm.internal.f.a(r6, r7)
                java.lang.Object r6 = kotlin.collections.b.b(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = kotlin.jvm.internal.f.a(r6, r0)
                if (r6 == 0) goto L3f
                r6 = 1
                goto L40
            L3f:
                r6 = 0
            L40:
                if (r6 == 0) goto L43
                goto L47
            L43:
                int r4 = r4 + 1
                goto L13
            L46:
                r5 = 0
            L47:
                kotlin.internal.a.C0420a.f8175a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.a.C0420a.<clinit>():void");
        }

        private C0420a() {
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        f.b(th, "cause");
        f.b(th2, ErrMessage.ERRCODE_EXCEPTION);
        Method method = C0420a.f8175a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
