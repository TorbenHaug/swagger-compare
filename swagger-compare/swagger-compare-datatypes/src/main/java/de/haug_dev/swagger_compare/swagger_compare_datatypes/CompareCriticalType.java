package de.haug_dev.swagger_compare.swagger_compare_datatypes;

public enum CompareCriticalType{
    CRITICAL(3),
    WARNING(2),
    INFO(1),
    NONE(0);

    private int level;

    CompareCriticalType(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public CompareCriticalType greater(CompareCriticalType other){
        return this.getLevel() < other.getLevel() ? other : this;
    }
}
