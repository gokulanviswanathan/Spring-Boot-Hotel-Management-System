package com.hotelmgmt.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hotelmgmt.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>, JpaSpecificationExecutor<Hotel> {

	//Multiple filter by City using SQL IN clause in the SELECT query
	Page<Hotel> findByCityIn(List<String> cities, Pageable pageable);
}
