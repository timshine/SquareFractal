// Lab17bvst.java
// The student, starting version of the Lab17b assignment.

import java.awt.*;
import java.applet.*;

public class Runner extends Applet
{		
	public void init(){
		setSize(1024,768);
	}
	public void paint (Graphics g)
	{
		drawSquare1(g,1024,768);
	}
	
	public void drawSquare1(Graphics g, int maxX, int maxY)
	{
		int midX = maxX/2;//512
		int midY = maxY/2;//384
		int startWidth = maxX/4;//256
		int startHeight = maxY/4;//192
		int tlX = midX - (startWidth/2);//384
		int tlY = midY - (startHeight/2);//288
		g.fillRect(tlX,tlY,startWidth,startHeight);
		drawFourSquares(g,tlX,tlY,startWidth,startHeight);
		//g.fillRect(tlX-startWidth/2,tlY-startHeight/2,startWidth/2,startHeight/2);
		
		/*if(startWidth>=1 && startHeight>=1){
			
			
			drawSquare1(g,tlX,tlY);*/
			//drawSquare1(g,startWidth+tlX),startHeight-tlY);
			
						
		}
	
	public void drawFourSquares(Graphics g,int x, int y, int w, int h){
		drawNE( g, x,  y,  w,  h);
	}
	
	public void drawNE(Graphics g,int x, int y, int w, int h){
		if(w>1){
			drawNE(g, x-w/2,y-h/2,w/2,h/2);
		}
	}
	
	public void drawSE(Graphics g,int x, int y, int w, int h){
			
	}
	
	public void drawNW(Graphics g,int x, int y, int w, int h){
		
	}
	
	public void drawSW(Graphics g,int x, int y, int w, int h){
			
	}

	public void delay(long n)
	{
		n *= 1000;
		long startDelay = System.nanoTime();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.nanoTime();
	}			

	
}
