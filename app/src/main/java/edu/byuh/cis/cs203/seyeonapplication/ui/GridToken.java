package edu.byuh.cis.cs203.seyeonapplication.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;


import java.util.ArrayList;

import edu.byuh.cis.cs203.seyeonapplication.R;
import edu.byuh.cis.cs203.seyeonapplication.logic.GameBoard;
import edu.byuh.cis.cs203.seyeonapplication.logic.Player;

public class GridToken implements TickListener {
    private RectF position;
    private Bitmap oImage, xImage;
    private PointF velocity;
    private int seyeon; //token know the stop
    private int size;
    private GridPosition gridPosition;


    /**
     * this class is inner class of GridToken
     */
    public class GridPosition {
        public char move;
        public char row;
        public char col;
        private int DIM =5;
        private int board [][];

        public GridPosition(){
            board = new int[DIM][DIM];
            for(int i =0; i<DIM; i++){
                for(int j = 0; j <DIM; j++){
                    board[i][j] = 0;// set as null
                }
            }
        }
        public void submitMove(char move,int p) {
            int col =Integer.parseInt(""+move)-1;
            int newVNum = p; //input
            if(move >= '1' && move <= '5') {//내 왼쪽 라인 라벨이 1,2,3,4,5
                //starting fill in the token in the cell
                for(int i =0; i<board.length; i++){
                    if(board[i][col] != 0){//if that token is not null:
                        int tmp = board[i][col];
                        board[i][col] = newVNum;

                    }else break;  //break out of the loop


                }

            }
        }
        }




    public GridToken(Resources res, int size, float x, float y) {
        oImage = BitmapFactory.decodeResource(res, R.drawable.player_o);
        oImage = Bitmap.createScaledBitmap(oImage, size, size, true);
        xImage = BitmapFactory.decodeResource(res, R.drawable.player_x);
        this.size = size;
        xImage = Bitmap.createScaledBitmap(xImage, size, size, true);
        position = new RectF(x, y, x + size, y + size);//set position of token im
        velocity = new PointF(0, 0);
        seyeon = 0;

    }



    public void move() {

        position.offset(velocity.x, velocity.y);
        seyeon ++;
        if(seyeon > 20){
            velocity.set(0,0);
            seyeon = 0;
        }
    }


    public PointF getVelocity() {
        return velocity;
    }

    public void setVelocity(PointF velocity) {
        this.velocity = velocity;

    }

    public void drawToken(Canvas c) {

            c.drawBitmap(xImage, position.left, position.top, null);
        }
        /*else
        c.drawBitmap(oImage,position.left, position.top, null);
        }*/

    @Override
    public void onTick() {
        move();

    }


    }


