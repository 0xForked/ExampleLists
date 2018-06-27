package id.aasumitro.gridimpl.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import id.aasumitro.gridimpl.R;

public class HolderRecycler
        extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    public TextView mTitle;
    public ImageView mImage;

    HolderRecycler(View view) {
        super(view);
        this.mTitle = view.findViewById(R.id.titleList);
        this.mImage = view.findViewById(R.id.imgList);

        RelativeLayout mLay = view.findViewById(R.id.lay_click);
        mLay.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (getPosition()) {
            case 0:
                Log.d("RecyclerView", "UP");
                break;
            case 1:
                Log.d("RecyclerView", "DOWN");
                break;
            case 2:
                Log.d("RecyclerView", "LEFT");
                break;
            case 3:
                Log.d("RecyclerView", "RIGHT");
                break;
        }
    }

}
