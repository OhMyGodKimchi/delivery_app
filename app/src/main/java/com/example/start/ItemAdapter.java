package com.example.start;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<Model> itemList1;

    public ItemAdapter(List<Model> itemList) {

        this.itemList1=itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemImage.setImageResource(itemList1.get(position).getImage());
        holder.itemtxt1.setText(itemList1.get(position).getName1());
        holder.itemtxt2.setText(itemList1.get(position).getName2());
        holder.itemImage2.setImageResource(itemList1.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemtxt1;
        TextView itemtxt2;
        ImageView itemImage2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.myImageView);
            itemtxt1 = itemView.findViewById(R.id.myText1);
            itemtxt2 = itemView.findViewById(R.id.myText2);
            itemImage2 = itemView.findViewById(R.id.myImageView2);

        }
    }
}
