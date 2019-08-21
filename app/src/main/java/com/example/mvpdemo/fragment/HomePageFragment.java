package com.example.mvpdemo.fragment;

import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.mvpdemo.R;
import com.example.mvpdemo.activity.FourActivity;
import com.example.mvpdemo.activity.RecyclerViewActivity;
import com.example.mvpdemo.activity.SecondActivity;
import com.example.mvpdemo.activity.TextInputActivity;
import com.example.mvpdemo.activity.ThreeActivity;
import com.example.mvpdemo.base.mvp.BaseFragment;
import com.example.mvpdemo.bean.HomeDataBean;
import com.example.mvpdemo.iview.IHomePageView;
import com.example.mvpdemo.presenter.HomePagePresenter;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements IHomePageView, View.OnClickListener {
    private static final String TAG = "HomePageFragment";
    private Button btnRequest, btn_three, btn_four, btn_snackBar, btn_recyclerView, textInput;
    private ToggleButton toggleBtn;


    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView(final View view) {
        btnRequest = getView(view, R.id.btn_request);
        btn_three = getView(view, R.id.btn_three);
        btn_four = getView(view, R.id.btn_four);
        btn_snackBar = getView(view, R.id.btn_snackBar);
        btn_recyclerView = getView(view, R.id.btn_recyclerView);
        toggleBtn = getView(view, R.id.toggleBtn);
        textInput = getView(view, R.id.btn_textInput);
        btnRequest.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_snackBar.setOnClickListener(this);
        btn_recyclerView.setOnClickListener(this);
        textInput.setOnClickListener(this);

        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showToastMsg("onCheckedChanged：" + isChecked);
            }
        });
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.getHomePageData("0", "1", getActivity());
            presenter.getBannerData("0", "1", getActivity());
        }
    }

    @Override
    public void updateHomeData(List<HomeDataBean> data) {
        Log.e(TAG, "updateHomeData：" + data.toString());
    }

    @Override
    public void updateBannerData(List<HomeDataBean> data) {
        Log.e(TAG, "updateBannerData：" + data.toString());
    }

    @Override
    public HomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_request://CoordinatorLayout
                SecondActivity.open(getActivity());
                break;
            case R.id.btn_three://CoordinatorLayout
                ThreeActivity.open(getActivity());
                break;
            case R.id.btn_four://CoordinatorLayout
                FourActivity.open(getActivity());
                break;
            case R.id.btn_snackBar://snackBar
                /**
                 * 参数3：
                 * Snackbar.LENGTH_INDEFINITE：不确定时间，只有右滑删除或者点击action按钮才可以删除。
                 * Snackbar.LENGTH_SHORT：时间较短。
                 * Snackbar.LENGTH_LONG：时间较长。
                 */
                //Snackbar.make(btn_snackBar, "这是一个snackBar", Snackbar.LENGTH_SHORT).show();//标准方法1
                //扩展方法2
                final Snackbar snackbar = Snackbar.make(btn_snackBar, "方法1，这是一个snackBar", Snackbar.LENGTH_SHORT);
                /**
                 * 1、设置一个action,Snackbar不支持设置多个action，如果设置多个action，只有最后一个生效。
                 * 2、如果listener不为null，那么在Snackbar右侧会显示一个按钮 eg取消按钮,
                 *      点击这个按钮，底层代码会调用销毁Snackbar的程序，相当于调用了Snackbar的dismiss方法。
                 * 3、当Snackbar在CoordinatorLayout下使用时，支持右滑删除功能
                 */
                snackbar.setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                //设置文本方法2，会覆盖方法1的文本
                snackbar.setText("方法2，这是一个snackBar");
                //设置action文本颜色，默认是红色
//                snackbar.setActionTextColor(Color.parseColor("#0000ff"));
                //设置Snackbar背景色，默认黑色
//                snackbar.getView().setBackgroundColor(Color.parseColor("#ff00ff"));
                //设置padding，默认就很合适，不做修改
//                snackbar.getView().setPadding(100, 100, 100, 100);
                /**
                 * 在文本前面添加图片
                 * 1、先获取 snackBar 中的 textView
                 * 2、得到要添加的图片对象
                 * 3、将图片添加到 textView 的前面
                 */
                TextView textView = snackbar.getView().findViewById(R.id.snackbar_text);
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher_round);//图片自己选择
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                textView.setCompoundDrawables(drawable, null, null, null);
                //增加文字和图标的距离
                textView.setCompoundDrawablePadding(20);
                textView.setGravity(Gravity.CENTER);
                snackbar.show();
                break;
            case R.id.btn_recyclerView://recyclerView
                RecyclerViewActivity.open(getActivity());
                break;
            case R.id.btn_textInput://textInput
                TextInputActivity.open(getActivity());
                break;
            default:
                break;
        }
    }
}
