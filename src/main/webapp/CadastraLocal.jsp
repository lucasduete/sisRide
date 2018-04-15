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
        <link rel="stylesheet" href="assets/css/Teste.css">
        <link rel="stylesheet" href="assets/css/inputSearchBox.css">
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
                <div class="col s12 m6 l6">
                    <form class="login-form" action="front" method="post">
                        <div class="card">
                           <!-- <div class="card-image">
                               <img src="assets/img/cadastro.png">
                            </div>-->
                            <div class="card-content">
                                <div class="input-field">
                                    <input id="nome" name="nome" type="text" required>
                                    <label for="nome">Nome do Local</label>
                                </div>
                                <div class="input-field">
                                    <input id="descricao" name="descricao" type="text" required>
                                    <label for="descricao">Descrição</label>
                                </div>

                                <input id="lat" name="lat" type="text" hidden>
                                <input id="lng" name="lng" type="text" hidden>
                            </div>
                            <div class="card-action">
                                <div class="center-align">
                                    <!-- POR COR INDIGO? -->
                                    <button class="btn waves-effect waves-light btn light-green accent-4"><i class="material-icons left">vpn_key</i>Cadastrar</button>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="action" value="CadastraLocal"/>
                    </form>
                </div>
                <div class="col s12 m6 l6">
                    <div class="row" style="margin-top: 7%;">
                        <input id="searchBox" class="controls" type="text" placeholder="Digite para Encontrar">
                        <div id="map"></div>
                    </div>
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
                <li id="l"><a href="CadastraViagem.jsp"><span class="black-text name">Cadastra Carona</span></a></li>
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

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA26N7U2JuMCMfu1u4IJKGtSP7286dE45Q&libraries=places&callback=initMap" async defer></script>
        <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/setSearchBox.js"></script>
        <script src="assets/js/getLocationFromBrowser.js"></script>
        <script src="assets/js/createMarker.js"></script>
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
                $('select').material_select();
            })
        </script>
        <script>
            var map;
            var marker;

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

            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -6.887860, lng: -38.559366},
                    zoom: 16
                });
                getLocationFromBrowser(map);

                let searchBox = document.getElementById('searchBox');
                setSearchBox(searchBox, map);

                document.addEventListener('keydown', function (e) {
                    e = e || window.event;
                    let code = e.which || e.keyCode;
                    if (code === 13) {
                        vm.readLocal(searchBox.value);
                    }
                });

                map.addListener('click', function (e) {
                    createMarker(e.latLng, map);
                });
            };

            $(document).ready(function () {
                $('.modal-trigger').leanModal({
                    ready: function () {
                        var map = document.getElementById("map");
                        google.maps.event.trigger(map, 'resize');
                    }
                });
            });

            var code = "${param.code}";
            if(code == "1"){
                swal("Sucesso", "Local Cadastrado com Sucesso", "success");
            } else if(code == "2") {
                swal("Ops...", "Problema ao cadastrar Local, verifique os dados e tente novamente", "error");
            }
        </script>
    </body>
</html>