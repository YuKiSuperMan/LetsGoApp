package com.njz.letsgoapp.adapter.notify;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.bean.mine.MyCommentModel;
import com.njz.letsgoapp.bean.notify.NotifyMainModel;
import com.njz.letsgoapp.constant.Constant;
import com.njz.letsgoapp.util.ToastUtil;
import com.njz.letsgoapp.util.glide.GlideUtil;
import com.njz.letsgoapp.util.log.LogUtil;
import com.njz.letsgoapp.view.find.DynamicDetailActivity;
import com.njz.letsgoapp.view.home.GuideDetailActivity;
import com.njz.letsgoapp.view.mine.SpaceActivity;
import com.njz.letsgoapp.view.order.OrderDetailActivity;

import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/8/23
 * Function:
 */

public class SystemMsgAdapter extends RecyclerView.Adapter<SystemMsgAdapter.ViewHolder> {

    Context mContext;
    List<NotifyMainModel> datas;

    public SystemMsgAdapter(Context mContext, List<NotifyMainModel> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_system_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (holder == null) return;
        final NotifyMainModel data = datas.get(position);
        if (data == null) return;

        holder.tv_name.setText(data.getTitle());
        holder.tv_time.setText(data.getStartTimeTwo());
        holder.tv_content.setText(data.getContent().getAlert());

        if(data.getCorrelationId() == -1 || TextUtils.isEmpty(data.getSkip())){
            holder.tv_jump.setVisibility(View.GONE);
        }else{
            holder.tv_jump.setVisibility(View.VISIBLE);
        }

        setSkip(holder.rl_parent,data.getSkip(),data.getCorrelationId());
    }

    public void setSkip(View view, final String skip, final int correlationId){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correlationId == -1){
                    LogUtil.e("不能进行跳转correlationId");
                    return;
                }
                Intent intent;
                switch (skip){
                    case Constant.NOTIFY_SKIP_FSD:
                        intent = new Intent(mContext, DynamicDetailActivity.class);
                        intent.putExtra(DynamicDetailActivity.FRIENDSTERID,correlationId);
                        mContext.startActivity(intent);
                        break;
                    case Constant.NOTIFY_SKIP_GD:
                        intent = new Intent(mContext, GuideDetailActivity.class);
                        intent.putExtra(GuideDetailActivity.GUIDEID,correlationId);
                        mContext.startActivity(intent);
                        break;
                    case Constant.NOTIFY_SKIP_OD:
                        intent = new Intent(mContext, OrderDetailActivity.class);
                        intent.putExtra("ORDER_ID",correlationId);
                        mContext.startActivity(intent);
                        break;
                    case Constant.NOTIFY_SKIP_UD:
                        intent = new Intent(mContext, SpaceActivity.class);
                        intent.putExtra(SpaceActivity.USER_ID,correlationId);
                        mContext.startActivity(intent);
                        break;
                    default:
                        LogUtil.e("不能进行跳转skip");
                        break;
                }

            }
        });
    }

    public void setData(List<NotifyMainModel> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public List<NotifyMainModel> getDatas(){
        return this.datas;
    }

    public void addData(List<NotifyMainModel> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_time,tv_content;
        FrameLayout rl_parent;
        TextView tv_jump;

        public ViewHolder(View itemView) {
            super(itemView);

            rl_parent = itemView.findViewById(R.id.rl_parent);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_jump = itemView.findViewById(R.id.tv_jump);
        }
    }

}
