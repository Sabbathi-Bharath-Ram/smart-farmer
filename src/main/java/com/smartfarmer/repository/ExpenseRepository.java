package com.smartfarmer.repository;

import com.smartfarmer.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {}
