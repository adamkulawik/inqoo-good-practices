package com.inqoo.quality.clean.example.good;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TaxTest {

    @Test
    @Parameters(method = "taxParams")
    public void calculateTax(BigDecimal base, BigDecimal expectedTax) {
        // given
        PITCalculator PITCalculator = new PITCalculator(valueOf(8000), valueOf(85528), valueOf(1000000), new BigDecimal("0.17"), new BigDecimal("0.32"), new BigDecimal("0.04"));

        // when
        BigDecimal calculatedTax = PITCalculator.calculate(base);

        // then
        assertThat(calculatedTax).isEqualTo(expectedTax);
    }

    public Object taxParams() {
        return $(
                $(BigDecimal.valueOf(8000), BigDecimal.ZERO),
                $(BigDecimal.valueOf(8001), BigDecimal.ZERO),
                $(BigDecimal.valueOf(10000), BigDecimal.valueOf(674)),
                $(BigDecimal.valueOf(13000), BigDecimal.valueOf(1685)),
                $(BigDecimal.valueOf(13001), BigDecimal.valueOf(1685)),
                $(BigDecimal.valueOf(85527), BigDecimal.valueOf(14014)),
                $(BigDecimal.valueOf(85528), BigDecimal.valueOf(14015)),
                $(BigDecimal.valueOf(85529), BigDecimal.valueOf(14015)),
                $(BigDecimal.valueOf(127000), BigDecimal.valueOf(27811)),
                $(BigDecimal.valueOf(127001), BigDecimal.valueOf(27811)),
                $(BigDecimal.valueOf(999999), BigDecimal.valueOf(307170)),
                $(BigDecimal.valueOf(1000000), BigDecimal.valueOf(307171)),
                $(BigDecimal.valueOf(1000001), BigDecimal.valueOf(307171))
        );

    }
}
