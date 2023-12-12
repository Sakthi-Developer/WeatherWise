package com.example.weatherwise;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        getFirebaseMessage(Objects.requireNonNull(message.getNotification()).getTitle(), message.getNotification().getBody());
    }

    @SuppressLint("MissingPermission")
    private void getFirebaseMessage(String title, String body) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notify")
                .setContentTitle(title).setContentText(body).setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(102, builder.build());
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }
}
