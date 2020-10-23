package me.tolkstudio.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CitiesFragment extends Fragment {

    private static final String CURRENT_CITY = "CurrentCity";
    boolean isExistWeather;

    Parcel currentParcel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isExistWeather = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        if(savedInstanceState != null){
            currentParcel = (Parcel) savedInstanceState.getSerializable(CURRENT_CITY);
        } else {
            currentParcel = new Parcel(0,getResources().getStringArray(R.array.cities)[0]);
        }

        if(isExistWeather){
            showWeather(currentParcel);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CURRENT_CITY, currentParcel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initList(view);
    }

    private void initList(View view){
        LinearLayout layoutView = (LinearLayout) view;
        String[] cities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(30);


            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(v -> {
                currentParcel = new Parcel(fi,getResources().getStringArray(R.array.cities)[fi]);
                showWeather(currentParcel);
            });
        }
    }
    private void showWeather(Parcel parcel){
        if(isExistWeather){
            WeatherFragment detail = (WeatherFragment) getFragmentManager().findFragmentById(R.id.weather_frame);

            if (detail == null|| detail.getParsel().getImageIndex() != parcel.getImageIndex()){
                detail = WeatherFragment.create(parcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.weather_frame,detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, WeatherFragment.create(parcel))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
