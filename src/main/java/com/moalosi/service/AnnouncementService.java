package com.moalosi.service;

import com.moalosi.model.Announcement;
import com.moalosi.dao.DaoImplementation;

import java.util.List;

public class AnnouncementService {
    private final DaoImplementation dao;

    public AnnouncementService() {
        dao = new DaoImplementation();
    }

    public List<Announcement> getAnnouncementsList() {
        return dao.findAllAnnouncement();
    }

    public void deleteAnnouncement(int announcementId){
        dao.deleteAnnouncement(announcementId);
    }

    public void addAnnouncement(Announcement announcement){
        dao.addAnnouncement(announcement);
    }
}
