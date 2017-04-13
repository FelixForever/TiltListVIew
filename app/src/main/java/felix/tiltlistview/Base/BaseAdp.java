package felix.tiltlistview.Base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by felix on 17-4-13.
 */

public abstract class BaseAdp<VH extends BaseVH, T> extends RecyclerView.Adapter<VH> {
    protected Context mContext;
    protected List<T> mCell;
    protected final LayoutInflater mLayoutInflater;

    public BaseAdp(Context context, List<T> cell) {
        mContext = context;
        mCell = cell;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setData(position, mCell.get(position), mCell.size());
    }

    @Override
    public int getItemCount() {
        return mCell.size();
    }

    abstract protected int getLayoutId(int viewType);

    abstract protected VH getVH(Context context, View view);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        final int layoutId = getLayoutId(viewType);
        final View view = mLayoutInflater.inflate(layoutId, parent, false);
        return getVH(mContext, view);
    }

}
