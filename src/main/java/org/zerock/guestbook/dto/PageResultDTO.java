package org.zerock.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> dtoList;

    /**
     * Constructor for PageResultDTO
     * @param result
     * Page<Entity> result
     * @param fn
     * Entity to DTO function
     */
    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.map(fn).getContent();
    }
}
