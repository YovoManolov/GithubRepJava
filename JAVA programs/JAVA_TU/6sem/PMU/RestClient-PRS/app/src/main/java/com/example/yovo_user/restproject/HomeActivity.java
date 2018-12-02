package com.example.yovo_user.restproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

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


    public void navigateToMainActivity(String convertedNumberToWords){
        Intent mainIntent = new
                Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainIntent);
    }
}
