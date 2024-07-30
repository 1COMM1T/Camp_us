package com.commit.campus.repository;

import com.commit.campus.entity.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Long> {
    // 오프셋 기반 페이지네이션 사용, doName이 null일 경우 전체 조회
    @Query(value = "SELECT * FROM camping WHERE (:doName IS NULL OR do_name = :doName) AND (:sigunguName IS NULL OR sigungu_name = :sigunguName) " +
            "ORDER BY camp_id " +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Camping> findCampings(@Param("doName") String doName,
                               @Param("sigunguName") String sigunguName,
                               @Param("offset") int offset,
                               @Param("limit") int limit);

    @Query(value = "SELECT COUNT(*) FROM camping WHERE (:doName IS NULL OR do_name = :doName) AND (:sigunguName IS NULL OR sigungu_name = :sigunguName)", nativeQuery = true)
    long countCampings(@Param("doName") String doName,
                       @Param("sigunguName") String sigunguName);
}

