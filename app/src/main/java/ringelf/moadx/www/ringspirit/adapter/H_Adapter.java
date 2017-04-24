package ringelf.moadx.www.ringspirit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ringelf.moadx.www.ringspirit.Entity.H_SongEntity;
import ringelf.moadx.www.ringspirit.Entity.R_SongEntity;
import ringelf.moadx.www.ringspirit.R;

/**
 * Created by cw on 2016/10/18.
 */

public class H_Adapter extends BaseAdapter {

    private List<H_SongEntity> mList;
    private LayoutInflater mInflater;

    public H_Adapter(Context context, List<H_SongEntity> list){
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

//    public R_Adapter(JsonArrayHttpRequestCallback jsonArrayHttpRequestCallback, List<R_SongEntity> itemList) {
//    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //文艺式
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.r_item, null);
            viewHolder.serial = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.author = (TextView) convertView.findViewById(R.id.tv_author);
            viewHolder.time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.count = (TextView) convertView.findViewById(R.id.tv_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        H_SongEntity songEntity = mList.get(position);
        viewHolder.serial.setText(""+(position+1));
        viewHolder.name.setText(songEntity.getTitle());
        viewHolder.author.setText(songEntity.getContentProvider());
        //时间转换255->04:15
//        Integer i = Integer.valueOf(songEntity.getStatus());
//        Integer a = i/60;
//        Integer b = i%60;
//        viewHolder.time.setText(""+a+":"+""+b);
        viewHolder.time.setText(songEntity.getStatus());
        viewHolder.count.setText("播放次数:"+songEntity.getClick());
        return convertView;
    }

    class ViewHolder{

        public TextView serial;
        public TextView name;
        public TextView author;
        public TextView time;
        public TextView count;

    }
}
