package io.github.trinnorica.utils.tasks;

import java.util.TimerTask;

import io.github.trinnorica.entity.Entity;

public class CheckLanding extends TimerTask {
	
	Entity e;
	
	public CheckLanding(Entity e){
		this.e = e;
	}
	
	@Override
	public void run(){
		try{
			if(e.velocity.y == 0)
				e.damaged = false;
			else run();
		} catch(Exception ex){}
		
	}

}
