package com.ensah.etl.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupByQuery {
	
	private List<String> groupByClos = new ArrayList<String>();
	private List<Aggregation> aggregations = new ArrayList<Aggregation>();
	
	public GroupByQuery() {
	}

	public GroupByQuery(@JsonProperty("groupByClos")List<String> groupByClos, @JsonProperty("aggregations")List<Aggregation> aggregations) {
		this.groupByClos = groupByClos;
		this.aggregations = aggregations;
	}
	
	public List<String> getGroupByClos() {
		return groupByClos;
	}
	public void setGroupByClos(List<String> groupByClos) {
		this.groupByClos = groupByClos;
	}
	public List<Aggregation> getAggregations() {
		return aggregations;
	}
	public void setAggregations(List<Aggregation> aggregations) {
		this.aggregations = aggregations;
	}
	
	
	
}
