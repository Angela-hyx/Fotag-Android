package ca.uwaterloo.y254he.fotagy254he;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;



public class Toolbar implements Observers {

    private View view;
    private Context context;
    private Model model;

    private ImageButton clearButton;
    private ImageButton loadButton;
    private ImageButton clearRatingBar;
    private RatingBar ratingBar;
    private Drawable filledStar;
    private Drawable unfilledStar;


    public Toolbar(final Context context, final Model model) {
        this.model = model;
        this.context = context;
        model.addObserver(this);

        unfilledStar = ContextCompat.getDrawable(context, R.drawable.ic_action_star);
        filledStar = ContextCompat.getDrawable(context, R.drawable.ic_action_star_filled);

        view = ((Activity) context).findViewById(R.id.toolbar);
        clearButton = view.findViewById(R.id.clear);
        loadButton = view.findViewById(R.id.load);
        ratingBar = view.findViewById(R.id.ratingBar_toolbar);
        clearRatingBar = view.findViewById(R.id.clearRatingBar);



        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.clearImages();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.clearImages();
                model.addImages();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                model.setFilterValue((int)rating);
                model.notifyObservers();
            }
        });

        clearRatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setRating(0F);
            }
        });

    }

    public void update(Object observable) {
    }
}
