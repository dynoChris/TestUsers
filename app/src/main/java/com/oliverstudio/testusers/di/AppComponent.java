package com.oliverstudio.testusers.di;


import com.oliverstudio.testusers.di.modules.RepositoryModule;
import com.oliverstudio.testusers.di.modules.RetrofitModule;
import com.oliverstudio.testusers.domain.users_activity.UsersRepository;
import com.oliverstudio.testusers.presentation.users_screen.presenter.UsersPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(UsersRepository repository);
    void inject(UsersPresenter presenter);
}
