package com.wk.platform.recordEdit;

import com.wk.bean.RecordEditLog;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface RecordEditLogService {
    Result<RecordEditLog> addRecordEditLog(RecordEditLog recordEditLog, String operateUserId);

    Result<List<RecordEditLog>> getRecordEditLogList(String keyword,String customerId, String operateUserId);

    Result<PageList<RecordEditLog>> getRecordEditLogPageList(String keyword,String customerId, int page, int size,
                                                             String operateUserId);
}
