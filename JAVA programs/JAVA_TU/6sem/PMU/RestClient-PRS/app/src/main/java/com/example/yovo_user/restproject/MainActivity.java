package com.example.yovo_user.restproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    // създава Dialog Object
    ProgressDialog prgDialog;
    TextView errorMsg;
    // Name Edit View Object
    EditText nameET;
    // Email Edit View Object
    EditText inputNumberToConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        TextView textView = (TextView)findViewById(R.id.inputNumberToConvert);
        if( bundle != null &&((String)bundle.get("fromHomeActivity")).equals("true")){
            textView.setText("");
        }

        // Find Email Edit View control by ID
        inputNumberToConvert = (EditText)findViewById(R.id.inputNumberToConvert);
        // Instantiate Progress Dialog object
                prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
                prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
                prgDialog.setCancelable(false);

    }

    public void convertNumberToWords(View view){
    // взима стойността на Email ET control
            String numberToConvert = inputNumberToConvert.getText().toString();
    // взима стойността на Password ET control
            if(Utility.isNotNull(numberToConvert)){
    // Когато въведеният Email е валиден
                if(Utility.validate(numberToConvert)){
                    invokeWS(numberToConvert);
                }
    // При невалиден Email
                else{
                        Toast.makeText(getApplicationContext(),
                          "Please enter valid number", Toast.LENGTH_LONG).show();
                }

        // При празно поле
        } else{
            Toast.makeText(getApplicationContext(),
                    "Please fill the form, don't leave any field blank",
            Toast.LENGTH_LONG).show();
        }
    }


    public void invokeWS(String numberToConvert){
        // Показване на Progress Dialog
        prgDialog.show();
        // Осъществяване на RESTful webservice извикване чрез използване на AsyncHttpClient обект
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://192.168.0.106:8080/NumberToEnglishWords/convertNumberToWords/convert/"+ numberToConvert,
                null,new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        // Скриване на Progress Dialog
            prgDialog.hide();
        // JSON обект
                Log.d("\n Server say: ",new   String(responseBody));
                String convertedNumberToWords = new   String(responseBody);

                    navigatetoHomeActivity(convertedNumberToWords);
        // в Else секцията визуализира  съобщение за грешка !
//            else {
//                    errorMsg.setText(obj.getString("error_msg"));
//                    Toast.makeText(getApplicationContext(),
//                            obj.getString("error_msg"), Toast.LENGTH_LONG).show();
//                }
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                Toast.makeText(getApplicationContext(), "Error Occured[Server's " +
//                                                                "JSON response might be invalid]!",
//                Toast.LENGTH_LONG).show();
//                e.printStackTrace();
//            }
        }

        @Override
        public void onFailure(int statusCode, Header[]
        headers, byte[] responseBody, Throwable error) {
            // скриване на Progress Dialog
            prgDialog.hide();
            // Когато Http отговаря с код '404'
            if (statusCode == 404) {
                Toast.makeText(getApplicationContext(), "Requested resource not found",
                            Toast.LENGTH_LONG).show();
            }
            // Когато Http отговаря с код '500'
            else if (statusCode == 500) {
                Toast.makeText(getApplicationContext(), "Something went wrong at server end",
                        Toast.LENGTH_LONG).show();}
                 // Когато Http отговаря с код различен от  404, 500
                else {
                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured!" +
                                    " [Most common Error: Device might not be connected to" +
                                    " Internet or remote server is not up and running]",
                    Toast.LENGTH_LONG).show();
                }
            }
        // Когато отговорът се върне от REST сървъра Http връща код '200'}
    });

    }

    /**
     * метод навигиращ от Register Activity към MainActivity (
         Login Activity )
     */
    public void navigatetoHomeActivity(String convertedNumberToWords){
        Intent homeIntent = new
                Intent(getApplicationContext(),HomeActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Create the bundle
        Bundle bundle = new Bundle();
        //Add your data to bundle
        bundle.putString("convertedNumberToWords", convertedNumberToWords);
        //Add the bundle to the intent
        homeIntent.putExtras(bundle);

        startActivity(homeIntent);
    }

}