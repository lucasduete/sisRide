<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
		<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
		<!-- Compiled and minified CSS-->
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="assets/js/sweetalert.min.js"></script>
        <!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="assets/css/Teste.css">
    </head>
    <body class="grey lighten-3">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper light-green accent-4">
                    <a href="TelaPrincipal.jsp" class="brand-logo">SisRide</a>
                    <ul class="right">
                        <li><a onclick='NovoA()'><i class="material-icons">group</i></a></li>
                        <li><a onclick='NovoB()'><i class="material-icons">message</i></a></li>
                        <!--<li><a onclick='NovoC()'><i class="material-icons">notifications</i></a></li>-->
                        <li><a onclick='NovoD()'><i class="material-icons">account_circle</i></a></li>
                    </ul>
                </div>
            </nav>
        </div>
        
        <div class="container" style="margin-top: 3%">
            <div class="row">
                <form class="login-form" action="front" method="post" enctype="multipart/form-data">
                    <div class="card">
                        <div class="card-content">
                            <span class="card-title">Configurar os dados</span>
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
                                <input id="profissao" name="profissao" type="text" required>
                                <label for="profissao">Profissão</label>
                            </div>
                            <div class="input-field">
                                <input id="cidade" name="cidade" type="text" required>
                                <label for="cidade">Cidade</label>
                            </div>
                            <div class="input-field">
                                <input id="dataNasc" name="dataNasc" type="text" class="datepicker">
                                <label for="dataNasc">Data de Nascimento</label>
                            </div>
                            <div class="row">
                                <div class="col m3 l3 offset-m2 offset-l2">
                                    <label>
                                        <input name="sexo" type="radio" value="masculino" />
                                        <span>Masculino</span>
                                    </label>
                                </div>
                                <div class="col m1 l1 offset-m1 offset-l1">
                                    <label>
                                        <input name="sexo" type="radio" value="feminino" />
                                        <span>Feminino</span>
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col m3 l3 offset-m2 offset-l2">
                                    <label>
                                        <input name="tipo" type="radio" value="motorista" />
                                        <span>Motorista</span>
                                    </label>
                                </div>
                                <div class="col m1 l1 offset-m1 offset-l1">
                                    <label>
                                        <input name="tipo" type="radio" value="passageiro" />
                                        <span>Passageiro</span>
                                    </label>
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
                                <button class="btn waves-effect waves-light btn light-green accent-4">Salvar</button>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="action" value="UsuarioCadastro"/>
                </form>
            </div>
        </div>
        
        <div id="novoA" class="novoA white">
            <ul class="collection">
                <p>Solicitacoes de amizade 
                    <a class="ad" href="BuscarUsuarios.jsp">Encontrar amigos</a>
                    <a class="ad" href="TodasSolicitacoes.jsp">Ver tudo</a>
                </p>
                <c:forEach  var="solicitacao" items="${SolicitacaoA}">
                    <li class="collection-item avatar">
                        <img src="${solicitacao.fotoPerfil}" alt="" class="circle">
                        <span class="title">${solicitacao.nome}</span>
                        <p>
                            <a href="front?action=ConfimarAmizadade" class="waves-effect waves-light btn-small green darken-2">Confimar</a>
                            <a href="front?action=NaoConfimarAmizada" class="waves-effect waves-light btn-small grey lighten-5 black-text">Excluir solicitacao</a>
                        </p>
                    </li>
                </c:forEach>
                <p>Solicitacoes de seguir
                    <a class="ad" href="BuscarUsuarios.jsp">Encontrar pessoas para seguir</a>
                    <a class="ad" href="TodasSolicitacoes.jsp">Ver tudo</a>
                </p>
                <c:forEach  var="solicitacao" items="${SolicitacaoS}">
                    <li class="collection-item avatar">
                        <img src="${solicitacao.fotoPerfil}" alt="" class="circle">
                        <span class="title">${solicitacao.nome}</span>
                        <p>
                            <a href="front?action=ConfimarSeguir" class="waves-effect waves-light btn-small green darken-2">Confimar</a>
                            <a href="front?action=NaoConfimarSeguir" class="waves-effect waves-light btn-small grey lighten-5 black-text">Excluir solicitacao</a>
                        </p>
                    </li>
                </c:forEach>
            </ul>   
        <div>
        <div id="novoB" class="novoB white">
            <ul class="collection">
                <p>Mensagem
                    <a class="ad" href="TelaMessagem.jsp">Ver tudo</a>
                </p>
                <c:forEach  var="mensagem" items="${Mensagem}">
                    <li class="collection-item avatar">
                        <img src="${mensagem.fotoPerfil}" alt="" class="circle">
                        <span class="title">${mensagem.nome}</span>
                        <p>
                            <a href="front?action=IrParaMensagem" class="secondary-content"><i class="material-icons">arrow_forward</i></a>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!--<div id="novoC" class="novoC white">
            <ul class="collection">
                <p>Notificacoes
                    <a class="ad" href="">Ver tudo</a>
                </p>
                <c:forEach  var="notificacao" items="${Notificacao}">
                    <li class="collection-item avatar">
                        <img src="${notificacao.fotoPerfil}" alt="" class="circle">
                        <span class="title">${notificacao.nome}</span>
                        <p>
                            <a href="front?action=IrParaNotificacao" class="secondary-content"><i class="material-icons">arrow_forward</i></a>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        <div>-->
        <div id="novoD" class="novoD white">
            <ul>
                <li>
                    <a><img class="circle" src="${Usuario.fotoPerfil}"></a>
                    <a id="l"><span class="black-text name">${Usuario.nome}</span></a>
                </li>
                <li><div class="divider"></div></li>
                <li id="l"><a href="Perfil.jsp"><span class="black-text name">Ver perfil pessoal</span></a></li>
                <li><div class="divider"></div></li>
                <c:if test="${Usuario.tipo eq 'motorista'}">
                    <li id="l"><a href="CadastraViagem.jsp"><span class="black-text name">Cadastra Carona</span></a></li>
                    <li><div class="divider"></div></li>
                    <li id="l"><a href="CadastraVeiculo.jsp"><span class="black-text name">Cadastra Veiculo</span></a></li>
                    <li><div class="divider"></div></li>
                    <li id="l"><a href="CaronasOfertadas.jsp"><span class="black-text name">Caronas ofertadas</span></a></li>
                    <li><div class="divider"></div></li>
                </c:if>
                <li id="l"><a href="BuscarCarona.jsp"><span class="black-text name">Buscar Carona</span></a></li>
                <li><div class="divider"></div></li>
                <c:if test="${Usuario.tipo eq 'feminino'}">
                    <li id="l"><a href="SoElas.jsp"><span class="black-text name">So Elas</span></a></li>
                    <li><div class="divider"></div></li>
                </c:if>
                <li id="l"><a href="front?action=Sair"><span class="black-text name">Sair</span></a></li>
            </ul>
        <div>
            
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
        <script>
            function NovoA() {
                let novo = document.getElementById("novoA").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoA").style.visibility = "visible";
                    document.getElementById("novoB").style.visibility = "hidden";
                    document.getElementById("novoC").style.visibility = "hidden";
                    document.getElementById("novoD").style.visibility = "hidden";
                }else{
                    document.getElementById("novoA").style.visibility = "hidden";
                }
            }
            function NovoB() {
                let novo = document.getElementById("novoB").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoB").style.visibility = "visible";
                    document.getElementById("novoA").style.visibility = "hidden";
                    document.getElementById("novoC").style.visibility = "hidden";
                    document.getElementById("novoD").style.visibility = "hidden";
                }else{
                    document.getElementById("novoB").style.visibility = "hidden";
                }
            }
            function NovoC() {
                let novo = document.getElementById("novoC").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoC").style.visibility = "visible";
                    document.getElementById("novoA").style.visibility = "hidden";
                    document.getElementById("novoB").style.visibility = "hidden";
                    document.getElementById("novoD").style.visibility = "hidden";            
                }else{
                    document.getElementById("novoC").style.visibility = "hidden";
                }
            }
            function NovoD() {
                let novo = document.getElementById("novoD").style.visibility;
                if((novo == "") || (novo == "hidden")){
                    document.getElementById("novoD").style.visibility = "visible";
                    document.getElementById("novoA").style.visibility = "hidden";
                    document.getElementById("novoB").style.visibility = "hidden";
                    document.getElementById("novoC").style.visibility = "hidden";
                }else{
                    document.getElementById("novoD").style.visibility = "hidden";
                }
            }
        </script>
    </body>
</html>