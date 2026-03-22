package c.a.a.a.b;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ListView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: DividerAttr.java */
/* loaded from: classes.dex */
public class d extends g {
    public int e = 1;

    @Override // c.a.a.a.b.g
    public void a(View view) {
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            if (TtmlNode.ATTR_TTS_COLOR.equals(this.f1860d)) {
                listView.setDivider(new ColorDrawable(c.a.a.a.d.b.d().b(this.f1858b)));
                listView.setDividerHeight(this.e);
            } else if ("drawable".equals(this.f1860d)) {
                listView.setDivider(c.a.a.a.d.b.d().d(this.f1858b));
            }
        }
    }
}
