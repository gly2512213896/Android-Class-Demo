package cn.edu.sit.todayapplication.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sit.todayapplication.R;
import cn.edu.sit.todayapplication.tableviewpager.IconRelation;
import cn.edu.sit.todayapplication.tableviewpager.ImageStateAdapter;
import cn.edu.sit.todayapplication.tableviewpager.Message2Fragment;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private List<IconRelation> iconRelationList;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mTabLayout = findViewById(R.id.tab_layout);
//        viewPager=findViewById(R.id.view_pager);
        viewPager2=findViewById(R.id.view_pager2);

//        mTabLayout.addTab(mTabLayout.newTab().setText("111"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("222"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("333"));
        initIcon();
        initFragment();
//        viewPager.setAdapter(new ImageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragmentList));
//        mTabLayout.setupWithViewPager(viewPager);

        viewPager2.setAdapter(new ImageStateAdapter(this,fragmentList));
        new TabLayoutMediator(mTabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setCustomView(getTabView(iconRelationList,position));
            }
        }).attach();

//        for (int i = 0; i < iconRelationList.size(); i++) {
////            mTabLayout.addTab(mTabLayout.newTab());
//            mTabLayout.getTabAt(i).setCustomView(getTabView(iconRelationList, i));
//        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();

                ImageView imageView = view.findViewById(R.id.tab_iv);
                TextView textView = view.findViewById(R.id.tab_tv);
                imageView.setSelected(true);

                textView.setTextAppearance(R.style.TabSelectedStyle);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();

                ImageView imageView = view.findViewById(R.id.tab_iv);
                TextView textView = view.findViewById(R.id.tab_tv);
                imageView.setSelected(false);

                textView.setTextAppearance(R.style.TabUnSelectedStyle);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.getTabAt(2).select();
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();

        // 此处是第二次使用了message fragment, 所以加了个2，老师的没有加
        fragmentList.add(Message2Fragment.newInstance(R.drawable.jerry));
        fragmentList.add(Message2Fragment.newInstance(R.drawable.kenan));
        fragmentList.add(Message2Fragment.newInstance(R.drawable.mickey));
        fragmentList.add(Message2Fragment.newInstance(R.drawable.snow));
    }

    private void initIcon() {

        iconRelationList = new ArrayList<>();
        iconRelationList.add(new IconRelation(R.drawable.ic_message_sel, "消息"));
        iconRelationList.add(new IconRelation(R.drawable.ic_phone_sel, "通讯"));
        iconRelationList.add(new IconRelation(R.drawable.ic_discover_sel, "发现"));
        iconRelationList.add(new IconRelation(R.drawable.ic_me_sel, "我的"));
    }

    private View getTabView(List<IconRelation> data, int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);

        ImageView imageView = view.findViewById(R.id.tab_iv);
        TextView textView = view.findViewById(R.id.tab_tv);

        imageView.setImageResource(data.get(position).getImageId());
        textView.setText(data.get(position).getName());

        return view;
    }
}