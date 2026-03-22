package c.a.a.a.b;

import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: BackgroundAttr.java */
/* loaded from: classes.dex */
public class b extends g {
    @Override // c.a.a.a.b.g
    public void a(View view) {
        if (TtmlNode.ATTR_TTS_COLOR.equals(this.f1860d)) {
            view.setBackgroundColor(c.a.a.a.d.b.d().b(this.f1858b));
        } else if ("drawable".equals(this.f1860d)) {
            view.setBackground(c.a.a.a.d.b.d().d(this.f1858b));
        }
    }
}
