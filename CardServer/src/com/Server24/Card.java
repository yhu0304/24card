package com.Server24;

import java.io.Serializable;

public class Card implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8044324917834456050L;
	//纸牌数值
    private int number = 0;
    //纸牌花色 0--红桃  1--黑桃  2--方块  3--梅花
    private int color = 0;

    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public int getColor(){
        return color;
    }
    public void setColor(int color){
        this.color = color;
    }
}
