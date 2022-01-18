package com.example.sdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {


    private Button sendbutton;
    private EditText namefeedtext, messagefeedtext, mailfeedtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        this.setTitle("Feedback ");

        sendbutton = findViewById(R.id.sendfeed);
        namefeedtext = findViewById(R.id.feedname);
        messagefeedtext = findViewById(R.id.feedmessage);
        mailfeedtext = findViewById(R.id.feedmail);

        sendbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

            String name = namefeedtext.getText().toString();
            String mail = mailfeedtext.getText().toString();
            String message = messagefeedtext.getText().toString();


            if (v.getId() == R.id.sendfeed) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"nirviknirvik58@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback your app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name  + "\n Message : " + message);

                startActivity(Intent.createChooser(intent, "feedback with"));


            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(),"Exception :"+e ,Toast.LENGTH_SHORT).show();

        }


    }
}