package com.example.theskillsshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ContactsActivity extends AppCompatActivity {

    CardView caller;
    CardView facebook;
    CardView email;
    CardView instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        caller = findViewById(R.id.caller);

        caller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:" + "+18765409333"));
                startActivity(callintent);
            }
        });

    }

    public void facebook(View view) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/The-Skills-Shop-101303204582655/"));
        startActivity(facebookIntent);
    }

    public void email(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"skillsshop2019@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,  "Email Body");
        startActivity(emailIntent);
    }

    public void instagram(View view) {
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/theskills-shop/"));
        startActivity(instagramIntent);
    }

}