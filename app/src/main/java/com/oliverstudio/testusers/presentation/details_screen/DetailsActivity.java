package com.oliverstudio.testusers.presentation.details_screen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.oliverstudio.testusers.R;
import com.oliverstudio.testusers.data.models.User;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    //views
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
}
