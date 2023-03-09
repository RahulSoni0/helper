package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zac extends zab {
    private WeakReference<ImageManager.OnImageLoadedListener> zac;

    public zac(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(onImageLoadedListener);
        this.zac = new WeakReference<>(onImageLoadedListener);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zac)) {
            return false;
        }
        zac zac2 = (zac) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zac.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zac2.zac.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.equal(onImageLoadedListener2, onImageLoadedListener) && Objects.equal(zac2.zaa, this.zaa);
    }

    /* access modifiers changed from: protected */
    public final void zaa(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.zac.get()) != null) {
            onImageLoadedListener.onImageLoaded(this.zaa.zaa, drawable, z3);
        }
    }
}
