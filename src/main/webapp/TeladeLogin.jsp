<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!DOCTYPE html>
<html>
	<head>
		<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
		<!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">   
        
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


		<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>
    </head>
    <body class="grey lighten-3">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper light-green accent-4">
                    <a class="brand-logo center">Bem-vindo ao SisRide</a>
                </div>
            </nav>
        </div>
        <div class="container">
            <div class="row center-align">
                <h2 class="light-green-text text-accent-4">Login</h2>
            </div>
            <form class="col s12 l4" method="post" action="front">
                <div class="row">
                    <div class="input-field col s12 l4">
                        <input id="email" name="email" type="email" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12 l4">
                        <input id="password" name="senha" type="password" class="validate">
                        <label for="password">Senha</label>
                    </div>
                </div>
                <div class="row center-align">
                    <input class="waves-effect waves-light btn light-green accent-4" type="submit" value="Entrar">
                </div>
                <input type="hidden" name="action" value="Login"/>
            </form>
            <div class="row center-align">
                E novo?<a href="teladeCadastroUsuario.jsp"> Crie uma conta.</a>
            </div>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script type="text/javascript">
            var erro = "${param.error}";
            if(erro == "1"){
                swal("Oops...", "Não foi possivel logar", "error");
            } 
        </script>
    </body>
</html>