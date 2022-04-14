package cn.edu.sit.todayapplication.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sit.todayapplication.R;
import cn.edu.sit.todayapplication.listview.Flower;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<Flower> flowerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRv=findViewById(R.id.rv);
        initFlower();
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRv.setLayoutManager(linearLayoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        mRv.setLayoutManager(gridLayoutManager);
//        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        mRv.setLayoutManager(staggeredGridLayoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(staggeredGridLayoutManager);
        mRv.setAdapter(new RecyclerFlowerAdapter(flowerList,this));
    }
    private void initFlower() {
        flowerList=new ArrayList<>();
        flowerList.add(new Flower(R.drawable.flower1,"flower1","花语1"));
        flowerList.add(new Flower(R.drawable.flower2,"flower2","花语2"));
        flowerList.add(new Flower(R.drawable.flower3,"flower3","花语3"));
    }
}