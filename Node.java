package com.example.customengine.model;

public class ConditionNode {
    private String nodeType;  
    private ConditionNode left;        
    private ConditionNode right;       
    private String expression;     

    public ConditionNode(String nodeType, ConditionNode left, ConditionNode right, String expression) {
        this.nodeType = nodeType;
        this.left = left;
        this.right = right;
        this.expression = expression;
    }

    // Getters and Setters
    public String getNodeType() { return nodeType; }
    public ConditionNode getLeft() { return left; }
    public ConditionNode getRight() { return right; }
    public String getExpression() { return expression; }
}
