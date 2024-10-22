package com.example.wallapop;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wallapop.login_user.view.LoginUserM;
import com.example.wallapop.register_user.view.RegisterUserView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);

        Intent myIntent = new Intent(MainActivity.this, RegisterUserView.class);
        startActivity(myIntent);


    }
}