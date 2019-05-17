package com.oliverstudio.testusers.presentation.users_screen.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.oliverstudio.testusers.R;
import com.oliverstudio.testusers.data.models.User;
import com.oliverstudio.testusers.presentation.details_screen.DetailsActivity;
import com.oliverstudio.testusers.presentation.users_screen.presenter.UsersPresenter;
import com.oliverstudio.testusers.presentation.users_screen.view.adapters.AdapterCallback;
import com.oliverstudio.testusers.presentation.users_screen.view.adapters.UsersRecyclerAdapter;
import com.oliverstudio.testusers.utils.androidx_moxy.MvpAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends MvpAppCompatActivity implements UsersView, AdapterCallback {

    //views
    private ProgressBar mProgressBar;
    private RecyclerView mUsersRecyclerView;

    //general vars
    @InjectPresenter
    UsersPresenter mPresenter;
    private List<User> mUserList = new ArrayList<>();
    private UsersRecyclerAdapter mUsersRecyclerAdapter;

    //vars

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initRecycler();

        mPresenter.fetchRandomUsers();

    }

    private void initRecycler() {
        mUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUsersRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mUsersRecyclerAdapter = new UsersRecyclerAdapter(mUserList, this);
        mUsersRecyclerView.setAdapter(mUsersRecyclerAdapter);
        mUsersRecyclerAdapter.notifyDataSetChanged();
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.progress_bar);
        mUsersRecyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mUsersRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
        mUsersRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void inflateUsers(List<User> users) {
        mUserList.clear();
        mUserList.addAll(users);
        mUsersRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDetails(User user) {
        Intent intent = new Intent(UsersActivity.this, DetailsActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}