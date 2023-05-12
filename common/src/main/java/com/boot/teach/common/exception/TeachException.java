package com.boot.teach.common.exception;

import com.boot.teach.common.response.ResponseEnum;

/**
 * @author hzx
 * @description : 异常处理
 * @date 2023/5/12
 */
public class TeachException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Object object;

	private ResponseEnum responseEnum;

	public TeachException(String msg) {
		super(msg);
	}

	public TeachException(String msg, Object object) {
		super(msg);
		this.object = object;
	}

	public TeachException(String msg, Throwable cause) {
		super(msg, cause);
	}


	public TeachException(ResponseEnum responseEnum) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
	}

	public TeachException(ResponseEnum responseEnum, Object object) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
		this.object = object;
	}


	public Object getObject() {
		return object;
	}

	public ResponseEnum getResponseEnum() {
		return responseEnum;
	}

}
