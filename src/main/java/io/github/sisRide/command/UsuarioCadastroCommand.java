package io.github.sisRide.command;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.infraSecurity.FileManagement;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UsuarioCadastroCommand implements Command {

    private GerenciadorUsuario gerusu;
    
    public UsuarioCadastroCommand() {

        this.gerusu = new GerenciadorUsuario();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Usuario usuario = new Usuario();
        String email = request.getParameter("email");

        if(gerusu.getUsuarioByEmail(email) == null) {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("password");
            String sexo = request.getParameter("sexo");
            String tipo = request.getParameter("tipo");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(
                    request.getParameter("dataNasc"), formatter
            );

            final Part fotoPerfil = request.getPart("foto");

            OutputStream out = null;
            InputStream filecontent = null;

            try {
                out = new FileOutputStream(new File("./" + File.separator
                        + fotoPerfil.hashCode()));
                filecontent = fotoPerfil.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }

            File foto = new File("./" + File.separator
                    + fotoPerfil.hashCode());

            String fotoBase64 = FileManagement.encodeFile(foto);
            usuario.setFotoPerfil(fotoBase64);

            usuario.setEmail(email);
            usuario.setDataNasc(dataNasc);
            usuario.setNome(nome);
            usuario.setTipo(tipo);
            usuario.setSexo(sexo);
            usuario.setSenha(senha);

            if(gerusu.salvar(usuario)) {
                response.sendRedirect("TeladeLogin.jsp");
            } else {
                response.sendRedirect("TeladeCadastroUsuario.jsp?error=1");
            }

        } else {
            response.sendRedirect("TeladeCadastroUsuario.jsp?error=2");
        }
    }

}