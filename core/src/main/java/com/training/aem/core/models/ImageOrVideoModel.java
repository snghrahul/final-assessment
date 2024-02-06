package com.training.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = {Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageOrVideoModel {

    @ValueMapValue
    String video;

    public String getImage() {
        return image;
    }

    @ValueMapValue
    private String image;

    @PostConstruct
    protected void init(){

    }
}
