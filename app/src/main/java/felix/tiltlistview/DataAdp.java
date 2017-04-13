package felix.tiltlistview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import felix.tiltlistview.Base.BaseAdp;
import felix.tiltlistview.Base.BaseVH;

/**
 * Created by felix on 17-4-13.
 */

public class DataAdp extends BaseAdp<DataAdp.MyViewHolder, DataBean> {

    public DataAdp(Context context, List<DataBean> cell) {
        super(context, cell);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.data_item;
    }

    @Override
    protected MyViewHolder getVH(Context context, View view) {
        return new MyViewHolder(context, view);
    }

    class MyViewHolder extends BaseVH<DataBean> {
        private TextView mTextViewFirst;
        private TextView mTextViewSecond;

        public MyViewHolder(Context context, View view) {
            super(context, view);
            mTextViewFirst = findViewById(R.id.tv_first);
            mTextViewSecond = findViewById(R.id.tv_second);
        }

        @Override
        protected void setData(int position, DataBean data, int size) {
            super.setData(position, data, size);
            mTextViewFirst.setText(data.getTitle());
            mTextViewSecond.setText(data.getName());
        }
    }
}
