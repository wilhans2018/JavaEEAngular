var cursoModulo = angular.module('cursoModulo', []);

cursoModulo.controller("cursoController", function($scope, $http) {
	
	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';
	urlcurso = 'http://localhost:8080/Projeto4Final/rest/cursos';

	$scope.listarcursos = function() {
		$http.get(urlcurso).success(function(cursos) {
		$scope.cursos = cursos;
		}).error(function(erro) {
			alert(erro);
		})
	}
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessor).success(function(professores) {
		$scope.professores = professores;
		}).error(function(erro) {
			alert(erro);
		})
	}

	$scope.selecionacurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.curso = "";
	}

	$scope.salvar = function() {
		//alert($scope.curso.codigo);
		console.log($scope.curso.codigo);
		if ($scope.curso.codigo == undefined) {
			//alert("codigo vazio = novo registro")
			console.log("codigo vazio = novo registro")
			$http.post(urlcurso, $scope.curso).success(
					function(curso) {
						//$scope.cursos.push($scope.curso);
						$scope.listarcursos();
						$scope.limparCampos();
					}).error(function(erro) {
				alert(erro);
			})

		} else {
			//alert("codigo nao vazio = update")
			console.log("codigo nao vazio = update");
			$http.put(urlcurso, $scope.curso).success(
					function(curso) {
						$scope.listarcursos();
						$scope.limparCampos();
					}).error(function(erro) {
				alert(erro);
			})

		}
	}

	$scope.excluir = function() {

		if ($scope.curso.codigo == undefined) {
			alert("Favor selecionar um registro para poder excluir!!!")
			console.log("Favor selecionar um registro para poder excluir")
		}else{
			$http.delete(urlcurso +'/' + $scope.curso.codigo).success(
					function() {
						$scope.listarcursos();
						$scope.limparCampos();
					}).error(function(erro) {
				alert(erro);
			})
		}
	}

	// executa
	
	$scope.listarcursos();
	$scope.listarProfessores();
	

});
