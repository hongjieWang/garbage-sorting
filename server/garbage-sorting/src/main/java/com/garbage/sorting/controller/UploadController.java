package com.garbage.sorting.controller;

import com.garbage.sorting.service.BaiduService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Base64;

/**
 * @author wanghongjie
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private BaiduService baiduService;

    @RequestMapping("/picture")
    public String uploadPicture(@RequestParam("file") MultipartFile uploadFile) throws Exception {
        byte[] bytes = uploadFile.getBytes();
        String encodeToString = Base64.getEncoder().encodeToString(bytes);
        return baiduService.advancedGeneral(encodeToString);
    }
}
