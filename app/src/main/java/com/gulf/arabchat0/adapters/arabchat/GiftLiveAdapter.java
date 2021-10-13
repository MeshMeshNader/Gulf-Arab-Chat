package com.gulf.arabchat0.adapters.arabchat;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.gulf.arabchat0.R;
import com.gulf.arabchat0.home.connections.ChatActivity;
import com.gulf.arabchat0.home.live.LiveStreamingActivity;
import com.gulf.arabchat0.models.arabchat.GiftModel;

import java.util.List;

public class GiftLiveAdapter extends RecyclerView.Adapter<GiftLiveAdapter.ViewHolder> {
    private List<GiftModel> mGifts;
    private Activity mActivity;
    private boolean isChat;

    public GiftLiveAdapter(Activity activity, List<GiftModel> giftModelList, boolean isChat) {
        mGifts = giftModelList;
        mActivity = activity;
        this.isChat = isChat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;

        view = inflater.inflate(R.layout.item_live_gift_large, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        GiftModel gift = mGifts.get(position);
        Log.e("GiftAdapter", "onBindViewHolder: "  + gift.getGiftFile().getName());

        viewHolder.mGiftImage.setAnimationFromUrl(gift.getGiftFile().getUrl());
        viewHolder.mGiftImage.setSpeed(0.8f);

        viewHolder.mGiftCredits.setText(String.valueOf(gift.getCredits()));

        if (isChat)
            viewHolder.mLayout.setOnClickListener(v -> ((ChatActivity) mActivity).sendLiveGift(gift));
        else
            viewHolder.mLayout.setOnClickListener(v -> ((LiveStreamingActivity) mActivity).sendLiveGift(gift));
    }

    @Override
    public int getItemCount() {
        return mGifts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout mLayout;
        LottieAnimationView mGiftImage;
        TextView mGiftCredits;

        ViewHolder(View v) {
            super(v);

            mLayout = v.findViewById(R.id.root_view);
            mGiftImage = v.findViewById(R.id.itemLiveGift_iconImage);
            mGiftCredits = v.findViewById(R.id.itemLiveGift_priceText);
        }
    }

}