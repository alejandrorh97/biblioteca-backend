package com.ues.bibliotecabackend.Rol;

public enum RolEnum {
  ADMINISTRADOR("ADMINISTRADOR"),
  BIBLIOTECARIO("BIBLIOTECARIO"),
  ESTUDIANTE("ESTUDIANTE"),
  DOCENTE("DOCENTE");

  private final String value;

  RolEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
