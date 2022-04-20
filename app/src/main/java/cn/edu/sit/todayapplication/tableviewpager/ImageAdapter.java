package cn.edu.sit.todayapplication.tableviewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

// ViewPager使用的adapter
public class ImageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    public ImageAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList=fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
