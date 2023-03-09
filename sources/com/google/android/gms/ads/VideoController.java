package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzacj;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzacj zzb;
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zzg(z);
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zzf();
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zze();
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zzl(new zzadx(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj != null) {
                try {
                    zzacj.zzq();
                } catch (RemoteException e) {
                    zzbbk.zzg("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzacj zzacj) {
        synchronized (this.zza) {
            this.zzb = zzacj;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzacj zzb() {
        zzacj zzacj;
        synchronized (this.zza) {
            zzacj = this.zzb;
        }
        return zzacj;
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj == null) {
                return 0;
            }
            try {
                int zzi = zzacj.zzi();
                return zzi;
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj == null) {
                return false;
            }
            try {
                boolean zzp = zzacj.zzp();
                return zzp;
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj == null) {
                return false;
            }
            try {
                boolean zzn = zzacj.zzn();
                return zzn;
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzacj zzacj = this.zzb;
            if (zzacj == null) {
                return true;
            }
            try {
                boolean zzh = zzacj.zzh();
                return zzh;
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }
}
