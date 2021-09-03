package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItemUpd;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItemUpd = findViewById(R.id.etItemUpd);
        btnsave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItemUpd.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // Once the user finished editing and click the save button
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to store user input
                Intent intent = new Intent();
                // Pass the data after editing
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItemUpd.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // Set the result to be the as the user new intent input
                setResult(RESULT_OK, intent);

                // End this activity and go back
                finish();
            }
        });
    }
}