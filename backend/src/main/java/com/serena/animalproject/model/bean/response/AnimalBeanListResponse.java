package com.serena.animalproject.model.bean.response;

import java.util.List;

import com.serena.animalproject.model.bean.AnimalBean;

public class AnimalBeanListResponse {

    private List<AnimalBean> content;

    public AnimalBeanListResponse() {

    }

    /**
     * @return the content
     */
    public List<AnimalBean> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(List<AnimalBean> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        for (AnimalBean animalBean : content) {
            builder.append("[ content=").append(animalBean).append("]");
        }
        return builder.toString();
    }
}