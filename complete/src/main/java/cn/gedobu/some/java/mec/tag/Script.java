package cn.gedobu.some.java.mec.tag;

import java.util.HashMap;
import java.util.Map;

import cn.gedobu.some.java.mec.attribute.ScriptAttribute;

public class Script extends DoubleTag {
	HashMap<ScriptAttribute, String> attributes = new HashMap<>();
	
	public Script(ScriptAttribute attribute, String value) {
		attributes.put(attribute, value);
	}
	
	@Override
	public String getStartTagHTML() {
		String attributesString = "";
		for ( Map.Entry<ScriptAttribute, String> attributeEntry : attributes.entrySet() ) {
			String attributeString = String.format("%s=\"%s\"", attributeEntry.getKey().toString(), attributeEntry.getValue());
			attributesString += " " + attributeString;
		}
		return tab(this.layer, String.format("<%s%s>",
			this.getClass().getSimpleName().toLowerCase(),
			attributesString
		));
	}
}
