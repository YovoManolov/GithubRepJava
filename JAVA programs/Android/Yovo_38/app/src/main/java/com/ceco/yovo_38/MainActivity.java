package com.ceco.yovo_38;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    User Rec1 = new User("admin", "1234");

    final Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView userName = (TextView) findViewById(R.id.usernameBOX);
        final TextView password = (TextView) findViewById(R.id.PasswordBOX);
        final Button login = (Button) findViewById(R.id.LoginBUT);
        // ImageView img = (ImageView) findViewById(R.id.imageView);
        //  img.setImageResource(R.mipmap.ic_launcher);

        alertDialogBuilder = new AlertDialog.Builder(this);
        db.addUser(Rec1);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> users = db.getAllUsers();
                boolean log = true;

                for (User us : users) {

                    if (userName.getText().toString().equals(us.getUserName())
                            && password.getText().toString().equals(us.getPassword())) {
                        log = false;
                        open("Login Successful !", log);
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;

                    }
                }
            }

        });

    }

    public void open(String ss, final boolean log) {
        alertDialogBuilder.setMessage(ss);
        alertDialogBuilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                if (log == false) startActivity(
                        new Intent(MainActivity.this, WorkActivity.class));
            }
        });

    } ;

}
