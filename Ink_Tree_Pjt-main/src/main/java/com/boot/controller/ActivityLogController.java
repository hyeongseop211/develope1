package com.boot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.controller.util.ActivityTypeManager;
import com.boot.controller.util.ActivityTypeManager.FilterOption;
import com.boot.dto.ActivityLogCriteriaDTO;
import com.boot.dto.ActivityLogDTO;
import com.boot.dto.PageDTO;
import com.boot.service.ActivityLogService;

@Controller
public class ActivityLogController {
    
    @Autowired
    private ActivityLogService activityLogService;
    
    // 활동 로그 전체 보기 페이지
    @RequestMapping("/activity_log")
    public String viewActivityLog(Model model, 
                                 @RequestParam(defaultValue = "1") int pageNum,
                                 @RequestParam(defaultValue = "10") int amount,
                                 @RequestParam(required = false) String filter) {
        
        // 페이징 및 필터링을 위한 Criteria 객체 생성
        ActivityLogCriteriaDTO cri = new ActivityLogCriteriaDTO(pageNum, amount);
        
        // 필터 옵션 적용
        if(filter != null) {
            for(FilterOption option : ActivityTypeManager.getFilterOptions()) {
                if(option.getCode().equals(filter)) {
                    cri.setCategoryFilter(option.getCategoryFilter());
                    cri.setActorType(option.getActorFilter());
                    break;
                }
            }
        }
        
        // 활동 로그 목록 조회
        ArrayList<ActivityLogDTO> logList = activityLogService.getAllActivities(cri);
        model.addAttribute("logList", logList);
        
        // 페이징 처리를 위한 총 로그 수 조회
        int totalLogs = activityLogService.getTotalLogCount(cri);
        model.addAttribute("pageMaker", new PageDTO(totalLogs, pageNum, amount));
        
        // 필터 옵션을 모델에 추가
        model.addAttribute("filterOptions", ActivityTypeManager.getFilterOptions());
        model.addAttribute("criteria", cri);
        model.addAttribute("activityTypeManager", new ActivityTypeManager());
        
        return "activity_log";
    }
} 