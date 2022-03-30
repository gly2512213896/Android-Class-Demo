package cn.edu.sit.todayapplication.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView tvContextMenu1,tvContextMenu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        tvContextMenu1=findViewById(R.id.tv_context_menu1);
        tvContextMenu2=findViewById(R.id.tv_context_menu2);
        registerForContextMenu(tvContextMenu1);
        registerForContextMenu(tvContextMenu2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 为tv设置菜单
        // 如果为tv1，则用java代码设置菜单内容及子菜单
        if(v.equals(tvContextMenu1)){
            // 一级菜单的图标显示不出来
            menu.add("context java 1");
            SubMenu subMenu = menu.addSubMenu("context java 2");
            subMenu.add("context java 21");
        }else{
            // 如果为tv2，则用自定义的xml布局文件设置菜单内容及子菜单
            // 得出结论：Inflater类的Inflate方法就是用来给某一组件设置自定义布局文件的
            this.getMenuInflater().inflate(R.menu.context_menu,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String str="";
        switch (item.getItemId()){
            case R.id.context_menu_cut:
                str="context_menu_cut";
                break;
            case R.id.context_menu_paste:
                str="context_menu";
                break;
            default:return super.onContextItemSelected(item);
        }
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        return true;
    }
}