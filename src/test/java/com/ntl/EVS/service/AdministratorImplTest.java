package com.ntl.EVS.service;


import com.ntl.evs.bean.ApplicationBean;
import com.ntl.evs.bean.CandidateBean;
import com.ntl.evs.bean.ElectionBean;
import com.ntl.evs.bean.PartyBean;
import com.ntl.evs.dao.impl.ApplicationDaoImpl;
import com.ntl.evs.dao.impl.CandidateDaoImpl;
import com.ntl.evs.dao.impl.CredentialsDaoImpl;
import com.ntl.evs.dao.impl.ElectionDaoImpl;
import com.ntl.evs.dao.impl.PartyDaoImpl;
import com.ntl.evs.service.impl.AdministratorImpl;


import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import static org.mockito.Mockito.mock;

import junit.framework.TestCase;

public class AdministratorImplTest extends TestCase {
	//@Mock
	CandidateDaoImpl cand=mock(CandidateDaoImpl.class);
	//@Mock
	ApplicationDaoImpl appd=mock(ApplicationDaoImpl.class);
	//@Mock
	ElectionDaoImpl elec=mock(ElectionDaoImpl.class);
	//@Mock
	CredentialsDaoImpl cre=mock(CredentialsDaoImpl.class);
	//@Mock
	PartyDaoImpl par;
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Test
	public void testAddElection() {
		ElectionBean e=new ElectionBean("Varun",Date.valueOf("1997-03-30"),"qwe","asd",Date.valueOf("1997-03-30"));
		when(elec.createElection(e)).thenReturn("SUCCESS"); 
		AdministratorImpl admin=new AdministratorImpl(elec,cand,appd,par);
		assertEquals("Failed to test AddElection","SUCCESS",admin.addElection(e));
//		fail("Not yet implemented");
	}

	public void testViewAllUpcomingElections() {
		//public ElectionBean(String uid,String name,Date doe,String dist,String cons,Date coe)
		ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("1997-03-30"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2018-12-12"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2019-03-12"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2019-01-30"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		when(elec.findAll()).thenReturn(arr);
		AdministratorImpl admin=new AdministratorImpl(elec,cand,appd,par);
		assertEquals("Failed to view  Upcoming elections",arr, admin.viewAllUpcomingElections());
		//fail("Not yet implemented");
	}

	public void testViewElections() {
		ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("1997-03-30"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2018-12-12"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2019-03-12"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		arr.add(new ElectionBean("El123","Election1",Date.valueOf("2019-01-30"),"Delhi","Delhi",Date.valueOf("1997-03-30")));
		when(elec.findAll()).thenReturn(arr);
		AdministratorImpl admin=new AdministratorImpl(elec,cand,appd,par);
		assertEquals("Failed to view  Upcoming elections",arr, admin.viewAllUpcomingElections());
		fail("Not yet implemented");
	}
	@Test
	public void testAddParty() {
		PartyBean p=new PartyBean();
		//when(par.createParty(p)).thenReturn("SUCCESS");
		AdministratorImpl admin=new AdministratorImpl(elec,cand,appd,par);
		assertEquals("Add Party Failed","SUCCESS",admin.addParty(p));
		//fail("Not yet implemented");
	}

	public void testViewAllParty() {
		ArrayList<PartyBean> arr=new ArrayList<PartyBean>();
		arr.add(new PartyBean());
		arr.add(new PartyBean());
		//when(par.findAll()).thenReturn(arr);
		AdministratorImpl admin=new AdministratorImpl(elec,cand,appd,par);
		//assertEquals("Add View All Party failed",arr,admin.viewAllParty());
		fail("asd");
	}

	public void testAddCandidate() {
		CandidateBean c=new CandidateBean();
		when(cand.createCandidate(c)).thenReturn("SUCCESS");
		AdministratorImpl admin = new AdministratorImpl(elec,cand,appd,par);
		assertEquals("Failed to create candidate","SUCCESS",admin.addCandidate(c));
		//fail("Not yet implemented");
	}

	public void testViewCandidateDetailsByElectionName() {
		//when(cand.findByElectionName("Varun")).thenReturn(cand.findByElectionName("Varun"));
		AdministratorImpl admin = new AdministratorImpl(elec,cand,appd,par);
		//assertEquals("Failed to test ",cand.findByElectionName("Varun"),admin.viewCandidateDetailsByElectionName("Varun"));
		fail("Not yet implemented");
	}

	public void testViewAllAdminPendingApplications() {
		ArrayList<ApplicationBean> arr=new ArrayList<ApplicationBean>();
		arr.add(new ApplicationBean("VK9999","Delhi",1,0,""));
		arr.add(new ApplicationBean("VK99dsa","Delhi",1,0,""));
		arr.add(new ApplicationBean("VK9a","Delhi",0,0,""));
		when(appd.findAll()).thenReturn(arr);
		AdministratorImpl admin = new AdministratorImpl(elec,cand,appd,par);
		assertEquals(arr, admin.viewAllAdminPendingApplications());
		//fail("Not yet implemented");
	}

	public void testForwardVoterIDRequest() {
		fail("Not yet implemented");
	}

	public void testViewCandidateDetailsByParty() {
		fail("Not yet implemented");
	}

	public void testApproveElectionResults() {
		fail("Not yet implemented");
	}

}
