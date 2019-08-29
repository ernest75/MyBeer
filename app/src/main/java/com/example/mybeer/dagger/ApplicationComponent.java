package com.example.mybeer.dagger;

import com.example.mybeer.screens.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkingModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
