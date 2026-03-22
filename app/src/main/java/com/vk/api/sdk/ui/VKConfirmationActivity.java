package com.vk.api.sdk.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.vk.api.sdk.R$string;
import com.vk.api.sdk.m;
import com.vk.api.sdk.r.h;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKConfirmationActivity.kt */
/* loaded from: classes.dex */
public final class VKConfirmationActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4012a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f4013b = new a(null);

    /* compiled from: VKConfirmationActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* compiled from: VKConfirmationActivity.kt */
        /* renamed from: com.vk.api.sdk.ui.VKConfirmationActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class RunnableC0105a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f4014a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f4015b;

            RunnableC0105a(Context context, String str) {
                this.f4014a = context;
                this.f4015b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Intent putExtra = new Intent(this.f4014a, (Class<?>) VKConfirmationActivity.class).addFlags(268435456).putExtra("key_message", this.f4015b);
                f.a((Object) putExtra, "Intent(context, VKConfir…tra(KEY_MESSAGE, message)");
                this.f4014a.startActivity(putExtra);
            }
        }

        private a() {
        }

        public final boolean a() {
            return VKConfirmationActivity.f4012a;
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }

        public final void a(boolean z) {
            VKConfirmationActivity.f4012a = z;
        }

        public final void a(@NotNull Context context, @NotNull String str) {
            f.b(context, "context");
            f.b(str, "message");
            m.a(new RunnableC0105a(context, str), 0L, 2, null);
        }
    }

    /* compiled from: VKConfirmationActivity.kt */
    /* loaded from: classes.dex */
    static final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            VKConfirmationActivity.f4013b.a(true);
            VKConfirmationActivity.this.finish();
        }
    }

    /* compiled from: VKConfirmationActivity.kt */
    /* loaded from: classes.dex */
    static final class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            VKConfirmationActivity.f4013b.a(false);
            VKConfirmationActivity.this.finish();
        }
    }

    /* compiled from: VKConfirmationActivity.kt */
    /* loaded from: classes.dex */
    static final class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            VKConfirmationActivity.f4013b.a(false);
            VKConfirmationActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        h.f3998c.b();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(new FrameLayout(this));
        new AlertDialog.Builder(this, 5).setTitle(R$string.vk_confirm).setMessage(getIntent().getStringExtra("key_message")).setPositiveButton(R.string.ok, new b()).setNegativeButton(R.string.cancel, new c()).setOnCancelListener(new d()).show();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        h.f3998c.b();
    }
}
