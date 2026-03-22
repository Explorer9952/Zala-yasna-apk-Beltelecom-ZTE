package b.c.a;

import android.database.Cursor;
import android.widget.BaseAdapter;
import android.widget.Filterable;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable {
    public abstract Cursor a();

    public abstract CharSequence a(Cursor cursor);
}
