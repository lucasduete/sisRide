<%@ page pageEncoding="UTF-8" contentType="text/html" %>
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
                <div class="col m11 l11 s12 offset-m1 offset-l1">
                    <div class="card">
                        <div class="card-content">
                            <div class="row">
                                <form action="front" method="post">
                                    <div class="col m5 l5 s12">
                                        <div class="input-field">
                                            <input type="text" name="localSaida" id="localSaida">
                                            <label for="localSaida">Local de Saida</label>
                                        </div>
                                    </div>
                                    <div class="col m5 l5 s12">
                                        <div class="input-field">
                                            <input type="text" name="localChegada" id="localChegada">
                                            <label for="localChegada">Local de Chegada</label>
                                        </div>
                                    </div>
                                    <div class="col m2 l2">
                                        <button class="btn waves-effect waves-light btn light-green accent-4">
                                            <i class="material-icons left">search</i>
                                            Cadastrar
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
                                <tr>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                    <td>6</td>
                                    <td>7</td>
                                    <td>8</td>
                                    <td>9</td>
                                    <td>10</td>
                                    <td>11</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>