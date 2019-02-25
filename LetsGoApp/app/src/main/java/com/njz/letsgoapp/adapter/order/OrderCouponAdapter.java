package com.njz.letsgoapp.adapter.order;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.bean.mine.CouponData;

import java.util.List;

/**
 * Created by LGQ
 * Time: 2019/2/25
 * Function:
 */

public class OrderCouponAdapter extends RecyclerView.Adapter<OrderCouponAdapter.ViewHolder> {

    Context mContext;
    List<CouponData> datas;

    public OrderCouponAdapter(Context mContext, List<CouponData> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_order_coupon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder == null) return;
        final CouponData data = datas.get(position);
        if (data == null) return;

        holder.tv_price.setText("￥" + data.getPrice());
        holder.tv_title.setText(data.getTitle());
        holder.tv_limit.setText("满" + data.getLimit()+"元可用");
        holder.tv_expire.setText("有效期至" + data.getExpire());

        holder.rl_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });

        if(data.isSelected()){
            holder.iv_select.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.oval_f7_theme_r40));
        }else{
            holder.iv_select.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.oval_f7_99_r40));
        }
    }

    public void setData(List<CouponData> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_price,tv_title,tv_limit,tv_expire;
        ImageView iv_select;
        RelativeLayout rl_parent;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_price = itemView.findViewById(R.id.tv_price);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_limit = itemView.findViewById(R.id.tv_limit);
            tv_expire = itemView.findViewById(R.id.tv_expire);
            iv_select = itemView.findViewById(R.id.iv_select);
            rl_parent = itemView.findViewById(R.id.rl_parent);
        }
    }


    OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
