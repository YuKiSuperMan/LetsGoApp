package com.njz.letsgoapp.view.home.serverFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.base.EndlessRecyclerOnScrollListener;
import com.njz.letsgoapp.adapter.base.LoadMoreWrapper;
import com.njz.letsgoapp.adapter.home.EvaluateAdapter;
import com.njz.letsgoapp.adapter.home.ServerListAdapter1;
import com.njz.letsgoapp.adapter.home.ServerListAdapter2;
import com.njz.letsgoapp.base.BaseFragment;
import com.njz.letsgoapp.bean.home.EvaluateModel2;
import com.njz.letsgoapp.bean.home.GuideDetailModel;
import com.njz.letsgoapp.bean.home.GuideServiceModel;
import com.njz.letsgoapp.bean.home.PlayData;
import com.njz.letsgoapp.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/12/4
 * Function:
 */

public class ServerListFragment extends BaseFragment {
    GuideDetailModel model;
    RecyclerView recycler_view1,recycler_view2;
    private ServerListAdapter1 mAdapter1;
    private ServerListAdapter2 mAdapter2;

    private LoadMoreWrapper loadMoreWrapper;
    private int page;
    private int isLoadType = 1;//1下拉刷新，2上拉加载
    private boolean isLoad = false;//是否在加载，重复加载问题

    public static Fragment newInstance(GuideDetailModel guideDetailModel) {
        ServerListFragment fragment = new ServerListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("GuideDetailModel", guideDetailModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            model = bundle.getParcelable("GuideDetailModel");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_server_list;
    }

    @Override
    public void initView() {
        initRecycler1();
        initRecycler2();
    }

    @Override
    public void initData() {
        getRefreshData();
    }

    //初始化recyclerview
    private void initRecycler1() {
        recycler_view1 = $(R.id.recycler_view1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recycler_view1.setLayoutManager(linearLayoutManager);
        mAdapter1 = new ServerListAdapter1(activity, new ArrayList<GuideServiceModel>());
        recycler_view1.setAdapter(mAdapter1);
        recycler_view1.setNestedScrollingEnabled(false);

        mAdapter1.setOnItemClickListener(new ServerListAdapter1.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }
    private void initRecycler2() {
        recycler_view2 = $(R.id.recycler_view2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        recycler_view2.setLayoutManager(linearLayoutManager);
        mAdapter2 = new ServerListAdapter2(activity, new ArrayList<PlayData>());
        recycler_view2.setAdapter(mAdapter2);
        recycler_view2.setNestedScrollingEnabled(false);

        mAdapter2.setOnItemClickListener(new ServerListAdapter2.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }

    private void getRefreshData() {
        isLoad = true;
        page = Constant.DEFAULT_PAGE;
        isLoadType = 1;
        getData();
    }

    public void getData(){
        List<PlayData> datas = new ArrayList<>();
        PlayData data = new PlayData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543829470523&di=87de21d5e5ce4826a6d74b97deefb0b8&imgtype=0&src=http%3A%2F%2Fgotrip.zjol.com.cn%2Fxw14873%2Fycll14875%2F201710%2FW020171024603757884776.jpg",
                "长沙特色小吃游",300f,"长沙",4.8f,100,400);
        datas.add(data);
        datas.add(data);
        datas.add(data);
        mAdapter2.setDatas(datas);

        List<GuideServiceModel> datas2 = new ArrayList<>();
        GuideServiceModel item = new GuideServiceModel();
        item.setServiceType("私人定制");
        datas2.add(item);
        datas2.add(item);
        datas2.add(item);
        mAdapter1.setDatas(datas2);
    }
}
