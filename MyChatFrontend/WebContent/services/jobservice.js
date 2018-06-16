/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobServices={}
	
	jobService.addjob=function(job){
		return $http.post("http://localhost:8081/MyChatMiddleware/addjob",job)
	}

   return jobService;

})