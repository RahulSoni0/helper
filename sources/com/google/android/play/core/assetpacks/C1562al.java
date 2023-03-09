package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.al */
final class C1562al extends C1557ag<AssetPackStates> {

    /* renamed from: c */
    private final C1592bo f471c;

    /* renamed from: d */
    private final C1569as f472d;

    C1562al(C1564an anVar, C1786i<AssetPackStates> iVar, C1592bo boVar, C1569as asVar) {
        super(anVar, iVar);
        this.f471c = boVar;
        this.f472d = asVar;
    }

    /* renamed from: f */
    public final void mo30684f(Bundle bundle, Bundle bundle2) {
        super.mo30684f(bundle, bundle2);
        this.f463a.mo31066e(AssetPackStates.m361d(bundle, this.f471c, this.f472d));
    }
}
