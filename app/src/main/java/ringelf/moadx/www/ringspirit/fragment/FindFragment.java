package ringelf.moadx.www.ringspirit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ringelf.moadx.www.ringspirit.R;
import ringelf.moadx.www.ringspirit.customnavigationbar.NavigationBar;

/**
 * Created by cw on 16/10/18.
 */

public class FindFragment extends Fragment {
    private NavigationBar topbar;//导航栏
    private WebView web;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_find,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        //导航栏设置
        topbar = (NavigationBar) getActivity().findViewById(R.id.navi_find);
        topbar.setTitle("发现");

        web = (WebView) getActivity().findViewById(R.id.webview);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://app.modown.cc/R/index.aspx?type=RingElf");
    }

}
