package com.company;

public class Or implements IOperation {
    @Override
    public String nameOperation() {
        return "OR";
    }

    @Override
    public String sing() {
        return "Ⅴ" ;
    }

    @Override
    public String estimate(int first_number, int second_number) {

        int result = first_number | second_number;
        String result_bin = Integer.toBinaryString(result);
        return (result_bin);
    }
}
