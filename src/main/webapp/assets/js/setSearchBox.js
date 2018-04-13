
function setSearchBox(input, map) {

    // Cria uma Caixa de Busca e Setta ela no DOM
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    // Setta os resultados do SearchBox para a viewport do mapa atual.
    map.addListener('bounds_changed', function() {
        searchBox.setBounds(map.getBounds());
    });

    // Escuta o Event disparado quando o usuário seleciona uma resultado
    // e recupera mais detalhes para esse local.
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }

        // Para cada lugar e a localização.
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            if (!place.geometry) {
                console.log("Returned place contains no geometry");
                return;
            }

            if (place.geometry.viewport) {
                // Somente Geocode (geometria) tem viewport
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });


};