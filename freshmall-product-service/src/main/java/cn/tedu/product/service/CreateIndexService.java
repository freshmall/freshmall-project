package cn.tedu.product.service;



import java.util.List;

import com.fresh.common.pojo.Product;
import com.fresh.common.utils.MapperUtil;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;


import cn.tedu.product.mapper.ProductMapper;

@Service
public class CreateIndexService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired 
	private TransportClient client;
	
	public void createIndex() throws JsonProcessingException {
		List<Product> pList=productMapper.queryProducts(0,100);
		client.admin().indices().prepareCreate("freshgree").get();
		for(Product product:pList){
			String json= MapperUtil.MP.writeValueAsString(product);
		IndexRequestBuilder request=client.prepareIndex
				("freshgree","product",product.getPid());
		request.setSource(json).get();
		}
	}

}
