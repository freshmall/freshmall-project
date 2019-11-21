package cn.tedu.product.controller;

import cn.tedu.product.service.CreateIndexService;
import com.fresh.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateIndex {
	@Autowired
	private CreateIndexService cis;
	@RequestMapping("product/createIndex")
	public SysResult createIndex(){
		try{
			cis.createIndex();
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, "创建索引失败", null);
		}
	}
}
