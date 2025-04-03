package com.xk.aop;

import java.util.regex.Pattern;

import com.xk.util.AliFourUtils;

public class test {
     public static void main(String args[]){
    	    String content = "158104110";
    	 String code=AliFourUtils.checkNameMobileCard("郑大彬", "15068875829", "612525198608174217");
    	 System.out.println(code);
     }
}
