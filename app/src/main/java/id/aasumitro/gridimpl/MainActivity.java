package id.aasumitro.gridimpl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import id.aasumitro.gridimpl.grid.AdapterGrid;
import id.aasumitro.gridimpl.recycler.AdapterRecycler;
import id.aasumitro.gridimpl.recycler.ModelRecycler;

public class MainActivity extends AppCompatActivity {

    private GridView mGrid;
    private RecyclerView mRecycler;

    public static final String[] TITLES = {
            "UP","DOWN","LEFT", "RIGHT"
    };

    public static final int[] IMAGES = {
            R.drawable.ic_arrow_upward_black_24dp,
            R.drawable.ic_arrow_downward_black_24dp,
            R.drawable.ic_arrow_back_black_24dp,
            R.drawable.ic_arrow_forward_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();
        populateRecyclerView();
        initGridView();
    }

    private void initView(){
        mRecycler = findViewById(R.id.recycler_view);
        mGrid = findViewById(R.id.grid_view);
    }

    private void initRecyclerView() {
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false));
    }

    private void populateRecyclerView() {
        ArrayList<ModelRecycler> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new ModelRecycler(TITLES[i],IMAGES[i]));
        }
        AdapterRecycler adapter = new AdapterRecycler(MainActivity.this, arrayList);
        mRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initGridView(){
        mGrid.setAdapter(new AdapterGrid(this, TITLES, IMAGES));
        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "DOWN", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

}
