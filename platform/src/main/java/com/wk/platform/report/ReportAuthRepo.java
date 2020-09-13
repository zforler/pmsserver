package com.wk.platform.report;

import com.wk.bean.ReportAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportAuthRepo extends JpaRepository<ReportAuth,Integer> {
    int deleteByCustomerIdAndReportId(String customerId,int reportId);
    int deleteAllByReportId(int reportId);
}
