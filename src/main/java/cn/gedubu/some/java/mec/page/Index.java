package cn.gedubu.some.java.mec.page;

import cn.gedubu.some.java.mec.attribute.MetaAttribute;
import cn.gedubu.some.java.mec.tag.Body;
import cn.gedubu.some.java.mec.tag.HTML;
import cn.gedubu.some.java.mec.tag.Head;
import cn.gedubu.some.java.mec.tag.Meta;
import cn.gedubu.some.java.mec.tag.Tag;

public class Index {
	public static void main(String[] args) {
		new HTML(new Tag[] {
			new Head(new Tag[] {
				new Meta(MetaAttribute.charset, "utf-8"),
				new Meta(MetaAttribute.viewport, "initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
			}),
			new Body()
		});
	}
}
