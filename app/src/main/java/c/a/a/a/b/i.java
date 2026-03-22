package c.a.a.a.b;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: TextColorAttr.java */
/* loaded from: classes.dex */
public class i extends g {
    @Override // c.a.a.a.b.g
    public void a(View view) {
        ColorStateList a2;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (c.a.a.a.d.b.d() == null || !TtmlNode.ATTR_TTS_COLOR.equals(this.f1860d) || (a2 = c.a.a.a.d.b.d().a(this.f1858b)) == null) {
                return;
            }
            textView.setTextColor(a2);
        }
    }
}
