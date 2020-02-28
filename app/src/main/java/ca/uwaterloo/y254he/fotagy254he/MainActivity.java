package ca.uwaterloo.y254he.fotagy254he;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Observers {

    private Model model;

    private Toolbar toolbar;
    private GridView gridview;
    private ArrayList<ImageViews> imageviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        model = new Model(this);
        model.addObserver(this);

        toolbar = new Toolbar(this, model);
        imageviews = new ArrayList<>();
        gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageViewAdaptor(this, model));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            gridview.setNumColumns(1);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridview.setNumColumns(2);
        }
    }



    public void update(Object observable) {
        ((ImageViewAdaptor)gridview.getAdapter()).filter();
        ((ImageViewAdaptor)gridview.getAdapter()).notifyDataSetChanged();
    }
}