package fpc.aoc.computer.common;

/**
 * @author Bastien Aracil
 **/
public interface AccessModeVisitor {

    int visitImmediate(int input);

    int visitPosition(int input);

    int visitRelative(int parameter);
}
