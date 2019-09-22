package com.example.memo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MainActivity.MESSAGE";
    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        count = 0;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creation of Intent ('intention de passer à une autre activité)
                // first argument is Context (normally just 'this' but since we
                // are in a new function creator we need to specify 'ActivityName.this'
                // second argument is the class of the next activity
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();

                // add <key,value> pair into Intent
                intent.putExtra("Message",message);
                intent.putExtra(EXTRA_MESSAGE,1);

                startActivity(intent);
            }
        });

        FloatingActionButton fab3 = findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creation of Intent ('intention de passer à une autre activité)
                // first argument is Context (normally just 'this' but since we
                // are in a new function creator we need to specify 'ActivityName.this'
                // second argument is the class of the next activity
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();

                // add <key,value> pair into Intent
                intent.putExtra("Message",message);
                intent.putExtra(EXTRA_MESSAGE,2);

                TextView textView;
//                switch (count)
//                {
//                    case 0:
//                        textView = findViewById(R.id.flirt1);
//                        textView.setVisibility(View.VISIBLE);
//                    case 1:
//                        textView = findViewById(R.id.flirt2);
//                        textView.setVisibility(View.VISIBLE);
//                    case 2:
//                        textView = findViewById(R.id.flirt3);
//                        textView.setVisibility(View.VISIBLE);
//                    case 3:
//                        textView = findViewById(R.id.flirt4);
//                        textView.setVisibility(View.VISIBLE);
//                }

                // smarter way than switch case but needs protection
                // when count grows larger than max amount (4)
                textView = findViewById(getResources().getIdentifier(
                        "flirt" + (count+1),
                        "id",
                        getPackageName()));
                if (textView != null)
                {
                    textView.setVisibility(View.VISIBLE);
                    count++;
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Alix is the most beautiful <3", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
