package com.oliverstudio.testusers.presentation.users_screen.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oliverstudio.testusers.R;
import com.oliverstudio.testusers.data.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    private List<User> mUserList;

    public UsersRecyclerAdapter(List<User> userList) {
        mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Picasso.get()
                .load(mUserList.get(position).getPhotoUrl())
                .placeholder(R.drawable.photo_placeholder)
                .into(holder.mPhotoCircleImageView);

        holder.mNameTextView.setText(mUserList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mPhotoCircleImageView;
        private TextView mNameTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            mPhotoCircleImageView = itemView.findViewById(R.id.photo_iv);
            mNameTextView = itemView.findViewById(R.id.name_tv);
        }
    }
}




