package cn.gedubu.some.java.mec.tag;

import java.util.Collections;

public class SingleTag extends Tag {
	@Override
	public void printStartTagHTML() {
		System.out.println(String.format("%s<%s />", String.join("", Collections.nCopies(layer*4, " ")), this.getClass().getSimpleName().toLowerCase()));
	}
	
	@Override
	public void printEndTagHTML() {
		
	}
}
