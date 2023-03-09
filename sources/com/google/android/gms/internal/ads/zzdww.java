package com.google.android.gms.internal.ads;

import p009io.reactivex.annotations.SchedulerSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzdww {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE(SchedulerSupport.NONE);
    
    private final String zzd;

    private zzdww(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
