package com.example.leo.artists.di.modules;

import com.example.leo.artists.presenters.ArtistsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leo on 09.11.2017
 */

@Module
public class ArtistPresenterModule {

    private ArtistsPresenter.ArtistsView mView;

    public ArtistPresenterModule(ArtistsPresenter.ArtistsView mView) {
        this.mView = mView;
    }

    @Provides
    public ArtistsPresenter.ArtistsView provideArtistView() {
        return mView;
    }
}
