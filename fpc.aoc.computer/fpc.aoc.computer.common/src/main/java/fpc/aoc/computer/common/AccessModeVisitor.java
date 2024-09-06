package fpc.aoc.computer.common;

/**
 * @author perococco
 **/
public interface AccessModeVisitor {

    int visitImmediate(int input);

    int visitPosition(int input);

    int visitRelative(int parameter);
}
