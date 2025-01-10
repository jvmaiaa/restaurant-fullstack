package com.restaurant.fullstack.domain.enums;

public enum FormaDePagamentoENUM {

    DINHEIRO("dinheiro"),
    PIX("pix"),
    CARTAO("cartao");

    private String formaPagamento;

    FormaDePagamentoENUM(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
