package com.sonar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AppExpressionTest {

    @ParameterizedTest
    @CsvSource({"4+5*6+8,42","4+3+2,9","1,1","0*5,0","7+0*5,7"})
    public void testCalculate(String input, Integer expected){
        AppExpression expression = new AppExpression(input);
        expression.evaluateExpression();
        assertThat(expression.evaluateExpression(),equalTo(expected));
    }
}
