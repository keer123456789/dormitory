package com.keer.dormitory.dto;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
    private List<Location> student;
    private List<Location> room;
    private List<Location> object;

    public List<Location> getStudent() {
        return student;
    }

    public void setStudent(List<Location> student) {
        this.student = student;
    }

    public List<Location> getRoom() {
        return room;
    }

    public void setRoom(List<Location> room) {
        this.room = room;
    }

    public List<Location> getObject() {
        return object;
    }

    public void setObject(List<Location> object) {
        this.object = object;
    }

    public void addStudentLocation(Location location) {
        if (this.student == null) {
            this.student = new ArrayList<>();
        }
        this.student.add(location);
    }

    public void addRoomLocation(Location location) {
        if (this.room == null) {
            this.room = new ArrayList<>();
        }
        this.room.add(location);
    }

    public void addObjectLocation(Location location) {
        if (this.object == null) {
            this.object = new ArrayList<>();
        }
        this.object.add(location);
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "student=" + student +
                ", room=" + room +
                ", object=" + object +
                '}';
    }
}
