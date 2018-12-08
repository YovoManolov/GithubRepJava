package com.example.yovo_user.restproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private ProgressDialog prgDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the bundle
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        TextView textView = (TextView)findViewById(R.id.convertedNumberToWords);
        textView.setText((String)bundle.get("convertedNumberToWords"));
        textView.setSingleLine(false);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }


    public void navigateToMainActivity(View view){
        Intent mainIntent = new
                Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainIntent);

        //Create the bundle
        Bundle bundle = new Bundle();
        //Add your data to bundle
        bundle.putString("fromHomeActivity", "true");
        //Add the bundle to the intent
        mainIntent.putExtras(bundle);

        // Instantiate Progress Dialog object
        prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);
    }
}
