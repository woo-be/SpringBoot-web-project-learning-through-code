package org.zerock.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 페이지 결과 화면 구성에 필요한 데이터를 담는 DTO 클래스
 * @param <DTO>
 *     DTO
 * @param <EN>
 *     Entity
 */
@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> dtoList;

    private int totalPage;

    /**
     * 현재 페이지 번호
     */
    private int page;

    private int size;

    /**
     * 시작 페이지, 끝 페이지
     * 화면에 보여지는 시작 페이지 번호와 끝 페이지 번호
     * 만약 한 화면에 10페이지씩 보여진다면, start=1, end=10 데이터가 부족하면 start=1, end=5
     */
    private int start, end;

    private boolean prev, next;

    private List<Integer> pageList;

    /**
     * Constructor for PageResultDTO
     * @param result
     * Page<Entity> result
     * @param fn
     * Entity to DTO function
     */
    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();

        int tempEnd = (int) (Math.ceil(page / 10.0)) * 10;

        start = tempEnd - 9;

        prev = start > 1;

        end = totalPage > tempEnd ? tempEnd : totalPage;

        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
