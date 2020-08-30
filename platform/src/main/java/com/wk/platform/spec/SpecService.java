package com.wk.platform.spec;

import com.wk.bean.Spec;
import com.wk.common.vo.Result;

import java.util.List;

public interface SpecService {
    Result<Spec> addSpec(Spec spec, String operateUserId);

    Result updateSpec(Spec spec,String operateUserId);

    Result deleteSpec(String specId,String operateUserId);

    Result<List<Spec>> getSpecList(String keyword, String customerId, String operateUserId);
}
