package com.avondrix.score;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ScoreViewModel extends ViewModel {
    private static final String TAG = "ScoreViewModel";
    private MutableLiveData<Integer> scoreA;
    private MutableLiveData<Integer> scoreB;
    private ArrayDeque<Score> history = new ArrayDeque<>();


    public MutableLiveData<Integer> getScoreA() {
        if (scoreA == null) {
            scoreA = new MutableLiveData<>();
            scoreA.setValue(0);
            Log.d(TAG, "initScoreA: ");
        }
        return scoreA;
    }

    public MutableLiveData<Integer> getScoreB() {
        if (scoreB == null) {
            scoreB = new MutableLiveData<>();
            scoreB.setValue(0);
            Log.d(TAG, "initScoreB: ");
        }
        return scoreB;
    }

    public void record(View view) {
        history.push(new Score(scoreA.getValue(), scoreB.getValue()));
//        Button btn = (Button) view;
        switch (view.getId()) {
            case R.id.btn_a_1:
                scoreA.setValue(scoreA.getValue() + 1);
                Log.d(TAG, "record: a + 1");
                break;
            case R.id.btn_a_2:
                scoreA.setValue(scoreA.getValue() + 2);
                Log.d(TAG, "record: a + 2");
                break;
            case R.id.btn_a_3:
                scoreA.setValue(scoreA.getValue() + 3);
                Log.d(TAG, "record: a + 3");
                break;
            case R.id.btn_b_1:
                scoreB.setValue(scoreB.getValue() + 1);
                Log.d(TAG, "record: b + 1");
                break;
            case R.id.btn_b_2:
                scoreB.setValue(scoreB.getValue() + 2);
                Log.d(TAG, "record: b + 2");
                break;
            case R.id.btn_b_3:
                scoreB.setValue(scoreB.getValue() + 3);
                Log.d(TAG, "record: b + 3");
                break;
        }
        System.out.println(history.size() + Arrays.toString(history.toArray()));
    }

    public void undo() {
        try {
            Score pop = history.pop();
            scoreA.setValue(pop.getA());
            scoreB.setValue(pop.getB());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newGame() {
        scoreA.setValue(0);
        scoreB.setValue(0);
        history.clear();
    }
}
