package com.oliverstudio.testusers.di;


import com.oliverstudio.testusers.di.modules.RetrofitModule;
import com.oliverstudio.testusers.domain.users_activity.UsersRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface AppComponent {

    void inject(UsersRepository repository);
}
