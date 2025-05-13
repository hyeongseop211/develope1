package com.boot.dto;

import lombok.Data;

@Data
public class ActivityLogCriteriaDTO {
    private int pageNum; // 페이지 번호
    private int amount; // 페이지당 로그 갯수
    private String activityType; // 정확한 활동 유형
    private String categoryFilter; // 카테고리 필터 (book, user, notice 등)
    private String actorType; // 수행자 유형 필터

    public ActivityLogCriteriaDTO() {
        this(1, 10);
    }

    public ActivityLogCriteriaDTO(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
} 