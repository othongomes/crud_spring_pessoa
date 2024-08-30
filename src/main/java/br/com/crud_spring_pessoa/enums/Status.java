package br.com.crud_spring_pessoa.enums;

public enum Status {
    ATIVO("Ativo"), INATIVO("Inativo");

    private final String value;

    private Status(String value) {
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
