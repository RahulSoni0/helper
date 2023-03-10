package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zaj;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zaai extends zaan {
    final /* synthetic */ zaad zaa;
    private final Map<Api.Client, zaaf> zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaai(zaad zaad, Map<Api.Client, zaaf> map) {
        super(zaad, (zaag) null);
        this.zaa = zaad;
        this.zab = map;
    }

    public final void zaa() {
        zaj zaj = new zaj(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.zab.keySet()) {
            if (!next.requiresGooglePlayServices() || this.zab.get(next).zac) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList;
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                i = zaj.zaa(this.zaa.zac, (Api.Client) obj);
                if (i != 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList2;
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                i = zaj.zaa(this.zaa.zac, (Api.Client) obj2);
                if (i == 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            this.zaa.zaa.zaa((zaba) new zaah(this, this.zaa, new ConnectionResult(i, (PendingIntent) null)));
            return;
        }
        if (this.zaa.zam && this.zaa.zak != null) {
            this.zaa.zak.zab();
        }
        for (Api.Client next2 : this.zab.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zab.get(next2);
            if (!next2.requiresGooglePlayServices() || zaj.zaa(this.zaa.zac, next2) == 0) {
                next2.connect(connectionProgressReportCallbacks);
            } else {
                this.zaa.zaa.zaa((zaba) new zaak(this, this.zaa, connectionProgressReportCallbacks));
            }
        }
    }
}
