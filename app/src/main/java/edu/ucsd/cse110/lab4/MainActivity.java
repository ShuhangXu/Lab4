package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        //TextView textView = findViewById(R.id.text2022);
        //textView.setText("I love Feng!");
        startActivity(intent);
    }
}