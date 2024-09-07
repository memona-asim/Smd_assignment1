package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.TableLayout;

public class ReviewScreen extends AppCompatActivity {

    private TableLayout tableLayout;
    private FloatingActionButton fabBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tableLayout = findViewById(R.id.tableLayout);
        fabBackToMain = findViewById(R.id.fabBackToMain);

        Intent intent = getIntent();
        String senderName = intent.getStringExtra("senderFullName");
        String senderCountry = intent.getStringExtra("senderCountry");
        String senderAddress = intent.getStringExtra("senderAddress");
        String senderContactInfo = intent.getStringExtra("senderPhone");
        String receiverName = intent.getStringExtra("receiverFullName");
        String receiverCountry = intent.getStringExtra("receiverCountry");
        String receiverAddress = intent.getStringExtra("receiverAddress");
        String receiverContactInfo = intent.getStringExtra("receiverPhone");

        addRow(senderName, senderCountry, senderAddress, senderContactInfo);
        addIconRow();
        addRow(receiverName, receiverCountry, receiverAddress, receiverContactInfo);

        fabBackToMain.setOnClickListener(v -> {
            Intent mainIntent = new Intent(ReviewScreen.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        });
    }

    private void addRow(String name, String country, String address, String contactInfo) {
        TableRow tableRow = new TableRow(this);

        TextView nameTextView = createTextView(name);
        TextView countryTextView = createTextView(country);
        TextView addressTextView = createTextView(address);
        TextView contactInfoTextView = createTextView(contactInfo);

        tableRow.addView(nameTextView);
        tableRow.addView(countryTextView);
        tableRow.addView(addressTextView);
        tableRow.addView(contactInfoTextView);

        tableLayout.addView(tableRow);
    }
    private void addIconRow() {
        TableRow tableRow = new TableRow(this);

        ImageView iconImageView = new ImageView(this);
        iconImageView.setImageResource(R.drawable.two_sided_arrow);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        iconImageView.setLayoutParams(layoutParams);

        iconImageView.setPadding(16, 8, 16, 8);

        tableRow.addView(iconImageView);
        tableRow.addView(createTextView(" "));
        tableRow.addView(createTextView(" "));
        tableRow.addView(createTextView(" "));

        tableLayout.addView(tableRow);
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);

        textView.setPadding(16, 8, 16, 8);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8, 8, 8, 8);
        textView.setLayoutParams(layoutParams);

        textView.setTextColor(getResources().getColor(android.R.color.black));
        return textView;
    }

    }


