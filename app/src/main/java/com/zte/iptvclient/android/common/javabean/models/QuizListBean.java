package com.zte.iptvclient.android.common.javabean.models;

import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class QuizListBean implements Serializable {
    private String answerstate;
    private String answertime;
    private String questionnum;
    private String subjectcode;
    private String subjectdescription;
    private String subjectendtime;
    private String subjectname;
    private String subjectstarttime;
    private String subjectstate;
    private String subjecttimes;
    private String subjecttype;
    private String userSubjectScore;

    public static QuizListBean getQuizListBeanFromJSon(JSONObject jSONObject) {
        QuizListBean quizListBean = new QuizListBean();
        try {
            quizListBean.setSubjectstate(jSONObject.optString("subjectstate"));
            quizListBean.setSubjectname(jSONObject.optString("subjectname"));
            quizListBean.setSubjecttype(jSONObject.optString("subjecttype"));
            quizListBean.setSubjecttimes(jSONObject.optString("subjecttimes"));
            quizListBean.setUserSubjectScore(jSONObject.optString("usersubjectscore"));
            quizListBean.setQuestionnum(jSONObject.optString("questionnum"));
            quizListBean.setSubjectstarttime(jSONObject.optString("subjectstarttime"));
            quizListBean.setSubjectendtime(jSONObject.optString("subjectendtime"));
            quizListBean.setAnswertime(jSONObject.optString("answertime"));
            quizListBean.setSubjectdescription(jSONObject.optString("subjectdescription"));
            quizListBean.setAnswerstate(jSONObject.optString("answerstate"));
            quizListBean.setSubjectcode(jSONObject.optString("subjectcode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quizListBean;
    }

    public String getAnswerstate() {
        return this.answerstate;
    }

    public String getAnswertime() {
        return this.answertime;
    }

    public String getQuestionnum() {
        return this.questionnum;
    }

    public String getSubjectcode() {
        return this.subjectcode;
    }

    public String getSubjectdescription() {
        return this.subjectdescription;
    }

    public String getSubjectendtime() {
        return this.subjectendtime;
    }

    public String getSubjectname() {
        return this.subjectname;
    }

    public String getSubjectstarttime() {
        return this.subjectstarttime;
    }

    public String getSubjectstate() {
        return this.subjectstate;
    }

    public String getSubjecttimes() {
        return this.subjecttimes;
    }

    public String getSubjecttype() {
        return this.subjecttype;
    }

    public String getUserSubjectScore() {
        return this.userSubjectScore;
    }

    public void setAnswerstate(String str) {
        this.answerstate = str;
    }

    public void setAnswertime(String str) {
        this.answertime = str;
    }

    public void setQuestionnum(String str) {
        this.questionnum = str;
    }

    public void setSubjectcode(String str) {
        this.subjectcode = str;
    }

    public void setSubjectdescription(String str) {
        this.subjectdescription = str;
    }

    public void setSubjectendtime(String str) {
        this.subjectendtime = str;
    }

    public void setSubjectname(String str) {
        this.subjectname = str;
    }

    public void setSubjectstarttime(String str) {
        this.subjectstarttime = str;
    }

    public void setSubjectstate(String str) {
        this.subjectstate = str;
    }

    public void setSubjecttimes(String str) {
        this.subjecttimes = str;
    }

    public void setSubjecttype(String str) {
        this.subjecttype = str;
    }

    public void setUserSubjectScore(String str) {
        this.userSubjectScore = str;
    }
}
