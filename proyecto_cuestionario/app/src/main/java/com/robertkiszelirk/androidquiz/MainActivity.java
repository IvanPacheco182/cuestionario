package com.robertkiszelirk.androidquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CardView appTheme;
    CardView playerScore;
    CardView quizEnd;

    LinearLayout appThemeLL;
    LinearLayout playerScoreLL;
    LinearLayout quizEndLL;

    ArrayList<LinearLayout> quizLayouts;

    Button submitNextButton;

    int actualView;

    Animation animOut;
    Animation animIn;

    int score = 0;
    int addScore = 1;
    String playerName;
    EditText playerNameEditText;
    TextView playerNameText;
    TextView scoreText;
    TextView quizLevel;
    TextView quizRule;

    Random randomNumber;

    ArrayList<String> editNumberQuizData;
    ArrayList<EditTextQuiz> editTextNumberQuiz;
    EditText editTextNumberAnswer;
    int editTextNumberRandom = 0;

    TextView editTextNumberQuestion;

    ArrayList<String> editTextQuizData;
    ArrayList<EditTextQuiz> editTextTextQuiz;
    EditText editTextTextAnswer;
    int editTextTextRandom = 0;

    ArrayList<String> checkBoxQuizData;
    ArrayList<CheckRadioQuiz> checkQuiz;
    ArrayList<CheckBox> checkBoxes;
    int checkBoxRandom = 0 ;

    ArrayList<String> radioQuizData;
    ArrayList<CheckRadioQuiz> radioQuiz;
    ArrayList<RadioButton> radioButtons;
    int radioButtonRandom = 0;

    boolean orientationChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CHECK ANDROID VERSION
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            appTheme = (CardView) findViewById(R.id.appTheme);
            playerScore = (CardView) findViewById(R.id.playerScore);
            quizEnd = (CardView) findViewById(R.id.quiz_end);
        } else{
            appThemeLL = (LinearLayout) findViewById(R.id.appTheme);
            playerScoreLL = (LinearLayout) findViewById(R.id.playerScore);
            quizEndLL = (LinearLayout) findViewById(R.id.quiz_end);
        }
        //SET CARD TEXTVIEWS
        playerNameText = (TextView) findViewById(R.id.player_name_card_view);
        scoreText = (TextView) findViewById(R.id.score);
        quizLevel = (TextView) findViewById(R.id.quiz_level);
        quizRule = (TextView) findViewById(R.id.quiz_rule);
        //CREATE LAYOUTS
        quizLayouts = new ArrayList<>();
        quizLayouts.add((LinearLayout) findViewById(R.id.start_layout));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_text_number));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_text_text));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_checkbox));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_radio_button));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_end_layout));
        //SET EDIT TEXTS
        editTextNumberQuestion = (TextView) findViewById(R.id.edit_text_number_question);
        editTextNumberAnswer = (EditText) findViewById(R.id.edit_text_number_answer);
        //SET BUTTON
        submitNextButton = (Button) findViewById(R.id.submit_next_button);
        //SET BASE DATA
        actualView = 0;
        randomNumber = new Random();
        //Llammar animaciones
        animOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        //Llamamos las preguntas que definimos en String.xml
        editTextNumberQuiz = new ArrayList<>();
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_one),getString(R.string.edit_text_number_answer_one)));
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_two),getString(R.string.edit_text_number_answer_two)));
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_three),getString(R.string.edit_text_number_answer_three)));
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_four),getString(R.string.edit_text_number_answer_four)));
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_five),getString(R.string.edit_text_number_answer_five)));
        editTextNumberQuiz.add(new EditTextQuiz(getString(R.string.edit_text_number_question_six),getString(R.string.edit_text_number_answer_six)));

        editTextTextQuiz = new ArrayList<>();
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_one)));
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_two)));
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_three)));
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_four)));
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_five)));
        editTextTextQuiz.add(new EditTextQuiz(getString(R.string.edit_text_text_question),getString(R.string.edit_text_text_answer_six)));

        checkQuiz = new ArrayList<>();
        checkQuiz.add(new CheckRadioQuiz(getString(R.string.check_box_question_one),
                getString(R.string.check_box_answer_three_one),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_one_two),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_one_four),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_one_five),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_two_one),getString(R.string.check_box_false)));
        checkQuiz.add(new CheckRadioQuiz(getString(R.string.check_box_question_two),
                getString(R.string.check_box_answer_three_zero),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_two_six),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_three_one),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_three_two),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_two_one),getString(R.string.check_box_false)));
        checkQuiz.add(new CheckRadioQuiz(getString(R.string.check_box_question_three),
                getString(R.string.check_box_answer_four_four),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_four_five),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_four_zero),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_three_two),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_four_three),getString(R.string.check_box_false)));
        checkQuiz.add(new CheckRadioQuiz(getString(R.string.check_box_question_four),
                getString(R.string.check_box_answer_four_three),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_five_zero),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_four_two),getString(R.string.check_box_true),
                getString(R.string.check_box_answer_four_zero),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_four_one),getString(R.string.check_box_true)));
        checkQuiz.add(new CheckRadioQuiz(getString(R.string.check_box_question_five),
                getString(R.string.check_box_answer_two_two),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_one_eight),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_three_one),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_two_zero),getString(R.string.check_box_false),
                getString(R.string.check_box_answer_two_three),getString(R.string.check_box_true)));
        //Set Radio Button Quiz Questions
        radioQuiz = new ArrayList<>();
        radioQuiz.add(new CheckRadioQuiz(getString(R.string.radio_button_question_one),
                getString(R.string.radio_button_answer_one_one),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_one_two),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_one_three),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_one_four),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_one_five),getString(R.string.radio_button_true)));
        radioQuiz.add(new CheckRadioQuiz(getString(R.string.radio_button_question_two),
                getString(R.string.radio_button_answer_two_one),getString(R.string.radio_button_true),
                getString(R.string.radio_button_answer_two_two),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_two_three),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_two_four),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_two_five),getString(R.string.radio_button_false)));
        radioQuiz.add(new CheckRadioQuiz(getString(R.string.radio_button_question_three),
                getString(R.string.radio_button_answer_three_one),getString(R.string.radio_button_true),
                getString(R.string.radio_button_answer_three_two),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_three_three),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_three_four),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_three_five),getString(R.string.radio_button_false)));
        radioQuiz.add(new CheckRadioQuiz(getString(R.string.radio_button_question_four),
                getString(R.string.radio_button_answer_four_one),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_four_two),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_four_three),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_four_four),getString(R.string.radio_button_true),
                getString(R.string.radio_button_answer_four_five),getString(R.string.radio_button_false)));
        radioQuiz.add(new CheckRadioQuiz(getString(R.string.radio_button_question_five),
                getString(R.string.radio_button_answer_five_one),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_five_two),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_five_three),getString(R.string.radio_button_true),
                getString(R.string.radio_button_answer_five_four),getString(R.string.radio_button_false),
                getString(R.string.radio_button_answer_five_five),getString(R.string.radio_button_false)));

        if(savedInstanceState != null){
            orientationChanged = true;
            playerName = savedInstanceState.getString(getString(R.string.player_name_istate));
            playerNameText.setText(savedInstanceState.getString(getString(R.string.player_name_istate)));
            scoreText.setText(getString(R.string.score_value) + savedInstanceState.getInt(getString(R.string.score_istate)));
            score = savedInstanceState.getInt(getString(R.string.score_istate));
            quizLevel.setText(savedInstanceState.getString(getString(R.string.quiz_level_istate)));
            quizRule.setText(savedInstanceState.getString(getString(R.string.quiz_rule_istate)));
            submitNextButton.setText(savedInstanceState.getString(getString(R.string.submit_next_button_istate)));
            editTextNumberQuestion.setText(savedInstanceState.getString(getString(R.string.quiz_one_question_istate)));
            editTextNumberAnswer.setText(savedInstanceState.getString(getString(R.string.quiz_one_answer_istate)));
            setRotateView(savedInstanceState.getInt(getString(R.string.actual_view_istate)));
            actualView = savedInstanceState.getInt(getString(R.string.actual_view_istate));
            editTextNumberRandom = savedInstanceState.getInt(getString(R.string.edit_text_number_random_istate));
            editTextTextRandom = savedInstanceState.getInt(getString(R.string.edit_text_text_random_istate));
            checkBoxRandom = savedInstanceState.getInt(getString(R.string.check_box_random_istate));
            radioButtonRandom = savedInstanceState.getInt(getString(R.string.radio_button_random_istate));
            for (int i = 1; i <6; i++){
                setQuiz(i);
            }
            orientationChanged = false;
        }
    }

    public void changeView(View view) {
        boolean wasIn = false;

        //Ver los cambios de inicio, siguiente pregunta y resumen de respuestas
        if ((submitNextButton.getText().equals(getString(R.string.next_quiz))) ||
                (submitNextButton.getText().equals(getString(R.string.start_quiz))) ||
                (submitNextButton.getText().equals(getString(R.string.summary)))) {
            if(submitNextButton.getText().equals(getString(R.string.start_quiz))){
                playerNameEditText = (EditText) findViewById(R.id.edit_player_name_text);
                playerName = playerNameEditText.getText().toString();
                playerNameEditText.setText("");
                if (playerName.equals("")){
                    playerNameText.setText(R.string.player_name);
                }else {
                    playerNameText.setText(playerName);
                }
            }
            if (actualView < (quizLayouts.size() - 1)) {
                if (actualView == 0) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                        playerScore.setVisibility(View.VISIBLE);
                        playerScore.startAnimation(animIn);
                        appTheme.setVisibility(View.GONE);
                        appTheme.startAnimation(animOut);
                    } else{
                        playerScoreLL.setVisibility(View.VISIBLE);
                        playerScoreLL.startAnimation(animIn);
                        appThemeLL.setVisibility(View.GONE);
                        appThemeLL.startAnimation(animOut);
                    }
                }
                if(actualView == 1){editTextNumberAnswer.setText("");}
                if(actualView == 2){editTextTextAnswer.setText("");}
                if(actualView == 3){
                    for(CheckBox checkBox : checkBoxes){
                        if(checkBox.isChecked()){checkBox.toggle();}
                    }
                }
                if(actualView == 4){
                    RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
                    radioGroup.clearCheck();
                }
                quizLayouts.get(actualView).setVisibility(View.GONE);
                quizLayouts.get(actualView).startAnimation(animOut);
                actualView++;
                quizLayouts.get(actualView).setVisibility(View.VISIBLE);
                quizLayouts.get(actualView).startAnimation(animIn);
                if(actualView != 5) {
                    submitNextButton.setText(R.string.submit_answer);
                    wasIn = true;
                    quizLevel.setText(getString(R.string.quiz_level) + actualView);
                    setQuiz(actualView);
                }else{
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                        playerScore.setVisibility(View.GONE);
                        playerScore.startAnimation(animOut);
                        quizEnd.setVisibility(View.VISIBLE);
                        quizEnd.startAnimation(animIn);
                    } else{
                        playerScoreLL.setVisibility(View.GONE);
                        playerScoreLL.startAnimation(animOut);
                        quizEndLL.setVisibility(View.VISIBLE);
                        quizEndLL.startAnimation(animIn);
                    }
                    setQuiz(actualView);
                    submitNextButton.setText(R.string.restart);
                    wasIn = true;
                }
            }
        }
        //Ver la respuesta antes de pasar a la siguiente pregunta
        if((submitNextButton.getText().equals(getString(R.string.submit_answer)))&&(actualView != 4)&&(!wasIn)){
            checkQuiz(actualView);
            submitNextButton.setText(R.string.next_quiz);
        }
        //Ver respuesta antes de finalizar
        if((submitNextButton.getText().equals(getString(R.string.submit_answer))) && (actualView == 4)&&(!wasIn)) {
            checkQuiz(actualView);
            submitNextButton.setText(R.string.summary);
            wasIn = true;
        }
        //Después del resumen de respuestas, el usuario puede enviar las respuestas por correo llamando a la clase "MainActivityMail"
        if((submitNextButton.getText().equals(getString(R.string.restart))) && (actualView == 5)&&(!wasIn)) {

            Intent ListSong = new Intent(getApplicationContext(), MainActivityMail.class);
            startActivity(ListSong);
        }
    }


    //Establecer preguntas sobre la vista actual haciendo uso de casos, se muestran las 4 preguntas aleatorias y el resumen
    public void setQuiz(int actualQuiz){
        switch (actualQuiz){
            case 1:
                addScore = 1;
                if(!orientationChanged) {
                    editTextNumberRandom = randomNumber.nextInt(editTextNumberQuiz.size());
                }
                editNumberQuizData = new ArrayList<>(editTextNumberQuiz.get(editTextNumberRandom).getEditTextQuizData());
                editTextNumberQuestion.setText(editNumberQuizData.get(0));
                break;
            case 2:
                addScore = 1;
                if(!orientationChanged) {
                    editTextTextRandom = randomNumber.nextInt(editTextTextQuiz.size()) ;
                }
                editTextQuizData = new ArrayList<>(editTextTextQuiz.get(editTextTextRandom).getEditTextQuizData());
                TextView editTextTextQuestion = (TextView) findViewById(R.id.edit_text_text_question);
                editTextTextQuestion.setText(editTextQuizData.get(0));
                ImageView imageView = (ImageView) findViewById(R.id.edit_text_text_image);
                switch(editTextTextRandom){

                    case 0:imageView.setBackgroundResource(R.drawable.conmutador);
                        break;
                    case 1:imageView.setBackgroundResource(R.drawable.firewall);
                        break;
                    case 2:imageView.setBackgroundResource(R.drawable.hub);
                        break;
                    case 3:imageView.setBackgroundResource(R.drawable.portatil);
                        break;
                    case 4:imageView.setBackgroundResource(R.drawable.router);
                        break;
                    case 5:imageView.setBackgroundResource(R.drawable.servidor);
                        break;

                }
                editTextTextAnswer = (EditText) findViewById(R.id.edit_text_text_answer);
                break;
            case 3:
                addScore = 1;
                quizRule.setText(R.string.quiz_three_hint);
                if(!orientationChanged) {
                    checkBoxRandom = randomNumber.nextInt(checkQuiz.size());
                }
                checkBoxQuizData = new ArrayList<>(checkQuiz.get(checkBoxRandom).getCheckRadioQuizData());
                TextView checkBoxQuestion = (TextView) findViewById(R.id.checkbox_question);
                checkBoxQuestion.setText(checkBoxQuizData.get(0));
                checkBoxes = new ArrayList<>();
                checkBoxes.add((CheckBox) findViewById(R.id.answer_one_check));
                checkBoxes.add((CheckBox) findViewById(R.id.answer_two_check));
                checkBoxes.add((CheckBox) findViewById(R.id.answer_three_check));
                checkBoxes.add((CheckBox) findViewById(R.id.answer_four_check));
                checkBoxes.add((CheckBox) findViewById(R.id.answer_five_check));
                int counterCheckBox = 1;
                for(CheckBox checkBox : checkBoxes){
                    checkBox.setText(checkBoxQuizData.get(counterCheckBox));
                    counterCheckBox += 2;
                }
                break;
            case 4:
                addScore = 1;
                quizRule.setText(R.string.quiz_four_hint);
                if(!orientationChanged) {
                    radioButtonRandom = randomNumber.nextInt(radioQuiz.size());
                }
                radioQuizData = new ArrayList<>(radioQuiz.get(radioButtonRandom).getCheckRadioQuizData());
                TextView radioQuestion = (TextView) findViewById(R.id.radio_button_question);
                radioQuestion.setText(radioQuizData.get(0));
                radioButtons = new ArrayList<>();
                radioButtons.add((RadioButton) findViewById(R.id.answer_one_radio));
                radioButtons.add((RadioButton) findViewById(R.id.answer_two_radio));
                radioButtons.add((RadioButton) findViewById(R.id.answer_three_radio));
                radioButtons.add((RadioButton) findViewById(R.id.answer_four_radio));
                radioButtons.add((RadioButton) findViewById(R.id.answer_five_radio));
                int counterRadio = 1;
                for(RadioButton radioButton : radioButtons){
                    radioButton.setText(radioQuizData.get(counterRadio));
                    counterRadio += 2;
                }
                break;
            case 5:
                TextView endCardText = (TextView) findViewById(R.id.end_card_text);
                endCardText.setText(getString(R.string.end_thank_first)+playerName+getString(R.string.end_thank_second)+score+getString(R.string.end_thank_third));
                TextView questionOne = (TextView) findViewById(R.id.end_question_one);
                questionOne.setText(editNumberQuizData.get(0));
                TextView answerOne = (TextView) findViewById(R.id.end_answer_one);
                answerOne.setText(editNumberQuizData.get(1));
                TextView questionTwo = (TextView) findViewById(R.id.end_question_two);
                questionTwo.setText(editTextQuizData.get(0));
                TextView answerTwo = (TextView) findViewById(R.id.end_answer_two);
                answerTwo.setText(editTextQuizData.get(1));
                ImageView endImage = (ImageView) findViewById(R.id.end_image_view);
                if(editTextQuizData.get(1).equals("conmutador")){
                    endImage.setBackgroundResource(R.drawable.conmutador);
                }
                if(editTextQuizData.get(1).equals("firewall")){
                    endImage.setBackgroundResource(R.drawable.firewall);
                }
                if(editTextQuizData.get(1).equals("hub")){
                    endImage.setBackgroundResource(R.drawable.hub);
                }
                if(editTextQuizData.get(1).equals("portatil")){
                    endImage.setBackgroundResource(R.drawable.portatil);
                }
                if(editTextQuizData.get(1).equals("router")){
                    endImage.setBackgroundResource(R.drawable.router);
                }
                if(editTextQuizData.get(1).equals("servidor")){
                    endImage.setBackgroundResource(R.drawable.servidor);
                }
                switch(editTextTextRandom){
                    case 0:endImage.setBackgroundResource(R.drawable.conmutador);
                        break;
                    case 1:endImage.setBackgroundResource(R.drawable.firewall);
                        break;
                    case 2:endImage.setBackgroundResource(R.drawable.hub);
                        break;
                    case 3:endImage.setBackgroundResource(R.drawable.portatil);
                        break;
                    case 4:endImage.setBackgroundResource(R.drawable.router);
                        break;
                    case 5:endImage.setBackgroundResource(R.drawable.servidor);
                        break;

                }
                TextView questionThree = (TextView) findViewById(R.id.end_question_three);
                questionThree.setText(checkBoxQuizData.get(0));
                ArrayList<CheckBox> endCheckBoxes = new ArrayList<>();
                endCheckBoxes.add((CheckBox) findViewById(R.id.end_answer_check_one));
                endCheckBoxes.add((CheckBox) findViewById(R.id.end_answer_check_two));
                endCheckBoxes.add((CheckBox) findViewById(R.id.end_answer_check_three));
                endCheckBoxes.add((CheckBox) findViewById(R.id.end_answer_check_four));
                endCheckBoxes.add((CheckBox) findViewById(R.id.end_answer_check_five));
                int boxCounter = 0;
                for(CheckBox endCheckBox : endCheckBoxes){
                    endCheckBox.setChecked(false);
                    endCheckBox.setEnabled(true);
                    endCheckBox.setText(checkBoxes.get(boxCounter).getText().toString());
                    if (Boolean.parseBoolean(checkBoxQuizData.get(2 + (boxCounter * 2)))){
                        endCheckBox.setChecked(true);
                    }
                    endCheckBox.setEnabled(false);
                    boxCounter+=1;
                }
                TextView questionFour = (TextView) findViewById(R.id.end_question_four);
                questionFour.setText(radioQuizData.get(0));
                ArrayList<RadioButton> endRadioButtons = new ArrayList<>();
                endRadioButtons.add((RadioButton) findViewById(R.id.end_answer_radio_one));
                endRadioButtons.add((RadioButton) findViewById(R.id.end_answer_radio_two));
                endRadioButtons.add((RadioButton) findViewById(R.id.end_answer_radio_three));
                endRadioButtons.add((RadioButton) findViewById(R.id.end_answer_radio_four));
                endRadioButtons.add((RadioButton) findViewById(R.id.end_answer_radio_five));
                int countRadio = 1;
                for(RadioButton radioButton : endRadioButtons){
                    radioButton.setChecked(false);
                    radioButton.setEnabled(true);
                    radioButton.setText(radioQuizData.get(countRadio));
                    if(Boolean.parseBoolean(radioQuizData.get(countRadio + 1))){
                        radioButton.setChecked(true);
                    }
                    radioButton.setEnabled(false);
                    countRadio += 2;
                }
                break;
        }
    }

    //Ver la respuesta correcta en cada vista una vez que el usuario envió la respuesta
    public void checkQuiz(int actualQuiz){
        switch(actualQuiz){
            case 1:
                if(editTextNumberAnswer.getText().toString().equals(editNumberQuizData.get(1))){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wright_answer)+" +"+addScore+getString(R.string.score),
                            Toast.LENGTH_SHORT);
                    toast.show();
                    score += addScore;
                    scoreText.setText(getString(R.string.score_text) + score);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wrong_answer)+editNumberQuizData.get(1)+"!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                editTextNumberAnswer.setFocusable(false);
                editTextNumberAnswer.setFocusableInTouchMode(false);
                break;
            case 2:
                if(editTextTextAnswer.getText().toString().trim().toUpperCase().equals(editTextQuizData.get(1))){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wright_answer)+" +"+addScore+getString(R.string.score),
                            Toast.LENGTH_SHORT);
                    toast.show();
                    score += addScore;
                    scoreText.setText(getString(R.string.score_text) + score);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wrong_answer)+editTextQuizData.get(1)+"!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                editTextTextAnswer.setFocusable(false);
                editTextTextAnswer.setFocusableInTouchMode(false);
                break;
            case 3:
                int wrightAnswersCheck = 0;
                int counterCheck = 2;
                for(CheckBox checkBox : checkBoxes){
                    if (checkBox.isChecked() == Boolean.parseBoolean(checkBoxQuizData.get(counterCheck))){
                        wrightAnswersCheck++;
                    }
                    checkBox.setEnabled(false);
                    counterCheck += 2;
                }
                if(wrightAnswersCheck == 5){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wright_answer)+" +"+addScore+getString(R.string.score),
                            Toast.LENGTH_SHORT);
                    toast.show();
                    score += addScore;
                    scoreText.setText(getString(R.string.score_text) + score);
                }else{
                    String text;
                    text = getString(R.string.wrong_answer);
                    for (int i = 2; i < checkBoxQuizData.size(); i+=2){
                        if(checkBoxQuizData.get(i).equals("true")){
                            text += ", " + checkBoxQuizData.get(i-1)+"";
                        }
                    }
                    text += " !";
                    Toast toast = Toast.makeText(getApplicationContext(),
                            text,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case 4:
                int wrightAnswersRadio = 0;
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
                int selectedButton = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedButton);
                if(selectedButton != -1) {
                    for (int i = 1; i < radioQuizData.size(); i += 2) {
                        if ((selectedRadioButton.getText().toString().equals(radioQuizData.get(i))
                        &&(Boolean.parseBoolean(radioQuizData.get(i+1))))) {
                            wrightAnswersRadio++;
                        }
                    }
                }
                for(RadioButton radioButton : radioButtons){
                    radioButton.setEnabled(false);
                }
                if(wrightAnswersRadio == 1){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.wright_answer)+" +"+addScore+getString(R.string.score),
                            Toast.LENGTH_SHORT);
                    toast.show();
                    score += addScore;
                    scoreText.setText(getString(R.string.score_text) + score);
                }else{
                    String text;
                    text = getString(R.string.wrong_answer);
                    for (int i = 2; i < radioQuizData.size(); i+=2){
                        if(radioQuizData.get(i).equals("true")){
                            text += ", " + radioQuizData.get(i-1)+"";
                        }
                    }
                    text += " !";
                    Toast toast = Toast.makeText(getApplicationContext(),
                            text,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }
    }

    //Mostrar cambios cuando se cambia de vista
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(getString(R.string.player_name_istate),playerName);
        outState.putString(getString(R.string.quiz_level_istate),quizLevel.getText().toString());
        outState.putString(getString(R.string.quiz_rule_istate),quizRule.getText().toString());
        outState.putString(getString(R.string.submit_next_button_istate),submitNextButton.getText().toString());
        outState.putString(getString(R.string.quiz_one_question_istate),editTextNumberQuestion.getText().toString());
        outState.putString(getString(R.string.quiz_one_answer_istate),editTextNumberAnswer.getText().toString());
        outState.putInt(getString(R.string.score_istate),score);
        outState.putInt(getString(R.string.actual_view_istate),actualView);
        outState.putInt(getString(R.string.edit_text_number_random_istate),editTextNumberRandom);
        outState.putInt(getString(R.string.edit_text_text_random_istate),editTextTextRandom);
        outState.putInt(getString(R.string.check_box_random_istate),checkBoxRandom);
        outState.putInt(getString(R.string.radio_button_random_istate),radioButtonRandom);
        super.onSaveInstanceState(outState);
    }
    //Recrear vista después de los cambios
    private void setRotateView(int rotatedView){
        switch(rotatedView){
            case 0:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.GONE);
                    appTheme.setVisibility(View.VISIBLE);
                    quizEnd.setVisibility(View.GONE);
                } else{
                    playerScoreLL.setVisibility(View.GONE);
                    appThemeLL.setVisibility(View.VISIBLE);
                    quizEndLL.setVisibility(View.GONE);
                }
                quizLayouts.get(0).setVisibility(View.VISIBLE);
                quizLayouts.get(1).setVisibility(View.GONE);
                quizLayouts.get(2).setVisibility(View.GONE);
                quizLayouts.get(3).setVisibility(View.GONE);
                quizLayouts.get(4).setVisibility(View.GONE);
                quizLayouts.get(5).setVisibility(View.GONE);
                break;
            case 1:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.VISIBLE);
                    appTheme.setVisibility(View.GONE);
                    quizEnd.setVisibility(View.GONE);
                } else{
                    playerScoreLL.setVisibility(View.VISIBLE);
                    appThemeLL.setVisibility(View.GONE);
                    quizEndLL.setVisibility(View.GONE);
                }
                quizLayouts.get(0).setVisibility(View.GONE);
                quizLayouts.get(1).setVisibility(View.VISIBLE);
                quizLayouts.get(2).setVisibility(View.GONE);
                quizLayouts.get(3).setVisibility(View.GONE);
                quizLayouts.get(4).setVisibility(View.GONE);
                quizLayouts.get(5).setVisibility(View.GONE);
                break;
            case 2:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.VISIBLE);
                    appTheme.setVisibility(View.GONE);
                    quizEnd.setVisibility(View.GONE);
                } else{
                    playerScoreLL.setVisibility(View.VISIBLE);
                    appThemeLL.setVisibility(View.GONE);
                    quizEndLL.setVisibility(View.GONE);
                }
                quizLayouts.get(0).setVisibility(View.GONE);
                quizLayouts.get(1).setVisibility(View.GONE);
                quizLayouts.get(2).setVisibility(View.VISIBLE);
                quizLayouts.get(3).setVisibility(View.GONE);
                quizLayouts.get(4).setVisibility(View.GONE);
                quizLayouts.get(5).setVisibility(View.GONE);
                break;
            case 3:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.VISIBLE);
                    appTheme.setVisibility(View.GONE);
                    quizEnd.setVisibility(View.GONE);
                } else{
                    playerScoreLL.setVisibility(View.VISIBLE);
                    appThemeLL.setVisibility(View.GONE);
                    quizEndLL.setVisibility(View.GONE);
                }
                quizLayouts.get(0).setVisibility(View.GONE);
                quizLayouts.get(1).setVisibility(View.GONE);
                quizLayouts.get(2).setVisibility(View.GONE);
                quizLayouts.get(3).setVisibility(View.VISIBLE);
                quizLayouts.get(4).setVisibility(View.GONE);
                quizLayouts.get(5).setVisibility(View.GONE);
                break;
            case 4:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.VISIBLE);
                    appTheme.setVisibility(View.GONE);
                    quizEnd.setVisibility(View.GONE);
                } else{
                    playerScoreLL.setVisibility(View.VISIBLE);
                    appThemeLL.setVisibility(View.GONE);
                    quizEndLL.setVisibility(View.GONE);
                }
                quizLayouts.get(0).setVisibility(View.GONE);
                quizLayouts.get(1).setVisibility(View.GONE);
                quizLayouts.get(2).setVisibility(View.GONE);
                quizLayouts.get(3).setVisibility(View.GONE);
                quizLayouts.get(4).setVisibility(View.VISIBLE);
                quizLayouts.get(5).setVisibility(View.GONE);
                break;
            case 5:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    playerScore.setVisibility(View.GONE);
                    appTheme.setVisibility(View.GONE);
                    quizEnd.setVisibility(View.VISIBLE);
                } else{
                    playerScoreLL.setVisibility(View.GONE);
                    appThemeLL.setVisibility(View.GONE);
                    quizEndLL.setVisibility(View.VISIBLE);
                }
                quizLayouts.get(0).setVisibility(View.GONE);
                quizLayouts.get(1).setVisibility(View.GONE);
                quizLayouts.get(2).setVisibility(View.GONE);
                quizLayouts.get(3).setVisibility(View.GONE);
                quizLayouts.get(4).setVisibility(View.GONE);
                quizLayouts.get(5).setVisibility(View.VISIBLE);
                break;
        }
    }
}
