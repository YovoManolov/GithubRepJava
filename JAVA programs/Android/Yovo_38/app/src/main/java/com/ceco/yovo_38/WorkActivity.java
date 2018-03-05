package com.ceco.yovo_38;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        final TextView textusers = (TextView) findViewById(R.id.ShowView);
        Button LogOut = (Button) findViewById(R.id.LogOutBUT);
        Button showallusers = (Button) findViewById(R.id.ShowAllUsersBUT);
        Button adduser = (Button) findViewById(R.id.AddUserBUT);
        Button delete = (Button) findViewById(R.id.DeleteUserBUT);

        final Database db = new Database(this);
        final List<User> users = db.getAllUsers();


        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkActivity.this,
                        AddUserActivity.class));
            }
        });

        showallusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textusers.setText("");
                for (User us : users) {
                    String log = textusers.getText() +"\n" + "Id: " +
                            us.getId() + " ,Name: " + us.getUserName()
                            + " ,Pass: " +us.getPassword() ;
                    textusers.setText(log);
                }
                Toast.makeText(WorkActivity.this,"All users are loaded!",Toast.LENGTH_LONG).show();
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkActivity.this,
                        MainActivity.class));
            }
        });


    }
}
