package com.wk.platform.customer;

import com.wk.bean.Customer;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.user.UserInfoRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @Transactional
    @Override
    public Result<Customer> addCustomer(Customer customer, String operateUserId) {
        String customerId = seqService.getNextBusinessId(Const.BZ_CUSTOMER, "", 4);
        customer.setCustomerId(customerId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        customer.setCreateTime(currentInSecond);
        customer.setUpdateTime(currentInSecond);
        Customer newCus = customerRepo.saveAndFlush(customer);

        return Result.success(newCus);
    }

    @Override
    public Result<Customer> updateCustomer(Customer customer, String operateUserId) {
        Customer oldCus = customerRepo.findFirstByCustomerId(customer.getCustomerId());

        int currentInSecond = TimeUtil.getCurrentInSecond();
        customer.setCreateTime(oldCus.getCreateTime());
        customer.setStatus(oldCus.getStatus());
        customer.setEquipmentCount(oldCus.getEquipmentCount());
        customer.setUpdateTime(currentInSecond);

        Customer newCus = customerRepo.saveAndFlush(customer);

        return Result.success(newCus);
    }

    @Override
    public Result deleteCustomer(String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Customer>> getCustomerList(String keyword, String operateUserId) {
        List<Customer> customers = customerRepo.findAll();
        return Result.success(customers);
    }

    @Override
    public Result<PageList<Customer>> getCustomerPageList(String keyword, int page, int size, String operateUserId) {

        String sql = "SELECT * FROM customer WHERE 1=1";
        Map<String,Object> param = new HashMap<>();
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (customer_id LIKE :keyword OR company LIKE :keyword OR address LIKE :keyword" +
                    " OR concator LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "userId");
        Page<Customer> list = commonService.pageBySql(sql,param,pageable,Customer.class);

        return Result.success(new PageList<Customer>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<Customer>> getNoReportCustomerList(String keyword, int reportId, String operateUserId) {
        String sql = "SELECT * FROM customer WHERE customer_id != '0000' and  customer_id not in" +
                " (SELECT customer_id FROM report_auth WHERE report_id=:reportId)";
        Map<String,Object> param = new HashMap<>();
        param.put("reportId",reportId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (customer_id LIKE :keyword OR company LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Customer> customers = commonService.listBySql(sql, param, Customer.class);

        return Result.success(customers);
    }

    @Override
    public Result<List<Customer>> getHasReportCustomerList(String keyword, int reportId, String operateUserId) {
        String sql = "SELECT * FROM customer WHERE customer_id != '0000' and customer_id in" +
                " (SELECT customer_id FROM report_auth WHERE report_id=:reportId)";
        Map<String,Object> param = new HashMap<>();
        param.put("reportId",reportId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (customer_id LIKE :keyword OR company LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Customer> customers = commonService.listBySql(sql, param, Customer.class);

        return Result.success(customers);
    }
}
