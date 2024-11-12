package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nameEtv, emailEtv, passwordEtv, numberEtv;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nameEtv = findViewById(R.id.nameETv);
        emailEtv = findViewById(R.id.emailEtv);
        passwordEtv = findViewById(R.id.passwordEtv);
        numberEtv = findViewById(R.id.numberEtv);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameEtv.getText().toString();
                String email=emailEtv.getText().toString();
                String password=passwordEtv.getText().toString();
                String number=numberEtv.getText().toString();

               boolean check = validateInfo(name,email,password,number);

               if(check==true){
                   Toast.makeText(getApplicationContext(), "data is valid",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(), "Sorry check information again",Toast.LENGTH_SHORT).show();
               }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private Boolean validateInfo(String name, String email, String password, String number) {
        if(name.length()==0){
            nameEtv.requestFocus();
            nameEtv.setError("Fild cannot be empty");
            return false;
        } else if (!name.matches("[a-zA-Z]+")) {
            nameEtv.requestFocus();
            nameEtv.setError("Alphebetical character");
            return false;
        }
        else if (email.length()==0) {
            emailEtv.requestFocus();
            emailEtv.setError("Can not be empty");
            return false;
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            emailEtv.requestFocus();
            emailEtv.setError("Enter valid Email");
            return false;
        }
         else if (password.length()<=6) {
            passwordEtv.requestFocus();
            passwordEtv.setError("Minimun 6");
            return false;

        }else if(number== password){
        numberEtv.requestFocus();
        numberEtv.setError("Put again");
        return false;
    } else if (number.length() == 0) {
            numberEtv.requestFocus();
            numberEtv.setError("Can not be empty");
            return false;
        }
        else {
            return true;
        }
    }
}