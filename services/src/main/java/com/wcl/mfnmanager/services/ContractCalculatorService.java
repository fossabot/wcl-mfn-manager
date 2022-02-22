package com.wcl.mfnmanager.services;

import com.wcl.mfnmanager.entities.contract.ContractCalculation;
import com.wcl.mfnmanager.entities.contract.ContractLengthSpecificCalculations;
import com.wcl.mfnmanager.entities.contract.YearContractCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class ContractCalculatorService {
    private static final BiFunction<Integer, Integer, Integer> MAX_SALARY = (suggSalary, minSalary) -> suggSalary > minSalary ? suggSalary : minSalary;
    private static final BiFunction<Integer, Integer, Integer> ROUND_DIVISION = (divident, divisor) -> (int)Math.round((double)divident/divisor);

    public ContractCalculation calculateContract(int minSalary, int requiredBonus) {
        return new ContractCalculation(minSalary, requiredBonus, calculateYearlyFigures(minSalary, requiredBonus));
    }

    private List<ContractLengthSpecificCalculations> calculateYearlyFigures(int minSalary, int requiredBonus) {
        final var constantFigures = new ArrayList<ContractLengthSpecificCalculations>();
        IntStream.rangeClosed(1, 6).forEach(years -> constantFigures.add(new ContractLengthSpecificCalculations(years, calculateYearlyFigures(years, minSalary, requiredBonus))));
        return constantFigures;
    }

    private List<YearContractCalculation> calculateYearlyFigures(int years, int minSalary, int requiredBonus) {
        final var yearContractCalculations = new ArrayList<YearContractCalculation>();
        final var yearlyBonus = ROUND_DIVISION.apply(requiredBonus, years);
        final var initialSalary = MAX_SALARY.apply((int)Math.round((double)yearlyBonus/3*1.00001), minSalary);
        IntStream.rangeClosed(1, years).forEach(year -> yearContractCalculations.add(calculateYearlyFigure(year,initialSalary, yearlyBonus)));
        return yearContractCalculations;
    }
    private YearContractCalculation calculateYearlyFigure(int year, int initialSalary, int requiredBonus) {
        return new YearContractCalculation(year, (int)Math.round(initialSalary * Math.pow(1.0501, year - 1)), requiredBonus );
    }
}
