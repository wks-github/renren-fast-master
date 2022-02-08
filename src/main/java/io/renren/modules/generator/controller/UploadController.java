package io.renren.modules.generator.controller;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Value("${upload.fileUrl}")
    private String fileDir;
    @Value("${upload.suffixUrl}")
    private String suffixUrl;

//    @PostMapping("/file")
//    public String upload(MultipartFile file) throws SocketException, IOException {
//        // 获取文件名
//        String originalFilename = file.getOriginalFilename();
//        String fileName = UUID.randomUUID().toString().replace("-","")+originalFilename.substring(originalFilename.lastIndexOf("."));
//        // 本工程下的路径
//        String destFileName= fileDir + fileName;
//        File destFile = new File(destFileName);
//        // 如果没有就根据地址创建一个
//        if(!destFile.exists()){
//            destFile.getParentFile().mkdirs();
//        }
//        // 将文件移动到目的目录
//        file.transferTo(destFile);
//        return "上传成功";
//    }

    /**
     * 上传文件
     */
    @PostMapping("/file")
    @ResponseBody
    public R upload(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletRequest request) throws Exception {
        List<Map<String,Object>> imgNameList=new ArrayList<>();
        for (int i = 0; i < multipartFiles.length; i++) {
            MultipartFile file = multipartFiles[i];
            if (file.isEmpty()) {
                throw new RRException("文件上传失败");
            }
            // 获取文件名称,包含后缀
            String originalFilename = file.getOriginalFilename();
            //避免文件名字重复
            String fileName = UUID.randomUUID().toString().replace("-","")+originalFilename.substring(originalFilename.lastIndexOf("."));
            //下载到本地部署服务器
            String webUrl = uploadFile(file, fileName);
            //重命名后的文件名
            Map<String,Object> imgMap=new HashMap<>();
            imgMap.put("name",fileName);
            imgMap.put("url",webUrl);
            imgNameList.add(imgMap);
            //上传文件到本地
        }
        return R.ok().put("imgNameList", imgNameList);
    }

    private String uploadFile(MultipartFile file, String fileName) throws IOException {
        String destFileName= fileDir + fileName;
        File destFile = new File(destFileName);
        // 如果没有就根据地址创建一个
        if(!destFile.exists()){
            destFile.getParentFile().mkdirs();
        }
        // 将文件移动到目的目录
        file.transferTo(destFile);
        return suffixUrl+fileName;

    }




}
