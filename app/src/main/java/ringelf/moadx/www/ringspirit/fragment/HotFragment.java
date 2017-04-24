package ringelf.moadx.www.ringspirit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.okhttpfinal.HttpCycleContext;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.JsonArrayHttpRequestCallback;
import cn.finalteam.okhttpfinal.RequestParams;
import ringelf.moadx.www.ringspirit.Entity.H_SongEntity;
import ringelf.moadx.www.ringspirit.Entity.L_SongEntity;
import ringelf.moadx.www.ringspirit.R;
import ringelf.moadx.www.ringspirit.adapter.H_Adapter;
import ringelf.moadx.www.ringspirit.adapter.L_Adapter;

/**
 * Created by cw on 16/10/18.
 */

public class HotFragment extends Fragment implements HttpCycleContext {
    private ListView list_hot;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_hot,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();

    }
    private void initData() {
        //http://app.modown.cc/API/Api.ashx?d=1&resType=3&method=GetResListByCate&id=0&order=1&ps=20&pn=1
        RequestParams params = new RequestParams(this);
        params.addFormDataPart("d","1");
        params.addFormDataPart("resType", "3");
        params.addFormDataPart("method", "GetResListByCate");
        params.addFormDataPart("id", "0");
        params.addFormDataPart("order", "1");
        params.addFormDataPart("ps", "20");
        params.addFormDataPart("pn", "1");
        HttpRequest.post("http://app.modown.cc/API/Api.ashx",params,new JsonArrayHttpRequestCallback(){
            @Override
            protected void onSuccess(JSONArray objects) {
                super.onSuccess(objects);
                List<H_SongEntity> itemList = new ArrayList<>();
                for (int i = 0;i<objects.size();i++){
                    H_SongEntity song = new H_SongEntity();
                    JSONObject item = (JSONObject)objects.get(i);
                    song.setContentProvider(item.getString("ContentProvider"));
                    song.setTitle(item.getString("Title"));
                    song.setClick(item.getInteger("Click"));
                    song.setStatus(item.getString("Status"));

                    itemList.add(song);
                    //Log.i("song", "onSuccess: "+song.getTitle());
                    list_hot.setAdapter(new H_Adapter(getContext(),itemList));
                }
            }
        });
    }

    private void initView() {
        list_hot = (ListView) getActivity().findViewById(R.id.list_hot);
    }

    @Override
    public String getHttpTaskKey() {
        return null;
    }
}
