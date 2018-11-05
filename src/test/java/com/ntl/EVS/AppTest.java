package com.ntl.EVS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	com.ntl.EVS.dao.impl.EoDaoImplTest.class,
	com.ntl.EVS.dao.impl.ApplicationDaoImplTest.class,
	com.ntl.EVS.dao.impl.CandidateDaoImplTest.class,
	com.ntl.EVS.dao.impl.CredentialsDaoImplTest.class,
	com.ntl.EVS.dao.impl.ElectionDaoImplTest.class,
	com.ntl.EVS.dao.impl.PartyDaiImplTest.class,
	com.ntl.EVS.dao.impl.VoterDaoImplTest.class,
	com.ntl.EVS.service.AdministratorImplTest.class,
	com.ntl.EVS.service.ElectoralOfficerImplTest.class,
	com.ntl.EVS.util.AuthenticationTest.class,
	com.ntl.EVS.util.UserTest.class
})
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public AppTest() {
		
	}
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
