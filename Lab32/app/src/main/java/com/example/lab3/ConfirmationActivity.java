package com.example.lab3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // Retrieve the Team object from the intent
        Team team = (Team) getIntent().getSerializableExtra("teamInfo");

        // Find the UI components
        TextView teamName = (TextView) findViewById(R.id.teamNameTextViewId);
        TextView teamPostalCode = (TextView) findViewById(R.id.postalCodeTextViewId);
        ImageView logoImage = (ImageView) findViewById(R.id.teamLogoId);

        if (team != null) {
            // Populate the TextViews
            teamName.setText(team.getName());
            teamPostalCode.setText(team.getPostalCode());

            // Find the dynamic image resource ID and apply it
            int resID = getResources().getIdentifier(team.getDrawableName(), "drawable", getPackageName());
            logoImage.setImageResource(resID);
        }
    }
}
