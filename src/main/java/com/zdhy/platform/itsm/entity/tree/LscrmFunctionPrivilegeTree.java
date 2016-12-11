package com.zdhy.platform.itsm.entity.tree;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 功能: 
 * LscrmFunctionPrivilegeTree.java
 * 创建人： 吴心宽
 * 时间： 2016年11月21日-下午3:48:02
 * @version v1.0.0
 */
public class LscrmFunctionPrivilegeTree {
	 /**编号**/
    private int id;

    private String createId;

    private String updateId;

    /**创建时间**/
    private Date createTime;

    /**修改时间**/
    private Date updateTime=new Date();

    /**有效性 1.有效 0. 无效**/
    private int validity=1;

    /**编码**/
    private String code;

    /**名称**/
    private String functionName;

    /**父节点**/
    private int parentId;

    /**是否叶子节点(叶子结点 就是度为0的结点 就是没有子结点的结点),在添加子节点时,需要将parent_id is_leaf_node 设置成0**/
    private int isLeafNode;

    /**所属子系统**/
    private int subSystemId;

    /**UI是否隐藏,ui上不展示**/
    private int isHidden=1;

    private List<LscrmFunctionPrivilegeEntity> privilegeList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(int isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public int getSubSystemId() {
		return subSystemId;
	}

	public void setSubSystemId(int subSystemId) {
		this.subSystemId = subSystemId;
	}

	public int getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(int isHidden) {
		this.isHidden = isHidden;
	}

	public List<LscrmFunctionPrivilegeEntity> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<LscrmFunctionPrivilegeEntity> privilegeList) {
		this.privilegeList = privilegeList;
	}
	
}
