package ringelf.moadx.www.ringspirit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ringelf.moadx.www.ringspirit.R;

/**
 * Created by cw on 16/10/18.
 */

public class BaseActivity extends FragmentActivity {
    private TextView title;
    private TextView left_title;
    private TextView right_title;
    private LinearLayout left_line;
    private LinearLayout right_line;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initView();
    }
    private void initView(){
        super.setContentView(R.layout.base_head);
        left_title = (TextView) findViewById(R.id.left_title);
        right_title = (TextView) findViewById(R.id.right_title);
        title = (TextView) findViewById(R.id.tv_title);
        left_line = (LinearLayout) findViewById(R.id.left_bar);
        right_line = (LinearLayout) findViewById(R.id.right_bar);

    }
    /**
     * 是否显示返回按钮
     * @param leftTitle  文字
     * @param show  true则显示
     */
    protected void showBackwardView(String leftTitle, boolean show) {
        if (left_line != null) {
            if (show) {
                left_line.setVisibility(View.VISIBLE);
                left_title.setText(leftTitle);
            } else {
                left_line.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * 提供是否显示提交按钮
     * @param rightTitle  文字
     * @param show  true则显示
     */
    protected void showForwardView(String rightTitle, boolean show) {
        if (right_line!= null) {
            if (show) {
                right_line.setVisibility(View.VISIBLE);
                right_title.setText(rightTitle);
            } else {
                right_line.setVisibility(View.INVISIBLE);
            }
        } // else ignored
    }

    /**
     * 返回按钮点击后触发
     * @param backwardView
     */
    protected void onBackward(View backwardView) {
        Toast.makeText(this, "点击返回，可在此处调用finish()", Toast.LENGTH_LONG).show();
        //finish();
    }

    /**
     * 提交按钮点击后触发
     * @param forwardView
     */
    protected void onForward(View forwardView) {
        Toast.makeText(this, "点击提交", Toast.LENGTH_LONG).show();
    }
    //设置标题内容
    public void setTitle(String midTitle) {
        title.setText(midTitle);
    }
}
