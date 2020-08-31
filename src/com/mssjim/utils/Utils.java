package com.mssjim.utils;

import java.awt.Color;
import java.util.Random;

public class Utils {
    public static String getPrefix = ";";
    
    public static Color getRandomColor() {
    	Random rand = new Random();
    	return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }
}
