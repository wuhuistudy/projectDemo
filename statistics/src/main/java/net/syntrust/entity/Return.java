package net.syntrust.entity;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 
 * @Description: 统一返回类型
 * @author reece
 * @date 2017年10月13日 下午5:11:17
 */
public class Return implements Serializable {

	private static final long serialVersionUID = -5158708077742187883L;
	/* 状态码 */
	private String code;
	/* 数据 */
	private Object data;
	/* 数据量 */
	private Integer count;

	public Return() {}

	public Return(String code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public Return(String code, Object data, Integer count) {
		super();
		this.code = code;
		this.data = data;
		this.count = count;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String toJson(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@Override
	public String toString() {
		return "Return [code=" + code + ", data=" + data + ", count=" + count + "]";
	}
	
}
