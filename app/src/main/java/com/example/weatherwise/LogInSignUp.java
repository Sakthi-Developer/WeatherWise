 package com.example.weatherwise;

 import android.annotation.SuppressLint;
 import android.app.Dialog;
 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;
 import android.text.InputType;
 import android.util.Log;
 import android.util.Patterns;
 import android.view.View;
 import android.widget.EditText;
 import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;

 import com.google.android.material.tabs.TabLayout;
 import com.google.firebase.auth.FirebaseUser;

 import java.util.Objects;

 public class LogInSignUp extends AppCompatActivity {

     private boolean VIEW_STATUS = false;
     private boolean NEW_USER = false;
     private TextView warning;
     private FirebaseAuthManager authManager;
     public Dialog loder_dialog;

     @Override
     @SuppressLint({"MissingInflatedId", "LocalSuppress"})

     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_log_in_sign_up);


         authManager = FirebaseAuthManager.getInstance();

         FirebaseUser currentUser = authManager.getCurrentUser();

         if (currentUser != null) {

             startActivity(new Intent(this, MainActivity.class));
             finish();

         }

         TabLayout log_in_tab = findViewById(R.id.log_in_tab);
         EditText email_text = findViewById(R.id.emailText);
         EditText password_text = findViewById(R.id.passwordText);
         LinearLayout submit = findViewById(R.id.submit_button);
         TextView submit_text = findViewById(R.id.log_sign);
         ImageView eye = findViewById(R.id.eye);
         warning = findViewById(R.id.warning);



         log_in_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @SuppressLint("SetTextI18n")
             @Override
             public void onTabSelected(TabLayout.Tab tab) {
                 if (tab.getPosition() == 0) {

                     submit_text.setText("Log In");
                     warning.setVisibility(View.GONE);
                     NEW_USER = false;

                 } else {

                     submit_text.setText("Sign Up");
                     warning.setVisibility(View.GONE);
                     NEW_USER = true;

                 }
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });
         eye.setOnClickListener(v -> {
             @SuppressLint("CutPasteId") ImageView imageView = findViewById(R.id.eye);
             if (VIEW_STATUS) {
                 password_text.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                 imageView.setImageResource(R.drawable.hidden);
                 VIEW_STATUS = false;

             } else {
                 password_text.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                 imageView.setImageResource(R.drawable.view);
                 VIEW_STATUS = true;
             }

             password_text.setSelection(password_text.getText().length());
         });

         submit.setOnClickListener(v -> {



             String get_email = email_text.getText().toString();
             String get_password = password_text.getText().toString();

             if (checkCredentials(warning, get_email,get_password)) {

                 if (NEW_USER) {

                     signUpWithEmailPassword(get_email, get_password);

                 } else {

                     logInWithEmailPassword(warning, get_email, get_password);

                 }
             }
         });

     }

     @SuppressLint("SetTextI18n")
     private void logInWithEmailPassword(TextView textView, String email, String password){
         CustomLoderDialog customLoderDialog = new CustomLoderDialog(this);

         if (loder_dialog != null) {
             if (loder_dialog.isShowing()) {
                 loder_dialog.dismiss();
             } else {
                 loder_dialog.show();
             }
         } else{
             customLoderDialog.show();
         }

         authManager.getFirebaseAuth().signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()){

                 new Handler().postDelayed(() -> {
                     customLoderDialog.dismiss();
                     startActivity(new Intent(LogInSignUp.this, MainActivity.class));
                     finish();
                 },2000);


            } else {

                if (String.valueOf(Objects.requireNonNull(task.getException()).getMessage()).equals("The supplied auth credential is incorrect, malformed or has expired.")) {
                    customLoderDialog.dismiss();
                    textView.setText("Account Not Found");
                    textView.setVisibility(View.VISIBLE);
                }
                Toast.makeText(this, "Use Sign Up", Toast.LENGTH_LONG).show();

                Log.d("FailLogin", Objects.requireNonNull(Objects.requireNonNull(task.getException()).getMessage()));
            }

         });
     }

     private void signUpWithEmailPassword(String email, String password){

         authManager.getFirebaseAuth().createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

             if (task.isSuccessful()){
                 logInWithEmailPassword(warning, email, password);
                 Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show();

             }else{
                 loder_dialog.dismiss();
                 Log.d("onFail", Objects.requireNonNull(Objects.requireNonNull(task.getException()).getMessage()));
                 Toast.makeText(this, "Sign Up Unsuccessful", Toast.LENGTH_SHORT).show();
             }
         });
     }


     @SuppressLint("SetTextI18n")
     private boolean checkCredentials(TextView textview, String email, String password){


         if (email.length() !=0 && password.length() !=0){

             if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                 if (password.length() > 5){


                     textview.setVisibility(View.GONE);
                     return true;

                 }else {

                     textview.setText("Password should be more than Six characters");
                     textview.setVisibility(View.VISIBLE);
                     return false;
                 }

             }else {


                 textview.setText("Invalid Email");
                 textview.setVisibility(View.VISIBLE);
                 return false;
             }

         } else {

             textview.setText("Please provide both email and password");
             textview.setVisibility(View.VISIBLE);

             return false;
         }
     }

}