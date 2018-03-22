package com.serena.animalproject.model.bean.response;

import com.serena.animalproject.model.bean.OwnerBean;

public class OwnerBeanResponse {

	private OwnerBean content;

	public OwnerBeanResponse() {

	}

	/**
	 *
	 * @return the content
	 */
	public OwnerBean getContent() {
		return content;
	}

	/**
	 *
	 * @param content the content to set
	 */
	public void setContent(OwnerBean content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName())
			.append("[content = ").append(content).append("]");
		return builder.toString();
	}
}
