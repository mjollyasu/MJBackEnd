package com.mjolly.webSvc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
 




import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.mjolly.db.Messages;
import com.mjolly.transactions.MessageTransactions;
import com.mjolly.wrappers.MessageWrapper;

//Controller handles get/post requests from front-end
@RestController
@RequestMapping("/service")
@Component
public class RestServiceController 
{
	
	@Autowired
	MessageTransactions mt;
	
	//Sends all public messages to front-end
	@RequestMapping(value="/messages", method=RequestMethod.GET)
    public ArrayList<MessageWrapper> messages() {
        return mt.getMessages();
    }
	
	//Creates and stores a new message
	@RequestMapping(value="/sendMsg", method=RequestMethod.POST, consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public @ResponseBody ArrayList<MessageWrapper> sendMsg(@RequestBody MessageWrapper mw)
	{
		return mt.sendMsg(mw);
	}
	
}
	  

