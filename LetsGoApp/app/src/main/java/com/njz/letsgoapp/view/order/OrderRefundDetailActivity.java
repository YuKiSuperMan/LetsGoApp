package com.njz.letsgoapp.view.order;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.order.OrderRefundDetailAdapter;
import com.njz.letsgoapp.bean.MySelfInfo;
import com.njz.letsgoapp.bean.order.OrderRefundDetailChildModel;
import com.njz.letsgoapp.bean.order.OrderRefundDetailModel;
import com.njz.letsgoapp.constant.Constant;
import com.njz.letsgoapp.dialog.DialogUtil;
import com.njz.letsgoapp.mvp.order.OrderRefundDetailContract;
import com.njz.letsgoapp.mvp.order.OrderRefundDetailPresenter;
import com.njz.letsgoapp.util.ToastUtil;

import java.util.ArrayList;

/**
 * Created by LGQ
 * Time: 2018/9/29
 * Function:
 */

public class OrderRefundDetailActivity extends OrderDetailActivity implements OrderRefundDetailContract.View{

    OrderRefundDetailPresenter refundPresenter;
    OrderRefundDetailAdapter refundAdapter;

    OrderRefundDetailModel refundModel;

    RelativeLayout rl_refund_penalty,rl_refund_price,rl_order_price;
    TextView tv_refund_penalty,tv_refund_price;
    CardView cv_refund_reason;
    TextView tv_refund_reason,tv_refund_explain;

    @Override
    public void initData() {
        refundPresenter = new OrderRefundDetailPresenter(context,this);
        refundPresenter.orderRefundQueryOrderRefundDetails(orderId);
    }

    @Override
    public void initView() {
        super.initView();
        rl_refund_penalty = $(R.id.rl_refund_penalty);
        rl_refund_price = $(R.id.rl_refund_price);
        rl_order_price = $(R.id.rl_order_price);
        tv_refund_penalty = $(R.id.tv_refund_penalty);
        tv_refund_price = $(R.id.tv_refund_price);
        cv_refund_reason = $(R.id.cv_refund_reason);
        tv_refund_reason = $(R.id.tv_refund_reason);
        tv_refund_explain = $(R.id.tv_refund_explain);

        rl_order_price.setVisibility(View.GONE);
        rl_refund_price.setVisibility(View.VISIBLE);
        rl_refund_penalty.setVisibility(View.VISIBLE);
        cv_refund_reason.setVisibility(View.VISIBLE);

    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        refundAdapter = new OrderRefundDetailAdapter(activity, new ArrayList<OrderRefundDetailChildModel>());
        recyclerView.setAdapter(refundAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call_guide:
                DialogUtil.getInstance().showGuideMobileDialog(context,model.getGuideMobile());
                break;
            case R.id.btn_delete:
                showShortToast("删除");
                break;
            case R.id.btn_call_custom:
                DialogUtil.getInstance().showCustomerMobileDialog(context);
                break;
        }

    }

    @Override
    public void orderRefundQueryOrderRefundDetailsSuccess(OrderRefundDetailModel str) {
        refundModel = str;

        ll_order_no.setVisibility(View.VISIBLE);
        tv_order_no.setText(str.getOrderNo());
        ll_order_refund_apply.setVisibility(View.VISIBLE);
        tv_order_refund_apply.setText(str.getApplyTime());

        switch (str.getRefundStatus()){
            case Constant.ORDER_REFUND_PROCESS:
                ll_order_refund_verify.setVisibility(View.VISIBLE);
                tv_order_refund_verify.setText(str.getGuideCheckTime());
                break;
            case Constant.ORDER_REFUND_FINISH:
                ll_order_refund_verify.setVisibility(View.VISIBLE);
                tv_order_refund_verify.setText(str.getGuideCheckTime());
                ll_order_refund_time.setVisibility(View.VISIBLE);
                tv_order_refund_time.setText(str.getRefundTime());
                break;
        }

        switch (str.getRefundStatus()){
            case Constant.ORDER_REFUND_WAIT:
            case Constant.ORDER_REFUND_PROCESS:
                btn_call_custom.setVisibility(View.VISIBLE);
                btn_call_guide.setVisibility(View.VISIBLE);
                break;
            case Constant.ORDER_REFUND_FINISH:
                btn_delete.setVisibility(View.VISIBLE);
                break;
        }

        tv_guide_name.setText(str.getGuideName());
        tv_order_status.setText(str.getPayStatusStr());

        fixed_view_city.setContent(str.getLocation());
        login_view_name.setContent(str.getName());
        login_view_phone.setContent(str.getMobile());
        et_special.setText(str.getSpecialRequire());

        tv_refund_penalty.setText(str.getRefundMoney() + "");
        tv_refund_price.setText(str.getDefaultMoney() + "");

        tv_refund_reason.setText(str.getRefundReason());
        tv_refund_explain.setText(str.getRefundContent());


        refundAdapter.setData(str.getNjzRefundDetailsChildVOS());
    }

    @Override
    public void orderRefundQueryOrderRefundDetailsFailed(String msg) {
        showShortToast(msg);
    }
}
