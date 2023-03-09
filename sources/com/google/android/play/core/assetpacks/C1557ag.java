package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1713u;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ag */
class C1557ag<T> extends C1713u {

    /* renamed from: a */
    final C1786i<T> f463a;

    /* renamed from: b */
    final /* synthetic */ C1564an f464b;

    C1557ag(C1564an anVar, C1786i<T> iVar) {
        this.f464b = anVar;
        this.f463a = iVar;
    }

    C1557ag(C1564an anVar, C1786i iVar, byte[] bArr) {
        this(anVar, iVar);
    }

    C1557ag(C1564an anVar, C1786i iVar, char[] cArr) {
        this(anVar, iVar);
    }

    C1557ag(C1564an anVar, C1786i iVar, int[] iArr) {
        this(anVar, iVar);
    }

    C1557ag(C1564an anVar, C1786i iVar, short[] sArr) {
        this(anVar, iVar);
    }

    /* renamed from: b */
    public void mo30680b(int i, Bundle bundle) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onStartDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo30681c(List<Bundle> list) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onGetSessionStates", new Object[0]);
    }

    /* renamed from: d */
    public void mo30682d(Bundle bundle, Bundle bundle2) {
        this.f464b.f480f.mo30894b();
        C1564an.f475a.mo17057d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    /* renamed from: e */
    public void mo30683e(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onGetChunkFileDescriptor", new Object[0]);
    }

    /* renamed from: f */
    public void mo30684f(Bundle bundle, Bundle bundle2) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onRequestDownloadInfo()", new Object[0]);
    }

    /* renamed from: g */
    public void mo30685g(Bundle bundle) {
        this.f464b.f479e.mo30894b();
        int i = bundle.getInt("error_code");
        C1564an.f475a.mo17055b("onError(%d)", Integer.valueOf(i));
        this.f463a.mo31065d(new AssetPackException(i));
    }

    /* renamed from: h */
    public final void mo30686h(int i) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: i */
    public void mo30687i() {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onCancelDownloads()", new Object[0]);
    }

    /* renamed from: j */
    public final void mo30688j(int i) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: k */
    public void mo30689k(Bundle bundle) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: l */
    public void mo30690l(Bundle bundle) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: m */
    public void mo30691m(Bundle bundle) {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: n */
    public void mo30692n() {
        this.f464b.f479e.mo30894b();
        C1564an.f475a.mo17057d("onRemoveModule()", new Object[0]);
    }
}
