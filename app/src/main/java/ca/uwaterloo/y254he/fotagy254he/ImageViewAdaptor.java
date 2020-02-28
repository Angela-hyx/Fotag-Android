package ca.uwaterloo.y254he.fotagy254he;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


public class ImageViewAdaptor extends BaseAdapter {
    private Context context;
    private Model model;
    private ArrayList<ImageViews> imageViews;
    private ArrayList<Images> display;

    public ImageViewAdaptor(Context context, Model model) {
        this.context = context;
        this.model = model;
        imageViews = new ArrayList<>();
        filter();
    }

    public void filter() {
        display = new ArrayList<>();
        int current = model.getFilterValue();
        ArrayList<Images> imgs = model.getImages();
        int length = imgs.size();

        for (int i=0; i<length; ++i) {
            Images img = imgs.get(i);
            int rating = img.getRating();
            if (current == 0 || rating >= current) {
                display.add(img);
            }
        }
    }

    public int getCount() {
        return display.size();
    }

    public Images getItem(int p) {
        return display.get(p);
    }

    public long getItemId(int p) {
        return p;
    }


    public View getView(int position, View view, ViewGroup viewGroup) {
        View iview = LayoutInflater.from(context).inflate(R.layout.image_view, viewGroup, false);
        Images img = getItem(position);
        ImageViews imgView = new ImageViews(context, model, img, iview);
        imgView.update(imgView);
        imageViews.add(imgView);
        View rview = imgView.getView();
        return rview;

    }

}