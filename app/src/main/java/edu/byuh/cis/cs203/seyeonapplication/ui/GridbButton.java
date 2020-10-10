package edu.byuh.cis.cs203.seyeonapplication.ui;



import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.RectF;
import android.view.MotionEvent;


import edu.byuh.cis.cs203.seyeonapplication.R;

public class GridbButton {

    //composition
    private RectF bounds;
    private Bitmap buttonImage, pressedImage; //store buttonImage
    private char label;  //make it invisible
    int size;
    boolean buttonPressed;//indicating whether the button is "pressed" or not.


    /**
     * constructur make buttonImage to be scaled
     *
     * @param res
     * @param size
     * @param x
     * @param y
     * @param label
     */

    public GridbButton(Resources res, int size, float x, float y, char label) { //modeling size of button

        buttonImage = BitmapFactory.decodeResource(res, R.drawable.button);
        buttonImage = Bitmap.createScaledBitmap(buttonImage, size, size, true);
        pressedImage = BitmapFactory.decodeResource(res, R.drawable.pressed_button);
        pressedImage = Bitmap.createScaledBitmap(pressedImage, size, size, true);
        bounds = new RectF(x, y, x + size, y + size); //size
        this.size = size;
        this.label = label;
        buttonPressed = false;


    } // at least this parameter

    /**
     * this method check bounds cantains x,y cordinace.
     * @param x
     * @param y
     * @return
     */

    public boolean contains(float x, float y) {
        if(bounds.contains(x,y)){
            return true;
        }else {
            return false;

        }

    }

    public char getLabel() {
        return label;
    }



    /**
     * when we call press method it make buttonpressed true
     */
    public void press() {
        buttonPressed = true;


    }


    public void release() {
        buttonPressed = false;
    }

    /**
     * drawbutton image depends on buttonpressed value
     * @param c
     */
    public void drawButton(Canvas c) {
        if (buttonPressed) {
            c.drawBitmap(pressedImage, bounds.left, bounds.top, null);
        } else { //make when we relae button change image
            c.drawBitmap(buttonImage, bounds.left, bounds.top, null);
        }
    }

}
