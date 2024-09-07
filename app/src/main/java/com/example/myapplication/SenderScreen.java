package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SenderScreen extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextCountry;
    private EditText editTextAddress;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sender_input_screen);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String country = editTextCountry.getText().toString();
                String address = editTextAddress.getText().toString();

                // Create an Intent to start the ReviewScreen
                Intent intent = new Intent(SenderScreen.this, ReceiverScreen.class);

                // Pass data to the next screen
                intent.putExtra("senderFullName", fullName);
                intent.putExtra("senderPhone", phone);
                intent.putExtra("senderCountry", country);
                intent.putExtra("senderAddress", address);

                startActivity(intent);
            }
        });
    }
}
