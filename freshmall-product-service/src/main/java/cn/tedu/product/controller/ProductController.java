package cn.tedu.product.controller;

import cn.tedu.product.service.ProductService;
import com.fresh.common.pojo.Product;
import com.fresh.common.vo.EasyUIResult;
import com.fresh.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("product/manage")
public class ProductController {

    @Autowired
    private ProductService productService = null;

    /**
     * 根据商品id查询商品详情
     * @param pid 商品id
     * @return  商品详情
     */
    //http://productservice"+"/product/manage/detail/
    @RequestMapping("detail/{pid}")
    public Product queryProductDetail(@PathVariable String pid){
       Product product = productService.queryProductDetail(pid);

        return product;
    }
    /**
     * 商品分页查询
     *
     * @param page
     * @param rows
     * @param request
     * @return
     */
    @RequestMapping("/query")
    public EasyUIResult queryProductByPage(Integer page, Integer rows, HttpServletRequest request) {
        String queryString = request.getQueryString();
        //pdlcode/pxlcode/pname=%E8%83%A1%E8%90%9D%E5%8D%9C&page=1&rows=10
        String substring = queryString.substring(0, queryString.indexOf("="));
        //获取第一个请求参数name
        String s = queryString.substring(queryString.indexOf("="));
        if ("pdlcode".equals(substring)) {
            String param = s.substring(1,2);
            return productService.queryProductByPdlcodeAndPage(page, rows, param);
        }
        if ("pxlcode".equals(substring)) {
            String param = s.substring(1,3);
            return productService.queryProductByPxlcodeAndPage(page, rows, param);
        }
        String[] values = request.getParameterValues("pname");
        String value = values[0];
        return productService.queryProductByPnameAndPage(page, rows, value);
    }

/*
    *//**
     * 根据商品大类的分页查询
     * @param page 第几页
     * @param rows 每页商品条数
     * @param pdlcode 商品大类参数
     * @return 商品集合的json
     *//*
    @RequestMapping("/query1")
    public EasyUIResult queryProductByPdlcodeAndPage(Integer page,Integer rows,String pdlcode){
        return  productService.queryProductByPdlcodeAndPage(page,rows,pdlcode);
    }

    *//**
     * 根据商品小类的分页查询
     * @param page
     * @param rows
     * @param pxlcode
     * @return
     *//*
    @RequestMapping("/query2")
    public EasyUIResult queryProductByPxlcodeAndPage(Integer page,Integer rows,String pxlcode){
        return  productService.queryProductByPxlcodeAndPage(page,rows,pxlcode);
    }

    *//**
     * 根据商品名称的分页查询
     * @param page
     * @param rows
     * @param pname
     * @return
     *//*
    @RequestMapping("/query3")
    public EasyUIResult queryProductByPnameAndPage(Integer page,Integer rows,String pname){
        return  productService.queryProductByPnameAndPage(page,rows,pname);
    }*/

    /**
     * 新增商品
     * @param product
     * @return
     */
    @RequestMapping("/save")
    public SysResult addProduct(Product product, HttpServletRequest req, HttpServletResponse res){
        try {
            productService.addProduct(product);
            //成功
		//res.sendRedirect("http://www.background.com/close.html");
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201,"新增商品失败",null);
        }
    }

    /**
     * 更新-删除商品
     * @return
     */
    @RequestMapping("update")
    public SysResult updateProduct(Product product){
        try {
            productService.updateProduct(product);
            return SysResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201,"更新或删除商品失败",null);
        }
    }
    /**
     * 后台查询商品
     * 查询全部商品
     */
    @RequestMapping("pageManage")
    public EasyUIResult queryProductsByPage(Integer page,Integer rows){

        return productService.queryProductsByPage(page,rows);
    }

}
