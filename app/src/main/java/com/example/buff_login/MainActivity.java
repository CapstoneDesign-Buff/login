package com.example.buff_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_id,tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);


        Intent intent = getIntent();
        String user_id=intent.getStringExtra("user_id");
        String prv_password=intent.getStringExtra("prv_password");

        tv_id.setText(user_id);
        tv_pass.setText(prv_password);
    }
}