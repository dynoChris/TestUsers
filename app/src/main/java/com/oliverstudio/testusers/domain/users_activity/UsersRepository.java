package com.oliverstudio.testusers.domain.users_activity;

import com.oliverstudio.testusers.App;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.data.network.ApiRandomUser;
import com.oliverstudio.testusers.data.network.responses.list_users.ListUsersResponse;
import com.oliverstudio.testusers.data.network.responses.list_users.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UsersRepository {

    @Inject
    ApiRandomUser mApiRandomUser;

    public UsersRepository() {
        App.getAppComponent().inject(this);
    }

    public Observable<List<User>> fetchRandomUsers() {
        return mApiRandomUser.getRandomUsers(ApiRandomUser.USERS_PER_PAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ListUsersResponse, List<User>>() {
                    @Override
                    public List<User> apply(ListUsersResponse listUsersResponse) throws Exception {
                        return getUsers(listUsersResponse.getResults());
                    }
                });
    }

    private List<User> getUsers(List<Result> users) {
        List<User> listUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            String firstName = users.get(i).getName().getFirst();
            String lastName = users.get(i).getName().getLast();
            String photoUrl = users.get(i).getPicture().getLarge();
            String email = users.get(i).getEmail();
            int age = users.get(i).getDob().getAge();
            String city = users.get(i).getLocation().getCity();
            User user = new User(photoUrl, firstName, lastName, age, city, email);
            listUsers.add(user);
        }
        return listUsers;
    }
}