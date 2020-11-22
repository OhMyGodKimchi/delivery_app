package com.example.start.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.start.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Menu> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Menu> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).img)
                .into(holder.img);

        holder.name.setText(arrayList.get(position).name);
        holder.content.setText(arrayList.get(position).content);
        holder.price.setText(arrayList.get(position).price);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(context,holder.name.getText().toString() + "가 체크되었습니다",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,holder.name.getText().toString() + "가 체크해지되었습니다",Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size():0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView content;
        private ImageView img;
        private TextView price;
        private CheckBox checkBox;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_id);
            content = itemView.findViewById(R.id.content_id);
            img = itemView.findViewById(R.id.profile_id);
            price = itemView.findViewById(R.id.price_id);
            checkBox = itemView.findViewById(R.id.checkbox_id);



        }
    }
}