package com.ballGame2;

class Ball implements Runnable{
	int bx=0;
	int by=0;
	int speed=4;
	int direction=1;
	boolean isLive=true;
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ball fly function
			//right down
			if(direction==1){
				bx+=speed;
				by+=speed;
			}
			//right up
			if(direction==2){
				bx+=speed;
				by-=speed;
			}
			//left up
			if(direction==3){
				bx-=speed;
				by-=speed;
			}
			//left down
			if(direction==4){
				bx-=speed;
				by+=speed;
			}
			//touch the wall
			
			if(by>=260){
//				if (direction==1){
//					direction=2;
//				}else{
//					direction=3;
//				}
				isLive=false;
			}
			
			if(bx>=375){
				if (direction==2){
					direction=3;
				}else{
					direction=4;
				}
			}
			if(by<=-2){
				if (direction==3){
					direction=4;
				}else{
					direction=1;
				}
			}
			if(bx<=-2){
				if (direction==4){
					direction=1;
				}else{
					direction=2;
				}
			}
			
		}
		
	}
}

class Stick {
	int sx=100;
	int sy=150;
	int speed=5;
	
}