package ca.uwaterloo.y254he.fotagy254he;


import android.content.Context;

import java.util.ArrayList;

public class Model {
    private ArrayList<Observers> observers;
    private Context context;
    private ArrayList<Images> images;
    private int FilterValue;

    public Model(Context context) {
        observers = new ArrayList<>();
        this.context = context;
        images = new ArrayList<>();
        FilterValue = 0;
    }

    public void setFilterValue(int value) {
        FilterValue = value;
    }
    public int getFilterValue() {
        return FilterValue;
    }

    public void addObserver(Observers observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for (Observers observer:this.observers) {
            observer.update(this);
        }
    }

    public void addImage(Images image) {
        images.add(image);
    }
    public void addImages() {
        Images pic1 = new Images(R.drawable.pic1, this, this.context);
        Images pic2 = new Images(R.drawable.pic2, this, this.context);
        Images pic3 = new Images(R.drawable.pic3, this, this.context);
        Images pic4 = new Images(R.drawable.pic4, this, this.context);
        Images pic5 = new Images(R.drawable.pic5, this, this.context);
        Images pic6 = new Images(R.drawable.pic6, this, this.context);
        Images pic7 = new Images(R.drawable.pic7, this, this.context);
        Images pic8 = new Images(R.drawable.pic8, this, this.context);
        Images pic9 = new Images(R.drawable.pic9, this, this.context);
        Images pic10 = new Images(R.drawable.pic10, this, this.context);

        addImage(pic1);
        addImage(pic2);
        addImage(pic3);
        addImage(pic4);
        addImage(pic5);
        addImage(pic6);
        addImage(pic7);
        addImage(pic8);
        addImage(pic9);
        addImage(pic10);

        notifyObservers();
    }

    public void clearImages() {
        images.clear();
        this.notifyObservers();
    }
    public ArrayList<Images> getImages() {
        return images;
    }

    public void setContext(Context context) {
        this.context = context;
    }



}
