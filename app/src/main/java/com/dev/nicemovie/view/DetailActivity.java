package com.dev.nicemovie.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.dev.nicemovie.R;
import com.dev.nicemovie.data.model.Movie;
import com.dev.nicemovie.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements DetailPresenter.View {

    public static final String IMDB_ID = "imdb_id";

    @BindView(R.id.iv_poster)
    ImageView mImagePoster;
    @BindView(R.id.tv_title)
    TextView mTextTitle;
    @BindView(R.id.tv_year)
    TextView mTextYear;
    @BindView(R.id.tv_duration)
    TextView mTextDuration;
    @BindView(R.id.tv_star)
    TextView mTextStar;
    @BindView(R.id.tv_description)
    TextView mTextDescription;
    @BindView(R.id.tv_genre)
    TextView mTextGenre;
    @BindView(R.id.tv_director)
    TextView mTextDirector;
    @BindView(R.id.tv_actors)
    TextView mTextActors;

    private String imdbId;
    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        Intent intent = getIntent();
        imdbId = intent.getStringExtra(IMDB_ID);

        presenter = new DetailPresenter(this);
        presenter.showDetail(imdbId);
    }

    @Override
    public void showDetail(Movie movie) {
        Glide.with(this)
                .load(movie.getPoster())
                .into(mImagePoster);

        mTextTitle.setText(movie.getTitle());
        mTextYear.setText(movie.getYear());
        mTextDuration.setText(movie.getRuntime());
        mTextStar.setText(movie.getImdbRating());
        mTextDescription.setText(movie.getPlot());
        mTextGenre.setText(movie.getGenre());
        mTextActors.setText(movie.getActors());
        mTextDirector.setText(movie.getDirector());
    }

    @OnClick(R.id.iv_back)
    void finishActivity() {
        finish();
    }

    @OnClick(R.id.fab_favorite)
    void addToFavorite() {

    }
}