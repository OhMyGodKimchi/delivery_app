package com.example.start.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.start.MainActivity2;
import com.example.start.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailFoodActivty extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Menu> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private MainActivity2 mainActivity2 = new MainActivity2();

    private DetailFoodActivty detailFoodActivty = new DetailFoodActivty();




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_food);

        TextView textView = findViewById(R.id.food_name);

        Intent intent = getIntent();
        Log.d("check","what "+intent.getExtras().getInt("please"));
        textView.setText(intent.getStringExtra("name")); // 누를 때마다 클릭 된 이름 나오게 하오는것
        Log.d("ahaha","It is "+ intent.getStringExtra("yours"));
        Handler handler = new Handler();



        ArrayList<Menu> itemList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("korea_food") // 던져준것 받은 것 해결하면됨
                .document(intent.getStringExtra("name"))
                .collection("menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("sss", document.getId() + " => " + document.getData());
                                itemList.add(new Menu(document.getId().toString(),document.get("content").toString(),document.get("img").toString(),
                                        document.get("price").toString()));
                            }
                        } else {
                            Log.w("sss", "Error getting documents.", task.getException());
                        }
                    }
                });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                recyclerView=findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



                recyclerView.setAdapter(new CustomAdapter(itemList));
                Log.d("error", itemList.toString());
            }
        },2000);
        // Inflate the layout for this fragment

    }
}
