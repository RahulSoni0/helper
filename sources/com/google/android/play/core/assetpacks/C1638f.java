package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.f */
final /* synthetic */ class C1638f implements OnSuccessListener {

    /* renamed from: a */
    private final C1571au f767a;

    private C1638f(C1571au auVar) {
        this.f767a = auVar;
    }

    /* renamed from: a */
    static OnSuccessListener m613a(C1571au auVar) {
        return new C1638f(auVar);
    }

    public final void onSuccess(Object obj) {
        this.f767a.mo30710A((List) obj);
    }
}
