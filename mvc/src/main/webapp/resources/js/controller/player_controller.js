'use strict';

App.controller('PlayerController', ['$scope', 'PlayerService', function($scope, PlayerService) {
    var self = this;
    self.player={id:null,firstName:'',lastName:''};
    self.players=[];

    // --------------- service delegation methods start --------------------
    
    self.fetchAllPlayers = function(){
        PlayerService.fetchAllPlayers()
            .then(
                function(d) {
                    self.players = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.createPlayer = function(player){
        PlayerService.createPlayer(player)
            .then(
                self.fetchAllPlayers,
                function(errResponse){
                    console.error('Error while creating Player.');
                }
            );
    };

    self.updatePlayer = function(player, id){
        PlayerService.updatePlayer(player, id)
            .then(
                self.fetchAllPlayers,
                function(errResponse){
                    console.error('Error while updating Player.');
                }
            );
    };

    self.deletePlayer = function(id){
        PlayerService.deletePlayer(id)
            .then(
                self.fetchAllPlayers,
                function(errResponse){
                    console.error('Error while deleting Player.');
                }
            );
    };
    
    // --------------- service methods end --------------------

    //init players
    self.fetchAllPlayers();

    self.submit = function() {
        if(self.player.id===null){
            console.log('Saving New Player', self.player);
            self.createPlayer(self.player);
        }else{
            self.updatePlayer(self.player, self.player.id);
            console.log('Player updated with id ', self.player.id);
        }
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].id === id) {
                self.player = angular.copy(self.players[i]);
                break;
            }
        }
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.player.id === id) {//clean form if the player to be deleted is shown there.
            self.reset();
        }
        self.deletePlayer(id);
    };

    self.reset = function(){
        self.player={id:null,firstName:'',lastName:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);