app.controller('CalculadoraController', function ($scope) {

$scope.var1;
$scope.var2;
$scope.total;
  
$scope.somarValores = function(){

    $scope.total = $scope.var1 + $scope.var2;

  }
});