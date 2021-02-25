package basic.reflact;

import java.lang.reflect.Field;

public class FixField implements Comparable<FixField>{
    private Field field;

    private Integer order;
    private Integer length;
    private String align;
    private char padSpace;


    public FixField(Field field, Integer order, Integer length, String align, char padSpace) {
        this.field = field;
        this.order = order;
        this.length = length;
        this.align = align;
        this.padSpace = padSpace;
    }

    public FixField() {
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public char getPadSpace() {
        return padSpace;
    }

    public void setPadSpace(char padSpace) {
        this.padSpace = padSpace;
    }

    @Override
    public int compareTo(FixField fixField) {
        return this.order - fixField.order;
    }
}
