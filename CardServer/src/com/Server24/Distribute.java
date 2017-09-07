package com.Server24;

import java.util.ArrayList;
import java.util.Random;

public class Distribute {
    //标记一副牌中被分配的牌
    Boolean[] boo = new Boolean[52];
    //标记每个人已经使用的牌
    Boolean[] boo1 = new Boolean[13];

    //建立初始化纸牌 集合类
    ArrayList<Card> play = null;
    //建立4个玩家的纸牌集合类
    ArrayList<Card> play1,play2,play3,play4;
    public Distribute(){
        //初始化集合类
        play=new ArrayList<Card>();
        play1=new ArrayList<Card>();
        play2=new ArrayList<Card>();
        play3=new ArrayList<Card>();
        play4=new ArrayList<Card>();
        //初始化play集合
        for(int i = 0; i < 13; i ++){
            for(int j = 0; j < 4; j ++){
                Card temp1 = new Card();
                temp1.setNumber(i);
                temp1.setColor(j);
                play.add(temp1);
                boo[i * 4 + j] = true;
                boo1[i] = true;
            }
        }
        //初始化4个玩家的集合
        d_play(play1);
        d_play(play2);
        d_play(play3);
        d_play(play4);
    }

    //随机产生一个整数下标值
    public int getRandom(int max){
        Random random = new Random();
        int index=random.nextInt(max);
        return index;
    }
    //将初始化的对象随机分配给集合类
    private void d_play(ArrayList<Card> temp_Arr){
        int j=13;
        for(int i=0;i<j;i++){
            int index=getRandom(52);
            if(boo[index]){
                Card temp2 = new Card();
                temp2 = play.get(index);
                temp_Arr.add(temp2);
                boo[index] = false;
            }
            else{
                j ++;
            }
        }
    }
}