package com.jph.testdagger.di.module;

import com.jph.testdagger.Author;
import com.jph.testdagger.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jph on 2016/9/19.
 */
@Module
public class MainModule {

    private final MainView mMainView;

    public MainModule(MainView mainView) {
        mMainView = mainView;
    }


    @Provides
    MainView provideMainView() {
        return mMainView;
    }

    @Provides
    Author provideXXAuthor() {
        return new Author("嘻嘻嘻嘻");
    }
}