package pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;


public class PingPongController {
//    Group root = new Group();

    Text text = new Text("simple textik");

    Timeline timeline;
    final int PADDLE_MOVEMENT_INCREMENT = 6;
    final int BALL_MOVEMENT_INCREMENT = 5;
    double centerTableY;

    DoubleProperty currentKidPaddleY = new SimpleDoubleProperty();
    DoubleProperty currentCompPaddleY = new SimpleDoubleProperty();
    double initialCompPaddle;
    double initialKidPaddle;

    DoubleProperty ballCenterX = new SimpleDoubleProperty();
    DoubleProperty ballCenterY = new SimpleDoubleProperty();

    StringProperty textFieldText = new SimpleStringProperty();

    double allowedPaddleTopY;
    double allowedPaddleBottomY;

    int kidScore = 0;
    int compScore = 0;

    @FXML Rectangle table;
    @FXML Rectangle kidPaddle;
    @FXML Rectangle computerPaddle;
    @FXML Circle ball;
    @FXML TextField textField;


    public void initialize(){
        initialKidPaddle = kidPaddle.getLayoutY();
        currentKidPaddleY.set(kidPaddle.getLayoutY());
        kidPaddle.layoutYProperty().bind(currentKidPaddleY);

        initialCompPaddle = computerPaddle.getLayoutY();
        currentCompPaddleY.set(computerPaddle.getLayoutY());
        computerPaddle.layoutYProperty().bind(currentCompPaddleY);

//        textFieldText.set(textField.getText());
//        textField.textProperty().bindBidirectional(textFieldText.getValue());

        ballCenterX.set(ball.getCenterX());
        ball.centerXProperty().bind(ballCenterX);
        ballCenterY.set(ball.getCenterY());
        ball.centerYProperty().bind(ballCenterY);

        allowedPaddleTopY = PADDLE_MOVEMENT_INCREMENT;
        allowedPaddleBottomY = table.getHeight() - kidPaddle.getHeight() - PADDLE_MOVEMENT_INCREMENT;

        centerTableY = table.getHeight()/2;

//        textField.textProperty().setValue("Kid: " + kidScore);

    }

    public void keyReleasedHandler(KeyEvent event){

        KeyCode keyCode = event.getCode();

        switch (keyCode){
            case UP:
                process_key_up();
                break;
            case DOWN:
                process_key_down();
                break;
            case N:
                process_key_n();
                break;
            case Q:
                Platform.exit();
                break;
            case S:
                process_key_s();
                break;
        }
    }
    private void process_key_down() {
        if (currentKidPaddleY.get() < allowedPaddleBottomY){
            currentKidPaddleY.set(currentKidPaddleY.get() + PADDLE_MOVEMENT_INCREMENT);
        }
    }

    private void process_key_up() {
        if (currentKidPaddleY.get() > allowedPaddleTopY){
            currentKidPaddleY.set(currentKidPaddleY.get() - PADDLE_MOVEMENT_INCREMENT);
        }
    }
    private void process_key_n() {
        newGame();

        textField.setText("jkaq");
        System.out.println(textField.getText());
    }

    private void process_key_s() {
        ballCenterX.set(kidPaddle.getLayoutX() - ball.getRadius());
        ballCenterY.set(currentKidPaddleY.get() + kidPaddle.getHeight()/2);
        currentCompPaddleY.set(initialCompPaddle);

        moveTheBall();
    }

    private void moveTheBall(){

        Random random = new Random();
        double nextIncrement = random.nextInt(BALL_MOVEMENT_INCREMENT);

        final boolean isServingFromTop = (ballCenterY.get() <= centerTableY)?true:false;

        KeyFrame keyFrame = new KeyFrame(new Duration(20),
                event -> {

                    if (ballCenterX.get() > -20) {
                        ballCenterX.set(ballCenterX.get() - BALL_MOVEMENT_INCREMENT);

                        if (isServingFromTop) {
                            ballCenterY.set(ballCenterY.get() + nextIncrement);
                            currentCompPaddleY.set(currentCompPaddleY.get() + 1);

                        } else  {
                            ballCenterY.set(ballCenterY.get() - nextIncrement);
                            currentCompPaddleY.set(currentCompPaddleY.get() - 1);
                        }
                        if(checkForBallPaddleContact(computerPaddle)){
                            timeline.stop();
                            currentCompPaddleY.set(initialCompPaddle);
                            bounceTheBall();
                        };
                    } else {
                        timeline.stop();
                        updateScore();

                        currentCompPaddleY.set(initialCompPaddle);
                    }
                });

        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void bounceTheBall() {

        double theBallOffTheTableX = table.getWidth() + 20;

        KeyFrame keyFrame = new KeyFrame(new Duration(70),
                event -> {
                    if (ballCenterX.get() < theBallOffTheTableX) {
                        ballCenterX.set(ballCenterX.get() + BALL_MOVEMENT_INCREMENT);

                        if (checkForBallPaddleContact(kidPaddle)){
                            timeline.stop();
                            moveTheBall();
                        };
                    } else {
                        timeline.stop();
                        updateScore();
                    }
                });

        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    private boolean checkForBallPaddleContact(Rectangle paddle){
        if (ball.intersects(paddle.getBoundsInParent())){
            return true;
        } else{
            return false;
        }
    }

    private void updateScore(){
        //ball goes off the left border -- kid +1
        if (ballCenterX.get() < 0){
            kidScore += 1;
        }
        //ball goes off the right border -- comp +1
        else if (ballCenterX.get() > table.getWidth()){
            compScore += 1;
        }
        //ball goes off the top or bottom border -- comp +1
        else if (ballCenterY.get() < 0 || ballCenterY.get() > table.getHeight()){
            compScore += 1;
        }
        textField.appendText("Kid: ");

        System.out.println("Kid score: " + kidScore);
        System.out.println("Computer score: " + compScore);
    }

    private void newGame() {
        currentCompPaddleY.set(initialCompPaddle);
        currentKidPaddleY.set(initialKidPaddle);
        ballCenterX.set(kidPaddle.getLayoutX() - ball.getRadius());
        ballCenterY.set(currentKidPaddleY.get() + kidPaddle.getHeight()/2);
        kidScore = 0;
        compScore = 0;

    }





























    private void bounceTheBallUp(){
        Random random = new Random();

        int nextIncrement = random.nextInt(BALL_MOVEMENT_INCREMENT);

        KeyFrame keyFrame = new KeyFrame(new Duration(20),
                event -> {
                    if (ballCenterX.get() > -20) {
                        ballCenterX.set(ballCenterX.get() - BALL_MOVEMENT_INCREMENT);
                        ballCenterY.set(ballCenterY.get() - nextIncrement);

                    } else {
                        timeline.stop();
                    }
                });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private void bounceTheBallDown(){
        Random random = new Random();

        int nextIncrement = random.nextInt(BALL_MOVEMENT_INCREMENT);

        KeyFrame keyFrame = new KeyFrame(new Duration(40),
                event -> {
                    if (ballCenterX.get() > -20) {
                        ballCenterX.set(ballCenterX.get() - BALL_MOVEMENT_INCREMENT);
                        ballCenterY.set(ballCenterY.get() + nextIncrement);

                    } else {
                        timeline.stop();
                    }
                });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



}
