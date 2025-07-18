package org.jaredstaiert.rpg_toolbackend.timeline;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineService {

    private final TimelineRepository timelineRepository;

    public TimelineService(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    public List<Timeline> getAllTimelines() {
        return timelineRepository.findAll();
    }

    public List<String> getDistinctTimelines() {
        return timelineRepository.findDistinctTimelineNames();
    }
}
