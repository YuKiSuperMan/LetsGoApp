package com.njz.letsgoapp.adapter.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.order.SimpleImageAdapter;
import com.njz.letsgoapp.bean.home.CommentData;
import com.njz.letsgoapp.bean.home.EvaluateModel;
import com.njz.letsgoapp.bean.home.GuideDetailModel;
import com.njz.letsgoapp.util.glide.GlideUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/8/17
 * Function:
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    Context mContext;
    List<EvaluateModel> datas;

    /**
     * 标记展开的item
     */
    private int opened = -1;

    public CommentAdapter(Context mContext, List<EvaluateModel> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder == null) return;
        final int pos = holder.getAdapterPosition();
        final EvaluateModel data = datas.get(pos);
        if (data == null) return;

        GlideUtil.LoadCircleImage(mContext, data.getImg(), holder.commont_head);

        holder.commont_name.setText(data.getName());
        holder.commont_time.setText(data.getUserDate());
        holder.commont_score.setText(data.getScore());
        holder.tv_comment_content.setText(data.getUserContent());
        holder.tv_order.setText("天门山一日游\n包车旅行\n导游陪游景点翻游\n天门山假日酒店");
        holder.reply_time.setText("回复回复回复回复回复回复回复回复回复回复回复回复回复回复回复回复");
        holder.reply_content.setText("2018-09-14");

        holder.rl_reply.setVisibility(View.VISIBLE);
        holder.tv_click.setVisibility(View.VISIBLE);

        holder.mRecyclerView.setNestedScrollingEnabled(false);//滑动取消
        holder.mRecyclerView.setLayoutManager(new GridLayoutManager(
                holder.mRecyclerView.getContext(), 4));

        SimpleImageAdapter enterAdapter = new SimpleImageAdapter(mContext, data.getImageUrls());
        holder.mRecyclerView.setAdapter(enterAdapter);

        holder.bindView(pos);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setData(List<EvaluateModel> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public List<EvaluateModel> getDatas(){
        return this.datas;
    }

    public void addData(List<EvaluateModel> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView commont_head;
        TextView commont_name, commont_time, commont_score, tv_comment_content, tv_order, reply_time, reply_content;
        RelativeLayout rl_reply;
        RecyclerView mRecyclerView;

        TextView tv_click;

        ViewHolder(View itemView) {
            super(itemView);
            commont_head = itemView.findViewById(R.id.comment_head);
            commont_name = itemView.findViewById(R.id.commont_name);
            commont_time = itemView.findViewById(R.id.commont_time);
            commont_score = itemView.findViewById(R.id.commont_score);
            tv_comment_content = itemView.findViewById(R.id.tv_comment_content);
            tv_order = itemView.findViewById(R.id.tv_order);
            reply_time = itemView.findViewById(R.id.reply_time);
            reply_content = itemView.findViewById(R.id.reply_content);
            rl_reply = itemView.findViewById(R.id.rl_reply);
            mRecyclerView = itemView.findViewById(R.id.recycler_view);
            tv_click = itemView.findViewById(R.id.tv_click);
            tv_click.setOnClickListener(this);

        }

        void bindView(int pos) {
            if (pos == opened){
                tv_order.setVisibility(View.VISIBLE);
            } else{
                tv_order.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View v) {
            if (opened == getAdapterPosition()) {
                //当点击的item已经被展开了, 就关闭.
                opened = -1;
                notifyItemChanged(getAdapterPosition());
            } else {
                int oldOpened = opened;
                opened = getAdapterPosition();
                notifyItemChanged(oldOpened);
                notifyItemChanged(opened);
            }
        }
    }
}
