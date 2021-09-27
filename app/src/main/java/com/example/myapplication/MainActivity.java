package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        ecouteBtnMenu1();
        ecouteBtnMenu2();
        ecouteBtnMenu3();
    }

    private void ecouteBtnMenu1() {
        findViewById(R.id.buttonMenu1).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu1Activity.class);
                startActivity(intent);

            }
        });
    }
    private void ecouteBtnMenu2() {
        findViewById(R.id.buttonMenu2).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu2Activity.class);
                startActivity(intent);

            }
        });
    }
    private void ecouteBtnMenu3() {
        findViewById(R.id.buttonMenu3).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu3Activity.class);
                startActivity(intent);

            }
        });
    }
}
