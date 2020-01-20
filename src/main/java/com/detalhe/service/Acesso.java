package com.detalhe.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.detalhe.model.Usuario;
import com.detalhe.repository.UsuarioRepository;

public class Acesso {

	public static Usuario getUsuario(UsuarioRepository usuarioRepository) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioRepository.findByEmail(auth.getName()).get();
		return usuario;
	}

}
