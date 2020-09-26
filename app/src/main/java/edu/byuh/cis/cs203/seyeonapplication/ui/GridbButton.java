package edu.byuh.cis.cs203.seyeonapplication.ui;



import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.RectF;




import edu.byuh.cis.cs203.seyeonapplication.R;

public class GridbButton {

    //composition
    private RectF bounds;
    private Bitmap buttonImage; //store buttonImage
    private char label;  //make it invisible
    int size;


    /**
     * constructur make buttonImage to be scaled
     * @param res
     * @param size
     * @param x
     * @param y
     * @param label
     */

    public GridbButton(Resources res, int size,float x, float y,char label){ //modeling size of button

        buttonImage = BitmapFactory.decodeResource(res,R.drawable.button);
        buttonImage = Bitmap.createScaledBitmap(buttonImage, size, size, true);

        bounds = new RectF(x,y, x+size,y+size); //size
        //this.label = label;



    } // at least this parameter

    /**
     * drawbuttom image
     * @param c
     */

    public void drawButton(Canvas c){

        c.drawBitmap(buttonImage, bounds.left,bounds.top,null);
    }


}
