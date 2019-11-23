package cn.tedu.img.service;

import java.io.File;
import java.util.UUID;

import com.fresh.common.utils.UploadUtil;
import com.fresh.common.vo.PicUploadResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PicService {

	public PicUploadResult imgUpload(MultipartFile pic) {
		/**
		 *1  验证文件的后缀 jps png gif
		 *  如果判断不在范围  直接返回错误数据
		 *2 生成一个多级路径
		 *3 创建g://img的逻辑目录
		 *4 重命名文件uuid+后缀
		 *5 流数据输出到文件夹中
		 */
		PicUploadResult result=new PicUploadResult();
		try{
			String oFileName=pic.getOriginalFilename();
			String extName=oFileName.substring(oFileName.lastIndexOf("."));
			//正则表达式
			if(!extName.matches(".(jpg|png|gif)$")){
				//说明后缀非法
				result.setError(1);
				return result;
			}
			//使用工具类
			String dir= UploadUtil.getUploadPath(oFileName,"freshgree");
		//使用file创建
			//String path="G://img/"+dir+"/";
			String path="F://img/"+dir+"/";
			File file=new File(path);
			//判断是否存在 不存在创建
			if(!file.exists()){
				//需要创建多级目录
				file.mkdirs();
			}
			//重命名文件
			String newFileName=UUID.randomUUID().toString()+extName;
			//输出到path+newFileName
			pic.transferTo(new File(path+newFileName));
			//生成一个可访问图片的地址
			String urlPath="http://image.fg.com/"+dir+"/"+newFileName;
			result.setUrl(urlPath);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			result.setError(1);
			return result;
		}
	}
}
