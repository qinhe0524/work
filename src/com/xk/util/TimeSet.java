package com.xk.util;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeSet {
	public void TimerTask(){
		 Runnable runnable = new Runnable() {  
	         public void run() {  
	             // task to run goes here  
	             System.out.println("Hello !!");  
	         }  
	     };  
	     ScheduledExecutorService service = Executors  
	             .newSingleThreadScheduledExecutor();  
	     // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
	     service.scheduleAtFixedRate(runnable, 10, 60, TimeUnit.SECONDS);  
	}
	
	public static void main(String[] args) {
		new TimeSet().TimerTask();
	}

}
