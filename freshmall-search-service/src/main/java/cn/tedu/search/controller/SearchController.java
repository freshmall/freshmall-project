package cn.tedu.search.controller;

import java.util.List;

import com.fresh.common.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.tedu.search.service.EsService;

/**
 * 
 * @author Administrator
 *
 */
@RestController
public class SearchController {
	@Autowired
	private EsService esService;
	@RequestMapping("search/manage/query")
	public List<Product> search(@RequestParam("query")String text, Integer page, Integer rows) throws Exception{
		return esService.search(text,page,rows);
		
	}
	
}
