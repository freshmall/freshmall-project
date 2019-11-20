package cn.tedu.product.mapper;

import com.fresh.common.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    /**
     * 根据商品id查询商品详情持久层方法
     * @param productId
     * @return
     */
    Product selectProductByProductId(String productId);

    /**
     *  统计某商品大类下的数据条数
     * @return
     * @param pdlcode
     */
    int countProductsByPdlcode(String pdlcode);

    /**
     * 商品按大类分页查询持久层方法
     * @param start
     * @param rows
     * @param pdlcode
     * @return
     */
    List<Product> queryProductListByPdlcodeAndPage(@Param("pdlcode") String pdlcode, @Param("start") int start, @Param("rows") Integer rows);

    /**
     * 统计商品小类下的数据条数
     * @param pdlcode
     * @return
     */
    int countProductsByPxlcode(String pdlcode);

    /**
     * 商品按小类分页查询持久层方法
     * @param start
     * @param rows
     * @param pxlcode
     * @return
     */
    List<Product> queryProductListByPxlcodeAndPage(@Param("start") int start, @Param("rows") Integer rows, @Param("pxlcode") String pxlcode);

    /**
     * 统计某商品名称下的数据条数
     * @param pname
     * @return
     */
    int countProductsByPname(String pname);

    /**
     * 商品按pname分页查询持久层方法
     * @param start
     * @param rows
     * @param pname
     * @return
     */
    List<Product> queryProductListByPnameAndPage(@Param("start") int start, @Param("rows") Integer rows, @Param("pname") String pname);

    /**
     * 新增商品持久层方法
     * @param product
     */
    void addProduct(Product product);

    /**
     * 更新或删除商品
     * @param pid
     */
    void updateProduct(String pid);
}
