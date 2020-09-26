package edu.byuh.cis.cs203.seyeonapplication.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import edu.byuh.cis.cs203.seyeonapplication.ui.GridbButton;

public class MyView extends View {

    private Paint p1;
    private float startX, startY, endX;

    private float lineWidth;
    private GridbButton button1;
    private GridbButton button2;
    private GridbButton button3;
    private GridbButton button4;
    private GridbButton button5;
    private GridbButton button6;
    private GridbButton button7;
    private GridbButton button8;
    private GridbButton button9;
    private GridbButton button10;







    public MyView(Context c) {
        super(c);
        p1 = new Paint();
        p1.setColor(Color.BLACK);








    }

    /**
     * This method put buttonimage specific location
     * @param c
     */
    @Override
    public void onDraw(Canvas c) {
        float w = getWidth();
        float h = getHeight();
        startX = w * 0.155f; //rectwidth
        startY = h * 0.228f;
        endX = startX *6;//draw same width value by using startx
        lineWidth = w *0.0113f;
        p1.setStrokeWidth(lineWidth);
        int buttonWidth =(int) startX; //the same as cell width
        button1 = new GridbButton(getResources(),buttonWidth,(w-startX*6)/6,startY+(startX) ,'1');
        button2 = new GridbButton(getResources(),buttonWidth,(w-startX*6)/6, startY, '2');
        button3 = new GridbButton(getResources(),buttonWidth,(w-startX*6)/6,startY+(startX*2),'3');
        button4 = new GridbButton(getResources(),buttonWidth,(w-startX*6)/6, startY+(startX*3),'4');
        button5 = new GridbButton(getResources(),buttonWidth,(w-startX*6)/6, startY+(startX*4),'5');
        button6 = new GridbButton(getResources(),buttonWidth,startX, startY-startX,'A');
        button7 = new GridbButton(getResources(),buttonWidth,startX*2, startY-startX,'B');
        button8 = new GridbButton(getResources(),buttonWidth,startX*3, startY-startX,'C');
        button9 = new GridbButton(getResources(),buttonWidth,startX*4, startY-startX,'D');
        button10 = new GridbButton(getResources(),buttonWidth,startX*5, startY-startX,'E');

        button1.drawButton(c);
        button2.drawButton(c);
        button3.drawButton(c);
        button4.drawButton(c);
        button5.drawButton(c);
        button6.drawButton(c);
        button7.drawButton(c);
        button8.drawButton(c);
        button9.drawButton(c);
        button10.drawButton(c);



    //draw horizental
        for (int i = 0; i < 6; i++) {
            c.drawLine(startX, startY+(startX*i), endX,startY+(startX*i),p1);

        }
        //draw verticall
        for (int i = 1; i <7; i++) {
            c.drawLine(startX*i,startY,startX*i,startY+(startX*5),p1);
        }
    }

}

