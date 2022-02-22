/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.entities.contract;


/**
 * Contains the contract calculation details for a single contract year.
 * <p>
 * A method is provided to return the total renumeration for the year.
 */
public record YearContractCalculation(int year,
                                      int salary,
                                      int bonus) {
    /**
     * Returns the renumeration for the yearly contract, calculated by adding the salary and bonus.
     *
     * @return the yearly renumeration total
     */
    public int yearlyRemuneration() {
        return salary + bonus;
    }
}
