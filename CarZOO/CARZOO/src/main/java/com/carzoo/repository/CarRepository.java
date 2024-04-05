package com.carzoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carzoo.model.CarInfo;

import jakarta.transaction.Transactional;

public interface CarRepository extends JpaRepository<CarInfo, Integer> {
	
	
	@Query("SELECT p FROM CarInfo p WHERE p.brand_name LIKE %:keyword%"
		    +" OR p.carname LIKE %:keyword%"
		    +" OR p.color LIKE %:keyword%"
		    +" OR p.transmission LIKE %:keyword%"
		    +" OR p.engine_type LIKE %:keyword%"
		)
		public List<CarInfo> findAll(@Param("keyword") String keyword);
	
	@Transactional
	@Modifying
	@Query("UPDATE CarInfo c SET c.cust_name = :custName, c.dateofpurchase = :dateOfPurchase, " +
		       "c.sellingprice = :sellingPrice, c.email = :email, c.transactionid = :transactionId, " +
		       "c.phno = :phno, c.status = :status WHERE c.id = :carId")
		void updateCarInfoDetails(@Param("carId") int carId, @Param("custName") String custName,
		                          String dateOfPurchase, @Param("sellingPrice") long sellingPrice,
		                          @Param("email") String email, @Param("transactionId") String transactionId,
		                          @Param("phno") String phno, @Param("status") String status);
	
	
	
	
	
	
	
	
	@Query("SELECT p FROM CarInfo p WHERE ("
	        + "p.cust_name LIKE %:keyword%"
	        + " OR p.carname LIKE %:keyword%"
	        + " OR p.email LIKE %:keyword%"
	        + " OR p.phno LIKE %:keyword%)"
	        + " AND p.status = 'sold'"
	)
	public List<CarInfo> findAllsoldcars(@Param("keyword") String keyword);

	 @Query("SELECT c FROM CarInfo c WHERE c.status = 'unsold'")
	 List<CarInfo> findBystatus();
	 
	 @Query("SELECT c FROM CarInfo c WHERE c.status = 'sold' ORDER BY c.dateofpurchase DESC")
	 List<CarInfo> findBysoldstatus();
	 
	 @Query("SELECT c FROM CarInfo c WHERE c.status = 'unsold' AND c.buyprice < :buyPrice")
	 List<CarInfo> findUnsoldCarsBelowBudget(@Param("buyPrice")int buyprice);
}
