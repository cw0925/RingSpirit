package ringelf.moadx.www.ringspirit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ringelf.moadx.www.ringspirit.R;
import ringelf.moadx.www.ringspirit.customnavigationbar.NavigationBar;

/**
 * Created by cw on 16/10/18.
 */

public class MyFragment extends Fragment {
    private NavigationBar topbar;//导航栏
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter simple_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.cate_7_normal,R.drawable.cate_7_normal,R.drawable.cate_7_normal};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_my);
        topbar.setTitle("我的");

        gview = (GridView) getActivity().findViewById(R.id.gv_my);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image"};
        int[] to = {R.id.gv_item_my};
        simple_adapter = new SimpleAdapter(getContext(), data_list, R.layout.gv_my, from, to);
        //配置适配器
        gview.setAdapter(simple_adapter);
        //点击事件
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            //map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
