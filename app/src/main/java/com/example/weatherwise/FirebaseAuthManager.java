package com.example.weatherwise;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthManager {

    public static FirebaseAuthManager instance;
    private final FirebaseAuth mAuth;

    private FirebaseAuthManager(){
        mAuth = FirebaseAuth.getInstance();
    }

    public static synchronized FirebaseAuthManager getInstance(){
        if (instance == null){
            instance = new FirebaseAuthManager();
        }
        return instance;
    }

    public FirebaseAuth getFirebaseAuth() {
        return mAuth;
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public boolean signOut() {
        try {
            mAuth.signOut();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
