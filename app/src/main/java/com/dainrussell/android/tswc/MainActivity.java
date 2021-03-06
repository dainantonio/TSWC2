package com.dainrussell.android.tswc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ((Button) findViewById(R.id.sendButton)).setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View view) {
                String to = ((EditText) findViewById(R.id.emailTo)).getText().toString();
                String subject = ((EditText) findViewById(R.id.emailSubject)).getText().toString();
                String body = ((EditText) findViewById(R.id.emailBody)).getText().toString();

                //intent used to launch email app

                Intent intent = new Intent(Intent.ACTION_SENDTO);


                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, body);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Send Feedback via"));

            }
        });
    }
}
