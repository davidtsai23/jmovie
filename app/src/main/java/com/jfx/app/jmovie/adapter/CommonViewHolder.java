package com.jfx.app.jmovie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class CommonViewHolder extends RecyclerView.ViewHolder {

    //相当于View的数组将holder中的view都放进去减少findViewById查询
    private SparseArray<View> mViews;

    public CommonViewHolder(@NonNull View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    /**
     * 根据Id从数组map获取view
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            //Map中没有则直接查询
            view = itemView.findViewById(viewId);
            //放入map
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 文本View设值
     * @param viewId
     * @param text
     * @return
     */
    public CommonViewHolder setTextView(int viewId,CharSequence text){
        TextView textView = (TextView) mViews.get(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * 设置View的Visibility
     */
    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    /**
     * 设置ImageView的资源
     */
    public CommonViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    /***************
     * 设置条目点击和长按事件
     *********************/
    public AdapterView.OnItemClickListener mItemClickListener;
    public View.OnLongClickListener mLongClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener longClickListener) {
        this.mLongClickListener = longClickListener;
    }

}
