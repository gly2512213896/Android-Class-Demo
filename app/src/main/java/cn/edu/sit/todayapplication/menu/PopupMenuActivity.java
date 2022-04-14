package cn.edu.sit.todayapplication.menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.sit.todayapplication.R;

public class PopupMenuActivity extends AppCompatActivity {
    private Button btnPopupMenu0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        btnPopupMenu0=findViewById(R.id.btn_popupmenu);
        btnPopupMenu0.setOnClickListener(new View.OnClickListener() {
            // 点击事件进行菜单的弹
            @Override
            public void onClick(View view) {
                // 在哪个页面的哪个view上新建一个popupMenu
                PopupMenu popupMenu=new PopupMenu(PopupMenuActivity.this,view);
                // 为popMenu填充xml文件
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String str="";
                        switch(menuItem.getItemId()){
                            case R.id.popup_file_open:
                                str="popup_file";
                                break;
                            case R.id.popup_search:
                                str="popup_search";
                                break;
                            case R.id.popup_save:
                                str="save";
                                break;
                            default:return false;
                        }
                        Toast.makeText(PopupMenuActivity.this, str, Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }
}