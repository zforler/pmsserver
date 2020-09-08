package com.wk.platform.record;

import com.wk.bean.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record,String> {
}
