package com.hussain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hussain.entity.AmazonCategory;

@Repository
public interface AmazonCategoryRepository extends JpaRepository<AmazonCategory, Long> {

}
