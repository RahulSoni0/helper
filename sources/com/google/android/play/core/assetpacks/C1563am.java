package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.am */
final class C1563am extends C1557ag<AssetPackStates> {

    /* renamed from: c */
    private final List<String> f473c;

    /* renamed from: d */
    private final C1592bo f474d;

    C1563am(C1564an anVar, C1786i<AssetPackStates> iVar, C1592bo boVar, List<String> list) {
        super(anVar, iVar);
        this.f474d = boVar;
        this.f473c = list;
    }

    /* renamed from: b */
    public final void mo30680b(int i, Bundle bundle) {
        super.mo30680b(i, bundle);
        this.f463a.mo31066e(AssetPackStates.m360c(bundle, this.f474d, this.f473c));
    }
}
