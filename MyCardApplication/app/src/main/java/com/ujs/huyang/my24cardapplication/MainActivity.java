package com.ujs.huyang.my24cardapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.lang.Thread;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    private Button play;
    private Button exit;
    private TextView scores;
    private ImageView v1, v2, v3, v4;
    private EditText input;
    //引入表达式解析类
    Calculator c = null;
    //定义得分变量
    private int count = 0;
    private Handler handler;
    private Resources resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new Calculator();

        exit = (Button)findViewById(R.id.exit);
        scores = (TextView)findViewById(R.id.count);
        scores.setText(Integer.toString(count));
        v1 = (ImageView)findViewById(R.id.imgv1);
        v2 = (ImageView)findViewById(R.id.imgv2);
        v3 = (ImageView)findViewById(R.id.imgv3);
        v4 = (ImageView)findViewById(R.id.imgv4);
        input = (EditText)findViewById(R.id.input);
        handler = new Handler();
        play = (Button)findViewById(R.id.play);
        resource = this.getResources();

    }

    public void start(View view){
       /* Socket s=null;
        try{
             s= new Socket("10.0.2.2",30000);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
            s.close();
            }catch (Exception ex){}
        }
        */

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Connection con = new Connection();
                Log.i("MainActivity","执行了");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        InputStream inputStream0 = resource.openRawResource(con.getPath(0));
                        Bitmap b1 = BitmapFactory.decodeStream(inputStream0);
                        v1.setImageBitmap(b1);
                        InputStream inputStream1 = resource.openRawResource(con.getPath(1));
                        Bitmap b2 = BitmapFactory.decodeStream(inputStream1);
                        v2.setImageBitmap(b2);
                        InputStream inputStream2 = resource.openRawResource(con.getPath(2));
                        Bitmap b3 = BitmapFactory.decodeStream(inputStream2);
                        v3.setImageBitmap(b3);
                        InputStream inputStream = resource.openRawResource(con.getPath(3));
                        Bitmap b4 = BitmapFactory.decodeStream(inputStream);
                        v4.setImageBitmap(b4);
                    }
                });
            }
        }).start();

    }

    public void exit(View view){
        this.finish();
    }

    public void send(View view){
        String expression = input.getText().toString();
        if (expression.equals("") || expression == null){
            Toast.makeText(getApplicationContext(),"输入为空，重新输入",Toast.LENGTH_SHORT).show();
        }
        else{
            String result = c.suffix_expression(expression);
            if (result.equals("24.0")){
                Toast.makeText(getApplicationContext(),"回答正确，加一分",Toast.LENGTH_SHORT).show();
                count ++;
                scores.setText(Integer.toString(count));
                input.setText("");
            }
            else{
                Toast.makeText(getApplicationContext(),"回答错误",Toast.LENGTH_SHORT).show();
                input.setText("");
            }
        }
    }
}
