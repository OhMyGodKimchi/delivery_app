package com.example.start;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.start.main.DetailFoodActivty;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;

    List<Model> itemList1;

    public ItemAdapter(List<Model> itemList) {

        this.itemList1=itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        context = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemImage)
                .load(itemList1.get(position).img)
                .into(holder.itemImage);

        holder.itemtxt1.setText(itemList1.get(position).name1);
        holder.itemtxt2.setText(itemList1.get(position).name2);
        holder.itemImage2.setImageResource(R.drawable.star);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFoodActivty.class);
                intent.putExtra("name",holder.itemtxt1.getText());
                Log.d("putExtra_name","it is " +intent.putExtra("name",holder.itemtxt1.getText()));
                context.startActivity(intent);
            }
        });
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
