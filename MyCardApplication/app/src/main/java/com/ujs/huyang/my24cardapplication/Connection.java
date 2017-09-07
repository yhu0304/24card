package com.ujs.huyang.my24cardapplication;

import android.util.Log;

import com.Server24.Card;

import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Huyang on 2016/11/2.
 */

public class Connection {
    private static final String TAG="Connection";

    ObjectInputStream ois = null;
    Card[] lastcard = new Card[4];
    Socket socket = null;



    public Connection(){
        //连接服务器，并接收信息

        Log.i(TAG,"开始连接。。。");
        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.253.3",30000),5000);
            ois = new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < 4; i++){
                Card card = (Card)ois.readObject();

                if (card != null){
                    lastcard[i] = new Card();
                    lastcard[i] = card;
                }
            }


        }catch (Exception e){
            Log.e(TAG,"TCP error");
            e.printStackTrace();
        }
    }

    private int Path(Card card) {
        if (card.getNumber() == 0) {
            if (card.getColor() == 0) {
                return R.raw.p00;
            } else if (card.getColor() == 1) {
                return R.raw.p01;
            } else if (card.getColor() == 2) {
                return R.raw.p02;
            } else if (card.getColor() == 3) {
                return R.raw.p03;
            }
        }
        else if (card.getNumber() == 1) {
            if (card.getColor() == 0) {
                return R.raw.p10;
            } else if (card.getColor() == 1) {
                return R.raw.p11;
            } else if (card.getColor() == 2) {
                return R.raw.p12;
            } else if (card.getColor() == 3) {
                return R.raw.p13;
            }
        }
        else if (card.getNumber() == 2) {
            if (card.getColor() == 0) {
                return R.raw.p20;
            } else if (card.getColor() == 1) {
                return R.raw.p21;
            } else if (card.getColor() == 2) {
                return R.raw.p22;
            } else if (card.getColor() == 3) {
                return R.raw.p23;
            }
        }
        else if (card.getNumber() == 3) {
            if (card.getColor() == 0) {
                return R.raw.p30;
            } else if (card.getColor() == 1) {
                return R.raw.p31;
            } else if (card.getColor() == 2) {
                return R.raw.p32;
            } else if (card.getColor() == 3) {
                return R.raw.p33;
            }
        }
        else if (card.getNumber() == 4) {
            if (card.getColor() == 0) {
                return R.raw.p40;
            } else if (card.getColor() == 1) {
                return R.raw.p41;
            } else if (card.getColor() == 2) {
                return R.raw.p42;
            } else if (card.getColor() == 3) {
                return R.raw.p43;
            }
        }
        else if (card.getNumber() == 5) {
            if (card.getColor() == 0) {
                return R.raw.p50;
            } else if (card.getColor() == 1) {
                return R.raw.p51;
            } else if (card.getColor() == 2) {
                return R.raw.p52;
            } else if (card.getColor() == 3) {
                return R.raw.p53;
            }
        }
        else if (card.getNumber() == 6) {
            if (card.getColor() == 0) {
                return R.raw.p60;
            } else if (card.getColor() == 1) {
                return R.raw.p61;
            } else if (card.getColor() == 2) {
                return R.raw.p62;
            } else if (card.getColor() == 3) {
                return R.raw.p63;
            }
        }
        else if (card.getNumber() == 7) {
            if (card.getColor() == 0) {
                return R.raw.p70;
            } else if (card.getColor() == 1) {
                return R.raw.p71;
            } else if (card.getColor() == 2) {
                return R.raw.p72;
            } else if (card.getColor() == 3) {
                return R.raw.p73;
            }
        }
        else if (card.getNumber() == 8) {
            if (card.getColor() == 0) {
                return R.raw.p80;
            } else if (card.getColor() == 1) {
                return R.raw.p81;
            } else if (card.getColor() == 2) {
                return R.raw.p82;
            } else if (card.getColor() == 3) {
                return R.raw.p83;
            }
        }
        else if (card.getNumber() == 9) {
            if (card.getColor() == 0) {
                return R.raw.p90;
            } else if (card.getColor() == 1) {
                return R.raw.p91;
            } else if (card.getColor() == 2) {
                return R.raw.p92;
            } else if (card.getColor() == 3) {
                return R.raw.p93;
            }
        }
        else if (card.getNumber() == 10) {
            if (card.getColor() == 0) {
                return R.raw.p100;
            } else if (card.getColor() == 1) {
                return R.raw.p101;
            } else if (card.getColor() == 2) {
                return R.raw.p102;
            } else if (card.getColor() == 3) {
                return R.raw.p103;
            }
        }
        else if (card.getNumber() == 10) {
            if (card.getColor() == 0) {
                return R.raw.p100;
            } else if (card.getColor() == 1) {
                return R.raw.p101;
            } else if (card.getColor() == 2) {
                return R.raw.p102;
            } else if (card.getColor() == 3) {
                return R.raw.p103;
            }
        }
        else if (card.getNumber() == 11) {
            if (card.getColor() == 0) {
                return R.raw.p110;
            } else if (card.getColor() == 1) {
                return R.raw.p111;
            } else if (card.getColor() == 2) {
                return R.raw.p112;
            } else if (card.getColor() == 3) {
                return R.raw.p113;
            }
        }
        else if (card.getNumber() == 12) {
            if (card.getColor() == 0) {
                return R.raw.p120;
            } else if (card.getColor() == 1) {
                return R.raw.p121;
            } else if (card.getColor() == 2) {
                return R.raw.p122;
            } else if (card.getColor() == 3) {
                return R.raw.p123;
            }
        }
        /*String path = "R.raw.p" + String.valueOf(card.getNumber()) + String.valueOf(card.getColor());
        return path;*/
        return 0;
    }


    public int getPath(int index){
        Card card = lastcard[index];
        return Path(card);
    }
}
