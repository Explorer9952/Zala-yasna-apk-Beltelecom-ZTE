package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AnswerBean implements Serializable {
    private ArrayList<OptionBean> optionList;
    private String questionid;
    private String questionname;
    private String questionpicture;
    private String questionscore;
    private String questiontype;
    private String required;

    public static AnswerBean getAnswerBeanFromJSon(JSONObject jSONObject) {
        AnswerBean answerBean = new AnswerBean();
        try {
            answerBean.setQuestionid(jSONObject.optString("questionid"));
            answerBean.setQuestionpicture(jSONObject.optString("questionpicture"));
            answerBean.setQuestionname(jSONObject.optString("questionname"));
            answerBean.setQuestiontype(jSONObject.optString("questiontype"));
            answerBean.setQuestionscore(jSONObject.optString("questionscore"));
            answerBean.setRequired(jSONObject.optString("required"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answerBean;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(AnswerBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(AnswerBean.class.getName(), "writeObject");
    }

    public ArrayList<OptionBean> getOptionList() {
        return this.optionList;
    }

    public String getQuestionid() {
        return this.questionid;
    }

    public String getQuestionname() {
        return this.questionname;
    }

    public String getQuestionpicture() {
        return this.questionpicture;
    }

    public String getQuestionscore() {
        return this.questionscore;
    }

    public String getQuestiontype() {
        return this.questiontype;
    }

    public String getRequired() {
        return this.required;
    }

    public void setOptionList(ArrayList<OptionBean> arrayList) {
        this.optionList = arrayList;
    }

    public void setQuestionid(String str) {
        this.questionid = str;
    }

    public void setQuestionname(String str) {
        this.questionname = str;
    }

    public void setQuestionpicture(String str) {
        this.questionpicture = str;
    }

    public void setQuestionscore(String str) {
        this.questionscore = str;
    }

    public void setQuestiontype(String str) {
        this.questiontype = str;
    }

    public void setRequired(String str) {
        this.required = str;
    }
}
