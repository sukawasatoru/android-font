package jp.tinyport.example.font.core.viewmodel;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.tinyport.example.font.R;

class SystemFontAdapter extends RecyclerView.Adapter<SystemFontAdapter.FontViewHolder> {
    private final List<Pair<String, Typeface>> mList;

    SystemFontAdapter() {
        super();
        mList = new ArrayList<>();

        setHasStableIds(true);
    }

    @Override
    public FontViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FontViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.system_font_content, parent, false));
    }

    @Override
    public void onBindViewHolder(FontViewHolder holder, int position) {
        final Pair<String, Typeface> data = mList.get(position);
        holder.mLabel.setText(data.first);
        holder.mText.setTypeface(data.second);
    }

    @Override
    public void onViewRecycled(FontViewHolder holder) {
        // does nothing.
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    void add(Pair<String, Typeface> data) {
        mList.add(data);
        notifyItemInserted(mList.size());
    }

    void set(List<Pair<String, Typeface>> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    static class FontViewHolder extends RecyclerView.ViewHolder {
        final TextView mLabel;
        final TextView mText;

        FontViewHolder(View itemView) {
            super(itemView);

            mLabel = itemView.findViewById(android.R.id.text1);
            mText = itemView.findViewById(android.R.id.text2);
        }
    }
}
