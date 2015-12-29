package com.mjolly.transactions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mjolly.db.Messages;
import com.mjolly.wrappers.MessageWrapper;

//DAO object to manage Hibernate transactions for website messenger
@Component
@Scope("singleton")
@Transactional
public class MessageTransactions 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public MessageTransactions()
	{}
	
	//Retrieve messages from DB in reverse chronological order
	public ArrayList<MessageWrapper> getMessages()
	{
		ArrayList<MessageWrapper> messages= new ArrayList<>();
		Session s = getCurrentSession();
		
		Query q = s.createQuery("from Messages as m where m.private_  = 0 order by m.createdAt desc");
		List<Messages> messageList = q.list();
		
		for(Messages m: messageList)
		{
			messages.add(messages.size(), new MessageWrapper(m));
		}
		return messages;
	}
	
	//Create a new message and save to database
	public ArrayList<MessageWrapper> sendMsg(MessageWrapper mw)
	{
		Session s = getCurrentSession();		
		Messages m = new Messages(mw.getUsername(), mw.getMessage(), new Date(), mw.getPrivate_());
		s.save(m);
		
		return getMessages();
	}
}
