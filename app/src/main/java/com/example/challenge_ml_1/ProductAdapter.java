package com.example.challenge_ml_1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private static final String TAG = "ProductAdapter";

    private Context mContext;

    public ProductAdapter(Context context ) {
        mContext = context;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_adapter_item, parent, false);
        return new DataViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        try{

        } catch ( Exception e ){
            Log.e(TAG, "onBindViewHolder: e - ", e);
        }
    }

    public class DataViewHolder extends ProductViewHolder {
        public DataViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout lnrMain;

        public ImageView imgMain;

        public TextView txtVTitle;
        public TextView tetTxtVPrice;
        public TextView txtVExtra;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            lnrMain         = itemView.findViewById(R.id. lnr_main_product_adapter);
            imgMain         = itemView.findViewById(R.id. imgV_main_product_adapter);
            txtVTitle       = itemView.findViewById(R.id. txtV_title_product_adapter);
            tetTxtVPrice    = itemView.findViewById(R.id. txtV_price_product_adapter);
            txtVExtra       = itemView.findViewById(R.id. ttV_extra_product_adapter);
        }
    }

}
