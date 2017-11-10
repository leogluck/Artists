package com.example.leo.artists.di.components;

import com.example.leo.artists.di.modules.AlbumsPresenterModule;
import com.example.leo.artists.views.AlbumsActivity;

import dagger.Component;

/**
 * Created by Leo on 10.11.2017
 */

@Component(modules = AlbumsPresenterModule.class)
public interface AlbumsComponent {

    void inject(AlbumsActivity activity);
}
