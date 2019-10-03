package cn.gedobu.some.java.mec.page;

import cn.gedobu.some.java.mec.tag.H1;
import cn.gedobu.some.java.mec.tag.Tag;

public class Index extends Page {
	
	public Index() {
		fromBody(new Tag[] {
			new H1("MEC")
		});
	}
}
