package cn.gedobu.some.java.mec.tag;

import java.util.HashMap;
import java.util.Map;

import cn.gedobu.some.java.mec.attribute.MetaAttribute;


public class Meta extends SingleTag {
	HashMap<MetaAttribute, String> attributes = new HashMap<>();
	
	public Meta(MetaAttribute attribute, String value) {
		attributes.put(attribute, value);
	}
	
	public Meta() {
		super();
	}
	
	@Override
	public String getStartTagHTML() {
		String attributesString = "";
		for ( Map.Entry<MetaAttribute, String> attributeEntry : attributes.entrySet() ) {
			String attributeString = String.format("%s=\"%s\"", attributeEntry.getKey().toString(), attributeEntry.getValue());
			attributesString += " " + attributeString;
		}
		return tab(this.layer, String.format("<%s%s />",
			this.getClass().getSimpleName().toLowerCase(),
			attributesString
		));
	}
}
