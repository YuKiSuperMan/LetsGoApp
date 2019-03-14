package com.njz.letsgoapp.view.order;

import android.text.TextUtils;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.base.BaseActivity;
import com.njz.letsgoapp.bean.order.ServiceRefundRuleModel;
import com.njz.letsgoapp.mvp.order.ServiceRefundRuleContract;
import com.njz.letsgoapp.mvp.order.ServiceRefundRulePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/10/19
 * Function:
 */

public class RefundRuleActivity extends BaseActivity implements ServiceRefundRuleContract.View{

    TextView tv_refund_rule_50,tv_refund_rule_30;

    ServiceRefundRulePresenter mPresenter;

    int serviceId;
    int orderId;

    @Override
    public void getIntentData() {
        super.getIntentData();
        serviceId = intent.getIntExtra("serviceId",0);
        orderId = intent.getIntExtra("orderId",0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_refund_rule;
    }

    @Override
    public void initView() {
        showLeftAndTitle("退订规则");
        tv_refund_rule_30 = $(R.id.tv_refund_rule_30);
        tv_refund_rule_50 = $(R.id.tv_refund_rule_50);
    }

    @Override
    public void initData() {
        mPresenter = new ServiceRefundRulePresenter(context,this);
        mPresenter.orderRefundFindRefundRule(serviceId,orderId,true);
    }

    @Override
    public void orderRefundFindRefundRuleSuccess(ServiceRefundRuleModel str) {
        if(str == null) return;

        if (!TextUtils.isEmpty(str.getRenegePriceThree())) {
            List<String> lists = getValue(str.getRenegePriceThree());
            tv_refund_rule_30.setText(String.format(getResources().getString(R.string.refund_rule_30),
                    lists.get(0) + "-" + lists.get(1), getProportion(lists.get(2))));
        }
        if (!TextUtils.isEmpty(str.getRenegePriceFive())) {
            List<String> lists = getValue(str.getRenegePriceFive());
            tv_refund_rule_50.setText(String.format(getResources().getString(R.string.refund_rule_50),
                    lists.get(0) + "-" + lists.get(1), getProportion(lists.get(2))));
        }
    }

    @Override
    public void orderRefundFindRefundRuleFailed(String msg) {
        showShortToast(msg);
    }

    public String getProportion(String str){
        int value = (int) (Float.valueOf(str) * 100);
        return value + "";
    }

    public List<String> getValue(String str) {
        String[] strs = str.split(",");
        List<String> lists = new ArrayList<>(Arrays.asList(strs));
        if (lists.size() != 3) {
            lists.add("0");
        }
        return lists;
    }
}
