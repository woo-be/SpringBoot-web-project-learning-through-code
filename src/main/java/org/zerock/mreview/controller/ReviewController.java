/*
package org.zerock.mreview.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno) {
        log.info("----------------list-----------------");
        log.info("MNO: " + mno);

        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);

        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO movieReviewDTO) {
        log.info("----------------add Review-----------------");
        log.info("movieReviewDTO: " + movieReviewDTO);

        Long reviewNum = reviewService.register(movieReviewDTO);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    @PutMapping("{mno}/{reviewNum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewNum,
        @RequestBody ReviewDTO movieReviewDTO) {
        log.info("----------------modify Review-----------------");
        log.info("reviewDTO: " + movieReviewDTO);

        reviewService.modify(movieReviewDTO);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    @DeleteMapping("{mno}/{reviewNum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewNum) {
        log.info("----------------remove Review-----------------");
        log.info("reviewNum: " + reviewNum);

        reviewService.remove(reviewNum);

        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }
}
*/
