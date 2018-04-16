<%@ page pageEncoding="UTF-8" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tagsUtil" uri="TagsUtil" %>
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

<body>

<div class="container" style="margin-top: 3%">
    <div class="row">
        <div class="col m12 l12 s12">
            <div class="card">
                <div class="card-content">
                    <form action="front" method="post">
                        <input type="hidden" name="localSaida" id="localSaida">
                        <input type="hidden" name="localChegada" id="localChegada">
                        <div class="col right">
                            <button class="waves-effect waves-light btn light-green">
                                <i class="material-icons left">search</i>
                                Atualizar
                            </button>
                        </div>
                        <input type="hidden" name="action" value="CaronasOfertadas"/>
                    </form>

                    <br/>
                    <br/>

                    <div class="row">
                        <tagsUtil:listaViagens/>
                        <c:forEach var="viagem" items="${viagens}">
                            <tagsUtil:viagemDetail idLocalSaida="${viagem.idLocalSaida}" idLocalDestino="${viagem.idLocalDestino}"></tagsUtil:viagemDetail>
                            <div class="card">
                                <div class="card-content">
                                    <div class="row">
                                        <div class="col m6 l6 s12">
                                            <div class="input-field">
                                                <input type="text" class="valid" disabled contenteditable="false" value="${localSaida}">
                                            </div>
                                        </div>
                                        <div class="col m6 l6 s12">
                                            <div class="input-field">
                                                <input type="text" class="valid" disabled contenteditable="false" value="${localDestino}">
                                            </div>
                                        </div>
                                        <div class="col m6 l6 s12">
                                            <div class="input-field">
                                                <input type="text" class="valid" disabled contenteditable="false" value="${viagem.horario}">
                                            </div>
                                        </div>
                                        <div class="col m6 l6 s12">
                                            <div class="input-field">
                                                <input type="text" class="valid" disabled contenteditable="false" value="${viagem.data}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <tagsUtil:solicitacoesVagas idViagem="${viagem.id}" />
                                        <c:forEach var="solicitacao" items="${solicitacoes}">
                                            <form action="front" method="post">
                                                <div class="col m6 l6 s12">
                                                    <div class="input-field">
                                                        <input type="text" value="${solicitacao.emailPassageiro}" class="valid" disabled>
                                                        <input type="hidden" value="${solicitacao.emailPassageiro}" name="emailPassageiro">
                                                        <input type="hidden" name="idViagem" value="${viagem.id}">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <input type="hidden" name="action" id="action">
                                                    <button class="waves-effect waves-light btn light-blue" onclick="document.getElementById('action').value = 'AceitaSolicitacaoVaga'">
                                                        Aceitar
                                                    </button>
                                                    <button class="waves-effect waves-light btn red darken-2" onclick="document.getElementById('action').value = 'RejeitaSolicitacaoVaga'">
                                                        Remover
                                                    </button>
                                                </div>
                                            </form>

                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var code = "${param.code}";
    if(code == "1") {
        swal("Sucesso", "Salvo com Sucesso", "success");
    } else if(code == "2") {
        swal("Ops...", "Problema ao Realizar sua Requisição, tente novamente mais tarde.", "error");
    }
</script>
</html>