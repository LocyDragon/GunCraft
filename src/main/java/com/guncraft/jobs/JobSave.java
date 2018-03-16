package com.guncraft.jobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JobSave {
	public static FileConfiguration jobSave = null;
	public static List<JobEnum> getJobs(Player who) {
		List<String> jobList = jobSave.getStringList(who.getName().toLowerCase());
		List<JobEnum> hasJob = new ArrayList<>();
		hasJob.add(JobEnum.医生);
		hasJob.add(JobEnum.活动检测);
		if (jobList != null && !jobList.isEmpty()) {
            for (String job : jobList) {
            	hasJob.add(JobEnum.valueOf(job));
			}
		}
		return hasJob;
	}
	public static boolean buyJob(Player who, JobEnum job) {
		List<String> jobList = jobSave.getStringList(who.getName().toLowerCase());
		for (String obj : jobList) {
			if (obj.equals(job.toString())) {
				return false;
			}
		}
		jobList.add(job.toString());
		jobSave.set(who.getName(), jobList);
		try {
			jobSave.save(new File(".//plugins//GunCraft//gunmatch" +".yml"));
		} catch (Exception exc) {
			return false;
		}
		return true;
	}
}
