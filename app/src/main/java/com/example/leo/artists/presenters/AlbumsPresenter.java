package com.example.leo.artists.presenters;

import com.example.leo.artists.model.ApiService;
import com.example.leo.artists.model.responses.AlbumsResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Leo on 09.11.2017
 */

public class AlbumsPresenter {

    private AlbumsPresenter.AlbumsView mView;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AlbumsPresenter(AlbumsView albumsView) {
        this.mView = albumsView;
    }

    public void loadAlbums(String name) {

        compositeDisposable.add(
                ApiService.getInstance().getAlbums(name)
                        .subscribeOn(Schedulers.computation())
                        .map(albumsResponse -> albumsResponse.getTopalbums().getAlbum())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(albums -> mView.showAlbums(albums),
                                throwable -> mView.showError(throwable)));
    }

    public void onPause() {
        compositeDisposable.dispose();
    }

    public interface AlbumsView {
        void showAlbums(List<AlbumsResponse.Album> albums);

        void showError(Throwable throwable);
    }
}
