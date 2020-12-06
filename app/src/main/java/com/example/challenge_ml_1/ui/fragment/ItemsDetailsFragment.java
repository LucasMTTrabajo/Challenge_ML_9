package com.example.challenge_ml_1.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.challenge_ml_1.R;
import com.example.challenge_ml_1.adapter.AttributesAdapter;
import com.example.challenge_ml_1.model.object.Attributes;
import com.example.challenge_ml_1.model.object.Product;

import java.util.ArrayList;

public class ItemsDetailsFragment extends Fragment {
    private static final String TAG = "ItemsDetailsFragment";

    private TextView txtVTitle;
    private TextView txtVPrice;
    private TextView txtVQuantity;
    private TextView txtVExtraInfo;

    private ImageView imageViewMain;

    private RecyclerView recyclerView;
    private AttributesAdapter attributesAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Boolean isExtraInfoShowing = false;

    private ArrayList<Attributes> attributesArrayList;

    private Boolean isImageFitToScreen;
    private RelativeLayout.LayoutParams layoutParamsDefaultImgMain;

    private NavController navController;

    private Product selectedProductItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_items_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try{
            navController = Navigation.findNavController(view);


            loadViews(view);

            if ( getArguments() != null ) {
                selectedProductItem = (Product) getArguments().getSerializable("product_item");
                loadDataToViews(selectedProductItem);
            }


        } catch ( Exception e ){
            Log.e(TAG, "onViewCreated: e - ", e);
        }
    }

    private void loadViews (View view ) {
        try{
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            txtVTitle       = view . findViewById(R.id. txtV_title_fragemt_item_detail);
            txtVPrice       = view . findViewById(R.id. txtV_price_fragemt_item_detail);
            txtVQuantity    = view . findViewById(R.id. txtV_quantity_fragemt_item_detail);
            txtVExtraInfo   = view . findViewById(R.id. txtV_extra_info_fragemt_item_detail);
            imageViewMain   = view.findViewById(R.id.imgV_fragment_items_detail_main);

            recyclerView = view.findViewById(R.id.recyclerView_attributes_fragment_items_details);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);

            attributesAdapter = new AttributesAdapter(getContext() , attributesArrayList);
            recyclerView.setAdapter(attributesAdapter);

            isImageFitToScreen = false;
            layoutParamsDefaultImgMain = (RelativeLayout.LayoutParams) imageViewMain.getLayoutParams();

            imageViewMain . setOnClickListener(v -> {
//                    if(isImageFitToScreen) {
//                        isImageFitToScreen=false;
//                        imageViewMain . setLayoutParams( Utilities.getRelativeLayuotParamsFullScreenON());
//                        imageViewMain.setAdjustViewBounds(true);
//                    }else{
//                        isImageFitToScreen=true;
//                        imageViewMain . setLayoutParams( layoutParamsDefaultImgMain );
//                    }
            });

            txtVExtraInfo . setOnClickListener(v -> {
                if ( isExtraInfoShowing ) {
                    isExtraInfoShowing = false;
                    txtVExtraInfo . setText( getResources().getString(R.string.more_info));
                    recyclerView.setVisibility( View.GONE );
                } else {
                    isExtraInfoShowing = true;
                    txtVExtraInfo . setText( getResources().getString(R.string.less_info));
                    recyclerView.setVisibility( View.VISIBLE );
                }
            });

        } catch ( Exception e ){
            Log.e(TAG, "loadViews: e - ", e);
        }
    }

    private void loadDataToViews ( Product product ){
        try{
            txtVTitle             . setText( product . getTitle() );
            txtVPrice             . setText( getResources().getString(R.string.price) + product . getPrice().toString() );
            txtVQuantity          . setText( getResources().getString(R.string.available_quantity) + product . getAvailable_quantity().toString() );
            txtVExtraInfo         . setText( getResources().getString(R.string.more_info) );

            if ( product.getAttributes() != null ) {
                txtVExtraInfo . setVisibility( View.VISIBLE );
                attributesAdapter.setAttributesArrayList((ArrayList<Attributes>) product.getAttributes());
            } else {
                txtVExtraInfo . setVisibility(View.GONE);
            }

            String newURL = product.getThumbnail().replace('I' , 'L') ;
            Glide.with(this)
                    .load( newURL )
                    .centerCrop()
                    .placeholder(R.drawable.ic_placeholder_item_foreground)
                    .error(R.drawable.ic_placeholder_item_foreground)
                    .into( imageViewMain ) ;

        } catch ( Exception e ){
            Log.e(TAG, "loadDataToViews: e - ", e);
        }
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
