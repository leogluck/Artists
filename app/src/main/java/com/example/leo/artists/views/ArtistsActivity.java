package com.example.leo.artists.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leo.artists.R;
import com.example.leo.artists.di.components.DaggerArtistComponent;
import com.example.leo.artists.di.modules.ArtistPresenterModule;
import com.example.leo.artists.model.responses.ArtistResponse;
import com.example.leo.artists.presenters.ArtistsPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ArtistsActivity extends AppCompatActivity implements ArtistsPresenter.ArtistsView {

    @Inject
    ArtistsPresenter mArtistsPresenter;

    private RecyclerView mArtistList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);
        DaggerArtistComponent.builder()
                .artistPresenterModule(new ArtistPresenterModule(this))
                .build()
                .inject(this);

        mArtistsPresenter.loadArtists();

        mArtistList = (RecyclerView) findViewById(R.id.artistList);
        mArtistList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mArtistList.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showArtists(List<ArtistResponse.Artist> artists) {

        mAdapter = new ArtistAdapter(artists);
        mArtistList.setAdapter(mAdapter);
    }


    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mArtistsPresenter.onPause();
    }

    public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
        private List<ArtistResponse.Artist> mArtists;

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView mImage;
            TextView mArtistName;
            TextView mListenerCount;


            public ViewHolder(View view) {
                super(view);
                mImage = view.findViewById(R.id.artistImage);
                mArtistName = view.findViewById(R.id.artistName);
                mListenerCount = view.findViewById(R.id.listenersCount);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int pos = getAdapterPosition();
                        openAlbumsActivity(mArtists.get(pos).getName());
                    }
                });
            }
        }



        public ArtistAdapter(List<ArtistResponse.Artist> artists) {
            mArtists = artists;
        }

        @Override
        public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
            View artistView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.artist_item_layoyt, parent, false);

            ViewHolder artistViewHolder = new ViewHolder(artistView);
            return artistViewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mArtistName.setText(mArtists.get(position).getName());
            holder.mListenerCount.setText(mArtists.get(position).getListeners());
            Picasso.with(ArtistsActivity.this).load(mArtists.get(position)
                    .getImages().get(2).getText()).into(holder.mImage);
        }

        @Override
        public int getItemCount() {
            return mArtists.size();
        }
    }

    private void openAlbumsActivity(String name) {
        Intent intent = new Intent(this, AlbumsActivity.class);
        intent.putExtra(AlbumsActivity.ARTIST_NAME, name);
        startActivity(intent);
    }
}
