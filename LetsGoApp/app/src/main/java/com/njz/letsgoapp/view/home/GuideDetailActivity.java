package com.njz.letsgoapp.view.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.order.SimpleImageAdapter;
import com.njz.letsgoapp.base.BaseActivity;
import com.njz.letsgoapp.bean.MySelfInfo;
import com.njz.letsgoapp.bean.home.BannerModel;
import com.njz.letsgoapp.bean.home.EvaluateModel;
import com.njz.letsgoapp.bean.home.GuideDetailModel;
import com.njz.letsgoapp.constant.Constant;
import com.njz.letsgoapp.constant.URLConstant;
import com.njz.letsgoapp.dialog.DialogUtil;
import com.njz.letsgoapp.dialog.ShareDialog;
import com.njz.letsgoapp.mvp.home.GuideDetailContract;
import com.njz.letsgoapp.mvp.home.GuideDetailPresenter;
import com.njz.letsgoapp.util.AppUtils;
import com.njz.letsgoapp.util.ToastUtil;
import com.njz.letsgoapp.util.banner.LocalImageHolderView;
import com.njz.letsgoapp.util.glide.GlideUtil;
import com.njz.letsgoapp.util.webview.LWebView;
import com.njz.letsgoapp.view.login.LoginActivity;
import com.njz.letsgoapp.view.other.BigImageActivity;
import com.njz.letsgoapp.widget.GuideAuthenticationView;
import com.njz.letsgoapp.widget.GuideLabelView;
import com.njz.letsgoapp.widget.MyRatingBar;
import com.njz.letsgoapp.widget.ServiceTagView;
import com.njz.letsgoapp.widget.emptyView.EmptyView3;
import com.njz.letsgoapp.widget.popupwindow.PopService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/8/9
 * Function: 导游详情
 */

public class GuideDetailActivity extends BaseActivity implements View.OnClickListener, GuideDetailContract.View {

    ConvenientBanner convenientBanner;
    ImageView iv_head,iv_sex;
    TextView tv_name, tv_service_num, tv_comment_content, tv_content, tv_back_top, btn_submit;
    MyRatingBar my_rating_bar;
    ServiceTagView stv_tag;
    NestedScrollView scrollView;

    LinearLayout ll_select_service, btn_call;

    LinearLayout ll_comment_title;
    TextView tv_comment_title_score, tv_comment_title_count;

    PopService popService;
    GuideLabelView guideLabel;
    GuideAuthenticationView guide_authentication;

    LWebView webView;

    GuideDetailPresenter mPresenter;

    GuideDetailModel guideDetailModel;

    TextView tv_comment_guide_total,tv_comment_trip_total,tv_comment_car_total,tv_comment_book_total;

    int guideId;
    public static final String GUIDEID = "GUIDEID";

    EmptyView3 view_empty;

    @Override
    public void getIntentData() {
        super.getIntentData();
        guideId = intent.getIntExtra(GUIDEID, -1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide_detail;
    }

    @Override
    public void initView() {

        if (guideId == -1) {
            showShortToast("导游详情获取失败");
            finish();
        }

        showLeftAndTitle("向导详情介绍");
        showRightIv();
        getRightIv().setImageDrawable(ContextCompat.getDrawable(AppUtils.getContext(), R.mipmap.icon_share));
        getRightIv().setOnClickListener(this);

        view_empty = $(R.id.view_empty);
        convenientBanner = $(R.id.convenientBanner);
        iv_head = $(R.id.iv_head);
        iv_sex = $(R.id.iv_sex);
        tv_name = $(R.id.tv_name);
        my_rating_bar = $(R.id.my_rating_bar);
        stv_tag = $(R.id.stv_tag);
        ll_select_service = $(R.id.ll_select_service);
        tv_content = $(R.id.tv_content);
        btn_call = $(R.id.btn_call);
        btn_submit = $(R.id.btn_submit);
        guideLabel = $(R.id.guide_label);
        tv_service_num = $(R.id.tv_service_num);
        guide_authentication = $(R.id.guide_authentication);
        tv_comment_content = $(R.id.tv_comment_content);
        tv_back_top = $(R.id.tv_back_top);
        webView = $(R.id.webview);
        scrollView = $(R.id.scrollView);
        ll_comment_title = $(R.id.ll_comment_title);
        tv_comment_title_score = $(R.id.tv_comment_title_score);
        tv_comment_title_count = $(R.id.tv_comment_title_count);
        tv_comment_guide_total = $(R.id.tv_comment_guide_total);
        tv_comment_trip_total = $(R.id.tv_comment_trip_total);
        tv_comment_car_total = $(R.id.tv_comment_car_total);
        tv_comment_book_total = $(R.id.tv_comment_book_total);

        tv_back_top.setVisibility(View.GONE);
        tv_back_top.setOnClickListener(this);

        ll_comment_title.setOnClickListener(this);
        ll_select_service.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        convenientBanner.startTurning(Constant.BANNER_RUNNING_TIME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        convenientBanner.stopTurning();
    }

    @Override
    public void initData() {

        mPresenter = new GuideDetailPresenter(context, this);
        mPresenter.guideFindGuideDetails(MySelfInfo.getInstance().getDefaultCity(), guideId);
        mPresenter.bannerFindByType(Constant.BANNER_GUIDE, guideId);

        final int mDisplayHeight = AppUtils.getDisplayHeight();
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > mDisplayHeight) {
                    tv_back_top.setVisibility(View.VISIBLE);
                } else {
                    tv_back_top.setVisibility(View.GONE);
                }
            }
        });
    }

    //认证
    public List<Integer> getViable(GuideDetailModel model){
        List<Integer> authentications = new ArrayList<>();

        if(model.getDriveViable() == 2){
            authentications.add(GuideAuthenticationView.AUTHENT_CAR);
        }
        if(model.getGuideViable() == 2){
            authentications.add(GuideAuthenticationView.AUTHENT_GUIDE);
        }
        if(model.getCardViable() == 2){
            authentications.add(GuideAuthenticationView.AUTHENT_IDENTITY);
        }
        return authentications;
    }

    //initInfo
    public void initInfo(final GuideDetailModel model) {
        //个人信息
        GlideUtil.LoadCircleImage(context, model.getGuideImg(), iv_head);
        iv_sex.setImageDrawable(ContextCompat.getDrawable(context,model.getGuideGender() == 2?R.mipmap.icon_girl:R.mipmap.icon_boy));
        tv_name.setText(model.getGuideName());
        my_rating_bar.setRating((int) model.getGuideScore());
        tv_service_num.setText(model.getServiceCounts());
        guideLabel.setTabel(model.getSign());
        stv_tag.setServiceTag(model.getServiceTag());
        guide_authentication.setAuthentication(getViable(model));
        tv_content.setText(model.getIntroduce());

        tv_comment_title_score.setText("" + model.getGuideScore());
        tv_comment_title_count.setText("(" + model.getCount() + "条评论)");

        tv_comment_guide_total.setVisibility(View.GONE);
        tv_comment_trip_total.setVisibility(View.GONE);
        tv_comment_car_total.setVisibility(View.GONE);
        tv_comment_book_total.setVisibility(View.GONE);

        if(model.getGuideServices() > 0 ){
            tv_comment_guide_total.setVisibility(View.VISIBLE);
            tv_comment_guide_total.setText(model.getGuideServiceStr());
        }
        if(model.getTravelArranges() > 0 ){
            tv_comment_trip_total.setVisibility(View.VISIBLE);
            tv_comment_trip_total.setText(model.getTravelArrangeStr());
        }
        if(model.getCarConditions() > 0){
            tv_comment_car_total.setVisibility(View.VISIBLE);
            tv_comment_car_total.setText(model.getCarConditionStr());
        }
        if(model.getBuyServices() > 0){
            tv_comment_book_total.setVisibility(View.VISIBLE);
            tv_comment_book_total.setText(model.getBuyServiceStr());
        }

        initEvaluate(model.getTravelFirstReviewVO());

        if(!TextUtils.isEmpty(model.getGuideStory())){
            webView.loadDataWithBaseURL(null, model.getGuideStory(), "text/html", "utf-8", null);
            view_empty.setVisible(false);
        }else{
            view_empty.setVisible(true);
            view_empty.setEmptyData(R.mipmap.empty_guide_story,"他很害羞哦，什么都没留下~");
        }


    }

    //评价
    public void initEvaluate(final EvaluateModel evaluateModel) {
        if (evaluateModel == null) {
            LinearLayout ll_comment = $(R.id.ll_comment);
            ll_comment.setVisibility(View.GONE);
            return;
        }

        ImageView comment_head = $(R.id.comment_head);
        TextView commont_name = $(R.id.commont_name);
        TextView commont_time = $(R.id.commont_time);
        TextView commont_score = $(R.id.commont_score);
        TextView tv_comment_content = $(R.id.tv_comment_content);
        TextView tv_comment_guide = $(R.id.tv_comment_guide);
        TextView tv_comment_trip = $(R.id.tv_comment_trip);
        TextView tv_comment_car = $(R.id.tv_comment_car);
        TextView tv_comment_book = $(R.id.tv_comment_book);

        GlideUtil.LoadCircleImage(context, evaluateModel.getImgUrl(), comment_head);
        commont_name.setText(evaluateModel.getNickname());
        commont_time.setText(evaluateModel.getUserDate());
        commont_score.setText("" + evaluateModel.getScore());
        tv_comment_content.setText(evaluateModel.getUserContent());

        tv_comment_guide.setVisibility(View.GONE);
        tv_comment_trip.setVisibility(View.GONE);
        tv_comment_car.setVisibility(View.GONE);
        tv_comment_book.setVisibility(View.GONE);

        if(evaluateModel.getGuideService() > 0 ){
            tv_comment_guide.setVisibility(View.VISIBLE);
            tv_comment_guide.setText(evaluateModel.getGuideServiceStr());
        }
        if(evaluateModel.getTravelArrange() > 0 ){
            tv_comment_trip.setVisibility(View.VISIBLE);
            tv_comment_trip.setText(evaluateModel.getTravelArrangeStr());
        }
        if(evaluateModel.getCarCondition() > 0){
            tv_comment_car.setVisibility(View.VISIBLE);
            tv_comment_car.setText(evaluateModel.getCarConditionStr());
        }
        if(evaluateModel.getBuyService() > 0){
            tv_comment_book.setVisibility(View.VISIBLE);
            tv_comment_book.setText(evaluateModel.getBuyServiceStr());
        }

        RecyclerView mRecyclerView = $(R.id.recycler_view);
        mRecyclerView.setNestedScrollingEnabled(false);//滑动取消
        mRecyclerView.setLayoutManager(new GridLayoutManager( mRecyclerView.getContext(), 4));
        SimpleImageAdapter enterAdapter = new SimpleImageAdapter(context, evaluateModel.getImageUrls());
        enterAdapter.setOnItemClickListener(new SimpleImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                BigImageActivity.startActivity(activity,position,evaluateModel.getImageUrls());
            }
        });
        mRecyclerView.setAdapter(enterAdapter);
    }

    //banner
    public void initBanner(List<BannerModel> banners) {
        //开始自动翻页
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView(new LocalImageHolderView.BannerListener<BannerModel>() {

                    @Override
                    public void bannerListener(Context context, int position, BannerModel data, ImageView view) {
                        GlideUtil.LoadImage(context, data.getImgUrl(), view);
                    }
                });
            }
        }, banners)
                .setPointViewVisible(true) //设置指示器是否可见
                .setPageIndicator(new int[]{R.drawable.oval_white_hollow, R.drawable.oval_theme_solid})//设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)//设置指示器的方向（左、中、右）
//                    .setOnItemClickListener(this) //设置点击监听事件
                .setManualPageable(true);//设置手动影响（设置了该项无法手动切换）
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // webview 需要加载空界面来释放资源
        webView.loadUrl("about:blank");
        webView.clearCache(false);
        webView.destroy();

        if(popService != null){
            popService.onDestroty();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_comment_title:
                if(guideDetailModel == null) return;
                Intent intent = new Intent(context, EvaluateListActivity.class);
                intent.putExtra(EvaluateListActivity.GUIDEID,guideDetailModel.getId());
                startActivity(intent);
                break;
            case R.id.btn_call:
                if(guideDetailModel == null) return;
                DialogUtil.getInstance().showGuideMobileDialog(context,guideDetailModel.getMobile());
                break;
            case R.id.ll_select_service:
            case R.id.btn_submit:
                if (!MySelfInfo.getInstance().isLogin()) {//登录状态
                    startActivity(new Intent(context,LoginActivity.class));
                    return ;
                }
                showPopService();
                break;
            case R.id.right_iv:
                if(guideDetailModel == null) return;
                ShareDialog dialog = new ShareDialog(activity,
                        guideDetailModel.getGuideName()+"向导",
                        TextUtils.isEmpty(guideDetailModel.getIntroduce())?"赶快约TA一起体验当地的风土人情吧！":guideDetailModel.getIntroduce(),
                        guideDetailModel.getGuideImg(),
                        URLConstant.SHARE_GUIDE+"?location="+MySelfInfo.getInstance().getDefaultCity()+"&guideId="+guideDetailModel.getId());
                dialog.setReportData(guideDetailModel.getId(), ShareDialog.REPORT_GUIDE);
                dialog.setType(ShareDialog.TYPE_ALL);
                dialog.show();
                break;
            case R.id.tv_back_top:
                scrollView.scrollTo(0, 0);
                break;

        }
    }

    private void showPopService() {

        if (guideDetailModel == null
                || guideDetailModel.getTravelGuideServiceInfoVOs() == null
                || guideDetailModel.getTravelGuideServiceInfoVOs().size() == 0) {
            ToastUtil.showShortToast(context, "没有可供选择的服务项");
            return;
        }

        if (popService == null) {
            popService = new PopService(activity, btn_submit,guideDetailModel);
            popService.initData(guideDetailModel.getId(), guideDetailModel.getTravelGuideServiceInfoVOs());
        }
        popService.showPopupWindow(btn_submit);
    }

    @Override
    public void bannerFindByTypeSuccess(List<BannerModel> models) {
        initBanner(models);
    }

    @Override
    public void bannerFindByTypeFailed(String msg) {
        showShortToast(msg);
    }

    @Override
    public void guideFindGuideDetailsSuccess(GuideDetailModel model) {
        guideDetailModel = model;
        initInfo(model);
    }

    @Override
    public void guideFindGuideDetailsFailed(String msg) {
        showShortToast(msg);
    }
}
