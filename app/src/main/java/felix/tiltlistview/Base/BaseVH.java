package felix.tiltlistview.Base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by felix on 17-4-13.
 */

public class BaseVH<T> extends RecyclerView.ViewHolder {
    protected Context mContext;
    protected View mView;

    public BaseVH(Context context, View view) {
        super(view);
        mView = view;
        mContext = context;
    }

    protected <T extends View> T findViewById(int id) {
        return ((T) mView.findViewById(id));
    }

    protected void setData(int position, T data, int size) {

    }
}