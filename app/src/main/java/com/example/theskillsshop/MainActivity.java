package com.example.theskillsshop;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    CardView home;
    CardView dashboard;
    CardView contacts;
    CardView operations;
    CardView blog;
    CardView messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.home);
        dashboard = findViewById(R.id.dashboard);
        contacts = findViewById(R.id.contacts);
        operations = findViewById(R.id.operations);
        messages = findViewById(R.id.messages);
        blog = findViewById(R.id.blog);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( MainActivity.this,HomeActivity.class ));
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( MainActivity.this,DashboardActivity.class ));
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( MainActivity.this,ContactsActivity.class ));
            }
        });

        operations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( MainActivity.this,OperationsActivity.class ));
            }
        });

        /*
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( MainActivity.this,MessagesActivity.class ));
            }
        });
         */

    }

    public void messages(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/contacts/contacts/#message_form"));
        startActivity(blogIntent);
    }

    public void blog(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/blog/blog"));
        startActivity(blogIntent);
    }
}