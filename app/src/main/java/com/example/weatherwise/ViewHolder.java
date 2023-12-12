package com.example.weatherwise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView time, temp;
    ImageView weatherIcon;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        time = itemView.findViewById(R.id.time);
        temp = itemView.findViewById(R.id.temp);
        weatherIcon =itemView.findViewById(R.id.foreCastImage);

    }
}
