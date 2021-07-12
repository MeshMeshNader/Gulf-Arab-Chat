package com.gulf.arabchat0.adapters.arabchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gulf.arabchat0.R;
import com.gulf.arabchat0.app.Application;
import com.gulf.arabchat0.helpers.QuickHelp;
import com.gulf.arabchat0.home.encounters.EncountersFragment;
import com.gulf.arabchat0.models.arabchat.User;

import java.util.List;

public class EncountersAdapter extends RecyclerView.Adapter<EncountersAdapter.ViewHolder> {
    private List<User> mUsers;
    private EncountersFragment mEncountersFragment;

    public EncountersAdapter(List<User> likedYouModels, EncountersFragment encountersFragment) {
        mUsers = likedYouModels;
        mEncountersFragment = encountersFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;

        view = inflater.inflate(R.layout.item_encounters, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        User user = mUsers.get(position);

        QuickHelp.getEncountersAvatars(user, viewHolder.userPhoto);

        if (user.getBirthDate() != null) {
            viewHolder.nameAndAge.setText(String.format("%s, %s", user.getColFullName(), QuickHelp.getAgeFromDate(user.getBirthDate())));
        } else {
            viewHolder.nameAndAge.setText(user.getColFullName());
        }


        viewHolder.userCity.setText(QuickHelp.getOnlyCityFromLocation(user));
        String userCoins = String.valueOf(user.getCredits()) + " " + Application.getInstance().getApplicationContext().getResources().getString(R.string.credits);
        viewHolder.userCoins.setText(userCoins);

        viewHolder.userPhoto.setOnClickListener(v1 -> {

            if (user.getProfilePhotos().size() > 0) {

                QuickHelp.goToActivityPhotoViewer(mEncountersFragment.getActivity(), user, user.getAvatarPhotoPosition());
            }

        });


        viewHolder.likeBtn.setOnClickListener(v -> mEncountersFragment.likeUser());
        viewHolder.crush.setOnClickListener(v -> mEncountersFragment.crushUser(user));
        viewHolder.dislikeBtn.setOnClickListener(v -> mEncountersFragment.skipUser());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userPhoto;
        TextView nameAndAge;
        TextView userCity;
        TextView userCoins;

        ImageView dislikeBtn;
        ImageView crush;
        ImageView likeBtn;

        ViewHolder(View v) {
            super(v);

            userPhoto = v.findViewById(R.id.profilePhoto);
            nameAndAge = v.findViewById(R.id.nameAndAge);
            userCity = v.findViewById(R.id.location);
            userCoins = v.findViewById(R.id.card_view_coins);
            dislikeBtn = v.findViewById(R.id.dislikeBtn);
            crush = v.findViewById(R.id.crushBtn);
            likeBtn = v.findViewById(R.id.likeBtn);

        }
    }

}