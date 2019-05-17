package com.oliverstudio.testusers.domain.users_activity;

import com.oliverstudio.testusers.data.models.User;

import java.util.List;

public interface BackToPresenter {

    void onSuccess();
    void onFailure();
    void inflateUsers(List<User> users);
}
