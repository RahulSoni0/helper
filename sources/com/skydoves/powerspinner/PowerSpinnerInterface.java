package com.skydoves.powerspinner;

import java.util.List;
import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerInterface;", "T", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "getOnSpinnerItemSelectedListener", "()Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setOnSpinnerItemSelectedListener", "(Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;)V", "spinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "getSpinnerView", "()Lcom/skydoves/powerspinner/PowerSpinnerView;", "getItemCount", "notifyItemSelected", "", "setItems", "itemList", "", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerInterface.kt */
public interface PowerSpinnerInterface<T> {
    int getIndex();

    int getItemCount();

    OnSpinnerItemSelectedListener<T> getOnSpinnerItemSelectedListener();

    PowerSpinnerView getSpinnerView();

    void notifyItemSelected(int i);

    void setIndex(int i);

    void setItems(List<? extends T> list);

    void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<T> onSpinnerItemSelectedListener);
}
