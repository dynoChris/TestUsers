package com.oliverstudio.testusers.presentation.details_screen;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.oliverstudio.testusers.R;
import com.oliverstudio.testusers.data.models.User;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    //views
    private Toolbar mToolbar;
    private ImageView mPhotoImageView;
    private TextView mFirstNameTextView;
    private TextView mLastNameTextView;
    private TextView mAgeTextView;
    private TextView mCityTextView;
    private TextView mEmailTextView;

    //general vars
    private User mUserDetails;

    //vars

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();

        mUserDetails = getIntent().getExtras().getParcelable("user");

        inflateUserDetails();
    }

    private void inflateUserDetails() {
        Picasso.get()
                .load(mUserDetails.getPhotoUrl())
                .placeholder(R.drawable.photo_placeholder)
                .into(mPhotoImageView);

        mFirstNameTextView.setText(mUserDetails.getFirstName());
        mLastNameTextView.setText(mUserDetails.getLastName());
        mAgeTextView.setText("" + mUserDetails.getAge() + " years");
        mCityTextView.setText("City: " + mUserDetails.getCity());
        mEmailTextView.setText(mUserDetails.getEmail());
    }

    private void initViews() {
        mPhotoImageView = findViewById(R.id.photo_iv);
        mFirstNameTextView = findViewById(R.id.first_name_tv);
        mLastNameTextView = findViewById(R.id.last_name_tv);
        mAgeTextView = findViewById(R.id.age_tv);
        mCityTextView = findViewById(R.id.city_tv);
        mEmailTextView = findViewById(R.id.email_tv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
