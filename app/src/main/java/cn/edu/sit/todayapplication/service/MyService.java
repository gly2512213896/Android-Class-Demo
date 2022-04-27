package cn.edu.sit.todayapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyBinder myBinder=new MyBinder();
    public MyService() {
    }
    public class MyBinder extends Binder {
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService", "onBind: Bind");
       return myBinder;
    }

    @Override
    public void onCreate() {
        Log.i("MyService", "onCreate: "+Thread.currentThread().getId());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService", "onStartCommand: startId="+startId+",ThreadId="+Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("MyService", "onDestroy: "+Thread.currentThread().getId());
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService", "onUnbind: ThreadId="+Thread.currentThread().getId());
        return super.onUnbind(intent);
    }

    public String doSomeOperation(String str){
        Log.i("MyService", "doSomeOperation: bind");
        return str+"value";
    }
}