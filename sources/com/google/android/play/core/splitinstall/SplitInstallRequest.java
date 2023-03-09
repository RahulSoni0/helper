package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

    /* renamed from: a */
    private final List<String> f910a;

    /* renamed from: b */
    private final List<Locale> f911b;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<String> f912a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final List<Locale> f913b = new ArrayList();

        private Builder() {
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addLanguage(Locale locale) {
            this.f913b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.f912a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f910a = new ArrayList(builder.f912a);
        this.f911b = new ArrayList(builder.f913b);
    }

    public static Builder newBuilder() {
        return new Builder((byte[]) null);
    }

    public List<Locale> getLanguages() {
        return this.f911b;
    }

    public List<String> getModuleNames() {
        return this.f910a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", new Object[]{this.f910a, this.f911b});
    }
}
