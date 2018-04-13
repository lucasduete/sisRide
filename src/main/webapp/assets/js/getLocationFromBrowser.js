function getLocationFromBrowser(map) {
    let infoWindow = new google.maps.InfoWindow({map: map});

    // Tenta Utilizar o Serviço do HTML5 de Geolocalização
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            let coordenadas = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(coordenadas);
            infoWindow.setContent('Você Está Aqui! xD');
            map.setCenter(coordenadas);
        }, function() {
            getLocarionErro(true, infoWindow, map.getCenter());
        });
    } else {
        // Navegador Não Suporta Serviço de Geolocalização
        getLocarionErro(false, infoWindow, map.getCenter());
    }

};

function getLocarionErro(browserTemGPS, infoWindow, coordenadas) {
    infoWindow.setPosition(coordenadas);
    infoWindow.setContent(browserTemGPS ?
        'Não Foi Possivel Determinar Sua Localização :(' :
        'Seu Navegador Não Suporta o Serviço de Localização ;(');
};