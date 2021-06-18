package com.gulf.arabchat0.adapters.others;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.SkuDetails;
import com.gulf.arabchat0.R;
import com.gulf.arabchat0.app.Application;
import com.gulf.arabchat0.app.Config;
import com.gulf.arabchat0.helpers.QuickHelp;
import com.gulf.arabchat0.home.settings.WebUrlsActivity;

import java.util.List;


public class PaymentProductListSkuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mActivity;
    private ItemViewHolder.OnItemSelectedListener itemSelectedListener;

    private List<SkuDetails> mPaymentProductModels;

    private static int lastSelectedPosition = 0;

    private static final int NORMAL_ITEM = 0;
    private static final int FOOTER_VIEW = 1;

    public PaymentProductListSkuAdapter(Activity activity, ItemViewHolder.OnItemSelectedListener itemSelectedListener, List<SkuDetails> paymentProductModelList) {
        this.mActivity = activity;
        this.itemSelectedListener = itemSelectedListener;
        this.mPaymentProductModels = paymentProductModelList;
    }

    private boolean isHeader(int position) {
        return position == mPaymentProductModels.size() - 1;
    }

    @Override
    public int getItemViewType(int position) {

        return isHeader(position) ? FOOTER_VIEW : NORMAL_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;

        if (viewType == FOOTER_VIEW) {
            view = inflater.inflate(R.layout.payment_terms_item, parent, false);
            return new HeaderViewHolder(view);

        } else {

            view = inflater.inflate(R.layout.payment_product_package_list_item, parent, false);
            return new ItemViewHolder(view, itemSelectedListener);

        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SkuDetails productModel = mPaymentProductModels.get(viewHolder.getAdapterPosition());

        if (viewHolder.getItemViewType() == FOOTER_VIEW) {

            HeaderViewHolder headerViewHolder = ((HeaderViewHolder) viewHolder);

            SpannableString termsText = new SpannableString(mActivity.getString(R.string.terms_and_conditions));
            termsText.setSpan(new UnderlineSpan(), 0, termsText.length(), 0);
            headerViewHolder.mTermsnAndConditions.setText(termsText);

            headerViewHolder.mTermsnAndConditions.setOnClickListener(v -> QuickHelp.goToActivityWithNoClean(mActivity, WebUrlsActivity.class, WebUrlsActivity.WEB_URL_TYPE, Config.TERMS_OF_USE_IN_APP));

        } else if (viewHolder.getItemViewType() == NORMAL_ITEM) {

            ItemViewHolder holder = ((ItemViewHolder) viewHolder);

            holder.selectedProduct.setChecked(lastSelectedPosition == position);

            if (productModel.getType().equals(BillingClient.SkuType.INAPP)) {

                switch (productModel.getSku()) {

                    case Config.CREDIT_500:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_500));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.full_price));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;


                    case Config.CREDIT_2000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_2000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.full_price));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;



                    case Config.CREDIT_10000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_10000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 5, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;




                    case Config.CREDIT_20000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_20000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 15, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.VISIBLE);
                        holder.mostPopularText.setVisibility(View.VISIBLE);
                        holder.mItemLayout.setBackgroundColor(Application.getInstance().getResources().getColor(R.color.yellow_50));

                        break;


                    case Config.CREDIT_40000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_40000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 10, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;

                    case Config.CREDIT_80000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_80000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 15, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;


                    case Config.CREDIT_100000:

                        holder.ItemName.setText(mActivity.getString(R.string.credits_100000));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 20, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;

                }

            } else if (productModel.getType().equals(BillingClient.SkuType.SUBS)) {

                switch (productModel.getSku()) {
                    case Config.SUBS_3_MONTHS:

                        holder.ItemName.setText(mActivity.getString(R.string.subs_3_months));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 61, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.VISIBLE);
                        holder.mostPopularText.setVisibility(View.VISIBLE);
                        holder.mItemLayout.setBackgroundColor(Application.getInstance().getResources().getColor(R.color.yellow_50));

                        break;
                    case Config.SUBS_1_WEEK:

                        holder.ItemName.setText(mActivity.getString(R.string.subs_1_week));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.full_price));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;
                    case Config.SUBS_1_MONTH:

                        holder.ItemName.setText(mActivity.getString(R.string.subs_1_month));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 50, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;
                    case Config.SUBS_6_MONTHS:

                        holder.ItemName.setText(mActivity.getString(R.string.subs_6_months));

                        holder.ItemPrice.setText(String.format("%s %s", Application.getInstance().getText(R.string.payment_of), productModel.getPrice()));
                        holder.savePercent.setText(String.format(" -%s%s", 70, "%"));
                        holder.itemSave.setText(Application.getInstance().getText(R.string.save));

                        holder.mostPopularIcon.setVisibility(View.GONE);
                        holder.mostPopularText.setVisibility(View.GONE);
                        holder.mItemLayout.setBackgroundColor(Color.TRANSPARENT);

                        break;
                }
            }

            holder.mItem = productModel;
        }

    }

    @Override
    public int getItemCount() {
        return mPaymentProductModels.size();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView mTermsnAndConditions;

        HeaderViewHolder(@NonNull View v) {
            super(v);

            mTermsnAndConditions = v.findViewById(R.id.terms);
        }
    }

    public void setSelected(SkuDetails paymentProductModel) {

        itemSelectedListener.onItemSelected(paymentProductModel);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        SkuDetails mItem;
        OnItemSelectedListener itemSelectedListener;

        RelativeLayout mItemLayout;
        RadioButton selectedProduct;

        TextView ItemName;
        TextView ItemPrice;

        TextView mostPopularText;
        ImageView mostPopularIcon;

        TextView itemSave;
        TextView savePercent;

        ItemViewHolder(View v, OnItemSelectedListener itemSelected) {
            super(v);

            itemSelectedListener = itemSelected;

            mItemLayout = v.findViewById(R.id.productListItem_paymentBox);

            selectedProduct = v.findViewById(R.id.productListItem_radio);
            ItemName = v.findViewById(R.id.productListItem_name);
            mostPopularIcon = v.findViewById(R.id.productListItem_mostPopularPanel);
            ItemPrice = v.findViewById(R.id.productListItem_totalCost);
            mostPopularText = v.findViewById(R.id.productListItem_mostPopularPreselectedText);
            itemSave = v.findViewById(R.id.productListItem_details1);
            savePercent = v.findViewById(R.id.productListItem_details2);

            selectedProduct.setOnClickListener(view -> {

                lastSelectedPosition = getAdapterPosition();
                itemSelectedListener.onItemSelected(mItem);
            });

            mItemLayout.setOnClickListener(view -> {

                lastSelectedPosition = getAdapterPosition();
                itemSelectedListener.onItemSelected(mItem);
            });
        }

        public interface OnItemSelectedListener {

            void onItemSelected(SkuDetails item);
        }
    }

}