package org.models;
import org.models.enums.Rol;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Rol rol;
    private boolean active = true;
}
