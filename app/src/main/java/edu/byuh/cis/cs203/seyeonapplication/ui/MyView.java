package edu.byuh.cis.cs203.seyeonapplication.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import edu.byuh.cis.cs203.seyeonapplication.logic.GameBoard;

public class MyView extends View implements TickListener{

    private Paint p1;
    private float startX, startY, endX;

    private float lineWidth;
    private boolean mathDone;
    private boolean buttonTrack;
    private ArrayList<GridToken> tokens;
    private GridbButton[] leftLine;
    private GridbButton[] aboveLine;
    private GridToken token;
    private GameBoard player;
    private Timer timer;


    public MyView(Context c) {
        super(c);
        p1 = new Paint();
        p1.setColor(Color.BLACK);
        // buttons = new GridbButton[10];
        mathDone = false;
        tokens = new ArrayList<>();
        leftLine = new GridbButton[5];
        aboveLine = new GridbButton[5];

    }



        /**
         * This method put buttonimage specific location
         *
         * @param c
         */
        @Override
        public void onDraw(Canvas c) {
            if (mathDone == false) {
                float w = getWidth();
                float h = getHeight();
                startX = w * 0.155f; //rectwidth
                startY = h * 0.228f;
                endX = startX * 6;//draw same width value by using startx
                lineWidth = w * 0.0113f;
                p1.setStrokeWidth(lineWidth);
                int buttonWidth = (int) startX; //the same as cell width

                leftLine[0] = new GridbButton(getResources(), buttonWidth, (w - startX * 6) / 6, startY, 'A');//
                leftLine[1] = new GridbButton(getResources(), buttonWidth, (w - startX * 6) / 6, startY + (startX), 'B');//
                leftLine[2] = new GridbButton(getResources(), buttonWidth, (w - startX * 6) / 6, startY + (startX * 2), 'C');//
                leftLine[3] = new GridbButton(getResources(), buttonWidth, (w - startX * 6) / 6, startY + (startX * 3), 'D');//
                leftLine[4] = new GridbButton(getResources(), buttonWidth, (w - startX * 6) / 6, startY + (startX * 4), 'E');//

                aboveLine[0] = new GridbButton(getResources(), buttonWidth, startX, startY - startX, '1');//
                aboveLine[1] = new GridbButton(getResources(), buttonWidth, startX * 2, startY - startX, '2');//
                aboveLine[2] = new GridbButton(getResources(), buttonWidth, startX * 3, startY - startX, '3');//
                aboveLine[3] = new GridbButton(getResources(), buttonWidth, startX * 4, startY - startX, '4');//
                aboveLine[4] = new GridbButton(getResources(), buttonWidth, startX * 5, startY - startX, '5');//

                timer = new Timer();
                for (GridToken token: tokens) {
                    timer.register(token);

                }
                timer.register(this);//regist view class
                mathDone = true;
            }

            for (GridToken gr : tokens) {
                gr.drawToken(c);
            }


            for (GridbButton g : leftLine) {
                g.drawButton(c);

            }

            for (GridbButton g : aboveLine) {
                g.drawButton(c);
            }

            //draw horizental
            for (int i = 0; i < 6; i++) {
                c.drawLine(startX, startY + (startX * i), endX, startY + (startX * i), p1);

            }
            //draw verticall
            for (int i = 1; i < 7; i++) {
                c.drawLine(startX * i, startY, startX * i, startY + (startX * 5), p1);
            }
        }


        @Override
        public boolean onTouchEvent(MotionEvent m) {

            float w = getWidth();
            float h = getHeight();
            startX = w * 0.155f; //rectwidth
            startY = h * 0.228f;


            //create left sind of array button


            if (m.getAction() == MotionEvent.ACTION_DOWN) {
                float x = m.getX();
                float y = m.getY();


                buttonTrack = false;

                for (GridbButton g : leftLine) {
                    if (g.contains(x, y)) {
                        g.press();
                        buttonTrack = true;

                        token = new GridToken(getResources(), (int)startX, (w - startX * 6) / 6, startY);
                        token.setVelocity(new PointF(5, 0));
                        tokens.add(token);

                        invalidate();

                    }


                }


                for (GridbButton g : aboveLine) {
                    if (g.contains(x, y)) {
                        token = new GridToken(getResources(), (int)startX, startX, startY - startX);
                        token.setVelocity(new PointF(0, 20));
                        tokens.add(token);
                        g.press();
                        buttonTrack = true;

                        invalidate();
                    }
                }


                if (buttonTrack == false) {
                    //Log.d("CIS203", "please touch one of buttons");
                    Toast t = Toast.makeText(getContext(),
                            "please touch one of buttons", Toast.LENGTH_SHORT);
                    t.show();
                }

            }


            if (m.getAction() == MotionEvent.ACTION_UP) {

                for (GridbButton g : leftLine) {
                    g.release();

                }
                for (GridbButton g : aboveLine) {
                    g.release();
                }
                invalidate();


            }

            return true;
        }

    @Override
    public void onTick() {
        invalidate();
    }
}
