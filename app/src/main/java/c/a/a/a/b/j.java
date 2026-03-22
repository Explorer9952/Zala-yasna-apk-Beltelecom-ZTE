package c.a.a.a.b;

import android.view.View;
import android.widget.TextView;

/* compiled from: TextSizeAttr.java */
/* loaded from: classes.dex */
public class j extends g {
    @Override // c.a.a.a.b.g
    public void a(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if ("dimen".equals(this.f1860d)) {
                textView.setTextSize(c.a.a.a.d.b.d().c(this.f1858b) / view.getResources().getDisplayMetrics().density);
            }
        }
    }
}
