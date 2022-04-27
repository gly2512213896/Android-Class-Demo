package cn.edu.sit.todayapplication.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import cn.edu.sit.todayapplication.R;

public class BroadcastReceiverActivity extends AppCompatActivity {
    private ToggleButton mTbBroad, mTbNormal, mTbLocal, mTbOrder;
    private TextView mTvBroad;
    private Button mBtnStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        mTbBroad = findViewById(R.id.tb_broad);
        mTvBroad = findViewById(R.id.tv_broad);
        mBtnStatic = findViewById(R.id.btn_static);
        mTbNormal = findViewById(R.id.tb_normal);
        mTbLocal = findViewById(R.id.tb_local);
        mTbOrder = findViewById(R.id.tb_order);

        MyReceiver myReceiver = new MyReceiver();
        mTbBroad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //注册广播接收器
                    IntentFilter filter = new IntentFilter();
                    filter.addAction(Intent.ACTION_BATTERY_CHANGED);
                    registerReceiver(myReceiver, filter);
                } else {
                    //销毁广播接收器
                    mTvBroad.setText("Hello Broad");
                    unregisterReceiver(myReceiver);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBtnStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(BroadcastReceiverActivity.this, StaticReceiver.class);
                sendBroadcast(intent);
            }
        });

        NormalReceiver normalReceiver = new NormalReceiver();
        mTbNormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    IntentFilter filter = new IntentFilter();
                    filter.addAction("intent.normal");

                    registerReceiver(normalReceiver, filter);
                    Intent intent = new Intent();

                    intent.setAction("intent.normal");
                    sendBroadcast(intent);
                } else {
                    mTvBroad.setText("Hello Broad");
                    unregisterReceiver(normalReceiver);
                }
            }
        });

        LocalReceiver localReceiver = new LocalReceiver();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mTbLocal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    IntentFilter filter = new IntentFilter("intent.local");
                    localBroadcastManager.registerReceiver(localReceiver, filter);
                    Intent intent = new Intent("intent.local");
                    localBroadcastManager.sendBroadcast(intent);
                } else {
                    mTvBroad.setText("Hello Broad");
                    localBroadcastManager.unregisterReceiver(localReceiver);
                }
            }
        });

        Order1Receiver order1Receiver=new Order1Receiver();
        Order2Receiver order2Receiver=new Order2Receiver();
        mTbOrder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    IntentFilter filter1=new IntentFilter("intent.order");
                    filter1.setPriority(99);
                    registerReceiver(order1Receiver,filter1);

                    IntentFilter filter2=new IntentFilter("intent.order");
                    // 越大优先级越高
                    filter2.setPriority(101);
                    registerReceiver(order2Receiver,filter2);

                    Intent intent=new Intent("intent.order");
                    sendOrderedBroadcast(intent,null);
                }else{
                    mTvBroad.setText("Hello Broad");
                    unregisterReceiver(order1Receiver);
                    unregisterReceiver(order2Receiver);
                }
            }
        });
    }

    //定义广播接收器
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                //在BatteryManager中定义了level和scale
                int level = intent.getExtras().getInt("level");
                int scale = intent.getExtras().getInt("scale");
                mTvBroad.setText("电量为:" + level * 100 / scale + "%");
            }
        }
    }

    //定义normal接收器
    public class NormalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("intent.normal")) {
                mTvBroad.setText("Normal Broad");
            }
        }
    }

    //本地广播
    public class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("intent.local")) {
                mTvBroad.setText("Local Broad");
            }
        }
    }

    //有序广播
    public class Order1Receiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("intent.order")){
                mTvBroad.setText("Order1 Broad"+getResultData());
            }
        }
    }
    public class Order2Receiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("intent.order")){
                mTvBroad.setText("Order2 Broad");
                setResultData("From Order2");
                abortBroadcast();
            }
        }
    }
}