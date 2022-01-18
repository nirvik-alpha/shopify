package com.example.sdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    private AlertDialog.Builder alertdialogbuilder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navig);
        this.setTitle("Home Page");

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId())
                    {
                        case R.id.myorder:
                            Intent intent2 = new Intent(NavigActivity.this,OrderActivity.class);
                            startActivity(intent2);
                            break;

                        case R.id.categorynaviid:
                            Intent intent = new Intent(NavigActivity.this,CategoryActivity.class);
                            startActivity(intent);

                            break;

                        case R.id.aboutid:
                            Intent intent1 = new Intent(NavigActivity.this,AboutActivity.class);
                            startActivity(intent1);
                            break;

                        case R.id.logoutid:
                            userAlert();
                            break;

                    }

                    return true;
                }

                private void userAlert() {
                    alertdialogbuilder = new AlertDialog.Builder(NavigActivity.this);
                    alertdialogbuilder.setTitle(R.string.title_text);
                    alertdialogbuilder.setMessage(R.string.message_text);
                    alertdialogbuilder.setIcon(R.drawable.question);

                    alertdialogbuilder.setCancelable(false);

                    alertdialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alertdialogbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertdialogbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(NavigActivity.this ,"Cancel",Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog alertDialog = alertdialogbuilder.create();
                    alertDialog.show();
                }
            };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.barmenu_layout ,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.barshare)
        {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Shoppify app";
            String body = "Shoppify app is a kind of shopping mall app. You can buy product online easily .Try this app!";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"share with"));

        }
        else if(item.getItemId()==R.id.barfeed)
        {
            Intent intent = new Intent(NavigActivity.this,FeedbackActivity.class);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }
}