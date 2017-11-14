package com.example.root.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumber;
    private EditText smsBody;
    private Button smsManagerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = (EditText) findViewById(R.id.phoneNUmber);
        smsBody = (EditText) findViewById(R.id.smsBody);
        smsManagerBtn = (Button) findViewById(R.id.smsManagerBtn);

        smsManagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsByManager();
            }
        });
    }

        public void sendSmsByManager(){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.getText().toString(), null, smsBody.getText().toString(), null, null);
            Toast.makeText(getApplicationContext(),"SMS BERHASIL TERKIRIM...",Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"SMS GAGAL TERKIRIM...",Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }


    }

