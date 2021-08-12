package com.integranova.spring.expensereportdemo.api.team;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.service.TeamService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.crud.TeamPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.team.crud.TeamPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams;
import com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest;
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
@RequestMapping("/api/TeamApi")
@Api(value = "Team")
public class TeamApi {

    @Autowired
    TeamService service;

    @GetMapping(value="/")
    public List<Team> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{teamid}")
    public Team getInstance(Long teamid) {
    	return service.getById(teamid);
    }

    @PostMapping(value="/")
    public Team postInstance(@RequestBody TeamPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{teamid}")
    public Team putInstance(Long teamid, @RequestBody TeamPutViewModel payload) throws ModelException {
    	return service.put(teamid, payload);
    }
    
    @DeleteMapping(value="/{teamid}")
    public void deleteInstance(Long teamid) throws ModelException {
    	service.delete(teamid);
    }

    @PostMapping(value = "/GetDSTeams")
    @ApiOperation(value = "Returns displayset DSTeams for an instance of Team")
    public DSTeams getDSTeams(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSTeams(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSTeam")
    @ApiOperation(value = "Returns displayset DSTeam for an instance of Team")
    public DSTeam getDSTeam(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSTeam(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetTeam")
    @ApiOperation(value = "Returns an instance of Team", hidden = true)
    public Team getTeam(Long teamid) {
        return service.getById(teamid);
    }
    
    @PostMapping(value = "/GetTeamDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getTeamDynamic(@RequestBody QueryRequest request) {
        TeamOid oid = new TeamOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getTeamDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getTeamWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getTeamPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "Team's creation event")
    public ServiceResponse teamCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "Team's destruction event")
    public ServiceResponse teamDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "Team's change event")
    public ServiceResponse teamEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/addEmployeeToTeam")
    @ApiOperation(value = "addEmployeeToTeam")
    public ServiceResponse teamAddEmployeeToTeam(@RequestBody AddEmployeeToTeamRequest request) {
        return service.addEmployeeToTeam(request);
    }
    

    @PostMapping(value = "/removeEmployeeFromTeam")
    @ApiOperation(value = "removeEmployeeFromTeam")
    public ServiceResponse teamRemoveEmployeeFromTeam(@RequestBody RemoveEmployeeFromTeamRequest request) {
        return service.removeEmployeeFromTeam(request);
    }
    

    @PostMapping(value = "/IIU_Team")
    @ApiOperation(value = "Team")
    public DSTeam iiuIIUTeam(@RequestBody TeamOid oid) {
        return service.iIUTeam(oid);
    }

    @PostMapping(value = "/PIU_Teams")
    @ApiOperation(value = "Teams")
    public PIUTeamsResponse piuPIUTeams(@RequestBody PIUTeamsRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUTeamsResponse response;
        try
        {
            response = new PIUTeamsResponse(service.piuPIUTeams(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUTeams(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUTeamsResponse();
            response.setException(e);
        }
        return response;
    }

}
