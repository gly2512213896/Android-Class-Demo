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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            // from参数：是从哪个页面来的view；
            // inflate参数：要加载哪个view的布局文件；它的父布局是什么（如view之于viewGroup）；是否立马加到父布局中，
            view = LayoutInflater.from(context).inflate(R.layout.listitem, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.item_iv = view.findViewById(R.id.item_iv);
            viewHolder.item_name = view.findViewById(R.id.item_name);
            viewHolder.item_content = view.findViewById(R.id.item_content);
            viewHolder.item_check = view.findViewById(R.id.item_check);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.item_check.setTag(i);
        viewHolder.item_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int index = (int) compoundButton.getTag();
                flowerList.get(index).setCheckStatus(isChecked);
            }
        });
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
