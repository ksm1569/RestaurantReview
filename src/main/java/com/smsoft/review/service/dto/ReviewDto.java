package com.smsoft.review.service.dto;

import com.smsoft.review.model.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPate page;
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewDtoPate {
        private Integer offset;
        private Integer limit;
    }
}
