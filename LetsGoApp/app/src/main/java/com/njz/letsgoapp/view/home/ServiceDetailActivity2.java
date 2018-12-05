package com.njz.letsgoapp.view.home;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.base.BaseFragmentAdapter;
import com.njz.letsgoapp.bean.home.ServiceItem;
import com.njz.letsgoapp.bean.server.ServerDetailMedel;
import com.njz.letsgoapp.constant.Constant;
import com.njz.letsgoapp.dialog.DialogUtil;
import com.njz.letsgoapp.dialog.ShareDialog;
import com.njz.letsgoapp.map.MapActivity;
import com.njz.letsgoapp.mvp.other.BannerContract;
import com.njz.letsgoapp.mvp.other.BannerPresenter;
import com.njz.letsgoapp.mvp.server.ServerDetailContract;
import com.njz.letsgoapp.mvp.server.ServerDetailPresenter;
import com.njz.letsgoapp.util.StringUtils;
import com.njz.letsgoapp.util.glide.GlideUtil;
import com.njz.letsgoapp.util.rxbus.RxBus2;
import com.njz.letsgoapp.util.rxbus.busEvent.ServiceDetailCloseEvent;
import com.njz.letsgoapp.view.home.serverFragment.ServerEvaluateFragment;
import com.njz.letsgoapp.view.home.serverFragment.ServerFeatureFragment;
import com.njz.letsgoapp.view.home.serverFragment.ServerOtherFragment;
import com.njz.letsgoapp.widget.GuideLabelView;
import com.njz.letsgoapp.widget.MyRatingBar;
import com.njz.letsgoapp.widget.ServiceTagView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/12/4
 * Function: ServiceDetailActivity2单个服务详情，ServiceDetailActivity为导游进入的服务详情。
 */

public class ServiceDetailActivity2 extends ServiceDetailActivity implements ServerDetailContract.View,BannerContract.View{
    public RelativeLayout rl_person_info;
    public ImageView iv_head,iv_sex;
    public TextView tv_name;
    public MyRatingBar myRatingBar;
    public GuideLabelView guideLabelView;
    public ServiceTagView serviceTagView;

    ServerDetailMedel serverDetailMedel;

    private ServerDetailPresenter serverDetailPresenter;
    private BannerPresenter bannerPresenter;

    public String[] titles = {"服务特色", "TA的评价", "其他服务"};

    public  void initViewPage(ServerDetailMedel model){
        mFragments = new ArrayList<>();
        mFragments.add(ServerFeatureFragment.newInstance(model));
        mFragments.add(ServerEvaluateFragment.newInstance());
        mFragments.add(ServerOtherFragment.newInstance(model.getGuideId(),model.getId()));

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void initData() {
        bannerPresenter = new BannerPresenter(context,this);
        serverDetailPresenter = new ServerDetailPresenter(context, this);

        serverDetailPresenter.serveGuideServeOrder(serviceId);
        bannerPresenter.bannerFindByType(0,serviceId);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:

                break;
            case R.id.tv_phone:
                if(serverDetailMedel == null) return;
                DialogUtil.getInstance().showGuideMobileDialog(context,serverDetailMedel.getMobile());
                break;
            case R.id.tv_destination2:
                startActivity(new Intent(context, MapActivity.class));
                break;
            case R.id.tv_back_top:
//                scrollView.scrollTo(0, 0);
                break;
            case R.id.right_iv:
                if(serverDetailMedel == null) return;
                ShareDialog dialog = new ShareDialog(activity,"","","","");
                dialog.setReportData(serverDetailMedel.getId(), ShareDialog.REPORT_SERVICE);
                dialog.setType(ShareDialog.TYPE_REPORT);
                dialog.show();
                break;
        }
    }

    public void initPersonInfo(ServerDetailMedel model){
        rl_person_info = $(R.id.rl_person_info);
        rl_person_info.setVisibility(View.VISIBLE);

        iv_head = $(R.id.iv_head);
        iv_sex = $(R.id.iv_sex);
        tv_name = $(R.id.tv_name);
        myRatingBar = $(R.id.my_rating_bar);
        guideLabelView = $(R.id.guide_label);
        serviceTagView = $(R.id.stv_tag);

        GlideUtil.LoadCircleImage(context, model.getGuideImg(),iv_head);
        iv_sex.setImageDrawable(ContextCompat.getDrawable(context,model.getGender() == 2?R.mipmap.icon_girl:R.mipmap.icon_boy));
        tv_name.setText(model.getName());
        myRatingBar.setRating((int) model.getScore());
        guideLabelView.setTabel(model.getSigns());
        List<String> servicetag = new ArrayList<>();
        if(!TextUtils.isEmpty(model.getAge()))
            servicetag.add(model.getAge());
        if(!TextUtils.isEmpty(model.getServiceAge()))
            servicetag.add(model.getServiceAge());
        if(model.getLanguages() != null && model.getLanguages().size() != 0)
            servicetag.addAll(model.getLanguages());
        serviceTagView.setServiceTag(servicetag);

        rl_person_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 导游详情
            }
        });
    }

    public void initDetail(ServerDetailMedel model) {
        tv_title.setText(model.getTitle());
        if(TextUtils.isEmpty(model.getAddress())){
            tv_destination.setVisibility(View.GONE);
        }else{
            tv_destination.setText(model.getAddress());
            tv_destination.setVisibility(View.VISIBLE);
        }

        StringUtils.setHtml(tv_destination2, getResources().getString(R.string.destination2));

        tv_sell.setText("已售:" + model.getSellCount());
        pv_price.setPrice(model.getServePrice());

        initViewPage(model);

    }

    @Override
    public void serveGuideServeOrderSuccess(ServerDetailMedel str) {
        serverDetailMedel = str;
        initDetail(str);
        initPersonInfo(str);
    }

    @Override
    public void serveGuideServeOrderFailed(String msg) {

    }
}
