package br.com.fiap.fintech.model;

import br.com.fiap.fintech.util.Criptografia;

public class Usuario {
    private String email;
    private String senha;

    public Usuario (String email, String senha) {
        this.email = email;
        setSenha(senha);
    }

    public Usuario() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = Criptografia.criptografar(senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
