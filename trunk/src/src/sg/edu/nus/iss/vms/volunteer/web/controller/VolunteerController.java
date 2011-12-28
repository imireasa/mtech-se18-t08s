package sg.edu.nus.iss.vms.volunteer.web.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerController extends BaseMultiActionFormController {

        private CodeManagementServices codeManagementServices;
        private VolunteerManagementService volunteerManagementService;
	private ProjectManagementService projectManagementService;
        // local
        private final Logger logger = Logger.getLogger(VolunteerController.class);
        BindingResult errors;

        public VolunteerController() {
        }

        public void setCodeManagementServices(
                CodeManagementServices codeManagementServices) {
                this.codeManagementServices = codeManagementServices;
        }

        public void setVolunteerManagementService(
                VolunteerManagementService volunteerManagementService) {
                this.volunteerManagementService = volunteerManagementService;
        }

        @Override
        public long getLastModified(HttpServletRequest arg0) {
                logger.debug("###################################################################################");
                return super.getLastModified(arg0);
        }

        public BindingResult getErrors() {
                return errors;
        }

        public void setErrors(BindingResult errors) {
                this.errors = errors;
        }

	public ProjectManagementService getProjectManagementService() {
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

        @Override
        protected void bind(HttpServletRequest request, Object command)
                throws Exception {
                // TODO Auto-generated method stub

                ServletRequestDataBinder binder = createBinder(request, command);
                binder.bind(request);
                errors = binder.getBindingResult();
        }

        public void validate(Object command) {
                Validator[] validators = getValidators();
                if (validators != null) {
                        for (int index = 0; index < validators.length; index++) {
                                Validator validator = validators[index];
                                if (validator instanceof VolunteerValidator) {
                                        if (((VolunteerValidator) validator).supports(command.getClass())) {
                                                ValidationUtils.invokeValidator(validators[index],
                                                        command, errors);
                                        }
                                } else if (validator.supports(command.getClass())) {
                                        ValidationUtils.invokeValidator(validators[index], command,
                                                errors);
                                }
                        }
                }
        }

        public ModelAndView loadRegisterVolunteer(HttpServletRequest request,
                HttpServletResponse response) throws Exception {
                modelAndView = new ModelAndView("volunteer/registerVolunteer");// jsp
                // page
                modelAndView.addObject("titalList", codeManagementServices.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
                modelAndView.addObject("countryList", codeManagementServices.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                modelAndView.addObject("command", new VolunteerVo());
                return modelAndView;
        }

        public ModelAndView registerVolunteer(HttpServletRequest request,
                HttpServletResponse response, VolunteerVo command) throws Exception {

                validate(command);
                modelAndView = new ModelAndView("volunteer/registerVolunteer");
                modelAndView.addObject("titalList", codeManagementServices.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
                modelAndView.addObject("countryList", codeManagementServices.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                VolunteerVo volunteerVo = command;
                if (errors.hasErrors()) {
                        logger.debug("Error Handling : ");
                        saveError(request, errors.getFieldError().getDefaultMessage());
                        modelAndView.addObject("command", volunteerVo);
                        return modelAndView;
                }

                try {
                        volunteerManagementService.saveNewVolunteer(volunteerVo);
                } catch (ApplicationException ae) {
                        List list = new ArrayList();
                        list.add(ae.getMessage());
                        modelAndView.addObject("errors", list);
                        modelAndView.addObject("command", volunteerVo);
                        return modelAndView;
                }

                modelAndView.addObject("command", volunteerVo);
                modelAndView.addObject("msg", "save success");
                return modelAndView;
	public ModelAndView browseProject(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		modelAndView = new ModelAndView("volunteer/browseProject");// jsp page
		List<ProjectDto> projectList = projectManagementService
				.getListAllProject();
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", new ProjectVo());
		return modelAndView;
	}

	public ModelAndView searchProjects(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {

		logger.debug("searchProjects");

		modelAndView = new ModelAndView("volunteer/browseProject");
		List<ProjectDto> projectList = projectManagementService
				.getProjectbyProjectVo(command);
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", command);
		return modelAndView;

	}

	public ModelAndView viewProjectDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		long prjId = Long.parseLong(request.getParameter("prjId"));

		ProjectDto projectDto = projectManagementService.getProjectbyId(prjId);

		modelAndView = new ModelAndView("volunteer/viewProjectDetails");
		modelAndView.addObject("project", projectDto);
		return modelAndView;

	}

	public ModelAndView raiseInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");
		logger.debug("@@@@@@@@@@@@@@raiseInterest@@@@@@@@@:"
				+ projectDto.getPrjId());

		ProjectInterestDto projectInterestDto = new ProjectInterestDto();
		projectInterestDto.setPrjId(projectDto);
		projectInterestDto.setCreatedDte(new Date());
		projectInterestDto.setCreatedBy("XXX");
		projectInterestDto.setReqBy("ss");
		projectInterestDto.setVersion(1);
		projectInterestDto.setUpdBy("ss");
		projectInterestDto.setUpdDte(new Date());
		projectInterestDto.setStsCd(11);

		projectManagementService.raseInterest(projectInterestDto);

		logger.debug("@@@@@@@@@@@@@@successfully raise new project interest@@@@@@@@@:"
				+ projectDto.getPrjId());

		modelAndView = new ModelAndView("volunteer/viewProjectDetails");

		modelAndView.addObject("project", projectDto);
		return modelAndView;

	}
}
