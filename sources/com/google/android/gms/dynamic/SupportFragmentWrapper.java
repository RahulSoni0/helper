package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment zza;

    private SupportFragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    public static SupportFragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new SupportFragmentWrapper(fragment);
        }
        return null;
    }

    public final void zzA(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.unregisterForContextMenu(view);
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    public final Bundle zzc() {
        return this.zza.getArguments();
    }

    public final int zzd() {
        return this.zza.getId();
    }

    public final IFragmentWrapper zze() {
        return wrap(this.zza.getParentFragment());
    }

    public final IObjectWrapper zzf() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    public final boolean zzg() {
        return this.zza.getRetainInstance();
    }

    public final String zzh() {
        return this.zza.getTag();
    }

    public final IFragmentWrapper zzi() {
        return wrap(this.zza.getTargetFragment());
    }

    public final int zzj() {
        return this.zza.getTargetRequestCode();
    }

    public final boolean zzk() {
        return this.zza.getUserVisibleHint();
    }

    public final IObjectWrapper zzl() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzm() {
        return this.zza.isAdded();
    }

    public final boolean zzn() {
        return this.zza.isDetached();
    }

    public final boolean zzo() {
        return this.zza.isHidden();
    }

    public final boolean zzp() {
        return this.zza.isInLayout();
    }

    public final boolean zzq() {
        return this.zza.isRemoving();
    }

    public final boolean zzr() {
        return this.zza.isResumed();
    }

    public final boolean zzs() {
        return this.zza.isVisible();
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull(view);
        fragment.registerForContextMenu(view);
    }

    public final void zzu(boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    public final void zzv(boolean z) {
        this.zza.setMenuVisibility(z);
    }

    public final void zzw(boolean z) {
        this.zza.setRetainInstance(z);
    }

    public final void zzx(boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    public final void zzy(Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zzz(Intent intent, int i) {
        this.zza.startActivityForResult(intent, i);
    }
}
