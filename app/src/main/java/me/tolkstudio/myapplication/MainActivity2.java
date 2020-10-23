package me.tolkstudio.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initDataSource();

        Button button = findViewById(R.id.backToAct1);
        button.setOnClickListener(view -> finish());
    }

    // Выделяем инициализацию источника данных
    private void initDataSource() {
        // строим источник данных
        SocialDataSource sourceData = new SocSourceBuilder()
                .setResources(getResources())
                .build();

//        final SocialChangableSource sourceChangableData = new SocChangableSource(sourceData)
//        код с урока пока оставил я его изучал часов 8 _)

        final SocnetAdapter adapter = initRecyclerView(sourceData);

//        Button add = findViewById(R.id.buttonAdd);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sourceChangableData.add();
//                adapter.notifyItemInserted(sourceChangableData.size());
//            }
//        });
//        Button delete = findViewById(R.id.buttonDel);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sourceChangableData.delete();
//                adapter.notifyItemRemoved(sourceChangableData.size());
//            }
//        });
    }

    private SocnetAdapter initRecyclerView(SocialDataSource sourceData) {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Добавим разделитель карточек
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);

        // Установим анимацию. А чтобы было хорошо заметно, сделаем анимацию долгой
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(500);
        animator.setRemoveDuration(500);
        recyclerView.setItemAnimator(animator);

        // Установим адаптер
        SocnetAdapter adapter = new SocnetAdapter(sourceData);
        recyclerView.setAdapter(adapter);

        // Установим слушателя
        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent weatherNow = new Intent(Intent.ACTION_VIEW);
                weatherNow.setData(Uri.parse("https://yandex.ru/pogoda"));
                startActivity(weatherNow);
            }
        });
        return adapter;
    }
}