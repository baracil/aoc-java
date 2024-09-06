package fpc.aoc.common;

public enum Logger {
    DEBUG() {
        @Override
        public void log(String message) {
            System.out.println(message);
        }
    },
    NOP() {
        @Override
        public void log(String message) {}

        @Override
        public void log(String format, Object arg1) {}

        @Override
        public void log(String format, Object arg1, Object arg2) {}
    },
    ;

    public abstract void log(String message);

    public void log(String format, Object arg1) {
        log(String.format(format,arg1));
    }

    public void log(String format, Object arg1, Object arg2) {
        log(String.format(format,arg1,arg2));
    }

    public void log(String format, Object arg1, Object arg2, Object arg3) {
        log(String.format(format,arg1,arg2,arg3));
    }

    public static Logger get() {
        return enabled?DEBUG:NOP;
    }

    private static final boolean enabled = Boolean.getBoolean("debug");
}
