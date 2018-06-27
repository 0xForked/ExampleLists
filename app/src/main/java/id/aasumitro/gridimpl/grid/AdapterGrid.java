package id.aasumitro.gridimpl.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.aasumitro.gridimpl.R;

public class AdapterGrid extends BaseAdapter {

    private Context mContext;
    private final String[] string;
    private final int[] Imageid;

    public AdapterGrid(Context context, String[] string, int[] Imageid ) {
        mContext = context;
        this.Imageid = Imageid;
        this.string = string;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            assert inflater != null;
            grid = inflater.inflate(R.layout.item_list, null);
            TextView textView = grid.findViewById(R.id.titleList);
            ImageView imageView = grid.findViewById(R.id.imgList);
            textView.setText(string[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = convertView;
        }

        return grid;
    }


}
