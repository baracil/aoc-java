package fpc.aoc.computer.primitive._private;

public interface ParameterAccessor {

    long getParameter(int position);

    void setParameter(int position, long value);
}
