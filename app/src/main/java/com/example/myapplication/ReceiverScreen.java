package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverScreen extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextCountry;
    private EditText editTextAddress;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reciever_input_screen);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextAddress = findViewById(R.id.editTextAddress);
        buttonNext = findViewById(R.id.buttonNext);

        Intent intent = getIntent();
        final String senderFullName = intent.getStringExtra("senderFullName");
        final String senderPhone = intent.getStringExtra("senderPhone");
        final String senderCountry = intent.getStringExtra("senderCountry");
        final String senderAddress = intent.getStringExtra("senderAddress");


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String receiverFullName = editTextName.getText().toString();
                String receiverPhone = editTextPhone.getText().toString();
                String receiverCountry = editTextCountry.getText().toString();
                String receiverAddress = editTextAddress.getText().toString();

                Intent intent = new Intent(ReceiverScreen.this, ReviewScreen.class);
                intent.putExtra("senderFullName", senderFullName);
                intent.putExtra("senderPhone", senderPhone);
                intent.putExtra("senderCountry", senderCountry);
                intent.putExtra("senderAddress", senderAddress);
                intent.putExtra("receiverFullName", receiverFullName);
                intent.putExtra("receiverPhone", receiverPhone);
                intent.putExtra("receiverCountry", receiverCountry);
                intent.putExtra("receiverAddress", receiverAddress);
                startActivity(intent);
            }
        });
    }
}
