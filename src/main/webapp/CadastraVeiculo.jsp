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
        <link rel="stylesheet" href="assets/css/Teste.css">
    </head>
    <body class="grey lighten-3">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper light-green accent-4">
                    <!--<a href="TelaPrincipal.jsp"><i class="material-icons black">reply</i></a>
                    <a href="TelaPrincipal.jsp" class="brand-logo center">SisRide</a>-->
                    <a href="TelaPrincipal.jsp" class="brand-logo"><i class="material-icons">reply</i>SisRide</a>
                    <ul class="right">
                        <li><a onclick='NovoA()'><i class="material-icons">group</i></a></li>
                        <li><a onclick='NovoB()'><i class="material-icons">message</i></a></li>
                        <li><a onclick='NovoC()'><i class="material-icons">notifications</i></a></li>
                        <li><a onclick='NovoD()'><i class="material-icons">account_circle</i></a></li>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="container" style="margin-top: 3%">
                <div class="row">
                    <div class="col s12 m6 l6 offset-m3 offset-l3">
                        <form class="login-form" action="front" method="post" enctype="multipart/form-data">
                            <div class="card">
                                <div class="card-content">
                                    <div class="input-field">
                                        <input id="placa" name="placa" type="text" required>
                                        <label for="placa">Placa</label>
                                    </div>
                                    <div class="input-field">
                                        <input id="modelo" name="modelo" type="text" required>
                                        <label for="modelo">Modelo</label>
                                    </div>
                                    <div class="row">
                                        <p>Tem ArCondicionado?</p>
                                        <div class="col m3 l3 offset-m2 offset-l2">
                                            <input name="tipo" type="radio" id="sim" value="sim" />
                                            <label for="sim">Sim</label>
                                        </div>
                                        <div class="col m1 l1 offset-m1 offset-l1">
                                            <input name="tipo" type="radio" id="nao" value="nao" />
                                            <label for="nao">Não</label>
                                        </div>
                                    </div>
                                    <div id="ui" class="input-field">
                                        <input id="dataNasc" name="dataNasc" type="text" class="datepicker">
                                        <label for="dataNasc">Ano</label>
                                    </div>
                                </div>
                                <div class="card-action">
                                    <div class="center-align">
                                        <!-- POR COR INDIGO? -->
                                        <button class="btn waves-effect waves-light btn light-green accent-4"><i class="material-icons left">vpn_key</i>Cadastrar</button>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="action" value="CadastraVeiculo"/>
                        </form>
                    </div>
                </div>
            </div>

        <div id="novoA" class="novoA white">
            
        <div>

        <div id="novoB" class="novoB white">
                
        </div>

        <div id="novoC" class="novoC white">
                
        <div>

        <div id="novoD" class="novoD white">
            <ul>
                <li>
                    <a><img class="circle" src="assets/img/iconPadrao.jpg"></a>
                    <a id="l"><span class="black-text name">Caio Guilherme</span></a>
                </li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="Perfil.jsp"><span class="black-text name">Ver perfil pessoal</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="CadastraCarona.jsp"><span class="black-text name">Cadastra Carona</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="CadastraVeiculo.jsp"><span class="black-text name">Cadastra Veiculo</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="BuscarCarona.jsp"><span class="black-text name">Buscar Carona</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="SoElas.jsp"><span class="black-text name">So Elas</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="CaronasOfertadas.jsp"><span class="black-text name">Caronas ofertadas</span></a></li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="front?action=Sair"><span class="black-text name">Sair</span></a></li>
            </ul>
        <div>
                
        <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script type="text/javascript">
            $( document ).ready(function(){
                $('.datepicker').pickadate({
                    selectMonths: false, // Creates a dropdown to control month
                    selectYears: 160, // Creates a dropdown of 15 years to control year,
                    format: 'yyyy',
                    today: 'Hoje',
                    clear: 'Limpar',
                    close: 'Ok',
                    disableWeekends: false,
                    monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
                    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
                    closeOnSelect: false // Close upon selecting a date,
                });
            })
        </script>
        <script>
            function NovoA() {
                let novo = document.getElementById("novoA").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoA").style.visibility = "visible";
                }else{
                    document.getElementById("novoA").style.visibility = "hidden";
                }
            }
            function NovoB() {
                let novo = document.getElementById("novoB").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoB").style.visibility = "visible";
                }else{
                    document.getElementById("novoB").style.visibility = "hidden";
                }
            }
            function NovoC() {
                let novo = document.getElementById("novoC").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoC").style.visibility = "visible";
                }else{
                    document.getElementById("novoC").style.visibility = "hidden";
                }
            }
            function NovoD() {
                let novo = document.getElementById("novoD").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoD").style.visibility = "visible";
                }else{
                    document.getElementById("novoD").style.visibility = "hidden";
                }
            }
        </script>
    </body>
</html>