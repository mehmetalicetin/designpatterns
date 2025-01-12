package com.i2i.ssa.api.customer.repository;

import com.i2i.ssa.api.core.repository.BaseRepository;
import com.i2i.ssa.api.customer.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}
