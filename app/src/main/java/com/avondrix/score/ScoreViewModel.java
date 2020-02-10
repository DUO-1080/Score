package com.avondrix.score;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ScoreViewModel extends ViewModel {
    private static final String TAG = "ScoreViewModel";
    public static final String SCORE_A = "score a";
    public static final String SCORE_B = "score b";
    //    private MutableLiveData<Integer> scoreA;
//    private MutableLiveData<Integer> scoreB;
    private ArrayDeque<Score> history = new ArrayDeque<>();
    private SavedStateHandle handle;

    public ScoreViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getScoreA() {
//        if (scoreA == null) {
//            scoreA = new MutableLiveData<>();
//            scoreA.setValue(0);
//            Log.d(TAG, "initScoreA: ");
//        }
//        return scoreA;
        if (!handle.contains(SCORE_A)) {
            handle.set(SCORE_A, 0);
        }
        return handle.getLiveData(SCORE_A);
    }

    public MutableLiveData<Integer> getScoreB() {
//        if (scoreB == null) {
//            scoreB = new MutableLiveData<>();
//            scoreB.setValue(0);
//            Log.d(TAG, "initScoreB: ");
//        }
//        return scoreB;
        if (!handle.contains(SCORE_B)) {
            handle.set(SCORE_B, 0);
        }
        return handle.getLiveData(SCORE_B);
    }

    public void record(View view) {
        history.push(new Score(getScoreA().getValue(), getScoreB().getValue()));
//        Button btn = (Button) view;
        switch (view.getId()) {
            case R.id.btn_a_1:
                getScoreA().setValue(getScoreA().getValue() + 1);
                Log.d(TAG, "record: a + 1");
                break;
            case R.id.btn_a_2:
                getScoreA().setValue(getScoreA().getValue() + 2);
                Log.d(TAG, "record: a + 2");
                break;
            case R.id.btn_a_3:
                getScoreA().setValue(getScoreA().getValue() + 3);
                Log.d(TAG, "record: a + 3");
                break;
            case R.id.btn_b_1:
                getScoreB().setValue(getScoreB().getValue() + 1);
                Log.d(TAG, "record: b + 1");
                break;
            case R.id.btn_b_2:
                getScoreB().setValue(getScoreB().getValue() + 2);
                Log.d(TAG, "record: b + 2");
                break;
            case R.id.btn_b_3:
                getScoreB().setValue(getScoreB().getValue() + 3);
                Log.d(TAG, "record: b + 3");
                break;
        }
        System.out.println(history.size() + Arrays.toString(history.toArray()));
    }

    public void undo() {
        try {
            Score pop = history.pop();
            getScoreA().setValue(pop.getA());
            getScoreB().setValue(pop.getB());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newGame() {
        getScoreA().setValue(0);
        getScoreB().setValue(0);
        history.clear();
    }
}
