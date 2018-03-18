package jp.tinyport.example.font.core.adapters;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewBindingAdapter {
    @BindingAdapter("adapter")
    public static <T extends RecyclerView.ViewHolder> void setAdapter(
            RecyclerView v, RecyclerView.Adapter<T> adapter) {
        v.swapAdapter(adapter, true);
    }
}
