package api.forumHub.domain.usuario;

public enum Perfil {

    ADMINISTRADOR("ROLE_ADMIN"),
    ESTUDANTE("ROLE_ESTUDANTE"),
    PROFESSOR("ROLE_PROFESSOR");

    private String authority;

    Perfil(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
