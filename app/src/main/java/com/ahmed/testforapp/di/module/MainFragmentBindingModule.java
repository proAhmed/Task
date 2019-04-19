package com.ahmed.testforapp.di.module;

import com.ahmed.testforapp.screens.detailScreen.DetailFragment;
import com.ahmed.testforapp.screens.mainScreen.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract MainFragment provideMainFragment();
    @ContributesAndroidInjector
    abstract DetailFragment provideDetailFragment();

}
