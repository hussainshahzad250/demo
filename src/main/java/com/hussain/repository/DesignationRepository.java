package com.hussain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hussain.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

}
