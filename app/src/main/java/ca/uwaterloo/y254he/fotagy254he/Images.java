package ca.uwaterloo.y254he.fotagy254he;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class Images {
    private int rating;
    private int img_id;
    private Model model;
    private Context context;
    private Bitmap bitmap;

    public Images(int id, Model model, Context context) {
        rating = 0;
        img_id = id;
        this.context = context;
        this.model = model;
        bitmap = BitmapFactory.decodeResource(context.getResources(), img_id);
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }
    public Bitmap getBitmap() { return bitmap; }
}
