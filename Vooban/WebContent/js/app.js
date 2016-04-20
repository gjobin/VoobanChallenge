/**
 * Module principal de l'application Vooban.
 */
(function() {
    var app = angular.module('vooban', ['uiGmapgoogle-maps']);

    /*
     * Controlleur de l'affichage des suggestions de villes.
     */
    app
        .controller(
            'CitiesCtrl', [
                '$scope',
                '$http',
                function($scope, $http) {
                    
                	/**
                     * Contenu du formulaire
                     */
                	this.searchForm = {
                        "q": ""
                    };

                	/**
                	 * Liste des suggestions
                	 */
                    this.suggestions = [];
                    
                    /**
                     * Vide la liste des suggestions.
                     */
                    $scope.empty = function (){
                    	$scope.cities.suggestions = [];
                    }

                    /**
                     * Effectue la recherche basée sur le formulaire et alimente la liste des suggestions. 
                     */
                    $scope.query = function() {

                        var q = $scope.cities.searchForm.q;

                        if (q.length >= 3) {
                            // Get
                            $http
                                .get(
                                    '/Vooban/rest/cities/suggestions?q=' +
                                    q)
                                .then(
                                    function(response) {
                                    	// Success
                                        $scope.cities.suggestions = response.data.suggestions;
                                    },
                                    function(response) {
                                    	// Error
                                        $scope.empty();
                                    });
                        } else {
                            // Reset
                            $scope.empty();
                        }
                    };
                    
                    $scope.map = { center: { latitude: 45, longitude: -73 }, zoom: 8 };
                }
            ]);
})();