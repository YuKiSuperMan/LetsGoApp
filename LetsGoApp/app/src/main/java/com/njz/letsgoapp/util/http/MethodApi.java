package com.njz.letsgoapp.util.http;

import com.njz.letsgoapp.bean.mine.MyInfoData;
import com.njz.letsgoapp.bean.order.AliPay;
import com.njz.letsgoapp.bean.send.SendNotifyMainModel;
import com.njz.letsgoapp.bean.send.SendOrderCancelModel;
import com.njz.letsgoapp.bean.send.SendOrderModel;
import com.njz.letsgoapp.bean.send.SendOrderRefundModel;
import com.njz.letsgoapp.constant.Constant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by LGQ
 * Time: 2018/7/18
 * Function:
 */

public class MethodApi {

    /**
     * 获取用户详细信息
     *
     * @Field("telphone") String telphone,
     * @Field("passWord") String passWord,
     * @Field("captcha") String captcha,
     * @Field("channel") int channel
     */
//    public static void register(DisposableObserver<BaseResponse> subscriber
//            , String telphone, String passWord, String captcha, int channel) {
//        Observable observable = HttpMethods.getInstance().getHttpService().register(telphone,
//                passWord,
//                captcha,
//                channel); //在HttpServer中
//        HttpMethods.getInstance().toSubscribe(observable, subscriber);
//    }

    public static void appPay(DisposableObserver<AliPay> subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().appPay(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void appPayWX(DisposableObserver<AliPay> subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().appPayWX(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //-----------login start------------
    public static void login(String mobile, String password, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().login(mobile, password); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void msgCheckRegister(String mobile, String msg, String password, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().msgCheckRegister(mobile, msg, password); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    public static void msgCheckFindBy(String mobile, String msg, String password, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().msgCheckFindBy(mobile, msg, password); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void msgCheckLogin(String mobile, String msg, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().msgCheckLogin(mobile, msg); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void userSmsSend(String mobile, String type, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userSmsSend(mobile, type); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void changePwd(String token, String password, String newPassword, DisposableObserver subscriber) {
//        Observable observable = HttpMethods.getInstance().getHttpService().changePwd(token, password, newPassword); //在HttpServer中
        Observable observable = HttpMethods.getInstance().getHttpService().changePwd(password, newPassword); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void updateMobile(String token, String mobile, String msg, String password, DisposableObserver subscriber) {
//        Observable observable = HttpMethods.getInstance().getHttpService().updateMobile(token, mobile, msg, password); //在HttpServer中
        Observable observable = HttpMethods.getInstance().getHttpService().updateMobile(mobile, msg, password); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //userLogout
    public static void userLogout(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userLogout(); //在HttpServer中
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //-----------login end------------

    //----------首页 start -------
    public static void bannerFindByType(int type, int guideId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().bannerFindByType(type, guideId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendFriendSterTop 首页动态
    public static void friendFriendSterTop(String location, int limit,int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendFriendSterTop(location,limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void orderReviewsSortTop(String location, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().guideSortTop10ByLocation(location, Constant.GUIDE_TYPE_SYNTHESIZE, 5, Constant.DEFAULT_PAGE);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void guideSortTop10ByLocation(String location, int type, int limit, int page, Map<String, String> maps, DisposableObserver subscriber) {
        Observable observable;
        if (maps == null) {
            observable = HttpMethods.getInstance().getHttpService().guideSortTop10ByLocation(location, type, limit, page);
        } else {
            observable = HttpMethods.getInstance().getHttpService().guideSortTop10ByLocation2(location, type, limit, page, maps);
        }

        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void guideFindGuideDetails(String location, int guideId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().guideFindGuideDetails(location, guideId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void getGuideService(int serviceId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getGuideService(serviceId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void getServiceList(int guideId, int serveType,String location, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().getServiceList(guideId, serveType,location);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //----------首页 end -------


    //----------发现 start -------

    //friendFindAll
    public static void friendFindAll(String location, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendFindAll(location, limit, page,null);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendFindAll
    public static void friendFindAll(String location, int limit, int page,String search, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendFindAll(location, limit, page,search);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendFriendSter
    public static void friendFriendSter(int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendFriendSter(limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    private static List<MultipartBody.Part> filesToMultipartBodyParts(List<String> files) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (String fileStr : files) {
            File file = new File(fileStr);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("files", file.getName(), requestBody);
            parts.add(part);
        }
        return parts;
    }

    private static RequestBody getStringPart(String str){
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), str);
        return requestBody;
    }

    //sendSter
    public static void sendSter(String location, double lon, double lat, String content, List<String> files, DisposableObserver subscriber) {
        List<MultipartBody.Part> partList = filesToMultipartBodyParts(files);

        Observable observable = HttpMethods.getInstance().getHttpService().sendSter(getStringPart(location), lon, lat, getStringPart(content), partList);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //userFindFocus
    public static void userViewZone(int userId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userViewZone(userId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendPersonalFriendSter 动态列表
    public static void friendPersonalFriendSter(int userId, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendPersonalFriendSter(userId, limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendFindByFriendSterId 动态详情
    public static void friendPersonalFriendSter(int friendSterId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendFindByFriendSterId(friendSterId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //userFindFans //粉丝列表
    public static void userFindFans(int userId, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userFindFans(userId, limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //userFindFocus //关注列表
    public static void userFindFocus(int userId, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userFindFocus(userId, limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //travelFriendQueryLikes 朋友圈点赞列表
    public static void travelFriendQueryLikes(int userId, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendQueryLikes(userId, limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendDoUnLike  点赞
    public static void friendQueryLikes(boolean isNice, int friendSterId, DisposableObserver subscriber) {
        if (isNice) {
            Observable observable = HttpMethods.getInstance().getHttpService().friendDoUnLike(friendSterId);
            HttpMethods.getInstance().toSubscribe(observable, subscriber);
        } else {
            Observable observable = HttpMethods.getInstance().getHttpService().friendDoLike(friendSterId);
            HttpMethods.getInstance().toSubscribe(observable, subscriber);
        }
    }

    //userFocusOff  关注他
    public static void userFocusOff(boolean isFollow, int focusId, DisposableObserver subscriber) {
        if (isFollow) {
            Observable observable = HttpMethods.getInstance().getHttpService().userFocusOff(focusId);
            HttpMethods.getInstance().toSubscribe(observable, subscriber);
        } else {
            Observable observable = HttpMethods.getInstance().getHttpService().userFocusOn(focusId);
            HttpMethods.getInstance().toSubscribe(observable, subscriber);
        }
    }

    //friendDiscuss 动态评论
    public static void friendDiscuss(int friendSterId, int discussUserId, String discussContent, int toUserId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendDiscuss(friendSterId, discussUserId, discussContent, toUserId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //friendDeleteDiscuss 动态评论删除
    public static void friendDeleteDiscuss(int discussId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendDeleteDiscuss(discussId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //我的评论列表 friendMyDiscuss
    public static void friendMyDiscuss(int type, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendMyDiscuss(type);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //删除动态 friendDeleteFriendSter
    public static void friendDeleteFriendSter(int friendSterId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().friendDeleteFriendSter(friendSterId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //----------发现 end -------

    //---------我的 start-------
    public static void userChangePersonalData(MyInfoData data, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userChangePersonalData(data);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //userLabels
    public static void userLabels(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().userLabels();
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void upUpload(File file, DisposableObserver subscriber) {
        RequestBody fileRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part fileBody = MultipartBody.Part.createFormData("file", file.getName(), fileRequestBody);
        Observable observable = HttpMethods.getInstance().getHttpService().upUpload(fileBody);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //---------我的 end-------

    //--------订单 start---------
    //sendSter 订单评价
    public static void upUserReview(int orderId, int guideId, int guideService, int carCondition,
                                    int buyService, int travelArrange, String userContent, List<String> files,
                                    DisposableObserver subscriber) {

        List<MultipartBody.Part> partList = filesToMultipartBodyParts(files);

        Observable observable = HttpMethods.getInstance().getHttpService().upUserReview(orderId, guideId, guideService,
                carCondition, buyService, travelArrange, getStringPart(userContent), partList);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderReviewsFindGuideReviews 导游评价列表
    public static void orderReviewsFindGuideReviews(int guideId,String value, int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderReviewsFindGuideReviews(guideId, value,limit, page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderCreateOrder 订单创建
    public static void orderCreateOrder(SendOrderModel data, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderCreateOrder(data);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderPayAliPay 阿里支付
    public static void orderPayAliPay(String outTradeNo, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderPayAppPay(outTradeNo,"AliPay");
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderPayAliPay 微信支付
    public static void orderPayWxPay(String outTradeNo, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderPayAppPay(outTradeNo,"WxPay");
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderPayAppQuery 支付查询
    public static void orderPayAppQuery(String outTradeNo, String type, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderPayAppQuery(outTradeNo,type);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderQueryOrderList 订单列表
    public static void orderQueryOrderList(int payStatus,int limit, int page, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderQueryOrderList(payStatus,limit,page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderRefundQueryOrderRefundList 退款单列表
    public static void orderRefundQueryOrderRefundList(int limit, int page,DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderRefundQueryOrderRefundList(limit,page);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderRefundQueryOrderRefundDetails 退款单详情
    public static void orderRefundQueryOrderRefundDetails(int refundId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderRefundQueryOrderRefundDetails(refundId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }


    //orderCancelOrder 取消订单
    public static void orderCancelOrder(SendOrderCancelModel data, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderCancelOrder(data);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderRefundAliRefund 退款申请
    public static void orderRefundAliRefund(SendOrderRefundModel data, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderRefundAliRefund(data);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderRefundRefundAnalysis 退款分析
    public static void orderRefundRefundAnalysis(SendOrderRefundModel data, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderRefundRefundAnalysis(data);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //订单详情 orderQueryOrder
    public static void orderQueryOrder(int orderId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderQueryOrder(orderId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderDeleteOrder 订单删除
    public static void orderDeleteOrder(int id,int status, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderDeleteOrder(id,status);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //orderRefundFindRefundRule 退订规则
    public static void orderRefundFindRefundRule(int serveId, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().orderRefundFindRefundRule(serveId);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //--------订单 end---------

    //--------消息 start ----------
    //msgPushGetSendMsgList 获取主页消息
    public static void msgPushReceiveKindList(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().msgPushReceiveKindList();
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //msgPushGetReceiveMsgList 子消息列表
    public static void msgPushGetReceiveMsgList(String type,int limit,int page, DisposableObserver subscriber) {
        SendNotifyMainModel mainModel = new SendNotifyMainModel();
        mainModel.setMsgBroad(type);
        mainModel.setLimit(limit);
        mainModel.setPage(page);
        mainModel.setOrder("");
        mainModel.setSidx("");
        Observable observable = HttpMethods.getInstance().getHttpService().msgPushGetReceiveMsgList(mainModel);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //--------消息 end ----------



    //--------城市选择 start
    public static void regionFindProAndCity(DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().regionFindProAndCity();
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //regionFuzzyBySpell 搜索
    public static void regionFuzzyBySpell(String spell, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().regionFuzzyBySpell(spell);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    public static void guideGetGuideMacros(String values, DisposableObserver subscriber) {
        Observable observable = HttpMethods.getInstance().getHttpService().guideGetGuideMacros(values);
        HttpMethods.getInstance().toSubscribe(observable, subscriber);
    }

    //--------城市选择 end

}
