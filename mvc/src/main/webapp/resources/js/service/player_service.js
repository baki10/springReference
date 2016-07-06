'use strict';

App.factory('PlayerService', ['$http', '$q', function($http, $q){

    return {

        fetchAllPlayers: function() {
            return $http.get('http://localhost:8080/mvc/rest/players/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching players');
                        return $q.reject(errResponse);
                    }
                );
        },

        createPlayer: function(player){
            return $http.post('http://localhost:8080/mvc/rest/players/', player)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating player');
                        return $q.reject(errResponse);
                    }
                );
        },

        updatePlayer: function(player, id){
            return $http.put('http://localhost:8080/mvc/rest/players/'+id, player)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating player');
                        return $q.reject(errResponse);
                    }
                );
        },

        deletePlayer: function(id){
            return $http.delete('http://localhost:8080/mvc/rest/players/'+id)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while deleting player');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);