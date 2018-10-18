package com.njz.letsgoapp.view.find;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.find.DynamicCommentAdapter;
import com.njz.letsgoapp.base.BaseActivity;
import com.njz.letsgoapp.bean.EmptyModel;
import com.njz.letsgoapp.bean.MySelfInfo;
import com.njz.letsgoapp.bean.find.DynamicCommentModel;
import com.njz.letsgoapp.bean.home.DynamicModel;
import com.njz.letsgoapp.dialog.DialogUtil;
import com.njz.letsgoapp.dialog.ShareDialog;
import com.njz.letsgoapp.mvp.find.DynamicDeleteContract;
import com.njz.letsgoapp.mvp.find.DynamicDeletePresenter;
import com.njz.letsgoapp.mvp.find.DynamicDetailContract;
import com.njz.letsgoapp.mvp.find.DynamicDetailPresenter;
import com.njz.letsgoapp.mvp.find.DynamicNiceContract;
import com.njz.letsgoapp.mvp.find.DynamicNicePresenter;
import com.njz.letsgoapp.util.AppUtils;
import com.njz.letsgoapp.util.ToastUtil;
import com.njz.letsgoapp.util.glide.GlideUtil;
import com.njz.letsgoapp.view.mine.FansListActivity;
import com.njz.letsgoapp.view.mine.SpaceActivity;
import com.njz.letsgoapp.view.other.BigImageActivity;
import com.njz.letsgoapp.widget.DynamicImageView;
import com.njz.letsgoapp.widget.popupwindow.PopComment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/9/6
 * Function:
 */

public class DynamicDetailActivity extends BaseActivity implements DynamicDetailContract.View, DynamicNiceContract.View,DynamicDeleteContract.View, View.OnClickListener {

    public static final String FRIENDSTERID ="FRIENDSTERID";

    private ImageView ivImg;
    private TextView tvName, tvTime, tvContent, tvNice, tvComment, btnNiceContent, tvLocation,tvDelete;
    private DynamicImageView dynamicImageView;
//    private DynamicNiceImageView dynamicNiceImgView;
    private RelativeLayout rlNice;
    private RecyclerView recyclerView;

    private LinearLayout btnNice, btnComment;

    private PopComment popComment;

    private DynamicDetailPresenter mPresenter;
    private DynamicNicePresenter nicePresenter;
    private DynamicDeletePresenter deletePresenter;

    private int friendSterId;
    private DynamicCommentAdapter mAdapter;

    private DynamicModel model;
    private List<DynamicCommentModel> comments;

    private int toId;

    @Override
    public void getIntentData() {
        super.getIntentData();
        friendSterId = intent.getIntExtra(FRIENDSTERID, 0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dynamic_detail;
    }

    @Override
    public void initView() {

        showLeftAndTitle("动态详情");
        showRightIv();
        getRightIv().setImageDrawable(ContextCompat.getDrawable(AppUtils.getContext(), R.mipmap.icon_share));
        getRightIv().setOnClickListener(this);

        ivImg = $(R.id.iv_img);
        tvName = $(R.id.tv_name);
        tvTime = $(R.id.tv_time);
        tvContent = $(R.id.tv_content);
        tvNice = $(R.id.tv_nice);
        tvComment = $(R.id.tv_comment);
        tvDelete = $(R.id.tv_delete);
        dynamicImageView = $(R.id.dynamic_image_view);
//        dynamicNiceImgView = $(R.id.dynamic_nice_img_view);
        rlNice = $(R.id.rl_nice);
        recyclerView = $(R.id.recycler_view);
        btnNice = $(R.id.btn_nice);
        btnComment = $(R.id.btn_comment);
        tvLocation = $(R.id.tv_location);
        btnNiceContent = $(R.id.btn_nice_content);
        recyclerView.setNestedScrollingEnabled(false);
        initRecycler();

        popComment = new PopComment(context, btnComment);
        popComment.setSendClickLisener(new PopComment.OnSendClickLisener() {
            @Override
            public void send(String content) {
                //id,toId,content,dynamicId
//                MySelfInfo.getInstance().getUserId();//id
//                model.getFriendSterId();//dynamicId
//                toId;//toId
                mPresenter.friendDiscuss(model.getFriendSterId(),MySelfInfo.getInstance().getUserId(),content,toId);

            }
        });

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popComment.setEtHint("说点什么吧...");
                popComment.showPop(btnComment);
                toId = 0;
            }
        });

        dynamicImageView.setOnItemClickListener(new DynamicImageView.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                BigImageActivity.startActivity((Activity) context, position, model.getImgUrls());
            }
        });

        rlNice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFans = new Intent(context, FansListActivity.class);
                intentFans.putExtra(FansListActivity.TITLE, "点赞列表");
                intentFans.putExtra(FansListActivity.TYPE, 2);
                intentFans.putExtra(FansListActivity.USER_ID, model.getFriendSterId());
                startActivity(intentFans);
            }
        });

        btnNice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nicePresenter.friendQueryLikes(model.isLike(), model.getFriendSterId());
            }
        });

        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SpaceActivity.class);
                intent.putExtra(SpaceActivity.USER_ID, model.getUserId());
                startActivity(intent);
            }
        });


        tvDelete.setVisibility(View.GONE);
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.getInstance().getDefaultDialog(context, "您是否确认删除动态?", new DialogUtil.DialogCallBack() {
                    @Override
                    public void exectEvent(DialogInterface alterDialog) {
                        deletePresenter.friendDeleteFriendSter(model.getFriendSterId());
                    }
                }).show();
            }
        });
    }

    //初始化recyclerview
    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        mAdapter = new DynamicCommentAdapter(activity, new ArrayList<DynamicCommentModel>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new DynamicCommentAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                if (comments.get(position).getDiscussUserId() == MySelfInfo.getInstance().getUserId()){
                    ToastUtil.showShortToast(context, "不能回复自己");
                    return;
                }

                popComment.setEtHint("回复 " + model.getDynamicComments().get(position).getDiscussUserName());
                popComment.showPop(btnComment);
                toId = comments.get(position).getDiscussUserId();
            }
        });
    }

    public void initViewData() {
        GlideUtil.LoadCircleImage(context, model.getImgUrl(), ivImg);
        tvName.setText(model.getNickname());
        tvTime.setText(model.getStartTime());
        tvContent.setText(model.getContent());
        tvNice.setText(model.getLikeCount() + "人点赞");
        tvComment.setText(model.getReplyCount() + "条评论");
        dynamicImageView.setImages(model.getImgUrls());
//        dynamicNiceImgView.setImages(model.getImgUrls());
        setNice(model.isLike());
        tvLocation.setText(model.getLocation());

        mAdapter.setData(model.getDynamicComments());

        if(MySelfInfo.getInstance().getUserId() == model.getUserId()){
            tvDelete.setVisibility(View.VISIBLE);
        }else{
            tvDelete.setVisibility(View.GONE);
        }

    }

    public void setNice(boolean isNice) {
        if (isNice) {
            btnNiceContent.setText("已赞");
        } else {
            btnNiceContent.setText("赞");
        }
    }

    @Override
    public void initData() {
        mPresenter = new DynamicDetailPresenter(context, this);
        nicePresenter = new DynamicNicePresenter(context, this);
        deletePresenter = new DynamicDeletePresenter(context,this);

        mPresenter.friendPersonalFriendSter(friendSterId);
    }

    @Override
    public void friendPersonalFriendSterSuccess(DynamicModel model) {
        this.model = model;
        this.comments = model.getDynamicComments();
        initViewData();
    }

    @Override
    public void friendPersonalFriendSterFailed(String msg) {
        showShortToast(msg);
    }

    @Override
    public void friendDiscussSuccess(DynamicCommentModel comment) {
        comments.add(comment);
        mAdapter.setData(comments);
        model.setReplyCount(model.getReplyCount() + 1);
        tvComment.setText(model.getReplyCount() + "条评论");
        recyclerView.scrollToPosition(comments.size()-1);
        AppUtils.HideKeyboard(tvComment);
    }

    @Override
    public void friendDiscussFailed(String msg) {
        showShortToast(msg);
        AppUtils.HideKeyboard(tvComment);
    }

    @Override
    public void friendQueryLikesSuccess(EmptyModel models) {
        model.setLike(!model.isLike());
        if(model.isLike()){
            model.setLikeCount(model.getLikeCount() + 1);
        }else{
            model.setLikeCount(model.getLikeCount() - 1);
        }
        tvNice.setText(model.getLikeCount() + "人点赞");
        setNice(model.isLike());
    }

    @Override
    public void friendQueryLikesFailed(String msg) {
        showShortToast(msg);
    }


    @Override
    public void friendDeleteFriendSterSuccess(EmptyModel models) {
        finish();
        showShortToast("删除成功");
    }

    @Override
    public void friendDeleteFriendSterFailed(String msg) {
        showShortToast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.right_iv:
                if(model == null) return;
                ShareDialog dialog = new ShareDialog(activity,
                        model.getShareTitle(),
                        model.getShareContent(),
                        model.getShareImg(),
                        model.getShareUrl());
                dialog.show();
                break;
        }

    }
}
