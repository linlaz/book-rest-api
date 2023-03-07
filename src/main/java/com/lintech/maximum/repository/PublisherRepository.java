package com.lintech.maximum.repository;

import com.lintech.maximum.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    @Modifying
    @Query(value = "UPDATE publisher SET name_publisher = :name, address_publisher = :address, desc_publisher = :desc WHERE id = :id", nativeQuery = true)
    Publisher updateAll(String name, String address, String desc, Long id);

    Publisher getPublisherById(Long id);
}
