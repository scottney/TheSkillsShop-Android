package com.example.theskillsshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    CardView customers_booking;
    CardView customers_rating;
    CardView skills_person_registration;
    CardView skills_person_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        customers_booking = findViewById(R.id.customers_booking);
        customers_rating = findViewById(R.id.customers_rating);
        skills_person_registration = findViewById(R.id.skills_person_registration);
        skills_person_rating = findViewById(R.id.skills_person_rating);

        /*
        customers_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( DashboardActivity.this,CustomersBookingActivity.class ));
            }
        });

        customers_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( DashboardActivity.this,CustomersRatingActivity.class ));
            }
        });

        skills_person_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( DashboardActivity.this,SkillsPersonRegistrationActivity.class ));
            }
        });

        skills_person_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                startActivity(new Intent( DashboardActivity.this,SkillsPersonRatingActivity.class ));
            }
        });
         */

    }

    public void customers_booking(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/customers/book/customers%20booking"));
        startActivity(blogIntent);
    }

    public void customers_rating(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/customers/rate/customers%20rating"));
        startActivity(blogIntent);
    }

    public void skills_person_registration(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/skills_person/register/skills%20person%20registration"));
        startActivity(blogIntent);
    }

    public void skills_person_rating(View view) {
        Intent blogIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://theskills-shop.com/pages/skills_person/rate/skills%20person%20rating"));
        startActivity(blogIntent);
    }



}