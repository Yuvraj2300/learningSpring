package com.lrn.spring.factoryBean;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
	private String algoName = "MD5";

	private MessageDigest messageDigest = null;

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		messageDigest = MessageDigest.getInstance(algoName);
	}

	public MessageDigest getObject() throws Exception {
		// TODO Auto-generated method stub
		return messageDigest;
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return MessageDigest.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void setAlgoName(String algoName) {
		this.algoName = algoName;
	}

}
