package felix.tiltlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerView mRecyclerView;
    private ListView mListView;
    private DataAdp mDataAdp;
    private List<DataBean> mDataBeen;
    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBeen = DataBean.getDataList(40);
        initListView();
    }

    private void initRecyclerView() {
        setContentView(R.layout.activity_main);
        mRecyclerView = ((MyRecyclerView) findViewById(R.id.rv_main));

        mDataAdp = new DataAdp(this, mDataBeen);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setAdapter(mDataAdp);
    }

    private void initListView() {
        setContentView(R.layout.activity_main_listview);
        mListView = ((ListView) findViewById(R.id.rv_main));

        mDataAdapter = new DataAdapter(this, mDataBeen);
        mListView.setAdapter(mDataAdapter);
    }


}
