package com.oliverstudio.testusers.domain.users_activity;

import android.annotation.SuppressLint;

import com.oliverstudio.testusers.App;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.data.network.ApiRandomUser;
import com.oliverstudio.testusers.data.network.responses.list_users.ListUsersResponse;
import com.oliverstudio.testusers.data.network.responses.list_users.Result;
import com.oliverstudio.testusers.presentation.users_screen.presenter.UsersPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UsersRepository {

    @Inject
    ApiRandomUser mApiRandomUser;
    private BackToPresenter mBackToPresenter;

    public UsersRepository(UsersPresenter presenter) {
        App.getAppComponent().inject(this);
        mBackToPresenter = presenter;
    }

    @SuppressLint("CheckResult")
    public void fetchRandomUsers() {
        mApiRandomUser.getRandomUsers(ApiRandomUser.USERS_PER_PAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListUsersResponse, List<User>>() {
                    @Override
                    public List<User> apply(ListUsersResponse listUsersResponse) throws Exception {
                        return getUsers(listUsersResponse.getResults());
                    }
                })
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        mBackToPresenter.inflateUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

    private List<User> getUsers(List<Result> users) {
        List<User> listUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            String name = users.get(i).getName().getFirst();
            String photoUrl = users.get(i).getPicture().getLarge();
            String email = users.get(i).getEmail();
            int age = users.get(i).getDob().getAge();
            String city = users.get(i).getLocation().getCity();
            User user = new User(name, photoUrl, email, age, city);
            listUsers.add(user);
        }
        return listUsers;
    }
}