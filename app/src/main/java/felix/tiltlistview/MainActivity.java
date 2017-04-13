package felix.tiltlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerView mRecyclerView;
    private DataAdp mDataAdp;
    private List<DataBean> mDataBeen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = ((MyRecyclerView) findViewById(R.id.rv_main));
        mDataBeen = DataBean.getDataList(40);
        mDataAdp = new DataAdp(this, mDataBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setAdapter(mDataAdp);
    }


}
