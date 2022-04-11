package cn.edu.sit.todayapplication.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.sit.todayapplication.R;

public class FlowerAdapter extends BaseAdapter {
    private List<Flower> flowerList;
    private Context context;

    public FlowerAdapter(List<Flower> flowerList, Context context) {
        this.flowerList = flowerList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return flowerList.size();
    }

    @Override
    public Object getItem(int position) {
        return flowerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    // 每次把item填充至当前手机屏幕内时就要调用
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 优化空间：
        // 1. 每次view重新出现在屏幕中的时候都要重新加载，改为为null时才加载
        // 2. 每次把item放到当前view中的时候都要重新绑定子view，改为用viewHolder把子view保存起来，因为虽然item不同，但是每个item的子view是一样的，
        //      也就是说item的view需要每次加载，但是item的子view可以不用每次加载
        ViewHolder viewHolder;
        if (view == null) {
            // from参数：是从哪个页面来的view；
            // inflate参数：要加载哪个view的布局文件；它的父布局是什么（如view之于viewGroup）；是否立马加到父布局中，
            view = LayoutInflater.from(context).inflate(R.layout.listitem, viewGroup, false);
            viewHolder = new ViewHolder();
            // viewHolder拿到的就是当前view的子view，其他view也有各自的子view
            viewHolder.item_iv = view.findViewById(R.id.item_iv);
            viewHolder.item_name = view.findViewById(R.id.item_name);
            viewHolder.item_content = view.findViewById(R.id.item_content);
            viewHolder.item_check = view.findViewById(R.id.item_check);
            // tag可以看成view的额外空间，里面有啥view就是啥
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.item_check.setTag(i);
        // 设置选中的监听事件
        viewHolder.item_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int index = (int) compoundButton.getTag();
                flowerList.get(index).setCheckStatus(isChecked);
            }
        });
        // 把子view的属性设置一下，下次加载还是这些属性
        viewHolder.item_check.setChecked(flowerList.get(i).getCheckStatus());
        Log.i("FlowerAdapter", "getView: " + i);
        viewHolder.item_iv.setImageResource(flowerList.get(i).getImageId());
        viewHolder.item_name.setText(flowerList.get(i).getName());
        viewHolder.item_content.setText(flowerList.get(i).getContent());
        return view;
    }

    static class ViewHolder {
        ImageView item_iv;
        TextView item_name;
        TextView item_content;
        CheckBox item_check;
    }

    public void remove(int position){
        if(flowerList!=null){
            flowerList.remove(position);
        }
        notifyDataSetChanged();
    }
}
