package cn.gedobu.some.java.mec.page;

import cn.gedobu.some.java.mec.attribute.MetaAttribute;
import cn.gedobu.some.java.mec.attribute.ScriptAttribute;
import cn.gedobu.some.java.mec.tag.Body;
import cn.gedobu.some.java.mec.tag.HTML;
import cn.gedobu.some.java.mec.tag.Head;
import cn.gedobu.some.java.mec.tag.Meta;
import cn.gedobu.some.java.mec.tag.Script;
import cn.gedobu.some.java.mec.tag.Tag;

public class Page {
	String responseText;
	
	public String getResponseText() {
		return this.responseText;
	}
	
	protected void fromHTML(Tag[] tags) {
		this.responseText = new HTML(tags).getOuterHTML();
	}
	
	protected void fromBody(Tag[] tags) {
		fromHTML(new Tag[] {
			new Head(new Tag[] {
				new Meta(MetaAttribute.charset, "utf-8"),
				new Meta(MetaAttribute.viewport, "initial-scale=1.0, maximum-scale=1.0, user-scalable=no"),
				new Script(ScriptAttribute.src, "/js/some.js")
			}),
			new Body(tags)
		});
	}
}
