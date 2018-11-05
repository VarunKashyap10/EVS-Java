package com.ntl.evs.dao;

import java.util.ArrayList;

import com.ntl.evs.bean.ProfileBean;

public interface ProfileDAO {
	String createProfile(ProfileBean profileBean);
	int deleteProfile(ArrayList<String> profiles);
	boolean updateProfile(ProfileBean rofileBean);
	ProfileBean findById(String profile);
	ArrayList<ProfileBean> findAll();
}
