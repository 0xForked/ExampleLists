package id.aasumitro.gridimpl.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.aasumitro.gridimpl.R;

public class AdapterRecycler extends
        RecyclerView.Adapter<HolderRecycler>  {

    private ArrayList<ModelRecycler> mArrayList;
    private Context mContext;

    public AdapterRecycler(Context context,
                           ArrayList<ModelRecycler> arrayList) {
        this.mContext = context;
        this.mArrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return (null != mArrayList ? mArrayList.size() : 0);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycler holder, int position) {
        final ModelRecycler model = mArrayList.get(position);
        Bitmap image = BitmapFactory.decodeResource(mContext.getResources(),
                model.getImage());
        holder.mTitle.setText(model.getTitle());
        holder.mImage.setImageBitmap(image);
    }

    @NonNull
    @Override
    public HolderRecycler onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_list, viewGroup, false);
        return new HolderRecycler(mainGroup);
    }
}
