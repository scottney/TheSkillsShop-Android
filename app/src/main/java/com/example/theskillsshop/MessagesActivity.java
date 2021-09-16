package com.example.theskillsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessagesActivity extends AppCompatActivity {
    private EditText first_name, surname, middle_name, phone_number, email, text_message;
    private TextClock created_at;
    private Button reset, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        first_name = findViewById(R.id.first_name);
        surname = findViewById(R.id.surname);
        middle_name = findViewById(R.id.middle_name);
        phone_number = findViewById(R.id.phone_number);
        email = findViewById(R.id.email);
        text_message = findViewById(R.id.text_message);
        //created_at = findViewById(R.id.created_at);
        reset = findViewById(R.id.reset);
        submit = findViewById(R.id.submit);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first_name.getEditableText().clear();
                surname.getEditableText().clear();
                middle_name.getEditableText().clear();
                phone_number.getEditableText().clear();
                email.getEditableText().clear();
                text_message.getEditableText().clear();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

    }

    private void sendData() {
        String checkSpaces = "\\A\\w{1,13}\\z";
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String firstNameInput = first_name.getEditableText().toString().trim();
        String surNameInput = surname.getEditableText().toString().trim();
        String middleNameInput = middle_name.getEditableText().toString().trim();
        String phoneNumberInput = phone_number.getEditableText().toString().trim();
        String emailInput = email.getEditableText().toString().trim();
        String textMessageInput = text_message.getEditableText().toString().trim();
        String createdAtInput = created_at.getText().toString().trim();

        if(firstNameInput.isEmpty()) {
            first_name.setError("Field cannot be empty...");
            first_name.requestFocus();
            return;
        } else if(firstNameInput.length() > 13) {
            first_name.setError("First name too long...");
            return;
        } else if (firstNameInput.length() < 2) {
            first_name.setError("First name too short...");
            return;
        } else if(!firstNameInput.matches(checkSpaces)) {
            first_name.setError("No white spaces allowed...");
            return;
        } else if(surNameInput.isEmpty()) {
            surname.setError("Field cannot be empty...");
            surname.requestFocus();
            return;
        } else if(surNameInput.length() > 13) {
            surname.setError("Surname too long...");
            return;
        } else if (surNameInput.length() < 2) {
            surname.setError("Surname too short...");
            return;
        } else if(!surNameInput.matches(checkSpaces)) {
            surname.setError("No white spaces allowed...");
            return;
        } else if(middleNameInput.isEmpty()) {
            middle_name.setError("Field cannot be empty...");
            middle_name.requestFocus();
            return;
        } else if(middleNameInput.length() > 13) {
            middle_name.setError("Middle name too long...");
            return;
        } else if (middleNameInput.length() < 2) {
            middle_name.setError("Middle name too short...");
            return;
        } else if(!middleNameInput.matches(checkSpaces)) {
            middle_name.setError("No white spaces allowed...");
            return;
        } else if(phoneNumberInput.isEmpty()) {
            phone_number.setError("Field cannot be empty...");
            phone_number.requestFocus();
            return;
        } else if(phoneNumberInput.length() > 11) {
            phone_number.setError("Phone number too long...");
            return;
        } else if (phoneNumberInput.length() < 10) {
            phone_number.setError("Phone number too short...");
            return;
        } else if(emailInput.isEmpty()) {
            email.setError("Field cannot be empty...");
            email.requestFocus();
            return;
        } else if(!emailInput.matches(checkEmail)) {
            email.setError("Invalid email address...");
            return;
        } else if(textMessageInput.isEmpty()) {
            text_message.setError("Field cannot be empty...");
            text_message.requestFocus();
            return;
        }

        Call<ResponseModel>call = RetrofitClient.getInstance().getAPI().sendData(firstNameInput,surNameInput,middleNameInput,phoneNumberInput,emailInput,textMessageInput,createdAtInput);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                //This method will be called on successful server call
                ResponseModel obj = response.body();

                if(obj.isStatus()) {
                    //What we want to do on successful insertion
                } else {
                    //What we do in case of an error
                    Toast.makeText(MessagesActivity.this, "Operation Failed", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MessagesActivity.this, obj.getRemarks(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                //This method will be called in case of failure
                Toast.makeText(MessagesActivity.this, "Network Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
