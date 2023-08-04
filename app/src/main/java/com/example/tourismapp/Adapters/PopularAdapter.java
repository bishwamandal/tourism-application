package com.example.tourismapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.Domains.PopularDomain;
import com.example.tourismapp.R;
import com.google.android.material.card.MaterialCardView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<PopularDomain> items;
    DecimalFormat formatter;

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.placenameTxt.setText(items.get(position).getTitle());
        holder.addressTxt.setText(items.get(position).getLocation());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView placenameTxt, addressTxt;
        MaterialCardView placeimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            placenameTxt = itemView.findViewById(R.id.placename);
            addressTxt = itemView.findViewById(R.id.placeaddress);
            placeimage = itemView.findViewById(R.id.placeimg);
        }
    }
}
