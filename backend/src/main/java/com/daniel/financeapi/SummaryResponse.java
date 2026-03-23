package com.daniel.financeapi;

public class SummaryResponse {
    private double totalIncome;
    private double totalExpense;
    private double netBalance;
    public SummaryResponse(double totalIncome, double totalExpense, double netBalance){
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netBalance = netBalance;
    }
    public double getTotalIncome() {
        return totalIncome;
    }
    public double getTotalExpense(){
        return totalExpense;
    }
    public double getNetBalance(){
        return netBalance;
    }

}
