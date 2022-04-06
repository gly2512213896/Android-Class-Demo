package cn.edu.sit.todayapplication.gridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sit.todayapplication.R;
import cn.edu.sit.todayapplication.listview.Flower;

public class GridViewActivity extends AppCompatActivity {

    private GridView mGv;
    private List<Flower> flowerList;
    private List<String> imageNetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mGv=findViewById(R.id.gv);
//        initFlower();
//        mGv.setAdapter(new GridFlowerAdapter(flowerList,this));
        initImage();
        mGv.setAdapter(new GridFlowerAdapter(imageNetList,this));
    }

    private void initImage() {
        imageNetList=new ArrayList<>();
        imageNetList.add("https://cn.bing.com/images/search?view=detailV2&ccid=DoWQt9ma&id=DBC1CF514FE9CC841C59F279A39294BCE3F4010D&thid=OIP.DoWQt9maZl_3IMhKY1qAWAHaEK&mediaurl=https%3a%2f%2ftse1-mm.cn.bing.net%2fth%2fid%2fR-C.0e8590b7d99a665ff720c84a635a8058%3frik%3dDQH047yUkqN58g%26riu%3dhttp%253a%252f%252fwww.mobanjing.com%252fdown%252fjpg%252fc95a9b4d190dd6d3d9c0cee09f861bae.jpg%26ehk%3d6HmWlzfthLxzVdGSpppCu6g0gHjiqh7GFrMooSFUAQc%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=1080&expw=1920&q=%e6%a0%91%e5%8f%b6%e5%9b%be%e7%89%87&simid=608030806622369006&FORM=IRPRST&ck=C38CD28CC00100B5839673C210627B0B&selectedIndex=0");
        imageNetList.add("https://cn.bing.com/images/search?view=detailV2&ccid=rOidtFVo&id=65B4DF362D000EF223B62BFF52BC846A2D0B7C0F&thid=OIP.rOidtFVot62jZ7nu_CtX6wHaHY&mediaurl=https%3a%2f%2ftse1-mm.cn.bing.net%2fth%2fid%2fR-C.ace89db45568b7ada367b9eefc2b57eb%3frik%3dD3wLLWqEvFL%252fKw%26riu%3dhttp%253a%252f%252fpic42.photophoto.cn%252f20170106%252f0017029560112000_b.jpg%26ehk%3dyMTNrTVV9fwZoUThXBVseH83%252bkOVFkbyyh4YiFHD10c%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=987&expw=991&q=%e6%a0%91%e5%8f%b6%e5%9b%be%e7%89%87&simid=608004018915116870&FORM=IRPRST&ck=F8067D8DBC4097B5609C95FD937B0902&selectedIndex=1");
        imageNetList.add("https://cn.bing.com/images/search?view=detailV2&ccid=GYAGZxsH&id=EA844FE65450BB95B1147E28B509AB6345EDB891&thid=OIP.GYAGZxsHNt_ifpGlrsx7CgHaEo&mediaurl=https%3a%2f%2ftse1-mm.cn.bing.net%2fth%2fid%2fR-C.198006671b0736dfe27e91a5aecc7b0a%3frik%3dkbjtRWOrCbUofg%26riu%3dhttp%253a%252f%252fdl.ppt123.net%252fpptbj%252f201512%252f2015121507150652.jpg%26ehk%3dO0OsuevbJJTTS9SrheBmW5vrYdexphbjDkP5zhuhB0s%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=1200&expw=1920&q=%e6%a0%91%e5%8f%b6%e5%9b%be%e7%89%87&simid=608014820756514292&FORM=IRPRST&ck=20A4DD39AED60A3F04118FA8C69A3519&selectedIndex=4");
        imageNetList.add("https://cn.bing.com/images/search?view=detailV2&ccid=83IRcOPG&id=245078F1F68C4A76EDC6BF22D2EB300D87C68B3A&thid=OIP.83IRcOPGDK2s6N9uhbb35gHaFj&mediaurl=https%3a%2f%2ftse1-mm.cn.bing.net%2fth%2fid%2fR-C.f3721170e3c60cadace8df6e85b6f7e6%3frik%3dOovGhw0w69Iivw%26riu%3dhttp%253a%252f%252fwww.kuaipng.com%252fUploads%252fpic%252fw%252f2019%252f07-08%252f68341%252fwater_68341_698_523.73_.png%26ehk%3daHr7vAzcSsWhLH%252b550G4bmgw123DtV6l5yFvM5fmpFE%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=523&expw=698&q=%e6%a0%91%e5%8f%b6%e5%9b%be%e7%89%87&simid=608040590558379053&FORM=IRPRST&ck=2C1BEFEF8350A94C1C6FEDF023CD1658&selectedIndex=7");
    }

    private void initFlower() {
        flowerList=new ArrayList<>();
        flowerList.add(new Flower(R.drawable.flower1,"flower1","花语1"));
        flowerList.add(new Flower(R.drawable.flower2,"flower2","花语2"));
        flowerList.add(new Flower(R.drawable.flower3,"flower3","花语3"));
    }
}