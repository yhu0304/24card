package com.ujs.huyang.my24cardapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username = null;
    private EditText password = null;
    private TextView attempts;
    private Button login;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textview4);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
    }

    public void login(View view){
        if (username.getText().toString().equals("root") && password.getText().toString().equals("root")){
            Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        else {
            Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter --;
            attempts.setText(Integer.toString(counter));
            password.setText("");
            if (counter == 0)
                login.setEnabled(false);
        }
    }

}
