package me.tolkstudio.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.function.LongFunction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if(savedInstanceState == null){
            instanceState ="Первый запуск";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(),instanceState + " - onCreate()",
                Toast.LENGTH_SHORT).show();
        Log.d(instanceState," - OnCreate");


        Button buttonBarnaul = findViewById(R.id.buttonBarnaul);
        buttonBarnaul.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Погода в Барнауле", Toast.LENGTH_SHORT).show());

        Button buttonMoscow = findViewById(R.id.buttonMoscow);
        buttonMoscow.setOnClickListener(this);

        Button buttonSochi = findViewById(R.id.buttonSochi);
        buttonSochi.setOnClickListener(this);

        Button buttonCity = findViewById(R.id.buttonCity);
        buttonCity.setOnClickListener(this);

        Button btnAct2 = findViewById(R.id.btn_Act2);
        btnAct2.setOnClickListener(this);


    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onStart()");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(),"onSaveInstanceState()",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onSaveInstanceState()");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onResume()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"Повторный запуск",Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart()",
                Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy()",
                Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","onDestroy()");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonMoscow:
                Toast.makeText(this, "Погода в москве", Toast.LENGTH_SHORT).show();
                return;

            case R.id.buttonSochi:
                Toast.makeText(this, "Погода в Сочи", Toast.LENGTH_SHORT).show();
                return;

            case R.id.buttonCity:
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("В дальнейшем при нажатии на эту кнопку будет показана погода в вашем городе")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create()
                        .show();
                return;

            case R.id.btn_Act2:
                startActivity(new Intent(this,ActivityTwo.class));



        }
    }
}