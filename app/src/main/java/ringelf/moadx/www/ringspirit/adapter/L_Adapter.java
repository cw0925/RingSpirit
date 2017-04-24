package ringelf.moadx.www.ringspirit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ringelf.moadx.www.ringspirit.Entity.L_SongEntity;
import ringelf.moadx.www.ringspirit.Entity.R_SongEntity;
import ringelf.moadx.www.ringspirit.R;

/**
 * Created by cw on 16/10/19.
 */

public class L_Adapter extends BaseAdapter {

    private List<L_SongEntity> mList;
    private LayoutInflater mInflater;

    public L_Adapter(Context context, List<L_SongEntity> list){
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

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
        L_Adapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new L_Adapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.r_item, null);
            viewHolder.serial = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.author = (TextView) convertView.findViewById(R.id.tv_author);
            viewHolder.time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.count = (TextView) convertView.findViewById(R.id.tv_count);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (L_Adapter.ViewHolder) convertView.getTag();
        }
        L_SongEntity songEntity = mList.get(position);
        viewHolder.serial.setText(""+(position+1));
        viewHolder.name.setText(songEntity.getTitle());
        viewHolder.author.setText(songEntity.getContentProvider());
        viewHolder.time.setText(songEntity.getStatus());
        viewHolder.count.setText("播放次数"+songEntity.getClick());
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
