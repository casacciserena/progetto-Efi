package com.serena.animalproject.model.bean.response;

import java.util.Collection;

import com.serena.animalproject.model.bean.OwnerBean;

public class OwnerBeanCollectionResponse {

    private Collection<OwnerBean> content;

    public OwnerBeanCollectionResponse() {

    }

    /**
     * @return the content
     */
    public Collection<OwnerBean> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Collection<OwnerBean> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        for (OwnerBean ownerBean : content) {
            builder.append("[ content=").append(ownerBean).append("]");
        }
        return builder.toString();
    }
}
