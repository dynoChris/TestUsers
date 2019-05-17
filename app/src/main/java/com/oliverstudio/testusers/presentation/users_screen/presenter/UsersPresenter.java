package com.oliverstudio.testusers.presentation.users_screen.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.domain.users_activity.BackToPresenter;
import com.oliverstudio.testusers.domain.users_activity.UsersRepository;
import com.oliverstudio.testusers.presentation.users_screen.view.UsersView;

import java.util.List;

@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> implements BackToPresenter {

    private UsersRepository mRepository;

    public UsersPresenter() {
        mRepository = new UsersRepository(this);
    }

    public void fetchRandomUsers() {
        getViewState().showProgressBar();
        mRepository.fetchRandomUsers();
    }

    @Override
    public void inflateUsers(List<User> users) {
        getViewState().hideProgressBar();
        getViewState().inflateUsers(users);
    }
}