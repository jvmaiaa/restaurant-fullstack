package com.restaurant.fullstack.domain.enums;

public enum CargoENUM {

    GERENTE("gerente"),
    ATENDENTE("atendente");

    private String cargo;

    CargoENUM(String cargo) {
        this.cargo = cargo;
    }
}