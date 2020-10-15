package me.tolkstudio.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity implements Constants {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Parcel parcel = (Parcel) getIntent().getExtras().getSerializable(TEXT);

        TextView editCitiAct2 = findViewById(R.id.editCityAct2);
        EditText tempAct2 = findViewById(R.id.tempAct2);

        editCitiAct2.setText(parcel.text);
        tempAct2.setText(String.valueOf(parcel.number));

        Button backToAct1 = findViewById(R.id.backToAct1);
        backToAct1.setOnClickListener(view -> {

            EditText editTemp = findViewById(R.id.tempAct2);
            Intent intentResult = new Intent();
            intentResult.putExtra(NUMBER_RESULT,editTemp.getText().toString());
            setResult(RESULT_OK,intentResult);
            Toast.makeText(ActivityTwo.this, "Вернулись на первую активити", Toast.LENGTH_SHORT).show();
            finish();
            Log.d("ActivitiTwo","finish");
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onStart()");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(),"onSaveInstanceState()",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onSaveInstanceState()");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onResume()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"Повторный запуск",Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"onRestart()",
                Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy()",
                Toast.LENGTH_SHORT).show();
        Log.d("ActivityTwo","onDestroy()");
    }
}