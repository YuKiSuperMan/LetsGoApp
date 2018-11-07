package com.njz.letsgoapp.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.njz.letsgoapp.R;
import com.njz.letsgoapp.util.glide.GlideUtil;

import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/8/24
 * Function:
 */

public class DynamicImageView2 extends LinearLayout {

    LinearLayout ll_top, ll_left, ll_left2, ll_right,ll_bottom;
    ImageView iv_left1, iv_left21, iv_left22, iv_right1, iv_right2, iv_bottom1, iv_bottom2,iv_bottom3;

    Context context;

    public DynamicImageView2(Context context) {
        this(context, null);
    }

    public DynamicImageView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicImageView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.view_dynamic_image2, this, true);

        this.context = context;

        ll_top = findViewById(R.id.ll_top);
        ll_left = findViewById(R.id.ll_left);
        ll_left2 = findViewById(R.id.ll_left2);
        ll_right = findViewById(R.id.ll_right);
        ll_bottom = findViewById(R.id.ll_bottom);

        iv_left1 = findViewById(R.id.iv_left1);
        iv_left21 = findViewById(R.id.iv_left21);
        iv_left22 = findViewById(R.id.iv_left22);
        iv_right1 = findViewById(R.id.iv_right1);
        iv_right2 = findViewById(R.id.iv_right2);
        iv_bottom1 = findViewById(R.id.iv_bottom1);
        iv_bottom2 = findViewById(R.id.iv_bottom2);
        iv_bottom3 = findViewById(R.id.iv_bottom3);


    }

    private void setVisibility(){
        ll_top.setVisibility(GONE);
        ll_left.setVisibility(GONE);
        ll_left2.setVisibility(GONE);
        ll_right.setVisibility(GONE);
        ll_bottom.setVisibility(GONE);

        iv_left1.setVisibility(GONE);
        iv_left21.setVisibility(GONE);
        iv_left22.setVisibility(GONE);
        iv_right1.setVisibility(GONE);
        iv_right2.setVisibility(GONE);
        iv_bottom1.setVisibility(GONE);
        iv_bottom2.setVisibility(GONE);
        iv_bottom3.setVisibility(GONE);
    }


    public void setImages(List<String> datas) {
        setVisibility();
        if (datas == null || datas.size() == 0) {
            return;
        }

        ll_top.setVisibility(VISIBLE);
        ll_left.setVisibility(VISIBLE);

        switch (datas.size()) {
            case 1:
                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                break;
            case 2:
                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                ll_right.setVisibility(VISIBLE);
                iv_right1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(1), iv_right1,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                setOnclick(iv_right1,1);
                break;
            case 3:
                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                ll_right.setVisibility(VISIBLE);
                iv_right1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(1), iv_right1,R.mipmap.dynamic_default);

                ll_left2.setVisibility(VISIBLE);
                iv_left21.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(2), iv_left21,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                setOnclick(iv_right1,1);
                setOnclick(iv_left21,2);
                break;
            case 4:
                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                ll_right.setVisibility(VISIBLE);
                iv_right1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(1), iv_right1,R.mipmap.dynamic_default);

                ll_left2.setVisibility(VISIBLE);
                iv_left21.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(2), iv_left21,R.mipmap.dynamic_default);

                iv_left22.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(3), iv_left22,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                setOnclick(iv_right1,1);
                setOnclick(iv_left21,2);
                setOnclick(iv_left22,3);
                break;
            case 5:
                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                ll_right.setVisibility(VISIBLE);
                iv_right1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(1), iv_right1,R.mipmap.dynamic_default);

                ll_bottom.setVisibility(VISIBLE);
                iv_bottom1.setVisibility(VISIBLE);
                iv_bottom2.setVisibility(VISIBLE);
                iv_bottom3.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(2), iv_bottom1,R.mipmap.dynamic_default);
                GlideUtil.LoadDefaultImage(context, datas.get(3), iv_bottom2,R.mipmap.dynamic_default);
                GlideUtil.LoadDefaultImage(context, datas.get(4), iv_bottom3,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                setOnclick(iv_right1,1);
                setOnclick(iv_bottom1,2);
                setOnclick(iv_bottom2,3);
                setOnclick(iv_bottom3,4);

                break;
            default:

                iv_left1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(0), iv_left1,R.mipmap.dynamic_default);

                ll_right.setVisibility(VISIBLE);
                iv_right1.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(1), iv_right1,R.mipmap.dynamic_default);

                iv_right2.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(2), iv_right2,R.mipmap.dynamic_default);

                ll_bottom.setVisibility(VISIBLE);
                iv_bottom1.setVisibility(VISIBLE);
                iv_bottom2.setVisibility(VISIBLE);
                iv_bottom3.setVisibility(VISIBLE);
                GlideUtil.LoadDefaultImage(context, datas.get(3), iv_bottom1,R.mipmap.dynamic_default);
                GlideUtil.LoadDefaultImage(context, datas.get(4), iv_bottom2,R.mipmap.dynamic_default);
                GlideUtil.LoadDefaultImage(context, datas.get(5), iv_bottom3,R.mipmap.dynamic_default);

                setOnclick(iv_left1,0);
                setOnclick(iv_right1,1);
                setOnclick(iv_right2,2);
                setOnclick(iv_bottom1,3);
                setOnclick(iv_bottom2,4);
                setOnclick(iv_bottom3,5);
                break;

        }
    }

    private void setOnclick(View view, final int position){
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
