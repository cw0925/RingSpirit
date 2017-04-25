package ringelf.moadx.www.ringspirit.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ringelf.moadx.www.ringspirit.R;
import ringelf.moadx.www.ringspirit.customnavigationbar.NavigationBar;

/**
 * Created by cw on 16/10/18.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private NavigationBar topbar;//导航栏

    private TextView tv_recommend;
    private TextView tv_latest;
    private TextView tv_hot;
    private TextView tv_topic;

    private ViewPager recommend_viewPager;
    private FragmentPagerAdapter radapter;
    private List<Fragment> LFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initEvent();
    }
    private void initView() {

        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_home);
        topbar.setTitle("首页");

        tv_recommend = (TextView) getActivity().findViewById(R.id.tv_recommend);
        tv_latest = (TextView) getActivity().findViewById(R.id.tv_latest);
        tv_hot = (TextView) getActivity().findViewById(R.id.tv_hot);
        tv_topic = (TextView) getActivity().findViewById(R.id.tv_topic);

        tv_recommend.setTextColor(Color.rgb(252,50,89));
        recommend_viewPager = (ViewPager) getActivity().findViewById(R.id.recommend_viewpager);

        LFragment = new ArrayList<Fragment>();
        Fragment FRecommend = new RecommendFragment();
        Fragment FLatest = new LatestFragment();
        Fragment FHot = new HotFragment();
        Fragment FTopic = new TopicFragment();

        LFragment.add(FRecommend);
        LFragment.add(FLatest);
        LFragment.add(FHot);
        LFragment.add(FTopic);

        radapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return LFragment.get(position);
            }

            @Override
            public int getCount() {
                return LFragment.size();
            }
        };
        recommend_viewPager.setAdapter(radapter);

        recommend_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                int currentItem = recommend_viewPager.getCurrentItem();
//                setSelect(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void initEvent() {
        tv_recommend.setOnClickListener(this);
        tv_latest.setOnClickListener(this);
        tv_hot.setOnClickListener(this);
        tv_topic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setBackgroundDark();
        switch (v.getId()){
            case R.id.tv_recommend:
                tv_recommend.setTextColor(Color.rgb(252,50,89));
                recommend_viewPager.setCurrentItem(0);
                break;
            case R.id.tv_latest:
                tv_latest.setTextColor(Color.rgb(252,50,89));
                recommend_viewPager.setCurrentItem(1);
                break;
            case R.id.tv_hot:
                tv_hot.setTextColor(Color.rgb(252,50,89));
                recommend_viewPager.setCurrentItem(2);
                break;
            case R.id.tv_topic:
                tv_topic.setTextColor(Color.rgb(252,50,89));
                recommend_viewPager.setCurrentItem(3);
                break;
        }

    }
    private void setBackgroundDark() {

        tv_recommend.setTextColor(Color.rgb(0,0,0));
        tv_latest.setTextColor(Color.rgb(0,0,0));
        tv_hot.setTextColor(Color.rgb(0,0,0));
        tv_topic.setTextColor(Color.rgb(0,0,0));

    }
}
