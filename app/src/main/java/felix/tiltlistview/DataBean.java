package felix.tiltlistview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 17-4-13.
 */

public class DataBean implements Parcelable {
    private String mTitle;
    private String mName;


    public static DataBean getDataBean(int position) {
        final DataBean dataBean = new DataBean();
        dataBean.setTitle("this is title " + position);
        dataBean.setName("this is name " + position);
        return dataBean;
    }

    public static List<DataBean> getDataList(int size) {
        List<DataBean> dataBeen = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dataBeen.add(getDataBean(i));
        }
        return dataBeen;

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mName);
    }

    public DataBean() {
    }

    protected DataBean(Parcel in) {
        this.mTitle = in.readString();
        this.mName = in.readString();
    }

    public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel source) {
            return new DataBean(source);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };
}
