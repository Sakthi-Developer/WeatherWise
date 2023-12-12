package com.example.weatherwise;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import java.util.Objects;

public class CustomLoderDialog extends Dialog {
    public CustomLoderDialog(@NonNull Context context) {

        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog); // Use your custom layout here
        Objects.requireNonNull(getWindow()).setLayout(300, 300);

        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.dialog_background, null);
        if (drawable != null) {
            getWindow().setBackgroundDrawable(drawable);
        }

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.CENTER;
        getWindow().setAttributes(layoutParams);
        setCancelable(false);
    }

}

