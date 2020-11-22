package com.example.start;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class CfoodFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    RecyclerView recyclerView;
    List<Model> itemList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Handler handler = new Handler();
        View view = inflater.inflate(R.layout.fragment_cfood, container, false);

        itemList=new ArrayList<>();
        db.collection("china_food")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("china_d", document.getId() + " => " + document.getData());
                                itemList.add(new Model(document.getId().toString(),document.get("score").toString(),document.get("img").toString()));
                            }
                        } else {
                            Log.w("china_w", "Error getting documents.", task.getException());
                        }
                    }
                });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                recyclerView=view.findViewById(R.id.recycler_cfood);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                // initData();

                recyclerView.setAdapter(new ItemAdapter(itemList));
                Log.d("error", itemList.toString());
            }
        },2000);

        return view;
    }


}