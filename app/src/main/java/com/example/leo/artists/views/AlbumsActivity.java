package com.example.leo.artists.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leo.artists.R;
import com.example.leo.artists.di.components.DaggerAlbumsComponent;
import com.example.leo.artists.di.modules.AlbumsPresenterModule;
import com.example.leo.artists.model.responses.AlbumsResponse;
import com.example.leo.artists.presenters.AlbumsPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class AlbumsActivity extends AppCompatActivity implements AlbumsPresenter.AlbumsView {

    @Inject
    AlbumsPresenter mAlbumsPresenter;

    public static final String ARTIST_NAME = "ARTIST_NAME";
//    private AlbumsPresenter mAlbumsPresenter;
    private RecyclerView mAlbumsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        String artistName = getIntent().getStringExtra(ARTIST_NAME);

        DaggerAlbumsComponent.builder()
                .albumsPresenterModule(new AlbumsPresenterModule(this))
                .build()
                .inject(this);
//        mAlbumsPresenter = new AlbumsPresenter(this);
        mAlbumsPresenter.loadAlbums(artistName);

        mAlbumsList = (RecyclerView) findViewById(R.id.albumsList);
        mAlbumsList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mAlbumsList.setLayoutManager(layoutManager);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAlbumsPresenter.onPause();
    }

    @Override
    public void showAlbums(List<AlbumsResponse.Album> albums) {
        RecyclerView.Adapter adapter = new AlbumsAdapter(albums);
        mAlbumsList.setAdapter(adapter);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    class AlbumsAdapter extends RecyclerView.Adapter<AlbumsActivity.AlbumsAdapter.ViewHolder> {
        private List<AlbumsResponse.Album> mAlbums;

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView mImage;
            TextView mAlbumName;
            TextView mListenerCount;


            ViewHolder(View view) {
                super(view);
                mImage = view.findViewById(R.id.albumImage);
                mAlbumName = view.findViewById(R.id.albumName);
                mListenerCount = view.findViewById(R.id.albumListenersCount);

            }
        }

        AlbumsAdapter(List<AlbumsResponse.Album> albums) {
            mAlbums = albums;
        }

        @Override
        public AlbumsActivity.AlbumsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {
            View albumsView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.albums_item_layoyt, parent, false);

            return new ViewHolder(albumsView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mAlbumName.setText(mAlbums.get(position).getName());
            holder.mListenerCount.setText(String.valueOf(mAlbums.get(position).getPlaycount()));
            String imagePath = mAlbums.get(position).getImages().get(2).getText();
            if (!TextUtils.isEmpty(imagePath)) {
                Picasso.with(AlbumsActivity.this)
                        .load(imagePath)
                        .into(holder.mImage);
            }
        }

        @Override
        public int getItemCount() {
            return mAlbums.size();
        }
    }
}
