package cn.tedu.product.service;

import cn.tedu.product.mapper.ProductMapper;
import com.fresh.common.pojo.Product;
import com.fresh.common.utils.UUIDUtil;
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
     * @param pid
     * @return
     */
    public Product queryProductDetail(String pid) {
        return productMapper.selectProductByProductId(pid);
    }


    /**
     * 商品按大类分页查询的业务层方法
     * @param page
     * @param rows
     * @param pdlcode
     * @return
     */
    public EasyUIResult queryProductByPdlcodeAndPage(Integer page, Integer rows,String pdlcode) {
        EasyUIResult result = new EasyUIResult();
        int total = productMapper.countProductsByPdlcode(pdlcode);
        result.setTotal(total);
        int start = (page-1)*rows;
        List<Product> productList = productMapper.queryProductListByPdlcodeAndPage(pdlcode,start,rows);
        result.setRows(productList);
        return result;

    }

    /**
     * 商品按小类分页查询的业务层方法
     * @param page
     * @param rows
     * @param pxlcode
     * @return
     */
    public EasyUIResult queryProductByPxlcodeAndPage(Integer page, Integer rows, String pxlcode) {
        EasyUIResult result = new EasyUIResult();
        int total = productMapper.countProductsByPxlcode(pxlcode);
        result.setTotal(total);
        int start = (page-1)*rows;
        List<Product> productList = productMapper.queryProductListByPxlcodeAndPage(start,rows,pxlcode);
        result.setRows(productList);
        return result;
    }

    /**
     * 商品按名称分页查询的业务层方法
     * @param page
     * @param rows
     * @param pname
     * @return
     */
    public EasyUIResult queryProductByPnameAndPage(Integer page, Integer rows, String pname) {
        EasyUIResult result = new EasyUIResult();
        int total = productMapper.countProductsByPname(pname);
        result.setTotal(total);
        int start = (page-1)*rows;
        List<Product> productList = productMapper.queryProductListByPnameAndPage(start,rows,pname);
        result.setRows(productList);
        return result;
    }

    /**
     * 新增商品业务层方法
     * @param product
     */
    public void addProduct(Product product) {
        product.setPid(UUIDUtil.getUUID().toString());
        productMapper.addProduct(product);
    }

    /**
     * 更新或删除商品业务层方法
     * @param product
     */
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public EasyUIResult queryProductsByPage(Integer page, Integer rows) {
        EasyUIResult result = new EasyUIResult();
        int total = productMapper.queryTotalCount();
        result.setTotal(total);// 显示页数
        int start = (page - 1) * rows;
        List<Product> pList = productMapper.queryProducts(start, rows);
        result.setRows(pList);
        return result;
    }

}
