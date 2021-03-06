package felix.tiltlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by felix on 17-4-13.
 */

public class MyRecyclerView extends RecyclerView {
    private final static String TAG = MyRecyclerView.class.getSimpleName();
    private Matrix mMatrix = new Matrix();
    private float degress = 10;

    public MyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        float[] values = new float[]{1, 0, 0, degress / 45f, 1, 0, 0, 0, 1};
        mMatrix.setValues(values);

        // mMatrix.setsca
    }

    @Override
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        canvas.save();
        canvas.concat(mMatrix);
        boolean bool = super.drawChild(canvas, child, drawingTime);
        canvas.restore();
        return bool;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        int widthSize = MeasureSpec.getSize(widthSpec);
        int heightSize = MeasureSpec.getSize(heightSpec);
        int extra = ((int) (widthSize * 1.0 * Math.tan(degress / 45.0)));
        Log.i(TAG, "onMeasure: " + heightSize + " extra=" + extra);
        Log.i(TAG, "onMeasure: " + widthSize);
        setMeasuredDimension(widthSize, heightSize + extra);
    }


//    @Override
//    public View findChildViewUnder(float x, float y) {
//        final int count = mChildHelper.getChildCount();
//        for (int i = count - 1; i >= 0; i--) {
//            final View child = mChildHelper.getChildAt(i);
//            final float translationX = ViewCompat.getTranslationX(child);
//            final float translationY = ViewCompat.getTranslationY(child);
//            if (x >= child.getLeft() + translationX &&
//                    x <= child.getRight() + translationX &&
//                    y >= child.getTop() + translationY &&
//                    y <= child.getBottom() + translationY) {
//                return child;
//            }
//        }
//        return super.findChildViewUnder(x, y);
//    }

    @Override
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }
}
