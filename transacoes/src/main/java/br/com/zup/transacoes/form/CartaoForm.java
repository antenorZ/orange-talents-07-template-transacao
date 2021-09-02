package br.com.zup.transacoes.form;

public class CartaoForm {
    private String id;

    private String email;

    public CartaoForm(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
