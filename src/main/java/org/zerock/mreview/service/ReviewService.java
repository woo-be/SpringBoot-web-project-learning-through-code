package org.zerock.mreview.service;

import java.util.List;
import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

public interface ReviewService {

    List<ReviewDTO> getListOfMovie(Long mno);

    Long register(ReviewDTO reviewDTO);

    void modify(ReviewDTO reviewDTO);

    void remove(Long reviewNum);

    default Review dtoToEntity(ReviewDTO reviewDTO) {

        Review movieReview = Review.builder()
            .reviewNum(reviewDTO.getReviewnum())
            .movie(Movie.builder().mno(reviewDTO.getMno()).build())
            .member(Member.builder().mid(reviewDTO.getMid()).build())
            .grade(reviewDTO.getGrade())
            .text(reviewDTO.getText())
            .build();

        return movieReview;
    }

    default ReviewDTO entityToDTO(Review movieReview) {

        ReviewDTO reviewDTO = ReviewDTO.builder()
            .reviewnum(movieReview.getReviewNum())
            .mno(movieReview.getMovie().getMno())
            .mid(movieReview.getMember().getMid())
            .nickname(movieReview.getMember().getNickname())
            .email(movieReview.getMember().getEmail())
            .grade(movieReview.getGrade())
            .text(movieReview.getText())
            .regDate(movieReview.getRegDate())
            .modDate(movieReview.getModDate())
            .build();

        return reviewDTO;
    }
}
