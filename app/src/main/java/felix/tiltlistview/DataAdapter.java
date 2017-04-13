package felix.tiltlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by felix on 17-4-13.
 */

public class DataAdapter extends BaseAdapter {
    private Context mContext;
    private List<DataBean> mCell;
    private LayoutInflater mLayoutInflater;

    public DataAdapter(Context context, List<DataBean> dataBeen) {
        mContext = context;
        mCell = dataBeen;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public Object getItem(int position) {
        return mCell.get(position);
    }

    @Override
    public int getCount() {
        return mCell.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.data_item, parent, false);
            viewHolder = new ViewHolder(mContext, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = ((ViewHolder) convertView.getTag());
        }
        viewHolder.setData(position, mCell.get(position), mCell.size());
        return convertView;
    }

    class ViewHolder {
        private Context mContext;
        private View mView;
        private TextView mTextViewFirst;
        private TextView mTextViewSecond;

        public ViewHolder(Context context, View view) {
            mContext = context;
            mView = view;
            mTextViewFirst = findViewById(R.id.tv_first);
            mTextViewSecond = findViewById(R.id.tv_second);
        }

        protected void setData(int position, DataBean data, int size) {
            mTextViewFirst.setText(data.getTitle());
            mTextViewSecond.setText(data.getName());
        }

        protected <T extends View> T findViewById(int id) {
            return ((T) mView.findViewById(id));
        }
    }
}
