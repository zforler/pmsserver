package com.wk.platform.customer;

import com.wk.bean.Customer;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface CustomerService {
    Result<Customer> addCustomer(Customer customer, String operateUserId);

    Result<Customer> updateCustomer(Customer customer,String operateUserId);

    Result deleteCustomer(String customerId,String operateUserId);

    Result<List<Customer>> getCustomerList(String keyword, String operateUserId);

    Result<PageList<Customer>> getCustomerPageList(String keyword, int page, int size,String operateUserId);

    Result<List<Customer>> getNoReportCustomerList(String keyword,int reportId, String operateUserId);

    Result<List<Customer>> getHasReportCustomerList(String keyword,int reportId, String operateUserId);
}
