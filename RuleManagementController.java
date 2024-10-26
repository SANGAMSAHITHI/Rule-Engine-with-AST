package com.example.customengine.controller;

import com.example.customengine.model.ConditionNode;
import com.example.customengine.service.RuleProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleManagementController {

    @Autowired
    private RuleProcessingService ruleProcessingService;

    @PostMapping("/define")
    public ConditionNode defineRule(@RequestParam String ruleDefinition) {
        return ruleProcessingService.defineRule(ruleDefinition);
    }

    @PostMapping("/assess")
    public boolean assessRule(@RequestBody ConditionNode node, @RequestBody Map<String, Object> context) {
        return ruleProcessingService.assessRule(node, context);
    }
}
