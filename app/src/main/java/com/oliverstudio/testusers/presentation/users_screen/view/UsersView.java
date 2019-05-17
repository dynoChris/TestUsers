package com.oliverstudio.testusers.presentation.users_screen.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.oliverstudio.testusers.data.models.User;

import java.util.List;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface UsersView extends MvpView {
    void showProgressBar();
    void hideProgressBar();
    void inflateUsers(List<User> users);
}