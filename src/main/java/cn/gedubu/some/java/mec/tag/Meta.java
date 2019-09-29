package cn.gedubu.some.java.mec.tag;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import cn.gedubu.some.java.mec.attribute.MetaAttribute;

public class Meta extends SingleTag {
	HashMap<MetaAttribute, String> attributes = new HashMap<>();
	
	public Meta(MetaAttribute attribute, String value) {
		attributes.put(attribute, value);
	}
	
	public Meta() {
		super();
	}
	
	@Override
	public void printStartTagHTML() {
		String attributesString = "";
		for ( Map.Entry<MetaAttribute, String> attributeEntry : attributes.entrySet() ) {
			String attributeString = String.format("%s=\"%s\"", attributeEntry.getKey().toString(), attributeEntry.getValue());
			attributesString += " " + attributeString;
		}
		System.out.println(
			String.format("%s<%s%s />",
				String.join("", Collections.nCopies(layer*4, " ")),
				this.getClass().getSimpleName().toLowerCase(),
				attributesString
			)
		);
	}
}
