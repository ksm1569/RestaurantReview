package com.smsoft.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest {
    private Long restaurantId;
    private String content;
    private Double score;
}
