package cn.gedubu.some.java.mec.tag;

import java.util.Collections;

public class Tag {
	public int layer = 0;
	public Tag[] children;
	
	public Tag(Tag[] tags) {
		this.children = tags;
	}
	
	public Tag() {
	}
	
	public void printBehavior() {
		printStartTagHTML();
		if ( this.children != null ) {
			for ( Tag child : children ) {
				child.layer  = this.layer + 1;
				child.printBehavior();
			}
		}
		printEndTagHTML();
	}
	
	public void printStartTagHTML() {
		System.out.println(String.format("%s<%s>", String.join("", Collections.nCopies(layer*4, " ")), this.getClass().getSimpleName().toLowerCase()));
	}
	
	public void printEndTagHTML() {
		System.out.println(String.format("%s</%s>", String.join("", Collections.nCopies(layer*4, " ")), this.getClass().getSimpleName().toLowerCase()));
	}
}
