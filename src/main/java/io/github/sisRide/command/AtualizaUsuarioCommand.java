package io.github.sisRide.command;

import io.github.sisRide.gerenciadores.GerenciadorUsuario;
import io.github.sisRide.infraSecurity.FileManagement;
import io.github.sisRide.interfaces.Command;
import io.github.sisRide.model.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class AtualizaUsuarioCommand implements Command{
    
    private GerenciadorUsuario gerenciadorUsuario;
    
    public AtualizaUsuarioCommand() {

        this.gerenciadorUsuario = new GerenciadorUsuario();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        Usuario usuario = new Usuario();
        String email = req.getParameter("email");
        String cidade = req.getParameter("cidade");
        String profissao = req.getParameter("profissao");
        
        String nome = req.getParameter("nome");
        String senha = req.getParameter("password");
        String sexo = req.getParameter("sexo");
        String tipo = req.getParameter("tipo");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(
            req.getParameter("dataNasc"), formatter
        );

        final Part fotoPerfil = req.getPart("foto");

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
        usuario.setCidade(cidade);
        usuario.setProfissao(profissao);
        usuario.setNome(nome);
        usuario.setTipo(tipo);
        usuario.setSexo(sexo);
        usuario.setSenha(senha);

        usuario.setFotoPerfil(null);
        System.out.println(usuario);

        //gerenciadorUsuario.atualizar(usuario);
        
    }
    
}
