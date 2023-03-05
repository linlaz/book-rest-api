package com.lintech.maximum.repository;

import com.lintech.maximum.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Modifying
    @Query(value = "UPDATE Author SET name_author = :name, desc_author = :desc WHERE id = :id", nativeQuery = true)
    Integer updateAllEntityByIdAndParameter(Long id,String name, String desc);

}
