package com.wk.platform.fileupload;

import com.wk.common.vo.Result;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Result uploadFile(@RequestPart MultipartFile file, String customerId,int type,String operateUserId);
}
