package com.kirabium.catfactgenerator;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.kirabium.catfactgenerator.ui.main.ViewModelCatFacts;


public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }


    private ViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ViewModelCatFacts.class)) {
            return (T) new ViewModelCatFacts();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}