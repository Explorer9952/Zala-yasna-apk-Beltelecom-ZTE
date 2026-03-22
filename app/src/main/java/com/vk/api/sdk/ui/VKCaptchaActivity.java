package com.vk.api.sdk.ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.api.sdk.R$string;
import com.vk.api.sdk.m;
import com.vk.api.sdk.r.g;
import com.vk.api.sdk.r.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKCaptchaActivity.kt */
/* loaded from: classes.dex */
public final class VKCaptchaActivity extends Activity {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static String f3999d;
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private EditText f4000a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f4001b;

    /* renamed from: c, reason: collision with root package name */
    private ProgressBar f4002c;

    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VKCaptchaActivity.kt */
        /* renamed from: com.vk.api.sdk.ui.VKCaptchaActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class RunnableC0104a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f4003a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f4004b;

            RunnableC0104a(Context context, String str) {
                this.f4003a = context;
                this.f4004b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Intent putExtra = new Intent(this.f4003a, (Class<?>) VKCaptchaActivity.class).addFlags(268435456).putExtra("key_url", this.f4004b);
                kotlin.jvm.internal.f.a((Object) putExtra, "Intent(context, VKCaptch…  .putExtra(KEY_URL, img)");
                this.f4003a.startActivity(putExtra);
            }
        }

        private a() {
        }

        @Nullable
        public final String a() {
            return VKCaptchaActivity.f3999d;
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String str) {
            kotlin.jvm.internal.f.b(context, "context");
            kotlin.jvm.internal.f.b(str, "img");
            m.a(new RunnableC0104a(context, str), 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f4006b;

        b(Bitmap bitmap) {
            this.f4006b = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VKCaptchaActivity.c(VKCaptchaActivity.this).setImageBitmap(this.f4006b);
            VKCaptchaActivity.d(VKCaptchaActivity.this).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4008b;

        c(String str) {
            this.f4008b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.vk.api.sdk.r.f fVar = com.vk.api.sdk.r.f.f3994a;
            String str = this.f4008b;
            kotlin.jvm.internal.f.a((Object) str, "url");
            byte[] a2 = fVar.a(str);
            if (a2 != null) {
                VKCaptchaActivity vKCaptchaActivity = VKCaptchaActivity.this;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length);
                kotlin.jvm.internal.f.a((Object) decodeByteArray, "BitmapFactory.decodeByteArray(data, 0, data.size)");
                vKCaptchaActivity.a(decodeByteArray);
            }
        }
    }

    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    static final class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            VKCaptchaActivity.this.c();
        }
    }

    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    static final class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            VKCaptchaActivity.this.b();
        }
    }

    /* compiled from: VKCaptchaActivity.kt */
    /* loaded from: classes.dex */
    static final class f implements DialogInterface.OnCancelListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            VKCaptchaActivity.this.b();
        }
    }

    public static final /* synthetic */ ImageView c(VKCaptchaActivity vKCaptchaActivity) {
        ImageView imageView = vKCaptchaActivity.f4001b;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.f.d(MessengerShareContentUtility.MEDIA_IMAGE);
        throw null;
    }

    public static final /* synthetic */ ProgressBar d(VKCaptchaActivity vKCaptchaActivity) {
        ProgressBar progressBar = vKCaptchaActivity.f4002c;
        if (progressBar != null) {
            return progressBar;
        }
        kotlin.jvm.internal.f.d("progress");
        throw null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(new FrameLayout(this));
        LinearLayout linearLayout = new LinearLayout(this);
        int a2 = g.f3995a.a(12);
        int max = (int) (Math.max(1.0f, g.f3995a.a()) * 130.0f);
        int max2 = (int) (Math.max(1.0f, g.f3995a.a()) * 50.0f);
        linearLayout.setPadding(a2, a2, a2, a2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(max, max2);
        layoutParams.bottomMargin = a2;
        frameLayout.setLayoutParams(layoutParams);
        this.f4002c = new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        ProgressBar progressBar = this.f4002c;
        if (progressBar != null) {
            progressBar.setLayoutParams(layoutParams2);
            ProgressBar progressBar2 = this.f4002c;
            if (progressBar2 != null) {
                frameLayout.addView(progressBar2);
                this.f4001b = new ImageView(this);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams3.gravity = 17;
                ImageView imageView = this.f4001b;
                if (imageView != null) {
                    imageView.setLayoutParams(layoutParams3);
                    ImageView imageView2 = this.f4001b;
                    if (imageView2 != null) {
                        frameLayout.addView(imageView2);
                        linearLayout.addView(frameLayout);
                        EditText editText = new EditText(this);
                        this.f4000a = editText;
                        editText.setInputType(176);
                        EditText editText2 = this.f4000a;
                        if (editText2 != null) {
                            editText2.setSingleLine(true);
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(max, -2);
                            EditText editText3 = this.f4000a;
                            if (editText3 != null) {
                                editText3.setLayoutParams(layoutParams4);
                                View view = this.f4000a;
                                if (view != null) {
                                    linearLayout.addView(view);
                                    new AlertDialog.Builder(this, 5).setView(linearLayout).setTitle(R$string.vk_captcha_hint).setPositiveButton(R.string.ok, new d()).setNegativeButton(R.string.cancel, new e()).setOnCancelListener(new f()).show();
                                    EditText editText4 = this.f4000a;
                                    if (editText4 != null) {
                                        editText4.requestFocus();
                                        d();
                                        return;
                                    } else {
                                        kotlin.jvm.internal.f.d("input");
                                        throw null;
                                    }
                                }
                                kotlin.jvm.internal.f.d("input");
                                throw null;
                            }
                            kotlin.jvm.internal.f.d("input");
                            throw null;
                        }
                        kotlin.jvm.internal.f.d("input");
                        throw null;
                    }
                    kotlin.jvm.internal.f.d(MessengerShareContentUtility.MEDIA_IMAGE);
                    throw null;
                }
                kotlin.jvm.internal.f.d(MessengerShareContentUtility.MEDIA_IMAGE);
                throw null;
            }
            kotlin.jvm.internal.f.d("progress");
            throw null;
        }
        kotlin.jvm.internal.f.d("progress");
        throw null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        h.f3998c.b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        f3999d = null;
        h.f3998c.b();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        EditText editText = this.f4000a;
        if (editText != null) {
            f3999d = editText.getText().toString();
            h.f3998c.b();
            finish();
            return;
        }
        kotlin.jvm.internal.f.d("input");
        throw null;
    }

    private final void d() {
        m.f3940d.a().submit(new c(getIntent().getStringExtra("key_url")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bitmap bitmap) {
        m.a(new b(bitmap), 0L, 2, null);
    }
}
