package com.example.memo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int defi;
    public static final String EXTRA_MESSAGE = "MainActivity.MESSAGE";
    public static int count;

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("main","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("main","onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("main","onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("main","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        defi=1;
        count = 0;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (defi < 4) {
                    defi++;
                }
                else {
                    defi = 1;
                }
                Snackbar.make(view, "The global variable is: "+defi, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        };

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(listener);

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
                intent.putExtra("Message2",message);

                startActivity(intent);
            }
        });

        FloatingActionButton fab3 = findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                    Toast.makeText(MainActivity.this,"Guillaume is the most beautiful <3", Toast.LENGTH_LONG).show();
                }
            }
        });

        FloatingActionButton fab4 = findViewById(R.id.fab4);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creation of Intent ('intention de passer à une autre activité)
                // first argument is Context (normally just 'this' but since we
                // are in a new function creator we need to specify 'ActivityName.this'
                // second argument is the class of the next activity
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

                TextView textView;

                textView = findViewById(getResources().getIdentifier(
                        "flirt" + (defi),
                        "id",
                        getPackageName()));
                if (textView != null)
                {
                    intent.putExtra("Message",textView.getText().toString());
                    intent.putExtra(EXTRA_MESSAGE,1);
                    //textView = findViewById(R.id.flirt1);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Game over", Toast.LENGTH_LONG).show();
                    intent.putExtra("Message",textView.getText().toString());
                    intent.putExtra(EXTRA_MESSAGE,1);
                }




                //textView = findViewById(R.id.flirt1);

                // EditText editText = (EditText) findViewById(R.id.editText);
                // String message = editText.getText().toString();

                // add <key,value> pair into Intent
                //intent.putExtra("Message",textView.getText().toString());
                //intent.putExtra(EXTRA_MESSAGE,1);
               // intent.putExtra("Message2",message);

                startActivity(intent);
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
