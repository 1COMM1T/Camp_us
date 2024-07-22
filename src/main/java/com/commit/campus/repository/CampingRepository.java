package com.commit.campus.repository;

import com.commit.campus.entity.Camping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CampingRepository extends JpaRepository<Camping, Long> {

    @Query("SELECT c FROM Camping c WHERE " +
            "(:doName IS NULL OR c.doName = :doName) AND " +
            "(:sigunguName IS NULL OR c.sigunguName = :sigunguName) AND " +
            "(:induty IS NULL OR c.induty = :induty) " +
            "ORDER BY c.createdDate DESC")
    Page<Camping> findByFilters(@Param("doName") String doName,
                                @Param("sigunguName") String sigunguName,
                                @Param("induty") String induty,
                                Pageable pageable);
}
