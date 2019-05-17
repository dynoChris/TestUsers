package com.oliverstudio.testusers.presentation.users_screen.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
    private AdapterCallback mCallback;

    public UsersRecyclerAdapter(List<User> userList, AdapterCallback callback) {
        mUserList = userList;
        mCallback = callback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mParent;
        private CircleImageView mPhotoCircleImageView;
        private TextView mNameTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            mParent = itemView.findViewById(R.id.item_container);
            mPhotoCircleImageView = itemView.findViewById(R.id.photo_iv);
            mNameTextView = itemView.findViewById(R.id.name_tv);
        }

        public void bind(final User user) {
            Picasso.get()
                    .load(user.getPhotoUrl())
                    .placeholder(R.drawable.photo_placeholder)
                    .into(mPhotoCircleImageView);

            mNameTextView.setText(user.getFirstName());

            mParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.showDetails(user);
                }
            });
        }
    }
}