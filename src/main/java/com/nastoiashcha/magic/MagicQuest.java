package com.nastoiashcha.magic;

import com.nastoiashcha.database.User;
import com.nastoiashcha.database.service.DBService;
import com.nastoiashcha.database.service.DBServiceImpl;
import com.nastoiashcha.magic.entity.*;
import com.nastoiashcha.magic.service.FacultyService;
import com.nastoiashcha.magic.service.impl.FacultyServiceImpl;
import com.nastoiashcha.quest.Quest;
import com.nastoiashcha.quest.Question;
import com.nastoiashcha.service.QuestionListServiceImpl;
import com.nastoiashcha.service.QuestionService;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class MagicQuest implements Quest {

    private final QuestionService questionService = new QuestionListServiceImpl();

    private final FacultyService facultyService = new FacultyServiceImpl();

    private static User user;
    private final DBService dbService = new DBServiceImpl();

    private final String HAT_QUESTION = "This is a HAT, that chooses your future path in life. " +
            "Be careful in your chose";

    private final String COLOR_QUESTION = "Which color is basic for this faculty?";
    private final String ANIMAL_QUESTION = "Which animal is on gerb this faculty?";
    private final String PLACE_QUESTION = "Where live students this faculty?";
    private final String SCHOOL_QUESTION = "How name of this school?";

    private final String FINAL_ANSWER = School.HOGWARTS.name();

    @Override
    public Question createNextQuestion(int questionId,
                                       String answer,
                                       HttpSession session) {
        user = dbService.getUserById((Integer) session.getAttribute("user"));
        if (questionId == 0) {
            return createFirst();
        }
        return questionService.getQuestById(questionId + 1);
    }

    private Question createFirst() {
        Question question;
        List<String> list = new ArrayList<>();
        for (Houses house : Houses.values()) {
            list.add(house.name());
        }
        question = new Question(1, HAT_QUESTION, list, "", 2);
        questionService.addQuestion(question);
        return question;
    }

    @Override
    public boolean isWin(String answer) {
        if (answer.equals(FINAL_ANSWER)) {
            dbService.getUserById(user.getId()).setInfo(user.getInfo());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAnswer(int questionId, String answer) {
        if (questionId == 1) {
            user.setInfo(answer);
            createQuest(questionId + 1, answer);
            return true;
        }
        return questionService.getQuestById(questionId).getAnswer().equals(answer);
    }

    @Override
    public void addCustomSettings(String info, HttpSession session) {
        Faculty faculty = facultyService.getByName(Houses.valueOf(info));
        session.setAttribute("color", faculty.getColor().name().toLowerCase());
        session.setAttribute("text", faculty.getTextColor().name().toLowerCase());
        session.setAttribute("animal", faculty.getAnimal().name().toLowerCase());
    }

    private void createQuest(int id, String answer) {
        Question question;

        Faculty faculty = facultyService.getByName(Houses.valueOf(answer));
        question = getColorQuestion(id, faculty.getColor().name());
        question = getPlaceQuestion(question.getNextId(), faculty.getPlace().name());
        question = getAnimalQuestion(question.getNextId(), faculty.getAnimal().name());
        getFinalQuestion(question.getNextId());
    }

    private void getFinalQuestion(int id) {
        List<String> schools = new ArrayList<>();
        for (School school : School.values()) {
            schools.add(school.name());
        }
        Question question = new Question(id, SCHOOL_QUESTION, schools, FINAL_ANSWER, 0);
        questionService.addQuestion(question);
    }

    private Question getAnimalQuestion(int id, String answer) {
        List<String> animals = new ArrayList<>();
        for (Animal animal : Animal.values()) {
            animals.add(animal.name());
        }
        Question question = new Question(id, ANIMAL_QUESTION, animals, answer, id + 1);
        questionService.addQuestion(question);
        return question;
    }

    private Question getPlaceQuestion(int id, String answer) {
        List<String> places = new ArrayList<>();
        for (Place place : Place.values()) {
            places.add(place.name());
        }
        Question question = new Question(id, PLACE_QUESTION, places, answer, id + 1);
        questionService.addQuestion(question);
        return question;
    }

    private Question getColorQuestion(int id, String answer) {
        List<String> colors = new ArrayList<>();
        for (Color color : Color.values()) {
            colors.add(color.name());
        }
        Question question = new Question(id, COLOR_QUESTION, colors, answer, id + 1);
        questionService.addQuestion(question);
        return question;
    }
}
