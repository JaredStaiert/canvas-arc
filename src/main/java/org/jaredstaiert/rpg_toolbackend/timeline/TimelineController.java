package org.jaredstaiert.rpg_toolbackend.timeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timelines")
public class TimelineController {

    private final TimelineService timelineService;

    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @GetMapping("/all-timelines")
    public List<Timeline> getAllTimelines() {
        return timelineService.getAllTimelines();
    }
}
