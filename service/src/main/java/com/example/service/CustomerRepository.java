package com.example.service;

import com.example.service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @RestResource(path = "name")
    Collection<Customer> findByCustomerName(@Param("cname") String customerName);
}
