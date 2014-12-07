package com.ufrpe.integrais.negocio;

import java.util.LinkedList;

import com.ufrpe.integrais.dados.IRepositorioUsuarios;
import com.ufrpe.integrais.dados.RepositorioUsuarios;
import com.ufrpe.integrais.dados.entidades.Usuario;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.integrais.dados.entidades.excesoes.ObjetoNaoExistenteExcepition;
import com.ufrpe.integrais.util.Constantes;

public class CadastroUsuarios {

	private IRepositorioUsuarios repositosioUsuarios;
	private static final String NOME = "Usuario";

	public CadastroUsuarios() {
		repositosioUsuarios = RepositorioUsuarios.getInstance();
	}

	public LinkedList<Usuario> todosUsuarios() {
		return ((RepositorioUsuarios) repositosioUsuarios).getLista();
	}

	public void cadastrarUsuario(Usuario usuario) 
			throws ObjetoJaExistenteExcepitions {
		
		if (usuario == null) {
			throw new IllegalArgumentException(Constantes.PARAMETRO_INVALIDO);
		} else {
			Usuario retorno;

			retorno = this.repositosioUsuarios.procurar(usuario.getEmail(), usuario.getSenha());

			if (retorno == null) {
				((RepositorioUsuarios) repositosioUsuarios).cadastrar(usuario);
			} else {
				throw new ObjetoJaExistenteExcepitions(usuario);
			}
		}
	}

	public Usuario procurarUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}

		return retorno;
	}

	public void removerUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno != null) {
			((RepositorioUsuarios) repositosioUsuarios).remover(retorno);
		} else {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}
	}

	public Usuario loginUsuario(String email, String senha)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno == null) {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}

		return retorno;
	}

	public void atualizarCadastro(String email, String senha, Usuario novo)
			throws ObjetoNaoExistenteExcepition {

		Usuario retorno = repositosioUsuarios.procurar(email, senha);

		if (retorno != null) {
			//repositosioUsuarios.getLista().set(repositosioUsuarios.getLista().indexOf(retorno), novo);
		} else {
			throw new ObjetoNaoExistenteExcepition(NOME, email, senha);
		}
	}
}
