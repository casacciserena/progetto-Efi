package com.serena.animalproject.model.bean.response;

import com.serena.animalproject.model.bean.AnimalBean;

public class AnimalBeanResponse {

	private AnimalBean content;

	public AnimalBeanResponse() {

	}

	/**
	 *
	 * @return the content
	 */
	public AnimalBean getContent() {
		return content;
	}

	/**
	 *
	 * @param content the content to set
	 */
	public void setContent(AnimalBean content) {
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