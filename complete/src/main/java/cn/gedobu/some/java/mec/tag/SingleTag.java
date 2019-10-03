package cn.gedobu.some.java.mec.tag;

public class SingleTag extends Tag {
	@Override
	public String getStartTagHTML() {
		return tab(this.layer, String.format("<%s />", this.getClass().getSimpleName().toLowerCase()));
	}
	
	@Override
	public String getEndTagHTML() {
		return tab(this.layer, "");
	}
}
