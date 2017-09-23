/*
 * function: deep understanding of click
 * control ball using arrows in the keyboard
 */
package com.ballGame2;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class BallGame2 extends JFrame{
	Mypanel mp=null;
	public static void main(String[] args) {
		
		BallGame2 demo9_4=new BallGame2();
	}	
	public BallGame2(){
		mp=new Mypanel();
		Thread t=new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Mypanel extends JPanel implements Runnable,KeyListener{
	Ball ball=null;
	Stick stick=null;
	public Mypanel(){
		ball=new Ball();
		stick=new Stick();
		Thread t=new Thread(ball);
		t.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		
		//stick
		g.fillRect(stick.sx, stick.sy, 100, 5);
		g.fillOval(ball.bx, ball.by, 10, 10);
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
//		if(e.getKeyCode()==KeyEvent.VK_DOWN){
//			y++;
//		}else if(e.getKeyCode()==KeyEvent.VK_UP){
//			y--;
//		}else 
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			stick.sx-=stick.speed;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			stick.sx+=stick.speed;
		}
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			this.play();
			if(ball.isLive==false){
				break;
			}
	}
	}
		
	
	
public void play(){
	//System.out.println("Debug paly() funtion.ball.y"+ball.by+"stick.sy"+stick.sy);
			if(ball.by>=stick.sy-10
					&&stick.sx<=ball.bx&&ball.bx<=(stick.sx+100)){
				if(ball.direction==1){
					ball.direction=2;
				}else{
					ball.direction=3;
				}
			}
            }
}