package cn.edu.sit.todayapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.sit.todayapplication.R;
import cn.edu.sit.todayapplication.listview.Flower;

public class RecyclerFlowerAdapter extends RecyclerView.Adapter<RecyclerFlowerAdapter.ViewHolder> {
    private List<Flower> mData;
    private Context mContext;

    public RecyclerFlowerAdapter(List<Flower> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.rv_iv);
            textView=itemView.findViewById(R.id.rv_tv);
        }
    }
    @NonNull
    @Override
    public RecyclerFlowerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclerlinearitem,parent,false);
//        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclersvitem,parent,false);
        View view= LayoutInflater.from(mContext).inflate(R.layout.recyclershitem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerFlowerAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(mData.get(position).getImageId());
        holder.textView.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
