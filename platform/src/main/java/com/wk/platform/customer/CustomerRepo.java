package com.wk.platform.customer;

import com.wk.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findFirstByCustomerId(String customerId);
}
