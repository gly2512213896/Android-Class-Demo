package cn.edu.sit.todayapplication.toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import cn.edu.sit.todayapplication.R;

public class ToolbarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar=findViewById(R.id.toolbar);
        // java代码中的优先级较高，并且可以设置空标题，而xml文件不行
        toolbar.setTitle("一级标题");
        // 为当前界面设置工具栏
        this.setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 关闭当前activity，则下一个activity自动出栈
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.toobar_options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str="";
        switch(item.getItemId()){
            case R.id.toolbar_search:
                str="toolbar_search";
                break;
            case R.id.toolbar_menu_cut:
                str="toolbar_menu_cut";
                break;
            case R.id.toolbar_menu_copy:
                str="toolbar_menu_copy";
                break;
            default:return super.onOptionsItemSelected(item);
        }
        // 参数： 哪个界面，文本内容，显示时间
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return true;
    }
}