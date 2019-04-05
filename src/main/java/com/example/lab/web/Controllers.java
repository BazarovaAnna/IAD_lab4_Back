package com.example.lab.web;

import com.example.lab.database.DBConfig;
import com.example.lab.database.ResultsRepository;
import com.example.lab.entities.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

@RestController
public class Controllers {
    @Autowired
    ResultsRepository resultsRepository;
    private Logger log = LoggerFactory.getLogger(DBConfig.class);

    @RequestMapping("/get_hits")
    LinkedList<ResultEntity> hits(HttpSession session) {
        LinkedList<ResultEntity> result = new LinkedList<>();
        resultsRepository.findAllBySessionid(session.getId())
                .forEach(it -> result.add(it));
        return result;
    }

    @RequestMapping("/hit")
    public Boolean hit(@RequestParam double x, @RequestParam double y, @RequestParam double r, HttpSession session) {
        System.out.println("x:" + x);
        ResultEntity resultEntity = new ResultEntity(session.getId(), new Point(x, y), r);
        if (x >= 0 && y >= 0) {
            if (x <= r / 2 && y <= r) {
                resultEntity.setMatch(true);
            }
        }
        if (x <= 0 && y >= 0) {
            if (y <= x + r) {
                resultEntity.setMatch(true);
            }
        }
        if (x >= 0 && y <= 0) {
            if (x * x + y * y <= r / 2 * r / 2) {
                resultEntity.setMatch(true);
            }
        }

        resultsRepository.save(resultEntity);
        return resultEntity.isMatch();
    }
}