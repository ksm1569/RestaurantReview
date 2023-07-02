package com.smsoft.review.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld(){
        return "hello, world";
    }

    @GetMapping("/Sale/data2")
    public List<Sale> saleData(){
        Sale item1 = new Sale(3, "그리디 캣 레귤러핏 티셔츠","바이오 스판 원단",39000, "" +
                "https://github.com/ksm1569/RestaurantReview/assets/34292113/8b628099-fa0a-4d0a-9dfc-69441115db11");
        Sale item2 = new Sale(4, "유니폼 브이넥 티셔츠","스트릿 패션",59000, "" +
                "https://github.com/ksm1569/RestaurantReview/assets/34292113/f9606cbd-698a-4a01-9fd5-30c7a7fded1a");
        Sale item3 = new Sale(5, "로고 레이블 티셔츠","20수 싱크 코튼",39000, "" +
                "https://github.com/ksm1569/RestaurantReview/assets/34292113/11724f50-869c-436a-bf33-158b10d30cc3");

        List<Sale> sales = new ArrayList<>();
        sales.add(item1);
        sales.add(item2);
        sales.add(item3);

        return sales;
    }

    @Data
    @AllArgsConstructor
    static class Sale {
        private int id;
        private String title;
        private String content;
        private int price;
        private String src;
    }
}
