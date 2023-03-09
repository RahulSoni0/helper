package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.C1646a;
import com.google.android.play.core.tasks.C1787j;

public class AssetPackException extends C1787j {

    /* renamed from: a */
    private final int f429a;

    AssetPackException(int i) {
        super(String.format("Asset Pack Download Error(%d): %s", new Object[]{Integer.valueOf(i), C1646a.m627a(i)}));
        if (i != 0) {
            this.f429a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f429a;
    }
}
