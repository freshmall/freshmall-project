package cn.tedu.search.service;

import java.util.ArrayList;
import java.util.List;

import com.fresh.common.pojo.Product;
import com.fresh.common.utils.MapperUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EsService {
	
	@Autowired
	private TransportClient client;
	
	public List<Product> search(String text, Integer page, Integer rows) throws Exception{
		//
		QueryBuilders.matchQuery("pname", text);
		MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(text,"pname","showname");
		//获取requet对象
		SearchRequestBuilder request = client.prepareSearch("freshgree");
		SearchResponse response = request.setQuery(query).setFrom((page-1)*rows).setSize(rows).get();
 		List<Product> pList=new ArrayList<Product>();
 		SearchHit[] hits=response.getHits().getHits();
 		for(SearchHit hit : hits){
 			String pJson=hit.getSourceAsString();
 			Product product= MapperUtil.MP.readValue(pJson,Product.class);
 			pList.add(product);
 		}
		return pList;
	}

}
