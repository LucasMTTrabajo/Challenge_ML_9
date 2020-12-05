package com.example.challenge_ml_1.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challenge_ml_1.R;
import com.example.challenge_ml_1.adapter.ProductAdapter;
import com.example.challenge_ml_1.model.object.Product;

import java.util.ArrayList;

public class ItemsFragment extends Fragment {
    private static final String TAG = "ItemsFragment";

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private NavController navController;

    private ArrayList<Product> productArrayList ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            navController = Navigation.findNavController(view);

            loadViews(view);


        } catch ( Exception e ){
            Log.e(TAG, "onViewCreated: e - ", e);
        }
    }

    private void loadViews ( View view ){
        try{

            recyclerView = view.findViewById(R.id.recyclerView_product_fragment_items);
            recyclerView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);

            productAdapter = new ProductAdapter(getContext() , productArrayList);
            recyclerView.setAdapter(productAdapter);


        } catch ( Exception  e ){
            Log.e(TAG, "loadViews: e - ", e);
        }
    }

    public void setProductAdapter(ArrayList<Product> aProductsList ) {
        productArrayList= aProductsList;
        productAdapter.setProductArrayList((ArrayList<Product>) aProductsList);
    }

    public void nextViewFragment ( Product aSelectedProductItem ) {
        Bundle bundle = new Bundle();
        bundle . putSerializable( "product_item" , aSelectedProductItem );
        navController.navigate(R.id.action_itemsFragment_to_itemsDetailFragment , bundle );
    }
}
