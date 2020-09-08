package com.wk.platform.fileupload;

import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private FileUploadService fileUploadService;
    @ApiOperation("文件导入")
    @PostMapping("fileupload")
    public Result importVehicle(@RequestPart MultipartFile file, String customerId,int type, String token) {
        try{
            if(file == null){
                return Result.error("file is null");
            }
            Result result=fileUploadService.uploadFile(file,customerId,type, LocalMemCache.getUserIdByToken(token));
            return result;
        }catch (Exception e){
            logger.warn("fileupload exception:"+e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
