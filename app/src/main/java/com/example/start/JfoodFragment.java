package com.example.start;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JfoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JfoodFragment extends Fragment {



    RecyclerView recyclerView;
    List<Model> itemList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jfood, container, false);
        recyclerView=view.findViewById(R.id.recycler_jfood);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

       // initData();

        recyclerView.setAdapter(new ItemAdapter(initData()));

        return view;
    }

    private List<Model> initData() {

        itemList=new ArrayList<>();
        itemList.add(new Model(R.drawable.sushi,"스시","4.5",R.drawable.star));
        itemList.add(new Model(R.drawable.onigiri,"오니기리","4.5",R.drawable.star));
        itemList.add(new Model(R.drawable.ramen,"라멘","4.5",R.drawable.star));

        return itemList;

    }
}