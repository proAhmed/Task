package com.ahmed.testforapp.di.module;


import com.ahmed.testforapp.di.helper.ViewModelFactory;
import com.ahmed.testforapp.di.helper.ViewModelKey;
import com.ahmed.testforapp.screens.detailScreen.DetailViewModel;
import com.ahmed.testforapp.screens.mainScreen.MainViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindDetailViewModel(DetailViewModel detailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
