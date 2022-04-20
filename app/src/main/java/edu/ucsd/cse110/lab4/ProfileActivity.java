package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // IMPLEMENT MISSING CODE HERE
        loadProfile();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // IMPLEMENT MISSING CODE HERE
        saveProfile();
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        // IMPLEMENT MISSING CODE HERE
        String s1 = preferences.getString("name", "");
        String s2 = preferences.getString("status", "");

        TextView nameView = findViewById(R.id.name_textview);
        nameView.setText(s1);

        TextView statusView = findViewById(R.id.status_textview);
        statusView.setText(s2);

    }

    public void saveProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor  = preferences.edit();
        // IMPLEMENT MISSING CODE HERE
        TextView nameView = findViewById(R.id.name_textview);
        editor.putString("name", nameView.getText().toString());

        TextView statusView = findViewById(R.id.status_textview);
        editor.putString("status", statusView.getText().toString());

        editor.apply();
    }

    public void onExitClicked(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        finish();
    }
}