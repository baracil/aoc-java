package fpc.aoc.year2019.day21._private;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bastien Aracil
 **/
public class Node {

    private final int param;

    private final Node trueNode;

    private final Node falseNode;

    private final TriBool value;

    public Node(TruthTable truthTable) {
        this(truthTable, 0, 0);
    }

    public Node(int param, TriBool value) {
        this.param = param;
        this.trueNode = null;
        this.falseNode = null;
        this.value = value;
    }

    public Node(int param, Node trueNode, Node falseNode) {
        this.param = param;
        this.trueNode = trueNode;
        this.falseNode = falseNode;
        this.value = null;
    }

    private Node(TruthTable truthTable, int param, int value) {
        this.param = param;
        if (param == truthTable.nbParameters()) {
            this.value = truthTable.value(value);
            this.trueNode = null;
            this.falseNode = null;
        } else {
            this.value = null;
            this.trueNode = new Node(truthTable, param + 1, value | 1 << param);
            this.falseNode = new Node(truthTable, param + 1, value);
        }

    }

    @NonNull
    public String expression(ParameterNames parameterNames) {
        if (isLeaf()) {
            return value+"";
        }
        return String.join("+", gatherTerms(parameterNames, "", new ArrayList<>()));
    }

    private List<String> gatherTerms(ParameterNames parameterNames, String str, List<String> terms) {
        if (this.isLeaf()) {
            if (value == TriBool.TRUE) {
                terms.add(str);
            }
        } else {
            final String trueForm = parameterNames.trueForm(param);
            final String falseForm = parameterNames.falseForm(param);
            trueNode.gatherTerms(parameterNames,str+trueForm,terms);
            falseNode.gatherTerms(parameterNames,str+falseForm,terms);
        }
        return terms;
    }


    public boolean isLeaf() {
        return value != null;
    }

    private boolean isSimilarTo(Node otherNode) {
        if (isLeaf()!=otherNode.isLeaf()) {
            return false;
        }
        if (isLeaf() && otherNode.isLeaf()) {
            return this.value.isSimilarTo(otherNode.value);
        }
        return this.trueNode.isSimilarTo(otherNode.trueNode) && this.falseNode.isSimilarTo(otherNode.falseNode);
    }

    public Node simplify() {
        if (isLeaf()) {
            return this;
        }
        final Node trueNode = this.trueNode.simplify();
        final Node falseNode = this.falseNode.simplify();

        if (trueNode.isSimilarTo(falseNode)) {
            if (trueNode.isLeaf()) {
                return new Node(param,trueNode.value.compose(falseNode.value));
            }
            else {
                return new Node(trueNode.param,trueNode.trueNode,trueNode.falseNode);
            }
        } else {
            return new Node(param,trueNode,falseNode);
        }
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            return value.toString();
        }
        else {
            return "{" +
                   "param=" + param +
                   ", true=" + trueNode +
                   ", false=" + falseNode +
                   '}';
        }
    }
}
