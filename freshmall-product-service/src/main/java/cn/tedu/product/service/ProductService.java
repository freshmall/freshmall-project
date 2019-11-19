package cn.tedu.product.service;

import cn.tedu.product.mapper.ProductMapper;
import com.fresh.common.pojo.Product;
import com.fresh.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper = null;

    /**
     * 根据商品id查询商品详情业务层方法
     * @param productId
     * @return
     */
    public Product queryProductDetail(String productId) {
        return productMapper.selectProductByProductId(productId);
    }

    /**
     *  商品分页查询的业务层方法
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult queryProductByPage(Integer page, Integer rows) {
        EasyUIResult result = new EasyUIResult();
        int total = productMapper.countProducts();
        result.setTotal(total);
        int start = (page-1)*rows;
        List<Product> productList = productMapper.queryProductList(start,rows);
        result.setRows(productList);
        return result;

    }
}
