package com.dev.nicemovie.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dev.nicemovie.R;
import com.dev.nicemovie.adapter.MainAdapter;
import com.dev.nicemovie.data.model.SearchData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_poster)
    ImageView mImagePoster;
    @BindView(R.id.tv_title)
    TextView mTextTitle;
    @BindView(R.id.tv_year)
    TextView mTextYear;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(SearchData data, MainAdapter.OnItemClickedCallback onItemClickedCallback) {
        Glide.with(itemView.getContext())
                .load(data.getPoster())
                .into(mImagePoster);

        mTextTitle.setText(data.getTitle());
        mTextYear.setText(data.getYear());

        itemView.setOnClickListener(v -> onItemClickedCallback.onItemClicked(data));
    }
}
