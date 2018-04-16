<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html>
    <head>
	<!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS 
        <link rel="stylesheet" href="assets/css/materialize.min.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="assets/js/sweetalert.min.js"></script>
        <!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/Teste.css">
    </head>
    <body class="grey lighten-3">
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper light-green accent-4">
                    <a href="TelaPrincipal.jsp" class="brand-logo">SisRide</a>
                    <ul class="right">
                        <li><a onclick='NovoA()'><i class="material-icons">group</i></a></li>
                        <!--<li><a onclick='NovoB()'><i class="material-icons">message</i></a></li>-->
                        <!--<li><a onclick='NovoC()'><i class="material-icons">notifications</i></a></li>-->
                        <li><a onclick='NovoD()'><i class="material-icons">account_circle</i></a></li>
                    </ul>
                </div>
            </nav>
        </div>
        
        <div class="col s12">
            <div class="row">
                <div class="col s6">
                    <div class="row">
                        <div class="col s12">
                            <div class="card blue-grey darken-1">
                                <div class="card-content white-text">
                                    <span class="card-title">${UsuarioP.nome}</span>
                                    <p>
                                        <img class="circle" src="data:image/jpg;base64,${UsuarioP.fotoPerfil}"><br>
                                        ${UsuarioP.sexo}<br>
                                        ${UsuarioP.dataNasc}<br>
                                        ${UsuarioP.profissao}<br>
                                        ${UsuarioP.cidade}<br>
                                        ${UsuarioP.nota}<br>
                                    </p>
                                </div>
                                <div class="card-action">
                                    <c:if test="${UsuarioP.email eq Usuario.email}">
                                        <form class="left" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="ExcluirConta">
                                            <input type="hidden" name="email" value="${UsuarioP.email}">
                                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit">Excluir Conta</button>
                                        </form>
                                        <form class="left" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="EditarConta">
                                            <input type="hidden" name="email" value="${UsuarioP.email}">
                                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit" >Editar Conta</button>
                                        </form>
                                    </c:if>
                                    <c:if test="${UsuarioP.email}">
                                        <form class="right" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="SolicitarSeguir">
                                            <input type="hidden" name="email" value="${UsuarioP.email}">
                                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit" >Solicitar Seguir</button>
                                        </form>
                                        <form class="right" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="SolicitarAmizadade">
                                            <input type="hidden" name="email" value="${UsuarioP.email}">
                                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit" >Solicitar Amizade</button>
                                        </form> 
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col s6">
                    <div class="container" id="teste">
                        <ul class="collection">
                            <c:forEach  var="carona" items="${Caronas}">
                                <div class="row">
                                    <li class="collection-item avatar">
                                        <img src="data:image/jpg;base64,${carona.fotoPerfil}" alt="" class="circle">
                                        <span class="title">${carona.nome}</span>
                                        <p>First Line
                                        </p>
                                        <form class="right" action="front" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="action" value="IrParaCarona">
                                            <input type="hidden" name="id" value="${carona.id}">
                                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit" >Ver Canrona</button>
                                        </form>
                                    </li>
                                </div>
                            </c:forEach>
                        </ul>
                    </div>
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
                        <img src="data:image/jpg;base64,${solicitacao.fotoPerfil}" alt="" class="circle">
                        <span class="title">${solicitacao.nome}</span>
                        <p>
                        <form action="front" method="post" enctype="multipart/form-data">
                            <button class="btn waves-effect waves-light btn-small green darken-2" type="submit">Confimar</button>
                            <input type="hidden" name="action" value="ConfimarAmizade">
                            <input type="hidden" name="emailU" value="${Usuario.email}">
                            <input type="hidden" name="emailS" value="${solicitacao.email}">
                        </form>
                        <form action="front" method="post" enctype="multipart/form-data">
                            <button class="btn waves-effect waves-light btn-small grey lighten-5 black-text" type="submit" >Excluir solicitacao</button>
                            <input type="hidden" name="action" value="NaoConfimarAmizade">
                            <input type="hidden" name="emailU" value="${Usuario.email}">
                            <input type="hidden" name="emailS" value="${solicitacao.email}">
                        </form>
                        </p>
                    </li>
                </c:forEach>
                <p>Solicitacoes de seguir
                    <a class="ad" href="BuscarUsuarios.jsp">Encontrar pessoas para seguir</a>
                    <a class="ad" href="TodasSolicitacoes.jsp">Ver tudo</a>
                </p>
                <c:forEach  var="solicitacao" items="${SolicitacaoS}">
                    <li class="collection-item avatar">
                        <img src="data:image/jpg;base64,${solicitacao.fotoPerfil}" alt="" class="circle">
                        <span class="title">${solicitacao.nome}</span>
                        <p>
                            <form action="front" method="post" enctype="multipart/form-data">
                                <button class="btn waves-effect waves-light btn-small green darken-2" type="submit" >Confimar</button>
                                <input type="hidden" name="action" value="ConfimarSeguir">
                                <input type="hidden" name="emailU" value="${Usuario.email}">
                                <input type="hidden" name="emailS" value="${solicitacao.email}">
                            </form>
                            <form action="front" method="post" enctype="multipart/form-data">
                                <button class="btn waves-effect waves-light btn-small grey lighten-5 black-text" type="submit" >Excluir solicitacao</button>
                                <input type="hidden" name="action" value="NaoConfimarSeguir">
                                <input type="hidden" name="emailU" value="${Usuario.email}">
                                <input type="hidden" name="emailS" value="${solicitacao.email}">
                            </form>
                        </p>
                    </li>
                </c:forEach>
            </ul>   
        <div>
        <!--<div id="novoB" class="novoB white">
            <ul class="collection">
                <p>Mensagem
                    <a class="ad" href="TelaMessagem.jsp">Ver tudo</a>
                </p>
                <c:forEach  var="mensagem" items="${Mensagem}">
                    <li class="collection-item avatar">
                        <img src="data:image/jpg;base64,${mensagem.fotoPerfil}" alt="" class="circle">
                        <span class="title">${mensagem.nome}</span>
                        <p>
                            <form action="front" method="post" enctype="multipart/form-data">
                                <button class="btn waves-effect waves-light btn-small grey lighten-5 black-text" type="submit" name="action"><i class="material-icons">arrow_forward</i></button>
                                <input type="hidden" name="action" value="IrParaMensagem">
                                <input type="hidden" name="emailU" value="${mensagem.email}">
                            </form>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        </div>-->
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
                    <a><img class="circle" src="data:image/jpg;base64,${Usuario.fotoPerfil}"></a>
                    <a id="l"><span class="black-text name">${Usuario.nome}</span></a>
                </li>
                <li><div class="divider"></div></li>
                <li id="l">
                    <form action="front" method="post" enctype="multipart/form-data">
                        <button class="btn waves-effect waves-light btn-small grey lighten-5 black-text" type="submit" >Ver perfil pessoal</button>
                        <input type="hidden" name="action" value="IrParaPerfil">
                        <input type="hidden" name="emailU" value="${Usuario.email}">
                    </form>
                </li>
                <li><div class="divider"></div></li>
                <li id="l">
                    <form action="front" method="post" enctype="multipart/form-data">
                        <button class="btn waves-effect waves-light btn-small grey lighten-5 black-text" type="submit" >Ver Mensagens</button>
                        <input type="hidden" name="action" value="IrParaMensagemtudo">
                        <input type="hidden" name="email" value="${Usuario.email}">
                    </form>
                </li>
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
                <c:if test="${Usuario.sexo eq 'feminino'}">
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