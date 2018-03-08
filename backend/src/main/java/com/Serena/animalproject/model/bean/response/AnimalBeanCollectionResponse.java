package com.serena.animalproject.model.bean.response;

import java.util.Collection;

import com.serena.animalproject.model.bean.AnimalBean;

public class AnimalBeanCollectionResponse {

    private Collection<AnimalBean> content;

    public AnimalBeanCollectionResponse() {

    }

    /**
     * @return the content
     */
    public Collection<AnimalBean> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Collection<AnimalBean> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        for (AnimalBean animalBean : content) {
            builder.append("[content = ").append(animalBean).append("]");
        }
        return builder.toString();
    }
}
