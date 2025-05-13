package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.ActivityLogCriteriaDTO;
import com.boot.dto.ActivityLogDTO;

@Mapper
public interface ActivityLogDAO {
    // 로그 추가
    public void insertActivityLog(ActivityLogDTO log);
    
    // 최근 로그 가져오기 (개수 제한)
    public ArrayList<ActivityLogDTO> getRecentActivities(int limit);
    
    // 특정 유형의 활동 로그만 가져오기
    public ArrayList<ActivityLogDTO> getActivitiesByType(String activityType, int limit);
    
    // 모든 로그 가져오기 (페이징 처리)
    public ArrayList<ActivityLogDTO> getAllActivities(HashMap<String, Object> params);
    
    // 총 로그 수 가져오기
    public int getTotalLogCount();
    
    // 모든 로그 가져오기 (Criteria 객체 활용)
    public ArrayList<ActivityLogDTO> getAllActivities(ActivityLogCriteriaDTO cri);
    
    // 총 로그 수 가져오기 (필터링 적용)
    public int getTotalLogCount(ActivityLogCriteriaDTO cri);
} 