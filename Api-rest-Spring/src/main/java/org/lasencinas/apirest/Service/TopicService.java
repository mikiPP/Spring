package org.lasencinas.apirest.Service;

import org.lasencinas.apirest.Model.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {


    private List<Topic> bbdd = new ArrayList<>();


   @PostConstruct
    public void init(){
            bbdd.add(new Topic("spring", "Spring Framework" , "Spring Framework Description"));
            bbdd.add(new Topic("java", "Core Java" , "Core Java Description"));
            bbdd.add(new Topic("javascript", "JavaScript" , "JavaScript Description"));
   }


    public List<Topic> getBbdd(){
        return this.bbdd;
    }



    public void setBbdd(List<Topic> bbdd) {
        this.bbdd = bbdd;
    }


    public List<Topic> findAll(){
       return this.getBbdd();
    }


    public Topic findById(String id){
      return getBbdd().stream()
                .filter(topic -> topic.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic){
       getBbdd().add(topic);
    }

    public void editTopic(Topic topic,String id){

       setBbdd(getBbdd().stream()
               .filter(element -> !element.getId().equals(id))
                .collect(Collectors.toList()));

       getBbdd().add(topic);
    }


    public void deleteTopic(String id){

        setBbdd(getBbdd().stream().filter(topic -> !topic.getId().equals(id)).collect(Collectors.toList()));
    }


}
