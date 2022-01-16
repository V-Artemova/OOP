package com.company;

public class And implements IOperation{
    @Override
    public String nameOperation() {
        return "And";
    }

    @Override
    public String sing() {
        return "^" ;
    }

    @Override
    public String estimate(int first_number, int second_number) {

        int result = first_number & second_number;
        String result_bin = Integer.toBinaryString(result);
        return (result_bin);
    }
}
