package com.minecreatr.cliffieswars.util;

/**
 * Created on 6/4/14
 */
public class MathHelper {

    public static int getDistance(int xd, int yd, int zd){
        int t = Math.abs(sqr(xd)+sqr(yd)+sqr(zd));
        return (int) Math.abs(Math.sqrt(t));
    }

    public static int sqr(int s){
        return s*s;
    }

    public static int getRadiusFromPower(int power){
        int t = sqr(power)/3;
        return (int) Math.abs(Math.sqrt(t));
    }
}
