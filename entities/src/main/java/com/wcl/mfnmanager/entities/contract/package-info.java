/**
 * Contains entities pertaining to Player contracts.
 *
 * The top level entity is @see ContractCalculation which contains the results of a contract calculation along
 * with the salary and bonus values that are input to the process.
 *
 * @see ContractLengthSpecificCalculations are also held within @link ContractCalculation, representing the
 * calculation for a specific number of years, holding the number of years and a list of @see YearContractCalculation and
 * a helper method to calculate the total renumeration.
 *
 * @link YearContractCalculation contains the calculated salary and bonus for a stored year along with a method
 * to calculate the renumeration for the year.
 */
package com.wcl.mfnmanager.entities.contract;