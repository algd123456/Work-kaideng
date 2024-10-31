package com.example.mykaideng;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageView imageView;
    private TextView textView;
    private boolean isOpen=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        imageButton = findViewById(R.id.ib);
        imageView = findViewById(R.id.iv);
        textView = findViewById(R.id.tv);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    imageButton.setBackgroundResource(R.drawable.btn_close);
                    imageView.setBackgroundResource(R.drawable.img_close);
                    textView.setText("开灯");
                    isOpen=false;
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    stopService(intent);
                }else{
                    imageButton.setBackgroundResource(R.drawable.btn_open);
                    imageView.setBackgroundResource(R.drawable.img_open);
                    textView.setText("关灯");
                    isOpen=true;
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    startService(intent);
                }
            }
        });
    }
}