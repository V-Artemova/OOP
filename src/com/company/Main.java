package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        IOperation[] operations_OR = new IOperation[]{
                new Or()

        };

        IOperation[] operations_AND = new IOperation[]{
                new And()

        };

        IOperation[] operations_XOR = new IOperation[]{
                new Xor()

        };


        IOperation[] operations_ANDNOT = new IOperation[]{
                new AndNot()

        };

        int second_number = 4;
        int first_number = 6;
        String first_number_bin = Integer.toBinaryString(first_number);
        String second_number_bin = Integer.toBinaryString(second_number);

        for (IOperation op : operations_OR) {
            System.out.printf(op.nameOperation());
            System.out.printf(":   %s %s %s = %s",
                    first_number_bin,
                    op.sing(),
                    second_number_bin, op.estimate(first_number, second_number));
        }

        System.out.println("");
        for (IOperation op : operations_XOR) {
            System.out.printf(op.nameOperation());
            System.out.printf(":  %s %s %s = %s",
                    first_number_bin,
                    op.sing(),
                    second_number_bin, op.estimate(first_number, second_number));

        }

        System.out.println("");
        for (IOperation op : operations_AND) {
            System.out.printf(op.nameOperation());
            System.out.printf(":  %s %s %s = %s",
                    first_number_bin,
                    op.sing(),
                    second_number_bin, op.estimate(first_number, second_number));
        }

        System.out.println("");
        for (IOperation op : operations_ANDNOT) {
            System.out.printf(op.nameOperation());
            System.out.printf(":  %s %s %s = %s",
                    first_number_bin,
                    op.sing(),
                    second_number_bin,
                    op.estimate(first_number, second_number));
        }

    }
}