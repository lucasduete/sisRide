<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
		<!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        
        <script src="assets/js/sweetalert.min.js"></script>


		<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>
    </head>
    <body class="grey lighten-3">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper light-green accent-4">
                    <a class="brand-logo center">SisRide</a>
                </div>
            </nav>
        </div>
        <div class="container" style="margin-top: 3%">
            <div class="row">
                <div class="col s6 m6 l6 offset-m3 offset-l3">
                    <form class="login-form">
                        <div class="card">
                            <div class="card-content">
                                <span class="card-title">
	                                <h2 class="light-green-text center text-accent-4">Login</h2>
	                            </span>

                                <div class="input-field">
                                    <input class="validate" id="email" type="email" required>
                                    <label for="email">Email</label>
                                </div>

                                <div class="row">
                                    <div class="col s12 m12 l12">
                                        <div class="input-field">
                                            <input id="password" type="password" required>
                                            <label for="password">Senha</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-action">
                                <div class="center-align">
                                    <button class="btn waves-effect waves-light btn light-green accent-4"><i class="material-icons left">vpn_key</i>Login</button>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="row">
                        <div class="row center-align">
                            E novo?<a href="teladeCadastroUsuario.jsp"> Crie uma conta.</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="assets/js/materialize.min.js"></script>
        <script type="text/javascript">
            var erro = "${param.error}";
            if(erro == "1"){
                swal("Oops...", "Não foi possivel logar", "error");
            } 
        </script>
    </body>
</html>