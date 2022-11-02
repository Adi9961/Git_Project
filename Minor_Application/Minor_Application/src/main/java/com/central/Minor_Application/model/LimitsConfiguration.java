package com.central.Minor_Application.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitsConfiguration {
	
	private int maximum;
	private int minimum;
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public LimitsConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	@Override
	public String toString() {
		return "LimitsConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
	}
	
	private LimitsConfiguration() {
		super();
		
	}

}
