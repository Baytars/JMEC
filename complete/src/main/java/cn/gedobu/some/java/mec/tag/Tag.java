package cn.gedobu.some.java.mec.tag;

import java.util.Collections;

public class Tag {
	public int layer = 0;
	public Tag[] children;
	public String innerHTML;
	
	public Tag(Tag[] tags) {
		this.children = tags;
	}
	
	public Tag() {
	}
	
	public Tag(String innerHTML) {
		this.innerHTML = innerHTML;
	}
	
	public void printBehavior() {
		System.out.println(getStartTagHTML());
		if ( this.children != null ) {
			for ( Tag child : children ) {
				child.layer  = this.layer + 1;
				child.printBehavior();
			}
		}
		System.out.println(getEndTagHTML());
	}
	
	public String getTagName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	public String getInnerHTML() {
		if ( this.innerHTML == null ) {
			return tab(this.layer+1, "");
		}
		else {
			return tab(this.layer+1, this.innerHTML);
		}
	}
	
	protected String tab(int layer, String str) {
		return String.format("%s%s", String.join("", Collections.nCopies(layer, Integer.toString(layer))), str);
	}
	
	public String getStartTagHTML() {
		return tab(this.layer, String.format("<%s>", getTagName()));
	}
	
	public String getEndTagHTML() {
		return tab(this.layer, String.format("</%s>", getTagName()));
	}
	
	public String getOuterHTML() {
		String outerHTML = getStartTagHTML();
		if ( this.children != null ) {
			for ( Tag child : children ) {
				child.layer += this.layer + 1;
				outerHTML += "\n" + child.getOuterHTML();
			}
		}
		else {
			outerHTML += "\n" + getInnerHTML();
		}
		outerHTML += "\n" + getEndTagHTML();
		return outerHTML;
	}
}
