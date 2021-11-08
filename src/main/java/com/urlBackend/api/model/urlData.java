package com.urlBackend.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="urlData")
public class urlData {

	@Id
	private String id;
	private String longurl;
	private String shorturl;
	int count;
	
	public urlData() {
		
	}
	public urlData(String longurl, String shorturl, int count) {
		super();
		this.longurl = longurl;
		this.shorturl = shorturl;
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLongurl() {
		return longurl;
	}
	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}
	public String getShorturl() {
		return shorturl;
	}
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "urlData [id=" + id + ", longurl=" + longurl + ", shorturl=" + shorturl + ", count=" + count + "]";
	}
}
