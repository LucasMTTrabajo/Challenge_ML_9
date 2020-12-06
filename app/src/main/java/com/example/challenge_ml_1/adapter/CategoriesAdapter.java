package com.example.challenge_ml_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challenge_ml_1.R;
import com.example.challenge_ml_1.model.object.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter  extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private static final String TAG = "CategoriesAdapter";

    private Context context;
    private ArrayList<Categories> categoriesArrayList;

    public CategoriesAdapter ( Context context ,  ArrayList<Categories> aCategoriesList ) {
        try{
            this.context = context ;
            this.categoriesArrayList = aCategoriesList;

        } catch ( Exception e ){
            Log.e(TAG, "CategoriesAdapter: e - ", e);
        }
    }


    @Override
    public int getItemCount() {
        return categoriesArrayList == null ? 0 : categoriesArrayList.size();
    }


    public void setCategoriesArrayList(ArrayList<Categories> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_adapter_item, parent, false);
        return new DataViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        try{
            Categories categories = categoriesArrayList.get(position);

            ((DataViewHolder)holder).textViewTitle . setText( categories.getName() );

        } catch ( Exception e ){
            Log.e(TAG, "onBindViewHolder: e - ",e );
        }
    }

    public class DataViewHolder extends CategoriesViewHolder {
        public DataViewHolder(View itemView) {
            super(itemView);
        }
    }


    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle;

        public CategoriesViewHolder(@NonNull View itemView){
            super(itemView);
            textViewTitle   = itemView.findViewById(R.id.txtV_title_categories_adapter);
        }
    }
}
