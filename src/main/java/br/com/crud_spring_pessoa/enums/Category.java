package br.com.crud_spring_pessoa.enums;

public enum Category {
    M("Masculino"), F("Feminino");

    private final String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }       
}
