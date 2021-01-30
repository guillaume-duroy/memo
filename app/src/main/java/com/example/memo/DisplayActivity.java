package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();
        String message = intent.getStringExtra("Message");
        int viewType = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        if (viewType == 1)
        {
            setContentView(R.layout.activity_display);
        }

        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
    }

    protected void dosomething() {

        String message = intent.getStringExtra("Message2");

    }

}
