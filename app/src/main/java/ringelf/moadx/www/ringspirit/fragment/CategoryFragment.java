package ringelf.moadx.www.ringspirit.fragment;

import android.content.Intent;
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
import ringelf.moadx.www.ringspirit.activity.RingActivity;

/**
 * Created by cw on 16/10/18.
 */

public class CategoryFragment extends Fragment {

    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter simple_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.cate_7_normal,R.drawable.cate_2_normal,R.drawable.cate_5_normal,R.drawable.cate_104_normal,R.drawable.cate_6_normal,R.drawable.cate_4_normal,R.drawable.cate_3_normal,R.drawable.cate_101_normal,R.drawable.cate_102_normal,R.drawable.cate_8_normal,R.drawable.cate_103_normal};
    private String[] iconName = {"搞笑铃声", "手机铃声", "短信铃声", "闹钟铃声", "特效铃声", "游戏铃声", "影视动漫", "轻音乐", "DJ铃声", "网友上传", "其他铃声"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        gview = (GridView) getActivity().findViewById(R.id.gridview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.gv_img, R.id.gv_name};
        simple_adapter = new SimpleAdapter(getContext(), data_list, R.layout.gridview_item, from, to);
        //配置适配器
        gview.setAdapter(simple_adapter);
        //点击事件
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RingActivity.class);
                startActivity(intent);
            }
        });
    }
    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}
