package com.oliverstudio.testusers.presentation.users_screen.view;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.oliverstudio.testusers.R;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.presentation.users_screen.presenter.UsersPresenter;
import com.oliverstudio.testusers.utils.androidx_moxy.MvpAppCompatActivity;

import java.util.List;

public class UsersActivity extends MvpAppCompatActivity implements UsersView {

    @InjectPresenter
    UsersPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.fetchRandomUsers();

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void inflateUsers(List<User> users) {

    }
}