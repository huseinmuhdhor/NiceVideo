package com.dev.nicemovie.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.nicemovie.R;
import com.dev.nicemovie.adapter.MainAdapter;
import com.dev.nicemovie.data.model.SearchData;
import com.dev.nicemovie.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View, MainAdapter.OnItemClickedCallback {

    @BindView(R.id.rv_data)
    RecyclerView mRecData;

    private MainPresenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        presenter = new MainPresenter(this);
        presenter.showMovie("");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MainAdapter(this, this);
        mRecData.setLayoutManager(layoutManager);
        mRecData.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void showMovies(List<SearchData> searchData) {
        adapter.clearData();
        adapter.addData(searchData);
    }

    @Override
    public void onItemClicked(SearchData data) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.IMDB_ID, data.getImdbID());
        startActivity(intent);
    }
}