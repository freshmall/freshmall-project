package cn.tedu.product.controller;

import cn.tedu.product.service.ProductService;
import com.fresh.common.pojo.Product;
import com.fresh.common.vo.EasyUIResult;
import com.fresh.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class ProductControler {

    @Autowired
    private ProductService productService = null;

    /**
     * 根据商品id查询商品详情
     * @param productId 商品id
     * @return  商品详情
     */
    @RequestMapping("/detail/{productId}")
    public Product queryProductDetail(String productId){
        return productService.queryProductDetail(productId);
    }

    /**
     *  表示商品列表--分页查询
     * @param page 第几页
     * @param rows 每页商品条数
     * @return 商品集合的json
     */
    public EasyUIResult queryProductByPage(Integer page,Integer rows){
        return  productService.queryProductByPage(page,rows);
    }


}
