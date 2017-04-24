package io.github.trinnorica.utils.ui;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Entity;

public class UIEmpty extends Entity {
	
	List<Object> attachments = new ArrayList<>();

	public UIEmpty(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void addAttachment(Object o){
		attachments.add(o);
	}
	
	public List<Object> getAttachments(){
		return attachments;
	}

}
