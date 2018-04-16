<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="tagsUtil" uri="TagsUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <div class="card-content">
                                <div class="input-field">
                                    <input id="lugarSaida" name="lugarSaida" type="text" required>
                                    <label for="lugarSaida">Lugar de Saida</label>
                                </div>
                                <div class="input-field">
                                    <input id="lugarChegada" name="lugarChegada" type="text" required>
                                    <label for="lugarChegada">Lugar de Chegada</label>
                                </div>
                                <div class="input-field">
                                    <input id="QuantidadeVagas" name="QuantidadeVagas" type="number" min="0" max="1000" required>
                                    <label for="QuantidadeVagas">Quantidade de Vagas</label>
                                </div>
                                <div class="input-field">
                                    <input id="valor" name="valor" type="number" min="0" required>
                                    <label for="valor">Valor à ser Rachado</label>
                                </div>
                                <div class="input-field">
                                    <input id="data" name="data" type="text" class="datepicker">
                                    <label for="data">Data</label>
                                </div>
                                <div class="input-field">
                                    <input id="hora" name="hora" type="time">
                                    <label for="hora">Horario</label>
                                </div>
                                <div class="row">

                                    <tagsUtil:placasCarro />

                                    <div class="input-field col s12">
                                        <select id="carro" name="carro">
                                            <option value="" disabled selected>Selecione qual carro</option>

                                            <c:forEach var="placa" items="${placas}">
                                                <option value="${placa}">${placa}</option>
                                            </c:forEach>

                                        </select>
                                        <label>Carro</label>
                                      </div>

                                </div>
                                <div class="row">
                                    <p>Transporte de animais</p>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="transporteAnimal" type="radio" id="transporteAnimalSim" value="sim" />
                                        <label for="transporteAnimalSim">Sim</label>
                                    </div>
                                    <div class="col m1 l1 offset-m1 offset-l1">
                                        <input name="transporteAnimal" type="radio" id="transporteAnimalNao" value="não" />
                                        <label for="transporteAnimalNao">Não</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>Pode Fumar Dentro do Carro Durante a Viagem</p>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="podeFumar" type="radio" id="podeFumarSim" value="sim" />
                                        <label for="podeFumarSim">Sim</label>
                                    </div>
                                    <div class="col m1 l1 offset-m1 offset-l1">
                                        <input name="podeFumar" type="radio" id="podeFumarNao" value="não" />
                                        <label for="podeFumarNao">Não</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <p>Nivel de Conversa</p>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="nivelConversa" type="radio" id="nivel1" value="1" />
                                        <label for="nivel1">1</label>
                                    </div>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="nivelConversa" type="radio" id="nivel2" value="2" />
                                        <label for="nivel2">2</label>
                                    </div>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="nivelConversa" type="radio" id="nivel3" value="3" />
                                        <label for="nivel3">3</label>
                                    </div>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="nivelConversa" type="radio" id="nivel4" value="4" />
                                        <label for="nivel4">4</label>
                                    </div>
                                    <div class="col m3 l3 offset-m2 offset-l2">
                                        <input name="nivelConversa" type="radio" id="nivel5" value="5" />
                                        <label for="nivel5">5</label>
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
                        <input type="hidden" name="action" value="CadastraViagem"/>
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
        <script type="text/javascript">
            $( document ).ready(function() {
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
                document.addEventListener('keydown', function(e) {
                    e = e || window.event;
                    let code = e.which || e.keyCode;
                    if(code === 13){
                        vm.readLocal(searchBox.value);
                    }
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
                swal("Sucesso", "Viagem Cadastrada com Sucesso", "success");
            } else if(code == "2") {
                swal("Ops...", "Problema ao cadastrar sua Viagem, verifique os dados e tente novamente", "error");
            }
        </script>
    </body>
</html>