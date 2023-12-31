package com.example.myapplication.data.repositories.local;

import com.example.myapplication.data.models.entities.UserEntity;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserRepository {

    Single<UserEntity> getUserById(long id);

    Single<UserEntity> getUserByUsernameAndPassword(String username, String password);

    Completable insertUser(UserEntity user);

    Completable updateUser(int idUser,String password);
}

