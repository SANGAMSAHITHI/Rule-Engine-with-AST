package com.example.customengine.service;

import com.example.customengine.model.ConditionNode;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class RuleProcessingService {
    public ConditionNode defineRule(String ruleDefinition) {
        String[] tokens = ruleDefinition.split(" ");
        ConditionNode leftNode = new ConditionNode("operand", null, null, tokens[0] + " " + tokens[1] + " " + tokens[2]);
        ConditionNode rightNode = new ConditionNode("operand", null, null, tokens[4] + " " + tokens[5] + " " + tokens[6]);
        return new ConditionNode("operator", leftNode, rightNode, tokens[3]);
    }

    public boolean assessRule(ConditionNode node, Map<String, Object> context) {
        if ("operand".equals(node.getNodeType())) {
            String[] conditionParts = node.getExpression().split(" ");
            String attribute = conditionParts[0];
            String operator = conditionParts[1];
            String value = conditionParts[2];
            Object contextValue = context.get(attribute);
            if (contextValue == null) return false;

            switch (operator) {
                case "=": return contextValue.equals(value);
                case ">": return Integer.parseInt(contextValue.toString()) > Integer.parseInt(value);
                case "<": return Integer.parseInt(contextValue.toString()) < Integer.parseInt(value);
                default: return false;
            }
        }
        if ("operator".equals(node.getNodeType())) {
            if ("AND".equals(node.getExpression())) return assessRule(node.getLeft(), context) && assessRule(node.getRight(), context);
            if ("OR".equals(node.getExpression())) return assessRule(node.getLeft(), context) || assessRule(node.getRight(), context);
        }
        return false;
    }
}
