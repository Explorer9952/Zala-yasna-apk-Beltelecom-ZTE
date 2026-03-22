package com.zte.fragmentlib.publicbaseclass.skinloader;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

/* compiled from: BaseFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.iptvclient.android.common.swipeback.a implements c.a.a.a.c.a {

    /* compiled from: BaseFragment.java */
    /* renamed from: com.zte.fragmentlib.publicbaseclass.skinloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        return getActivity().getLayoutInflater();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
        } catch (ClassCastException unused) {
        }
        if (context instanceof InterfaceC0110a) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
