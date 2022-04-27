package cn.edu.sit.todayapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import cn.edu.sit.todayapplication.broadcastreceiver.BroadcastReceiverActivity;
import cn.edu.sit.todayapplication.gridview.GridViewActivity;
import cn.edu.sit.todayapplication.listview.ListViewActivity;
import cn.edu.sit.todayapplication.menu.ContextMenuActivity;
import cn.edu.sit.todayapplication.menu.OptionsMenuActivity;
import cn.edu.sit.todayapplication.menu.PopupMenuActivity;
import cn.edu.sit.todayapplication.recyclerview.RecyclerViewActivity;
import cn.edu.sit.todayapplication.service.ServiceActivity;
import cn.edu.sit.todayapplication.tablayout.TabLayoutActivity;
import cn.edu.sit.todayapplication.toolbar.ToolbarActivity;
import cn.edu.sit.todayapplication.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private Button btnEditText;
    private Button btnFragment;
    private Button btnOptionsMenu;
    private Button btnContextMenu;
    private Button btnPopupMenu;
    private Button btnToolbarMenu;
    private Button btnListView;
    private Button btnGridView;
    private Button btnRecyclerView;
    private Button btnTabLayout;
    private Button btnWebView;
    private Button btnBroadcastReceiver;
    private Button btnService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        try {
            InputStream tmpImgIs=getAssets().open("tmp.png");
            Bitmap bm = BitmapFactory.decodeStream(tmpImgIs);
            ImageView iv=findViewById(R.id.tmp);
            iv.setImageBitmap(bm);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建一个内部监听类
        MyClickListener myClickListener=new MyClickListener();
        //通过findViewById初始化
        btnEditText=findViewById(R.id.btn_edittext);
        btnFragment=findViewById(R.id.btn_fragment);
        btnOptionsMenu=findViewById(R.id.btn_optionsmenu);
        btnContextMenu=findViewById(R.id.btn_contextmenu);
        btnPopupMenu=findViewById(R.id.btn_popupmenu);
        btnToolbarMenu=findViewById(R.id.btn_toolbar);
        btnListView=findViewById(R.id.btn_listview);
        btnGridView=findViewById(R.id.btn_gridview);
        btnRecyclerView=findViewById(R.id.btn_recyclerview);
        btnTabLayout=findViewById(R.id.btn_tablayout);
        btnWebView=findViewById(R.id.btn_webview);
        btnBroadcastReceiver=findViewById(R.id.btn_broadcastreceiver);
        btnService=findViewById(R.id.btn_service);
        // 设置监听器
        btnEditText.setOnClickListener(myClickListener);
        btnFragment.setOnClickListener(myClickListener);
        btnOptionsMenu.setOnClickListener(myClickListener);
        btnContextMenu.setOnClickListener(myClickListener);
        btnPopupMenu.setOnClickListener(myClickListener);
        btnToolbarMenu.setOnClickListener(myClickListener);
        btnListView.setOnClickListener(myClickListener);
        btnGridView.setOnClickListener(myClickListener);
        btnRecyclerView.setOnClickListener(myClickListener);
        btnTabLayout.setOnClickListener(myClickListener);
        btnWebView.setOnClickListener(myClickListener);
        btnBroadcastReceiver.setOnClickListener(myClickListener);
        btnService.setOnClickListener(myClickListener);
        }
        class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch(view.getId()){
                case R.id.btn_edittext:
                    intent=new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent=new Intent(MainActivity.this,FragmentActivity.class);
                    break;
                case R.id.btn_optionsmenu:
                    intent=new Intent(MainActivity.this,OptionsMenuActivity.class);
                    break;
                case R.id.btn_contextmenu:
                    intent=new Intent(MainActivity.this, ContextMenuActivity.class);
                    break;
                case R.id.btn_popupmenu:
                    intent=new Intent(MainActivity.this, PopupMenuActivity.class);
                    break;
                case R.id.btn_toolbar:
                    intent=new Intent(MainActivity.this, ToolbarActivity.class);
                    break;
                case R.id.btn_listview:
                    intent=new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent=new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent=new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_tablayout:
                    intent=new Intent(MainActivity.this, TabLayoutActivity.class);
                    break;
                case R.id.btn_webview:
                    intent=new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_broadcastreceiver:
                    intent=new Intent(MainActivity.this, BroadcastReceiverActivity.class);
                    break;
                case R.id.btn_service:
                    intent=new Intent(MainActivity.this, ServiceActivity.class);
                    break;
                default:throw new IllegalArgumentException("null pointer");
            }
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }
}