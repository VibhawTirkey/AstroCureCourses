package com.astrocure.astrocurecourses.model;

public class LiveCourseModel {
    String courseName;
    int courseImg;
    String duration;
    String lessonCount;

    public LiveCourseModel(String courseName, int courseImg, String duration, String lessonCount) {
        this.courseName = courseName;
        this.courseImg = courseImg;
        this.duration = duration;
        this.lessonCount = lessonCount;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(int courseImg) {
        this.courseImg = courseImg;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(String lessonCount) {
        this.lessonCount = lessonCount;
    }
}
