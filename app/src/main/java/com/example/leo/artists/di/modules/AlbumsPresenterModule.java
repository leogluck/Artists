package com.example.leo.artists.di.modules;

import com.example.leo.artists.presenters.AlbumsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leo on 10.11.2017
 */

@Module
public class AlbumsPresenterModule {

    private AlbumsPresenter.AlbumsView mView;

    public AlbumsPresenterModule(AlbumsPresenter.AlbumsView mView) {
        this.mView = mView;
    }

    @Provides
    public AlbumsPresenter.AlbumsView provideArtistView() {
        return mView;
    }
}
