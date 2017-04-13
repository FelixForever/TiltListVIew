package felix.tiltlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by felix on 17-4-13.
 */

public class MyListView extends ListView {
    private final static String TAG = MyListView.class.getSimpleName();
    private Matrix mMatrix = new Matrix();
    private float degress = 10;

    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float[] values = new float[]{1, 0, 0, degress / 45f, 1, 0, 0, 0, 1};
        mMatrix.setValues(values);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        canvas.save();
        canvas.concat(mMatrix);
        boolean bool = super.drawChild(canvas, child, drawingTime);
        canvas.restore();
        return bool;
    }
}
