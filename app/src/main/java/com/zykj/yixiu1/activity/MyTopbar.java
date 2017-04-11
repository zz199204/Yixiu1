package com.zykj.yixiu1.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zykj.yixiu1.R;

/**
 * Created by zykj on 2017/4/11.
 */

public class MyTopbar extends RelativeLayout {
    //    定义属性标题
    private String titleText;
    private float titleTextSize;
    private int titleTextColor;
    //    定义属性标题
    private String rightText;
    private float rightTextSize;
    private int rightTextColor;
    //    定义属性作则
    private String lefttitleText;
    private float lefttitleTextSize;
    private int lefttitleTextColor;
    private Drawable leftBackground;
    //    定义空间属性
    private TextView title;
    private TextView righttitle;
    private Button leftButton;


    private Context context;

    public MyTopbar(Context context) {
        super(context);

    }

    public MyTopbar( Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        //初始化信息
        TypedArray kj = context.obtainStyledAttributes(attrs, R.styleable.Topbarrrrr);
        //标题控件取出
        titleText = kj.getString(R.styleable.Topbarrrrr_titleText);
        titleTextSize = kj.getDimension(R.styleable.Topbarrrrr_titleTextSize, 0);
        titleTextColor = kj.getColor(R.styleable.Topbarrrrr_titleTextColor, 0);

        //右侧板控件取出
        rightText = kj.getString(R.styleable.Topbarrrrr_rightText);
        rightTextSize = kj.getDimension(R.styleable.Topbarrrrr_rightTextSize, 0);
        rightTextColor = kj.getColor(R.styleable.Topbarrrrr_rightTextColor, 0);
        //左侧空间起初
        lefttitleText = kj.getString(R.styleable.Topbarrrrr_lefttitleText);
        lefttitleTextSize = kj.getDimension(R.styleable.Topbarrrrr_lefttitleTextSize, 0);
        lefttitleTextColor = kj.getColor(R.styleable.Topbarrrrr_lefttitleTextColor, 0);
        leftBackground = kj.getDrawable(R.styleable.Topbarrrrr_leftBackground);
        //创建空间
        title = new TextView(context);
        righttitle = new TextView(context);
        leftButton = new Button(context);
        title.setText(titleText);
        title.setTextSize(titleTextSize);
        title.setTextColor(titleTextColor);
        title.setGravity(Gravity.CENTER);

        righttitle.setText(rightText);
        righttitle.setTextSize(rightTextSize);
        righttitle.setTextColor(rightTextColor);
        righttitle.setGravity(Gravity.CENTER);


        //传入所有按钮的属性
        leftButton.setText(lefttitleText);
        leftButton.setTextSize(lefttitleTextSize);
        leftButton.setTextColor(lefttitleTextColor);
        leftButton.setBackgroundDrawable(leftBackground);

        //控制title 的位置
        LayoutParams titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT); //中间位置
        addView(title, titleParams);

        LayoutParams leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT); //左侧位置
        addView(leftButton, leftParams);

        LayoutParams rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT); //左侧位置
        addView(righttitle, rightParams);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.leftClick();
            }
        });
    }

    public MyTopbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TopBarClickListener clickListener; //成员变量用于映射外部传入的对象

    //对外提供的函数
    public void setTopBarOnClickListener(TopBarClickListener clickListener) {
        this.clickListener = clickListener;
    }

    //添加回调接口
    public interface TopBarClickListener {
        public void leftClick(); //左侧点击
    }


}
