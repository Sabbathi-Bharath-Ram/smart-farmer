package com.smartfarmer.repository;

import com.smartfarmer.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {}
