package com.example.weatherwise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwise.ApiPackage.HourlyWeatherResponseModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    ArrayList<HourlyWeatherResponseModel.Hour> list;

    public Adapter(Context context, ArrayList<HourlyWeatherResponseModel.Hour> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.forecast_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        switch (list.get(position).getTime().substring(11)){
            case "00:00":
            case "01:00":
            case "02:00":
            case "03:00":
            case "04:00":
            case "05:00":
            case "06:00":
            case "07:00":
            case "08:00":
            case "09:00":
                holder.time.setText(list.get(position).getTime().substring(12,13).concat(" AM"));
                break;
            case "10:00":
            case "11:00":
                holder.time.setText(list.get(position).getTime().substring(11,13).concat(" AM"));
                break;
            case "12:00":
            case "13:00":
            case "14:00":
            case "15:00":
            case "16:00":
            case "17:00":
            case "18:00":
            case "19:00":
            case "20:00":
            case "21:00":
            case "22:00":
            case "23:00":
                holder.time.setText(list.get(position).getTime().substring(10).concat(" PM"));
                break;
        }

        holder.temp.setText(String.valueOf(Math.round(list.get(position).getTemp_c())).concat(" °C"));

        String fullUrl = "https:" + list.get(position).getCondition().getIcon();

        Glide.with(context).load("https:" + list.get(position).getCondition().getIcon()).into(holder.weatherIcon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
