package com.jph.dagger.sample.di.module;

import com.jph.dagger.sample.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jph on 2016/9/22.
 */
@Module
public class MainModule {
    private MainView mMainView;

    public MainModule(MainView mainView) {
        mMainView = mainView;
    }

    @Provides
    public MainView provideMainView() {
        return mMainView;
    }

}