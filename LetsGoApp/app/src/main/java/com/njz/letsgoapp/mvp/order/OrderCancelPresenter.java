package com.njz.letsgoapp.mvp.order;

import android.content.Context;

import com.njz.letsgoapp.bean.EmptyModel;
import com.njz.letsgoapp.bean.send.SendOrderCancelModel;
import com.njz.letsgoapp.util.http.MethodApi;
import com.njz.letsgoapp.util.http.OnSuccessAndFaultSub;
import com.njz.letsgoapp.util.http.ResponseCallback;

/**
 * Created by LGQ
 * Time: 2018/9/28
 * Function:
 */

public class OrderCancelPresenter implements OrderCancelContract.Presenter {

    Context context;
    OrderCancelContract.View iView;

    public OrderCancelPresenter(Context context, OrderCancelContract.View iView) {
        this.context = context;
        this.iView = iView;
    }

    @Override
    public void orderTravelDeleteOrder(int orderId,int isMainly,String cancelReason,String cancelExplain) {
        ResponseCallback listener = new ResponseCallback<EmptyModel>() {
            @Override
            public void onSuccess(EmptyModel data) {
                iView.orderTravelDeleteOrderSuccess(data);
            }

            @Override
            public void onFault(String errorMsg) {
                iView.orderTravelDeleteOrderFailed(errorMsg);
            }
        };

        SendOrderCancelModel model = new SendOrderCancelModel();
        model.setId(orderId);
        model.setIsMainly(isMainly);
        model.setCancelReason(cancelReason);
        model.setCancelExplain(cancelExplain);
        MethodApi.orderCancelOrder(model,new OnSuccessAndFaultSub(listener, context));
    }
}
