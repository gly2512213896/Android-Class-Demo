package cn.edu.sit.todayapplication;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sit.todayapplication.fragment.DiscoverFragment;
import cn.edu.sit.todayapplication.fragment.MeFragment;
import cn.edu.sit.todayapplication.fragment.MessageFragment;
import cn.edu.sit.todayapplication.fragment.PhoneFragment;

public class FragmentActivity extends AppCompatActivity implements PhoneFragment.IPhoneCallBack{
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private PhoneFragment phoneFragment;
    private MessageFragment messageFragment;
    private DiscoverFragment discoverFragment;
    private MeFragment meFragment;
    private RadioGroup mRg;
    private List<Fragment> fragmentList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mRg=findViewById(R.id.fl_rg);

        fragmentManager = getSupportFragmentManager();
        messageFragment=new MessageFragment();
        fragmentList.add(messageFragment);
        hideOtherFragment(messageFragment,true);
         mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 switch (i){
                     case R.id.fl_rb_message:
                         hideOtherFragment(messageFragment,false);
                         break;
                     case R.id.fl_rb_phone:
                         if(phoneFragment==null){
                             phoneFragment=PhoneFragment.newInstance("Phone 12315");
                             fragmentList.add(phoneFragment);
                             hideOtherFragment(phoneFragment,true);
                         }else{
                             hideOtherFragment(phoneFragment,false);
                         }
                         break;
                     case R.id.fl_rb_discover:
                         if(discoverFragment==null){
                             discoverFragment=new DiscoverFragment();
                             fragmentList.add(discoverFragment);
                             hideOtherFragment(discoverFragment,true);
                         }else{
                             hideOtherFragment(discoverFragment,false);
                         }
                         break;
                     case R.id.fl_rb_me:
                         if(meFragment==null){
                             meFragment=new MeFragment();
                             fragmentList.add(meFragment);
                             hideOtherFragment(meFragment,true);
                         }else{
                             hideOtherFragment(meFragment,false);
                         }
                         break;
                 }
             }
         });
    }
    private void    hideOtherFragment(Fragment currentFragment,boolean b){
        fragmentTransaction =fragmentManager.beginTransaction();
        if(b){
            fragmentTransaction.add(R.id.fl_container,currentFragment);
        }

        for (Fragment tempFragment : fragmentList) {
             if(tempFragment.equals(currentFragment)){
                 fragmentTransaction.show(tempFragment);
             }else{
                 fragmentTransaction.hide(tempFragment);
             }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void setData(String str) {
        setTitle(str);
    }
}