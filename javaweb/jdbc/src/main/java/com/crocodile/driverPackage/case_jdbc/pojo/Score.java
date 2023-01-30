package com.crocodile.driverPackage.case_jdbc.pojo;
/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description:实体类
 *               基本数据类型推荐使用其包装类型
 * @Author：crocodilePole
 */
public class Score {
    public int id ;
    public int courseId;
    public int score;

    public Score(int id, int courseId, int score) {
        this.id = id;
        this.courseId = courseId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", score=" + score +
                '}';
    }
}
