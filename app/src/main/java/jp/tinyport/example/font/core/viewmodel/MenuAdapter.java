package jp.tinyport.example.font.core.viewmodel;

import android.support.v7.widget.RecyclerView;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jp.tinyport.example.font.R;

class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private final List<Pair<String, Scene>> mList;

    MenuAdapter(List<Pair<String, Scene>> list) {
        super();

        mList = list;

        setHasStableIds(true);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_content, parent, false));
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).first);
        holder.itemView.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                TransitionManager.go(mList.get(position).second);
            }
        });
    }

    @Override
    public void onViewRecycled(MenuViewHolder holder) {
        holder.itemView.setOnFocusChangeListener(null);
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

    public Pair<String, Scene> get(int position) {
        return mList.get(position);
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;

        MenuViewHolder(View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}
