package com.zdhy.platform.itsm.core.bean.easyui;

/**
 * 向客户端发送的消息
 * 
 * @author Andy
 * 
 */
public class ResponseMessage
{
	/**
	 * 返回码
	 */
	private int		code;
	/**
	 * 是否为错误信号
	 */
	private boolean	isError;
	/**
	 * 是否为成功信号
	 */
	private boolean	success;
	/**
	 * 错误信息
	 */
	private String	msg;
	/**
	 * Object对象
	 */
	private Object entity;

	/**
	 * 构造函数
	 * 
	 * @author Andy
	 * @param code
	 *            错误码
	 * @param msg
	 *            错误信息
	 */
	public ResponseMessage(int code, String msg)
	{
		this.msg = msg;
		setCode(code);
		return;
	} // Function EasyuiMessage()

	/**
	 * 取得错误码
	 * 
	 * @author Andy
	 * @return 错误码
	 */
	public int getCode()
	{
		return this.code;
	} // Function getCode()

	/**
	 * 设置错误码
	 * 
	 * @author Andy
	 * @param code
	 *            错误码
	 */
	public void setCode(int code)
	{
		this.code = code;
		this.success = (0 == code);
		this.isError = !this.success;
	} // Function setCode()

	/**
	 * 信息是否是一个错误信息
	 * 
	 * @author Andy
	 * @return 如果是错误信息，则返回true。否则返回false。
	 */
	public boolean getIsError()
	{
		return this.isError;
	} // Function getIsError()

	/**
	 * 设置信息是否为一个错误的信息
	 * 
	 * @author Andy
	 * @param isError
	 *            是否为错误信息
	 */
	public void setIsError(boolean isError)
	{
		this.isError = isError;
		this.success = !isError;
	} // Function setIsError()

	/**
	 * 是否为成功信息
	 * 
	 * @author Andy
	 * @return 如果成功返回true。否则返回false。
	 */
	public boolean getSuccess()
	{
		return this.success;
	} // Function getSuccess()

	/**
	 * 设置是否为成功信息
	 * 
	 * @author Andy
	 * @param success
	 *            是否成功
	 */
	public void setSuccess(boolean success)
	{
		this.success = success;
	} // Function setSuccess()

	/**
	 * 返回信息
	 * 
	 * @author Andy
	 * @return 返回给前端的提示信息
	 */
	public String getMsg()
	{
		return msg;
	} // Function getMsg()

	/**
	 * 设置信息
	 * 
	 * @author Andy
	 * @param msg
	 *            信息
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	} // Function setMsg()
	
	/**
	 * 返回实体
	 * 
	 * @author Andy
	 * @return 返回给前端的实体
	 */
	public Object getEntity()
	{
		return this.entity;
	} // Function getEntity()

	/**
	 * 设置实体
	 * 
	 * @author Andy
	 * @param entity
	 *            实体
	 */
	public void setEntity(Object entity)
	{
		this.entity = entity;
	} // Function setEntity()

} // class EasyuiMessage
