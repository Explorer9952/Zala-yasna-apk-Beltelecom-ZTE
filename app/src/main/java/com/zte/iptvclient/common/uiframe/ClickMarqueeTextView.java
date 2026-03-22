package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class ClickMarqueeTextView extends TextViewEx implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Object f7878a;

    /* renamed from: b, reason: collision with root package name */
    private Field f7879b;

    /* renamed from: c, reason: collision with root package name */
    private Field f7880c;

    /* renamed from: d, reason: collision with root package name */
    private c f7881d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements c {
        a() {
        }

        @Override // com.zte.iptvclient.common.uiframe.ClickMarqueeTextView.c
        public void a(int i) {
            if (i == 0) {
                ClickMarqueeTextView.this.setEllipsize(TextUtils.TruncateAt.END);
            }
        }

        @Override // com.zte.iptvclient.common.uiframe.ClickMarqueeTextView.c
        public void b(int i) {
        }

        @Override // com.zte.iptvclient.common.uiframe.ClickMarqueeTextView.c
        public void c(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (ClickMarqueeTextView.this.f7881d == null) {
                return false;
            }
            try {
                if (ClickMarqueeTextView.this.f7879b.getInt(ClickMarqueeTextView.this.f7878a) == 1) {
                    ClickMarqueeTextView.this.f7881d.b(ClickMarqueeTextView.this.f7880c.getInt(ClickMarqueeTextView.this.f7878a) - 1);
                }
                if (ClickMarqueeTextView.this.f7879b.getInt(ClickMarqueeTextView.this.f7878a) == 2) {
                    ClickMarqueeTextView.this.f7881d.c(ClickMarqueeTextView.this.f7880c.getInt(ClickMarqueeTextView.this.f7878a) - 1);
                }
                ((Handler) ClickMarqueeTextView.this.f7878a).handleMessage(message);
                if (ClickMarqueeTextView.this.f7879b.getInt(ClickMarqueeTextView.this.f7878a) == 0) {
                    ClickMarqueeTextView.this.f7881d.a(ClickMarqueeTextView.this.f7880c.getInt(ClickMarqueeTextView.this.f7878a));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        /* synthetic */ b(ClickMarqueeTextView clickMarqueeTextView, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i);

        void b(int i);

        void c(int i);
    }

    public ClickMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7878a = null;
        this.f7879b = null;
        this.f7880c = null;
        this.f7881d = new a();
        a(false, 0);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7878a == null) {
            a();
        }
        a(true, 1);
    }

    private void a() {
        try {
            Field declaredField = TextView.class.getDeclaredField("mMarquee");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            this.f7878a = obj;
            if (obj == null) {
                Constructor<?> declaredConstructor = declaredField.getType().getDeclaredConstructor(TextView.class);
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(this);
                this.f7878a = newInstance;
                declaredField.set(this, newInstance);
            }
            Field declaredField2 = this.f7878a.getClass().getDeclaredField("mStatus");
            this.f7879b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = this.f7878a.getClass().getDeclaredField("mRepeatLimit");
            this.f7880c = declaredField3;
            declaredField3.setAccessible(true);
            Field declaredField4 = Handler.class.getDeclaredField("mCallback");
            declaredField4.setAccessible(true);
            declaredField4.set(this.f7878a, new b(this, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClickMarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7878a = null;
        this.f7879b = null;
        this.f7880c = null;
        this.f7881d = new a();
        a(false, 0);
        setOnClickListener(this);
    }
}
