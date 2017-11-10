package com.example.leo.artists.di.components;

import com.example.leo.artists.di.modules.ArtistPresenterModule;
import com.example.leo.artists.views.ArtistsActivity;

import dagger.Component;

/**
 * Created by Leo on 09.11.2017
 */

@Component(modules = ArtistPresenterModule.class)
public interface ArtistComponent {

    void inject(ArtistsActivity activity);

}
