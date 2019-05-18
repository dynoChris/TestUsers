package com.oliverstudio.testusers.presentation.users_screen.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.oliverstudio.testusers.App;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.domain.users_activity.UsersRepository;
import com.oliverstudio.testusers.presentation.users_screen.view.UsersView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    @Inject
    UsersRepository mRepository;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public UsersPresenter() {
        App.getAppComponent().inject(this);
    }

    public void fetchRandomUsers() {
        getViewState().showProgressBar();

        Disposable subscribe = mRepository.fetchRandomUsers()
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        getViewState().hideProgressBar();
                        getViewState().inflateUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(subscribe);
    }

    public void dispose() {
        mCompositeDisposable.dispose();
    }

}