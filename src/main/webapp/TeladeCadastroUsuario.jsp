<!DOCTYPE html>
<html lang="pt-br">
	<head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
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
                <div class="col s12 m6 l6 offset-m3 offset-l3">
                    <form class="login-form" action="front" method="post" enctype="multipart/form-data">
                        <div class="card">
                            <div class="card-image">
                               <img src="assets/img/cadastro.png">    
                            </div>
                            <div class="card-content">
                                <div class="input-field">
                                    <input class="validate" id="email" name="email" type="email" required>
                                    <label for="email">Email</label>
                                </div>
                                <div class="input-field">
                                    <input id="password" name="password" type="password" required>
                                    <label for="password">Senha</label>
                                </div>
                                <div class="input-field">
                                    <input id="nome" name="nome" type="text" required>
                                    <label for="nome">Nome</label>
                                </div>
                                <div class="input-field">
                                    <input id="dataNasc" name="dataNasc" type="text" class="datepicker">
                                    <label for="dataNasc">Data de Nascimento</label>
                                </div>
                                <div class="row">
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="sexo" type="radio" id="masculino" />
                                        <label for="masculino">Masculino</label>
                                    </div>
                                    <div class="col m1 l1 offset-m1 offset-l1">
                                        <input name="sexo" type="radio" id="feminino" />
                                        <label for="feminino">Feminino</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="tipo" type="radio" id="motorista" />
                                        <label for="motorista">Motorista</label>
                                    </div>
                                    <div class="col m1 l1 offset-m1 offset-l1">
                                        <input name="tipo" type="radio" id="passageiro" />
                                        <label for="passageiro">Passageiro</label>
                                    </div>
                                </div>
                                <div class="file-field input-field">
                                    <div class="btn">
                                        <span>Foto</span>
                                        <input id="foto" name="foto" type="file">
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="card-action">
                                <div class="center-align">
                                    <!-- POR COR INDIGO? -->
                                    <button class="btn waves-effect waves-light btn light-green accent-4"><i class="material-icons left">vpn_key</i>Cadastrar</button>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="action" value="UsuarioCadastro"/>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="assets/js/materialize.min.js"></script>
        <script type="text/javascript">
            $( document ).ready(function(){
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 160, // Creates a dropdown of 15 years to control year,
                    format: 'dd/mm/yyyy',
                    today: 'Hoje',
                    clear: 'Limpar',
                    close: 'Ok',
                    monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
                    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
                    closeOnSelect: false // Close upon selecting a date,
                });
            })
        </script>
        <script type="text/javascript">
            var erro = "${param.error}";
            if(erro == "1"){
                swal("Oops...", "Não foi possivel cadastra", "error");
            }
            if(erro == "2"){
                swal("Oops...", "Não foi possivel cadastra, Já existe um usuario com esse email", "error");
            }
        </script>
    </body>
</html>