package cn.edu.sit.todayapplication.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWv;
    private TextView mTvTitle, mTvStart, mTvFinish, mTvProgress;

    private ActivityResultLauncher mLauncher;// 4.3.9.3和4.3.9.4小节有问题
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 启动器，接收了其他activity传回的参数之后执行后续操作
        mLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==1){
                    String tt=result.getData().getStringExtra("user");
                    mWv.loadUrl("javascript:showUserName('" + tt + "new')");
                }
            }
        });

        setContentView(R.layout.activity_web_view);
        mWv = findViewById(R.id.web_view);

        mTvTitle = findViewById(R.id.tv_title);
        mTvStart = findViewById(R.id.tv_start);
        mTvFinish = findViewById(R.id.tv_finish);
        mTvProgress = findViewById(R.id.tv_progress);

        // 不由系统浏览器接管，而让webview继续处理
        mWv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mTvStart.setText("开始加载");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mTvFinish.setText("加载完成");
            }
        });

        mWv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mTvTitle.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress < 100) {
                    mTvProgress.setText(newProgress + "%");
                } else {
                    mTvProgress.setText("100%");
                }
            }
        });


        WebSettings webSettings = mWv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

//        mWv.loadUrl("http://www.baidu.com");
        mWv.addJavascriptInterface(this, "android");
        mWv.loadUrl("file:///android_asset/test.html");
    }

    @JavascriptInterface
    public void login() {
        // 指定intent方式
        // 1. 构造方法指定
//        Intent intent = new Intent(this, LoginActivity.class);

        Intent intent=new Intent();

        // 2. 往构造方法中添加组件
        // 2.1 通过反射
//        intent.setComponent(new ComponentName(this,LoginActivity.class));
        // 2.2 通过上下文以及跳转类的全限定名字符串
//        intent.setComponent(new ComponentName(this,"cn.edu.sit.todayapplication.webview.LoginActivity"));
//        startActivityForResult(intent, 0);
        // 2.3 通过上下文类所在的全限定包名以及跳转类的
//        intent.setComponent(new ComponentName("cn.edu.sit.todayapplication.webview","cn.edu.sit.todayapplication.webview.LoginActivity"))

        // 3. 通过intent的api
        // 3.1 setClass方法(和构造方法很像）
//        intent.setClass(this,LoginActivity.class);
        // 3.2 setClassName方法
        // 3.2.1(和2.2很像）
//        intent.setClassName(this,"cn.edu.sit.todayapplication.webview.LoginActivity");
        // 3.3.2(和2.3很像）
//        intent.setClassName("cn.edu.sit.todayapplication.webview","cn.edu.sit.todayapplication.webview.LoginActivity");

//        intent.setAction("intent.login");
//        intent.addCategory("intent.category.login");
//        intent.addCategory("intent.category.e2");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("http://www.baidu.com"),"text/html");


        mLauncher.launch(intent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 0 && resultCode == 1) {
//            String temp = data.getStringExtra("user");
//            // mWv此时已经加载了一个html，加上一个javascript标签表示执行js代码，
//            mWv.loadUrl("javascript:showUserName('" + temp + "')");
//        }
//    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWv.canGoBack()) {
            mWv.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}


