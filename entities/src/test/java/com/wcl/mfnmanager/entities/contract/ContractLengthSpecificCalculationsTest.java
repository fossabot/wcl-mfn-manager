package com.wcl.mfnmanager.entities.contract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ContractLengthSpecificCalculationsTest {
    private ContractLengthSpecificCalculations testSubject;

    @BeforeEach
    public void setupTestSubject() {
        testSubject = new ContractLengthSpecificCalculations(6, generateTestSalaryAndBonusData());
    }

    @Test
    public void checkNumberOfYearsOnContractCalculatedCorrectly() {
        assertEquals(6, testSubject.years(), "Number of years was incorrect");
    }

    @Test
    public void checkTotalSalaryCalculatedCorrectly() {
        assertEquals(7_500, testSubject.totalRemuneration().totalSalary(), "Total salary was incorrect");
    }

    @Test
    public void checkTotalBonusCalculatedCorrectly() {
        assertEquals(27_000, testSubject.totalRemuneration().totalBonus(), "Total bonus was incorrect");
    }

    @Test
    public void checkTotalRemunerationCalculatedCorrectly() {
        assertEquals(34_500, testSubject.totalRemuneration().overallTotal(), "Total remuneration was incorrect");
    }


    private List<YearContractCalculation> generateTestSalaryAndBonusData() {
        return List.of(
                new YearContractCalculation(1, 1000, 2000),
                new YearContractCalculation(2, 1100, 3000),
                new YearContractCalculation(3, 1200, 4000),
                new YearContractCalculation(4, 1300, 5000),
                new YearContractCalculation(5, 1400, 6000),
                new YearContractCalculation(6, 1500, 7000));
    }
}