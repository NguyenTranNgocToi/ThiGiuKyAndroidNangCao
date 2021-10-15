package com.example.a19_18079841_nguyentranngoctoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.Image;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView icon1,icon2;

    private  ServiceMyClass mServiceMyClass;
    private boolean isServiceConnected=false;
    EditText eda,edb, edkq;
    Button btncong, btntru, btnnhan, btnchia;





    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceMyClass.MyBinder myBinder = (ServiceMyClass.MyBinder) service;
            mServiceMyClass = myBinder.getServiceMyClass();
            isServiceConnected =true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnected =false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        start();
        setContentView(R.layout.activity_main);
        icon1 =findViewById(R.id.imageView);
        icon2 =findViewById(R.id.imageView2);


        btncong=findViewById(R.id.buttonCong);
        btntru=findViewById(R.id.buttonTru);
        btnnhan=findViewById(R.id.buttonNhan);
        btnchia=findViewById(R.id.buttonChia);

        eda = findViewById(R.id.edA);
        edb = findViewById(R.id.edB);
        edkq = findViewById(R.id.edKQ);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_icon);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_icon2);
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon1.startAnimation(animation);
            }
        });
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon2.startAnimation(animation2);
            }
        });


        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceConnected){
                    int x = Integer.parseInt(String.valueOf(eda.getText()));
                    int y = Integer.parseInt(String.valueOf(eda.getText()));

                    mServiceMyClass.setAB(x, y);
                    int kq = mServiceMyClass.add();
                    edkq.setText(kq+"");
                }
            }
        });


        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceConnected){
                    int x = Integer.parseInt(String.valueOf(eda.getText()));
                    int y = Integer.parseInt(String.valueOf(eda.getText()));
                    mServiceMyClass.setAB(x, y);
                    int kq = mServiceMyClass.sub();
                    edkq.setText(kq+"");
                }
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceConnected){
                    int x = Integer.parseInt(String.valueOf(eda.getText()));
                    int y = Integer.parseInt(String.valueOf(eda.getText()));
                    mServiceMyClass.setAB(x, y);
                    float kq = mServiceMyClass.mul();
                    edkq.setText(kq+"");
                }
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceConnected){
                    int x = Integer.parseInt(String.valueOf(eda.getText()));
                    int y = Integer.parseInt(String.valueOf(eda.getText()));
                    mServiceMyClass.setAB(x, y);
                    float kq = mServiceMyClass.div();
                    edkq.setText(kq+"");
                }
            }
        });

    }

    public void start(){
        Intent intent = new Intent(this, ServiceMyClass.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

    }
    public void stop(){
        if(isServiceConnected){
            unbindService(mServiceConnection);
            isServiceConnected =false;
        }

    }
}