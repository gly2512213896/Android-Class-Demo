package cn.edu.sit.todayapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.sit.todayapplication.R;

public class MultiLayoutAdapter extends BaseAdapter {
    private static final int TYPE_LEFT=0;
    private static final int TYPE_RIGHT=1;
    private List<PersonChat> mData;
    private Context mContext;

    public MultiLayoutAdapter(List<PersonChat> data,Context context) {
        mData=data;
        mContext=context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 如果上下滚动view就删除了，再次显示又得重新加载，比较浪费资源
    // 为了避免这种情况，所以得把当前view的东西保存一下
    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        int type=getItemViewType(position);
        ViewHolder viewHolder=null;
        if(view==null){
            switch (type){
                case TYPE_LEFT:
                    view= LayoutInflater.from(mContext).inflate(R.layout.listitem_left,viewGroup,false);
                    break;
                case TYPE_RIGHT:
                    view=LayoutInflater.from(mContext).inflate(R.layout.listitem_right,viewGroup,false);
                    break;
            }
            // viewHolder先找到view的组件
            viewHolder=new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.item_iv);
            viewHolder.textView=view.findViewById(R.id.item_tv);
            // 再把viewHolder设为view的tag，下次要用view的时候就不必重新创建，直接找它的tag就行了(注：每个实例的tag是唯一的)
            // 实例会随着再现而新建，但是tag不会
            // 反复创建浪费性能，实际上只要拿到原来的view对象的属性值就行了
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(mData.get(position).getImageId());
        viewHolder.textView.setText(mData.get(position).getWords());
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(mData.get(position).getStatus()) return TYPE_RIGHT;
        else return TYPE_LEFT;
    }
}
