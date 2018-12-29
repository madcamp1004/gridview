package com.example.q.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    //keep all Images in array
    public Integer[] mThumbIds={
            R.drawable.image1,R.drawable.image3,
            R.drawable.image12,R.drawable.image6,
            R.drawable.image9,R.drawable.image10,
            R.drawable.image11,R.drawable.image7,
            R.drawable.image8
    };
    //Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
    @Override
    public int getCount(){
        return mThumbIds.length;
    }
    @Override
    public Object getItem(int position){
        return mThumbIds[position];
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
       /*
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70,70));
        return imageView;*/
       ImageView image;
       if (convertView == null){
           LayoutInflater mInflater = ( LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = mInflater.inflate(R.layout.grid_item_view,null);
           image = (ImageView) convertView.findViewById(R.id.grid_item_image);
           image.setImageResource(mThumbIds[position]);
           int h = mContext.getResources().getDisplayMetrics().densityDpi;

           convertView.setLayoutParams(new GridView.LayoutParams(h,h));
           convertView.setTag(image);
       }else{
           image = (ImageView) convertView.getTag();
       }
        return convertView;
    }
}
