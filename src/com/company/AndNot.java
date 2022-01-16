package com.company;

public class AndNot implements IOperation{
    @Override
    public String nameOperation() {
        return "AND - NOT";
    }

    @Override
    public String sing() {
        return "|";
    }

    @Override
    public String estimate(int first_number, int second_number) {

        int result = ~(first_number & second_number);

        String str = String.format("%s", Integer.toBinaryString(result)).replaceAll("11111111111111111111111111111", "");

        return (str);

    }
}
