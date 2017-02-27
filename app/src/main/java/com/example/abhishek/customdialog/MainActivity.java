package com.example.abhishek.customdialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowDialog = (Button)findViewById(R.id.btnShowDialog);

        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
                View mview = getLayoutInflater().inflate(R.layout.dialog_login,null);
                final EditText mEmail = (EditText)mview.findViewById(R.id.etEmail);
                final EditText mPassword = (EditText)mview.findViewById(R.id.etPassword);
                Button mLogin = (Button)mview.findViewById(R.id.btnLogin);
                Button mCancel = (Button)mview.findViewById(R.id.btnCancel);



                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String uEmail = mEmail.getText().toString();
                        final String uPwd = mPassword.getText().toString();

                        if(!uEmail.isEmpty() && !uPwd.isEmpty()){
                            Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"Please fill require details",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                mbuilder.setView(mview);

                final AlertDialog dialog = mbuilder.create();
                dialog.show();

                mCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     dialog.dismiss();
                    }
                });

            }
        });
    }
}
