package com.example.sendmessagewpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputTextPhone;
    private TextInputEditText inputTextMessage;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextPhone = findViewById(R.id.input_number_phone);
        inputTextMessage = findViewById(R.id.input_text_message);
        buttonEnviar = findViewById(R.id.button_submit);

        buttonEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        enviarMessage();
                    }
                });

    }


    private void enviarMessage(){

        String tel = inputTextPhone.getText().toString().trim();
        String message = inputTextMessage.getText().toString();

        String url = "https://wa.me/" + tel +"?text=" + message;

        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }
}