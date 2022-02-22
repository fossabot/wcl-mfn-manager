/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.entities.contract;

import java.util.List;

/**
 * Contains the contract calculations for the specified number of years.
 * <p>
 * The number of years is stored, along with the calculations for each of those years.
 * <p>
 * The total renumeration over the contract is calculated via a dedicated method, summing the salary
 * and bonus for each year.
 *
 * @param years                    - the number of years of the contract.
 * @param yearContractCalculations - the specific calculations for each year of the contract.
 * @see YearContractCalculation
 */
public record ContractLengthSpecificCalculations(int years,
                                                 List<YearContractCalculation> yearContractCalculations) {

    /**
     * Calculate the total renumeration over a contract period by summing up the salary and bonus values.
     *
     * @return YearContractTotalRemuneration the total renumeration over the course of the contract.
     */
    public YearContractTotalRemuneration totalRemuneration() {
        final var totalSalary = yearContractCalculations.stream().mapToInt(YearContractCalculation::salary).sum();
        final var totalBonus = yearContractCalculations.stream().mapToInt(YearContractCalculation::bonus).sum();

        return new YearContractTotalRemuneration(totalSalary,totalBonus);
    }

    /**
     * Contains the total salary, total bonus and overall renumeration total for a contract.
     */
    public record YearContractTotalRemuneration(int totalSalary,
                                                int totalBonus) {
        public int overallTotal() {
            return totalSalary + totalBonus;
        }
    }
}
