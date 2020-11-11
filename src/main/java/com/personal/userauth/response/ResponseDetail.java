package com.personal.userauth.response;

import org.springframework.http.HttpStatus;

public class ResponseDetail
{
	public ResponseDetail(HttpStatus code, String detail)
	{
		this.code = code;
		this.detail = detail;
	}
	
	public HttpStatus getCode()
	{
		return code;
	}
	public void setCode(HttpStatus code)
	{
		this.code = code;
	}
	public String getDetail()
	{
		return detail;
	}
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	private HttpStatus code;
	private String detail;
}
