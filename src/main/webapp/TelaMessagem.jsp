<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
-->
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS 
        <link rel="stylesheet" href="assets/css/materialize.min.css">-->
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
        
        <div class="row">
            <div class="col s6">
                <div class="row">
                    <form action="front" method="post" enctype="multipart/form-data">
                        <div class="input-field col s8">
                            <input id="search" type="search" required>
                            <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                            <i class="material-icons">close</i>
                        </div>
                        <div class="col s4" style="margin-top: 3%">
                            <button class="btn waves-effect waves-light light-green accent-4" type="submit" name="action">Procurar</button>
                        </div>
                        <input type="hidden" name="action" value="BuscarListUsuario"/>
                    </form>
                </div>
                <div class="row">
                    <div class="container" id="teste">
                        <ul class="collection">
                            <c:forEach  var="usuario" items="${Usuarios}">
                                <div class="row">
                                    <li class="collection-item avatar">
                                        <img src="${usuario.fotoPerfil}" alt="" class="circle">
                                        <span class="title">${carona.usuario}</span>
                                        <p>First Line
                                        </p>
                                        <form class="col s2 right" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="IrParaMensagem">
                                            <input type="hidden" name="id" value="${usuario.email}">
                                            <input class="button" type="submit" value="Ir">
                                        </form>
                                    </li>
                                </div>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col s6">
                <div class="row">
                    <div id="teste2" class="col s12 white" style="margin-top: 3%">
                        <c:forEach  var="mensagem" items="${Mensagem}">
                            <c:if test="${mensagem.tipo eq 'sent'}">
                                <div class="row">
                                    <p class="right text-black">${mensagem}</p>
                                </div>
                            </c:if>
                            <c:if test="${mensagem.tipo eq 'replies'}">
                                <div class="row">
                                    <p class="left text-black">${mensagem}</p>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <div class="row">
                    <form action="front" method="post" enctype="multipart/form-data">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">mode_edit</i>
                            <textarea id="textarea1" name="mensagem" class="materialize-textarea"></textarea>
                            <label for="textarea1">Digite aqui sua mensagem</label>
                        </div>
                        <input type="hidden" name="action" value="NovaMensagem"/>
                    </form>    
                </div>
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
        <!--<script type="text/javascript">
            $( document ).ready(function(){
                // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
                //$('.modal').modal();
            });
        </script>-->
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