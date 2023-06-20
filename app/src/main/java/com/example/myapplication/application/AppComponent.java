package com.example.myapplication.application;

import android.app.Application;

import com.example.myapplication.data.repositories.local.MealRepository;
import com.example.myapplication.data.repositories.local.UserRepository;
import com.example.myapplication.data.repositories.remote.CategoryRepository;
import com.example.myapplication.modules.CategoryModule;
import com.example.myapplication.modules.CoreModule;
import com.example.myapplication.modules.MealModule;
import com.example.myapplication.modules.UserModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {CoreModule.class, UserModule.class, MealModule.class, CategoryModule.class})
public interface AppComponent {
    void inject(MyApplication app);

    UserRepository provideUserRepository();

    MealRepository provideMealRepository();

    CategoryRepository provideCategoryRepository();

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application application);
    }
}

