package com.ahmed.testforapp.di.module;


import com.ahmed.testforapp.NavigateActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
    public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract NavigateActivity bindNavigateActivity();

}
