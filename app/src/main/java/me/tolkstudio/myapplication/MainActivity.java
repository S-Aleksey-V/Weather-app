package me.tolkstudio.myapplication;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        return true;
                    case R.id.week_temp:
                        Toast.makeText(getApplicationContext(),"Тут надо переходить на вторую активити",Toast.LENGTH_LONG).show();
    //                    startActivities(new Intent(this,MainActivity2.class)); // пытался перейти на 2рую активити но что то так и не дошло до меня как это сделать
                        return true;
                    case R.id.theme:
                        return true;

                }
                return false;
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.goToAct2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new CitiesFragment())
                    .commit();
        }


        button.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity2.class));
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

