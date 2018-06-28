/**
 * JobService
 */
app.factory('JobService',function($http){
	var jobService={}
	
	jobService.addJob=function(job){
		return $http.post("http://localhost:8085/MyChatMiddleware/addjob",job)

			}
	jobService.getActiveJobs=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/activejobs")

	}
	jobService.getInActiveJobs=function(){
		return $http.get("http://localhost:8085/MyChatMiddleware/inactivejobs")

	}
	jobService.updateActiveStatus=function(job){
		return $http.put("http://localhost:8085/MyChatMiddleware/updatejob",job)

		
	}
   return jobService;

})