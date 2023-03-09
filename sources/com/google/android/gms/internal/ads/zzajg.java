package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajg extends RemoteCreator<zzaht> {
    public zzajg() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzaht) {
            return (zzaht) queryLocalInterface;
        }
        return new zzaht(iBinder);
    }

    public final zzahs zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzahs zzahq;
        try {
            IBinder zze = ((zzaht) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzahs) {
                zzahq = (zzahs) queryLocalInterface;
            } else {
                zzahq = new zzahq(zze);
            }
            return zzahq;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbk.zzj("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }
}
