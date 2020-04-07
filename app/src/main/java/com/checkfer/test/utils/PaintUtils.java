package com.checkfer.test.utils;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;

public class PaintUtils {

    /**
     * +
     * Set the background of the text to a gradient.
     *
     * @param colors The array of colors you want it to be, from LEFT to RIGHT
     * @param textView TH
     */
    public static void setBackgroundForTextInTextView(int[] colors, TextView textView) {
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                colors, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
    }

    /**
     * In future I would make this return ValueAnimator since we can then cancel the animation
     * @param view The view you want to animate
     * @param startColor The start color of the animation (left hand side)
     * @param endColor The end color of the animation (Right hand side)
     * @param duration How long the animation should last before it repeats
     *
     */
    public static void animateGradientView(final View view, int startColor, int endColor, int duration) {

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        final GradientDrawable gradient = (GradientDrawable) view.getBackground();

        ValueAnimator animator = TimeAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(duration);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(valueAnimator -> {
            float fraction = valueAnimator.getAnimatedFraction();
            int newStart = (int) evaluator.evaluate(fraction, startColor, endColor);
            int newEnd = (int) evaluator.evaluate(fraction, endColor, startColor);
            int[] newArray = {newStart, newEnd};
            gradient.setColors(newArray);
        });
        animator.start();

    }
}
