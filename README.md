# Proyecto cuestionario

## Introducción
El objetivo es crear una aplicación que realice un cuestionario de retroalimentación (feedback) de un
curso determinado de su elección, una vez que el usuario conteste el cuestionario presionara el botón de
enviar y la aplicación generara un correo electrónico adjuntando las respuestas en un archivo de texto.

Para este proyecto, se eligió realizar un cuestionario sobre conceptos básicos de redes, el cuál consta con un total 
de 17 preguntas, de las cuales, 4 serán elegidas al azar para mostrarselas al usuario cada que inicie el cuestionario.
Al finalizar, se mostrará un resumen con las respustas y un botón para enviar las respuestas por correo. 

A continuación, se muestran las clases del proyecto así como capturas del resultado como evidencia. 

![Evidencia1](https://github.com/IvanPacheco182/cuestionario/blob/master/evidencia/img1.png )
![Evidencia2](https://github.com/IvanPacheco182/cuestionario/blob/master/evidencia/img2.png )
![Evidencia3](https://github.com/IvanPacheco182/cuestionario/blob/master/evidencia/img3.png )

## Archivo XML activity_main
~~~

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    android:orientation="vertical"
    tools:context="com.robertkiszelirk.androidquiz.MainActivity">

    <!-- Application Theme CardView -->

    <LinearLayout
        android:id="@+id/appTheme"
        style="@style/cardView">

        <TextView
            style="@style/cardViewLargeText"
            android:text="@string/game_theme"
            android:textSize="@dimen/app_theme_card_text_size" />

    </LinearLayout>

    <!-- In Quiz CardView -->
    <LinearLayout
        android:id="@+id/playerScore"
        style="@style/cardView"
        android:layout_width="159dp"
        android:layout_height="98dp"
        android:visibility="gone">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3">

                <TextView
                    android:id="@+id/player_name_card_view"
                    style="@style/cardViewText"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_margin="@dimen/card_view_text_margin" />

                <TextView
                    android:id="@+id/score"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_alignParentTop="true"
                    android:layout_alignParentEnd="true"
                    android:layout_alignParentRight="true"
                    android:layout_margin="@dimen/card_view_text_margin"
                    android:layout_toEndOf="@+id/player_name_card_view"
                    android:layout_toRightOf="@+id/player_name_card_view"
                    android:gravity="end"
                    android:text="@string/score_zero"
                    android:textColor="@color/textColorOnCard"
                    android:textSize="@dimen/in_quiz_card_text_size" />

                <TextView
                    android:id="@+id/quiz_level"
                    style="@style/cardViewText"
                    android:layout_alignBottom="@+id/quiz_rule"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_margin="@dimen/card_view_text_margin"
                    android:paddingBottom="16dp" />

                <TextView
                    android:id="@+id/quiz_rule"
                    style="@style/cardViewText"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentLeft="true"
                    android:layout_alignParentBottom="true"
                    android:layout_margin="@dimen/card_view_text_margin" />
            </RelativeLayout>



        </LinearLayout>
    </LinearLayout>

    <!-- Quiz End CardView -->
    <LinearLayout
        android:id="@+id/quiz_end"
        style="@style/cardView"
        android:visibility="gone">
        <TextView
            android:id="@+id/end_card_text"
            style="@style/cardViewLargeText"
            android:textSize="24sp"/>
    </LinearLayout>

    <!-- Start Screen Layout -->

    <LinearLayout
        android:id="@+id/start_layout"
        android:layout_width="match_parent"
        android:layout_height="12dp"
        android:layout_weight="4"
        android:descendantFocusability="beforeDescendants"
        android:focusableInTouchMode="true"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/imageView4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:scaleType="centerCrop"
            android:visibility="visible"
            app:srcCompat="@drawable/fondo" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="21dp"
            android:layout_marginTop="25dp"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:lines="2"
            android:text="@string/your_name_text"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/start_card_text_size" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginBottom="25dp"
            android:layout_weight="1">

            <EditText
                android:id="@+id/edit_player_name_text"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_marginLeft="25dp"
                android:layout_marginRight="25dp"
                android:ems="10"
                android:gravity="center"
                android:hint="@string/player_name_hint"
                android:imeOptions="actionDone"
                android:inputType="textPersonName"
                android:selectAllOnFocus="false"
                android:textColor="@color/textColorInQuestion"
                android:textSize="@dimen/start_screen_edit_text_size"></EditText>
        </LinearLayout>
    </LinearLayout>

    <!-- EditText With Number Quiz Layout -->
    <LinearLayout
        android:id="@+id/quiz_text_number"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_gravity="center"
        android:layout_weight="4"
        android:descendantFocusability="beforeDescendants"
        android:focusableInTouchMode="true"
        android:orientation="vertical"
        android:visibility="gone">
        <TextView
            android:id="@+id/edit_text_number_question"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_margin="@dimen/edit_text_number_question_margin"
            android:layout_weight="12"
            android:gravity="center"
            android:lineSpacingExtra="@dimen/edit_text_number_text_line_spacing"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/edit_text_number_question_size"/>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_gravity="center"
            android:layout_weight="5">
            <EditText
                android:id="@+id/edit_text_number_answer"
                style="@style/editText"
                android:inputType="number"
                >
            </EditText>
        </LinearLayout>
    </LinearLayout>

    <!-- EditText With Text Quiz Layout -->
    <LinearLayout
        android:id="@+id/quiz_text_text"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_gravity="center"
        android:layout_weight="4"
        android:descendantFocusability="beforeDescendants"
        android:focusableInTouchMode="true"
        android:orientation="vertical"
        android:visibility="gone">
        <TextView
            android:id="@+id/edit_text_text_question"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginBottom="10dp"
            android:layout_marginLeft="@dimen/edit_text_text_left_right_margin"
            android:layout_marginRight="@dimen/edit_text_text_left_right_margin"
            android:layout_weight="2"
            android:gravity="center"
            android:lineSpacingExtra="@dimen/edit_text_text_text_line_spacing"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/edit_text_text_question_size"/>
        <ImageView
            android:id="@+id/edit_text_text_image"
            android:layout_width="@dimen/edit_text_image_width"
            android:layout_height="0dp"
            android:layout_gravity="center_horizontal"
            android:layout_weight="4"
            android:scaleType="centerCrop"/>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_gravity="center"
            android:layout_weight="2">

            <EditText
                android:id="@+id/edit_text_text_answer"
                style="@style/editText"
                android:inputType="text" />

        </LinearLayout>
    </LinearLayout>

    <!-- CheckBox Quiz Layout -->
    <LinearLayout
        android:id="@+id/quiz_checkbox"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="4"
        android:gravity="center"
        android:orientation="vertical"
        android:visibility="gone">
        <TextView
            android:id="@+id/checkbox_question"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="@dimen/check_box_top_down_margin"
            android:layout_marginLeft="@dimen/check_box_left_right_margin"
            android:layout_marginRight="@dimen/check_box_left_right_margin"
            android:layout_marginTop="@dimen/check_box_top_down_margin"
            android:gravity="center_horizontal"
            android:lineSpacingExtra="@dimen/check_box_text_line_spacing"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/check_box_question_size"/>
        <CheckBox
            android:id="@+id/answer_one_check"
            style="@style/checkBox"/>
        <CheckBox
            android:id="@+id/answer_two_check"
            style="@style/checkBox"/>
        <CheckBox
            android:id="@+id/answer_three_check"
            style="@style/checkBox"/>
        <CheckBox
            android:id="@+id/answer_four_check"
            style="@style/checkBox"/>
        <CheckBox
            android:id="@+id/answer_five_check"
            style="@style/checkBox"/>
    </LinearLayout>

    <!-- RadioButton Quiz Layout -->
    <LinearLayout
        android:id="@+id/quiz_radio_button"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="4"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        android:visibility="gone">
        <TextView
            android:id="@+id/radio_button_question"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="10dp"
            android:layout_marginLeft="@dimen/radio_button_question_left_right_margin"
            android:layout_marginRight="@dimen/radio_button_question_left_right_margin"
            android:layout_marginTop="@dimen/radio_button_question_top_bottom_margin"
            android:gravity="center_horizontal"
            android:lineSpacingExtra="@dimen/radio_button_question_line_spacing"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/radio_button_question_text_size"/>
        <RadioGroup
            android:id="@+id/radio_group"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center_horizontal">
            <RadioButton
                android:id="@+id/answer_one_radio"
                style="@style/radioButton"/>
            <RadioButton
                android:id="@+id/answer_two_radio"
                style="@style/radioButton"/>
            <RadioButton
                android:id="@+id/answer_three_radio"
                style="@style/radioButton"/>
            <RadioButton
                android:id="@+id/answer_four_radio"
                style="@style/radioButton"/>
            <RadioButton
                android:id="@+id/answer_five_radio"
                style="@style/radioButton"/>
        </RadioGroup>
    </LinearLayout>

    <!-- End Quiz Layout -->
    <LinearLayout
        android:id="@+id/quiz_end_layout"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="4"
        android:orientation="vertical"
        android:visibility="gone">
        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="@dimen/scroll_view_margin"
            android:background="@color/colorAccent">
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="@dimen/scroll_view_linear_layout_margin"
                android:gravity="center_horizontal"
                android:orientation="vertical"
                android:paddingBottom="@dimen/scroll_view_linear_layout_padding">
                <TextView
                    android:id="@+id/end_question_one"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <TextView
                    android:id="@+id/end_answer_one"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="5dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <View
                    android:layout_width="match_parent"
                    android:layout_height="2dp"
                    android:background="@color/textColorOnButton"/>
                <TextView
                    android:id="@+id/end_question_two"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <ImageView
                    android:id="@+id/end_image_view"
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:scaleType="centerCrop" />
                <TextView
                    android:id="@+id/end_answer_two"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="5dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <View
                    android:layout_width="match_parent"
                    android:layout_height="2dp"
                    android:background="@color/textColorOnButton"/>
                <TextView
                    android:id="@+id/end_question_three"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <LinearLayout
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:orientation="vertical">
                    <CheckBox
                        android:id="@+id/end_answer_check_one"
                        style="@style/endCheckBox"/>
                    <CheckBox
                        android:id="@+id/end_answer_check_two"
                        style="@style/endCheckBox"/>
                    <CheckBox
                        android:id="@+id/end_answer_check_three"
                        style="@style/endCheckBox"/>
                    <CheckBox
                        android:id="@+id/end_answer_check_four"
                        style="@style/endCheckBox"/>
                    <CheckBox
                        android:id="@+id/end_answer_check_five"
                        style="@style/endCheckBox"/>
                </LinearLayout>
                <View
                    android:layout_width="match_parent"
                    android:layout_height="2dp"
                    android:background="@color/textColorOnButton"/>
                <TextView
                    android:id="@+id/end_question_four"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_margin="10dp"
                    android:gravity="center"
                    android:textColor="@color/textColorInQuestion"
                    android:textSize="@dimen/end_text_size"/>
                <LinearLayout
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:gravity="center"
                    android:orientation="vertical">
                    <RadioButton
                        android:id="@+id/end_answer_radio_one"
                        style="@style/radioButton"/>
                    <RadioButton
                        android:id="@+id/end_answer_radio_two"
                        style="@style/radioButton"/>
                    <RadioButton
                        android:id="@+id/end_answer_radio_three"
                        style="@style/radioButton"/>
                    <RadioButton
                        android:id="@+id/end_answer_radio_four"
                        style="@style/radioButton"/>
                    <RadioButton
                        android:id="@+id/end_answer_radio_five"
                        style="@style/radioButton"/>
                    </LinearLayout>
                </LinearLayout>
        </ScrollView>
    </LinearLayout>


    <Button
        android:id="@+id/submit_next_button"
        style="@style/submitNextButtonStyle"
        android:layout_width="172dp"
        android:layout_height="7dp"
        android:layout_margin="@dimen/submit_button_margin"
        android:layout_weight="1"
        android:background="@color/colorAccent"
        android:onClick="changeView"
        android:text="@string/start_quiz"
        android:textAllCaps="true"
        android:textColor="@color/textColorOnButton"
        android:textSize="@dimen/submit_button_text_size" />

    <LinearLayout
        android:id="@+id/quiz_text_text"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center"
        android:layout_weight="4"
        android:descendantFocusability="beforeDescendants"
        android:focusableInTouchMode="true"
        android:orientation="vertical"
        android:visibility="gone">

        <TextView
            android:id="@+id/edit_text_text_question"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginBottom="10dp"
            android:layout_marginLeft="@dimen/edit_text_text_left_right_margin"
            android:layout_marginRight="@dimen/edit_text_text_left_right_margin"
            android:layout_weight="2"
            android:gravity="center"
            android:lineSpacingExtra="@dimen/edit_text_text_text_line_spacing"
            android:textColor="@color/textColorInQuestion"
            android:textSize="@dimen/edit_text_text_question_size" />

        <ImageView
            android:id="@+id/edit_text_text_image"
            android:layout_width="@dimen/edit_text_image_width"
            android:layout_height="0dp"
            android:layout_gravity="center_horizontal"
            android:layout_weight="4"
            android:scaleType="centerCrop" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_gravity="center"
            android:layout_weight="2">

            <EditText
                android:id="@+id/edit_text_text_answer"
                style="@style/editText"
                android:inputType="text" />

        </LinearLayout>
    </LinearLayout>
</LinearLayout>

             
             
~~~

## Clase java MainActivity
~~~

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
        
        //CHECAR LA VERSION DE ANDROID 
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            appTheme = (CardView) findViewById(R.id.appTheme);
            playerScore = (CardView) findViewById(R.id.playerScore);
            quizEnd = (CardView) findViewById(R.id.quiz_end);
        } else{
            appThemeLL = (LinearLayout) findViewById(R.id.appTheme);
            playerScoreLL = (LinearLayout) findViewById(R.id.playerScore);
            quizEndLL = (LinearLayout) findViewById(R.id.quiz_end);
        }
        
        //LLAMAR LOS CARD TEXTVIEWS
        playerNameText = (TextView) findViewById(R.id.player_name_card_view);
        scoreText = (TextView) findViewById(R.id.score);
        quizLevel = (TextView) findViewById(R.id.quiz_level);
        quizRule = (TextView) findViewById(R.id.quiz_rule);
        
        //CREAR LAYOUTS
        quizLayouts = new ArrayList<>();
        quizLayouts.add((LinearLayout) findViewById(R.id.start_layout));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_text_number));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_text_text));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_checkbox));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_radio_button));
        quizLayouts.add((LinearLayout) findViewById(R.id.quiz_end_layout));
        
        //Llamar a los EDIT TEXTS
        editTextNumberQuestion = (TextView) findViewById(R.id.edit_text_number_question);
        editTextNumberAnswer = (EditText) findViewById(R.id.edit_text_number_answer);
        
        //Llamar al boton "next"
        submitNextButton = (Button) findViewById(R.id.submit_next_button);
        
        //Inicializar los datos en 0
        actualView = 0;
        randomNumber = new Random();
        

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

~~~

# Clases para enviar respuestas al correo 
***
## MainActivityMail.java
~~~
package com.robertkiszelirk.androidquiz;

/**
 * Created by ivan on 18/10/2018.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;



public class MainActivityMail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mail);

        Button btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //obtenemos los datos para el envío del correo
                EditText etEmail           = (EditText) findViewById(R.id.etEmail);
                EditText etSubject         = (EditText) findViewById(R.id.etSubject);

                //es necesario un intent que levante la actividad deseada
                Intent itSend = new Intent(android.content.Intent.ACTION_SEND);

                //vamos a enviar texto plano a menos que el checkbox esté marcado
                itSend.setType("plain/text");

                //colocamos los datos para el envío
                itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{
                        etEmail.getText().toString()});
                itSend.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        etSubject.getText().toString());
                itSend.putExtra(Intent.EXTRA_TEXT, new String("Las respuestas en orden son las siguientes: \n\n"+
                        "1.-¿Cuántos bits hay en una dirección ipv4?\n" +
                        "R= 32 \n\n " +
                        "2.-¿Cuál es el equivalente decimal del número hexadecimal 0x3f?\n" +
                        "R= 63 \n\n " +
                        "3.-¿Cuántos bits tiene un byte?\n" +
                        "R= 8 \n\n " +
                        "4.-¿A cuántos bytes equivale 16 bits?\n" +
                        "R= 2 \n\n " +
                        "5.-¿Cuántos bits hay en una dirección ipv6?\n" +
                        "R= 128 \n\n " +
                        "6.-¿Cuántos octetos tiene una dirección ipv4?\n" +
                        "R= 4 \n\n"+
                        "7.-¿Cómo se llama el dispositivo que se muestra en pantalla?\n" +
                        "R= Conmutador, hub, firewall, portatil, router, servidor \n\n " +
                        "8.-¿Comando para ver la configuracion ip en una computadora windows?\n" +
                        "R= ip info \n\n " +
                        "9.-3 características de los switches en la capa de acceso:\n" +
                        "R= Velocidad de reenvío, Alimentación por ethernet y Densidad de puertos \n\n " +
                        "10.-La información de la vlan de rango extendido se almacena en el archivo: \n" +
                        "R= running config \n\n " +
                        "11.-Seleccione las características básicas para configurar spanning-tree\n" +
                        "R= modo, dominio y contraseña \n\n " +
                        "12.-¿Cuál de las siguientes interfaces es la SVI predeterminada en un switch cisco?\n" +
                        "R= VLAN1 \n\n " +
                        "13.-Tipo De Vlan Se Identifica Mediante Una Id De Vlan Entre 1006 Y 4094\n" +
                        "R= Extendida \n\n " +
                        "14.-Protocolo de routing sin Clase que admite VLSM Y Cidr\n" +
                        "R= RIPv2 \n\n " +
                        "15.-Protocolo diseñado por la organización internacional de normalización (ISO):\n" +
                        "R= Sistema intermedio a sistema intermedio (IS-IS) \n\n " +
                        "16.-¿Cuál es la extensión de los programas de cisco?\n" +
                        "R= .pkt \n\n " +
                        "17.-¿Con etherchannel, qué tipo de conexión lógica usan las interfaces de múltiples links físicos? :\n" +
                        "R= Canal de puertos \n\n " ));
                //revisamos si el checkbox está marcado enviamos el ícono de la aplicación como adjunto

                //iniciamos la actividad
                startActivity(itSend);
            }
        });




    }
}

~~~

## activity_main_mail.xml
~~~
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout

    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context=".MainActivity">


    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/LinearLayout01"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="vertical">

        <LinearLayout
            android:id="@+id/LinearLayout02"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/txtForEmail"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Destinatario"></TextView>

            <EditText
                android:id="@+id/etEmail"
                android:layout_width="237dp"
                android:layout_height="wrap_content"
                android:width="170dip"
                android:inputType="textEmailAddress"></EditText>
        </LinearLayout>

        <LinearLayout
            android:id="@+id/LinearLayout03"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/txtForSubject"
                android:layout_width="73dp"
                android:layout_height="wrap_content"
                android:text="Asunto"></TextView>

            <EditText
                android:id="@+id/etSubject"
                android:layout_width="156dp"
                android:layout_height="wrap_content"
                android:width="170dip"></EditText>
        </LinearLayout>

        <LinearLayout
            android:id="@+id/LinearLayout04"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

        </LinearLayout>

        <Button
            android:id="@+id/btnSend"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:width="150dip"
            android:imeOptions="actionSend"
            android:text="Enviar respuestas"></Button>
    </LinearLayout>


</RelativeLayout>

~~~

# Paquete de Valores
***
## colors.xml
~~~
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#bfc0bd</color>
    <color name="colorPrimaryDark">#117ec1</color>
    <color name="colorAccent">#71afe2</color>

    <color name="textColorOnCard">#FFFFFF</color>
    <color name="textColorInQuestion">#000000</color>
    <color name="textColorOnButton">#000000</color>


</resources>
~~~
***
## dimens.xml
~~~
<resources>
    <dimen name="activity_horizontal_margin">16dp</dimen>
    <dimen name="activity_vertical_margin">16dp</dimen>


    <dimen name="app_theme_card_text_size">34sp</dimen>
    <dimen name="in_quiz_card_text_size">20sp</dimen>
    <dimen name="help_text_size">16sp</dimen>
    <dimen name="start_card_text_size">20sp</dimen>
    <dimen name="start_screen_edit_text_size">20sp</dimen>
    <dimen name="edit_text_number_question_size">20sp</dimen>
    <dimen name="edit_text_size">20sp</dimen>
    <dimen name="edit_text_text_question_size">16sp</dimen>
    <dimen name="edit_text_image_width">160dp</dimen>
    <dimen name="check_box_question_size">20sp</dimen>
    <dimen name="check_box_text_size">12sp</dimen>
    <dimen name="radio_button_question_text_size">20sp</dimen>
    <dimen name="radio_button_text_size">12sp</dimen>
    <dimen name="end_text_size">16sp</dimen>
    <dimen name="submit_button_text_size">20sp</dimen>


    <dimen name="app_theme_card_text_size_landscape">30sp</dimen>
    <dimen name="help_size_landscape">16sp</dimen>
    <dimen name="start_screen_text_size_landscape">20sp</dimen>
    <dimen name="edit_text_size_landscape">20sp</dimen>
    <dimen name="edit_text_number_question_size_landscape">16sp</dimen>
    <dimen name="edit_text_text_question_size_landscape">12sp</dimen>
    <dimen name="check_box_question_size_landscape">12sp</dimen>
    <dimen name="radio_button_question_size_landscape">16sp</dimen>
    <dimen name="submit_button_text_size_landscape">20sp</dimen>


    <dimen name="card_view_text_margin">12dp</dimen>
    <dimen name="edit_text_number_question_margin">20dp</dimen>
    <dimen name="edit_text_number_text_line_spacing">5dp</dimen>
    <dimen name="edit_text_text_left_right_margin">20dp</dimen>
    <dimen name="edit_text_text_text_line_spacing">5dp</dimen>
    <dimen name="check_box_left_right_margin">20dp</dimen>
    <dimen name="check_box_top_down_margin">5dp</dimen>
    <dimen name="check_box_text_line_spacing">5dp</dimen>
    <dimen name="radio_button_question_left_right_margin">20dp</dimen>
    <dimen name="radio_button_question_top_bottom_margin">5dp</dimen>
    <dimen name="radio_button_question_line_spacing">5dp</dimen>
    <dimen name="scroll_view_margin">5dp</dimen>
    <dimen name="scroll_view_linear_layout_margin">20dp</dimen>
    <dimen name="scroll_view_linear_layout_padding">20dp</dimen>
    <dimen name="submit_button_margin">20dp</dimen>

    <dimen name="card_view_player_name_margin_landscape">12dp</dimen>
    <dimen name="card_view_score_margin_landscape">12dp</dimen>
    <dimen name="card_view_left_bottom_margin_landscape">12dp</dimen>
    <dimen name="start_screen_question_left_right_margin_landscape">5dp</dimen>
    <dimen name="start_screen_question_top_margin_landscape">20dp</dimen>
    <dimen name="start_screen_edit_text_left_right_margin_landscape">20dp</dimen>
    <dimen name="edit_text_number_question_margin_landscape">20dp</dimen>
    <dimen name="edit_text_text_question_left_right_margin_landscape">20dp</dimen>
    <dimen name="edit_text_text_bottom_margin">5dp</dimen>
    <dimen name="check_box_question_margin_left_right_landscape">20dp</dimen>
    <dimen name="check_box_question_margin_top_bottom_landscape">5dp</dimen>
    <dimen name="radio_button_question_margin_left_right_landscape">20dp</dimen>
    <dimen name="radio_button_question_margin_top_bottom_landscape">5dp</dimen>
    <dimen name="scroll_view_margin_landscape">5dp</dimen>
    <dimen name="scroll_view_linear_layout_margin_landscape">20dp</dimen>
    <dimen name="scroll_view_linear_layout_padding_bottom_landscape">20dp</dimen>
</resources>

~~~
***
## strings.xml
~~~
<resources>
    <string name="app_name">Encuesta de CCNA 1</string>
    <string name="game_theme">Cuestionario sobre conceptos básicos de redes </string>
    <string name="score_zero">Correctas: 0</string>
    <string name="help">Ayuda</string>
    <string name="your_name_text">Ingresa tu nombre: </string>
    <string name="player_name_hint">Nombre</string>
    <string name="your_answer_hint">Tu Respuesta</string>
    <string name="start_quiz">Comenzar Encuesta</string>


    <string name="edit_text_number_question_one">¿Cuántos bits hay en una dirección ipv4?</string>
    <string name="edit_text_number_answer_one">32</string>
    <string name="edit_text_number_question_two">¿Cuál es el equivalente decimal del número hexadecimal 0x3f? </string>
    <string name="edit_text_number_answer_two">63</string>
    <string name="edit_text_number_question_three">¿Cuántos bits tiene un byte?</string>
    <string name="edit_text_number_answer_three">8</string>
    <string name="edit_text_number_question_four">¿A cuántos bytes equivale 16 bits?</string>
    <string name="edit_text_number_answer_four">2</string>
    <string name="edit_text_number_question_five">¿Cuántos bits hay en una dirección ipv6?</string>
    <string name="edit_text_number_answer_five">128</string>
    <string name="edit_text_number_question_six">¿Cuántos octetos tiene una dirección ipv4?</string>
    <string name="edit_text_number_answer_six">4</string>

    <string name="edit_text_text_question">¿Cómo se llama el dispositivo que se muestra en pantalla?</string>
    <string name="edit_text_text_answer_one">conmutador</string>
    <string name="edit_text_text_answer_two">firewall</string>
    <string name="edit_text_text_answer_three">hub</string>
    <string name="edit_text_text_answer_four">portatil</string>
    <string name="edit_text_text_answer_five">router</string>
    <string name="edit_text_text_answer_six">servidor</string>

    <string name="check_box_question_one">Comando para ver la configuracion ip en una computadora windows</string>
    <string name="check_box_question_two">3 características de los switches en la capa de acceso:</string>
    <string name="check_box_question_three">La información de la vlan de rango extendido se almacena en el archivo:</string>
    <string name="check_box_question_four">seleccione las caracteristicas básicas para configurar spanning-tree</string>
    <string name="check_box_question_five">¿Cuál de las siguientes interfaces es la SVI predeterminada en un switch cisco?</string>

    <string name="check_box_false">false</string>
    <string name="check_box_true">true</string>

    <string name="check_box_answer_one_two">ip info</string>
    <string name="check_box_answer_one_four">show running config</string>
    <string name="check_box_answer_one_five">ip config</string>
    <string name="check_box_answer_one_eight">VLAN one</string>
    <string name="check_box_answer_two_zero">VLAN 99</string>
    <string name="check_box_answer_two_one">enlace troncal</string>
    <string name="check_box_answer_two_two">VLAN 0</string>
    <string name="check_box_answer_two_three">VLAN 1</string>
    <string name="check_box_answer_two_six">Ethernetchannel</string>
    <string name="check_box_answer_three_zero">Velocidad de reenvío</string>
    <string name="check_box_answer_three_one">Alimentación por ethernet</string>
    <string name="check_box_answer_three_two">Densidad de puertos</string>
    <string name="check_box_answer_four_zero">sumary</string>
    <string name="check_box_answer_four_one">contraseña</string>
    <string name="check_box_answer_four_two">dominio</string>
    <string name="check_box_answer_four_three">modo</string>
    <string name="check_box_answer_four_four">running config</string>
    <string name="check_box_answer_four_five">info VLAN</string>
    <string name="check_box_answer_five_zero">ip brief</string>


    <string name="radio_button_question_one">Tipo De Vlan Se Identifica Mediante Una Id De Vlan Entre 1006 Y 4094</string>
    <string name="radio_button_question_two">Protocolo de routing sin Clase que admite VLSM Y Cidr</string>
    <string name="radio_button_question_three">Protocolo diseñado por la organización internacional de normalización (ISO)?</string>
    <string name="radio_button_question_four">¿Cuál es la extensión de los programas de cisco?</string>
    <string name="radio_button_question_five">¿Con etherchannel, qué tipo de conexión lógica usan las interfaces de múltiples links físicos?</string>

    <string name="radio_button_false">false</string>
    <string name="radio_button_true">true</string>

    <string name="radio_button_answer_one_one">transparente</string>
    <string name="radio_button_answer_one_two">nativa</string>
    <string name="radio_button_answer_one_three">eliminada</string>
    <string name="radio_button_answer_one_four">Troncal</string>
    <string name="radio_button_answer_one_five">extendida</string>
    <string name="radio_button_answer_two_one">RIPv2</string>
    <string name="radio_button_answer_two_two">EIGRP</string>
    <string name="radio_button_answer_two_three">OSPF</string>
    <string name="radio_button_answer_two_four">RIPv1</string>
    <string name="radio_button_answer_two_five">BGP</string>
    <string name="radio_button_answer_three_one">Sistema intermedio a sistema intermedio (IS-IS)</string>
    <string name="radio_button_answer_three_two">RIP</string>
    <string name="radio_button_answer_three_three">EIGRP</string>
    <string name="radio_button_answer_three_four">RIPv2</string>
    <string name="radio_button_answer_three_five">OSPF</string>
    <string name="radio_button_answer_four_one">.net</string>
    <string name="radio_button_answer_four_two">.cad</string>
    <string name="radio_button_answer_four_three">.apk</string>
    <string name="radio_button_answer_four_four">.pkt</string>
    <string name="radio_button_answer_four_five">.cis</string>
    <string name="radio_button_answer_five_one">interface range</string>
    <string name="radio_button_answer_five_two">interfaz VLAN</string>
    <string name="radio_button_answer_five_three">Canal de puertos</string>
    <string name="radio_button_answer_five_four">Loopback</string>
    <string name="radio_button_answer_five_five">deseable</string>

    <string name="player_name">Encuestado</string>
    <string name="submit_answer">Enviar Respuesta</string>
    <string name="quiz_level">"Pregunta: Numero "</string>
    <string name="restart">Enviar respuestas al correo</string>
    <string name="submit_next_button2">Enciar Correo</string>
    <string name="next_quiz">Siguiente Pregunta</string>
    <string name="summary">Finalizar</string>
    <string name="score_text">"Correctas : "</string>

    <string name="quiz_three_hint">Marque uno o más respuestas</string>
    <string name="quiz_four_hint">Marque solo una respuesta</string>
    <string name="end_thank_first">"El cuestionario ha finalizado: "</string>
    <string name="end_thank_second">"\nRespuestas correctas : "</string>
    <string name="end_thank_third">" \nRevisa Las Respuestas."</string>
    <string name="wrong_answer">"Error, la Respuesta Correcta es: "</string>
    <string name="wright_answer">"Tu respuesta es correcta.</string>
    <string name="score">Correctas: </string>

    <string name="score_value">Correctas: </string>
    <string name="player_name_istate">Nombre Del Encuestado</string>
    <string name="score_istate">Puntaje</string>
    <string name="quiz_level_istate">quizLevel</string>
    <string name="quiz_rule_istate">quizRule</string>
    <string name="submit_next_button_istate">submitNextButton</string>
    <string name="quiz_one_question_istate">quizOneQuestion</string>
    <string name="quiz_one_answer_istate">quizOneAnswer</string>
    <string name="actual_view_istate">actualView</string>
    <string name="edit_text_number_random_istate">editTextNumberRandom</string>
    <string name="edit_text_text_random_istate">editTextTextRandom</string>
    <string name="check_box_random_istate">checkBoxRandom</string>
    <string name="radio_button_random_istate">radioButtonRandom</string>

</resources>

~~~
***


