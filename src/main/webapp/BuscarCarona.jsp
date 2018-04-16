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
                            <div class="row">
                                <form action="front" method="post">
                                    <div class="col m4 l4 s12">
                                        <div class="input-field">
                                            <input type="text" name="localSaida" id="localSaida">
                                            <label for="localSaida">Local de Saida</label>
                                        </div>
                                    </div>
                                    <div class="col m4 l4 s12">
                                        <div class="input-field">
                                            <input type="text" name="localChegada" id="localChegada">
                                            <label for="localChegada">Local de Chegada</label>
                                        </div>
                                    </div>
                                    <div class="col right">
                                        <button class="waves-effect waves-light btn light-green">
                                            <i class="material-icons left">search</i>
                                            Buscar
                                        </button>
                                    </div>
                                    <input type="hidden" name="action" value="BuscarCarona"/>
                                </form>
                            </div>

                            <br/>

                            <table>
                                <thead>
                                <tr>
                                    <th>Local de Saída</th>
                                    <th>Local de Destino</th>
                                    <th>Data da Viagem</th>
                                    <th>Horario da Viagem</th>
                                    <th>Valor à ser Rachado</th>
                                    <th>Vagas Disponíveis</th>
                                    <th>Transporte de Animais</th>
                                    <th>Pode Fumar</th>
                                    <th>Nível de Conversa</th>
                                    <th>Email do Motorista</th>
                                    <th>Placa do Carro</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tagsUtil:listaViagens/>
                                    <c:forEach var="viagem" items="${viagens}">
                                        <tagsUtil:viagemDetail idLocalSaida="${viagem.idLocalSaida}" idLocalDestino="${viagem.idLocalDestino}"></tagsUtil:viagemDetail>
                                        <tr>
                                            <td>${localSaida}</td>
                                            <td>${localDestino}</td>
                                            <td>${viagem.data}</td>
                                            <td>${viagem.horario}</td>
                                            <td>${viagem.valor}</td>
                                            <td>
                                                <c:if test="${viagem.vagas ge 1}">
                                                    <form action="front" method="post">
                                                        <input type="hidden" name="viagem" value="${viagem.id}">
                                                        <input type="hidden" name="action" value="SolicitarVaga">
                                                        <button class="waves-effect waves-light btn green accent-2">
                                                            Solicitar Vaga
                                                        </button>
                                                    </form>
                                                </c:if>
                                                <c:if test="${viagem.vagas eq 0}">
                                                    <button class="waves-effect waves-light disabled btn">
                                                        Indiponível
                                                    </button>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${viagem.transporteAnimal eq true}">
                                                    Sim
                                                </c:if>
                                                <c:if test="${viagem.transporteAnimal eq false}">
                                                Não
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${viagem.podeFumar eq true}">
                                                    Sim
                                                </c:if>
                                                <c:if test="${viagem.podeFumar eq false}">
                                                    Não
                                                </c:if>
                                            </td>
                                            <td>${viagem.nivelConversa}</td>
                                            <td>${viagem.emailMotorista}</td>
                                            <td>${viagem.placaCarro}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        var code = "${param.code}";
        if(code == "1") {
            swal("Sucesso", "Vaga Solicitada com Sucesso", "success");
        } else if(code == "2") {
            swal("Ops...", "Problema ao Solicitar sua Vaga, tente novamente mais tarde.", "error");
        }
    </script>
</html>