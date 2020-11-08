package com.positivity.wellness.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserMoodController {
    @Autowired
    private UserMoodRepository repository;

    @RequestMapping(path = "/demo/user/mood", method = RequestMethod.POST)
    @ResponseBody
    public String saveUserMood(@RequestBody UserMood userMood) {
        System.out.println(userMood);
        repository.save(userMood);
        return "Got the user mood for " + userMood.getUserId();
    }

    @RequestMapping(path = "/demo/user/mood", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserMood> getUserMood(@RequestParam(name = "user") String userId) {
        return repository.findAllByUserId(userId);
    }

    @RequestMapping(path = "/demo/user/mood/for/range", method = RequestMethod.GET)
    @ResponseBody
    public List<UserMood> getUserMoodsForRange(
            @RequestParam(name = "user") String userId,
            @RequestParam(name = "from")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @RequestParam(name = "to")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {

        from.setHours(0);
        from.setMinutes(0);
        from.setSeconds(1);

        to.setHours(23);
        to.setMinutes(59);
        to.setSeconds(59);


        List<UserMood> userMoods = repository.findAllByUserId(userId);

        return userMoods.stream().filter(userMood -> {
            Date when = userMood.getWhen();
            return when.after(from) && when.before(to);
        }).collect(Collectors.toList());
    }
}
