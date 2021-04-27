package com.dev.nicemovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.nicemovie.R;
import com.dev.nicemovie.adapter.viewholder.MainViewHolder;
import com.dev.nicemovie.data.model.SearchData;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context context;
    private List<SearchData> searchDataList;
    private OnItemClickedCallback onItemClickedCallback;

    public MainAdapter(Context context, OnItemClickedCallback onItemClickedCallback) {
        this.context = context;
        this.onItemClickedCallback = onItemClickedCallback;
        if (searchDataList == null) {
            searchDataList = new ArrayList<>();
        }
    }

    public void addData(List<SearchData> searchDataList) {
        this.searchDataList.addAll(searchDataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.searchDataList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        SearchData data = searchDataList.get(position);
        holder.bind(data, onItemClickedCallback);
    }

    @Override
    public int getItemCount() {
        return searchDataList.size();
    }

    public interface OnItemClickedCallback {
        void onItemClicked(SearchData data);
    }
}
