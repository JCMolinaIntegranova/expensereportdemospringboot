package com.integranova.spring.expensereportdemo.global;

import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.service.AbstractService;
import com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User functions
 */
@Service
public class UserFunctions extends AbstractService {

   /** 
    * Method that solves the getEmployeeByName user function.
    *
    * @param "pfName" This parameter represents the pfName inbound argument.
    *
    * @param "outFound" This parameter represents the outFound outbound argument.
    *
    * @return Return Employee value of the User Function
    */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public Employee getEmployeeByNameFun(String pfName, java.util.Map<String, Object> outArgs) {
        // Please implement the body of your user function
        // Set the value of outbound argument 'outFound'
        outArgs.put("outFound", false);
        return null;
    }

    public Employee getEmployeeByNameFun(GetEmployeeByNameRequest request, java.util.Map<String, Object> outArgs) {
        return getEmployeeByNameFun(request.getPfName(), outArgs);
    }
}
