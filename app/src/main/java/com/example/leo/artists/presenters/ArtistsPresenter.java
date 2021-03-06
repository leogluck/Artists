package com.example.leo.artists.presenters;

import com.example.leo.artists.model.ApiService;
import com.example.leo.artists.model.responses.ArtistResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Leo on 08.11.2017
 */

public class ArtistsPresenter {

    private final static String COUNTRY = "ukraine";
    private ArtistsView mView;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Inject
    public ArtistsPresenter(ArtistsView artistsView) {
        mView = artistsView;
    }

    public void loadArtists() {
        compositeDisposable.add(
                ApiService.getInstance().getArtists(COUNTRY)
                        .subscribeOn(Schedulers.computation())
                        .map(artistResponse -> artistResponse.getTopArtists().getArtist())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(artists -> mView.showArtists(artists),
                                throwable -> mView.showError(throwable)));
    }

    public void onPause() {
        compositeDisposable.dispose();
    }

    public interface ArtistsView {
        void showArtists(List<ArtistResponse.Artist> artists);

        void showError(Throwable throwable);
    }
}
