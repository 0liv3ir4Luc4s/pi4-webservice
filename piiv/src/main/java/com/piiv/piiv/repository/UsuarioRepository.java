package com.piiv.piiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piiv.piiv.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
