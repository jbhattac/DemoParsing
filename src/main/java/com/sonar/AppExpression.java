package com.sonar;

public class AppExpression {

    public static final String REGEX_MULT = "\\*";
    public static final String REGEX_PLUS = "\\+";

    private final String  expression;

    public AppExpression(String expression) {
        this.expression = expression;
        split = new String[5][5];
    }

    private  String [][] split;

    public static void main(String[] args) {
        String input = "0*5";
        AppExpression expression = new AppExpression(input);
        expression.evaluateExpression();
    }
    public int evaluateExpression() {
        populate(this.expression);
        return calculate(split);
    }

    private  void populate(String test) {
        String [] splitByPlus = parse(test,"\\+");
        for (int i =0; i < splitByPlus.length;i++ ) {
            split[i] = parse(splitByPlus[i],REGEX_MULT);
        }
    }

    public   String [] parse(String expression, String regx){
        return expression.split(regx);
    }

    private  int calculate(String [][] arr){
        int adder=0;
        for (int row = 0; row < arr.length; row++)
        {
            int mult =0;
            boolean isAlreadyMultiplied= false;
            for (int col = 0; col < arr[row].length; col++)
            {
                if(null != arr[row][col] ){
                  if(isAlreadyMultiplied)
                      mult = mult*Integer.parseInt(arr[row][col]);
                  else {
                      isAlreadyMultiplied = true;
                      mult = Integer.parseInt(arr[row][col]);
                  }

                }

             }
            adder = adder+ mult;

        }

        System.out.println("result "+adder);
        return adder;
    }


}
