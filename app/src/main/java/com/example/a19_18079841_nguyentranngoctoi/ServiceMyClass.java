package com.example.a19_18079841_nguyentranngoctoi;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ServiceMyClass extends Service {
    int a,  b;
    private final MyBinder myBinder =new MyBinder();

    public class MyBinder extends Binder {
        public ServiceMyClass getServiceMyClass(){
            return ServiceMyClass.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service","onbinder");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service","unbinder");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
        Log.e("Service","create");

    }
    public void setAB(int x, int y){
        a=x;
        b=y;
    }
    public void start(){
        Log.e("Service","start");

    }
    public  int add(){
        return  a+b;
    }
    public  int sub(){
        return  a-b;
    }
    public  float mul(){
        return  a*b;
    }
    public  float div(){
        return  a/b;
    }





    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service đã bị hủy!", Toast.LENGTH_SHORT).show();
        Log.e("Service","huy");
        a=-999;
        b=-999;
    }


}
