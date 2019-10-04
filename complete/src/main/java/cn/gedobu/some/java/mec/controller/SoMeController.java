package cn.gedobu.some.java.mec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gedobu.some.java.mec.page.Page;

@Controller
public class SoMeController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/glossaries/spring/255.html";
	}
	
	@RequestMapping("/glossaries/spring/{pageNum}.html")
	public String getTopic(@PathVariable("pageNum") int pageNum) {
		String packageName = this.getClass().getPackage().getName();
		try {
			Class<Page> destClass = (Class<Page>) Class.forName(String.format("%s.topic._%s", packageName, Integer.toString(pageNum)));
			return String.format("forward:/spring/%s", Integer.toString(pageNum));
		} catch (ClassNotFoundException e) {
			return String.format("forward:/glossaries/conventional/%s.html", Integer.toString(pageNum));
		}
	}
}
