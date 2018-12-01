package com.ceco.yovo_38;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener {

    Button clear,addUser,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_actity);

        clear = (Button)findViewById(R.id.ClearBUT);
        clear.setOnClickListener(this);
        addUser = (Button) findViewById(R.id.AddUserBUT);
        addUser.setOnClickListener(this);
        back = (Button) findViewById(R.id.BackBUT);
        back.setOnClickListener(this);
    }

    final Database db = new Database(this);
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


    final TextView userName = (TextView) findViewById(R.id.usernameBOX);
    final TextView password = (TextView) findViewById(R.id.PasswordBOX);

    public void onClick(View v){

        switch(v.getId())
        {
            case R.id.ClearBUT:
            {
                userName.setText("");
                password.setText("");
                break;
            }
            case R.id.AddUserBUT:
            {
                db.addUser(new User(userName.getText().toString(),password.getText().toString()));

                ShowDialog("User is added! ");
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;
            }
            case R.id.BackBUT:
            {
                startActivity(new Intent(AddUserActivity.this, WorkActivity.class));
                break;
            }


        }
    }
    
    public void ShowDialog(String ss){

        // set title
        alertDialogBuilder.setTitle("Information:");
        // set dialog message
        alertDialogBuilder
                .setMessage(ss)
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();
                    }
                });

        // alertDialogBuilder.setMessage(ss);
    }
}
