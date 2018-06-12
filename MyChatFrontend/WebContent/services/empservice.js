/**
 * EmpService
 */
app.factory('EmpSrvice',function($http ){
	var empService={}
	
	empService.addEmp=function(emp){
		return $http.post("http://localhost:8081/MyChatMiddleware/addemp ",emp)
	}
	return empService;
})