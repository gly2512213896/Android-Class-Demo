package cn.edu.sit.todayapplication.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sit.todayapplication.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView lv1;
    private List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv1=findViewById(R.id.lv1);
//         // 1 用资源文件创建适配器
//        // 参数：上下文；默认加载的数组；数组中显示文字的默认格式
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.car, android.R.layout.simple_list_item_1);
//        lv1.setAdapter(adapter);

//        // 2 用构造器创建适配器
//        List<String> dataList =new ArrayList<>(Arrays.asList("大众","丰田","比亚迪","福特","哈弗"));
//        // 参数：上下文；设置单个item的view形式；显示的数组
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, dataList);
//        lv1.setAdapter(adapter);
//        // from参数：从哪个页面填充  inflate参数：要填充的布局文件；是否加入一个viewgroup中
//        lv1.addHeaderView(LayoutInflater.from(this).inflate(R.layout.viewhead,null));
//        lv1.addFooterView(LayoutInflater.from(this).inflate(R.layout.viewfoot,null));
//
//        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListViewActivity.this, i+"Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
        // 3 自定义item的view形式
        initFlower();
        FlowerAdapter flowerAdapter=new FlowerAdapter(flowerList,this);
        lv1.setAdapter(flowerAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                flowerAdapter.remove(i);
                Toast.makeText(ListViewActivity.this, i+"custom click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFlower() {
        flowerList=new ArrayList<>();
        flowerList.add(new Flower(R.drawable.flower1,"flower1","花语1"));
        flowerList.add(new Flower(R.drawable.flower2,"flower2","花语2"));
        flowerList.add(new Flower(R.drawable.flower3,"flower3","花语3"));
    }
}