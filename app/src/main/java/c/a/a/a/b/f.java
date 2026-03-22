package c.a.a.a.b;

import android.view.View;
import android.widget.AbsListView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: ListSelectorAttr.java */
/* loaded from: classes.dex */
public class f extends g {
    @Override // c.a.a.a.b.g
    public void a(View view) {
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (c.a.a.a.d.b.d().d(this.f1858b) != null) {
                if (TtmlNode.ATTR_TTS_COLOR.equals(this.f1860d)) {
                    if (this.f1858b != 0) {
                        absListView.setSelector(c.a.a.a.d.b.d().b(this.f1858b));
                    }
                } else if ("drawable".equals(this.f1860d)) {
                    absListView.setSelector(c.a.a.a.d.b.d().d(this.f1858b));
                }
            }
        }
    }
}
