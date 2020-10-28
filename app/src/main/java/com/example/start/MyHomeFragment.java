package com.example.start;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MyHomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_home, container, false); // 임의로 지정했다.

        Button button = view.findViewById(R.id.kfood);
        Button button1 = view.findViewById(R.id.jfood);
        Button button2 = view.findViewById(R.id.cfood);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"korea",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("country",0);

                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"japan",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("country",1);
                startActivity(intent); // 이동할 때 사용 intent
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"china",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("country",2);

                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}