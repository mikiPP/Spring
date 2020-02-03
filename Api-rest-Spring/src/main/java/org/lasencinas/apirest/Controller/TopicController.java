package org.lasencinas.apirest.Controller;


import org.lasencinas.apirest.Model.Topic;
import org.lasencinas.apirest.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
public class TopicController {

    @Autowired
    private TopicService topicService;


    @GetMapping(path = "/topics")
    public List<Topic> getAllTopics(){
        return  topicService.findAll();
    }


    @GetMapping(path = "/topics/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.findById(id);
    }


    @PostMapping(path = "/topics")
    public String addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return "Topic added";
    }


    @PutMapping(path = "/topics/{id}")
    public String  editTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.editTopic(topic,id);
        return "Topic edited with id:" + id +" edited";
    }


    @DeleteMapping(path = "/topics/{id}")
    public String deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
        return "Topic has been deleted";
    }

}
