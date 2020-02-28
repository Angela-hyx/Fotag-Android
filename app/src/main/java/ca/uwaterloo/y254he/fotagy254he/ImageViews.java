package ca.uwaterloo.y254he.fotagy254he;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;


public class ImageViews extends LinearLayout implements Observers {

    private Images image;
    private View view;
    private RatingBar ratingBar;
    private ImageButton clearButton;
    private Model model;
    ImageView imageView;

    public ImageViews(Context context,final  Model model, final Images image, View view) {
        super(context);

        this.image = image;
        this.view = view;
        this.model = model;

        ratingBar = view.findViewById(R.id.ratingBar);
        int rating = image.getRating();
        ratingBar.setRating(rating);

        clearButton = view.findViewById(R.id.clearbutton);

//        imageView = view.findViewById(R.id.image);
//        imageView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
////                imageView.setAdjustViewBounds(true);
//                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            }
//        });

        this.view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ImageViews.this.view.getContext(), R.style.FullScreen);
                dialog.setContentView(R.layout.image_view_full);
                imageView = dialog.findViewById(R.id.image_full);
                Bitmap bitmap = image.getBitmap();
                imageView.setImageBitmap(bitmap);
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                dialog.setCancelable(true);
                dialog.show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setRating((int)rating);
                model.notifyObservers();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar.setRating(0F);
            }
        });
    }

    public View getView() {
        return view;
    }

    public void update(Object observable) {
        ImageView iv = view.findViewById(R.id.image);
        Bitmap bitmap = image.getBitmap();
        iv.setImageBitmap(bitmap);
    }
}