package cn.tedu.img.controller;

import cn.tedu.img.service.PicService;
import com.fresh.common.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class PicController {
	/**
	 * 图片上传
	 */
	@Autowired
	private PicService ps;
	@RequestMapping("pic/upload")
	public PicUploadResult imgUpload(MultipartFile pic){
		return ps.imgUpload(pic);
	}
}
