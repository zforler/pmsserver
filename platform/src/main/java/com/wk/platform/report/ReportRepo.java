package com.wk.platform.report;

import com.wk.bean.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report,Integer> {
    Report findFirstByReportName(String name);
    Report findFirstByReportNameAndReportIdNot(String name,int id);
    Report findFirstByReportId(int id);
}
