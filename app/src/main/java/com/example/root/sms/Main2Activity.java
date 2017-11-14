package com.example.root.sms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mContext = getApplicationContext();

        mActivity = Main2Activity.this;

        mButton = (Button) findViewById(R.id.button);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] email = new String[]{
                        "emailku@example.com",
                        "emailmu@example.com"
                };

                String mailSubject = "Subject";
                String mailBody = "Isi email";

                Intent intent = new Intent(Intent.ACTION_SENDTO);

                intent.putExtra(Intent.EXTRA_EMAIL,email);

                intent.putExtra(Intent.EXTRA_SUBJECT,mailSubject);

                intent.putExtra(Intent.EXTRA_TEXT,mailBody);

                intent.setData(Uri.parse("mailto:"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext,"Tidak ada klien email yang terpasang di perangkat ini.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void sms(View view) {
        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }
}
