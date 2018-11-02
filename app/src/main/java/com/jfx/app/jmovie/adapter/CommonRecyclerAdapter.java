package com.jfx.app.jmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 通用适配器
 */
public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<T> mDatas;
    protected int mLayoutId;

    /**
     * 构造方法
     * @param context activity
     * @param datas   装填的数据
     * @param layoutId 子项item layout
     */
    public CommonRecyclerAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        this.mDatas = datas;
        this.mLayoutId = layoutId;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //拿到传入布局
        View view = mInflater.inflate(mLayoutId,viewGroup,false);
        //Hold住布局View
        CommonViewHolder viewHolder = new CommonViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder viewHolder, int position) {
        //将数据传回具体实现进行处理
        handleView(viewHolder,mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 子类Adapter具体实现从holder拿TextView等装填数据T
     * @param viewHolder
     * @param item
     */
    public abstract void handleView(CommonViewHolder viewHolder,T item);
}
