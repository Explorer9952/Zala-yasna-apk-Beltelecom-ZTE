package c.a.a.a.b;

import android.view.View;
import android.widget.ImageView;

/* compiled from: ImageResourceAttr.java */
/* loaded from: classes.dex */
public class e extends g {
    @Override // c.a.a.a.b.g
    public void a(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (c.a.a.a.d.b.d() == null || !"drawable".equals(this.f1860d)) {
                return;
            }
            imageView.setImageResource(this.f1858b);
        }
    }
}
