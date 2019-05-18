package com.oliverstudio.testusers.di.modules;

import com.oliverstudio.testusers.domain.users_activity.UsersRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public UsersRepository provideUsersRepository() {
        return new UsersRepository();
    }
}
