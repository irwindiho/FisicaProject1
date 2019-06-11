package com.apps.irdhilmc.fisicaproyect.entiites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irvinmarin on 10/06/2019.
 */

public class Formula {


    private int positionFormula;
    private int codigoFormula;
    private String nombreFormula;


    public Formula(int positionFormula, int codigoFormula, String nombreFormula) {
        this.positionFormula = positionFormula;
        this.codigoFormula = codigoFormula;
        this.nombreFormula = nombreFormula;
    }


    public int getPositionFormula() {
        return positionFormula;
    }

    public void setPositionFormula(int positionFormula) {
        this.positionFormula = positionFormula;
    }

    public int getCodigoFormula() {
        return codigoFormula;
    }

    public void setCodigoFormula(int codigoFormula) {
        this.codigoFormula = codigoFormula;
    }

    public String getNombreFormula() {
        return nombreFormula;
    }

    public void setNombreFormula(String nombreFormula) {
        this.nombreFormula = nombreFormula;
    }

    public static List<Formula> LlenarListaMRUFormulas() {

        List<Formula> formulaList = new ArrayList<>();

        formulaList.add(new Formula(1, 1, "D = V * T"));
        formulaList.add(new Formula(1, 2, "T = D / V"));
        formulaList.add(new Formula(1, 3, "V = D / T"));


        return formulaList;

    }

    public static List<Formula> LlenarListaMRUVFormulas() {
        return null;
    }
}
