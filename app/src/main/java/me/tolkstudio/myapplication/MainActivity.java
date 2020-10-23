package me.tolkstudio.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new CitiesFragment())
                    .commit();

        }

        Button button = findViewById(R.id.buttonGo);
        button.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity2.class));
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

