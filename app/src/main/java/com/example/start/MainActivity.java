package com.example.start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

   private MyHomeFragment myHomeFragment = new MyHomeFragment();
   private MyMiddleFragment myMiddleFragment = new MyMiddleFragment();
   private MyRightFragment myRightFragment = new MyRightFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bttid);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameid, myHomeFragment).commitAllowingStateLoss(); // 홈화면 뛰어줌

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.homeid:
                        fragmentTransaction.replace(R.id.frameid, myHomeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.middleid:
                        fragmentTransaction.replace(R.id.frameid, myMiddleFragment).commitAllowingStateLoss();
                        break;
                    case R.id.rightid:
                        fragmentTransaction.replace(R.id.frameid, myRightFragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}