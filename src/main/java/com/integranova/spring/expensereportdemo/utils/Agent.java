package com.integranova.spring.expensereportdemo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.persistence.IEntity;
import com.integranova.spring.expensereportdemo.persistence.oid.IOid;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.security.User;
import com.integranova.spring.expensereportdemo.security.UserCrudService;
import com.integranova.spring.expensereportdemo.service.AppUserService;
import com.integranova.spring.expensereportdemo.service.AdminUserService;
import com.integranova.spring.expensereportdemo.service.OperatorUserService;

/**
 * Holds the information of the connected agent.
 */
@Service
public class Agent implements UserCrudService {

    private String className;
    
    private String agentName;

    private IOid agentOid;

    private List<String> activeFacets = new ArrayList<>();

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private OperatorUserService operatorUserService;

    public List<String> getAgentRoles() {
        List<String> roles = new ArrayList<>();
        Authentication auth = getAuthentication();
        if (auth instanceof UsernamePasswordAuthenticationToken) {
            roles.addAll(getAgentRoles((UsernamePasswordAuthenticationToken) auth));
        }
        return roles;
    }

    private List<String> getAgentRoles(UsernamePasswordAuthenticationToken auth) {
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : auth.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        return roles;
    }

    private Authentication getAuthentication() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext != null ? securityContext.getAuthentication() : null;
    }

    /**
     * Returns the identifier of the connected agent.
     * 
     * @return the agent identifier.
     */
    public IOid getAgentOid() {
        if (agentOid == null)
        {
            IEntity agentInstance = getAgentInstance();
            agentOid = agentInstance != null ? agentInstance.getOid() : null;
        }
        return agentOid;
    }

    /**
     * Returns the instance of the connected agent.
     * 
     * @return Agent Entity
     */
    public IEntity getAgentInstance() {
    	setClassName(getAgentRoles().get(0));
        IEntity lAgent = null;
        if (Constants.APPUSER.equalsIgnoreCase(className)) {
            lAgent = appUserService.getByOID(new AppUserOid(agentName));
        }
        if (Constants.ADMINUSER.equalsIgnoreCase(className)) {
            lAgent = adminUserService.getByOID(new AdminUserOid(agentName));
        }
        if (Constants.OPERATORUSER.equalsIgnoreCase(className)) {
            lAgent = operatorUserService.getByOID(new OperatorUserOid(agentName));
        }
        return lAgent;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    
    public String getAgentName() {
        if (agentName == null || agentName.isEmpty()) {
            Authentication authentication = getAuthentication();
            agentName = authentication instanceof AnonymousAuthenticationToken ? "" : getAgentName(authentication);            
        }
        return agentName;
    }
    
    private String getAgentName(Authentication auth) {
        return auth != null ? auth.getName() : "";
    }
    
    /**
     * Returns the a given active facet of the instance of the connected agent.
     * 
     * @param facetName name of the active facet to return.
     * @return given active facet of the instance of the connected agent.
     */
    public IEntity getAgentInstance(String facetName) {
        IEntity currentAgentInstance = null;
        try {
            currentAgentInstance = getAgentInstance();
            if (currentAgentInstance == null) {
                Class<?> classFacet = Class
                        .forName("com.integranova.spring.expensereportdemo.persistence." + facetName);
                Constructor<?> agentConstructor = classFacet.getConstructor();
                currentAgentInstance = (IEntity) agentConstructor.newInstance();
            } else {
                if (!className.equalsIgnoreCase(facetName)) {
                    currentAgentInstance = executeGetFacetMethod(currentAgentInstance,
                            currentAgentInstance.getMethod(facetName + "facet"));
                }
            }
        } catch (Exception e) {
            currentAgentInstance = null;
        }
        return currentAgentInstance;
    }

    private IEntity executeGetFacetMethod(IEntity entity, Method getFacetMethod) {
        IEntity facet;
        try {
            facet = (getFacetMethod != null ? (IEntity) getFacetMethod.invoke(entity) : null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            facet = null;
        }
        return facet;
    }

    /**
     * Sets the identifier of the connected agent.
     * 
     * @param agentOID the agent identifier.
     */
    public void setAgentOID(IOid agentOid) {
        this.agentOid = agentOid;
    }

    /**
     * Returns the name of the connected agent model class. The model class name is
     * used to perform several visibility checks.
     * 
     * @return the agent class name.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the model class name of the connected agent.
     * 
     * @param className the agent class name.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Says if the connected agent is an instance of the model class
     * <code>agentClass</code>.
     *
     * @param agentClass the name of the model class to check against the connected
     *                   agent.
     * @return TRUE if the connected agent is an instance of the model class
     *         <code>agentClass</code> FALSE otherwise.
     */
    public boolean isA(String agentClass) {
        return className.equals(agentClass);
    }

    /**
     * Determines which attributes of the given display set the agent is able to see.
     * 
     * @param displaySet the attributes set to check.
     * @return the collection of attributes that this agent can see.
     * @throws SystemException In case of any error
     */
    public Collection<String> getVisibleAttributes(String displaySet) {
        Collection<String> attrList = new ArrayList<>();
        for (String attribute : displaySet.split(",")) {
            attrList.add(attribute.trim());
        }
        return attrList;
    }

    /**
     * Gets the list of active facets.
     * 
     * @return the activeFacets
     */
    public List<String> getActiveFacets() {
        return activeFacets;
    }

    /**
     * Sets the list of active facets.
     * 
     * @param activeFacets the activeFacets to set
     */
    public void setActiveFacets(List<String> activeFacets) {
        this.activeFacets = activeFacets;
    }

    /**
     * Returns if any of the facets is active
     * @param facets Comma-separated list of class names
     * @return True if any of the class names is an active facet
     */
    public boolean isAnyFacetActive(String facets) {
    	boolean result = false;
    	for(String facet : facets.split(",")) {
    		result |= isFacetActive(facet);
    	}
    	return result;
    }
    
    /**
     * Returns if a agent class is active or not.
     * 
     * @param agentClassName the name of the class agent
     * @return true if the class of the agent is active, false otherwise
     */
    public boolean isFacetActive(String agentClassName) {
    	return getAgentRoles().contains(agentClassName);
    }

    /**
     * Initializes the active facets list corresponding to the connected agent.
     */
    public void calculateActiveFacets() {
        activeFacets = new ArrayList<>();
        IEntity agentInstance = this.getAgentInstance();
        if (agentInstance != null) {
            activeFacets = agentInstance.getActiveFacets();
        } else {
            activeFacets.add(this.className);
        }
    }
    @Override
    public User save(User agent) {
        return agent;
    }

    @Override
    public Optional<User> find(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String userName) {
    	AbstractAppEntity instance = findAgentByUserName(userName);
    	List<String> roles = (instance != null ? instance.getActiveFacets() : new ArrayList<>());
        return instance != null ? Optional.of(new User(userName, getPassword(instance), roles)) : Optional.empty();
    }
    
    @Override
    public Optional<User> findByFacetAndUsername(String facetName, String userName) {
    	AbstractAppEntity instance = findAgentByFacetAndUsername(facetName, userName);
    	List<String> roles = (instance != null ? instance.getActiveFacets() : new ArrayList<>());
        return instance != null ? Optional.of(new User(userName, getPassword(instance), roles)) : Optional.empty();
    }
    
    private AbstractAppEntity findAgentByUserName(String userName) {
    	AbstractAppEntity instance;
        instance = findAppUserByUserName(userName);
    	return instance;
    }
    
    private AbstractAppEntity findAgentByFacetAndUsername(String facetName, String userName) {
    	switch (facetName) {
    	case Constants.APPUSER:
    		return findAgentAsAppUser(userName);
    	case Constants.ADMINUSER:
    		return findAgentAsAdminUser(userName);
    	case Constants.OPERATORUSER:
    		return findAgentAsOperatorUser(userName);
    	default:
    		return null;
    	}
    }

    private AppUser findAppUserByUserName(String userName) {
        return appUserService.getById(userName);
    }

    private AppUser findAgentAsAppUser(String userName) {
    	return appUserService.getByJsonOid(userName);
    }

    private AdminUser findAgentAsAdminUser(String userName) {
    	return adminUserService.getByJsonOid(userName);
    }

    private OperatorUser findAgentAsOperatorUser(String userName) {
    	return operatorUserService.getByJsonOid(userName);
    }

    private String getPassword(AbstractAppEntity instance) {
    	String p4ssw0rd;
    	Method p4ssw0rdGetter = instance.getMethod("PassWord");
    	try {
    		p4ssw0rd = p4ssw0rdGetter != null
        			? (p4ssw0rdGetter.invoke(instance)).toString()
        			: "";
    	} catch (Exception e) {
    		p4ssw0rd = "";
    	}
    	return p4ssw0rd;
    }
}
