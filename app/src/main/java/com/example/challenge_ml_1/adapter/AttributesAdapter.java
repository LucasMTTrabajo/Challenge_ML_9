package com.example.challenge_ml_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challenge_ml_1.model.object.Attributes;
import com.example.challenge_ml_1.R;

import java.util.ArrayList;

public class AttributesAdapter extends  RecyclerView.Adapter<AttributesAdapter.AttributesViewHolder>{
    private static final String TAG = "AttributesAdapter";

    private ArrayList<Attributes> attributesArrayList;

    private Context context;

    public AttributesAdapter(Context context , ArrayList<Attributes> anAttributesList ){
        try{
            this.context = context;
            this.attributesArrayList = anAttributesList;

        } catch ( Exception e ){
            Log.e(TAG, "AttributesAdapter: e - ", e);
        }
    }

    @NonNull
    @Override
    public AttributesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.attributes_adapter_item, parent, false);
        return new DataViewHolder(root);
    }

    public class DataViewHolder extends AttributesViewHolder {
        public DataViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AttributesViewHolder holder, int position) {
        try{
            Attributes attributesItem = attributesArrayList.get(position);

            ((DataViewHolder)holder) .textViewName      . setText( attributesItem.getName());
            ((DataViewHolder)holder) .textViewValueName . setText( attributesItem.getValue_name());

        } catch ( Exception e ){
            Log.e(TAG, "onBindViewHolder: e - ", e);
        }
    }

    @Override
    public int getItemCount() { return attributesArrayList == null ? 0 : attributesArrayList.size() ;
    }

    public void setAttributesArrayList(ArrayList<Attributes> attributesArrayList) {
        this.attributesArrayList = attributesArrayList;
        notifyDataSetChanged();
    }

    public static class AttributesViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewValueName;

        public AttributesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName        = itemView.findViewById(R.id.txtV_name_attribute_adapter);
            textViewValueName   = itemView.findViewById(R.id.txtV_value_name_attribute_adapter);


        }
    }

}
