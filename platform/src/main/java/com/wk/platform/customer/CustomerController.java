package com.wk.platform.customer;

import com.wk.bean.Customer;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.role.RoleController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private CustomerService customerService;

    @ApiOperation("添加客户")
    @PostMapping("/customer")
    public Result<Customer> addCustomer(Customer customer, String operateUserId){
        try {
            Result<Customer> result = customerService.addCustomer(customer, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改客户")
    @PostMapping("/updateCustomer")
    public Result<Customer> updateCustomer(Customer customer, String operateUserId){
        try {
            Result<Customer> result = customerService.updateCustomer(customer, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除客户")
    @PostMapping("/deleteCustomer")
    public Result<Customer> deleteCustomer(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Customer> result = customerService.deleteCustomer(customerId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下客户列表")
    @GetMapping("/getCustomerList")
    public Result<List<Customer>> getCustomerList(String keyword,  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return customerService.getCustomerList(keyword,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取客户分页列表")
    @GetMapping("/getCustomerPageList")
    public Result<PageList<Customer>> getCustomerPageList(String keyword, int page, int size, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return customerService.getCustomerPageList(keyword, page, size, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
