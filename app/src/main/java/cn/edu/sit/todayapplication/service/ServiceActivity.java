package cn.edu.sit.todayapplication.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class ServiceActivity extends AppCompatActivity {
    private Button mBtnStart,mBtnStop;
    private Button mBtnBind,mBtnOperate,mBtnUnBind;
    private ServiceConnection conn;
    private MyService.MyBinder myBinder;
    private MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Log.i("ServiceActivity", "onCreate: ThreadId="+Thread.currentThread().getId());
        initView();
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder= (MyService.MyBinder) iBinder;
                myService= myBinder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        initClick();
    }

    private void initClick() {
        MyClickListener myClickListener=new MyClickListener();
        mBtnStart.setOnClickListener(myClickListener);
        mBtnStop.setOnClickListener(myClickListener);
        mBtnBind.setOnClickListener(myClickListener);
        mBtnOperate.setOnClickListener(myClickListener);
        mBtnUnBind.setOnClickListener(myClickListener);

    }

    private class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.btn_start:
                    intent=new Intent(ServiceActivity.this,MyService.class);
                    startService(intent);
                    if(!mBtnStop.isEnabled()){
                        mBtnStop.setEnabled(true);
                    }
                    break;
                case R.id.btn_stop:
                    intent=new Intent(ServiceActivity.this,MyService.class);
                    stopService(intent);
                    break;
                case R.id.btn_bind:
                    intent=new Intent(ServiceActivity.this,MyService.class);
                    bindService(intent,conn,BIND_AUTO_CREATE);
                    break;
                case R.id.btn_operate:
                    if(myService!=null){
                        Toast.makeText(ServiceActivity.this,myService.doSomeOperation("abc"),Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_unbind:
                    unbindService(conn);
                    break;
            }
        }
    }
    private void initView(){
        mBtnStart=findViewById(R.id.btn_start);
        mBtnStop=findViewById(R.id.btn_stop);
        mBtnBind=findViewById(R.id.btn_bind);
        mBtnOperate=findViewById(R.id.btn_operate);
        mBtnUnBind=findViewById(R.id.btn_unbind);
    }
}