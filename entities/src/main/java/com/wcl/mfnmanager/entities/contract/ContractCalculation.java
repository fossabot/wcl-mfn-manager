/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.entities.contract;

import java.util.List;

/**
 * Represents the base values for a contract calculation, namely the minimal salary allowed and the bonus required
 * along with the resulting calculations made.
 *
 * The minimal salary allowed is on a per-season basis; the bonus required would be on a per-player basis.
 *
 * @param minimumSalary - the minimum salary required.
 * @param bonusRequired - the bonus required.
 * @param yearlyCalculations - the calculations generated on a yearly basis.
 */
public record ContractCalculation(int minimumSalary,
                                  int bonusRequired,
                                  List<ContractLengthSpecificCalculations> yearlyCalculations) {}
