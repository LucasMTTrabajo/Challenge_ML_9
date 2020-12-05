package com.example.challenge_ml_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.challenge_ml_1.model.viewmodel.ItemsAndSearchViewModel;
import com.example.challenge_ml_1.model.object.Product;
import com.example.challenge_ml_1.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private static final String TAG = "ProductAdapter";

    private ArrayList<Product> productArrayList ;

    private Context context;
    private ItemsAndSearchViewModel itemsAndSearchViewModel;

    public ProductAdapter(Context context , ArrayList<Product> aProductArrayList ) {
        try {
            this.context = context;
            this.productArrayList = aProductArrayList;
            itemsAndSearchViewModel = new ViewModelProvider((FragmentActivity) context).get(ItemsAndSearchViewModel.class);

        } catch ( Exception e ){
            Log.e(TAG, "ProductAdapter: e - ", e);
        }
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
            Product productItem = productArrayList.get(position);

            Log.d(TAG, "onBindViewHolder: productItem: " + productItem );

            ((DataViewHolder)holder).txtVTitle     . setText( productItem.getTitle() );
            ((DataViewHolder)holder).tetTxtVPrice  . setText( "$ " + productItem.getPrice().toString() );
            ((DataViewHolder)holder).txtVExtra     . setText( context.getString(R.string.available_quantity) + productItem.getAvailable_quantity().toString() );

            ((DataViewHolder)holder).rltMain.setOnClickListener(v -> itemsAndSearchViewModel . getLiveDataProductItem() .setValue( productItem ));

            Glide.with(context)
                    .load( productItem.getThumbnail() )
                    .centerCrop()
                    .placeholder(R.drawable.ic_camera_alt_black_48dp)
                    .error(R.drawable.ic_disabled_by_default_black_48dp)
                    .into( ((DataViewHolder)holder).imgMain ) ;



        } catch ( Exception e ){
            Log.e(TAG, "onBindViewHolder: e - ", e);
        }
    }

    public class DataViewHolder extends ProductViewHolder {
        public DataViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setProductArrayList(ArrayList<Product> aProductArrayList) {
        this.productArrayList = aProductArrayList;
        notifyDataSetChanged();
    }

    public void clearProductArrayList () {
        this.productArrayList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productArrayList ==  null ?  0 : productArrayList.size()  ;
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout rltMain;

        public ImageView imgMain;

        public TextView txtVTitle;
        public TextView tetTxtVPrice;
        public TextView txtVExtra;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            rltMain         = itemView.findViewById(R.id. lnr_main_product_adapter);
            imgMain         = itemView.findViewById(R.id. imgV_main_product_adapter);
            txtVTitle       = itemView.findViewById(R.id. txtV_title_product_adapter);
            tetTxtVPrice    = itemView.findViewById(R.id. txtV_price_product_adapter);
            txtVExtra       = itemView.findViewById(R.id. txtV_extra_product_adapter);
        }
    }

}
