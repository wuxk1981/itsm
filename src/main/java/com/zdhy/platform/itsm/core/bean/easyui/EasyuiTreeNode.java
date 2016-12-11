package com.zdhy.platform.itsm.core.bean.easyui;

public class EasyuiTreeNode
{
	/**
	 * ID
	 */
	private Long	id;
	/**
	 * 显示文本
	 */
	private String	text;
	/**
	 * 状态。"closed"有子节点，"open"无子节点
	 */
	private String	state;

	/**
	 * 构造函数
	 * @param id
	 * @param text
	 * @param state
	 */
	public EasyuiTreeNode(long id, String text, String state)
	{
		this.id = id;
		this.text = text;
		this.state = state;
	} // Function EasyuiTreeNode()

	/**
	 * 获得ID
	 * 
	 * @return 返回ID
	 */
	public Long getId()
	{
		return id;
	} // Function getId()

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Long id)
	{
		this.id = id;
	} // Function setId()

	/**
	 * 获得显示文本
	 * 
	 * @return 返回显示文本
	 */
	public String getText()
	{
		return text;
	} // Function getText()

	/**
	 * 设置显示文本
	 * 
	 * @param text
	 *            显示文本
	 */
	public void setText(String text)
	{
		this.text = text;
	} // Function setText()

	/**
	 * 获得状态."closed"有子节点，"open"无子节点.
	 * @return 返回状态。
	 */
	public String getState()
	{
		return state;
	} // Function getState()

	/**
	 * 设置状态
	 * 
	 * @param state
	 *            状态
	 */
	public void setState(String state)
	{
		this.state = state;
	} // Function setState()

} // Class EasyuiTreeNode
