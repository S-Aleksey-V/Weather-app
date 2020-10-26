package me.tolkstudio.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    public static final String PARCEL = "parcel";

    public static WeatherFragment create(Parcel parcel){
        WeatherFragment fragment = new WeatherFragment();

        Bundle args = new Bundle();
        args.putSerializable(PARCEL,parcel);

        fragment.setArguments(args);

        return fragment;
    }

    public Parcel getParsel(){
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_weather, container, false);

        ImageView coatOfArms = layout.findViewById(R.id.imageView);
        TextView cityNameView = layout.findViewById(R.id.textView);
        Button button = (Button) layout.findViewById(R.id.button);

        button.setOnClickListener(view -> {
            Intent weatherNow = new Intent(Intent.ACTION_VIEW);
            weatherNow.setData(Uri.parse("https://yandex.ru/pogoda"));
            startActivity(weatherNow);
        });

        TypedArray imgs = getResources().obtainTypedArray(R.array.cities_img);
        Parcel parcel = getParsel();


        coatOfArms.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        cityNameView.setText(parcel.getCityName());
        return layout;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
