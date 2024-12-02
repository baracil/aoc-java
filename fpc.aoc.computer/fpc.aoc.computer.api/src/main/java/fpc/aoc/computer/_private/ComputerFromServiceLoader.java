package fpc.aoc.computer._private;

import fpc.aoc.common.AOCException;
import fpc.aoc.computer.*;
import lombok.NonNull;

import java.util.ServiceLoader;

/**
 * @author Bastien Aracil
 **/
public class ComputerFromServiceLoader implements Computer {

    @NonNull
    private final Computer delegate;

    public ComputerFromServiceLoader(BitSize minimalBitSize,MemoryType memoryType) {
        this.delegate = findComputerFactoryOnProperty(minimalBitSize,memoryType).create();
    }

    @Override
    public Program compile(String code) {
        return delegate.compile(code);
    }

    @NonNull
    private static ComputerFactory findComputerFactoryOnProperty(BitSize minimalBitSize,MemoryType memoryType) {
        final ServiceLoader<ComputerFactory> serviceLoader = ServiceLoader.load(ComputerFactory.class);
        return serviceLoader.stream()
                            .map(ServiceLoader.Provider::get)
                            .filter(f -> f.verifyAllProperties(minimalBitSize,memoryType))
                            .findAny()
                            .orElseThrow(() -> new AOCException("Cannot find any computer matching the provided properties : "+minimalBitSize+" & "+memoryType));
    }
}
