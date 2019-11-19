package cn.tedu.product.mapper;

import com.fresh.common.pojo.Product;

import java.util.List;

public interface ProductMapper {

    /**
     * 根据商品id查询商品详情持久层方法
     * @param productId
     * @return
     */
    Product selectProductByProductId(String productId);

    /**
     *  统计商品数据条数--为分页查询准备
     * @return
     */
    int countProducts();

    /**
     *  商品列表的分页查询
     * @param start
     * @param rows
     * @return
     */
    List<Product> queryProductList(int start, Integer rows);

    /**
     *  以商品销量排行的商品列表
     * @return
     */
    List<Product> queryProductListForRank();

}
