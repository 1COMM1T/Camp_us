package com.commit.campus.repository;

import com.commit.campus.entity.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Long> {

    @Query(value = "SELECT * FROM camping WHERE do_name = :doName AND (:sigunguName IS NULL OR sigungu_name = :sigunguName) " +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Camping> findCampings(@Param("doName") String doName,
                               @Param("sigunguName") String sigunguName,
                               @Param("offset") int offset,
                               @Param("limit") int limit);

    @Query(value = "SELECT COUNT(*) FROM camping WHERE do_name = :doName AND (:sigunguName IS NULL OR sigungu_name = :sigunguName)", nativeQuery = true)
    long countCampings(@Param("doName") String doName,
                       @Param("sigunguName") String sigunguName);
}
