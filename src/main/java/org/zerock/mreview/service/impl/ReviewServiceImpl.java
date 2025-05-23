/*
package org.zerock.mreview.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;
import org.zerock.mreview.repository.ReviewRepository;
import org.zerock.mreview.service.ReviewService;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> getListOfMovie(Long mno) {

        Movie movie = Movie.builder().mno(mno).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        return result.stream().map(movieReview -> entityToDTO(movieReview)).collect(
            Collectors.toList());
    }

    @Override
    public Long register(ReviewDTO reviewDTO) {

        Review movieReview = dtoToEntity(reviewDTO);

        reviewRepository.save(movieReview);

        return movieReview.getReviewNum();
    }

    @Override
    public void modify(ReviewDTO reviewDTO) {

        Optional<Review> result = reviewRepository.findById(reviewDTO.getReviewnum());

        if (result.isPresent()) {

            Review movieReview = result.get();
            movieReview.changeGrade(reviewDTO.getGrade());
            movieReview.changeText(reviewDTO.getText());

            reviewRepository.save(movieReview);
        }
    }

    @Override
    public void remove(Long reviewNum) {

        reviewRepository.deleteById(reviewNum);
    }
}
*/
