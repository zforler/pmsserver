package com.wk.platform.technology;

import com.wk.bean.Technology;
import com.wk.common.vo.Result;

import java.util.List;

public interface TechnologyService {
    Result<Technology> addTechnology(Technology technology, String operateUserId);

    Result updateTechnology(Technology technology,String operateUserId);

    Result deleteTechnology(String technologyId,String operateUserId);

    Result<List<Technology>> getTechnologyList(String keyword, String customerId, String operateUserId);
}
