package com.integranova.spring.expensereportdemo.api.project;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.service.ProjectService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.crud.ProjectPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.crud.ProjectPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.project.piu.SELProjectResponse;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ProjectApi")
@Api(value = "Project")
public class ProjectApi {

    @Autowired
    ProjectService service;

    @GetMapping(value="/")
    public List<Project> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{projectidProject}")
    public Project getInstance(Long projectidProject) {
    	return service.getById(projectidProject);
    }

    @PostMapping(value="/")
    public Project postInstance(@RequestBody ProjectPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{projectidProject}")
    public Project putInstance(Long projectidProject, @RequestBody ProjectPutViewModel payload) throws ModelException {
    	return service.put(projectidProject, payload);
    }
    
    @DeleteMapping(value="/{projectidProject}")
    public void deleteInstance(Long projectidProject) throws ModelException {
    	service.delete(projectidProject);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getProjectPreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSProject")
    @ApiOperation(value = "Returns displayset DSProject for an instance of Project")
    public DSProject getDSProject(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSProject(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSProjectSup")
    @ApiOperation(value = "Returns displayset DSProjectSup for an instance of Project")
    public DSProjectSup getDSProjectSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSProjectSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetProject")
    @ApiOperation(value = "Returns an instance of Project", hidden = true)
    public Project getProject(Long projectidProject) {
        return service.getById(projectidProject);
    }
    
    @PostMapping(value = "/GetProjectDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getProjectDynamic(@RequestBody QueryRequest request) {
        ProjectOid oid = new ProjectOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getProjectDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getProjectWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getProjectPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByTeam")
    @ApiOperation(value = "Returns instances related with another one through Team")
    public List<Project> getProjectByTeam(TeamOid relatedInstanceOid) {
        Team relatedInstance = new Team(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Team");
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "Project's creation event")
    public ServiceResponse projectCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "Project's destruction event")
    public ServiceResponse projectDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "Project's change event")
    public ServiceResponse projectEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/assignTemplateToProject")
    @ApiOperation(value = "Assign Template")
    public ServiceResponse projectAssignTemplateToProject(@RequestBody AssignTemplateToProjectRequest request) {
        return service.assignTemplateToProject(request);
    }
    

    @PostMapping(value = "/deassignTemplate")
    @ApiOperation(value = "Deassign Template")
    public ServiceResponse projectDeassignTemplate(@RequestBody DeassignTemplateRequest request) {
        return service.deassignTemplate(request);
    }
    

    @PostMapping(value = "/TCOMPLETE")
    @ApiOperation(value = "Complete")
    public ServiceResponse projectTCOMPLETE(@RequestBody TCOMPLETERequest request) {
        return service.tCOMPLETE(request);
    }
    

    @PostMapping(value = "/IIU_Project")
    @ApiOperation(value = "Project")
    public DSProject iiuIIUProject(@RequestBody ProjectOid oid) {
        return service.iIUProject(oid);
    }

    @PostMapping(value = "/IIU_ProjectReports")
    @ApiOperation(value = "Project")
    public DSProject iiuIIUProjectReports(@RequestBody ProjectOid oid) {
        return service.iIUProjectReports(oid);
    }

    @PostMapping(value = "/PIU_Project")
    @ApiOperation(value = "Projects")
    public PIUProjectResponse piuPIUProject(@RequestBody PIUProjectRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUProjectResponse response;
        try
        {
            response = new PIUProjectResponse(service.piuPIUProject(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUProject(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUProjectResponse();
            response.setException(e);
        }
        return response;
    }

    @PostMapping(value = "/SEL_Project")
    @ApiOperation(value = "Projects")
    public SELProjectResponse piuSELProject(@RequestBody PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        SELProjectResponse response;
        try
        {
            response = new SELProjectResponse(service.piuSELProject(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4SELProject(queryRequest));
            }
        } catch (Exception e) {
            response = new SELProjectResponse();
            response.setException(e);
        }
        return response;
    }

}
