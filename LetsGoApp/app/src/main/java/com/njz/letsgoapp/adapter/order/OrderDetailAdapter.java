package com.njz.letsgoapp.adapter.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.bean.home.ServiceItem;
import com.njz.letsgoapp.bean.order.OrderDetailChildModel;
import com.njz.letsgoapp.constant.Constant;
import com.njz.letsgoapp.util.glide.GlideUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/8/16
 * Function:
 */

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.BaseViewHolder> {

    private Context context;
    private List<OrderDetailChildModel> datas;

    public OrderDetailAdapter(Context context, List<OrderDetailChildModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setData(List<OrderDetailChildModel> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_order_submit, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder == null) return;
        if (holder instanceof ViewHolder) {
            final int pos = holder.getAdapterPosition();
            final OrderDetailChildModel data = datas.get(pos);
            if (data == null) return;

            GlideUtil.LoadRoundImage(context, data.getTitleImg(), ((ViewHolder) holder).iv_img,5);
            ((ViewHolder) holder).tv_title.setText(data.getTitle());
            ((ViewHolder) holder).tv_price_unit.setText("￥" + data.getPrice());

            switch (data.getValue()) {
                case Constant.SERVICE_TYPE_SHORT_CUSTOM:
                    ((ViewHolder) holder).tv_day.setText("x" + data.getPersonNum() + "人");
                    ((ViewHolder) holder).tv_price_total.setText("￥" + data.getOrderPrice());

                    ((ViewHolder) holder).ll_count.setVisibility(View.GONE);

                    ((ViewHolder) holder).tv_time_title.setText("行程时间");
                    break;
                case Constant.SERVICE_TYPE_SHORT_CAR:
                case Constant.SERVICE_TYPE_SHORT_GUIDE:
                    ((ViewHolder) holder).tv_day.setText("x" + data.getDayNum() + "天");
                    ((ViewHolder) holder).tv_price_total.setText("￥" + data.getOrderPrice());

                    ((ViewHolder) holder).ll_count.setVisibility(View.VISIBLE);
                    ((ViewHolder) holder).tv_count_title.setText("出行人数");
                    ((ViewHolder) holder).tv_count_content.setText(data.getPersonNum() + "");

                    ((ViewHolder) holder).tv_time_title.setText("出行日期");
                    break;
                case Constant.SERVICE_TYPE_SHORT_HOTEL:
                    ((ViewHolder) holder).tv_day.setText("x" + data.getRoomNum() + "间" + "x" +  data.getDayNum() + "天");
                    ((ViewHolder) holder).tv_price_total.setText("￥" + data.getOrderPrice());

                    ((ViewHolder) holder).ll_count.setVisibility(View.GONE);

                    ((ViewHolder) holder).tv_time_title.setText("入住时间");
                    break;
                case Constant.SERVICE_TYPE_SHORT_TICKET:
                    ((ViewHolder) holder).tv_day.setText("x" + data.getTicketNum() + "张");
                    ((ViewHolder) holder).tv_price_total.setText("￥" + data.getOrderPrice());

                    ((ViewHolder) holder).ll_count.setVisibility(View.GONE);

                    ((ViewHolder) holder).tv_time_title.setText("日期");
                    break;
            }

            ((ViewHolder) holder).tv_time_content.setText(data.getTravelDate());

            ((ViewHolder) holder).btn_cancel.setVisibility(View.GONE);
            switch (data.getPayStatus()){
                case Constant.ORDER_PAY_WAIT:

                    if(data.getPayingStatus() == Constant.ORDER_WAIT_PAYING){
                        ((ViewHolder) holder).btn_cancel.setVisibility(View.GONE);
                    }else{
                        ((ViewHolder) holder).btn_cancel.setVisibility(View.VISIBLE);
                        ((ViewHolder) holder).btn_cancel.setText("取消");
                        ((ViewHolder) holder).btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(mOnCancelClickListener != null){
                                    mOnCancelClickListener.onClick(data.getId());
                                }
                            }
                        });
                    }

                    break;
                case Constant.ORDER_PAY_ALREADY:
                    ((ViewHolder) holder).btn_cancel.setVisibility(View.VISIBLE);
                    ((ViewHolder) holder).btn_cancel.setText("退款");
                    ((ViewHolder) holder).btn_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(mOnRefundClickListener != null){
                                List<Integer> childIds = new ArrayList<Integer>();
                                childIds.add(data.getId());
                                mOnRefundClickListener.onClick(0, childIds, data.getChildOrderStatus(), pos);
                            }
                        }
                    });
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder extends BaseViewHolder {

        ImageView iv_img;
        TextView tv_title, tv_price_unit, tv_day, tv_price_total;
        LinearLayout ll_count;
        TextView tv_count_title, tv_count_content, tv_time_title, tv_time_content,btn_cancel;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_price_unit = itemView.findViewById(R.id.tv_price_unit);
            tv_day = itemView.findViewById(R.id.tv_day);
            tv_price_total = itemView.findViewById(R.id.tv_price_total);
            ll_count = itemView.findViewById(R.id.ll_count);
            tv_time_content = itemView.findViewById(R.id.tv_time_content);
            tv_time_title = itemView.findViewById(R.id.tv_time_title);
            tv_count_content = itemView.findViewById(R.id.tv_count_content);
            tv_count_title = itemView.findViewById(R.id.tv_count_title);
            btn_cancel = itemView.findViewById(R.id.btn_cancel);

        }
    }

    OnCancelClickListener mOnCancelClickListener;
    OnRefundClickListener mOnRefundClickListener;

    public interface OnCancelClickListener{
        void onClick(int orderId);
    }

    public interface OnRefundClickListener{
        void onClick(int id, List<Integer> childIds, int status, int index);
    }

    public void setOnCancelClickListener(OnCancelClickListener onCancelClickListener){
        this.mOnCancelClickListener = onCancelClickListener;
    }

    public void setOnRefundClickListener(OnRefundClickListener onRefundClickListener){
        this.mOnRefundClickListener = onRefundClickListener;
    }
}
