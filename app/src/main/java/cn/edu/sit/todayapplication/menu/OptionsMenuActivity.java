package cn.edu.sit.todayapplication.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    // 初始化选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 默认groupId，itemId，order都为0
        menu.add("options1");
        //参数：groupId，分组方便一起删除；itemId，选项的id；order选项的顺序；
        menu.add(0,1,1,"options2");
        menu.add(0,2,2,"options3");
        menu.add(1,2,4,"options4");
        menu.add(1,1,3,"options5");
        // 添加子菜单
        SubMenu sm1 = menu.addSubMenu("sub_options");
        // 直接添加一个子选项
        sm1.add("sub1");
        // 添加具备子菜单的子选项
        SubMenu sm1_1 = sm1.addSubMenu("sub1-1");
        sm1_1.add("sub1-1-1");
        return super.onCreateOptionsMenu(menu);
    }

    // 修改菜单选项
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        // 为当前菜单设置xml文件
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onPrepareOptionsMenu(menu);
    }
    // 选项的监听事件

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str="";
        switch (item.getItemId()){
            case R.id.menu_open:
                str="menu_open";
                break;
            case R.id.menu_close:
                str="menu_close";
                break;
        }
        // 参数：在哪个界面；制作哪些文字；显示时长
        Toast.makeText(this,str+"Click",Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}