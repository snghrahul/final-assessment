package com.training.aem.core.models;


//import com.training.aem.core.services.FaqService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FaqModel {

    @ChildResource
    private Resource faqs;
    @ValueMapValue
    private String question;

    @ValueMapValue
    private String answer;

    List<FaqEntity> faqsList = new ArrayList<>();

    public List<FaqEntity> getFaqsList() {
        if(faqs != null && faqs.hasChildren()){
            for(Resource resource : faqs.getChildren()){
                ValueMap map = resource.getValueMap();
                FaqEntity faq = new FaqEntity();
                faq.setQuestion(map.get("question",String.class));
                faq.setAnswer(map.get("answer",String.class));
                faqsList.add(faq);
            }
        }
        return faqsList;
    }


    //    public void addFaq(String question , String answer){
//        faqService.addFaq(question,answer);
//    }
}