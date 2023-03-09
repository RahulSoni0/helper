package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C0960bh;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;

/* renamed from: com.google.android.play.core.assetpacks.n */
public final class C1647n implements C1696ce<AssetPackManager> {

    /* renamed from: a */
    private final C1696ce f799a;

    /* renamed from: b */
    private final C1696ce f800b;

    /* renamed from: c */
    private final /* synthetic */ int f801c = 0;

    public C1647n(C1696ce<C1641i> ceVar, C1696ce<Context> ceVar2) {
        this.f799a = ceVar;
        this.f800b = ceVar2;
    }

    public C1647n(C1696ce<Context> ceVar, C1696ce<C1571au> ceVar2, byte[] bArr) {
        this.f800b = ceVar;
        this.f799a = ceVar2;
    }

    public C1647n(C1696ce<Context> ceVar, C1696ce<C1592bo> ceVar2, char[] cArr) {
        this.f799a = ceVar;
        this.f800b = ceVar2;
    }

    public C1647n(C1696ce<C1571au> ceVar, C1696ce<C1653t> ceVar2, int[] iArr) {
        this.f800b = ceVar;
        this.f799a = ceVar2;
    }

    public C1647n(C1696ce<Context> ceVar, C1696ce<C1626cv> ceVar2, short[] sArr) {
        this.f799a = ceVar;
        this.f800b = ceVar2;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        int i = this.f801c;
        if (i == 0) {
            Object a = this.f799a.mo30603a();
            Context b = ((C1649p) this.f800b).mo30603a();
            C1641i iVar = (C1641i) a;
            C0960bh.m104h(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
            C0960bh.m104h(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService"), 4);
            PlayCoreDialogWrapperActivity.m655a(b);
            C0960bh.m107k(iVar);
            return iVar;
        } else if (i == 1) {
            return new C1577b(((C1649p) this.f800b).mo30603a(), (C1571au) this.f799a.mo30603a());
        } else {
            if (i == 2) {
                return new C1564an(((C1649p) this.f799a).mo30603a(), (C1592bo) this.f800b.mo30603a());
            }
            if (i == 3) {
                return new C1571au(((C1649p) this.f799a).mo30603a(), (C1626cv) this.f800b.mo30603a());
            }
            return new C1628cx((C1571au) this.f800b.mo30603a(), C1694cc.m743c(this.f799a));
        }
    }
}
