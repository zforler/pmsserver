package com.wk.platform.report;

import com.wk.bean.Report;
import com.wk.common.vo.Result;

import java.util.List;

public interface ReportService {
    Result<Report> addReport(Report report, String operateUserId);

    Result updateReport(Report report,String operateUserId);

    Result deleteReport(int reportId,String operateUserId);

    Result<List<Report>> getReportList(String keyword, String customerId, String operateUserId);

    Result<List<Report>> getAuthReportList(String keyword, String customerId, String operateUserId);

    Result shareReport(String customerIds, int reportId, String operateUserId);

    Result cancleShareReport(String customerIds, int reportId, String operateUserId);

}
