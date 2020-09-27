package com.wk.platform.recordEdit;

import com.wk.bean.RecordEditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordEditLogRepo extends JpaRepository<RecordEditLog,Integer> {
}
