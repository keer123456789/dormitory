package com.keer.dormitory.dto;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
    private List<Location> student;
    private List<Location> room;

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

    public void addStudentLocation(Location location){
        if(this.student==null){
            this.student=new ArrayList<>();
        }
        this.student.add(location);
    }

    public void addRoomLocation(Location location){
        if(this.room==null){
            this.room=new ArrayList<>();
        }
        this.room.add(location);
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "student=" + student +
                ", room=" + room +
                '}';
    }
}
