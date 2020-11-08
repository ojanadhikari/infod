package com.infodev.fpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infodev.fpro.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {

}
