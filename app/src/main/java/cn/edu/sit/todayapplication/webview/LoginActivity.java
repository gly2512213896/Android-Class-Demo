package cn.edu.sit.todayapplication.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mEtUser;
    private Button mBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtUser = findViewById(R.id.et_user);
        mBtnSubmit = findViewById(R.id.btn_submit);

        // 存在的问题：登陆之后无法拿到输入的z用户名
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = mEtUser.getText().toString();
                Intent data = new Intent();
                data.putExtra("user", temp);
                setResult(1, data);
                finish();
            }

        });
//        mEtUser.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.i("EditTextActivity", "onTextChanged: "+charSequence);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }
}