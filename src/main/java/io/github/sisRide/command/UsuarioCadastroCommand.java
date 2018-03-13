package io.github.sisRide.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioCadastroCommand implements Command {

    private GerenciadorUsuario gerusu;
    
    public UsuarioCadastroCommand(){
        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Usuario usuario = new Usuario();

        String email = request.getParameter("email");

        if(gerusu.getUsuarioByEmail(email) == null) {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("password");
            String sexo = request.getParameter("group1");
            String tipo = request.getParameter("group2");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(
                    request.getParameter("dataNasc"), formatter
            );
            String fotoPerfil = request.getParameter("foto");
            
            File file = new File(fotoPerfil);
            byte[] readAllBytes = Files.readAllBytes(file.toPath());
            usuario.setFotoPerfil(Base64.getEncoder().encodeToString(readAllBytes));
            
            usuario.setEmail(email);
            usuario.setDataNasc(dataNasc);
            usuario.setNome(nome);
            usuario.setTipo(tipo);
            usuario.setSexo(sexo);
            usuario.setSenha(senha);

            if(gerusu.salvar(usuario)){
                response.sendRedirect("TeladeLogin.jsp");
            }else{
                response.sendRedirect("TeladeCadastroUsuario.jsp?error=1");
            }

        }else{
            response.sendRedirect("TeladeCadastroUsuario.jsp?error=2");
        }
    }

}