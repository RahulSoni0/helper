package com.skydoves.powerspinner;

import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo18301d2 = {"Lcom/skydoves/powerspinner/SpinnerGravity;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "START", "TOP", "END", "BOTTOM", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: SpinnerGravity.kt */
public enum SpinnerGravity {
    START(0),
    TOP(1),
    END(2),
    BOTTOM(3);
    
    private final int value;

    private SpinnerGravity(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
