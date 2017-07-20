package com.example.administrator.nestword;

import android.animation.Animator;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.List;

import me.wangyuwei.slackloadingview.SlackLoadingView;
import okhttp3.Call;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    private TextView mTextView;
    private AMapLocationClientOption mLocationOption;
    private String mUrl;
    private TextView mWeather;
    private LinearLayout mImageView;
    private ImageView iv_weather;
    private TextView mCity;
    private TextView mWendu;
    private TextView mFeng_dengji;
    private TextView mPm;
    private ListView mListView;
    private SlackLoadingView mView;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mView.stopNestedScroll();
            mView.reset();
            ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0f, 1, 0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

            scaleAnimation.setDuration(500);
            scaleAnimation.setFillAfter(true);
            mRl_loading.startAnimation(scaleAnimation);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mRl_loading.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }
    };
    private RelativeLayout mRl_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getSupportActionBar().hide();
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();
        getLocation();
    }

    private void initView() {
        mRl_loading = (RelativeLayout) findViewById(R.id.rl_loading);
        mListView = (ListView) findViewById(R.id.listview);
        mCity = (TextView) findViewById(R.id.city);
        mWendu = (TextView) findViewById(R.id.wendu);
        mFeng_dengji = (TextView) findViewById(R.id.feng_dengji);
        mPm = (TextView) findViewById(R.id.pm);
        mUrl = "http://api.avatardata.cn/Weather/Query?key=4f210ce66e4f4a719f98044bf380bf46&cityname=";
        mImageView = (LinearLayout) findViewById(R.id.bg);
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                int cx = (mImageView.getLeft() + mImageView.getRight()) / 2;
                //圆形动画的y坐标  位于View的中心
                int cy = (mImageView.getTop() + mImageView.getBottom()) / 2;
                //起始大小半径
                float startX = 0f;
                //结束大小半径 大小为图片对角线的一半
                float startY = (float) Math.sqrt(cx * cx + cy * cy);
                Animator animator = ViewAnimationUtils.createCircularReveal(mImageView, cx, cy, startX, startY);
                //在动画开始的地方速率改变比较慢,然后开始加速
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(500);
                animator.start();
            }
        });
        mView = (SlackLoadingView) findViewById(R.id.loading);
        mView.setVisibility(View.VISIBLE);
        mView.start();
    }

    public void getLocation() {
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                mCity.setText(aMapLocation.getCity());
                System.out.println(aMapLocation.getCity());
                mUrl = mUrl + aMapLocation.getCity();
                OkGo.post(mUrl).execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        parseJson(s);
                    }
                });
            }
        };
        AMapLocationClient aMapLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        aMapLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(false);
        mLocationOption.setNeedAddress(true);
        //给定位客户端对象设置定位参数
        aMapLocationClient.setLocationOption(mLocationOption);
        //启动定位
        aMapLocationClient.startLocation();
    }

    private void parseJson(String s) {
        try {
            Gson gson = new Gson();
            WeathBean weathBean = gson.fromJson(s, WeathBean.class);
            List<WeathBean.ResultBean.WeatherBeanX> weather = weathBean.getResult().getWeather();
            WeathBean.ResultBean.WeatherBeanX.InfoBeanX info = weather.get(0).getInfo();
            String s1 = info.getDay().get(2);
            mWendu.setText(s1 + "℃");
            String s2 = info.getDay().get(3) + info.getDay().get(4);
            mFeng_dengji.setText(s2);
            mPm.setText(weathBean.getResult().getPm25().getPm25().getDes());
            setAdapter(weather);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAdapter(List<WeathBean.ResultBean.WeatherBeanX> weather) {
        mListView.setAdapter(new MyAdapter(weather));
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private class MyAdapter extends BaseAdapter {

        private final List<WeathBean.ResultBean.WeatherBeanX> weather;

        MyAdapter(List<WeathBean.ResultBean.WeatherBeanX> weather) {
            this.weather = weather;
        }

        @Override
        public int getCount() {
            return weather.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder;
            if (convertView == null) {
                convertView = View.inflate(WeatherActivity.this, R.layout.weather_item, null);
                holder = new Holder();
                holder.item_day = (TextView) convertView.findViewById(R.id.item_day);
                holder.item_weather = (TextView) convertView.findViewById(R.id.item_weather);
                holder.item_wendu = (TextView) convertView.findViewById(R.id.item_wendu);
                convertView.setTag(holder);

            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.item_day.setText("星期" + weather.get(position).getWeek());
            holder.item_weather.setText(weather.get(position).getInfo().getDay().get(1));
            holder.item_wendu.setText(weather.get(position).getInfo().getNight().get(2) + "/" + weather.get(position).getInfo().getDay().get(2));
            return convertView;
        }

        class Holder {
            TextView item_day;
            TextView item_weather;
            TextView item_wendu;
        }
    }

}
