/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.vms.project.service.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.*;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.impl.ProjectManagementServiceImpl;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

/**
 *
 * @author zaw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/spring-hibernate-vms.xml",
        "/spring-mail.xml",
        "/spring-resources-vms.xml",
        "/spring-security.xml",
        "/spring-service-operation.xml",
        "/spring-service.xml"
})
public class ProjectManagementServiceImplTest {
	
	  @Qualifier("projectManagementServiceImpl")
      @Autowired
      protected ProjectManagementServiceImpl projectManagementService;

    public ProjectManagementServiceImplTest() {
    }

        @BeforeClass
        public static void setUpClass() throws Exception {
        }

        @AfterClass
        public static void tearDownClass() throws Exception {
        }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

        /**
         * Test of getManager method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetManager() {
        	 System.out.println("getManager");
             assertNotNull(projectManagementService.getManager());
        }

        /**
         * Test of getProjectList method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectList() {

        	System.out.println("getProjectList");    
            try {
                List<ProjectVo> projectVoList = projectManagementService.getProjectList();
                assertNotNull(projectVoList);                  
            } catch (Exception ex) {
                fail(ex.getMessage());
            }
        }

        /**
         * Test of getProjectVoByLoginUserAccessRight method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectVoByLoginUserAccessRight() {
                System.out.println("getProjectVoByLoginUserAccessRight");
                try {
                	ProjectVo projectVo = projectManagementService.getProjectVoByLoginUserAccessRight(1L);
                    assertNotNull(projectVo);   
                    assertEquals(projectVo.getName(), "Reveninentor");
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

        /**
         * Test of getProjectbyProjectVo method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectbyProjectVo() {
                System.out.println("getProjectbyProjectVo");
                try {
                	ProjectVo projectVo = new ProjectVo();
                	projectVo.setName("re");
                	List<ProjectDto> projectDtoList= projectManagementService.getProjectbyProjectVo(projectVo);
                    assertNotNull(projectDtoList);   
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

        /**
         * Test of getProjectbyId method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectbyId() {
                System.out.println("getProjectbyId");
                long id = 1L;
                try {
                	ProjectVo projectVo = projectManagementService.getProjectVoByLoginUserAccessRight(id);
                    assertNotNull(projectVo);   
                    assertEquals(projectVo.getName(), "Reveninentor");
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

        /**
         * Test of getProjectVoById method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectVoById() {
                System.out.println("getProjectVoById");
                long projectId = 1L;
                try {
                	ProjectVo projectVo = projectManagementService.getProjectVoById(projectId);
                    assertNotNull(projectVo);   
                    assertEquals(projectVo.getName(), "Reveninentor");
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

      

        /**
         * Test of getProjectListbyProjectVo method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectListbyProjectVo() {
                System.out.println("getProjectListbyProjectVo");
                try {
                	ProjectVo projectVo = new ProjectVo();
                	projectVo.setName("re");
                	List<ProjectVo> projectVoList= projectManagementService.getProjectbyProjectVo(projectVo);
                    assertNotNull(projectVoList);  
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

        /**
         * Test of getProjectMember method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectMember() {
                System.out.println("getProjectMember");
                long projectId = 1L;
                try {
                	List<ProjectMemberDto> projectMemberDtoList = projectManagementService.getProjectVoById(projectId);
                    assertNotNull(projectMemberDtoList);   
                    assertEquals(projectMemberDtoList.size(), 2);
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

        /**
         * Test of getProjectsbyProjectVo method, of class ProjectManagementServiceImpl.
         */
        @Test
        public void testGetProjectsbyProjectVo() {
                System.out.println("getProjectsbyProjectVo");
                try {
                	ProjectVo projectVo = new ProjectVo();
                	projectVo.setName("re");
                	List<ProjectVo> projectVoList= projectManagementService.getProjectbyProjectVo(projectVo);
                    assertNotNull(projectVoList);   
                } catch (Exception ex) {
                    fail(ex.getMessage());
                }
        }

}