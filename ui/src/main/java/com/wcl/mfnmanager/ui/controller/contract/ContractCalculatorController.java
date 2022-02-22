/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcl.mfnmanager.ui.controller.contract;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.wcl.mfnmanager.entities.contract.ContractCalculation;
import com.wcl.mfnmanager.ui.utils.AbstractSwitchableDisplayController;
import com.wcl.mfnmanager.services.ContractCalculatorService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * @author Martin Warnett, Marlyn Consulting Ltd
 */
public final class ContractCalculatorController extends AbstractSwitchableDisplayController {//implements Initializable {

    @FXML
    TextField minSalary;

    @FXML
    TextField requiredBonus;

    @FXML
    TableView<YearlySalary> oneYearDealSalaryTable;

    @FXML
    TableView<YearlySalary> twoYearDealSalaryTable;

    @FXML
    TableView<YearlySalary> threeYearDealSalaryTable;

    @FXML
    TableView<YearlySalary> fourYearDealSalaryTable;

    @FXML
    TableView<YearlySalary> fiveYearDealSalaryTable;

    @FXML
    TableView<YearlySalary> sixYearDealSalaryTable;

    @FXML
    TableView<TotalSalary> salaryTable;

    @FXML
    TableColumn<TotalSalary, Number> salaryYears;

    @FXML
    TableColumn<TotalSalary, Number> salaryTotalSalary;

    @FXML
    TableColumn<TotalSalary, Number> salaryBonusPerYear;

    @FXML
    TableColumn<TotalSalary, Number> salaryTotal;

    @FXML
    TableColumn<TotalSalary, Number> salaryTotalPerYear;

    @FXML
    TableColumn<YearlySalary, Number> oneYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> oneYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> oneYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> oneYearDealTotalColumn;

    @FXML
    TableColumn<YearlySalary, Number> twoYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> twoYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> twoYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> twoYearDealTotalColumn;

    @FXML
    TableColumn<YearlySalary, Number> threeYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> threeYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> threeYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> threeYearDealTotalColumn;

    @FXML
    TableColumn<YearlySalary, Number> fourYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> fourYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> fourYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> fourYearDealTotalColumn;

    @FXML
    TableColumn<YearlySalary, Number> fiveYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> fiveYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> fiveYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> fiveYearDealTotalColumn;

    @FXML
    TableColumn<YearlySalary, Number> sixYearDealYearColumn;

    @FXML
    TableColumn<YearlySalary, Number> sixYearDealSalaryColumn;

    @FXML
    TableColumn<YearlySalary, Number> sixYearDealBonusColumn;

    @FXML
    TableColumn<YearlySalary, Number> sixYearDealTotalColumn;

    @FXML
    Button calculateButton;

    private int minimumSalary;
    private int bonusRequired;

    private ObservableList<TotalSalary> salaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> oneYearDealSalaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> twoYearDealSalaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> threeYearDealSalaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> fourYearDealSalaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> fiveYearDealSalaries = FXCollections.observableArrayList();
    private ObservableList<YearlySalary> sixYearDealSalaries = FXCollections.observableArrayList();

    private ContractCalculatorService service;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new ContractCalculatorService();

        minSalary.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null
                    && !newValue.equals(Integer.toString(minimumSalary))) {
                minimumSalary = Integer.parseInt(newValue);
            }
        });

        requiredBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null
                    && !newValue.equals(Integer.toString(bonusRequired))) {
                bonusRequired = Integer.parseInt(newValue);

            }
        });

        oneYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        oneYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        oneYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        oneYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        oneYearDealSalaryTable.setPlaceholder(new Label(""));
        oneYearDealSalaryTable.setItems(oneYearDealSalaries);

        twoYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        twoYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        twoYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        twoYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        twoYearDealSalaryTable.setPlaceholder(new Label(""));
        twoYearDealSalaryTable.setItems(twoYearDealSalaries);

        threeYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        threeYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        threeYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        threeYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        threeYearDealSalaryTable.setPlaceholder(new Label(""));
        threeYearDealSalaryTable.setItems(threeYearDealSalaries);

        fourYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        fourYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        fourYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        fourYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        fourYearDealSalaryTable.setPlaceholder(new Label(""));
        fourYearDealSalaryTable.setItems(fourYearDealSalaries);

        fiveYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        fiveYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        fiveYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        fiveYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        fiveYearDealSalaryTable.setPlaceholder(new Label(""));
        fiveYearDealSalaryTable.setItems(fiveYearDealSalaries);

        sixYearDealYearColumn.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        sixYearDealSalaryColumn.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        sixYearDealBonusColumn.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        sixYearDealTotalColumn.setCellValueFactory(yearData -> yearData.getValue().totalProperty());

        sixYearDealSalaryTable.setPlaceholder(new Label(""));
        sixYearDealSalaryTable.setItems(sixYearDealSalaries);

        salaryYears.setCellValueFactory(yearData -> yearData.getValue().yearProperty());
        salaryTotalSalary.setCellValueFactory(yearData -> yearData.getValue().salaryProperty());
        salaryBonusPerYear.setCellValueFactory(yearData -> yearData.getValue().bonusProperty());
        salaryTotal.setCellValueFactory(yearData -> yearData.getValue().totalProperty());
        salaryTotalPerYear.setCellValueFactory(yearData -> yearData.getValue().totalPerYearProperty());

        salaryTable.setPlaceholder(new Label(""));
        salaryTable.setItems(salaries);
    }

    public void calculateContractOffer(final ActionEvent event) {
        convertContractInfo(service.calculateContract(minimumSalary, bonusRequired));
    }

    private void convertContractInfo(ContractCalculation contractCalculation) {
        final var values = contractCalculation.yearlyCalculations();

        oneYearDealSalaries.clear();
        oneYearDealSalaries.addAll(values.get(0).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        twoYearDealSalaries.clear();
        twoYearDealSalaries.addAll(values.get(1).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        threeYearDealSalaries.clear();
        threeYearDealSalaries.addAll(values.get(2).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        fourYearDealSalaries.clear();
        fourYearDealSalaries.addAll(values.get(3).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        fiveYearDealSalaries.clear();
        fiveYearDealSalaries.addAll(values.get(4).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        sixYearDealSalaries.clear();
        sixYearDealSalaries.addAll(values.get(5).yearContractCalculations().stream().map(a -> new YearlySalary(a.year(),
                a.salary(), a.bonus(), a.yearlyRemuneration()))
                .collect(Collectors.toList())
        );

        salaries.clear();
        salaries.addAll(values.stream().map(a -> new TotalSalary(a.years(),
                a.totalRemuneration().totalSalary(),
                a.totalRemuneration().totalBonus(),
                a.totalRemuneration().overallTotal()))
                .collect(Collectors.toList()));

    }
}

class YearlySalary {

    private final SimpleIntegerProperty year;
    private final SimpleIntegerProperty salary;
    private final SimpleIntegerProperty bonus;
    private final SimpleIntegerProperty total;

    YearlySalary(final int year, final int salary, final int bonus, final int total) {
        this.year = new SimpleIntegerProperty(year);
        this.salary = new SimpleIntegerProperty(salary);
        this.bonus = new SimpleIntegerProperty(bonus);
        this.total = new SimpleIntegerProperty(total);
    }

    int getYear() {
        return year.get();
    }

    SimpleIntegerProperty yearProperty() {
        return year;
    }

    int getSalary() {
        return salary.get();
    }

    SimpleIntegerProperty salaryProperty() {
        return salary;
    }

    int getBonus() {
        return bonus.get();
    }

    SimpleIntegerProperty bonusProperty() {
        return bonus;
    }

    int getTotal() {
        return total.get();
    }

    SimpleIntegerProperty totalProperty() {
        return total;
    }

}

class TotalSalary extends YearlySalary {
    private SimpleIntegerProperty totalPerYear;

    public TotalSalary(final int year, final int salary, final int bonus, final int total) {
        super(year, salary, bonus, total);
        this.totalPerYear = new SimpleIntegerProperty(total / year);
    }


    /**
     * @return the salaryPerYear
     */
    public int getTotalPerYear() {
        return totalPerYear.get();
    }

    public SimpleIntegerProperty totalPerYearProperty() {
        return totalPerYear;
    }

}

