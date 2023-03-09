package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1668ac;
import com.google.android.play.core.internal.C1681aq;
import com.google.android.play.core.internal.C1690bp;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.review.i */
public final class C1730i {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C0944ag f903b = new C0944ag("ReviewService");

    /* renamed from: a */
    C1681aq<C1668ac> f904a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f905c;

    public C1730i(Context context) {
        this.f905c = context.getPackageName();
        if (C1690bp.m735a(context)) {
            Context context2 = context;
            this.f904a = new C1681aq(context2, f903b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C1725d.f897a);
        }
    }

    /* renamed from: a */
    public final Task<ReviewInfo> mo30982a() {
        C0944ag agVar = f903b;
        agVar.mo17057d("requestInAppReview (%s)", this.f905c);
        if (this.f904a == null) {
            agVar.mo17055b("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.m943b(new C1726e());
        }
        C1786i iVar = new C1786i();
        this.f904a.mo30893a(new C1727f(this, iVar, iVar));
        return iVar.mo31064c();
    }
}
