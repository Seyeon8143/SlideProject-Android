package edu.byuh.cis.cs203.seyeonapplication.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.byuh.cis.cs203.seyeonapplication.ui.GridToken;
import edu.byuh.cis.cs203.seyeonapplication.ui.TickListener;


public class Timer extends Handler {
        private List<TickListener> listeners;

        public Timer() {
            listeners = new ArrayList<>(); //collection of observers
            sendMessageDelayed(obtainMessage(), 0);
        }

        //subject can register and unregister observers
        public void register(TickListener t){
            listeners.add(t);
        }
        public void unregister(TickListener t){
            listeners.remove(t);
        }
        public void notifyTickListeners(){
            for(TickListener t : listeners){
                t.onTick();
            }
        }
        @Override
        public void handleMessage(Message M) {
            /*for (GridToken gr : tokens) {
                Log.d("cs203", "move");
                gr.move();
            }

            invalidate();*/
            notifyTickListeners();
            sendMessageDelayed(obtainMessage(), 100);
        }
    }

