package com.njz.letsgoapp.view.homeFragment.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.adapter.base.BaseFragmentAdapter;
import com.njz.letsgoapp.base.BaseFragment;
import com.njz.letsgoapp.view.order.OrderListFragment;
import com.njz.letsgoapp.widget.myTabLayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/7/23
 * Function:
 */

public class OrderFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> mFragments;
    private String[] titles = {"待付款", "已付款", "已完成", "退款单"};
    private int[] payStatus = {0,1,2,3};

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView() {

        mTabLayout = $(R.id.tab_layout);
        mViewPager = $(R.id.viewpager);

    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(OrderListFragment.newInstance(payStatus[0]));
        mFragments.add(OrderListFragment.newInstance(payStatus[1]));
        mFragments.add(OrderListFragment.newInstance(payStatus[2]));
        mFragments.add(OrderListFragment.newInstance(payStatus[3]));

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getChildFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
    }


}