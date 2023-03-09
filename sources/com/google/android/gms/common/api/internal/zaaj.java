package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zaaj extends zaan {
    private final ArrayList<Api.Client> zaa;
    private final /* synthetic */ zaad zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaj(zaad zaad, ArrayList<Api.Client> arrayList) {
        super(zaad, (zaag) null);
        this.zab = zaad;
        this.zaa = arrayList;
    }

    public final void zaa() {
        this.zab.zaa.zad.zac = this.zab.zai();
        ArrayList<Api.Client> arrayList = this.zaa;
        ArrayList arrayList2 = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            client.getRemoteService(this.zab.zao, this.zab.zaa.zad.zac);
        }
    }
}
