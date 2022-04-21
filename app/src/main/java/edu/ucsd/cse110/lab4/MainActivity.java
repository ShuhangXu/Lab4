package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

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

    public void onShowCounterClicked(View view){
        Intent intent = new Intent(this, CounterActivity.class);

        TextView maxCountView = findViewById(R.id.max_count_view);
        String maxCountStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        // Check if the integer parsed correctly.
        if(!maybeMaxCount.isPresent()) {
            // If not, show an error, and then return
            Utilities.showAlert(this, "That isn't a number!");
            return;
        }

        // Get the integer
        int maxCount = maybeMaxCount.get();

        // If it's not positive, show an error and then return.
        if(maxCount <= 0){
            Utilities.showAlert(this, "Please enter a positive number!");
            return;
        }
        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }
}