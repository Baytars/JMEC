package cn.gedobu.some.java.mec.controller;


import cn.gedobu.some.java.mec.page.Page;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoMeRestController {

	@RequestMapping("/spring/{pageNum}")
	public String getTopic(@PathVariable("pageNum") int pageNum) {
		String packageName = this.getClass().getPackage().getName();
		Page topic = null;
		try {
			Class<Page> destClass = (Class<Page>) Class.forName(String.format("%s.topic.T%s", packageName, Integer.toString(pageNum)));
			try {
				topic = destClass.newInstance();
			} catch (InstantiationException e) {
				return e.toString();
			} catch (IllegalAccessException e) {
				return e.toString();
			}
		} catch (ClassNotFoundException e) {
			return e.toString();
		}
		return topic.getResponseText();
	}
}
