package org.zerock.mreview.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct r) from Movie m "
        + "left outer join MovieImage mi on mi.movie = m "
        + "left outer join Review r on r.movie = m group by m")
    Page<Object[]> getListPage(Pageable pageable);

//    @Query("select m, i, count(distinct r) from Movie m "
//        + "left outer join MovieImage i on i.movie = m and "
//        + "i.inum = (select max(i2.inum) from MovieImage i2 where i2.movie = m ) "
//        + "left outer join Review r on r.movie = m group by m")
//    Page<Object[]> getListPage1(Pageable pageable);

    @Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct(r)) from Movie m "
        + "left outer join MovieImage mi on mi.movie = m "
        + "left outer join Review r on r.movie = m "
        + "where m.mno = :mno group by mi")
    List<Object[]> getMovieWithAll(Long mno);
}
