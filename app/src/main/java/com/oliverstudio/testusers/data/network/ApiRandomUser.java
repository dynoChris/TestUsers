package com.oliverstudio.testusers.data.network;

import com.oliverstudio.testusers.data.network.responses.list_users.ListUsersResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRandomUser {

    String BASE_URL = "https://randomuser.me/";
    int USERS_PER_PAGE = 20;

    //https://randomuser.me/api/?results=20
    @GET("api")
    Observable<ListUsersResponse> getRandomUsers(
            @Query("results") int usersPerPage
    );

}