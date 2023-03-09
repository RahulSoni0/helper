package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ak */
final class C1561ak extends C1557ag<Void> {

    /* renamed from: c */
    final int f467c;

    /* renamed from: d */
    final String f468d;

    /* renamed from: e */
    final int f469e;

    /* renamed from: f */
    final /* synthetic */ C1564an f470f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1561ak(C1564an anVar, C1786i<Void> iVar, int i, String str, int i2) {
        super(anVar, iVar);
        this.f470f = anVar;
        this.f467c = i;
        this.f468d = str;
        this.f469e = i2;
    }

    /* renamed from: g */
    public final void mo30685g(Bundle bundle) {
        this.f470f.f479e.mo30894b();
        int i = bundle.getInt("error_code");
        C1564an.f475a.mo17055b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.f469e;
        if (i2 > 0) {
            this.f470f.m411y(this.f467c, this.f468d, i2 - 1);
        }
    }
}
