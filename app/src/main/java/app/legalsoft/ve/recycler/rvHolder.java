package app.legalsoft.ve.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.legalsoft.ve.R;

/**
 * Created by Syed.Rahman on 14/03/2015.
 */
public class rvHolder extends RecyclerView.ViewHolder {

    ImageView menuIcon;
    TextView menuText;

    public rvHolder(View itemView) {
        super(itemView);

        menuIcon = (ImageView)itemView.findViewById(R.id.mIcon);
        menuText = (TextView)itemView.findViewById(R.id.mText);
    }

}
