package com.org.Dao;

import java.util.List;

import com.org.models.Job;

public interface JobDao {
  void saveJob(Job job);
  List<Job> getActiveJobs();//active is true,for other roles
  //For admin to return all jobs
  List<Job> getInActiveJobs();
void updateJob(Job job);
}

