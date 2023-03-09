package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public class MissingSplitsManagerFactory {

    /* renamed from: a */
    private static final AtomicReference<Boolean> f165a = new AtomicReference<>((Object) null);

    @Deprecated
    public static MissingSplitsManager create(Context context) {
        return new C1721b(context, Runtime.getRuntime(), new C1720a(context, context.getPackageManager()), f165a);
    }
}
