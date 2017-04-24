package ringelf.moadx.www.ringspirit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpCycleContext;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.JsonArrayHttpRequestCallback;
import cn.finalteam.okhttpfinal.RequestParams;
import okhttp3.Headers;
import ringelf.moadx.www.ringspirit.Entity.R_SongEntity;
import ringelf.moadx.www.ringspirit.R;
import ringelf.moadx.www.ringspirit.adapter.R_Adapter;

/**
 * Created by cw on 16/10/18.
 */

public class RecommendFragment extends Fragment implements HttpCycleContext {

    private ListView list_recommend;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recommend,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initView();

    }

    private void initView() {
        list_recommend = (ListView) getActivity().findViewById(R.id.list_recommend);
    }

    //请求网络数据
    private void initData() {
//http://app.modown.cc/API/Api.ashx?d=1&resType=3&method=GetResSpecial&id=312&order=0&ps=20&pn=1
        RequestParams params = new RequestParams(this);
        params.addFormDataPart("d","1");
        params.addFormDataPart("resType", "3");
        params.addFormDataPart("method", "GetResSpecial");
        params.addFormDataPart("id", "312");
        params.addFormDataPart("order", "0");
        params.addFormDataPart("ps", "20");
        params.addFormDataPart("pn", "1");
        HttpRequest.post("http://app.modown.cc/API/Api.ashx",params,new JsonArrayHttpRequestCallback(){
            @Override
            protected void onSuccess(JSONArray objects) {
                super.onSuccess(objects);
                List<R_SongEntity>  itemList = new ArrayList<>();

                for (int i = 0;i<objects.size();i++){
                    R_SongEntity song = new R_SongEntity();
                    JSONObject item = (JSONObject)objects.get(i);
                    song.setContentProvider(item.getString("ContentProvider"));
                    song.setTitle(item.getString("Title"));
                    song.setClick(item.getInteger("Click"));
                    song.setStatus(item.getString("Status"));

                    itemList.add(song);
                    list_recommend.setAdapter(new R_Adapter(getContext(),itemList));
                }
            }
        });
    }

    @Override
    public String getHttpTaskKey() {
        return null;
    }
}
